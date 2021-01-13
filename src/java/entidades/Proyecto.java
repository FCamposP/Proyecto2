package clasesDB;

import java.util.ArrayList;

/**
 *
 * @author SZ19002 - Daniel Serrano
 */
public class Proyecto
{
    private int id_proyecto;
    private String nombre;
    private String descripcion;
    private String ruta_local;
    private String estado;
    private ArrayList<File> archivos;

    public Proyecto(int id_proyecto, String nombre, String descripcion, String ruta_local, String estado) {
        this.id_proyecto = id_proyecto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.ruta_local = ruta_local;
        this.estado = estado;
        this.archivos = new ArrayList<>();
    }

    public int getId_proyecto() {
        return id_proyecto;
    }

    public void setId_proyecto(int id_proyecto) {
        this.id_proyecto = id_proyecto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRuta_local() {
        return ruta_local;
    }

    public void setRuta_local(String ruta_local) {
        this.ruta_local = ruta_local;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public ArrayList<File> getArchivos() {
        return archivos;
    }

    public void setArchivos(ArrayList<File> archivos) {
        this.archivos = archivos;
    }
    
    
}
