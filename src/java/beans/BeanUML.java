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
    private String archivo ;

    public BeanUML() {
    }
    
    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }
    
    void obtenerCodigoDeEditor(){
        String prueba2=archivo;
    }
    
}
