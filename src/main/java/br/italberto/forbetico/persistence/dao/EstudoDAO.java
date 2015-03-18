/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.italberto.forbetico.persistence.dao;

import br.italberto.forbetico.persistence.domain.Estudo;
import br.italberto.forbetico.persistence.factory.EntityManagerFactory;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.persistence.Query;

/**
 *
 * @author italberto
 */
public class EstudoDAO extends DAO<Estudo> {

    private EntityManager em;

    public EstudoDAO() {
        super(Estudo.class);
        em = EntityManagerFactory.getCurrentInstance().getEntityManagerForQuery();
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public List<Estudo> findAll() {
        em = EntityManagerFactory.getCurrentInstance().getEntityManagerForQuery();
        Set<Estudo> estudos = new HashSet<>();

        estudos.addAll(em.createQuery("FROM Estudo e order by e.id asc").getResultList());

        List<Estudo> retorno = new ArrayList();

        for (Estudo estudo : estudos) {
            retorno.add(estudo);
        }

        Collections.sort(retorno);
        return retorno;
    }

    public List<Estudo> findByQuery(String query) {
        em = EntityManagerFactory.getCurrentInstance().getEntityManagerForQuery();
        Set<Estudo> estudos = new HashSet<>();

        estudos.addAll(em.createQuery(query).getResultList());

        List<Estudo> retorno = new ArrayList();

        for (Estudo estudo : estudos) {
            retorno.add(estudo);
        }

        Collections.sort(retorno);
        return retorno;
    }

    public List<Map<String, Integer>> countEstudosPorAno() {
        em = EntityManagerFactory.getCurrentInstance().getEntityManagerForQuery();

        List<Map<String, Integer>> retorno = new ArrayList<>();

        String consulta = "select e.ano_publicacao,count(*) from estudo e group by e.ano_publicacao order by e.ano_publicacao asc";

        Query query = em.createNativeQuery(consulta);

        List<Object[]> results = query.getResultList();

        for (Object[] objects : results) {
            Map<String, Integer> tmp = new HashMap<>();

            tmp.put(objects[0].toString(), ((BigInteger) objects[1]).intValue());

            retorno.add(tmp);
        }

        return retorno;
    }

    public HashMap<String, Integer> countEstudosPorPais() {
        em = EntityManagerFactory.getCurrentInstance().getEntityManagerForQuery();

        HashMap<String, Integer> retorno = new HashMap<String, Integer>();

        String consulta = "select p.nome,count(*) "
                + "from estudo e join pais p on p.id_pais = e.id_pais "
                + "where e.id_pais is not null "
                + "group by p.nome order by count(*) asc "
                + "limit 15";

        Query query = em.createNativeQuery(consulta);

        List<Object[]> results = query.getResultList();

        for (Object[] objects : results) {
            String key = (String) objects[0];
            BigInteger value = (BigInteger) objects[1];
            System.out.println("");
            retorno.put(key, value.intValue());
        }

        return retorno;
    }

    public HashMap<String, Integer> countEstudosPorAutor() {
        em = EntityManagerFactory.getCurrentInstance().getEntityManagerForQuery();

        HashMap<String, Integer> retorno = new HashMap<>();

        String consulta = "select a.primeiro_nome || ' ' || a.ultimo_nome nome,count(*)\n"
                + "from\n"
                + "	autor a join estudo e using(id_estudo)\n"
                + "where\n"
                + "	autor_principal is true\n"
                + "	and a.primeiro_nome <> ''\n"
                + "	and a.ultimo_nome <> ''\n"
                + "group by primeiro_nome,ultimo_nome\n"
                + "having count(*)>1"
                + "order by count(*) desc, nome asc "
                + "limit 15";

        Query query = em.createNativeQuery(consulta);

        List<Object[]> results = query.getResultList();

        for (Object[] objects : results) {
            String key = (String) objects[0];
            BigInteger value = (BigInteger) objects[1];

            retorno.put(key, value.intValue());
        }

        return retorno;
    }

    public HashMap<String, Integer> countPublicacoesPorEngine() {
        em = EntityManagerFactory.getCurrentInstance().getEntityManagerForQuery();

        HashMap<String, Integer> retorno = new HashMap<>();

        String consulta = "select x.nome,count(*) \n"
                + "from \n"
                + "	estudo e join engine x on e.id_engine = x.id_engine\n"
                + "group by x.nome\n";

        Query query = em.createNativeQuery(consulta);

        List<Object[]> results = query.getResultList();

        for (Object[] objects : results) {
            String key = (String) objects[0];
            BigInteger value = (BigInteger) objects[1];

            retorno.put(key, value.intValue());
        }

        return retorno;
    }

    @Override
    public Estudo findById(Long id) {
        em = EntityManagerFactory.getCurrentInstance().getEntityManagerForQuery();
        Estudo retorno = em.find(Estudo.class, id);
        return retorno;
    }

    @Override
    public void save(Estudo obj) {
        em = EntityManagerFactory.getCurrentInstance().getEntityManagerForQuery();
        em.getTransaction().begin();
        obj = em.merge(obj);
        em.persist(obj);
        em.getTransaction().commit();
        EntityManagerFactory.getCurrentInstance().closeEntityManager(em);
    }

    @Override
    public void create(Estudo obj) {
        em = EntityManagerFactory.getCurrentInstance().getEntityManagerForQuery();
        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();
        EntityManagerFactory.getCurrentInstance().closeEntityManager(em);
    }

    @Override
    public void delete(Estudo obj) {
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
