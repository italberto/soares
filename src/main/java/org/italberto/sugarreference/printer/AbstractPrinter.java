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
public abstract class AbstractPrinter {

    private OutputFormat outputFormat;

    public AbstractPrinter(OutputFormat outputFormat) {
        this.outputFormat = outputFormat;
    }

    public abstract String getResult(Article article);

    public OutputFormat getOutputFormat() {
        return outputFormat;
    }

    public void setOutputFormat(OutputFormat outputFormat) {
        this.outputFormat = outputFormat;
    }

}
