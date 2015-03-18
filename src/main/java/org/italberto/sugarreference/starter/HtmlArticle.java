/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.italberto.sugarreference.starter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.italberto.sugarreference.domain.Article;
import org.jsoup.nodes.Element;

/**
 *
 * @author italberto
 */
public abstract class HtmlArticle {

    private List<Article> articles;
    private List<Element> elementosArtigos;
    protected Element element;

    public HtmlArticle(List<String> links) throws IOException {

    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public List<Element> getElementosArtigos() {
        return elementosArtigos;
    }

    public void setElementosArtigos(List<Element> elementosArtigos) {
        this.elementosArtigos = elementosArtigos;
    }

    protected abstract List<String> getAuthors();

    protected abstract String getTitle();

    protected abstract String getDate();

    protected abstract String getPublication();

    protected abstract String getAbstract();

    protected abstract List<String> getKeywords();

    protected abstract String getFullTextLink();

    protected abstract String getCitationLink();

    protected abstract List<Object> getHtmBody(List<String> links) throws IOException;
}
