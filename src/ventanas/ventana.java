/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author bramdon
 */
public class ventana {
    
    public void menuPrincipal(ActionEvent eve)
    {
        try {
            Stage primaryStage=new Stage();
            Parent raiz= FXMLLoader.load(getClass().getResource("/menuPrincipal/menu.fxml"));
            Scene escena=new Scene(raiz);
//            image=new Image("/imagenes/icono.png");
//            primaryStage.getIcons().add(image);
            primaryStage.setTitle("Menu Principal");
            primaryStage.setScene(escena);
            primaryStage.show();
            ((Node)(eve.getSource())).getScene().getWindow().hide();
        } catch (IOException ex) {
            Logger.getLogger(ventana.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public void goToInventario(ActionEvent eve)
    {
        try {
            Stage primaryStage=new Stage();
            Parent raiz= FXMLLoader.load(getClass().getResource("/inventario/inventario.fxml"));
            Scene escena=new Scene(raiz);
//            image=new Image("/imagenes/icono.png");
//            primaryStage.getIcons().add(image);
            primaryStage.setTitle("Menu Principal");
            primaryStage.setScene(escena);
            primaryStage.show();
            ((Node)(eve.getSource())).getScene().getWindow().hide();
        } catch (IOException ex) {
            Logger.getLogger(ventana.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
}
