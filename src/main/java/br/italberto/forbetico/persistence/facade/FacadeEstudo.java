/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.italberto.forbetico.persistence.facade;

import br.italberto.forbetico.persistence.dao.EstudoDAO;
import br.italberto.forbetico.persistence.domain.Estudo;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author italberto
 */
public class FacadeEstudo extends Facade<Estudo> {

    public FacadeEstudo() {
        super(new EstudoDAO());
    }

    @Override
    public List<Estudo> findAll() {
        return ((EstudoDAO) dao).findAll();
    }

    @Override
    public Estudo findById(Long id) {
        return ((EstudoDAO) dao).findById(id);
    }

    public List<Estudo> findAllByRevisao(Long id) {
        String query = "FROM Estudo e where e.engine.revisao.id = " + id;
        System.out.println(query);
        return ((EstudoDAO) dao).findByQuery(query);
    }

    public List<Estudo> findAllExcluidosByRevisao(Long id) {

        String query = "FROM Estudo e WHERE e.criterio is not null and e.engine.revisao.id = " + id;
        System.out.println(query);
        return ((EstudoDAO) dao).findByQuery(query);
    }

    @Override
    public void save(Estudo obj) {
        ((EstudoDAO) dao).save(obj);
    }

    @Override
    public void create(Estudo obj) {
        ((EstudoDAO) dao).create(obj);
    }

    @Override
    public void delete(Estudo obj) {
        ((EstudoDAO) dao).delete(obj);
    }

    @Override
    public void closeSession() {
        ((EstudoDAO) dao).closeSession();
    }

    public List<Estudo> findExcluidos() {

        String query = "FROM Estudo e WHERE e.etapaE2 is not null or etapaE3 is not null";
        return ((EstudoDAO) dao).findByQuery(query);
    }

    public HashMap<String, Integer> countPublicacoesPorPais() {
        return ((EstudoDAO) dao).countEstudosPorPais();
    }

    public List<Map<String, Integer>> countPublicacoesPorAno() {
        return ((EstudoDAO) dao).countEstudosPorAno();
    }

    public HashMap<String, Integer> countPublicacoesPorAutor() {
        return ((EstudoDAO) dao).countEstudosPorAutor();
    }

    public HashMap<String, Integer> countPublicacoesPorEngine() {
        return ((EstudoDAO) dao).countPublicacoesPorEngine();
    }

}
