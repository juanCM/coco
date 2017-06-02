/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DAO;

/**
 *
 * @author juan
 */
import com.models.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class EncuestasDAO {

    private final EntityManagerFactory factory =  Persistence.createEntityManagerFactory("EncuestasPU");
    private final EntityManager em  = factory.createEntityManager();
   
    
    
    public EncuestasDAO(){
       
    }
}
