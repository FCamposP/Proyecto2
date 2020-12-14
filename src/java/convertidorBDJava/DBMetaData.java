/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convertidorBDJava;

import controllers.ControllerBD;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DatabaseMetaData;

import java.util.List;
/**
 *
 * @author MontoyaOsorio
 */
//@ManagedBean
//@RequestScoped
public class DBMetaData {

    //static variables
    private Connection connection = null;
    private DatabaseMetaData metadata = null;
    ResultSet res;

    public DBMetaData(Connection conn) {
        this.connection = conn;
    }


    public List<BaseTablas> getTablesMetadata(String db) throws SQLException {
//        String table[] = {"TABLE"};
//        ResultSet rs = null;
    
        List<BaseTablas> tablas = new ArrayList<BaseTablas>();
        
        String[] types = {"TABLE"};
        res = connection.getMetaData().getTables(db, null, "%", types);
        
        while (res.next()) {
               BaseTablas nuevaTabla= new BaseTablas();
               DtoTabla dtoTabla= new DtoTabla();
               dtoTabla.setNombreTabla(res.getString(3));
               List<DBColumn> columns= getColumnsMetadata(dtoTabla.getNombreTabla());
               nuevaTabla.setColumnas(columns);
               nuevaTabla.setTabla(dtoTabla);
            //crerar objeto de tabla
            //obtener atributos
            
            tablas.add(nuevaTabla);
        }
        return tablas;
    }

    /**
     * Gets a list with all relationships in the DB.
     *
     * @param tableNames A list with the tables in the DB.
     * @return Arraylist
     * * @throws SQLException
     */
    public ArrayList<DBRelation> getRelationsMetadata(ArrayList<String> tableNames)
            throws SQLException {

        ArrayList<DBRelation> result = new ArrayList<DBRelation>();

        for (String tableName : tableNames) {
            //get the foreign keys
            ResultSet foreignKeys = metadata.getImportedKeys(connection.getCatalog(), null, tableName);
            while (foreignKeys.next()) {
                String fkTableName = foreignKeys.getString("FKTABLE_NAME");
                String fkColumnName = foreignKeys.getString("FKCOLUMN_NAME");
                String pkTableName = foreignKeys.getString("PKTABLE_NAME");
                String pkColumnName = foreignKeys.getString("PKCOLUMN_NAME");

                DBRelation relation = new DBRelation(pkColumnName, pkTableName, fkColumnName, fkTableName);

                result.add(relation);
            }
        }

        return result;

    }

    /**
     * Returns a list with DBColumn objects, one for each column in the table
     * provided as a parameter.
     *
     * @param tableName
     * @return List with the columns in the table.
     * @throws SQLException
     */
    public ArrayList<DBColumn> getColumnsMetadata(String tableName)
            throws SQLException {
        ResultSet rs = null;
        metadata= connection.getMetaData();
       // rs = metadata.getPrimaryKeys(null, null, tableName);

        //get primary key
        ArrayList<String> primaryKeys = new ArrayList<String>();
//        while (rs.next()) {
//            primaryKeys.add(rs.getString("COLUMN_NAME"));
//        }

        // gets the columns
        ArrayList<DBColumn> result = new ArrayList<DBColumn>();
        rs = metadata.getColumns(ControllerBD.getBaseElegida(), null, tableName, "%");

        //records the data for each column
        while (rs.next()) {
            String uno=rs.getString("COLUMN_NAME");
            String dos=rs.getString("TYPE_NAME");
             String tres=rs.getString("COLUMN_SIZE");
            DBColumn column = new DBColumn(uno,dos ,
                   tres);

            //checks if this column is the primary key
//            for (String primaryKey : primaryKeys) {
//                if (primaryKey.equals(column.name)) {
//                    column.primaryKey = true;
//                }
//            }

            result.add(column);
        }

        return result;
    }

    //Método agregado por Daniel Serrano
    //Consulta y retorna un List con los nombres de las bases de datos
    public ArrayList<String> getSchemasNames() throws SQLException {
        res = connection.getMetaData().getCatalogs();
        ArrayList<String> schemas = new ArrayList<String>();

        while (res.next()) {
            String nombreBase = res.getString("TABLE_CAT");
            if (!nombreBase.equals("information_schema")  && !nombreBase.equals("cr_debug")  && !nombreBase.equals("mysql") && !nombreBase.equals("information_schema")) {
                schemas.add(nombreBase);
            }

        }
        return schemas;
    }
}
