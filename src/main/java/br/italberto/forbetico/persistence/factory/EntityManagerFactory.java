/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.italberto.forbetico.persistence.factory;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;

/**
 *
 * @author italberto
 */
public class EntityManagerFactory {
    
    private static final String PU = "postgres";
    //private static final String PU = "mysql";
    private static EntityManagerFactory emf = null;
    private static javax.persistence.EntityManagerFactory managerFactory = null;
    
    private EntityManagerFactory(){
        managerFactory = Persistence.createEntityManagerFactory(PU);
    }
    
    public static EntityManagerFactory getCurrentInstance(){
        if (emf==null){
            emf = new EntityManagerFactory();
        }
        return emf;
    }
    
    public EntityManager getEntityManagerForQuery(){
        return managerFactory.createEntityManager();
    }
    
    public void closeEntityManager(EntityManager em){
        if (em.isOpen())
            em.close();
    }
}
