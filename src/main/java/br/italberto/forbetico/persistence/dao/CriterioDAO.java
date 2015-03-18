/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.italberto.forbetico.persistence.dao;

import br.italberto.forbetico.persistence.domain.Criterio;
import br.italberto.forbetico.persistence.domain.Criterio;
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
public class CriterioDAO extends DAO<Criterio>{

    private EntityManager em;
    
    public CriterioDAO() {
        super(Criterio.class);
        em = EntityManagerFactory.getCurrentInstance().getEntityManagerForQuery();
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

   
    @Override
    public List<Criterio> findAll() {
        em = EntityManagerFactory.getCurrentInstance().getEntityManagerForQuery();
        Set<Criterio> engines = new HashSet<>();
        
        engines.addAll(em.createQuery("FROM Criterio").getResultList());
        
        List<Criterio> retorno = new ArrayList();
        
        for (Criterio criterio : engines) {
            retorno.add(criterio);
        }
        
        return retorno;
    }
    
    
    public List<Criterio> findByTitulo(String name) {
        em = EntityManagerFactory.getCurrentInstance().getEntityManagerForQuery();
        Set<Criterio> engines = new HashSet<>();
        
        String consulta = "FROM Criterio e where e.titulo like '%"+name+"%'";
        
        engines.addAll(em.createQuery(consulta).getResultList());
        
        List<Criterio> retorno = new ArrayList();
        
        for (Criterio engine : engines) {
            retorno.add(engine);
        }
        
        return retorno;
    }
    
    @Override
    public Criterio findById(Long id) {
        em = EntityManagerFactory.getCurrentInstance().getEntityManagerForQuery();
        Criterio retorno = em.find(Criterio.class, id);
        return retorno;
    }

    @Override
    public void save(Criterio obj) {
        em = EntityManagerFactory.getCurrentInstance().getEntityManagerForQuery();
        em.getTransaction().begin();
        obj = em.merge(obj);
        em.persist(obj);
        em.getTransaction().commit();
        EntityManagerFactory.getCurrentInstance().closeEntityManager(em);   
    }

    @Override
    public void create(Criterio obj) {
        em = EntityManagerFactory.getCurrentInstance().getEntityManagerForQuery();
        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();
        EntityManagerFactory.getCurrentInstance().closeEntityManager(em); 
    }

    @Override
    public void delete(Criterio obj) {
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
