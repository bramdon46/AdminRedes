
package RegistroFallas;

import static Fallas.FallasController.datosFalla;
import Fallas.falla;
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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;
import ventanas.ventana;


public class FallasRegistroController implements Initializable {

    @FXML
    private TableView<fallas> table;

    @FXML
    private TableColumn<fallas, String> dispo;

    @FXML
    private TableColumn<fallas, String> falla;
    
    @FXML
    private TextField txt_dispo;

    @FXML
    private TextArea txt_falla;

    @FXML
    private TextField txt_buscar;
    
    ObservableList<fallas> dFallas = FXCollections.observableArrayList();
    
    FilteredList<fallas> FiltroFallas=new FilteredList<>(dFallas, b -> true);
            
    ventana vt=new ventana();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        falla.setCellValueFactory(new PropertyValueFactory<>("falla"));
        dispo.setCellValueFactory( new PropertyValueFactory<>("dispo"));
        //table.setItems(dFallas);
        buscador();
        select();
    } 
    
    @FXML private void nuevaFalla(ActionEvent ev){
        //System.out.println(txt_dispo.getText());
        //System.out.println(txt_falla.getText());
        if(!txt_dispo.getText().equals("") && !txt_falla.getText().equals("")){
            dFallas.add(new fallas(txt_dispo.getText(), txt_falla.getText() ));
            //table.refresh();
        }
        
    }
    
    public void select () {
        table.setOnMouseClicked((MouseEvent event)->{
            if(event.getClickCount()>0)
            {
                if(table.getSelectionModel().getSelectedItem()!=null)
                {
                    fallas aux = table.getSelectionModel().getSelectedItem();
                    txt_dispo.setText(aux.getDispo());
                    txt_falla.setText(aux.getFalla());
                }
            }
        });
    }
    
    @FXML private void editarFalla (ActionEvent ev) {
        if(table.getSelectionModel().getSelectedIndex()>=0)
        {
            int index=table.getSelectionModel().getSelectedIndex();
            if(!txt_falla.getText().equals("") && !txt_dispo.getText().equals(""))
            {
                fallas pro=dFallas.get(index);
                pro.setFalla(txt_falla.getText());
                pro.setDispositivo(txt_dispo.getText());
                //table.refresh();
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
    
    public void limpiar() {
        txt_dispo.setText("");
        txt_falla.setText("");
        
    }
    
    @FXML private void volverMenu (ActionEvent ev) {
        vt.menuPrincipal(ev);
    }
    
    public void buscador()
    {
        txt_buscar.textProperty().addListener((observable,oldvalue,newValue)->{
            FiltroFallas.setPredicate(pro->{ 
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
        SortedList<fallas> sortedData = new SortedList<>(FiltroFallas);
        sortedData.comparatorProperty().bind(table.comparatorProperty());
        table.setItems(sortedData);
    }
    
}
