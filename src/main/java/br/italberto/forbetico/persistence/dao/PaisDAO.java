/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.italberto.forbetico.persistence.dao;

import br.italberto.forbetico.persistence.domain.Pais;
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
public class PaisDAO extends DAO<Pais>{

    private EntityManager em;
    
    public PaisDAO() {
        super(Pais.class);
        em = EntityManagerFactory.getCurrentInstance().getEntityManagerForQuery();
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

   
    @Override
    public List<Pais> findAll() {
        em = EntityManagerFactory.getCurrentInstance().getEntityManagerForQuery();
        Set<Pais> paises = new HashSet<>();
        
        paises.addAll(em.createQuery("FROM Pais").getResultList());
        
        List<Pais> retorno = new ArrayList();
        
        for (Pais pais : paises) {
            retorno.add(pais);
        }
        
        return retorno;
    }
    
    
    public List<Pais> findByName(String name) {
        em = EntityManagerFactory.getCurrentInstance().getEntityManagerForQuery();
        Set<Pais> paises = new HashSet<>();
        
        String consulta = "FROM Pais p where p.nome like '%"+name+"%'";
        
        paises.addAll(em.createQuery(consulta).getResultList());
        
        List<Pais> retorno = new ArrayList();
        
        for (Pais pais : paises) {
            retorno.add(pais);
        }
        
        return retorno;
    }
    
    @Override
    public Pais findById(Long id) {
        em = EntityManagerFactory.getCurrentInstance().getEntityManagerForQuery();
        Pais retorno = em.find(Pais.class, id);
        return retorno;
    }

    @Override
    public void save(Pais obj) {
        em = EntityManagerFactory.getCurrentInstance().getEntityManagerForQuery();
        em.getTransaction().begin();
        obj = em.merge(obj);
        em.persist(obj);
        em.getTransaction().commit();
        EntityManagerFactory.getCurrentInstance().closeEntityManager(em);   
    }

    @Override
    public void create(Pais obj) {
        em = EntityManagerFactory.getCurrentInstance().getEntityManagerForQuery();
        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();
        EntityManagerFactory.getCurrentInstance().closeEntityManager(em); 
    }

    @Override
    public void delete(Pais obj) {
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
