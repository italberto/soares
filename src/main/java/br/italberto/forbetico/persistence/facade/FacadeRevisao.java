/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.italberto.forbetico.persistence.facade;

import br.italberto.forbetico.persistence.dao.RevisaoDAO;
import br.italberto.forbetico.persistence.dao.PaisDAO;
import br.italberto.forbetico.persistence.domain.Revisao;
import br.italberto.forbetico.persistence.domain.Pais;
import java.util.List;

/**
 *
 * @author italberto
 */
public class FacadeRevisao extends Facade<Revisao> {

    public FacadeRevisao() {
        super(new RevisaoDAO());
    }

    @Override
    public List<Revisao> findAll() {
        return ((RevisaoDAO) dao).findAll();
    }

    @Override
    public Revisao findById(Long id) {
        return ((RevisaoDAO) dao).findById(id);
    }

    @Override
    public void save(Revisao obj) {
        ((RevisaoDAO) dao).save(obj);
    }

    @Override
    public void create(Revisao obj) {
        ((RevisaoDAO) dao).create(obj);
    }

    @Override
    public void delete(Revisao obj) {
        ((RevisaoDAO) dao).delete(obj);
    }

    @Override
    public void closeSession() {
        ((RevisaoDAO) dao).closeSession();
    }

}
