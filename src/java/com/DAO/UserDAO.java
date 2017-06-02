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
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class UserDAO {
    
    private final EntityManagerFactory factory =  Persistence.createEntityManagerFactory("EncuestasPU");
    private final EntityManager em  = factory.createEntityManager();
   
    
    
    public UserDAO(){
       
    }
    
    public User loginUser(String email, String pass){
        try{
            em.getTransaction().begin();
            Query query =  em 
                    .createQuery("SELECT u FROM User u WHERE u.email = :email AND u.password = :pass")
                    .setParameter("email", email)
                    .setParameter("pass",pass);
            List<User> results = (List<User>) query.getResultList();
            if (results.isEmpty()) {
               return null; 
            }
            User user = results.get(0);
            
            
            return user;
        }catch(Exception e){
                return null;
        }
       
        
    }
    
    public boolean insertUser(User user){
         em.getTransaction().begin();
        try{
           
            em.persist(user);
            em.getTransaction().commit();
            
            return true;
        }catch(Exception e){
            em.getTransaction().rollback();
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
