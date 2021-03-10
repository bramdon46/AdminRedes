/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dispositivos;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import ventanas.ventana;

/**
 *
 * @author chino
 */
public class dispo {
     ventana vt=new ventana();
     
    @FXML private void menuPrincipal(ActionEvent ev)
    {
        vt.menuPrincipal(ev);
    }
    
}
