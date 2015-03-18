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
public class Printer extends AbstractPrinter {

    public Printer(OutputFormat outputFormat) {
        super(outputFormat);
    }

    @Override
    public String getResult(Article article) {
        return super.getOutputFormat().getContent(article);
    }

}
