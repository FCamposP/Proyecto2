/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generadorJava;

import gestordearchivos.Archivo;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author fabry
 */
public class CreadorArchivosJava {
    
         private   String ubicacionFisica="F:/facompiler/";
    
    public void editarArchivoJava(String ubicacion, String contenido) throws IOException{
      //  String direccion="/user01/project01/uml/";
        
        FileWriter actualizar= new FileWriter(ubicacionFisica+ubicacion);
        PrintWriter pw= new PrintWriter(actualizar);
        pw.println("");
        pw.println(contenido);
        actualizar.close();
        
    }
    
    public void crearArchivosJava(ArrayList<Archivo> archivos, String direccion) throws IOException{
      

        String dirGuardar=ubicacionFisica+direccion;
        
        //crear carpeta
        try {
        crearCarpeta(dirGuardar);
        
        FileWriter fichero = null;
        PrintWriter pw = null;
        
        
        
        for (Archivo archivo : archivos) {
           // String nombreFile = ""; 
          //  nombreFile=archivo.getNombre();
            
          fichero= new FileWriter(dirGuardar+archivo.getNombre());
          pw= new PrintWriter(fichero);
          pw.println(archivo.getCodigo());
          fichero.close();
            
//            File nuevoFile = new File(dirGuardar+archivo.getNombre());
//            BufferedWriter bw = new BufferedWriter(new FileWriter(nuevoFile));
         //   bw.write(archivo.getCodigo());
        
        }
        } catch (Exception e) {
        }

    }
    
    public void crearCarpeta(String direccion){
                File directorio = new File(direccion);
        if (!directorio.exists()) {
            if (directorio.mkdirs()) {
                System.out.println("Directorio creado");
            } else {
                System.out.println("Error al crear directorio");
            }
        }
    }
    
}
