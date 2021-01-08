package controllers;

import subirXmi.FileUploadMBean;
import gestordearchivos.Archivo;
import gestordearchivos.ArchivoBean;
import convertidorBDJava.BaseTablas;
import convertidorBDJava.DBColumn;
import convertidorBDJava.DBConnection;
import convertidorBDJava.DBMetaData;
import convertidorBDJava.DtoTabla;
import convertidorBDJava.Funciones;
import datos.clases.Atributo;
import datos.clases.Clase;
import convertidorUmlJava.TransformadorXmiJava;
import editor.ArchivoEdit;
import generadorJava.CreadorArchivosJava;
import generadorJava.GeneradorJava;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedProperty;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

@Named(value = "principalMBean")
@SessionScoped
public class ControllerPrincipal implements Serializable {

    /**
     * Creates a new instance of PrincipalMBean
     */
    //otros beans
    @ManagedProperty("#{fileUploadMBean}")
    private FileUploadMBean fileUpload;
    @ManagedProperty("#{archivoEdit}")
    private ArchivoEdit archivoEdit;

    public FileUploadMBean getFileUpload() {
        return fileUpload;
    }

    public void setFileUpload(FileUploadMBean fileUpload) {
        this.fileUpload = fileUpload;
    }

    //fin otros beans
    DBConnection conexionfc = new DBConnection();
    private List<String> listaBasesDatos;
    private List<String> tablas;
    private List<DtoTabla> tablasMostrar;
    private List<BaseTablas> tablasCompletas;
    private boolean tablasTodas;
    private String mensajet;


    
    public ControllerPrincipal() {
        String prueba = "";
    }


    
    
    

    public String getMensajet() {
        return mensajet;
    }

    public void setMensajet(String mensajet) {
        this.mensajet = mensajet;
    }

    public boolean isTablasTodas() {
        return tablasTodas;
    }

    public void setTablasTodas(boolean tablasTodas) {
        this.tablasTodas = tablasTodas;
    }

    public List<BaseTablas> getTablasCompletas() {
        return tablasCompletas;
    }

    public void setTablasCompletas(List<BaseTablas> tablasCompletas) {
        this.tablasCompletas = tablasCompletas;
    }

    public List<DtoTabla> getTablasMostrar() {
        return tablasMostrar;
    }

    public void setTablasMostrar(List<DtoTabla> tablasMostrar) {
        this.tablasMostrar = tablasMostrar;
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
        String nombreArchivo = fileUpload.getArchivoSubido().getSubmittedFileName();
        if (nombreArchivo.endsWith(".xmi")) {
            fileUpload.setContenidoArchivo(fileUpload.getArchivoSubido().getInputStream());

            this.setMensajet("Archivo leído con éxito");

        }
    }

    public void generarCodigo() throws ParserConfigurationException, IOException, SAXException {

        //a sustituir por datos tomados del usuario
        String direccion="/user01/project01/uml/";
        
        if (fileUpload.getContenidoArchivo() != null) {
            ArrayList<Archivo> archivos = new ArrayList<Archivo>();
            TransformadorXmiJava converter = new TransformadorXmiJava();
            archivos = converter.TransformarXmiToJava();
            
            //creación de los archivos fisicos
            CreadorArchivosJava creador= new CreadorArchivosJava();
            creador.crearArchivosJava(archivos, direccion);
         
            //archivos a mostrar en pantalla
            ArchivoBean.setClases(archivos);
        }
//        Model m = getModel("C:/ExtendedPO2.uml");
//        System.out.println(m.getName());
    }

    public void conectarBd() throws SQLException {
        try {
            conexionfc.getConnection(ControllerBD.getServer(), ControllerBD.getPuerto(), "", ControllerBD.getUserBD(), ControllerBD.getPass());
            DBMetaData metaData = new DBMetaData(conexionfc.connection);
            List<String> basesd = metaData.getSchemasNames();
            listaBasesDatos = basesd;
            String ojala = "";
        } catch (Exception e) {

        }

    }

    public void obtenerTablas() {
        try {
            DBMetaData metaData = new DBMetaData(conexionfc.connection);

            String baseElegida = ControllerBD.getBaseElegida();
            this.setTablasCompletas(metaData.getTablesMetadata(baseElegida));
            this.setTablasMostrar(new ArrayList<DtoTabla>());

            for (BaseTablas tabla : tablasCompletas) {
                this.tablasMostrar.add(tabla.getTabla());
            }
            String stop = "";
        } catch (Exception e) {
        }
    }

    public void elegirTodos() {

        for (DtoTabla dto : tablasMostrar) {
            if (this.isTablasTodas()) {
                dto.setElegido(true);
            } else {
                dto.setElegido(false);
            }

        }
    }

    public void generarClasesTablas() {
        ArrayList<Clase> clasesGenerar = new ArrayList<Clase>();
        Funciones fun = new Funciones();
        for (DtoTabla tabla : tablasMostrar) {
            if (tabla.isElegido()) {
                BaseTablas tablaGenerar = fun.buscarBaseTablas(tablasCompletas, tabla);
                List<DBColumn> columnasGenerar = tablaGenerar.getColumnas();
                Clase nuevaClase = new Clase();
                nuevaClase.setNombre(tabla.getNombreTabla());

                for (DBColumn col : columnasGenerar) {
                    Atributo nuevoAtributo = new Atributo();
                    nuevoAtributo.setNombre(col.name);
                    nuevoAtributo.setNombreTipoPropiedad(col.type);

                    nuevaClase.adicionarAtributo(nuevoAtributo);
                }
                clasesGenerar.add(nuevaClase);
            }
        }
        GeneradorJava creadorJava = new GeneradorJava();
        creadorJava.CrearArchivos(clasesGenerar, 1);

    }

    public void actualizarCadaTabla(DtoTabla act) {
        boolean sf = false;
        boolean otroo = false;
        for (DtoTabla dto : tablasMostrar) {
            if (dto == act) {
                //     dto=act;
                sf = dto.isElegido();
                otroo = !sf;
                dto.setElegido(otroo);
            }
        }
    }

    public void limpiarTablas() {
        this.setTablasMostrar(new ArrayList<DtoTabla>());
        //tablasMostrar.clear();
        this.setTablasCompletas(new ArrayList<BaseTablas>());
        //s   tablasCompletas.clear();
        this.setTablasTodas(false);
        ArchivoBean.code = "";
        ArchivoBean.setClases(new ArrayList<Archivo>());
    }

//    private static final long serialVersionUID = 1L;	
//	private boolean programador;
// 
//	public boolean isProgramador() {
//		return programador;
//	}
//	public void setProgramador(boolean programador) {
//		this.programador = programador;
//	}
//     	<h:form id="form">
//   		<h:selectBooleanCheckbox id="pregunta" value="#{ejemploSelectBooleanCheckbox.programador}" /> Eres Programador?
//   		<h:commandButton value="Clicar" action="respuesta" />
//	</h:form>
//    
//    <h:selectBooleanCheckbox id="checkbox" value="#{myBean.value}"   >	
//    <p:ajax process="@this" event="change" partialSubmit="true"
//                listener="#{myBean.valueChanged}" />	
//</h:selectBooleanCheckbox>
    //PARA HABILITAR UN ELEMENTOS  
//    <h:form>
//    <h:selectBooleanCheckbox binding="#{checkbox}">
//        <f:ajax render="button" />
//    </h:selectBooleanCheckbox>
//    <h:commandButton id="button" value="submit" 
//        action="#{bean.submit}" 
//        disabled="#{not checkbox.value}" />
//</h:form>
}
