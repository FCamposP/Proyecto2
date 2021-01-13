/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.interfaces;

import Persistencia.dto.DtoProyecto;
import java.util.List;

/**
 *
 * @author fabry
 */
public interface IDaoProyecto {
       public void insertar(DtoProyecto a);
  public  void modificar (DtoProyecto a);
  public  void eliminar (int a);
  public  List<DtoProyecto> obtenerTodos();
   public DtoProyecto obtenerObjeto (DtoProyecto id);
     public  List<DtoProyecto> filtrarUser(int idUser); 
   
}
