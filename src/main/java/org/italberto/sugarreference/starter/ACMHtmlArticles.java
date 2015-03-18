/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.italberto.sugarreference.starter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.italberto.sugarreference.domain.Article;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.italberto.sugarreference.net.Vacum;

/**
 *
 * @author italberto
 */
public class ACMHtmlArticles extends HtmlArticle {

    public ACMHtmlArticles(List<String> links) throws IOException {
        super(links);
        super.setArticles(new ArrayList<Article>());
        this.setElementosArtigos((List<Element>)(Object)this.getHtmBody(links));

        for (Element element : this.getElementosArtigos()) {

            this.element = element;

            
            this.getArticles().add(new Article(this.getTitle(),
                    this.getAuthors().get(0),
                    this.getDate(),
                    this.getAbstract(),
                    this.getKeywords(),
                    this.getFullTextLink(),
                    this.getFullTextLink())
            );

        }

    }

    protected List<String> getAuthors() {
        List<String> retorno = new ArrayList<String>();

        List<Element> elementos = super.element.getElementsByAttributeValue("class", "authors");

        if (!elementos.isEmpty()) {
            String autoresStr = elementos.get(0).html();

            if (!autoresStr.contains(",")) {
                retorno.add(Jsoup.parse(autoresStr).text());
            } else {
                retorno.add(Jsoup.parse(autoresStr).text());
//                String[] autores = autoresStr.split(",");
//
//                for (String a : autores) {
//                    retorno.add(Jsoup.parse(a).text());
//                }
            }

        }

        return retorno;
    }

    protected String getTitle() {
        String retorno = "";

        List<Element> elementos = super.element.getElementsByTag("a");

        if (!elementos.isEmpty()) {
            String valorElemento = Jsoup.parse(elementos.get(0).html()).text();

            retorno = valorElemento;
        }

        return retorno;
    }

    protected String getDate() {
        String retorno = "";

        List<Element> elementos = super.element.select("td.small-text");

        if (!elementos.isEmpty()) {
            retorno = elementos.get(0).html();
        }

        return retorno;
    }

    protected String getPublication() {
        String retorno = "";

        List<Element> elementos = super.element.select("div.addinfo");

        if (!elementos.isEmpty()) {
            retorno = Jsoup.parse(elementos.get(0).html()).text();
        }

        return retorno;
    }

    protected String getAbstract() {
        String retorno = "";

        List<Element> elementos = super.element.select("div.abstract2");

        if (!elementos.isEmpty()) {
            retorno = Jsoup.parse(elementos.get(0).html()).text();
        }

        return retorno.replaceAll("Keywords.+", "");
    }

    protected List<String> getKeywords() {
        List<String> retorno = new ArrayList<String>();

        List<Element> elementos = super.element.select("div.abstract2");

        String tmp = "";

        String ktmp = "";

        if (!elementos.isEmpty()) {
            tmp = Jsoup.parse(elementos.get(0).html()).text();

            if (!tmp.isEmpty()) {
                Pattern p = Pattern.compile("Keywords:.+");

                Matcher m = p.matcher(tmp);

                while (m.find()) {
                    ktmp = m.group();
                }
            }
        }

        if (!ktmp.isEmpty()) {
            String[] ks = ktmp.split(",");

            for (String k : ks) {
                retorno.add(k.replaceAll("Keywords:", ""));
            }
        }

        return retorno;
    }

    protected String getFullTextLink() {
        String retorno = "";

        List<Element> elementos = super.element.getElementsByTag("a");

        Element lnk = null;

        for (Element ex : elementos) {
            if (ex.attr("title").equals("PDF")) {
                lnk = ex;
            }
        }

        if (lnk != null) {
            retorno = lnk.attr("href");
        }

        return retorno;
    }

    protected String getCitationLink() {
        String retorno = "";

        List<Element> elementos = super.element.getElementsByTag("a");

        if (!elementos.isEmpty()) {
            String valorElemento = elementos.get(0).attr("href");

            retorno = valorElemento;
        }

        return retorno;
    }

    protected List<Object> getHtmBody(List<String> links) throws IOException {

        List<Object> retorno = new ArrayList<Object>();

        for (String link : links) {

            Document doc = Jsoup.parse(Vacum.getCode(link));

            Elements trs = doc.getElementsByAttributeValue("style", "padding: 5px; 5px; 5px; 5px;");

            for (Element element : trs) {

                retorno.add(element);

            }
        }

        return retorno;
    }

}
