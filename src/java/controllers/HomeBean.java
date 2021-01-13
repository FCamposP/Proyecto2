/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Persistencia.dto.DtoProyecto;
import Persistencia.implementacionDao.DAODBImpProyecto;
import Persistencia.implementacionDao.objetosDAOBD;
import Persistencia.interfaces.IDaoProyecto;
import auth.SessionUtils;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;

/**
 *
 * @author fabry
 */
@Named(value = "proyectosBean")
@SessionScoped
public class HomeBean implements Serializable {

    /**
     * Creates a new instance of BeanProyectos
     */
    private List<DtoProyecto> proyectosUser;

    public HomeBean() {
    }

    public List<DtoProyecto> getProyectosUser() {
        return proyectosUser;
    }

    public void setProyectosUser(List<DtoProyecto> proyectosUser) {
        this.proyectosUser = proyectosUser;
    }

    public void eliminarProyecto(int id) {
        try {
            objetosDAOBD.daobdimpProyecto.eliminar(id);
            List<DtoProyecto> actualizar= obtenerProyectos();
        } catch (Exception e) {
        }
        
    }

    public List<DtoProyecto> obtenerProyectos() {
        IDaoProyecto proy = new DAODBImpProyecto();
        int idusuario = -1;
        String username = "";
        List<DtoProyecto> proyectosUser= new ArrayList<>();
        HttpSession session = SessionUtils.getSession();

        //obtener usuario
        username=session.getAttribute("username").toString();
        idusuario=objetosDAOBD.daobdiUser.obtenerId(username);
        
       
        // obtener proyectos de usuario
         

        proyectosUser= proy.filtrarUser(idusuario);
         String estot="";
         return proyectosUser;
    }

    
    
}
