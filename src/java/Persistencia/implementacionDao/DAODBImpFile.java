/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.implementacionDao;

import Persistencia.dto.DtoFile;
import Persistencia.interfaces.IDaoFile;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fabry
 */
public class DAODBImpFile extends Conexion implements IDaoFile{

    @Override
    public void insertar(DtoFile a) {
 try{
     this.ConectarBasedeDatos();
     PreparedStatement st=this.conexion.prepareStatement("insert into file(nombre,ruta,tipo) values (?,?)");
     st.setString(1, a.getNombre());
     st.setString(2, a.getRuta_local());
     st.setString(3, a.getTipo());
     st.execute();
 }catch (Exception ex){
     
 }finally{
     this.DesconectarBasedeDatos();
 }    
    }

    @Override
    public void modificar(DtoFile a) {
       try{
     this.ConectarBasedeDatos();
     PreparedStatement st=this.conexion.prepareStatement("update file set (nombre,ruta,tipo) values (?,?)");
     st.setString(1, a.getNombre());
     st.setString(2, a.getRuta_local());
     st.setString(3, a.getTipo());
     st.execute();
 }catch (Exception ex){
     
 }finally{
     this.DesconectarBasedeDatos();
 }
    }

    @Override
    public void eliminar(DtoFile a) {
 try{
     this.ConectarBasedeDatos();
     PreparedStatement st=this.conexion.prepareStatement("delete from File where id= ?");
     st.setInt(1, a.getId_archivo());
     st.execute();
 }catch (Exception ex){
     
 }finally{
     this.DesconectarBasedeDatos();
 }     

    }

    @Override
    public List<DtoFile> obtenerTodos() {
        List<DtoFile> lista=null;
 try{
     this.ConectarBasedeDatos();
     PreparedStatement st=this.conexion.prepareStatement("select * from file");
      lista= new ArrayList();
      ResultSet rs=st.executeQuery();
      while(rs.next()){
          DtoFile file= new DtoFile();
          file.setId_archivo(rs.getInt("id"));
          file.setNombre(rs.getString("nombre"));
          file.setRuta_local(rs.getString("ruta_local"));
          file.setTipo(rs.getString("tipo"));
      }
     rs.close();
     st.close();
 }catch (Exception ex){
     
 }finally{
     this.DesconectarBasedeDatos();
 }   
 
 return lista;
    }

    @Override
    public DtoFile obtenerObjeto(DtoFile id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DtoFile> filtrarPorPropiedad(String propiedad, String valor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
// try{
//     this.ConectarBasedeDatos();
//     PreparedStatement st=this.conexion.prepareStatement("select * from File where"+propiedad+" = ?");
//     st.setString(1, valor);
//     st.execute();
// }catch (Exception ex){
//     
// }finally{
//     this.DesconectarBasedeDatos();
// }       
//    }

    }

  
}
