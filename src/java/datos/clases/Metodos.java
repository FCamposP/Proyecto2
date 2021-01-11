
package datos.clases;

import java.util.ArrayList;

/**
 *
 * @author Irs
 */
public class Metodos 
{
    private String id;
    private String nombre;
    private String tipo;
    private Enums.Visibilidad visibilidad;
    private ArrayList<Parametro> parametros;
    private boolean retorna=false;
    private String tipoRetorno;
    //constructores
    public Metodos()
    {
        this.nombre = "";
        this.parametros=new ArrayList<Parametro>();
    }
    //, ArrayList<Parametro> parametros
    public Metodos( String tipo, String nombre) {
      //  this.visibilidad = visibilidad;
        this.tipo = tipo;
        this.nombre = nombre;
         this.parametros=new ArrayList<Parametro>();
    }
    
    @Override
    public String toString() {
        return "\nMetodo{" + "nombre=" + nombre + ", tipo=" + tipo+", parametros="+parametros + ", id=" + id + '}';
    }

    //geett y sett 

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Enums.Visibilidad getVisibilidad() {
        return visibilidad;
    }

    public void setVisibilidad(Enums.Visibilidad visibilidad) {
        this.visibilidad = visibilidad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    public boolean isRetorna() {
        return retorna;
    }

    public void setRetorna(boolean retorna) {
        this.retorna = retorna;
    }

    public String getTipoRetorno() {
        return tipoRetorno;
    }

    public void setTipoRetorno(String tipoRetorno) {
        this.tipoRetorno = tipoRetorno;
    }
    
     public void adicionarParametro(Parametro p) {
        parametros.add(p);
    }
     
    public ArrayList<Parametro> getParametros() {
        return parametros;
    }

    public void setParametros(ArrayList<Parametro> parametros) {
        this.parametros = parametros;
    }
    
    
    
    
}
