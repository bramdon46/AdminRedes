/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dispositivos;



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
 * @author chino
 */
public class DispositivosController implements Initializable {

    ventana vt=new ventana();
    
    @FXML private TableView<dispo> tablaDispositivos=new TableView();
    
    @FXML TableColumn<dispo, String> id; 
    @FXML TableColumn<dispo, String> nombre; 
    @FXML TableColumn<dispo, String> locadispositivo;
    @FXML TextField idtext;
    @FXML TextField nombretext;
    @FXML TextField locatext;
    @FXML TextField buscartext;
     public static ObservableList<dispo> datos=FXCollections.observableArrayList(    );
    FilteredList<dispo> FiltroDatos=new FilteredList<>(datos, b -> true);

      @Override
    public void initialize(URL url, ResourceBundle rb) {
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        locadispositivo.setCellValueFactory(new PropertyValueFactory<>("loca_dispositivo"));
        buscador();
        seleccion();
    }    
    
    public void buscador()
    {
        buscartext.textProperty().addListener((observable,oldvalue,newValue)->{
            FiltroDatos.setPredicate(pro->{ 
                if(newValue==null||newValue.isEmpty())
                    return true;
                String LowerCaseFilter=newValue.toLowerCase();
                if(pro.getId().toLowerCase().indexOf(LowerCaseFilter) !=-1)
                    return true;
                else if(pro.getNombre().toLowerCase().indexOf(LowerCaseFilter) !=-1)
                    return true;
                else if(pro.getLocadispositivo().toLowerCase().indexOf(LowerCaseFilter) !=-1)
                    return true;
                else
                return false;
            });
        });
        SortedList<dispo> sortedData = new SortedList<>(FiltroDatos);
        sortedData.comparatorProperty().bind(tablaDispositivos.comparatorProperty());
        tablaDispositivos.setItems(sortedData);
    }
    
    
    /**
     * Initializes the controller class.
     */
    
    @FXML private void menuPrincipal(ActionEvent ev)
    {
        vt.menuPrincipal(ev);
    }
    
    @FXML private void Buscador(ActionEvent ev)
    {
        
    }
     @FXML private void AgregarNuevo(ActionEvent ev)
    {
          if(!idtext.getText().equals("")
          && !nombretext.getText().equals("")
          && !locatext.getText().equals(""))
        {
            datos.add( new dispo
        ( idtext.getText(),
          nombretext.getText(),
          locatext.getText() ) );
            JOptionPane.showMessageDialog(null,"Inventario actualizado");
            limpiar();
        }
        else
            JOptionPane.showMessageDialog(null,"Campos vacios");
    }
     
      @FXML private void Modificar(ActionEvent ev)
    {
        
    }
    public void seleccion()
    {
        tablaDispositivos.setOnMouseClicked((MouseEvent event)->{
            if(event.getClickCount()>0)
            {
                if(tablaDispositivos.getSelectionModel().getSelectedItem()!=null)
                {
                    dispo aux=tablaDispositivos.getSelectionModel().getSelectedItem();
                    idtext.setText(aux.getId());
                    nombretext.setText(aux.getNombre());
                    locatext.setText(aux.getLocadispositivo());
                    
                }
            }
        });
    }   

    private void limpiar() {
       idtext.setText("");
       nombretext.setText("");
       locatext.setText("");
        
    }
    
}
