
package RegistroFallas;

import javafx.beans.property.SimpleStringProperty;


public class fallas {

    private final SimpleStringProperty id_dispo;
    private final SimpleStringProperty id_descrFalla;
    
    public fallas(String dispositivo, String descripcionFalla)
    {
        
        id_dispo = new SimpleStringProperty(dispositivo);
        id_descrFalla = new SimpleStringProperty(descripcionFalla);
    }
    
    public String getDispo()
    {
        return id_dispo.get();
    }
    public String getFalla()
    {
        return id_descrFalla.get();
    }
    
    
    public void setDispositivo(String dispo)
    {
        id_dispo.set(dispo);
    }
    public void setFalla(String fallaD)
    {
        id_descrFalla.set(fallaD);
    }
    
}
