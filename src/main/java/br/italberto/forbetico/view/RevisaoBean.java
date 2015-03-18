/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.italberto.forbetico.view;

import br.italberto.forbetico.persistence.domain.Revisao;
import br.italberto.forbetico.persistence.facade.FacadeRevisao;
import java.util.List;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author italberto
 */
@ManagedBean(name = "revisaoBean")
public class RevisaoBean extends BeanPadrao {

    private FacadeRevisao facade;
    private List<Revisao> revisoes;
    private Revisao revisao;

    public RevisaoBean() {
        facade = new FacadeRevisao();
        revisoes = facade.findAll();
        revisao = new Revisao();
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

    public void criarRevisao() {
        this.revisao = new Revisao();

    }

    public void salvarRevisao() {
        FacadeRevisao fe = new FacadeRevisao();

        fe.save(this.revisao);

        this.revisoes = fe.findAll();

        this.revisao = new Revisao();

        fe.closeSession();

        setMensagem("Aviso!", "A revisão foi criada com sucesso.");
    }

    public void atualizarRevisao() {
        FacadeRevisao fe = new FacadeRevisao();

        fe.save(this.revisao);

        this.revisao = new Revisao();

        this.revisoes = fe.findAll();

        fe.closeSession();

        setMensagem("Aviso!", "A revisão foi atualizada com sucesso.");
    }

    public void excluirRevisao(Revisao revisao) {
        FacadeRevisao fe = new FacadeRevisao();

        fe.delete(revisao);

        this.revisoes = fe.findAll();

        fe.closeSession();

        setMensagem("Aviso!", "A revisão foi excluída com sucesso.");
    }

}
