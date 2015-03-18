/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.italberto.forbetico.persistence.facade;

import br.italberto.forbetico.persistence.dao.KeywordDAO;
import br.italberto.forbetico.persistence.domain.Keyword;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author italberto
 */
public class FacadeKeyword extends Facade<Keyword> {

    public FacadeKeyword() {
        super(new KeywordDAO());
    }

    @Override
    public List<Keyword> findAll() {
        return ((KeywordDAO) dao).findAll();
    }

    @Override
    public Keyword findById(Long id) {
        return ((KeywordDAO) dao).findById(id);
    }

    @Override
    public void save(Keyword obj) {
        ((KeywordDAO) dao).save(obj);
    }

    @Override
    public void create(Keyword obj) {
        ((KeywordDAO) dao).create(obj);
    }

    @Override
    public void delete(Keyword obj) {
        ((KeywordDAO) dao).delete(obj);
    }

    @Override
    public void closeSession() {
        ((KeywordDAO) dao).closeSession();
    }

    public HashMap<String, BigInteger> getCount() {
        return ((KeywordDAO) dao).getCount();
    }

    public HashMap<String, Integer> getCountEstudosPorKeyword() {
        return ((KeywordDAO) dao).getCountEstudosPorKeyword();
    }

    public List<List<Object>> getCountKeywordsPorAno() {
        return ((KeywordDAO) dao).getCountKeywordsPorAno();
    }

}
