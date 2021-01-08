/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package runCode;
 
import java.io.BufferedReader; 
import java.io.InputStreamReader;

/**
 *
 * @author fabry
 */ 
public class CompiladorEjecutorJava {
 
    
            public String ejecutarArchivos(String ubicacion, String comando) {

        String salidaEstandar = "";
        String salidaError = "";
        String salidaReturn="";
        boolean exito=false;
        if(comando=="javac"){
             ubicacion=comando+" F:/facompiler/HolaMundo.java";
        }else{
             ubicacion="java -cp F:\\facompiler HolaMundo";
             //ubicacion="cd C:\\test && && "+comando+" HolaMundo";
        }
       
        try {
            String line; 
            Process p = Runtime.getRuntime().exec(ubicacion);
            
            //salida estandar de la compilación
            BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
            while ((line = input.readLine()) != null) {
          //      System.out.println(line);
                salidaEstandar += line; 
            } 
            input.close();             
            
            if(salidaEstandar==""){
                salidaEstandar="0";
            }
            
            //en caso de error en la compilación
            BufferedReader error = new BufferedReader(new InputStreamReader(p.getErrorStream()));
            while ((line = error.readLine()) != null) {
              //  System.out.println(line);
                salidaError += line;
            }
            error.close(); 
            
            if(salidaError!=""){ 
                salidaReturn=salidaError;
            }else{
                salidaReturn=salidaEstandar;
            }
            

        } catch (Exception e) {
        }
        return salidaReturn;

    }
    
    
}
