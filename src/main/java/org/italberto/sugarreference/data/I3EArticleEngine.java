/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.italberto.sugarreference.data;

import java.util.ArrayList;
import java.util.List;
import org.italberto.sugarreference.datafeed.Feeder;
import org.italberto.sugarreference.domain.Article;
import org.italberto.sugarreference.formats.parser.AbstractParser;
import org.italberto.sugarreference.formats.parser.ArticleParser;
import org.italberto.sugarreference.formats.ris.RisArticleFormat;

/**
 *
 * @author italberto
 */
public class I3EArticleEngine extends ArticleEngine{

    @Override
    public List<Article> transform(Feeder feeder) {
        List<Article> records = (List<Article>) feeder.getData();
        
        return records;
    }
    
    
//    @Override
//    public List<Article> transform(Feeder feeder) {
//        List<Article> records = (List<Article>) feeder.getData();
//        
//        return records;
//    }
}
