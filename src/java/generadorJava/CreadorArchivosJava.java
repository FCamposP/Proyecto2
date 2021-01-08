/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editor;

import gestordearchivos.Archivo;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author fabry
 */
public class CreadorArchivosJava {
    
    public void crearArchivosJava(ArrayList<Archivo> archivos, String direccion) throws IOException{
        direccion="/user01/project01/uml/";
        String ubicacionFisica="F:/facompiler/";
        String dirGuardar=ubicacionFisica+direccion;
        
        //crear carpeta
        try {
        crearCarpeta(dirGuardar);
        for (Archivo archivo : archivos) {
            File nuevoFile = new File(dirGuardar+archivo.getNombre());
            BufferedWriter bw = new BufferedWriter(new FileWriter(nuevoFile));
            bw.write(archivo.getCodigo());
        
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
