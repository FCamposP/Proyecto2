/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convertidorBDJava;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author MontoyaOsorio
 */
//@ManagedBean
//@RequestScoped
public class DBConnection {
//    private static  String DB_USER = "root";
//    private static  String DB_PASSWORD = "MO17011";
//    private static  String DB_URL = "jdbc:mysql://localhost:3307/alumnos?zeroDateTimeBehavior=convertToNull";

    
    public static Connection connection;

    
    
    
    public static Connection getConnection(String server,int puerto,String bd, String DB_USER, String DB_PASSWORD) throws SQLException{
        
        try {
            String direccionCompleta="jdbc:mysql://";
            direccionCompleta+= server+":"+puerto+"/";
          connection = DriverManager.getConnection(direccionCompleta, DB_USER, DB_PASSWORD);
          System.err.println("The connection is successfully obtained");

        } catch(SQLException ex){

            System.err.println("error establishing connection");
        }
        
        return connection;
    }
    
    //CloseConexion
    public static Connection closeConnection(){
    
        try{
        
            connection.close();
        }catch(SQLException ex){
        
            System.err.println("Failed to close connection. Error: "+ex.getMessage());
        }
        return connection;
    }
}
