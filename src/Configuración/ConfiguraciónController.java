/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Configuración;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;
import ventanas.ventana;

/**
 * FXML Controller class
 *
 * @author zneo1
 */
public class ConfiguraciónController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML TableView<Tabla> tablaConf=new TableView();
    //valores de la tabla
    @FXML TableColumn<Tabla, String> Codigo; 
    @FXML TableColumn<Tabla, String> Dispositivo; 
    @FXML TableColumn<Tabla, String> Usuario;  
    @FXML TableColumn<Tabla, String> Contraseña;
    @FXML TableColumn<Tabla, String> Ip;  
    @FXML TableColumn<Tabla, String> Mascara;
    @FXML TableColumn<Tabla, String> Conectado;  
    //Textos
    @FXML TextField TCodigo;
    @FXML TextField TDispositivo;
    @FXML TextField TUsuario;
    @FXML TextField TContraseña;
    @FXML TextField TIp;
    @FXML TextField TMascara;
    @FXML TextField TConectado;
    
    ventana vt=new ventana();
    public static ObservableList<Tabla> datosConf=FXCollections.observableArrayList(    );
    
    @Override
    public void initialize(URL url, ResourceBundle rd) {
        
        Codigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        Dispositivo.setCellValueFactory(new PropertyValueFactory<>("dispositivo"));
        Usuario.setCellValueFactory(new PropertyValueFactory<>("usuario"));
        Contraseña.setCellValueFactory(new PropertyValueFactory<>("contraseña"));
        Ip.setCellValueFactory(new PropertyValueFactory<>("ip"));
        Mascara.setCellValueFactory(new PropertyValueFactory<>("mascara"));
        Conectado.setCellValueFactory(new PropertyValueFactory<>("conectado"));
        tablaConf.setItems(datosConf);
        
        seleccion();
    } 
    
    @FXML private void Agregar(ActionEvent ev)
    {
        if(!TCodigo.getText().equals("") && !TDispositivo.getText().equals("") && !TUsuario.getText().equals("") && !TContraseña.getText().equals("")
           &&!TIp.getText().equals("") && !TMascara.getText().equals("") && !TConectado.getText().equals("") )
        {
            datosConf.add( new Tabla( TCodigo.getText(),TDispositivo.getText(), TUsuario.getText(), TContraseña.getText(), TIp.getText(), TMascara.getText(), TConectado.getText()) );
            JOptionPane.showMessageDialog(null,"Configuración actualizada");
            limpiar();
            
        }
        else
            JOptionPane.showMessageDialog(null,"Campos vacios");
        
    }
    
    @FXML private void modificar(ActionEvent ev)
    {
        if(tablaConf.getSelectionModel().getSelectedIndex()>=0)
        {
            int index=tablaConf.getSelectionModel().getSelectedIndex();
            if(!TCodigo.getText().equals("") && !TDispositivo.getText().equals("") && !TUsuario.getText().equals("") && !TContraseña.getText().equals("")
           &&!TIp.getText().equals("") && !TMascara.getText().equals("") && !TConectado.getText().equals("") )
            {
                Tabla Conf=datosConf.get(index);
                Conf.setCodigo(TCodigo.getText());
                Conf.setDisp(TDispositivo.getText());
                Conf.setUsua(TUsuario.getText());
                Conf.setContra(TContraseña.getText());
                Conf.setIp(TIp.getText());
                Conf.setMasc(TMascara.getText());
                Conf.setConectado(TConectado.getText());
                datosConf.set(index, Conf);    
                limpiar();
                JOptionPane.showMessageDialog(null,"Configuracion modificada");
            }
            else
                JOptionPane.showMessageDialog(null,"Campos vacios");
        }
        else
            JOptionPane.showMessageDialog(null,"Selecciona la fila a modificar");
    }
    public void limpiar()
    {
        TCodigo.setText("");
        TDispositivo.setText("");
        TUsuario.setText("");
        TContraseña.setText("");
        TIp.setText("");
        TMascara.setText("");
        TConectado.setText("");
    }

    public void seleccion()
    {
        tablaConf.setOnMouseClicked((MouseEvent event)->{
            if(event.getClickCount()>0)
            {
                if(tablaConf.getSelectionModel().getSelectedItem()!=null)
                {
                    Tabla aux=tablaConf.getSelectionModel().getSelectedItem();
                    TCodigo.setText(aux.getCodigo());
                    TUsuario.setText(aux.getUsuario());
                    TDispositivo.setText(aux.getDispositivo());
                    TContraseña.setText(aux.getContraseña());
                    TIp.setText(aux.getIp());
                    TMascara.setText(aux.getMascara());
                    TConectado.setText(aux.getConectado());
                }
            }
        });
    }
    @FXML void menuPrincipal(ActionEvent ev)
    {
        vt.menuPrincipal(ev);
    }
}
