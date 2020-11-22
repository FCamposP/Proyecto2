/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convertidorBDJava;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
/**
 *
 * @author MontoyaOsorio
 */
//@ManagedBean
//@RequestScoped
public class DBRelation {
    /**
     * Initializes a new DBRelation object.
     * @param _pk_key The primaty key.
     * @param _pk_table The table that holds the primary key.
     * @param _fk_key The foreign key.
     * @param _fk_table The table that holds the foreign key.
     */
    public DBRelation( String _pk_key, String _pk_table, String _fk_key, String _fk_table)
    {
        String pk_key = _pk_key;
        String pk_table = _pk_table;
        String fk_key = _fk_key;
        String fk_table = _fk_table;

    }
}
