/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.italberto.forbetico.persistence.dao;

import br.italberto.forbetico.persistence.domain.Revisao;

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
public class RevisaoDAO extends DAO<Revisao> {

    private EntityManager em;

    public RevisaoDAO() {
        super(Revisao.class);
        em = EntityManagerFactory.getCurrentInstance().getEntityManagerForQuery();
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public List<Revisao> findAll() {
        em = EntityManagerFactory.getCurrentInstance().getEntityManagerForQuery();
        Set<Revisao> engines = new HashSet<>();

        engines.addAll(em.createQuery("FROM Revisao e order by e.id asc").getResultList());

        List<Revisao> retorno = new ArrayList();

        for (Revisao engine : engines) {
            retorno.add(engine);
        }

        return retorno;
    }

    public List<Revisao> findByNome(String name) {
        em = EntityManagerFactory.getCurrentInstance().getEntityManagerForQuery();
        Set<Revisao> engines = new HashSet<>();

        String consulta = "FROM Revisao e where e.nome like '%" + name + "%'";

        engines.addAll(em.createQuery(consulta).getResultList());

        List<Revisao> retorno = new ArrayList();

        for (Revisao engine : engines) {
            retorno.add(engine);
        }

        return retorno;
    }

    @Override
    public Revisao findById(Long id) {
        em = EntityManagerFactory.getCurrentInstance().getEntityManagerForQuery();
        Revisao retorno = em.find(Revisao.class, id);
        return retorno;
    }

    @Override
    public void save(Revisao obj) {
        em = EntityManagerFactory.getCurrentInstance().getEntityManagerForQuery();
        em.getTransaction().begin();
        obj = em.merge(obj);
        em.persist(obj);
        em.getTransaction().commit();
        EntityManagerFactory.getCurrentInstance().closeEntityManager(em);
    }

    @Override
    public void create(Revisao obj) {
        em = EntityManagerFactory.getCurrentInstance().getEntityManagerForQuery();
        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();
        EntityManagerFactory.getCurrentInstance().closeEntityManager(em);
    }

    @Override
    public void delete(Revisao obj) {
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
