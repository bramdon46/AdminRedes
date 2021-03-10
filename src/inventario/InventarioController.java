/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
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
 * @author bramdon
 */
public class InventarioController implements Initializable {

    @FXML private TableView<producto> tablaInventario=new TableView();
    @FXML TableColumn<producto, String> id_producto; 
    @FXML TableColumn<producto, String> nombre_producto; 
    @FXML TableColumn<producto, String> marca_producto;  
    @FXML TableColumn<producto, String> cantidad_producto;
    @FXML TextField busca;
    @FXML TextField codigoPro;
    @FXML TextField nombrePro;
    @FXML TextField marcaPro;
    @FXML TextField cantiPro;
    public static ObservableList<producto> datosProducto=FXCollections.observableArrayList(    );
    FilteredList<producto> FiltroDatosProducto=new FilteredList<>(datosProducto, b -> true);
    ventana vt=new ventana();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        id_producto.setCellValueFactory(new PropertyValueFactory<>("id_producto"));
        nombre_producto.setCellValueFactory(new PropertyValueFactory<>("nombre_producto"));
        marca_producto.setCellValueFactory(new PropertyValueFactory<>("marca_producto"));
        cantidad_producto.setCellValueFactory(new PropertyValueFactory<>("cantidad_producto"));
        buscador();
        seleccion();
    }    
    
    public void buscador()
    {
        busca.textProperty().addListener((observable,oldvalue,newValue)->{
            FiltroDatosProducto.setPredicate(pro->{ 
                if(newValue==null||newValue.isEmpty())
                    return true;
                String LowerCaseFilter=newValue.toLowerCase();
                if(pro.getId_producto().toLowerCase().indexOf(LowerCaseFilter) !=-1)
                    return true;
                else if(pro.getNombre_producto().toLowerCase().indexOf(LowerCaseFilter) !=-1)
                    return true;
                else if(pro.getMarca_producto().toLowerCase().indexOf(LowerCaseFilter) !=-1)
                    return true;
                else
                return false;
            });
        });
        SortedList<producto> sortedData = new SortedList<>(FiltroDatosProducto);
        sortedData.comparatorProperty().bind(tablaInventario.comparatorProperty());
        tablaInventario.setItems(sortedData);
    }
    
    @FXML private void nuevo(ActionEvent ev)
    {
        if(!codigoPro.getText().equals("") && !nombrePro.getText().equals("") && !marcaPro.getText().equals("") && !cantiPro.getText().equals(""))
        {
            datosProducto.add( new producto( codigoPro.getText(), nombrePro.getText(), marcaPro.getText(), cantiPro.getText() ) );
            JOptionPane.showMessageDialog(null,"Inventario actualizado");
            limpiar();
        }
        else
            JOptionPane.showMessageDialog(null,"Campos vacios");
    }
    @FXML private void modificar(ActionEvent ev)
    {
        if(tablaInventario.getSelectionModel().getSelectedIndex()>=0)
        {
            int index=tablaInventario.getSelectionModel().getSelectedIndex();
            if(!codigoPro.getText().equals("") && !nombrePro.getText().equals("") && !marcaPro.getText().equals("") && !cantiPro.getText().equals(""))
            {
                producto pro=datosProducto.get(index);
                pro.setNombre_producto(nombrePro.getText());
                pro.setMarca_producto(marcaPro.getText());
                pro.setCantidad_producto(cantiPro.getText());
                datosProducto.set(index, pro);
                limpiar();
                JOptionPane.showMessageDialog(null,"Inventario modificado");
            }
            else
                JOptionPane.showMessageDialog(null,"Campos vacios");
        }
        else
            JOptionPane.showMessageDialog(null,"Selecciona la fila a modificar");
    }
    @FXML private void menuPrincipal(ActionEvent ev)
    {
        vt.menuPrincipal(ev);
    }
    
    public void limpiar()
    {
        codigoPro.setText("");
        nombrePro.setText("");
        marcaPro.setText("");
        cantiPro.setText("");
    }
    public void seleccion()
    {
        tablaInventario.setOnMouseClicked((MouseEvent event)->{
            if(event.getClickCount()>0)
            {
                if(tablaInventario.getSelectionModel().getSelectedItem()!=null)
                {
                    producto aux=tablaInventario.getSelectionModel().getSelectedItem();
                    codigoPro.setText(aux.getId_producto());
                    nombrePro.setText(aux.getNombre_producto());
                    marcaPro.setText(aux.getMarca_producto());
                    cantiPro.setText(aux.getCantidad_producto());
                }
            }
        });
    }
}
