/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.interfaces;

import Persistencia.dto.DtoFile;
import Persistencia.dto.DtoUser;
import java.util.List;

/**
 *
 * @author fabry
 */
public interface IDaoUser {
    
       public void insertar(DtoUser a);
  public  void modificar (DtoUser a);
  public  void eliminar (DtoUser a);
  public  List<DtoUser> obtenerTodos();
   public DtoUser obtenerObjeto (DtoUser id);
   public boolean validate(String username, String pass);
   public int obtenerId(String username);
}
