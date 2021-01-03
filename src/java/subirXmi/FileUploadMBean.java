
package subirXmi;

import java.io.InputStream;
import java.io.Serializable;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.servlet.http.Part;


@Named(value = "fileUploadMBean")
@ViewScoped
public class FileUploadMBean implements Serializable
{

    private Part file;
    private static Part archivoSubido;
    private static InputStream contenidoArchivo;

    public static InputStream getContenidoArchivo() {
        return contenidoArchivo;
    }

    public static void setContenidoArchivo(InputStream contenidoArchivo) {
        FileUploadMBean.contenidoArchivo = contenidoArchivo;
    }


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
   

//    public void uploadFile() throws IOException 
//    {
//        try{
//            FileValidator validador= new FileValidator();
//            if(validador.ValidarEstenxion()){
//                
//            }
//
//  
//        }catch(Exception ex){
//            
//        }
// 
//       
//    }
    
  
    
}
