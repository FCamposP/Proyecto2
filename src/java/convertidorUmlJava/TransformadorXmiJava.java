/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convertidorUmlJava;

import subirXmi.FileUploadMBean;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;
import generadorJava.GeneradorJava;
import gestordearchivos.Archivo;
import java.io.InputStream;
import java.util.ArrayList;

/**
 *
 * @author fabry
 */
public class TransformadorXmiJava {

    LectorXmiHandler handler;

    public TransformadorXmiJava() {
        handler = new LectorXmiHandler();
    }

    public ArrayList<Archivo> TransformarXmiToJava() throws ParserConfigurationException, IOException, SAXException {
        LeerXmi();
        GeneradorJava crearJava = new GeneradorJava();
         ArrayList<Archivo> archivos = new ArrayList<Archivo>();
       archivos= crearJava.CrearArchivos(handler.getListaClases(), 1);
        return archivos;
    }

    public void LeerXmi() throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();

        // File file = new File("C:\\Users\\Irs\\Desktop\\archivo\\prueba1.xmi");
        InputStream sfs=FileUploadMBean.getContenidoArchivo();
        saxParser.parse(FileUploadMBean.getContenidoArchivo(), handler);

    }

}
