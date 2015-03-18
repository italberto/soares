/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.italberto.sugarreference.printer;

import org.italberto.sugarreference.printer.fileformat.CSVFileFormat;
import org.italberto.sugarreference.domain.Article;

/**
 *
 * @author italberto
 */
public class CSVOutputFormat extends CSVFileFormat implements OutputFormat {

    @Override
    public String getContent(Article art) {
        StringBuilder retorno = new StringBuilder();

        retorno.append(art.getTitle()).append(super.getDelimiter());
        retorno.append(art.getTextAbstract()).append(super.getDelimiter());
        retorno.append(art.getAuthors()).append(super.getDelimiter());
        retorno.append(art.getDate()).append(super.getDelimiter());
        retorno.append(art.getDatabaseName()).append(super.getDelimiter());
        retorno.append(art.getCountry()).append(super.getDelimiter());

        return retorno.toString();
    }

}
