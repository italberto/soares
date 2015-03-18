/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.italberto.forbetico.persistence.dao;

import br.italberto.forbetico.persistence.domain.Autor;
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
public class AutorDAO extends DAO<Autor> {

    private EntityManager em;

    public AutorDAO() {
        super(Autor.class);
        em = EntityManagerFactory.getCurrentInstance().getEntityManagerForQuery();
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public List<Autor> findAll() {
        em = EntityManagerFactory.getCurrentInstance().getEntityManagerForQuery();
        Set<Autor> autores = new HashSet<>();

        autores.addAll(em.createQuery("FROM Autor").getResultList());

        List<Autor> retorno = new ArrayList();

        for (Autor autor : autores) {
            retorno.add(autor);
        }

        return retorno;
    }

    public List<Autor> findByName(String primeiroNome, String ultimoNome) {
        em = EntityManagerFactory.getCurrentInstance().getEntityManagerForQuery();
        Set<Autor> autores = new HashSet<>();

        String consulta = "FROM Autor p where p.primeiroNome = '" + primeiroNome + "' and p.ultimoNome = '" + ultimoNome + "'";

        autores.addAll(em.createQuery(consulta).getResultList());

        List<Autor> retorno = new ArrayList();

        for (Autor autor : autores) {
            retorno.add(autor);
        }

        return retorno;
    }

    @Override
    public Autor findById(Long id) {
        em = EntityManagerFactory.getCurrentInstance().getEntityManagerForQuery();
        Autor retorno = em.find(Autor.class, id);
        return retorno;
    }

    @Override
    public void save(Autor obj) {
        em = EntityManagerFactory.getCurrentInstance().getEntityManagerForQuery();
        em.getTransaction().begin();
        obj = em.merge(obj);
        em.persist(obj);
        em.getTransaction().commit();
        EntityManagerFactory.getCurrentInstance().closeEntityManager(em);
    }

    @Override
    public void create(Autor obj) {
        em = EntityManagerFactory.getCurrentInstance().getEntityManagerForQuery();
        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();
        EntityManagerFactory.getCurrentInstance().closeEntityManager(em);
    }

    @Override
    public void delete(Autor obj) {
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
