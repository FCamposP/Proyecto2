/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.implementacionDao;

import Persistencia.dto.DtoUser;
import Persistencia.interfaces.IDaoUser;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author fabry
 */
public class DAODBImpUser extends Conexion  implements IDaoUser{

    @Override
    public void insertar(DtoUser a) {
 try{
     this.ConectarBasedeDatos();
     PreparedStatement st=this.conexion.prepareStatement("insert into user(nombres,username,email,password) values (?,?,?,?)");
     st.setString(1, a.getNombres());
     st.setString(2, a.getNombre_usuario());
     st.setString(3, a.getEmail());
     st.setString(4, a.getContrasena());
     st.execute();
 }catch (Exception ex){
     
 }finally{
     this.DesconectarBasedeDatos();
 }  
    }

    @Override
    public void modificar(DtoUser a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(DtoUser a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DtoUser> obtenerTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DtoUser obtenerObjeto(DtoUser id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean validate(String username, String pass) {
		PreparedStatement ps = null;
		try {
                         this.ConectarBasedeDatos();
			ps = this.conexion.prepareStatement("Select nombre_usuario, contrasena from usuario where nombre_usuario = ? and contrasena = ?");
			ps.setString(1, username);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				//result found, means valid inputs
				return true;
			}
		} catch (Exception ex) {
			System.out.println("Login error -->" + ex.getMessage());
			return false;
		} finally {
			DesconectarBasedeDatos();
		}
		return false;
	}

    @Override
    public int obtenerId(String username) {
        int id=-1;
        		PreparedStatement ps = null;
		try {
                     this.ConectarBasedeDatos();
			ps = this.conexion.prepareStatement("Select * from usuario where nombre_usuario = ?");
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				//result found, means valid inputs
			id=rs.getInt("id_usuario");
			}
		} catch (Exception ex) {
			System.out.println("Login error -->" + ex.getMessage());
			
		} finally {
			DesconectarBasedeDatos();
		}
return id;
    }
    
}
