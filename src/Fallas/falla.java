/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fallas;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Rubert
 */

public class falla {
    private final SimpleStringProperty id_dispo;
    private final SimpleStringProperty id_descr;
    
    public falla(String dispo, String fallaD)
    {
        id_dispo=new SimpleStringProperty(dispo);
        id_descr=new SimpleStringProperty(fallaD);
    }
    
    public String getDispo()
    {
        return id_dispo.get();
    }
    public String getFalla()
    {
        return id_descr.get();
    }
    
    public void setDispositivo(String dispo)
    {
        id_dispo.set(dispo);
    }
    public void setFalla(String fallaD)
    {
        id_descr.set(fallaD);
    }
}
