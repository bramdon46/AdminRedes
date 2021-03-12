/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fallas;

import static inventario.InventarioController.datosProducto;
import inventario.producto;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;
import ventanas.ventana;

/**
 * FXML Controller class
 *
 * @author Rubert
 */
public class FallasController implements Initializable {
    @FXML private TableView<falla> tblFallas=new TableView();
    @FXML private TableColumn <falla, String> dispositivillo;
    @FXML private TableColumn <falla, String> fallita;
    @FXML TextField txtDispo;
    @FXML TextArea txtDescrFalla;
    @FXML TextField busacarFalla;
    
    public static ObservableList<falla> datosFalla=FXCollections.observableArrayList(    );
    
    FilteredList<falla> FiltroDatosFalla=new FilteredList<>(datosFalla, c -> true);
    
    ventana vt=new ventana();
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        dispositivillo.setCellValueFactory(new PropertyValueFactory<>("dispositivillo"));
        fallita.setCellValueFactory(new PropertyValueFactory<>("fallita"));
        //buscador();
        select();
        
    }   
    
    public void buscador()
    {
        busacarFalla.textProperty().addListener((observable,oldvalue,newValue)->{
            FiltroDatosFalla.setPredicate(pro->{ 
                if(newValue==null||newValue.isEmpty())
                    return true;
                String LowerCaseFilter=newValue.toLowerCase();
                if(pro.getDispo().toLowerCase().indexOf(LowerCaseFilter) !=-1)
                    return true;
                else if(pro.getFalla().toLowerCase().indexOf(LowerCaseFilter) !=-1)
                    return true;
                else
                return false;
            });
        });
        SortedList<falla> sortedData = new SortedList<>(FiltroDatosFalla);
        sortedData.comparatorProperty().bind(tblFallas.comparatorProperty());
        tblFallas.setItems(sortedData);
    }

    
    @FXML private void nuevaFalla(ActionEvent ev){
        if(!txtDescrFalla.getText().equals("") && !txtDispo.getText().equals(""))
        {
            datosFalla.add( new falla( txtDispo.getText(), txtDescrFalla.getText()));
            tblFallas.setItems(datosFalla);
            JOptionPane.showMessageDialog(null,"Inventario actualizado");
            limpiar();
        }
        else
            JOptionPane.showMessageDialog(null,"Campos vacios");
    }
    
    @FXML private void editarFalla(ActionEvent ev) {
        if(tblFallas.getSelectionModel().getSelectedIndex()>=0)
        {
            int index=tblFallas.getSelectionModel().getSelectedIndex();
            if(!txtDescrFalla.getText().equals("") && !txtDispo.getText().equals(""))
            {
                falla pro=datosFalla.get(index);
                pro.setFalla(txtDescrFalla.getText());
                pro.setDispositivo(txtDispo.getText());
               
                limpiar();
                JOptionPane.showMessageDialog(null,"Fallas actualizado");
            }
            else{
                JOptionPane.showMessageDialog(null,"Campos vacios");
            }
        }
        else{
            JOptionPane.showMessageDialog(null,"Selecciona la fila a modificar");
        }
    }
    
    @FXML private void volverMenu(ActionEvent ev) {
        vt.menuPrincipal(ev);
    }
    
    public void select () {
        tblFallas.setOnMouseClicked((MouseEvent event)->{
            if(event.getClickCount()>0)
            {
                if(tblFallas.getSelectionModel().getSelectedItem()!=null)
                {
                    falla aux=tblFallas.getSelectionModel().getSelectedItem();
                    txtDispo.setText(aux.getDispo());
                    txtDescrFalla.setText(aux.getFalla());
                }
            }
        });
    }
    
    public void limpiar() {
        txtDescrFalla.setText("");
        txtDispo.setText("");
    }
    
}
