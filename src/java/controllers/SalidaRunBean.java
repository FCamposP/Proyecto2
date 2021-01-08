/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import runCode.CompiladorEjecutorJava;

/**
 *
 * @author fabry
 */
@Named(value = "salidaRunBean")
@SessionScoped  
public class SalidaRunBean implements Serializable {

    /**
     * Creates a new instance of SalidaRunBean
     */
 
        private String mensajeCompilando1;
        private String mensajeCompilando2;
        private String resultadoUml;
        private String resultadoBD;
        private String msjEjecutando1;
        private String msjEjecutando2; 
        private String msjEjecucion1;
        private String msjEjecucion2;
        
    public SalidaRunBean() {
    }

    public String getMsjEjecutando1() {
        return msjEjecutando1;
    }

    public void setMsjEjecutando1(String msjEjecutando1) {
        this.msjEjecutando1 = msjEjecutando1;
    } 

    public String getMsjEjecutando2() {
        return msjEjecutando2;
    }

    public void setMsjEjecutando2(String msjEjecutando2) {
        this.msjEjecutando2 = msjEjecutando2;
    }
    
    

    public String getMensajeCompilando1() {
        return mensajeCompilando1;
    }

    public void setMensajeCompilando1(String mensajeCompilando1) {
        this.mensajeCompilando1 = mensajeCompilando1;
    }

    public String getMensajeCompilando2() {
        return mensajeCompilando2;
    }

    public void setMensajeCompilando2(String mensajeCompilando2) {
        this.mensajeCompilando2 = mensajeCompilando2;
    }

    public String getResultadoBD() {
        return resultadoBD;
    }

    public void setResultadoBD(String resultadoBD) {
        this.resultadoBD = resultadoBD;
    }

    public String getMsjEjecucion1() {
        return msjEjecucion1;
    }

    public void setMsjEjecucion1(String msjEjecucion1) {
        this.msjEjecucion1 = msjEjecucion1;
    }

    public String getMsjEjecucion2() {
        return msjEjecucion2;
    }

    public void setMsjEjecucion2(String msjEjecucion2) {
        this.msjEjecucion2 = msjEjecucion2;
    }
    
    
    
    
        public String getResultadoUml() {
        return resultadoUml;
    }

    public void setResultadoUml(String resultadoUml) {
        this.resultadoUml = resultadoUml;
    }
    
    
    public void compilarEjecutar() 
    {
        try 
        {  
            CompiladorEjecutorJava compilerJava = new CompiladorEjecutorJava();
            mensajeCompilando1="Compilando ...";
 
            String resultadoCompilacion="";
            resultadoCompilacion=compilerJava.ejecutarArchivos("","javac");
            if(resultadoCompilacion=="0"){
                resultadoUml="\nCompilación realizada con éxito";
            }else{
                resultadoUml="\n"+resultadoCompilacion;
            }
            
            if(resultadoCompilacion=="0"){
             msjEjecutando1="Ejecutando ...";   
                
                String resultadoExec="";
                resultadoExec=compilerJava.ejecutarArchivos("","java");
                msjEjecucion1=resultadoExec;
            } 
            
        } 
        catch (Exception e)
        {
            // Excepciones si hay algún problema al arrancar el ejecutable o al leer su salida.*/
            e.printStackTrace();
        }
    }
    
    
    
}
