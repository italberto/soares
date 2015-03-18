/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.italberto.forbetico.persistence.dao;

import br.italberto.forbetico.persistence.domain.Etapa;
import br.italberto.forbetico.persistence.domain.Etapa;
import br.italberto.forbetico.persistence.domain.Estudo;
import br.italberto.forbetico.persistence.factory.EntityManagerFactory;
import java.util.List;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author italberto
 */
public class EtapaDAO extends DAO<Etapa> {

    private EntityManager em;

    public EtapaDAO() {
        super(Etapa.class);
        em = EntityManagerFactory.getCurrentInstance().getEntityManagerForQuery();
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public List<Etapa> findAll() {
        em = EntityManagerFactory.getCurrentInstance().getEntityManagerForQuery();
        Set<Etapa> engines = new HashSet<>();

        engines.addAll(em.createQuery("FROM Etapa e order by e.id asc").getResultList());

        List<Etapa> retorno = new ArrayList();

        for (Etapa engine : engines) {
            retorno.add(engine);
        }

        return retorno;
    }

    public List<Etapa> findByTitulo(String name) {
        em = EntityManagerFactory.getCurrentInstance().getEntityManagerForQuery();
        Set<Etapa> engines = new HashSet<>();

        String consulta = "FROM Etapa e where e.titulo like '%" + name + "%'";

        engines.addAll(em.createQuery(consulta).getResultList());

        List<Etapa> retorno = new ArrayList();

        for (Etapa engine : engines) {
            retorno.add(engine);
        }

        return retorno;
    }

    public List<Etapa> findByQuery(String query) {
        em = EntityManagerFactory.getCurrentInstance().getEntityManagerForQuery();
        Set<Etapa> etapas = new HashSet<>();

        etapas.addAll(em.createQuery(query).getResultList());

        List<Etapa> retorno = new ArrayList();

        for (Etapa etapa : etapas) {
            retorno.add(etapa);
        }

        Collections.sort(retorno);
        return retorno;
    }
    
    @Override
    public Etapa findById(Long id) {
        em = EntityManagerFactory.getCurrentInstance().getEntityManagerForQuery();
        Etapa retorno = em.find(Etapa.class, id);
        return retorno;
    }

    @Override
    public void save(Etapa obj) {
        em = EntityManagerFactory.getCurrentInstance().getEntityManagerForQuery();
        em.getTransaction().begin();
        obj = em.merge(obj);
        em.persist(obj);
        em.getTransaction().commit();
        EntityManagerFactory.getCurrentInstance().closeEntityManager(em);
    }

    @Override
    public void create(Etapa obj) {
        em = EntityManagerFactory.getCurrentInstance().getEntityManagerForQuery();
        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();
        EntityManagerFactory.getCurrentInstance().closeEntityManager(em);
    }

    @Override
    public void delete(Etapa obj) {
        em = EntityManagerFactory.getCurrentInstance().getEntityManagerForQuery();
        em.getTransaction().begin();
        obj = em.merge(obj);
        em.remove(obj);
        em.getTransaction().commit();
        EntityManagerFactory.getCurrentInstance().closeEntityManager(em);
    }

    @Override
    public void closeSession() {
        EntityManagerFactory.getCurrentInstance().closeEntityManager(em);
    }

}
