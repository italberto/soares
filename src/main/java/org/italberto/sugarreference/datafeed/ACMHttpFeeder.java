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
import org.italberto.sugarreference.starter.ACMHtmlArticles;
import org.italberto.sugarreference.starter.HtmlArticle;
import org.italberto.sugarreference.net.LinkVacum;

/**
 *
 * @author italberto
 *
 * Fornece dados obtidos atavés de uma conexão de rede.
 *
 */
public class ACMHttpFeeder implements Feeder<Article> {

    private DataSource dataSource;

    public ACMHttpFeeder(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Article> getData() {

        List<Article> retorno = null;

        LinkVacum lv = new LinkVacum();

        try {
            HtmlArticle ha = new ACMHtmlArticles(lv.getLinks(this.dataSource.getTrailer(), this.dataSource.getUrl()));
            retorno = ha.getArticles();

        } catch (IOException ex) {
            Logger.getLogger(ACMHttpFeeder.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (retorno.isEmpty()) {
            retorno = new ArrayList<Article>();
        }

        return retorno;
    }

}
