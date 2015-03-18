/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.italberto.forbetico.persistence.facade;

import br.italberto.forbetico.persistence.dao.PaisDAO;
import br.italberto.forbetico.persistence.domain.Pais;
import java.util.List;

/**
 *
 * @author italberto
 */
public class FacadePais extends Facade<Pais>{

    public FacadePais() {
        super(new PaisDAO());
    }

    @Override
    public List<Pais> findAll() {
        return ((PaisDAO)dao).findAll();
    }
    
    
    @Override
    public Pais findById(Long id) {
        return ((PaisDAO)dao).findById(id);
    }

    public List<Pais> findByName(String name){
        return ((PaisDAO)dao).findByName(name);
    }
    
    @Override
    public void save(Pais obj) {
        ((PaisDAO)dao).save(obj);
    }

    @Override
    public void create(Pais obj) {
        ((PaisDAO)dao).create(obj);
    }

    @Override
    public void delete(Pais obj) {
        ((PaisDAO)dao).delete(obj);
    }

    @Override
    public void closeSession() {
        ((PaisDAO)dao).closeSession();
    }    
}
