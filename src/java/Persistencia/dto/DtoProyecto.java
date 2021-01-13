/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.dto;

import java.util.Date;

/**
 *
 * @author fabry
 */
public class DtoProyecto {
        private int id_proyecto;
    private String nombre;
    private String descripcion;
    private String ruta_local;
    private String estado;
    private String tipo;
    private Date fechacreacion;
    private Date fechaActualizacion;
    
    public DtoProyecto() {
    }

    public DtoProyecto(int id_proyecto, String nombre, String descripcion, String ruta_local, String estado) {
        this.id_proyecto = id_proyecto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.ruta_local = ruta_local;
        this.estado = estado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    

    public Date getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(Date fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
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
    
}
