/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import java.util.List;
import db.UsuarioDB;

/**
 *
 * @author Helki
 */
@Named(value = "loginBean")
@RequestScoped
public class LoginBean {
    String msgClass;
    String message;
    String username;
    String password;

    public LoginBean() {
        this.msgClass = "info";
        this.message = "Ingrese usuario y contraseña";
        
    }
    
    public String getMsgClass() {
        return msgClass;
    }

    public void setMsgClass(String msgClass) {
        this.msgClass = msgClass;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public void doLogin(){
        try{
            List<UsuarioDB> usuario = UsuarioDB.doLogin(null, this.username, this.password);
            
            if(usuario.size() > 0){
                this.message = "Bienvenido " + usuario.get(0).getNombre();
                this.msgClass = "success";
            }else{
                this.message = "Usuario y/o clave incorrectos";
                this.msgClass = "danger";
            }
            
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
