/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.italberto.forbetico.view;

import br.italberto.forbetico.persistence.domain.Estudo;
import br.italberto.forbetico.persistence.domain.Etapa;
import br.italberto.forbetico.persistence.domain.Revisao;
import br.italberto.forbetico.persistence.facade.FacadeEstudo;
import br.italberto.forbetico.persistence.facade.FacadeEtapa;
import br.italberto.forbetico.persistence.facade.FacadeRevisao;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

/**
 *
 * @author italberto
 */
@ManagedBean(name = "estudoExcluidoBean")
public class EstudoExcluidoBean {

    private FacadeEstudo facade;
    private FacadeRevisao fr;
    private List<Estudo> estudos;
    private Long criterioId;
    private Long revisaoId;

    private List<Revisao> revisoes;
    private Revisao revisao;
    private List<Etapa> etapas;

    FacadeEtapa facade_etapa = new FacadeEtapa();

    public EstudoExcluidoBean() {
        facade = new FacadeEstudo();
        //estudos = facade.findAll();
        fr = new FacadeRevisao();
        revisoes = fr.findAll();
        this.etapas = new ArrayList<>();
        fr.closeSession();
    }

    public List<Estudo> getEstudos() {
        return estudos;
    }

    public void setEstudos(List<Estudo> estudos) {
        this.estudos = estudos;
    }

    public String salvar() {
        return null;
    }

    public void escolherRevisao() {
        this.revisao = fr.findById(revisaoId);

        this.estudos = facade.findAllExcluidosByRevisao(revisaoId);

        this.etapas = facade_etapa.findAllByRevisao(revisaoId);

        facade.closeSession();
        fr.closeSession();
    }

    public Revisao getRevisao() {
        return revisao;
    }

    public void setRevisao(Revisao revisao) {
        this.revisao = revisao;
    }

    public FacadeEstudo getFacade() {
        return facade;
    }

    public void setFacade(FacadeEstudo facade) {
        this.facade = facade;
    }

    public Long getCriterioId() {
        return criterioId;
    }

    public void setCriterioId(Long criterioId) {
        this.criterioId = criterioId;
    }

    public Long getRevisaoId() {
        return revisaoId;
    }

    public void setRevisaoId(Long revisaoId) {
        this.revisaoId = revisaoId;
    }

    public List<Revisao> getRevisoes() {
        return revisoes;
    }

    public void setRevisoes(List<Revisao> revisoes) {
        this.revisoes = revisoes;
    }

    public List<Etapa> getEtapas() {
        return etapas;
    }

    public void setEtapas(List<Etapa> etapas) {
        this.etapas = etapas;
    }

    public void onEdit(RowEditEvent event) {

        Estudo estudo = (Estudo) event.getObject();

        System.out.println(estudo.getId());

        FacadeEstudo f = new FacadeEstudo();

        f.save(estudo);

        f.closeSession();
        FacesMessage msg = new FacesMessage("Estudo editado", estudo.getId() + "");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}
