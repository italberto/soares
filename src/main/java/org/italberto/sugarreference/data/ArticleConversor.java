/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.italberto.sugarreference.data;

import java.util.List;
import org.italberto.sugarreference.datafeed.Feeder;
import org.italberto.sugarreference.domain.Article;
import org.italberto.sugarreference.xml.Transformator;

/**
 *
 * @author italberto
 */
public class ArticleConversor extends AbstractConversor<Article>{

    public ArticleConversor(Feeder feeder, ArticleEngine eng) {
        super(feeder,eng);
    }

    @Override
    public List<Article> getResult() {
        return (List<Article>) engine.transform(feeder);
    }
    
    
            
}
