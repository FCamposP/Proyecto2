/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convertidorBDJava;

import java.util.List;

/**
 *
 * @author fabry
 */
public class Funciones {
    
    
   public BaseTablas buscarBaseTablas(List<BaseTablas> tablas, DtoTabla buscado){
       BaseTablas find= new BaseTablas();
       for(BaseTablas buscador:tablas){
           if(buscador.getTabla()==buscado){
               return buscador;
           }
       }
       return find;
       
   }
}
