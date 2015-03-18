/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.italberto.sugarreference.formats.parser;

import org.italberto.sugarreference.domain.Article;
import org.italberto.sugarreference.formats.ArticleAbstractFormat;

/**
 *
 * @author italberto
 */
public class ArticleParser extends AbstractParser<Article>{

    
    protected ArticleAbstractFormat format; 
    
    public ArticleParser(ArticleAbstractFormat format) {
        this.format = format;
    }
    
    @Override
    public Article parse() {
        Article retorno = new Article();
        
        retorno.setTitle(format.getTitle());
        retorno.setAuthors(format.getAuthors());
        retorno.setDate(format.getDate());
        retorno.setTextAbstract(format.getAbstract());
        retorno.setKeywords(format.getKeyWords());
        retorno.setUrlFullText(format.getUrl());
        retorno.setIsbn(format.getISBN());
        retorno.setDoi(format.getDOI());
        retorno.setCountry(format.getCountry());
        
        return retorno;
    }
    
    
}
