/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import convertidorBDJava.BaseTablas;
import convertidorBDJava.DtoTabla;
import java.io.Serializable;
import java.util.ArrayList;
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
    private static String puerto;
    private static String pass;
    private static List<String> basesDatos;
    private static List<String> tablas;
     private static String baseElegida;

    private static List<BaseTablas> tablasBd;
    
    
    private  String userBDd="";
    private  String serverd;
    private  String puertod;
    private  String passd="";
    private  List<String> basesDatosd;
    private  List<String> tablasd;
    private String baseElegidad;
    

    
    public ControllerBD() {
        basesDatosd= new ArrayList<String>();

    }

    public List<BaseTablas> getTablasBd() {
        return tablasBd;
    }

    public void setTablasBd(List<BaseTablas> tablasBd) {
        this.tablasBd = tablasBd;
    }



    public static List<String> getTablas() {
        return tablas;
    }

    public static void setTablas(List<String> tablas) {
        ControllerBD.tablas = tablas;
    }

    public List<String> getTablasd() {
        return tablasd;
    }

    public void setTablasd(List<String> tablasd) {
        this.tablasd = tablasd;
    }

    
    
    
    public static String getBaseElegida() {
        return baseElegida;
    }

    public static void setBaseElegida(String baseElegida) {
        ControllerBD.baseElegida = baseElegida;
    }
    
    
    
    public String getBaseElegidad() {
        return baseElegidad;
    }

    public void setBaseElegidad(String baseElegida) {
        this.baseElegidad = baseElegida;
        ControllerBD.baseElegida=baseElegida;
    }
    
    

    public String getUserBDd() {
        return userBDd;
    }

    public void setUserBDd(String userBDd) {
        this.userBDd = userBDd;
        ControllerBD.userBD=userBDd;
    }

    public String getServerd() {
        return serverd;
    }

    public void setServerd(String serverd) {
        this.serverd = serverd;
        ControllerBD.server=serverd;
    }

    public String getPuertod() {
        return puertod;
    }

    public void setPuertod(String puertod) {
        this.puertod = puertod;
        ControllerBD.puerto=puertod;
    }

    public String getPassd() {
        return passd;
    }

    public void setPassd(String passd) {
        this.passd = passd;
        ControllerBD.pass=passd;
    }

    public List<String> getBasesDatosd() {
        return basesDatosd;
    }

    public void setBasesDatosd(List<String> basesDatosd) {
        this.basesDatosd = basesDatosd;
        ControllerBD.basesDatos=basesDatosd;
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

    public static String getPuerto() {
        return puerto;
    }

    public static void setPuerto(String puerto) {
        ControllerBD.puerto = puerto;
    }

    public static String getPass() {
        return pass;
    }

    public static void setPass(String pass) {
        ControllerBD.pass = pass;
    }

    
    
}
