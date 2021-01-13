package entidades;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author SZ19002 - Daniel Serrano
 */
public class Usuario
{
    private int id_usuario;
    private String nombres;
    private String apellidos;
    private Date fecha_nacimiento;
    private String email;
    private String nombre_usuario;
    private String contrasena;
    private ArrayList<Proyecto> proyectos;
    
    public Usuario(int id_usuario, String nombres, String apellidos, Date fecha_nacimiento, String email, String nombre_usuario, String contrasena) {
        this.id_usuario = id_usuario;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fecha_nacimiento = fecha_nacimiento;
        this.email = email;
        this.nombre_usuario = nombre_usuario;
        this.contrasena = contrasena;
        this.proyectos = new ArrayList<>();
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public ArrayList<Proyecto> getProyectos() {
        return proyectos;
    }

    public void setProyectos(ArrayList<Proyecto> proyectos) {
        this.proyectos = proyectos;
    }
    
    
}
