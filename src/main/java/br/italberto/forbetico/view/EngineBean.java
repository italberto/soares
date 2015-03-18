/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.italberto.forbetico.view;

import br.italberto.forbetico.persistence.domain.Engine;
import br.italberto.forbetico.persistence.domain.Revisao;
import br.italberto.forbetico.persistence.facade.FacadeEngine;
import br.italberto.forbetico.persistence.facade.FacadeRevisao;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author italberto
 */
@ManagedBean(name = "engineBean")
@ViewScoped
public class EngineBean extends BeanPadrao {

    private List<Engine> engines;
    private Engine engine;
    private Long revisaoId;
    private List<Revisao> revisoes;

    FacadeEngine fe = new FacadeEngine();

    FacadeRevisao fr = new FacadeRevisao();

    public EngineBean() {

        engines = fe.findAll();
        revisoes = fr.findAll();

        

        fe.closeSession();
        fr.closeSession();
        
        if (revisoes.size() < 1) {
            setMensagem("Aviso!", "Para cadastrar uma engine é necessário primeiro cadastrar uma revisão.");
        }
    }

    public void criarEngine() {
        this.engine = new Engine();

    }

    public void salvarEngine() {

        Revisao r = fr.findById(this.revisaoId);

        this.engine.setRevisao(r);
        fe.save(this.engine);

        this.engines = fe.findAll();

        this.engine = new Engine();
        fr.closeSession();
        fe.closeSession();

        setMensagem("Aviso!", "Engine cadastrada com sucesso.");
    }

    public void atualizarEngine() {

        fe.save(engine);

        fe.closeSession();

        setMensagem("Aviso!", "Engine atualizada com sucesso.");
    }

    public void excluirEngine(Engine engine) {

        fe.delete(engine);

        this.engines = fe.findAll();

        fe.closeSession();

        setMensagem("Aviso!", "Engine exculída com sucesso.");
    }

    public List<Engine> getEngines() {
        return engines;
    }

    public void setEngines(List<Engine> engines) {
        this.engines = engines;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
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

}
