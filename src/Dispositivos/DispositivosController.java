/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dispositivos;

import inventario.producto;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import ventanas.ventana;

/**
 * FXML Controller class
 *
 * @author chino
 */
public class DispositivosController implements Initializable {

    ventana vt=new ventana();
    
    @FXML private TableView<producto> tablaDispositivos=new TableView();
    @FXML TableColumn<producto, String> Loca_dispositivo; 
    @FXML TableColumn<producto, String> id_producto; 
    @FXML TableColumn<producto, String> nombre_producto; 
    
    /**
     * Initializes the controller class.
     */
    
    @FXML private void menuPrincipal(ActionEvent ev)
    {
        vt.menuPrincipal(ev);
    }
    
    @FXML private void BuscarDispo(ActionEvent ev)
    {
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
