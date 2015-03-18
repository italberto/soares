/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.italberto.forbetico.persistence.facade;

import br.italberto.forbetico.persistence.dao.EngineDAO;
import br.italberto.forbetico.persistence.domain.Engine;
import java.util.List;

/**
 *
 * @author italberto
 */
public class FacadeEngine extends Facade<Engine>{

    public FacadeEngine() {
        super(new EngineDAO());
    }

    @Override
    public List<Engine> findAll() {
        return ((EngineDAO)dao).findAll();
    }
    
    
    @Override
    public Engine findById(Long id) {
        return ((EngineDAO)dao).findById(id);
    }

    public List<Engine> findByName(String name){
        return ((EngineDAO)dao).findByName(name);
    }
    
    @Override
    public void save(Engine obj) {
        ((EngineDAO)dao).save(obj);
    }

    @Override
    public void create(Engine obj) {
        ((EngineDAO)dao).create(obj);
    }

    @Override
    public void delete(Engine obj) {
        ((EngineDAO)dao).delete(obj);
    }

    @Override
    public void closeSession() {
        ((EngineDAO)dao).closeSession();
    }    
}
