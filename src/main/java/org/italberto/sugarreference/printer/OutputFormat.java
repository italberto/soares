/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.italberto.sugarreference.printer;

import org.italberto.sugarreference.domain.Article;

/**
 *
 * @author italberto
 */
public interface OutputFormat {

    public String getContent(Article art);
}
