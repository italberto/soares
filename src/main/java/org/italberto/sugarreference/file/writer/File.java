/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.italberto.sugarreference.file.writer;

import java.io.FileReader;
import java.util.Scanner;

/**
 *
 * @author italberto
 */
public abstract class File {

    protected String caminhoArquivo;

    /**
     * Recebe como parâmetro o local no qual o arquivo se encontra. Como não
     * recebe o delimitador, é assumido que o delimitador é um espaço em branco;
     *
     * @param caminhoArquivo
     */
    public File(String caminhoArquivo) {

        this.caminhoArquivo = caminhoArquivo;
    }

    public String getCaminhoArquivo() {
        return caminhoArquivo;
    }

    public void setCaminhoArquivo(String caminhoArquivo) {
        this.caminhoArquivo = caminhoArquivo;
    }

    public abstract Scanner openFileToRead();

    public abstract void writeFile(String s);

}
