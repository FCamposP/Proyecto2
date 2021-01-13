/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.dto;

/**
 *
 * @author fabry
 */
public class DtoFile {
    private int id_archivo;
    private String nombre;
    private String ruta_local;
    private String tipo;

    public DtoFile() {
    }

    
    public DtoFile(int id_archivo, String nombre, String ruta_local, String tipo) {
        this.id_archivo = id_archivo;
        this.nombre = nombre;
        this.ruta_local = ruta_local;
        this.tipo = tipo;
    }

    public int getId_archivo() {
        return id_archivo;
    }

    public void setId_archivo(int id_archivo) {
        this.id_archivo = id_archivo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRuta_local() {
        return ruta_local;
    }

    public void setRuta_local(String ruta_local) {
        this.ruta_local = ruta_local;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
    
}
