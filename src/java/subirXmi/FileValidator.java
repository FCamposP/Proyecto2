/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subirXmi;

import java.io.InputStream;
import java.util.Scanner;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.Part;


@FacesValidator(value="FileValidator")
public class FileValidator implements Validator 
{
    
    public boolean ValidarEstenxion() throws ValidatorException{
         Part file = (Part) FileUploadMBean.getArchivoSubido();
        String text = "";

        try {
            InputStream is = file.getInputStream();
            text = new Scanner(is).useDelimiter("\\A").next();
            // Do not accept an upload unless it contains the string
        
        } catch (Exception ex) 
        {
            throw new ValidatorException(new FacesMessage("file invalido"), ex);
        }
        if (!text.contains("xmi"))
        {
            throw new ValidatorException(new FacesMessage("Invalid file.  File must contain special string"));
        }
        return false;
    }
    
        @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException 
    {
        Part file = (Part) value;
        String text = "";

        try {
            InputStream is = file.getInputStream();
            text = new Scanner(is).useDelimiter("\\A").next();
            // Do not accept an upload unless it contains the string
        
        } catch (Exception ex) 
        {
            throw new ValidatorException(new FacesMessage("file invalido"), ex);
        }
        if (!text.contains("xmi"))
        {
            throw new ValidatorException(new FacesMessage("Invalid file.  File must contain special string"));
        }

    }
    
}
