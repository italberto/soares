/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.italberto.sugarreference.data;

import java.util.List;
import org.italberto.sugarreference.datafeed.Feeder;
import org.italberto.sugarreference.domain.Article;

/**
 *
 * @author italberto
 */
public abstract class AbstractConversor<Type> {
    
    protected Feeder feeder;
    protected ArticleEngine engine;
    
    public AbstractConversor(Feeder feeder, ArticleEngine engine){
        this.feeder = feeder;
        this.engine = engine;
                
    }
    
    public abstract List<Type> getResult();
}
