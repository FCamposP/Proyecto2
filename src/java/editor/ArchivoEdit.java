package editor;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import gestordearchivos.Archivo;
import gestordearchivos.ArchivoBean;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.event.ActionEvent;

/**
 *
 * @author fabry
 */
@Named(value = "archivoEdit")
@SessionScoped
public class ArchivoEdit implements Serializable{

    /**
     * Creates a new instance of ArchivoEdit
     */
    public ArchivoEdit() {
    }
    
    private  String nombreArchivo1;
    private  String contenidoArchivo1;
    private  String nombreArchivo2;
    private  String contenidoArchivo2;
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
    
    
    public String getNombreArchivo1() {
        return nombreArchivo1;
    }

    public void setNombreArchivo1(String nombreArchivo1) {
        this.nombreArchivo1 = nombreArchivo1;
    }

    public String getContenidoArchivo1() {
        return contenidoArchivo1;
    }

    public void setContenidoArchivo1(String contenidoArchivo1) {
        this.contenidoArchivo1 = contenidoArchivo1;
    }

    public String getNombreArchivo2() {
        return nombreArchivo2;
    }

    public void setNombreArchivo2(String nombreArchivo2) {
        this.nombreArchivo2 = nombreArchivo2;
    }

    public String getContenidoArchivo2() {
        return contenidoArchivo2;
    }

    public void setContenidoArchivo2(String contenidoArchivo2) {
        this.contenidoArchivo2 = contenidoArchivo2;
    }

   
    
    public void crearArchivo() throws IOException{
        String ruta = "F:/facompiler/archivo7.txt";
        File archivo = new File(ruta);
        BufferedWriter bw;
        if(archivo.exists()) {
            bw = new BufferedWriter(new FileWriter(archivo));
            bw.write("El fichero de texto ya estaba creado.");
        } else {
            bw = new BufferedWriter(new FileWriter(archivo));
            bw.write("Acabo de crear el fichero de texto.");
        }
        bw.close();
    }
    

    private int ObtenerIndice( String nombreClase){
     
        ArrayList<Archivo> archivos= new ArrayList<>();
        archivos=ArchivoBean.getClases();
        int indice=-1;
        for (int i = 0; i < archivos.size(); i++) {
            if(archivos.get(i).getNombre().equals(nombreClase)){
                indice=i;
                break;
            }
        }
        return indice;
    }

    

        public void guardarEdicion(){
        String cambios= contenidoArchivo1;

        ArchivoBean.actualizaClaseEditada(contenidoArchivo1, ObtenerIndice( nombreArchivo1));
                  String otoro=text;
        String ojala=""; 
        
    }
    
        public void editarArchivo(ActionEvent event) {
        String nombreArchivo;
       
        boolean found = false;
        ArrayList<Archivo> clases = new ArrayList<Archivo>();
        UIComponent component = event.getComponent();
        nombreArchivo = (String) component.getAttributes().get("value");
        
        clases=ArchivoBean.getClases();

        for (Archivo clase : clases) {
            if(clase.getNombre().equals(nombreArchivo)){
                found=true;
                contenidoArchivo1=(clase.getCodigo());
                nombreArchivo1=(nombreArchivo);
            }
        }
        if(!found){
            contenidoArchivo1=("Archivo no encontrado");
        }

    }

}
