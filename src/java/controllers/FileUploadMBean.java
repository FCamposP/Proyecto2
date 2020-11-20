
package controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.enterprise.context.Dependent;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import subirXmi.FileValidator;
import subirXmi.Utils;


@Named(value = "fileUploadMBean")
@ViewScoped
public class FileUploadMBean implements Serializable
{

 
   
     private static final long serialVersionUID = 1L;
    private Part file;
    private String message;
    private static Part archivoSubido;
    private static InputStream contenidoArchivo;

    public static InputStream getContenidoArchivo() {
        return contenidoArchivo;
    }

    public static void setContenidoArchivo(InputStream contenidoArchivo) {
        FileUploadMBean.contenidoArchivo = contenidoArchivo;
    }
    
    
     public static final int BUFFER_SIZE = 1024;

    public static Part getArchivoSubido() {
        return archivoSubido;
    }

    public static void setArchivoSubido(Part archivoSubido) {
        FileUploadMBean.archivoSubido = archivoSubido;
    }

     
    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
        archivoSubido=this.file;
    }
   
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    
    public void uploadFile() throws IOException 
    {
        try{
            FileValidator validador= new FileValidator();
            if(validador.ValidarEstenxion()){
                
            }
//                 InputStream inputStream = null;
//        OutputStream outputStream = null;
//        FacesContext context = FacesContext.getCurrentInstance();
//        ServletContext servletContext = (ServletContext) context.getExternalContext().getContext();
//        String path;
//         path = servletContext.getRealPath("");
//        boolean fileSuccess = false;
//        
//        if (archivoSubido.getSize() > 0) 
//        {
//            String fileName = Utils.getFileNameFromPart(archivoSubido);
//            
//            //destino 
//            File outputFile = new File(path + File.separator + "WEB-INF" + File.separator + fileName);
//            inputStream = archivoSubido.getInputStream();
//            outputStream = new FileOutputStream(outputFile);
//            byte[] buffer = new byte[BUFFER_SIZE];
//            int bytesRead = 0;
//            
//            while ((bytesRead = inputStream.read(buffer)) != -1)
//            {
//                outputStream.write(buffer, 0, bytesRead);
//            }
//            
//            if (outputStream != null) 
//            {
//                outputStream.close();
//            }
//            
//            if (inputStream != null) 
//            {
//                inputStream.close();
//            }
//            
//            fileSuccess = true;
//        }
//        
//        
//        if (fileSuccess)
//        {
//            System.out.println("File uploaded to : " + path);
//      
//        } 
//        else
//        { }
  
        }catch(Exception ex){
            
        }
 
       
    }
    
  
    
}
