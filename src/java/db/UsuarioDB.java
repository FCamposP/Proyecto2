package db;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

//@author Helki

public class UsuarioDB implements Serializable{
    private int id;
    private String nombre;
    private String username;
    private String password;
    private String correo;

    public UsuarioDB(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    public static List<UsuarioDB> doLogin(DB db, String user, String pass) throws Exception{
        List<UsuarioDB> list = new ArrayList<UsuarioDB>();
        
        PreparedStatement prepState = null;
        ResultSet resultSet = null;
        
        try{
            if(db == null){
                db = new DB();
            }
        
            String sql = "SELECT id, nombre FROM usuarios WHERE username=? AND password=?";
            prepState = db.doConnect().prepareStatement(sql);
            prepState.setString(1, user);
            prepState.setString(2, pass);

            resultSet = prepState.executeQuery();

            while(resultSet.next()){
                list.add(new UsuarioDB(resultSet.getInt(1), resultSet.getString(2)));
            } 
        } catch (Exception e){
            System.out.println("Error; " + e.getMessage());
        }
        
        return list;
    }        
}
