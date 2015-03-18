/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.italberto.sugarreference.datafeed;

import java.util.List;
import org.italberto.sugarreference.domain.Article;

/**
 *
 * @author italberto
 * 
 * Interface que representa um fornecedor de dados.
 */
public interface Feeder<Type> {
    
    public List<Type> getData();
    
}
