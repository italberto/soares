/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.italberto.forbetico.persistence.dao;

import br.italberto.forbetico.persistence.domain.Arquivo;
import br.italberto.forbetico.persistence.domain.Arquivo;
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
public class ArquivoDAO extends DAO<Arquivo> {

    private EntityManager em;

    public ArquivoDAO() {
        super(Arquivo.class);
        em = EntityManagerFactory.getCurrentInstance().getEntityManagerForQuery();
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public List<Arquivo> findAll() {
        em = EntityManagerFactory.getCurrentInstance().getEntityManagerForQuery();
        Set<Arquivo> engines = new HashSet<>();

        engines.addAll(em.createQuery("FROM Arquivo a order by a.id asc").getResultList());

        List<Arquivo> retorno = new ArrayList();

        for (Arquivo engine : engines) {
            retorno.add(engine);
        }

        return retorno;
    }

    public List<Arquivo> findByName(String name) {
        em = EntityManagerFactory.getCurrentInstance().getEntityManagerForQuery();
        Set<Arquivo> engines = new HashSet<>();

        String consulta = "FROM Arquivo e where e.nome like '%" + name + "%' order by e.nome asc";

        engines.addAll(em.createQuery(consulta).getResultList());

        List<Arquivo> retorno = new ArrayList();

        for (Arquivo engine : engines) {
            retorno.add(engine);
        }

        return retorno;
    }

    @Override
    public Arquivo findById(Long id) {
        em = EntityManagerFactory.getCurrentInstance().getEntityManagerForQuery();
        Arquivo retorno = em.find(Arquivo.class, id);
        return retorno;
    }

    @Override
    public void save(Arquivo obj) {
        em = EntityManagerFactory.getCurrentInstance().getEntityManagerForQuery();
        em.getTransaction().begin();
        obj = em.merge(obj);
        em.persist(obj);
        em.getTransaction().commit();
        EntityManagerFactory.getCurrentInstance().closeEntityManager(em);
    }

    @Override
    public void create(Arquivo obj) {
        em = EntityManagerFactory.getCurrentInstance().getEntityManagerForQuery();
        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();
        EntityManagerFactory.getCurrentInstance().closeEntityManager(em);
    }

    @Override
    public void delete(Arquivo obj) {
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
