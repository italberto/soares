/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.italberto.forbetico.persistence.facade;

import br.italberto.forbetico.persistence.dao.CriterioDAO;
import br.italberto.forbetico.persistence.dao.PaisDAO;
import br.italberto.forbetico.persistence.domain.Criterio;
import br.italberto.forbetico.persistence.domain.Pais;
import java.util.List;

/**
 *
 * @author italberto
 */
public class FacadeCriterio extends Facade<Criterio>{

    public FacadeCriterio() {
        super(new CriterioDAO());
    }

    @Override
    public List<Criterio> findAll() {
        return ((CriterioDAO)dao).findAll();
    }
    
    @Override
    public Criterio findById(Long id) {
        return ((CriterioDAO)dao).findById(id);
    }

    @Override
    public void save(Criterio obj) {
        ((CriterioDAO)dao).save(obj);
    }

    @Override
    public void create(Criterio obj) {
        ((CriterioDAO)dao).create(obj);
    }

    @Override
    public void delete(Criterio obj) {
        ((CriterioDAO)dao).delete(obj);
    }

    @Override
    public void closeSession() {
        ((CriterioDAO)dao).closeSession();
    }

  
    
}
