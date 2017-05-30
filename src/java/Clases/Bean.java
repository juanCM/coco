/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Petite
 */
@ManagedBean
@ViewScoped
public class Bean implements Serializable {
    private List<Item> items;
    
    public Bean(){
        
    }
   
   
    @PostConstruct
    public void init() {
        items = new ArrayList<>();
    }

    public void add() {
        Item item = new Item();
        item.setLabel("Pregunta: ");
        items.add(item);
    }
    
    public void remove(Item item) {
        items.remove(item);
    }

    public List<Item> getItems() {
        return items;
    }

}
