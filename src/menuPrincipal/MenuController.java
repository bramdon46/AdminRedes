/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menuPrincipal;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import ventanas.ventana;

/**
 * FXML Controller class
 *
 * @author bramdon
 */
public class MenuController implements Initializable {

    ventana vt=new ventana();
    
    @FXML private void inventario(ActionEvent ev)
    {
        vt.goToInventario(ev);
    }
    @FXML private void dispositivos(ActionEvent ev)
    {
         vt.goToDispositivos(ev);
    }
    @FXML private void configuraciones(ActionEvent ev)
    {
        
    }
    @FXML private void fallas(ActionEvent ev)
    {
        
    }
     @FXML private void BuscarDispo(ActionEvent ev)
    {
        
    }
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
