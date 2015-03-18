/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.italberto.forbetico.view;

import br.italberto.forbetico.persistence.facade.Facade;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author italberto
 */
public abstract class BeanPadrao {

    private Facade facade;

    public void setMensagem(String titulo, String mensagem) {
        FacesMessage msg = new FacesMessage(titulo, mensagem);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}
