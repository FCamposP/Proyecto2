/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.implementacionDao;

import Persistencia.dto.DtoFile;
import Persistencia.dto.DtoProyecto;
import Persistencia.interfaces.IDaoProyecto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fabry
 */
public class DAODBImpProyecto extends Conexion implements IDaoProyecto {

    @Override
    public void insertar(DtoProyecto a) {
        try {
            this.ConectarBasedeDatos();
            PreparedStatement st = this.conexion.prepareStatement("insert into proyecto (nombre,descripcion,ruta, estado) values (?,?,?,?)");
            st.setString(1, a.getNombre());
            st.setString(2, a.getDescripcion());
            st.setString(3, a.getRuta_local());
            st.setString(4, a.getEstado());
            st.execute();
        } catch (Exception ex) {

        } finally {
            this.DesconectarBasedeDatos();
        }
    }

    @Override
    public void modificar(DtoProyecto a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(int a) {
 try{
     this.ConectarBasedeDatos();
     PreparedStatement st=this.conexion.prepareStatement("delete from proyecto where id_proyecto= ?");
     st.setInt(1, a);
     st.execute();
 }catch (Exception ex){
     
 }finally{
     this.DesconectarBasedeDatos();
 }     


    }

    @Override
    public List<DtoProyecto> obtenerTodos() {
        List<DtoProyecto> lista = null;
        try {
            this.ConectarBasedeDatos();
            PreparedStatement st = this.conexion.prepareStatement("select * from proyecto");
            lista = new ArrayList();
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                DtoProyecto proyecto = new DtoProyecto();
                proyecto.setId_proyecto(rs.getInt("id"));
                proyecto.setNombre(rs.getString("nombre"));
                proyecto.setDescripcion(rs.getString("descripcion"));
                proyecto.setRuta_local(rs.getString("ruta"));
                proyecto.setEstado(rs.getString("estado"));
            }
            rs.close();
            st.close();
        } catch (Exception ex) {

        } finally {
            this.DesconectarBasedeDatos();
        }

        return lista;
    }

    @Override
    public DtoProyecto obtenerObjeto(DtoProyecto id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DtoProyecto> filtrarUser(int idUser) {
             List<DtoProyecto> lista = null;
        try {
            this.ConectarBasedeDatos();
            PreparedStatement st = this.conexion.prepareStatement("select * from proyecto where id_usuario = ?");
            st.setInt(1, idUser);
            lista = new ArrayList();
            ResultSet rs = st.executeQuery();
            while (rs.next()) { 
                DtoProyecto proyecto = new DtoProyecto();
                proyecto.setId_proyecto(rs.getInt("id_proyecto"));
                proyecto.setNombre(rs.getString("nombre"));
                proyecto.setDescripcion(rs.getString("descripcion"));
                proyecto.setRuta_local(rs.getString("ruta_local"));
                proyecto.setEstado(rs.getString("estado"));
                proyecto.setTipo(rs.getString("tipo"));
                lista.add(proyecto);
            }
            rs.close();
            st.close();
        } catch (Exception ex) {

        } finally {
            this.DesconectarBasedeDatos();
        }

        return lista;
    }



}
