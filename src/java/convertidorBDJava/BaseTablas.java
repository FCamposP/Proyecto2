/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convertidorBDJava;

import java.util.List;

/**
 *
 * @author fabry
 */
public class BaseTablas {
    
    private DtoTabla tabla;
    
    private List<DBColumn> columnas;

    
    public DtoTabla getTabla() {
        return tabla;
    }

    public void setTabla(DtoTabla tabla) {
        this.tabla = tabla;
    }

    public List<DBColumn> getColumnas() {
        return columnas;
    }

    public void setColumnas(List<DBColumn> columnas) {
        this.columnas = columnas;
    }
    
    public void addColumna(DBColumn columna){
        this.columnas.add(columna);
    }
    
    public void clearColumnas(){
        this.columnas.clear();
    }
}
