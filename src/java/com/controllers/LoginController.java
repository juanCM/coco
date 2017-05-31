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
        user = userDAO.loginUser("waffle133@gmail.com","123");
        if (user == null) {
            
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
