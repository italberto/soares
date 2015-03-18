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
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

/**
 *
 * @author italberto
 */
@ManagedBean(name = "etapaBean")
public class EtapaBean extends BeanPadrao {

    private FacadeEtapa facade;
    private List<Etapa> etapas;
    private Etapa etapa;

    private List<Revisao> revisoes;
    private Revisao revisao;
    private Long revisaoId;

    FacadeRevisao fr = new FacadeRevisao();

    public EtapaBean() {
        facade = new FacadeEtapa();
        etapas = facade.findAll();
        etapa = new Etapa();

        revisao = new Revisao();
        revisoes = fr.findAll();
        fr.closeSession();
        
        if (revisoes.size()<1){
            setMensagem("Aviso!", "É necessário primeiro cadastrar uma revisão para poder cadastrar uma etapa.");
        }
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

    public void criarEtapa() {
        this.etapa = new Etapa();

        this.revisao = new Revisao();
        this.revisaoId = null;

    }

    public void salvarEtapa() {
        FacadeEtapa fe = new FacadeEtapa();

        Revisao tmp = fr.findById(this.revisaoId);
        this.etapa.setRevisao(tmp);
        fe.save(this.etapa);

        this.etapas = fe.findAll();

        this.etapa = new Etapa();
        this.revisaoId = null;

        fe.closeSession();
        fr.closeSession();

        setMensagem("Aviso!", "Etapa cadastrada com sucesso.");
    }

    public void atualizarEtapa() {
        FacadeEtapa fe = new FacadeEtapa();

        Revisao tmp = fr.findById(this.revisaoId);
        this.etapa.setRevisao(tmp);
        fe.save(this.etapa);

        this.etapas = fe.findAll();

        this.etapa = new Etapa();

        fe.closeSession();

        setMensagem("Aviso!", "Etapa atualizada com sucesso.");
    }

    public void excluirEtapa(Etapa etapa) {
        FacadeEtapa fe = new FacadeEtapa();

        fe.delete(etapa);

        this.etapas = fe.findAll();

        fe.closeSession();

        setMensagem("Aviso!", "Etapa excluída com sucesso");
    }

    public List<Revisao> getRevisoes() {
        return revisoes;
    }

    public void setRevisoes(List<Revisao> revisoes) {
        this.revisoes = revisoes;
    }

    public Revisao getRevisao() {
        return revisao;
    }

    public void setRevisao(Revisao revisao) {
        this.revisao = revisao;
    }

    public Long getRevisaoId() {
        return revisaoId;
    }

    public void setRevisaoId(Long revisaoId) {
        this.revisaoId = revisaoId;
    }

}
