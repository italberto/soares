/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.italberto.sugarreference.formats.parser;

import org.italberto.sugarreference.domain.Article;

/**
 *
 * @author italberto
 */
public abstract class AbstractParser<Type> {
    
    public abstract Type parse();
    
    
}
