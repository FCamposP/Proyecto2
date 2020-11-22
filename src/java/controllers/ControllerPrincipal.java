
package controllers;

import convertidorBDJava.DBConnection;
import convertidorBDJava.DBMetaData;
import convertidorUmlJava.Convertidor;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import subirXmi.FileValidator;

@Named(value = "principalMBean")
@ViewScoped
public class ControllerPrincipal implements Serializable {

    /**
     * Creates a new instance of PrincipalMBean
     */
    public ControllerPrincipal() {
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
        
        public void conectarBd() throws SQLException{
            try {
                          DBConnection.getConnection(ControllerBD.getServer(), ControllerBD.getPuerto(),"", ControllerBD.getUserBD(), ControllerBD.getPass());
               ControllerBD.setBasesDatos(DBMetaData.getSchemasNames());
               String ojala="";
            } catch (Exception e) {
                
            }
          
        }
}
