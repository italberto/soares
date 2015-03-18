/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.italberto.sugarreference.starter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import org.italberto.sugarreference.data.AbstractConversor;
import org.italberto.sugarreference.data.ArticleConversor;
import org.italberto.sugarreference.data.ArticleEngine;
import org.italberto.sugarreference.data.RisArticleEngine;
import org.italberto.sugarreference.datafeed.Feeder;
import org.italberto.sugarreference.datafeed.RisFileFeeder;
import org.italberto.sugarreference.domain.Article;
import org.italberto.sugarreference.file.writer.File;
import org.italberto.sugarreference.file.writer.NormalFile;
import org.italberto.sugarreference.printer.AbstractPrinter;
import org.italberto.sugarreference.printer.CSVOutputFormat;
import org.italberto.sugarreference.printer.Printer;

/**
 *
 * @author italberto
 */
public class FileStarter {
    public static void main(String args[]) throws IOException, TransformerConfigurationException, TransformerException {

        List<String> filesScienceDirect = new ArrayList<String>();
        filesScienceDirect.add(getSystemUserFolder() + "/Dropbox/Mestrado/Dissertação/protocol_test/teste_01/science_direct.ris");

        List<String> filesCompendex = new ArrayList<String>();
        filesCompendex.add(getSystemUserFolder() + "/Dropbox/Mestrado/Dissertação/protocol_test/teste_01/compendex.ris");

        List<Article> artigosScienceDirect = new ArrayList<Article>();
        List<Article> artigosCompendex = new ArrayList<Article>();

        artigosScienceDirect = getArticles(filesScienceDirect);
        artigosCompendex = getArticles(filesCompendex);

        System.out.println("Total de entradas encontradas: " + (artigosScienceDirect.size() + artigosCompendex.size()));

        AbstractPrinter printer;

        StringBuilder saidaScienceDirect = new StringBuilder();
        for (Article article : artigosScienceDirect) {

            article.setDatabaseName("ScienceDirect");

            printer = new Printer(new CSVOutputFormat());

            saidaScienceDirect.append(printer.getResult(article)).append("\n");
        }

        StringBuilder saidaCompendex = new StringBuilder();
        for (Article article : artigosCompendex) {

            article.setDatabaseName("Compendex");

            printer = new Printer(new CSVOutputFormat());

            saidaCompendex.append(printer.getResult(article)).append("\n");
        }

        File file = new NormalFile("/Users/italberto/Dropbox/Mestrado/exportacao_artigos.csv");

        file.writeFile(saidaScienceDirect.append(saidaCompendex).toString());

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
    
    public static String getSystemUserFolder() {
        return System.getProperty("user.home");
    }
}
