/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.Dependent;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author fabry
 */
@Named(value = "controllerBD")
@ViewScoped
public class ControllerBD implements Serializable{

    /**
     * Creates a new instance of ControllerBD
     */
    
    private static String userBD;
    private static String server;
    private static Integer puerto;
    private static String pass;
    private static List<String> basesDatos;
    
    public ControllerBD() {
    }

    public static List<String> getBasesDatos() {
        return basesDatos;
    }

    public static void setBasesDatos(List<String> basesDatos) {
        ControllerBD.basesDatos = basesDatos;
    }

    
    
    public static String getUserBD() {
        return userBD;
    }

    public static void setUserBD(String userBD) {
        ControllerBD.userBD = userBD;
    }

    public static String getServer() {
        return server;
    }

    public static void setServer(String server) {
        ControllerBD.server = server;
    }

    public static Integer getPuerto() {
        return puerto;
    }

    public static void setPuerto(Integer puerto) {
        ControllerBD.puerto = puerto;
    }

    public static String getPass() {
        return pass;
    }

    public static void setPass(String pass) {
        ControllerBD.pass = pass;
    }

    
    
}
