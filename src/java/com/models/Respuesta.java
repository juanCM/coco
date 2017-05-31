/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author juan
 */
@Entity
@Table(name = "respuesta")
public class Respuesta implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_contestadas")
    private int id_contestadas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_pregunta")
    private int id_pregunta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "respuesta")
    private String respuesta;

    public Respuesta(int id) {
        this.id = id;
    }

    public Respuesta() {
    }
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_contestadas() {
        return id_contestadas;
    }

    public void setId_contestadas(int id_contestadas) {
        this.id_contestadas = id_contestadas;
    }

    public int getId_pregunta() {
        return id_pregunta;
    }

    public void setId_pregunta(int id_pregunta) {
        this.id_pregunta = id_pregunta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }
    
}
