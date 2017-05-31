/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;



@Entity
@Table(name="usuario")
@XmlRootElement
public class User implements Serializable {

   // @JoinColumn(name = "id_tipo", referencedColumnName = "id")
  //  @ManyToOne(optional = false)
    //private TipoUsuario idTipo;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable=false, unique=true)
    private int id; 
    @Column(name="email", nullable=false, unique=false) 
    private String email;
    
    @Column(name="password", nullable=false, unique=false) 
    private String password;
    
    @Column(name="nombre", nullable=false, unique=false) 
    private String nombre;
    
    @Column(name="ape_p", nullable=false, unique=false) 
    private String ape_p;
    
    @Column(name="ape_m", nullable=false, unique=false) 
    private String ape_m;
    
    @Column(name="id_tipo", nullable=false, unique=false)
    private int id_tipo;

    public User() {
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApe_p() {
        return ape_p;
    }

    public void setApe_p(String ape_p) {
        this.ape_p = ape_p;
    }

    public String getApe_m() {
        return ape_m;
    }

    public void setApe_m(String ape_m) {
        this.ape_m = ape_m;
    }

    public int getId_tipo() {
        return id_tipo;
    }

    public void setId_tipo(int id_tipo) {
        this.id_tipo = id_tipo;
    }

   

//    public TipoUsuario getIdTipo() {
//        return idTipo;
//    }
//
//    public void setIdTipo(TipoUsuario idTipo) {
//        this.idTipo = idTipo;
//    }
//    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.id;
        hash = 53 * hash + Objects.hashCode(this.email);
        hash = 53 * hash + Objects.hashCode(this.password);
        hash = 53 * hash + Objects.hashCode(this.nombre);
        hash = 53 * hash + Objects.hashCode(this.ape_p);
        hash = 53 * hash + Objects.hashCode(this.ape_m);
        hash = 53 * hash + this.id_tipo;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        return true;
    }

  
    


}
