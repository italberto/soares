/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.italberto.forbetico.persistence.dao;

import br.italberto.forbetico.persistence.domain.Keyword;
import br.italberto.forbetico.persistence.domain.Estudo;
import br.italberto.forbetico.persistence.factory.EntityManagerFactory;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Query;

/**
 *
 * @author italberto
 */
public class KeywordDAO extends DAO<Keyword> {

    private EntityManager em;

    public KeywordDAO() {
        super(Keyword.class);
        em = EntityManagerFactory.getCurrentInstance().getEntityManagerForQuery();
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public List<Keyword> findAll() {
        em = EntityManagerFactory.getCurrentInstance().getEntityManagerForQuery();
        Set<Keyword> keywords = new HashSet<>();

        keywords.addAll(em.createQuery("FROM Keyword").getResultList());

        List<Keyword> retorno = new ArrayList();

        for (Keyword keyword : keywords) {
            retorno.add(keyword);
        }

        return retorno;
    }

    public HashMap<String, BigInteger> getCount() {
        em = EntityManagerFactory.getCurrentInstance().getEntityManagerForQuery();

        HashMap<String, BigInteger> retorno = new HashMap<String, BigInteger>();

        String consulta = "select nome,count(*) from keyword group by nome having count(*)>1";

        Query query = em.createNativeQuery(consulta);

        List<Object[]> results = query.getResultList();

        for (Object[] objects : results) {
            retorno.put((String) objects[0], (BigInteger) objects[1]);
        }

        return retorno;
    }

    public HashMap<String, Integer> getCountEstudosPorKeyword() {
        em = EntityManagerFactory.getCurrentInstance().getEntityManagerForQuery();

        HashMap<String, Integer> retorno = new HashMap<String, Integer>();

        String consulta = "select nome,count(*) from keyword group by nome having count(*)>8 limit 15";

        Query query = em.createNativeQuery(consulta);

        List<Object[]> results = query.getResultList();

        for (Object[] objects : results) {
            retorno.put((String) objects[0], ((BigInteger) objects[1]).intValue());
        }

        return retorno;
    }

    public List<List<Object>> getCountKeywordsPorAno() {
        em = EntityManagerFactory.getCurrentInstance().getEntityManagerForQuery();

        List<List<Object>> retorno = new ArrayList<>();

        String consulta = "select e.ano_publicacao,k.nome,count(*)\n"
                + "from\n"
                + "	estudo e join keyword k on k.id_estudo = e.id_estudo\n"
                + "group by e.ano_publicacao,k.nome\n"
                + "having count(*)>=8"
                + "order by e.ano_publicacao asc";

        Query query = em.createNativeQuery(consulta);

        List<Object[]> results = query.getResultList();

        for (Object[] objects : results) {
            List<Object> tmp = new ArrayList<>();

            tmp.add(objects[0]);
            tmp.add(objects[1]);
            tmp.add(objects[2]);

            retorno.add(tmp);
        }

        return retorno;
    }

    public List<Keyword> findByName(String name) {
        em = EntityManagerFactory.getCurrentInstance().getEntityManagerForQuery();
        Set<Keyword> keywords = new HashSet<>();

        String consulta = "FROM Keyword k where k.nome like '%" + name + "%'";

        keywords.addAll(em.createQuery(consulta).getResultList());

        List<Keyword> retorno = new ArrayList();

        for (Keyword keyword : keywords) {
            retorno.add(keyword);
        }

        return retorno;
    }

    @Override
    public Keyword findById(Long id) {
        em = EntityManagerFactory.getCurrentInstance().getEntityManagerForQuery();
        Keyword retorno = em.find(Keyword.class, id);
        return retorno;
    }

    @Override
    public void save(Keyword obj) {
        em = EntityManagerFactory.getCurrentInstance().getEntityManagerForQuery();
        em.getTransaction().begin();
        obj = em.merge(obj);
        em.persist(obj);
        em.getTransaction().commit();
        EntityManagerFactory.getCurrentInstance().closeEntityManager(em);
    }

    @Override
    public void create(Keyword obj) {
        em = EntityManagerFactory.getCurrentInstance().getEntityManagerForQuery();
        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();
        EntityManagerFactory.getCurrentInstance().closeEntityManager(em);
    }

    @Override
    public void delete(Keyword obj) {
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
