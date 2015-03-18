/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.italberto.forbetico.persistence.facade;

import br.italberto.forbetico.persistence.dao.ArquivoDAO;
import br.italberto.forbetico.persistence.dao.PaisDAO;
import br.italberto.forbetico.persistence.domain.Arquivo;
import br.italberto.forbetico.persistence.domain.Pais;
import java.util.List;

/**
 *
 * @author italberto
 */
public class FacadeArquivo extends Facade<Arquivo>{

    public FacadeArquivo() {
        super(new ArquivoDAO());
    }

    @Override
    public List<Arquivo> findAll() {
        return ((ArquivoDAO)dao).findAll();
    }
    
    @Override
    public Arquivo findById(Long id) {
        return ((ArquivoDAO)dao).findById(id);
    }

    @Override
    public void save(Arquivo obj) {
        ((ArquivoDAO)dao).save(obj);
    }

    @Override
    public void create(Arquivo obj) {
        ((ArquivoDAO)dao).create(obj);
    }

    @Override
    public void delete(Arquivo obj) {
        ((ArquivoDAO)dao).delete(obj);
    }

    @Override
    public void closeSession() {
        ((ArquivoDAO)dao).closeSession();
    }

  
    
}
