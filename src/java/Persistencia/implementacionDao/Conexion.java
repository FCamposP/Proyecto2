/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.implementacionDao;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author fabry
 */
public class Conexion {
    public Connection conexion;
    public Statement sentencia;
    public ResultSet resultado;

    public void ConectarBasedeDatos() throws SQLException, ClassNotFoundException {
        try {
            final String Controlador = "com.mysql.jdbc.Driver";
            Class.forName(Controlador);
            final String url_bd = "jdbc:mysql://"+DatosConexion.servidor+":"+DatosConexion.puerto;
            final String url_bd2 = "jdbc:mysql://"+DatosConexion.servidor+":"+DatosConexion.puerto+"/" + DatosConexion.bd;
            if (DatosConexion.bd.equals("")) {
                conexion = DriverManager.getConnection(url_bd, DatosConexion.user, DatosConexion.pass);
            } else {
                conexion = DriverManager.getConnection(url_bd2,DatosConexion.user, DatosConexion.pass);
            }
        //  sentencia = (Statement) conexion.createStatement();
       // return conexion;
       String h=";";
        } catch ( SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Excepcion", JOptionPane.ERROR_MESSAGE);
         //   return null;
        }
        
        
    }

    public void DesconectarBasedeDatos() {
        try {
            if (conexion != null) {

                conexion.close();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Excepcion", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }

    public Connection getConnection() {
        return conexion;
    }

    public void CrearBd() {

        try {
            ConectarBasedeDatos();
            //this.sentencia.execute();
        } catch (Exception e) {

        }

    }
}
