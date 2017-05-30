/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DAO;

/**
 *
 * @author Fernando
 */

import com.models.User;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class UserDAO {
    
    private final EntityManagerFactory factory =  Persistence.createEntityManagerFactory("EncuestasPU");
    private final EntityManager em  = factory.createEntityManager();
   
    
    
    public UserDAO(){
       
    }
    
    public boolean getUser(String email, String pass){
        try{
            User query = (User) em
                               .createQuery("SELECT u FROM User u WHERE u.email = :email AND u.password = :password")
                               .setParameter("email",email)
                               .setParameter("password",pass);

            return query==null;
        }catch(Exception e){
            return false;
        }
       
        
    }
    
    public boolean insertUser(User user){
        try{
            em.persist(user);
            return true;
        }catch(Exception e){
            return false;
        }
       
    }
    
    public boolean deleteUser(User user){
         try{
            em.remove(user);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    
}
