/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.italberto.sugarreference.starter;

import br.italberto.forbetico.persistence.facade.FacadeAutor;

/**
 *
 * @author italberto
 */
public class CriarBanco {

    public static void main(String args[]) {
        FacadeAutor f = new FacadeAutor();

        f.findAll();
    }
}
