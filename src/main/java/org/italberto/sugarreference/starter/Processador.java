/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.italberto.sugarreference.starter;

import br.italberto.forbetico.persistence.domain.Autor;
import br.italberto.forbetico.persistence.domain.Engine;
import br.italberto.forbetico.persistence.domain.Estudo;
import br.italberto.forbetico.persistence.domain.Keyword;
import br.italberto.forbetico.persistence.domain.Pais;
import br.italberto.forbetico.persistence.facade.FacadeAutor;
import br.italberto.forbetico.persistence.facade.FacadeEngine;
import br.italberto.forbetico.persistence.facade.FacadeEstudo;
import br.italberto.forbetico.persistence.facade.FacadeKeyword;
import br.italberto.forbetico.persistence.facade.FacadePais;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import org.italberto.sugarreference.data.AbstractConversor;
import org.italberto.sugarreference.data.ArticleConversor;
import org.italberto.sugarreference.data.ArticleEngine;
import org.italberto.sugarreference.data.RisArticleEngine;
import org.italberto.sugarreference.datafeed.DBRisFeeder;
import org.italberto.sugarreference.datafeed.Feeder;
import org.italberto.sugarreference.datafeed.RisFileFeeder;
import org.italberto.sugarreference.domain.Article;

/**
 *
 * @author italberto
 */
public class Processador {

    public static Integer count = 0;

    public static void Processar(String filePath, Engine engine) throws IOException, TransformerConfigurationException, TransformerException {

        List<String> listFiles = new ArrayList<>();

        listFiles.add(filePath);

        List<Article> artigos = getArticles(listFiles);

        importaEstudos(engine, artigos);

        //f.closeSession();
    }

    public static void importaEstudos(Engine engine, List<Article> artigos) {

        for (Article article : artigos) {

            article.setDatabaseName(engine.getNome());

            Estudo tmp = new Estudo();

            tmp.setTitulo(article.getTitle());

            FacadeEngine facadeEngine = new FacadeEngine();

            tmp.setAbstractText(article.getTextAbstract());

            tmp.setAnoPublicacao(getData(article.getDate()));

            tmp.setDoi(article.getDoi());

            tmp.setIsbn(article.getIsbn());

            FacadeEstudo fe = new FacadeEstudo();
            FacadeAutor fa = new FacadeAutor();

            fe.create(tmp);

            Long paisId = getPais(article.getCountry());

            for (Autor autor : montaNomeAutor(article.getAuthorsList())) {
                autor.setEstudo(tmp);
                fa.create(autor);
            }

            FacadeKeyword fk = new FacadeKeyword();

            for (Keyword keyword : montaKeywords(article.getKeywords())) {
                keyword.setEstudo(tmp);
                fk.create(keyword);
            }

            FacadePais fp = new FacadePais();
            if (paisId != null) {

                Pais p = fp.findById(paisId);
                tmp.setPaisEstudo(p);
                fe.save(tmp);
            }

            System.out.println(">>>>>>> " + engine.getId());

            Engine engineTmp = facadeEngine.findById(engine.getId());

            tmp.setEngine(engineTmp);

            fe.save(tmp);

            facadeEngine.closeSession();
            fa.closeSession();
            fk.closeSession();
            fp.closeSession();
            fe.closeSession();

        }

    }

    public static List<Long> salvaAutores(List<Autor> autores) {
        List<Long> retorno = new ArrayList<>();
        FacadeAutor fa = new FacadeAutor();

        for (Autor autor : autores) {
            List<Autor> result = fa.findByName(autor.getPrimeiroNome(), autor.getUltimoNome());

            if (!result.isEmpty()) {
                retorno.add(result.get((0)).getId());
            } else {
                fa.create(autor);
                retorno.add(autor.getId());
            }
        }

        fa.closeSession();

        return retorno;
    }

    public static String getSystemUserFolder() {
        return System.getProperty("user.home");
    }

    public static Integer getData(String dataTexto) {
        Integer ano = 0;
        if (!dataTexto.isEmpty()) {
            ano = new Integer(dataTexto);
        }
        return ano;
    }

    public static Long getPais(String nome) {
        FacadePais fp = new FacadePais();
        Pais pais = null;

        List<Pais> p = fp.findByName(nome);

        if (p != null && p.size() > 0) {
            if (!nome.isEmpty()) {
                pais = p.get(0);
            }
        } else {
            pais = new Pais(nome);
            fp.create(pais);
        }

        if (pais != null) {
            return pais.getId();
        }

        fp.closeSession();

        return null;
    }

    public static Engine getEngine(String engineName) {
        FacadeEngine fe = new FacadeEngine();
        Engine retorno = null;

        List<Engine> e = fe.findByName(engineName);

        if (e != null && e.size() > 0) {
            retorno = e.get(0);
        } else {
            retorno = new Engine(engineName);
            fe.create(retorno);
        }

        fe.closeSession();

        return retorno;
    }

    public static List<Keyword> montaKeywords(List<String> keywords) {
        List<Keyword> retorno = new ArrayList<>();
        //FacadeKeyword fk = new FacadeKeyword();

        for (String k : keywords) {
            Keyword ktmp = new Keyword(k);

            //fk.create(ktmp);
            retorno.add(ktmp);
        }

        //fk.closeSession();
        return retorno;
    }

    public static List<Autor> montaNomeAutor(List<String> autores) {
        List<Autor> retorno = new ArrayList<>();

        for (int i = 0; i < autores.size(); i++) {

            String autor = autores.get(i);

            String primeiroNome = "";
            String ultimoNome = "";
            Boolean autorPrincipal = false;

            if (i == 0) {
                autorPrincipal = true;
            }

            String[] nomes = autor.split(",");
            List<String> partesNome = Arrays.asList(nomes);

            if (partesNome.size() > 1) {
                primeiroNome = partesNome.get(1);
                ultimoNome = partesNome.get(0);
            } else if (partesNome.size() == 1) {
                primeiroNome = partesNome.get(0);
            }

            retorno.add(new Autor(primeiroNome, ultimoNome, autorPrincipal));

        }

        return retorno;
    }

    public static List<Article> getArticles(List<String> files) {
        Feeder feed = null;
        ArticleEngine engine = null;

        List<Article> retorno = new ArrayList<>();

        engine = new RisArticleEngine();

        for (String path : files) {

            feed = new RisFileFeeder(path);

            AbstractConversor conversor = new ArticleConversor(feed, engine);

            List<Article> tmp = conversor.getResult();

            retorno.addAll(tmp);
        }
        return retorno;
    }

}
