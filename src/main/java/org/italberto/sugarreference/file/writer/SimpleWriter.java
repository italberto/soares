/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.italberto.sugarreference.file.writer;

import java.util.List;

/**
 *
 * @author italberto
 */
public class SimpleWriter implements Writer {

    @Override
    public void putElements(List<Elemento> elementos, File file) {
        StringBuilder saida = new StringBuilder();

        for (Elemento elemento : elementos) {
            saida.append(elemento);
        }

        file.writeFile(saida.toString());
    }

}
