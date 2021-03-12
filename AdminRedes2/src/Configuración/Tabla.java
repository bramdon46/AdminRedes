/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Configuración;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author zneo1
 */
public class Tabla {
    private final SimpleStringProperty codigo;
    private final SimpleStringProperty dispositivo;
    private final SimpleStringProperty usuario;
    private final SimpleStringProperty contraseña;
    private final SimpleStringProperty ip;
    private final SimpleStringProperty mascara;
    private final SimpleStringProperty conectado;
    
    public Tabla(String Codigo1, String Dis, String Usua, String Contra, String Ip1, String Masc, String Conectado1)
    {
        codigo=new SimpleStringProperty(Codigo1);
        dispositivo=new SimpleStringProperty(Dis);
        usuario=new SimpleStringProperty(Usua);
        contraseña=new SimpleStringProperty(Contra);
        ip=new SimpleStringProperty(Ip1);
        mascara=new SimpleStringProperty(Masc);
        conectado=new SimpleStringProperty(Conectado1);
    }
    
    // 
    public String getCodigo()
    {
        return codigo.get();
    }
    public String getDispositivo()
    {
        return dispositivo.get();
    }
    public String getUsuario()
    {
        return usuario.get();
    }
    public String getContraseña()
    {
        return contraseña.get();
    }
    public String getIp()
    {
        return ip.get();
    }
    public String getMascara()
    {
        return mascara.get();
    }
    public String getConectado()
    {
        return conectado.get();
    }
    
    
    //
    public void setCodigo(String codigo1)
    {
        codigo.set(codigo1);
    }
    public void setDisp(String disp)
    {
        dispositivo.set(disp);
    }
    public void setUsua(String usua)
    {
        usuario.set(usua);
    }
    public void setContra(String contra)
    {
        contraseña.set(contra);
    }
    public void setIp(String Ip1)
    {
        ip.set(Ip1);
    }
    public void setMasc(String Masc)
    {
        mascara.set(Masc);
    }
    public void setConectado(String Conectado1)
    {
        conectado.set(Conectado1);
    }

}

