/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.italberto.forbetico.persistence.dao;

import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author italberto
 * @param <Type>
 */
public abstract class DAO<Type> {
    
    private Class<Type> entityClass;
    
    public DAO(Class<Type> entityClass){
        this.entityClass = entityClass;
    }
    
    public abstract EntityManager getEntityManager();
    public abstract List<Type> findAll();
    public abstract Type findById(Long id);
    public abstract void save(Type obj);
    public abstract void create(Type obj);
    public abstract void delete(Type obj);
    public abstract void closeSession();
    

}
