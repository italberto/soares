/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.italberto.forbetico.persistence.facade;

import br.italberto.forbetico.persistence.dao.DAO;
import java.util.List;

/**
 *
 * @author italberto
 */
public abstract class Facade<Type> {
    
    protected DAO dao = null;
    
    public Facade(DAO dao){
        this.dao = dao;
    }
    
    public abstract List<Type> findAll();
    public abstract Type findById(Long id);
    public abstract void save(Type obj);
    public abstract void create(Type obj);
    public abstract void delete(Type obj);
    public abstract void closeSession();
}
