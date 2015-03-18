/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.italberto.forbetico.persistence.dao;

import br.italberto.forbetico.persistence.domain.Engine;
import br.italberto.forbetico.persistence.domain.Estudo;
import br.italberto.forbetico.persistence.factory.EntityManagerFactory;
import java.util.List;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author italberto
 */
public class EngineDAO extends DAO<Engine>{

    private EntityManager em;
    
    public EngineDAO() {
        super(Engine.class);
        em = EntityManagerFactory.getCurrentInstance().getEntityManagerForQuery();
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

   
    @Override
    public List<Engine> findAll() {
        em = EntityManagerFactory.getCurrentInstance().getEntityManagerForQuery();
        Set<Engine> engines = new HashSet<>();
        
        engines.addAll(em.createQuery("FROM Engine").getResultList());
        
        List<Engine> retorno = new ArrayList();
        
        for (Engine engine : engines) {
            retorno.add(engine);
        }
        
        return retorno;
    }
    
    
    public List<Engine> findByName(String name) {
        em = EntityManagerFactory.getCurrentInstance().getEntityManagerForQuery();
        Set<Engine> engines = new HashSet<>();
        
        String consulta = "FROM Engine e where e.nome like '%"+name+"%'";
        
        engines.addAll(em.createQuery(consulta).getResultList());
        
        List<Engine> retorno = new ArrayList();
        
        for (Engine engine : engines) {
            retorno.add(engine);
        }
        
        return retorno;
    }
    
    @Override
    public Engine findById(Long id) {
        em = EntityManagerFactory.getCurrentInstance().getEntityManagerForQuery();
        Engine retorno = em.find(Engine.class, id);
        return retorno;
    }

    @Override
    public void save(Engine obj) {
        em = EntityManagerFactory.getCurrentInstance().getEntityManagerForQuery();
        em.getTransaction().begin();
        obj = em.merge(obj);
        em.persist(obj);
        em.getTransaction().commit();
        EntityManagerFactory.getCurrentInstance().closeEntityManager(em);   
    }

    @Override
    public void create(Engine obj) {
        em = EntityManagerFactory.getCurrentInstance().getEntityManagerForQuery();
        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();
        EntityManagerFactory.getCurrentInstance().closeEntityManager(em); 
    }

    @Override
    public void delete(Engine obj) {
        em = EntityManagerFactory.getCurrentInstance().getEntityManagerForQuery();
        em.getTransaction().begin();
        obj = em.merge(obj);
        em.remove(obj);
        em.getTransaction().commit();
        EntityManagerFactory.getCurrentInstance().closeEntityManager(em); 
    }

    @Override
    public  void closeSession(){
        EntityManagerFactory.getCurrentInstance().closeEntityManager(em); 
    }
    
    
}
