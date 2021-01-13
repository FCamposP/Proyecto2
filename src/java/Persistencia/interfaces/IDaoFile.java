/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.interfaces;

import Persistencia.dto.DtoFile;
import Persistencia.dto.DtoProyecto;
import java.util.List;

/**
 *
 * @author fabry
 */
public interface IDaoFile {
   public void insertar(DtoFile a);
  public  void modificar (DtoFile a);
  public  void eliminar (DtoFile a);
  public  List<DtoFile> obtenerTodos();
   public DtoFile obtenerObjeto (DtoFile id);
  public  List<DtoFile> filtrarPorPropiedad(String propiedad, String valor); 
}
