package componentegestordearchivos;

import beans.BeanUML;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 *
 * @author Dany Serrano
 */
@Named(value = "archivoBean")
@Dependent
public class ArchivoBean
{

    private static final String MESSAGE = "El código aparecerá aquí.";
    private static ArrayList<Archivo> clases = new ArrayList<Archivo>();
    public static String code;
  
    public static void agregarArchivo(Archivo file)
    {
        clases.add(file);
    }
    
    
      
    public static void setClases(ArrayList<Archivo> lista)
    {
        clases.clear();
        ArchivoBean.clases = lista;
        //FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("result");
    }

    public static ArrayList<Archivo> getClases()
    {	return clases;	}

    public static void InitCode()
    {
        ArchivoBean.code = MESSAGE;
        clases.clear();
    }
    
    public static void limpiarLista()
    {	clases.clear();		}

public static String getCode()
    {	return code;    }

    public static void setCode(String code)
    {	ArchivoBean.code = code;    }
    
    /*
    * Método invocado al hacer click en un elemento de la tabla Archivos
    * Extrae el nombre del archivo, lo busca en la lista "clases" y cuando
    * lo encuentra guarda el valor del atributo codigo en el atributo code
    * de esta clase.
    */
    public void actualizaCode(ActionEvent event)
    {
        String value;
        int index = 0;
        UIComponent component = event.getComponent();
        value = (String) component.getAttributes().get("value");
        boolean found = false;
        
        while(!found || (index == -1))
        {
            try{
                if(clases.get(index).getNombre().equals(value))
                found = true;
                else index++;
            }catch(Exception e)
            { index = -1; }
            
        }
        
        if(index != -1)
            setCode(clases.get(index).getCodigo());
        else setCode("No se ha encontrado el archivo.");

        //Actualiza el componente de id=txtCode
        FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("result"); 
    }


    /*
    * Método que genera objetos de tipo Archivo para probar
    * el componente para mostrar los archivos
    */
    public static void generarArchivosDePrueba()
    {
    	clases.clear();
        clases.add(new Archivo("public static void main(String[] args){\n"+
                                "\t//Please put on all your code here:\n\t}", "Main.java"));
        clases.add(new Archivo("public int getValor(){\n\treturn valor;\n\t}", "GetValor.java"));
        clases.add(new Archivo("public void setValor(int valor){\n\tthis.valor = valor;\n\t}", "SetValor.java"));
    }
    
}
