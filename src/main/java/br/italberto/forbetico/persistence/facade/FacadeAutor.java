/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.italberto.forbetico.persistence.facade;

import br.italberto.forbetico.persistence.dao.AutorDAO;
import br.italberto.forbetico.persistence.dao.PaisDAO;
import br.italberto.forbetico.persistence.domain.Autor;
import br.italberto.forbetico.persistence.domain.Pais;
import java.util.List;

/**
 *
 * @author italberto
 */
public class FacadeAutor extends Facade<Autor>{

    public FacadeAutor() {
        super(new AutorDAO());
    }

    @Override
    public List<Autor> findAll() {
        return ((AutorDAO)dao).findAll();
    }
    
    @Override
    public Autor findById(Long id) {
        return ((AutorDAO)dao).findById(id);
    }

    @Override
    public void save(Autor obj) {
        ((AutorDAO)dao).save(obj);
    }

    @Override
    public void create(Autor obj) {
        ((AutorDAO)dao).create(obj);
    }

    @Override
    public void delete(Autor obj) {
        ((AutorDAO)dao).delete(obj);
    }

    @Override
    public void closeSession() {
        ((AutorDAO)dao).closeSession();
    }

    public List<Autor> findByName(String pname,String uname){
        return ((AutorDAO)dao).findByName(pname, uname);
    }
    
    
}
