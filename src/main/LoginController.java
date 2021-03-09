/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import ventanas.ventana;

/**
 * FXML Controller class
 *
 * @author bramdon
 */
public class LoginController implements Initializable {

    @FXML TextField txtUsuario=new TextField(); 
    @FXML PasswordField txtContra =new PasswordField();
    ventana vt=new ventana();
    
    @FXML private void entrar(ActionEvent ev)
    {
        if(txtUsuario.getText().equals("admin") && txtContra.getText().equals("123"))
        {
            vt.menuPrincipal(ev);
        }
        else
            JOptionPane.showMessageDialog(null, "Error en usuario y/o contraseña");
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
