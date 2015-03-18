/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.italberto.forbetico.persistence.facade;

import br.italberto.forbetico.persistence.dao.EtapaDAO;
import br.italberto.forbetico.persistence.dao.PaisDAO;
import br.italberto.forbetico.persistence.domain.Etapa;
import br.italberto.forbetico.persistence.domain.Pais;
import java.util.List;

/**
 *
 * @author italberto
 */
public class FacadeEtapa extends Facade<Etapa>{

    public FacadeEtapa() {
        super(new EtapaDAO());
    }

    @Override
    public List<Etapa> findAll() {
        return ((EtapaDAO)dao).findAll();
    }
    
    @Override
    public Etapa findById(Long id) {
        return ((EtapaDAO)dao).findById(id);
    }

    @Override
    public void save(Etapa obj) {
        ((EtapaDAO)dao).save(obj);
    }

    @Override
    public void create(Etapa obj) {
        ((EtapaDAO)dao).create(obj);
    }

    @Override
    public void delete(Etapa obj) {
        ((EtapaDAO)dao).delete(obj);
    }

    @Override
    public void closeSession() {
        ((EtapaDAO)dao).closeSession();
    }

    public List<Etapa> findAllByRevisao(Long idRevisao){
        String query = "from Etapa e where e.revisao.id = " + idRevisao;
        List<Etapa> retorno =  ((EtapaDAO)dao).findByQuery(query);
        return retorno;
    }
    
}
