
package Upload;

import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.Part;

/**
 *
 * @author emers
 */
@ManagedBean
@ViewScoped
public class UploadBean implements Serializable  {
    private Part file;
   private String x;
    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }
   
    public void upload() throws IOException{
    Scanner s= new Scanner(file.getInputStream());
    String fileContent =s.useDelimiter("\\A").next();
    s.close();
    System.out.println(fileContent);
    x=fileContent;    
    }
    
    public void validar(FacesContext context, UIComponent component , Object value){
    Part file =(Part) value;
        if (!file.getContentType().equals("text/plain")) 
         throw new ValidatorException(new FacesMessage("Archivo no admitido"));  
    }
    
    
    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }
    
}
