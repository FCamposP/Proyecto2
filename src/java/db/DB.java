package db;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.faces.context.FacesContext;

//@author Helki

public class DB implements Serializable{
    private String db_server = "";
    private String db_user = "";
    private String db_password = "";      
    private String db_driver = "";
            
    public Connection connection = null;
            
    public DB() throws Exception{
        FacesContext fc = FacesContext.getCurrentInstance();
        this.db_server = fc.getExternalContext().getInitParameter("DB-SERVER");
        this.db_user = fc.getExternalContext().getInitParameter("DB-USER");
        this.db_password = fc.getExternalContext().getInitParameter("DB-PASSWORD");
        this.db_driver = fc.getExternalContext().getInitParameter("JDBC-DRIVER");
        
        Class.forName(this.db_driver);
    }
    
    public Connection doConnect() throws Exception{
        if(this.connection == null)
            this.connection = DriverManager.getConnection(this.db_server,this.db_user,this.db_password);
        
        return this.connection;
    }
    
}
