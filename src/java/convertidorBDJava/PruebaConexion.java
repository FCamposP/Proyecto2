/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convertidorBDJava;

/**
 *
 * @author MontoyaOsorio
 */
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Scanner;
//@ManagedBean
//@RequestScoped
public class PruebaConexion {
    private static Connection conexion;
    private static final String user = "root";
    private static final String password = "MO17011";
    private static final String url = "jdbc:mysql://localhost:3307/alumnos?zeroDateTimeBehavior=convertToNull";
    
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException 
    {
        //Conectar();
        Scanner input = new Scanner(System.in);
        
        try{ 
            DBMetaData metaData= new DBMetaData(conexion);
            ArrayList<String> schemas = metaData.getSchemasNames();
            
            System.out.println("A continuación se listan las bases de datos disponibles: \n");
            for(int i = 0; i < schemas.size(); i++)
            { System.out.println(i + ". " + schemas.get(i)); }
            
            System.out.println("\n\nEscriba el número correspondiente a la base de datos de la cual " + 
                    "quiere saber la metadata: ");
            
            String bd = schemas.get(input.nextInt());
            System.out.println("Imprimiendo metadata de la base " + bd + ":\n");
           // ArrayList<String> tablas = metaData.getTablesMetadata(bd);
            ArrayList<String> tablas = new ArrayList<String>();
            ArrayList<DBColumn> columnas;
                for(int i = 0; i < tablas.size(); i++)
                {
                    columnas = metaData.getColumnsMetadata(tablas.get(i));
                    System.out.println("\nImprimiendo las columnas de la tabla " + tablas.get(i) + ":");
                    
                    for(int j = 0; j < columnas.size(); j++)
                    {    
                    String cad = "\n";
                    cad += "Columna " + columnas.get(j).name;
                    cad+= "\nEs de tipo y tamaño " + columnas.get(j).type + "(" + columnas.get(j).size + ")"; 
                    cad+= columnas.get(j).primaryKey?"\nEs llave principal":"\nNo es la llave principal";
                    System.out.println(cad + "\n");
                    }
                }
        }catch(Exception e)
        {
            System.err.println("Ocurrió un error: " + e.getMessage());
        }
        
        
        
    }
    
    static public void Conectar() throws ClassNotFoundException, InstantiationException, IllegalAccessException
    {
        conexion = null;
        try{
            conexion = (Connection) DriverManager.getConnection(url, user, password);   
            if(conexion != null){
                System.out.println("Conexión Establecida.");
            }
        }
        catch(Exception ex){
            System.out.println("Error al Conectar a la Base de Datos. " + ex);
        }
    }
}
