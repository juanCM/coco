/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;



/**
 *
 * @author Petite
 */
public class Item{
    private String label;
    private String value;
    private String opcion;
    private String opMultiple;

    public String getOpMultiple() {
        return opMultiple;
    }

    public void setOpMultiple(String opMultiple) {
        this.opMultiple = opMultiple;
    }

    public String getOpcion() {
        return opcion;
    }

    public void setOpcion(String opcion) {
        this.opcion = opcion;
    }
    
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    
    
}
