/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.italberto.sugarreference.printer.fileformat;

/**
 *
 * @author italberto
 */
public abstract class DelimitedFileFormat {

    private String delimiter;

    public DelimitedFileFormat(String delimiter) {
        this.delimiter = delimiter;
    }

    public String getDelimiter() {
        return delimiter;
    }

    public void setDelimiter(String delimiter) {
        this.delimiter = delimiter;
    }

}
