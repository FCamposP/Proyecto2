/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.clases;


import componentegestordearchivos.Archivo;
import componentegestordearchivos.ArchivoBean;
import java.util.ArrayList;
import datos.clases.Clase;
import datos.clases.Atributo;
import datos.clases.AtributoMostrar;
import datos.clases.Formato;

/**
 *
 * @author fabry
 */
public class GeneradorJava {

    private static String espacios = "    ";
    private static String paquete="package fc1;\n";
    private static String mensajeArchivo = "/* \n * Codigo generado por WIFA Gencompiler\n */\n\n";
    private static ArrayList<AtributoMostrar> listaDeclaracionAtributos;
    private static ArrayList<AtributoMostrar> listaDeclaracionAtributosPrimitivos;
    private static ArrayList<Metodos> listaDeMetodos;
    private static ArrayList<Parametro> listaDeParametros;

        public static void CrearArchivos(ArrayList<Clase> listaClases, int opcion) {

        ArrayList<Archivo> archivos = new ArrayList<Archivo>();
        archivos.add(new Archivo(GenerarClaseMain(), "Main.java"));
        
        try {
            for (Clase clase : listaClases) {

                //   for (Clase clas:listaClases)
                String codigo = GenerarCodigoJava(clase);
                //pw.println(codigo);
                archivos.add(new Archivo(codigo, clase.getNombre() + ".java"));
                //fichero.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
        if(opcion==1){
           ArchivoBean.setClases(archivos);   
        }else{
              ArchivoBean.setClases2(archivos);
        }
      
    }

    
    public static String GenerarCodigoJava(Clase clase) {
        
        String importJava = "import java.util.ArrayList;\n\n";
        String importDate="import java.util.Date;\n\n";
        String codigoCompleto="";
        String X="";
        boolean hayListas=false;
        
        //Generación de código Java
        X += "public class " + clase.getNombre() + (clase.isHija() ? " extends " + clase.getNombrePadre() + " " : " ") + "{\n";
        String tipoAcceso = clase.isHija() ? "protected" : "private";
        // atributos
        X += "\n";
        X += GenerarDeclaracionAtributos(clase);

        //Constructor Vacio
        X += GenerarConstructorDefault(clase);
        X += "\n\n";
        //Constructor con Parametros
        X += espacios + "//Constructor con parametros\n";
        X += espacios + GenerarConstructorConParametrosJava(clase);
        X += GenerarGettersAndSetters();
          //Metodos
        X+="\n";
        X+=GenerarMetodos(clase);      
        //codigo de metodos cuando los atributos son una lista de objetos
        hayListas=VerificarExistenListas(clase);
        if(hayListas){
              X+=espacios+"//Metodos para uso de ArrayList\n";
        }
      
        X += GenerarMetodosListas();

        X += "}";
        if (hayListas) {
            codigoCompleto=paquete;
            codigoCompleto+=importJava;
            codigoCompleto+=mensajeArchivo;
            codigoCompleto+=X;
        }else{
            codigoCompleto=paquete;
            codigoCompleto+=mensajeArchivo;
            codigoCompleto+=X;
        }
        /*codigo para el uso de Date*/
       boolean usoDate=false;
        usoDate=VerificarUsoDate();
        if(usoDate){
            codigoCompleto=paquete;
            codigoCompleto+=importDate;
            codigoCompleto+=mensajeArchivo;
            codigoCompleto+=X;
        }
        return codigoCompleto;
    }

    private static boolean VerificarExistenListas(Clase clase) {

        boolean existen = false;
        int cantidad = 0;
        for (Atributo atributo : clase.getAtributos()) {
            if (atributo.isIsLista()) {
                cantidad++;
            }
        }
        if (cantidad > 0) {
            existen = true;
        }
        return existen;
    }
    private static boolean VerificarUsoDate() {

        boolean existen = false;
        int cantidad = 0;
         for (AtributoMostrar mostrarAtributo : listaDeclaracionAtributosPrimitivos) {
           
            if(obtenerTipoAtributo(mostrarAtributo.getTipoDato())=="Date"){ /*Verifica si hay un dato de tipo Date */
             cantidad++;
            }}
        if (cantidad > 0) {
            existen = true;
        }
        return existen;
    }

    private static String GenerarDeclaracionAtributos(Clase clase) {
        String x = "";
        AtributoMostrar nuevoAtributoMostrar;
        listaDeclaracionAtributos = new ArrayList<AtributoMostrar>();
        listaDeclaracionAtributosPrimitivos = new ArrayList<AtributoMostrar>();
        for (Atributo atributo : clase.getAtributos()) {
            if (atributo.isIsLista()) {
                nuevoAtributoMostrar = new AtributoMostrar(atributo.getNombreTipoPropiedad(), atributo.getNombre());
                listaDeclaracionAtributos.add(nuevoAtributoMostrar);
            } else {
                nuevoAtributoMostrar = new AtributoMostrar(atributo.getNombreTipoPropiedad(), atributo.getNombre());
                listaDeclaracionAtributosPrimitivos.add(nuevoAtributoMostrar);
            }
        }

        for (AtributoMostrar mostrarAtributo : listaDeclaracionAtributosPrimitivos) {
           
            if(obtenerTipoAtributo(mostrarAtributo.getTipoDato())=="Date"){ /*si el tipo de dato es Date la declaracion es distinta*/
                x+= "    private" + " "+obtenerTipoAtributo(mostrarAtributo.getTipoDato()) + " "+ mostrarAtributo.getNombreVariable()+"= "+"new"+ " "+obtenerTipoAtributo(mostrarAtributo.getTipoDato())+"()"+ ";\n";
            }
            else{
             x += "    private" + " " + obtenerTipoAtributo(mostrarAtributo.getTipoDato()) + " " + mostrarAtributo.getNombreVariable() + ";\n";
            
            }
        }
        for (AtributoMostrar mostrarAtributo : listaDeclaracionAtributos) {
            x += "    private" + " ArrayList<" + obtenerTipoAtributo(mostrarAtributo.getTipoDato())  + "> " + mostrarAtributo.getNombreVariable() + ";\n";
        }

        return x;

    }
    
       private static String GenerarMetodos(Clase clase)
    {
        String x="";
       // x+="\n"+espacios+"//Metodos\n";
        Metodos nuevoMetod;
        listaDeMetodos=new ArrayList<Metodos>();
        for(Metodos m:clase.getMetodos()){
             nuevoMetod = new Metodos(m.getTipo(), m.getNombre());
                listaDeMetodos.add(nuevoMetod);
           // clase.adicionarMetodo(m);
            x += espacios + "public"+" " +nuevoMetod.getTipo() + " "+ nuevoMetod.getNombre() +"( "+
                   // nuevoMetod.getParametros() +
                              
                    " )"+" {\n\n" + espacios + "}"+"\n\n" ;
        } 
        return x;
    }
       private static void GenerarParametros(Metodos metodo){
       Parametro nuevoP;
       listaDeParametros =new ArrayList<Parametro>();
       for(Parametro p: metodo.getParametros()){
       nuevoP=new Parametro(p.getTipo(),p.getNombre());
       listaDeParametros.add(p);
       }
       
       }
    
    private static String obtenerTipoAtributo(String tipoDato){
        String tipo="";
        tipo=tipoDato;
        switch(tipoDato){
            case "VARCHAR":
                tipo="String";
                break;
            case "TEXT":
                tipo="String";
                break;
            case "INT":
                tipo="int";
                break;
            case "BOOLEAN":
                tipo="boolean";
                break;
            case "Integer":
                tipo="int";
                break;
            case "DOUBLE":
                tipo="double";
                break;
            case "EDouble":
                tipo="double";
                break;
            case "BIT":
                tipo="bit";
                break;
            case "EDate":
                tipo="Date";
                break;
        }
        return tipo;
    }

    private static String GenerarConstructorDefault(Clase clase) {

        String x = "";

        if (EsVacio(clase)) {
            x += "\n";
            x += espacios + "//Constructor Vacio\n";
            x += espacios + "public " + clase.getNombre() + "()" + " {\n\n" + espacios + "}";
        }
        return x;
    }

    private static String GenerarConstructorConParametrosJava(Clase clase) {

        ArrayList<AtributoMostrar> listaAtributosAMostrar = new ArrayList<AtributoMostrar>();
        AtributoMostrar nuevoAtributoMostrar;
        String X = "";
        X += "public " + clase.getNombre() + "(";
        for (int i = 0; i < clase.getAtributos().size(); i++) {//obtiene la info de los atributos a usar en el constructor y dentro de el
            Atributo atrActual = clase.getAtributos().get(i);
            if (atrActual.isPrimitiva() || (!atrActual.isPrimitiva() && atrActual.getMultiplicidadMinima() == null)) {
                nuevoAtributoMostrar = new AtributoMostrar(atrActual.getNombreTipoPropiedad(), atrActual.getNombre());
                nuevoAtributoMostrar.setLista(atrActual.isIsLista());
                listaAtributosAMostrar.add(nuevoAtributoMostrar);
            }
        }
        
        for (int i = 0; i < listaAtributosAMostrar.size(); i++) {
            AtributoMostrar atributoM= new AtributoMostrar(listaAtributosAMostrar.get(i).getTipoDato(), listaAtributosAMostrar.get(i).getNombreVariable(),listaAtributosAMostrar.get(i).isLista());
            if(atributoM.isLista()){
            X += obtenerTipoAtributo(atributoM.getTipoDato()) + " " + Formato.variable(atributoM.getTipoDato());    
            }
            else{
               X += obtenerTipoAtributo(atributoM.getTipoDato()) + " " + Formato.variable(atributoM.getNombreVariable());
            }
  
            
            if (i + 1 != listaAtributosAMostrar.size()) {
                X += ", ";
            }
        }

        X += "){\n";
        for (AtributoMostrar mostrar : listaDeclaracionAtributosPrimitivos) {
            X += espacios + espacios + "this." + mostrar.getNombreVariable() + " = " + mostrar.getNombreVariable() + ";\n";

        }
        for (int i = 0; i < listaAtributosAMostrar.size(); i++) { /*solo las listas pasadas por parametros en el constructor*/
            AtributoMostrar atributoM= new AtributoMostrar(listaAtributosAMostrar.get(i).getTipoDato(), listaAtributosAMostrar.get(i).getNombreVariable(),listaAtributosAMostrar.get(i).isLista());
            if(atributoM.isLista()){
            X += espacios + espacios + "add" + obtenerTipoAtributo(atributoM.getTipoDato()) + "(" + Formato.variable(atributoM.getTipoDato()) + ");\n";
            }
        }
        
        X += espacios + "}\n";
        return X;

    }

    private static String GenerarGettersAndSetters() {

        String x = "";
        x += "\n" + espacios + "//Getters and Setters\n";
        for (AtributoMostrar atributoMostrar : listaDeclaracionAtributosPrimitivos) {
            //para getter          
            x += "\n" + espacios + "public " + obtenerTipoAtributo(atributoMostrar.getTipoDato()) + " get" + Formato.nombreClase(atributoMostrar.getNombreVariable()) + "()"
                    + " {\n " + espacios + espacios + "return " + atributoMostrar.getNombreVariable() + ";\n" + espacios + "}\n";
            //para setter
            x += "\n" + espacios + "public void set" + Formato.nombreClase(atributoMostrar.getNombreVariable()) + "(" + obtenerTipoAtributo(atributoMostrar.getTipoDato()) + " " + atributoMostrar.getNombreVariable() + ")"
                    + " {\n" + espacios + espacios + "this." + atributoMostrar.getNombreVariable() + " = " + atributoMostrar.getNombreVariable() + ";\n" + espacios + "}\n\n";
        }

        return x;
    }

    private static String GenerarMetodosListas() {
        String x = "";
        for (AtributoMostrar atributo : listaDeclaracionAtributos) {
            //metodo addElemento
            String tipoDato = "";
            String nombreAtributo = "";
            tipoDato = obtenerTipoAtributo(atributo.getTipoDato());
            nombreAtributo = atributo.getNombreVariable();
            x += "\n"+espacios + "public void add" + Formato.nombreClase(tipoDato) + "(" + tipoDato + " element) {\n"
                    + espacios + espacios + nombreAtributo + ".add(element);\n" + espacios + "}\n";

            //metodo getElement
            x += "\n" + espacios + "public " + tipoDato + " get" + Formato.nombreClase(tipoDato) + "(int index){\n"
                    + espacios + espacios + "if(this." + nombreAtributo + ".size()>index){\n"
                    + espacios + espacios + espacios + tipoDato + " element =" + nombreAtributo + ".get(index);\n"
                    + espacios + espacios + espacios + "return element;\n" + espacios + espacios + "}\n"
                    + espacios + espacios + "else\n" + espacios + espacios + espacios + "throw new IllegalArgumentException ( \"Error: Posicion invalida\");\n" + espacios + "}\n";

            //findElement
            x += "\n" + espacios + "public int find" + Formato.nombreClase(tipoDato) + "(" + tipoDato + " element) {\n"
                    + espacios + espacios + "return " + nombreAtributo + ".indexOf(element);\n" + espacios + "}\n";

            //setElement
            x += "\n" + espacios + "public void set" + tipoDato + "(int index, " + tipoDato + " element) {\n"
                    + espacios + espacios + "if(this." + nombreAtributo + ".size() > index)\n"
                    + espacios + espacios + espacios + nombreAtributo + ".set(index,element);\n"
                    + espacios + espacios + "else\n"
                    + espacios + espacios + espacios + "throw new IllegalArgumentException ( \"Error: Posicion invalida\");\n"
                    + espacios + "}\n";

            //removeElement
            x += "\n" + espacios + "public void remove" + tipoDato + "(" + tipoDato + " element) {\n"
                    + espacios + espacios + "if(" + nombreAtributo + ".contains(element))\n"
                    + espacios + espacios + espacios + nombreAtributo + ".remove(element);\n"
                    + espacios + espacios + "else\n"
                    + espacios + espacios + espacios + "throw new IllegalArgumentException ( \"Error: Elemento no existe\");\n"
                    + espacios + "}\n\n";
        }
        return x;
    }
    
    public static String GenerarClaseMain() {

        String x = paquete;
        x += mensajeArchivo;
        x += "public class Main {\n";
        x += espacios + "\npublic static void main(String [] args){\n";
        x += espacios + espacios + "/*\n" + espacios + espacios + " * ESCRIBE AQUI TU CODIGO\n " + espacios + espacios + "*/\n";
        x += espacios + "}\n";
        x += "}";

        return x;
    }

    private static boolean EsVacio(Clase clase) {

        boolean hacerVacio = true;
        int cantidadObligatorios = 0;//si hay campos obligatorios no se generar un constructor vacio
        for (Atributo atributo : clase.getAtributos()) {//verificar si hay campos obligatorios

            if ( atributo.getMultiplicidadMinima() == null && clase.getIdPadre()!=null && clase.getIdPadre()==null) {//no primitivo y null significa atributo no primitivo con multiplicidadMinima unoo
                cantidadObligatorios++;
            }
        }
        
        if (cantidadObligatorios > 0) {
            hacerVacio = false;
        }

        return hacerVacio;
    }
}

//proble denetro del contrunsctor cuando se agregue un nuevo elemennto de lsta en una listaa
