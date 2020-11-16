/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author HS19011-Edwin Alexander Hernandez Sanchez
 */
@Named(value = "beanUML")
@SessionScoped
public class BeanUML implements Serializable {
    public static String archivo = "";

    public BeanUML() {
    }
    
    public static String getArchivo() {
        return archivo;
    }

    public static void setArchivo(String archivo) {
        BeanUML.archivo = archivo;
    }
    
    void obtenerCodigoDeEditor(){
        String prueba2=archivo;
    }
    
}
