package componentegestordearchivos;

import beans.BeanUML;
import datos.clases.Clase;
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
    private static ArrayList<Archivo> clases2 = new ArrayList<Archivo>();
    public static String code2;
    private  ArrayList<Archivo> clases2d = new ArrayList<Archivo>();
    public  String code2d;
  
    public static void agregarArchivo(Archivo file)
    {
        clases.add(file);
    }

    public ArrayList<Archivo> getClases2d() {
        return clases2d;
    }

    public void setClases2d(ArrayList<Archivo> clases2d) {
        this.clases2d = clases2d;
    }

    public String getCode2d() {
        return code2;
    }

    public void setCode2d(String code2d) {
        this.code2d = code2d;
    }
    
    

    public static ArrayList<Archivo> getClases2() {
        return clases2;
    }

    public static void setClases2(ArrayList<Archivo> clases2) {
        ArchivoBean.clases2 = clases2;
    }

    public static String getCode2() {
        return code2;
    }

    public static void setCode2(String code2) {
        ArchivoBean.code2 = code2;
    }
    
    
      
    public static void setClases(ArrayList<Archivo> lista)
    {
        clases.clear();
        ArchivoBean.clases = lista;
        //FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("result");
    }

    public static ArrayList<Archivo> getClases()
    {	return clases;	
    }

    public void limpiarPagina(){
        limpiarLista();
        ArchivoBean.code = "";  
    }
    public static void InitCode()
    {
        ArchivoBean.code = MESSAGE;
        clases.clear();
    }
    
    public static void limpiarLista()
    {	
        clases.clear();		}

public static String getCode()
    {	
        return code; 
    
    }

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
     //   FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("result"); 
    }
    public void actualizaCode2(ActionEvent event)
    {
        String value;
        int index = 0;
        UIComponent component = event.getComponent();
        value = (String) component.getAttributes().get("value");
        boolean found = false;
        
        while(!found || (index == -1))
        {
            try{
                if(clases2.get(index).getNombre().equals(value))
                found = true;
                else index++;
            }catch(Exception e)
            { index = -1; }
            
        }
        
        if(index != -1)
            setCode2(clases2.get(index).getCodigo());
        else setCode2("No se ha encontrado el archivo.");

        //Actualiza el componente de id=txtCode
        FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("result"); 
    }
    public void actualizaCode2(Archivo clas)
    {
        String value;
        int index = 0;
//        UIComponent component = event.getComponent();
//        value = (String) component.getAttributes().get("value");
        boolean found = false;
        
        while(!found || (index == -1))
        {
            try{
                if(clases2.get(index).getNombre().equals(clas.getNombre()))
                found = true;
                else index++;
            }catch(Exception e)
            { index = -1; }
            
        }
        
        if(index != -1)
            setCode2(clases2.get(index).getCodigo());
        else setCode2("No se ha encontrado el archivo.");

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
