/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubber.dao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import ubber.entity.Commande;
import ubber.entity.Conducteur;

/**
 *
 * @author admin
 */
public class CommandeDAO {

  

    public void creer(Commande cmd) {
        
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        em.getTransaction().begin();
        
        em.persist(cmd);
        
        em.getTransaction().commit();
    }
    
}
