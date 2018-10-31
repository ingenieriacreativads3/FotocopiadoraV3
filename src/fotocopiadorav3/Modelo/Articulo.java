/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fotocopiadorav3.Modelo;

import java.util.*;

/**
 *
 * @author Tomás Contreras
 */
public class Articulo {
    
    //atributos
    
    private static final String NOMBRE_TABLA = "articulo";
    
    private static final String CAMPO_ID = "id";
    private static final String CAMPO_ID_DOCUMENTO = "id_documento";
    private static final String CAMPO_ID_CATEGORIA = "id_categoria";
    private static final String CAMPO_PRECIO = "precio";
    private static final String CAMPO_FECHA_INGRESO = "fecha_ingreso";
    private static final String CAMPO_ID_NOMBRE = "id_nombre";
    private static final String CAMPO_ID_AUTOR = "id_autor";
    private static final String CAMPO_ID_EDITORIAL = "id_editorial";
    private static final String CAMPO_ID_EDICION = "id_edicion";
    private static final String CAMPO_ID_MATERIA = "id_materia";
    
    private static final int CANTIDAD_DE_CAMPOS = 10;
    private static final int LUGAR_DEL_CAMPO_ID = 1;
    private static final int LUGAR_DEL_CAMPO_ID_DOCUMENTO = 2;
    private static final int LUGAR_DEL_CAMPO_ID_CATEGORIA = 3;
    private static final int LUGAR_DEL_CAMPO_PRECIO = 4;
    private static final int LUGAR_DEL_CAMPO_FECHA_INGRESO = 5;
    private static final int LUGAR_DEL_CAMPO_ID_NOMBRE = 6;
    private static final int LUGAR_DEL_CAMPO_ID_AUTOR = 7;
    private static final int LUGAR_DEL_CAMPO_ID_EDITORIAL = 8;
    private static final int LUGAR_DEL_CAMPO_ID_EDICION = 9;
    private static final int LUGAR_DEL_CAMPO_ID_MATERIA = 10;
    
    private int id;               //tipo bd
    private AlfaNumerico documento;     //id identificador
    private Estado categoria;           //id identificador
    private double precio;              //tipo bd
    private Date fechaIngreso;          //tipo bd
    private AlfaNumerico nombre;        //id identificador
    private AlfaNumerico autor;         //id identificador
    private AlfaNumerico editorial;     //id identificador
    private AlfaNumerico edicion;       //id identificador
    private AlfaNumerico materia;       //id identificador
    
    private int idDocumento;            
    private int idCategoria;
    private int idNombre;
    private int idAutor;
    private int idEditorial;
    private int idEdicion;
    private int idMateria;
            
    protected final static Articulo OBJETO_INVALIDO = new Articulo();

    private static Set<Articulo> listaObjetos = new HashSet<>();
    
    //Rutinas
    
    public Estado modificar(double precioRecibida, Date fechaIngresoRecibida, AlfaNumerico nombreRecibido, AlfaNumerico autorRecibido, AlfaNumerico editorialRecibida, AlfaNumerico edicionRecibida, AlfaNumerico materiaRecibida){
        
        return Estado.ERROR;
    }
    
    public Estado borrar(){
        
        return Estado.ERROR;
    }

    private static int getNewId(){

        //Crear un nuevo identificador
        int idActual = listaObjetos.size();

        //Buscar el siguiente identificador
        int siguienteIdentificador = Valor.SIGUIENTE_IDENTIFICADOR;

        //Combinar ambos valores
        idActual = idActual + siguienteIdentificador;

        //Devolver el nuevo identificador
        return idActual;

    }

    //Constructor
    
    protected static Articulo nuevo(double precioRecibida, Date fechaIngresoRecibida, AlfaNumerico nombreRecibido, AlfaNumerico autorRecibido, AlfaNumerico editorialRecibida, AlfaNumerico edicionRecibida, AlfaNumerico materiaRecibida){

        //Crear un objeto a devolver
        Articulo objetoDevolver = Articulo.OBJETO_INVALIDO;

        //Obtener el siguiente identificador
        int identificador = getNewId();
        
        //Crear un nuevo objeto
        Articulo objetoNuevo = new Articulo(identificador);

        //Agregar a la lista de control
        Estado seAgrego = addNewObjeto(objetoNuevo);

        //Si se agrega con exito
        if(seAgrego == Estado.EXITO){
            
            //Asignar el valor recibido por defecto
            
            
            objetoDevolver = objetoNuevo;
            
            //Estado seGuardo = objetoDevolver.guardar();

        }else{

            //TODO capturar el error generado por un ingreso erroneo a la lista
            listaObjetos.remove(objetoDevolver);
            //...se establecio un valor por defecto

        }

        //Devolver el objeto requerido
        return objetoDevolver;

    }

    private Articulo(int identificadorRecibido) {

        //Asignar un identificador
        this.id = identificadorRecibido;


    }
    
    private Articulo() {}

    private static Articulo nuevo(){

        //Crear un objeto a devolver
        Articulo objetoDevolver = Articulo.OBJETO_INVALIDO;

        //Crear un nuevo objeto
        Articulo objetoNuevo = new Articulo();

        //Agregar a la lista de control
        Estado seAgrego = addNewObjeto(objetoNuevo);

        //Si se agrega con exito
        if(seAgrego == Estado.EXITO){

            //Establecer el objeto a devolver
            objetoDevolver = objetoNuevo;

        }else{

            //TODO capturar el error generado por un ingreso erroneo a la lista
            //...se establecio un valor por defecto

        }

        //Devolver el objeto requerido
        return objetoDevolver;

    }

    //Manejo de lista

    private static Estado addNewObjeto(Object objetoActual){

        //Establecer un valor por defecto
        Estado estadoDevolver= Estado.ERROR;

        //Si el objeto recibido es del tipo correcto
        if(objetoActual.getClass() == Articulo.class){

            //Obtener el objeto requerido
            Articulo objetoAgregar = (Articulo)objetoActual;

            //Agregar el nuevo elemento a la lista
            boolean seAgrego;
            seAgrego = listaObjetos.add(objetoAgregar);

            if(seAgrego){

                //...asignar el estado correspondiente
                estadoDevolver = Estado.EXITO;

            }else{

                //...se establecio un valor por defecto

            }//...fin if


        }else{

            //...se establecio un valor por defecto

        }//...fin if

        //Devolver el estado correspondiente
        return estadoDevolver;

    }//...fin funcion
    
    //Setter
    
    private Estado setPrecio(double precioRecibido){
        
        Estado estadoDevolver = Estado.EXITO;
        
        //Asignar el valor recibido
        this.precio = precioRecibido;
        
        return estadoDevolver;
        
    }
    
    private Estado setFechaIngreso(Date fechaRecibida){
        
        Estado estadoDevolver = Estado.EXITO;
        
        //Asignar el valor recibido
        this.fechaIngreso = fechaRecibida;
        
        return estadoDevolver;
        
    }
    
//    autor
//            editorial
//            edicion
//                    materia
    
    private Estado setNombre(AlfaNumerico nombreRecibido){
        
        Estado estadoDevolver = Estado.EXITO;
        
        //Asignar el valor recibido
        this.nombre = nombreRecibido;
        
        return estadoDevolver;
        
    }
    
    private Estado setAutor(AlfaNumerico autorRecibido){
        
        Estado estadoDevolver = Estado.EXITO;
        
        //Asignar el valor recibido
        this.nombre = autorRecibido;
        
        return estadoDevolver;
        
    }
    
    private Estado setEditorial(AlfaNumerico editorialRecibido){
        
        Estado estadoDevolver = Estado.EXITO;
        
        //Asignar el valor recibido
        this.nombre = editorialRecibido;
        
        return estadoDevolver;
        
    }
    
    //Getter

    public int getId() {
        return id;
    }

    public AlfaNumerico getDocumento() {
        return documento;
    }

    public Estado getCategoria() {
        return categoria;
    }

    public double getPrecio() {
        return precio;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public AlfaNumerico getNombre() {
        return nombre;
    }

    public AlfaNumerico getAutor() {
        return autor;
    }

    public AlfaNumerico getEditorial() {
        return editorial;
    }

    public AlfaNumerico getEdicion() {
        return edicion;
    }

    public AlfaNumerico getMateria() {
        return materia;
    }
    
    
    
    //Others
    
    @Override
    public boolean equals(Object objetoActual) {

        if(objetoActual == null){return false;}
        if(this.getClass() != objetoActual.getClass()){return false;}

        final Articulo objetoRecibido = (Articulo) objetoActual;

        if(this.hashCode() != objetoRecibido.hashCode()){return false;}

        return true;

    }

    @Override
    public int hashCode() {

        return this.id;

    }
    
    @Override
    public String toString() {
        
        return this.documento.toString();
        
    }
    
}
