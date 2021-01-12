
package datos.clases;

/**
 *
 * @author Irs
 */
public class Parametro 
{
    private String id;
    private String tipo;
    private String nombre;
//lista
    
      public Parametro() {
        this.nombre = "";
    }

    public Parametro(String tipo,String nombre) {
        this.tipo=tipo;
        this.nombre = nombre;    
    }
    
      @Override
    public String toString() {
        return "\nParametro{" + "nombre=" + nombre + ", tipo=" + tipo + ", id=" + id + '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
    
    
    
}
