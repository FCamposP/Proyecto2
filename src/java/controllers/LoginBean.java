package controllers;

import Persistencia.dto.DtoUser;
import Persistencia.implementacionDao.objetosDAOBD;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import auth.SessionUtils;

@Named(value = "logine")
@SessionScoped
public class LoginBean implements Serializable {

    private static final long serialVersionUID = 1094801825228386363L;

    private String pwd;
    private String msg;
    private String user;
    private String nombre;
    private String username;
    private String email;
    private String password;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }    
    
    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    //validate login
    public String validateUsernamePassword() {
        boolean valid = objetosDAOBD.daobdiUser.validate(user, pwd);
        if (valid) {
            HttpSession session = SessionUtils.getSession();
            session.setAttribute("username", user);

            return "home.xhtml?faces-redirect=true";
        } else {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Incorrect Username and Passowrd",
                            "Please enter correct username and Password"));
            return "login.xhtml?faces-redirect=true";
        }
    }

    //logout event, invalidate session
    public String logout() {
        HttpSession session = SessionUtils.getSession();
        session.invalidate();
        return "login.xhtml?faces-redirect=true";
    }
    
    public void registrarse(){
        System.out.println(password);
        System.out.println(email);
        System.out.println(username);
        System.out.println(nombre);
        
        DtoUser nuevoUser= new DtoUser();
        nuevoUser.setContrasena(password);
        nuevoUser.setEmail(email);
        nuevoUser.setNombre_usuario(username);
        nuevoUser.setNombres(nombre);
    
        objetosDAOBD.daobdiUser.insertar(nuevoUser);
    }
    
    //hs19011 metod
    
    public void registrar(){
        try {
            
        } catch (Exception e) {
            //mensaje
        }
    }
    
}
