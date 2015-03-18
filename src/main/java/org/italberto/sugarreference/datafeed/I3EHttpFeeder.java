/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.italberto.sugarreference.datafeed;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.italberto.sugarreference.domain.Article;
import org.italberto.sugarreference.net.DataSource;
import org.italberto.sugarreference.starter.HtmlArticle;
import org.italberto.sugarreference.starter.I3EHtmlArticles;

/**
 *
 * @author italberto
 *
 * Fornece dados obtidos atavés de uma conexão de rede.
 *
 */
public class I3EHttpFeeder implements Feeder<Article> {

    private DataSource dataSource;

    public I3EHttpFeeder(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Article> getData() {

        List<Article> retorno = null;

        List<String> link = new ArrayList<String>();

        link.add(this.dataSource.getTrailer() + this.dataSource.getUrl());

        HtmlArticle ha = null;
        try {
            ha = new I3EHtmlArticles(link);
        } catch (IOException ex) {
            Logger.getLogger(I3EHttpFeeder.class.getName()).log(Level.SEVERE, null, ex);
        }
        retorno = ha.getArticles();

        if (retorno.isEmpty()) {
            retorno = new ArrayList<Article>();
        }

        return retorno;
    }

}
