/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dispositivos;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import ventanas.ventana;

/**
 *
 * @author chino
 */

public class dispo {
     private final SimpleStringProperty id;
    private final SimpleStringProperty nombre;
    private final SimpleStringProperty locadispositivo;
   
     public dispo(String numero, String nom, String local) {
     
         
          id=new SimpleStringProperty(numero);
        nombre=new SimpleStringProperty(nom);
        locadispositivo=new SimpleStringProperty(local);
        
     }

   public String getId()
    {
        return id.get();
    }

    public String getNombre() {
       return nombre.get();
    }

   public  String getLocadispositivo() {
       return locadispositivo.get();
    }
     
   
     public void setId(String numero)
    {
        id.set(numero);
    }
    
    public void setNombre(String nom)
    {
        nombre.set(nom);
    }
    public void setLocadispositivo(String local)
    {
        locadispositivo.set(local);
    }
     
     
    
    
    
}
