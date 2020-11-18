
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
import subirXmi.Utils;


@Named(value = "fileUploadMBean")
@Dependent
public class FileUploadMBean implements Serializable
{

 
   
     private static final long serialVersionUID = 1L;
    private Part file;
    private String message;
    
    
     public static final int BUFFER_SIZE = 1024;

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }
   
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    
    public void uploadFile() throws IOException 
    {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        FacesContext context = FacesContext.getCurrentInstance();
        ServletContext servletContext = (ServletContext) context.getExternalContext().getContext();
        String path;
         path = servletContext.getRealPath("");
        boolean fileSuccess = false;
        
        if (file.getSize() > 0) 
        {
            String fileName = Utils.getFileNameFromPart(file);
            
            //destino 
            File outputFile = new File(path + File.separator + "WEB-INF" + File.separator + fileName);
            inputStream = file.getInputStream();
            outputStream = new FileOutputStream(outputFile);
            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead = 0;
            
            while ((bytesRead = inputStream.read(buffer)) != -1)
            {
                outputStream.write(buffer, 0, bytesRead);
            }
            
            if (outputStream != null) 
            {
                outputStream.close();
            }
            
            if (inputStream != null) 
            {
                inputStream.close();
            }
            
            fileSuccess = true;
        }
        
        
        if (fileSuccess)
        {
            System.out.println("File uploaded to : " + path);
      
        } 
        else
        { }

       
    }
    
  
    
}
