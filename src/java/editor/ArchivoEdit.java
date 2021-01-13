package editor;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import generadorJava.CreadorArchivosJava;
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
        try {
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
        } catch (Exception e) {
        }

    }
    

    private int ObtenerIndice( String nombreClase, int opcion){
        int indice=-1;
        int opo=opcion;
        try {
                    ArrayList<Archivo> archivos= new ArrayList<>();
                    if(opo==1){
                           archivos=ArchivoBean.getClases();
                    }else{
                           archivos=ArchivoBean.getClases2();
                    }
     
     
        for (int i = 0; i < archivos.size(); i++) {
            if(archivos.get(i).getNombre().equals(nombreClase)){
                indice=i;
                break;
            }
        }
        } catch (Exception e) {
        }

        return indice;
    }

    

        public void guardarEdicion() throws IOException{
        //a sustituir por datos tomados del usuario
            try {
                 String direccion="/user01/project01/uml/";
            
        String cambios= contenidoArchivo1;

        ArchivoBean.actualizaClaseEditada(contenidoArchivo1, ObtenerIndice( nombreArchivo1,1));
                  String otoro=text;
        String ojala=""; 
        
        //dirección de archivos obtenido de Principal
            CreadorArchivosJava editorJava= new CreadorArchivosJava();
            
            editorJava.editarArchivoJava(direccion+nombreArchivo1, cambios);
            } catch (Exception e) {
            }
       
        
    }
    
        public void editarArchivo(ActionEvent event) {
            try {
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

            } catch (Exception e) {
            }
            
      
    }
        public void guardarEdicion2() throws IOException{
        //a sustituir por datos tomados del usuario
            try {
                 String direccion="/user01/project01/bd/";
            
        String cambios= contenidoArchivo2;

        ArchivoBean.actualizaClaseEditada2(contenidoArchivo2, ObtenerIndice( nombreArchivo2,2));
                  String otoro=text;
        String ojala=""; 
        
        //dirección de archivos obtenido de Principal
            CreadorArchivosJava editorJava= new CreadorArchivosJava();
            
            editorJava.editarArchivoJava(direccion+nombreArchivo2, cambios);
            } catch (Exception e) {
            }
       
        
    }
    
        public void editarArchivo2(ActionEvent event) {
            try {
                  String nombreArchivo;
       
        boolean found = false;
        ArrayList<Archivo> clases = new ArrayList<Archivo>();
        UIComponent component = event.getComponent();
        nombreArchivo = (String) component.getAttributes().get("value");
        
        clases=ArchivoBean.getClases2();

        for (Archivo clase : clases) {
            if(clase.getNombre().equals(nombreArchivo)){
                found=true;
                contenidoArchivo2=(clase.getCodigo());
                nombreArchivo2=(nombreArchivo);
            }
        }
        if(!found){
            contenidoArchivo2=("Archivo no encontrado");
        }

            } catch (Exception e) {
            }
            
      
    }

}
