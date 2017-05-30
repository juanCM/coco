/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controllers;

import com.DAO.UserDAO;
import com.models.User;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import javax.faces.context.FacesContext;
//import javax.management.Query;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Fernando
 */
@ManagedBean(name = "LoginMB")
@ViewScoped

public class LoginController {
    
    private UserDAO userDAO = new UserDAO();
    private User user = new User();
 
    
    public String send(){
        user.setId(1);
        user.setNombre("Dummy");
        user.setApe_p("Dummy");
        user.setApe_m("Dummy");
        user.setEmail("Dummy");
        user.setPassword("123");
        user.setId_tipo(1);
   
        if (!userDAO.insertUser(user)) {
            
            RequestContext.getCurrentInstance().update("growl");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Usuario no encontrado ","Error en login"));
            return null;
        }else{
            return "/faces/Encuestas.xhtml";
        }
    }
    
   
    public User getUser(){
        return user;
    }
    
    public void setUser(){
        this.user = user;
    }
}
