/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.italberto.forbetico.view;

import br.italberto.forbetico.persistence.domain.Criterio;
import br.italberto.forbetico.persistence.domain.Estudo;
import br.italberto.forbetico.persistence.domain.Etapa;
import br.italberto.forbetico.persistence.domain.Revisao;
import br.italberto.forbetico.persistence.facade.FacadeCriterio;
import br.italberto.forbetico.persistence.facade.FacadeEstudo;
import br.italberto.forbetico.persistence.facade.FacadeEtapa;
import br.italberto.forbetico.persistence.facade.FacadeRevisao;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author italberto
 */
@ManagedBean(name = "estudoBean")
@ViewScoped
public class EstudoBean {

    private FacadeEstudo facade;
    private FacadeRevisao fr;
    private List<Estudo> estudos;
    private Long criterioId;
    private Long revisaoId;

    private List<Revisao> revisoes;
    private Revisao revisao;
    private List<Etapa> etapas;

    private Estudo estudo;

    private String teste;

    FacadeEtapa facade_etapa = new FacadeEtapa();

    private List<SelectItem> criterios = new ArrayList<>();

    public EstudoBean() {
        facade = new FacadeEstudo();
        //estudos = facade.findAll();
        fr = new FacadeRevisao();
        revisoes = fr.findAll();
        this.etapas = new ArrayList<>();

        this.criterios = montaCriterios(etapas);

        fr.closeSession();

    }

    public void prepararAvaliacao(Estudo estudo) {

        this.estudo = estudo;

        this.criterios = montaCriterios(this.etapas);

        System.out.println(criterios);
    }

    public void avaliarEstudo() {

        FacadeCriterio fcri = new FacadeCriterio();

        Criterio criterioTmp = fcri.findById(criterioId);

        Estudo estudoTmp = facade.findById(this.estudo.getId());

        estudoTmp.setCriterio(criterioTmp);

        facade.save(estudoTmp);

        revisoes = fr.findAll();

        fcri.closeSession();
        facade.closeSession();
        fr.closeSession();

        System.out.println(this.criterioId);
    }

    private List<SelectItem> montaCriterios(List<Etapa> et) {

        List<SelectItem> retorno = new ArrayList<>();

        for (Etapa etapa : et) {
            SelectItemGroup grupo = new SelectItemGroup(etapa.getTitulo());
            System.out.println(etapa.getTitulo());
            SelectItem[] items = new SelectItem[etapa.getCriterios().size()];
            for (int i = 0; i < items.length; i++) {
                System.out.println("\t" + etapa.getCriterios().get(i).getId() + " - " + etapa.getCriterios().get(i).getTitulo());
                items[i] = new SelectItem(etapa.getCriterios().get(i).getId(), etapa.getCriterios().get(i).getTitulo());
            }

            grupo.setSelectItems(items);

            retorno.add(grupo);

        }

        return retorno;
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

        this.estudos = facade.findAllByRevisao(revisaoId);

        this.etapas = facade_etapa.findAllByRevisao(revisaoId);

        Collections.sort(this.etapas);

        this.criterios = montaCriterios(this.etapas);

        facade.closeSession();
        fr.closeSession();
    }

    public Revisao getRevisao() {
        return revisao;
    }

    public void setRevisao(Revisao revisao) {
        this.revisao = revisao;
    }

    public String todos() {
        this.estudos = facade.findAll();
        return "lista_artigos";
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

    public List<SelectItem> getCriterios() {
        return this.criterios;
    }

    public void setCriterios(List<SelectItem> criterios) {
        this.criterios = criterios;
    }

    public Estudo getEstudo() {
        return estudo;
    }

    public void setEstudo(Estudo estudo) {
        this.estudo = estudo;
    }

    public void onEdit(RowEditEvent event) {

        Map x = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

        Estudo estudo = (Estudo) event.getObject();

        System.out.println(estudo.getId());

        FacadeEstudo f = new FacadeEstudo();
        FacadeCriterio fcri = new FacadeCriterio();
        Criterio cri = fcri.findById(criterioId);

        estudo.setCriterio(cri);

        f.save(estudo);

        f.closeSession();
        FacesMessage msg = new FacesMessage("Estudo editado", estudo.getId() + "");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public String getTeste() {
        return teste;
    }

    public void setTeste(String teste) {
        this.teste = teste;
    }

}
