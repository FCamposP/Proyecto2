/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convertidorUmlJava;

import subirXmi.FileUploadMBean;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import datos.clases.Clase;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;
import componentegestordearchivos.*;
import convertidorUmlJava.LectorXmiHandler;
import datos.clases.GeneradorJava;

/**
 *
 * @author fabry
 */
public class Convertidor {

    public void ConvertidorXmi() throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();
        
       // File file = new File("C:\\Users\\Irs\\Desktop\\archivo\\prueba1.xmi");
        LectorXmiHandler handler = new LectorXmiHandler();
        saxParser.parse(FileUploadMBean.getContenidoArchivo(), handler);
        GeneradorJava.CrearArchivos(handler.getListaClases(),1);
    }

    public Convertidor() {
    }


}
