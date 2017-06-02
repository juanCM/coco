/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controllers;

import com.DAO.EncuestasDAO;
import com.models.User;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import javax.faces.context.FacesContext;
/**
 *
 * @author juan
 */
@ManagedBean(name = "Encuestas")
@ViewScoped
public class EncuestasController implements Serializable{
    private ArrayList questions;

    public ArrayList getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList questions) {
        this.questions = questions;
    }
    public void addInput() {
        questions.add(questions.size());

    }
    
    public EncuestasController() {
        questions = new ArrayList();
        questions.add(questions.size());
    }
    public void show() {
        
    }
    public void add() {
        
    }
    public void edit() {
        
    }
    public void delete() {
        
    }
}
