package controllers;

import convertidorBDJava.DBConnection;
import convertidorBDJava.DBMetaData;
import convertidorUmlJava.Convertidor;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
      DBConnection conexionfc = new DBConnection();
    private List<String> listaBasesDatos;
    private List<String> tablas;
    
    public ControllerPrincipal() {

    }

    public List<String> getTablas() {
        return tablas;
    }

    public void setTablas(List<String> tablas) {
        this.tablas = tablas;
    }

    
    
    public List<String> getListaBasesDatos() {
        return listaBasesDatos;
    }

    public void setListaBasesDatos(List<String> listaBasesDatos) {
        this.listaBasesDatos = listaBasesDatos;
    }

    
    public void saveArchivo() throws IOException {
        String nombreArchivo = FileUploadMBean.getArchivoSubido().getSubmittedFileName();
        if (nombreArchivo.endsWith(".xmi")) {
            FileUploadMBean.setContenidoArchivo(FileUploadMBean.getArchivoSubido().getInputStream());
        }
    }

    public void generar() throws ParserConfigurationException, IOException, SAXException {

        if (FileUploadMBean.getContenidoArchivo() != null) {
            Convertidor converter = new Convertidor();
            converter.ConvertidorXmi();
        }
//        Model m = getModel("C:/ExtendedPO2.uml");
//        System.out.println(m.getName());
    }

    public void conectarBd() throws SQLException {
        try {
//                String server= ControllerBD.getServer();
//                String port= ControllerBD.getPuerto();
//                String pass= ControllerBD.getPass();
          

            conexionfc.getConnection(ControllerBD.getServer(), ControllerBD.getPuerto(), "", ControllerBD.getUserBD(), ControllerBD.getPass());
            DBMetaData metaData = new DBMetaData(conexionfc.connection);
            List<String> basesd = metaData.getSchemasNames();
            listaBasesDatos=basesd;
            String ojala = "";
        } catch (Exception e) {

        }

    }
    
    public void obtenerTablas(){
        try {
             DBMetaData metaData = new DBMetaData(conexionfc.connection);
             tablas= new ArrayList<String>();
             String baseElegida=ControllerBD.getBaseElegida();
             tablas= metaData.getTablesMetadata(baseElegida);
             String stop="";
        } catch (Exception e) {
        }
    }
}
