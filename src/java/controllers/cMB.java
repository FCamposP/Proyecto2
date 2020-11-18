
package controllers;

import generadorJava.Convertidor;
import generadorJava.GeneradorJava;
import generadorJava.LectorXmiHandler;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

@Named(value = "cMB")
@Dependent
public class cMB {
   
    
   
    public cMB() {
        
    }
      
     
//    private URI typesUri = null;
    

    public void generar() throws ParserConfigurationException, IOException, SAXException {

       Convertidor converter= new Convertidor();
        converter.ConvertidorXmi();
        
//        Model m = getModel("C:/ExtendedPO2.uml");
//        System.out.println(m.getName());
    }
    public void guarda() throws ParserConfigurationException, IOException, SAXException
    {
        FileUploadMBean obje=new FileUploadMBean();
        obje.uploadFile();
    }

//    public Model getModel(String pathToModel) {
//
//        typesUri = URI.createFileURI(pathToModel);
//        ResourceSet set = new ResourceSetImpl();
//
//        set.getPackageRegistry().put(UMLPackage.eNS_URI, UMLPackage.eINSTANCE);
//        set.getResourceFactoryRegistry().getExtensionToFactoryMap().put(UMLResource.FILE_EXTENSION, UMLResource.Factory.INSTANCE);
//        set.createResource(typesUri);
//        Resource r = set.getResource(typesUri, true);
//
//        Model m = (Model) EcoreUtil.getObjectByType(r.getContents(), UMLPackage.Literals.MODEL);
//
//        return m;
//    }
    
   

}
