
package controllers;

import generadorJava.Convertidor;
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
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import subirXmi.FileValidator;
import subirXmi.Utils;


@Named(value = "principalMBean")
@ViewScoped
public class PrincipalMBean implements Serializable {

    /**
     * Creates a new instance of PrincipalMBean
     */
    public PrincipalMBean() {
    }
    
    public void saveArchivo() throws IOException{
        String nombreArchivo=FileUploadMBean.getArchivoSubido().getSubmittedFileName();
        if(nombreArchivo.endsWith(".xmi")){
            FileUploadMBean.setContenidoArchivo(FileUploadMBean.getArchivoSubido().getInputStream());
        }
    }
        public void generar() throws ParserConfigurationException, IOException, SAXException {

           if(FileUploadMBean.getContenidoArchivo()!=null){
                  Convertidor converter= new Convertidor();
        converter.ConvertidorXmi();
           }        
//        Model m = getModel("C:/ExtendedPO2.uml");
//        System.out.println(m.getName());
    }
}
