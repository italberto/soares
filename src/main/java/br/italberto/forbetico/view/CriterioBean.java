/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.italberto.forbetico.view;

import br.italberto.forbetico.persistence.domain.Criterio;
import br.italberto.forbetico.persistence.domain.Estudo;
import br.italberto.forbetico.persistence.domain.Etapa;
import br.italberto.forbetico.persistence.facade.FacadeCriterio;
import br.italberto.forbetico.persistence.facade.FacadeEstudo;
import br.italberto.forbetico.persistence.facade.FacadeEtapa;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

/**
 *
 * @author italberto
 */
@ManagedBean(name = "criterioBean")
public class CriterioBean extends BeanPadrao {

    private List<Criterio> criterios;
    private Criterio criterio;
    private List<Etapa> etapas;
    private Etapa etapa;
    private Long etapaId;

    FacadeEtapa fe = new FacadeEtapa();
    FacadeCriterio fc = new FacadeCriterio();

    public CriterioBean() {

        criterio = new Criterio();
        etapa = new Etapa();
        etapas = fe.findAll();
        criterios = fc.findAll();
        
        if (etapas.size()<1){
            setMensagem("Aviso!", "É necessário primeiro cadastrar uma etapa para associá-la a um critério.");
        }
    }

    public Criterio getCriterio() {
        return criterio;
    }

    public void setCriterio(Criterio criterio) {
        this.criterio = criterio;
    }

    public void criarCriterio() {
        this.criterio = new Criterio();

        this.etapa = new Etapa();
        this.etapaId = null;
    }

    public void salvarCriterio() {

        Etapa tmp = fe.findById(this.etapaId);
        criterio.setEtapa(tmp);
        fc.save(this.criterio);

        this.criterios = fc.findAll();
        this.etapaId = null;
        this.criterio = new Criterio();
        fe.closeSession();
        fc.closeSession();

        setMensagem("Aviso!", "Critério salvo com sucesso.");
    }

    public void atualizarCriterio() {

        Etapa tmp = fe.findById(this.etapaId);
        criterio.setEtapa(tmp);
        fe.save(criterio.getEtapa());

        fc.save(criterio);

        fc.closeSession();
        fe.closeSession();

        setMensagem("Aviso!", "Critério atulizado com sucesso.");

    }

    public void excluirCriterio(Criterio criterio) {

        Criterio ctmp = fc.findById(criterio.getId());

        fc.delete(ctmp);

        this.criterios = fc.findAll();

        fc.closeSession();

        setMensagem("Aviso!", "Critério excluído com sucesso.");
    }

    public List<Criterio> getCriterios() {
        return criterios;
    }

    public void setCriterios(List<Criterio> criterios) {
        this.criterios = criterios;
    }

    public List<Etapa> getEtapas() {
        return etapas;
    }

    public void setEtapas(List<Etapa> etapas) {
        this.etapas = etapas;
    }

    public Etapa getEtapa() {
        return etapa;
    }

    public void setEtapa(Etapa etapa) {
        this.etapa = etapa;
    }

    public boolean getPrepared() {
        if (this.etapas.size() > 0) {
            return true;
        }
        return false;
    }

    public Long getEtapaId() {
        return etapaId;
    }

    public void setEtapaId(Long etapaId) {
        this.etapaId = etapaId;
    }

}
