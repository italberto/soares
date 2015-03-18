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
public interface Writer {

    public void putElements(List<Elemento> elementos, File file);
}
