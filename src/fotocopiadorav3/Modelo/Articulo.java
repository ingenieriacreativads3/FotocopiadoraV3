/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fotocopiadorav3.Modelo;

import com.mysql.cj.util.Util;
import java.util.*;
import java.sql.*;

/**
 *
 * @author Tomás Contreras
 */
public class Articulo {
    
    //Atributos
    
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
    
    private int id;                         //tipo bd
    private AlfaNumerico documento;         //id identificador
    private Estado categoria;               //id identificador
    private double precio;                  //tipo bd
    private java.sql.Date fechaIngreso;     //tipo bd
    private AlfaNumerico nombre;            //id identificador
    private AlfaNumerico autor;             //id identificador
    private AlfaNumerico editorial;         //id identificador
    private AlfaNumerico edicion;           //id identificador
    private Materia materia;           //id identificador
    
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
    
    public Estado guardar(){
        
        Estado estadoDevolver = Estado.ERROR;
        
        ConexionMySql conn = new ConexionMySql();
        PreparedStatement prepared = conn.getPreparedStatement(CANTIDAD_DE_CAMPOS, NOMBRE_TABLA);
        
        //System.out.println("entra a guardar");
        try {
            
            prepared.setInt(LUGAR_DEL_CAMPO_ID, this.id);
            prepared.setInt(LUGAR_DEL_CAMPO_ID_DOCUMENTO, this.idDocumento);
            prepared.setInt(LUGAR_DEL_CAMPO_ID_CATEGORIA, this.idCategoria);
            prepared.setDouble(LUGAR_DEL_CAMPO_PRECIO, this.precio);
            prepared.setDate(LUGAR_DEL_CAMPO_FECHA_INGRESO, this.fechaIngreso);
            prepared.setInt(LUGAR_DEL_CAMPO_ID_NOMBRE, this.idNombre);
            prepared.setInt(LUGAR_DEL_CAMPO_ID_AUTOR, this.idAutor);
            prepared.setInt(LUGAR_DEL_CAMPO_ID_EDITORIAL, this.idEditorial);
            prepared.setInt(LUGAR_DEL_CAMPO_ID_EDICION, this.idEdicion);
            prepared.setInt(LUGAR_DEL_CAMPO_ID_MATERIA, this.idMateria);
            
            //System.out.println(prepared.toString());
            
            prepared.executeUpdate();
            
            estadoDevolver = Estado.EXITO;
            prepared.close();
            conn.closeConn(Articulo.class.toString() + "guardar");
            
            
        } catch (Exception e) {
            
            estadoDevolver = Estado.ERROR_PERSISTENCIA_INCORRECTA;
            System.out.println("se rompe en la persistencia de " + Articulo.class.toString() + " guardar");
            e.printStackTrace();
            
        }
        
        return estadoDevolver;
        
    }
    
    protected static Articulo getForId(int idRecibido){
        
        Articulo articuloDevolver = OBJETO_INVALIDO;
        
        Estado seObtuvo = Estado.EXITO;
        //Estado seObtuvo = getInformacion();
        
        if(listaObjetos != null){
            
            if(seObtuvo == Estado.EXITO){

                for(Articulo articuloActual : listaObjetos){

                    if(articuloActual.id == idRecibido){

                        articuloDevolver = articuloActual;

                    }else{

                        //...se establecion un valor por defecto

                    }
                }

            }else{

                //TODO capturar el error producido por no haber capturado la info de la db
                System.out.println("Se rompio en Direccion.getForId();");

            }
            
        }else{
            
            //...no hacer nada
            
        }
        return articuloDevolver;
        
    }
    
    public Estado modificar(double precioRecibido, java.sql.Date fechaIngresoRecibida, AlfaNumerico nombreRecibido, AlfaNumerico autorRecibido, AlfaNumerico editorialRecibida, AlfaNumerico edicionRecibida, Materia materiaRecibida){
        
        Estado estadoDevolver = Estado.ERROR;
        
        this.borrar();
        Articulo nuevoObjeto = Articulo.nuevo(precioRecibido, fechaIngresoRecibida, nombreRecibido, autorRecibido, editorialRecibida, edicionRecibida, materiaRecibida);
        nuevoObjeto.setId(this.id);
        
        if(nuevoObjeto.guardar() == Estado.EXITO){
            
            estadoDevolver = Estado.EXITO;
            
        }else{
            
            nuevoObjeto.borrar();
            
        }
        
        return estadoDevolver;
    }
    
    public Estado borrar(){
        
        Estado estadoDevolver = Estado.ERROR;
        
        ConexionMySql conn = new ConexionMySql();
        PreparedStatement prepared = conn.getPreparedStatementD(NOMBRE_TABLA);
        
        try {
            
            prepared.setInt(LUGAR_DEL_CAMPO_ID, this.id);
            
            //System.out.println(prepared.toString());
            listaObjetos.remove(this);
            System.out.println("se remueve el objeto");
            if(true){
                
                prepared.executeUpdate();
                
                
                System.out.println("ejecuta a sentencia" + prepared.toString());
                estadoDevolver = Estado.EXITO;
                
            }else{
                
                estadoDevolver = Estado.ERROR_LISTA_REMOVE;
                
            }
            
            prepared.close();
            conn.closeConn("borrar");
            
        } catch (Exception e) {
            System.out.println("se rompe en borrar");
            
            estadoDevolver = Estado.ERROR_PERSISTENCIA_INCORRECTA;
            
        }
        
        return estadoDevolver;
    }

    protected static Estado getInformacion(){
        
        Estado estadoDevolver = Estado.ERROR;
        
        //System.out.println("pregunta por los articulos");
        
        ResultSet rs = null;
        
        ConexionMySql conn = new ConexionMySql();
        PreparedStatement prepared = conn.getPreparedStatement(NOMBRE_TABLA);
        
        try {
            
            rs = prepared.executeQuery();
            
            while (rs.next()) {
                
                int idObjeto = rs.getInt(CAMPO_ID);
                int idDocumento = rs.getInt(CAMPO_ID_DOCUMENTO);
                int idCategoria = rs.getInt(CAMPO_ID_CATEGORIA);
                double precio = rs.getDouble(CAMPO_PRECIO);
                java.sql.Date fechaIngreso = rs.getDate(CAMPO_FECHA_INGRESO);
                int idNombre = rs.getInt(CAMPO_ID_NOMBRE);
                int idAutor = rs.getInt(CAMPO_ID_AUTOR);
                int idEditorial = rs.getInt(CAMPO_ID_EDITORIAL);
                int idEdicion = rs.getInt(CAMPO_ID_EDICION);
                int idMateria = rs.getInt(CAMPO_ID_MATERIA);
                
                AlfaNumerico documentoObjeto = AlfaNumerico.getForId(idDocumento);
                Estado categoriaObjeto = Estado.getForId(idCategoria);
                AlfaNumerico nombreObjeto = AlfaNumerico.getForId(idNombre);
                AlfaNumerico autorObjeto = AlfaNumerico.getForId(idAutor);
                AlfaNumerico editorialObjeto = AlfaNumerico.getForId(idEditorial);
                AlfaNumerico edicionObjeto = AlfaNumerico.getForId(idEdicion);
                Materia materiaObjeto = Materia.getForId(idMateria);
                
                Articulo asd = Articulo.nuevo(idObjeto, documentoObjeto, categoriaObjeto, precio, fechaIngreso, nombreObjeto, autorObjeto, editorialObjeto, edicionObjeto, materiaObjeto, documentoObjeto.getId(), categoriaObjeto.getId(), nombreObjeto.getId(), autorObjeto.getId(), editorialObjeto.getId(), edicionObjeto.getId(), materiaObjeto.getId());
                
                //System.out.println("este es el articulo numero: " + asd.id);
                
            }
            
            estadoDevolver = Estado.EXITO;
            prepared.close();
            conn.closeConn(Articulo.class.toString() + "getInformacion");
            
        } catch (Exception e) {
            
            estadoDevolver = Estado.ERROR_PERSISTENCIA_INCORRECTA;
            
        }
        
        return estadoDevolver;
        
    }
    
    private static int getLastId(){
        
        int ultimoID = 0;
        
        Estado estadoConsulta = Estado.EXITO;
        //Estado estadoConsulta = getInformacion();

        if(listaObjetos != null){
            
            System.out.println("la lista no es nula");

            if(estadoConsulta == Estado.EXITO){

                for(Articulo articuloActual : listaObjetos){

                    if(articuloActual.id > ultimoID){

                        ultimoID = articuloActual.id;

                    }else{

                        //...no hacer nada

                    }

                }

            }else{

                //...no hacer nada

            }

        }else{

            //...se establecio unvalor por defecto

        }
        
        return ultimoID;
        
    }

    private static int getNewId(){

        //Obtener el ultimo identificador
        int idActual = getLastId();

        //Buscar el siguiente identificador
        int siguienteIdentificador = Valor.SIGUIENTE_IDENTIFICADOR;

        //Combinar ambos valores
        idActual = idActual + siguienteIdentificador;
        //System.out.println("el valor del siuiente id es " + idActual);

        //Devolver el nuevo identificador
        return idActual;

    }

    //Constructor
    
    private static Articulo nuevo(int idRecibido, AlfaNumerico documentoRecibido, Estado categoriaRecibida, double precioRecibido, java.sql.Date fechaIngresoRecibida, AlfaNumerico nombreRecibido, AlfaNumerico autorRecibido, AlfaNumerico editorialRecibido, AlfaNumerico edicionRecibida, Materia materiaRecibida, int idDocumentoRecibido, int idCategoriaRecibida, int idNombreRecibido, int idAutorRecibido, int idEitorialRecibida, int idEdicionRecibida, int idMateriarecibida){
        
        Articulo articuloDevolver = new Articulo();
        
        articuloDevolver.id = idRecibido;
        articuloDevolver.documento = documentoRecibido;
        articuloDevolver.categoria = categoriaRecibida;
        articuloDevolver.precio = precioRecibido;
        articuloDevolver.fechaIngreso = fechaIngresoRecibida;
        articuloDevolver.nombre = nombreRecibido;
        articuloDevolver.autor = autorRecibido;
        articuloDevolver.editorial = editorialRecibido;
        articuloDevolver.edicion = edicionRecibida;
        articuloDevolver.materia = materiaRecibida;
        
        articuloDevolver.idDocumento = idDocumentoRecibido;
        articuloDevolver.idCategoria = idCategoriaRecibida;
        articuloDevolver.idNombre = idNombreRecibido;
        articuloDevolver.idAutor = idAutorRecibido;
        articuloDevolver.idEditorial = idEitorialRecibida;
        articuloDevolver.idEdicion = idEdicionRecibida;
        articuloDevolver.idMateria = idMateriarecibida;
        
        Estado seAgrego = Articulo.addNewObjeto(articuloDevolver);
        
        if(!(seAgrego == Estado.EXITO)){
            
            //listaObjetos.remove(usuarioDevolver);
            
        }else{
            
            //...no hacer nada
            
        }
        
        return articuloDevolver;
    }
    
    protected static Articulo nuevo(double precioRecibido, java.sql.Date fechaIngresoRecibida, AlfaNumerico nombreRecibido, AlfaNumerico autorRecibido, AlfaNumerico editorialRecibida, AlfaNumerico edicionRecibida, Materia materiaRecibida){

        AlfaNumerico documentoRecibido = AlfaNumerico.nuevo("ruta relativa del documento");
        documentoRecibido.guardar();
        Estado categoriaRecibida = Estado.TUTORIAS;
        
        //System.out.println("entra a nuevo");
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
            Estado seSeteoPrecio = objetoNuevo.setPrecio(precioRecibido);
            Estado seSeteoDocumento = objetoNuevo.setDocumento(documentoRecibido);
            Estado seSeteoCategoria = objetoNuevo.setCategoria(categoriaRecibida);
            Estado seSeteoFechaIngreso = objetoNuevo.setFechaIngreso(fechaIngresoRecibida);
            Estado seSeteoNombre = objetoNuevo.setNombre(nombreRecibido);
            Estado seSeteoAutor = objetoNuevo.setAutor(autorRecibido);
            Estado seSeteoEditorial = objetoNuevo.setEditorial(editorialRecibida);
            Estado seSeteoEdicion = objetoNuevo.setEdicicon(edicionRecibida);
            Estado seSeteoMateria = objetoNuevo.setMateria(materiaRecibida);
            
            Estado seSeteoIdDocumento = objetoNuevo.setIdDocumento(documentoRecibido.getId());
            Estado seSeteoIdCategoria = objetoNuevo.setIdCategoria(categoriaRecibida.getId());
            Estado seSeteoIdNombre = objetoNuevo.setIdNombre(nombreRecibido.getId());
            Estado seSeteoIdAutor = objetoNuevo.setIdAutor(autorRecibido.getId());
            Estado seSeteoIdEditorial = objetoNuevo.setIdEditorial(editorialRecibida.getId());
            Estado seSeteoIdEdicion = objetoNuevo.setIdEdicion(edicionRecibida.getId());
            Estado seSeteoIdMateria = objetoNuevo.setIdMateria(materiaRecibida.getId());
            
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
    
    private void setId(int id) {
        this.id = id;
    }
    
    private Estado setPrecio(double precioRecibido){
        
        Estado estadoDevolver = Estado.EXITO;
        
        //Asignar el valor recibido
        this.precio = precioRecibido;
        
        return estadoDevolver;
        
    }
    
    private Estado setDocumento(AlfaNumerico documentoRecibido){
        
        Estado estadoDevolver = Estado.EXITO;
        
        //Asignar el valor recibido
        this.documento = documentoRecibido;
        
        return estadoDevolver;
        
    }
    
    private Estado setCategoria(Estado categoriaRecibido){
        
        Estado estadoDevolver = Estado.EXITO;
        
        //Asignar el valor recibido
        this.categoria = categoriaRecibido;
        
        return estadoDevolver;
        
    }
    
    private Estado setFechaIngreso(java.sql.Date fechaRecibida){
        
        Estado estadoDevolver = Estado.EXITO;
        
        //Asignar el valor recibido
        this.fechaIngreso = fechaRecibida;
        
        return estadoDevolver;
        
    }
    
    private Estado setNombre(AlfaNumerico nombreRecibido){
        
        Estado estadoDevolver = Estado.EXITO;
        
        //Asignar el valor recibido
        this.nombre = nombreRecibido;
        
        return estadoDevolver;
        
    }
    
    private Estado setAutor(AlfaNumerico autorRecibido){
        
        Estado estadoDevolver = Estado.EXITO;
        
        //Asignar el valor recibido
        this.autor = autorRecibido;
        
        return estadoDevolver;
        
    }
    
    private Estado setEditorial(AlfaNumerico editorialRecibido){
        
        Estado estadoDevolver = Estado.EXITO;
        
        //Asignar el valor recibido
        this.editorial = editorialRecibido;
        
        return estadoDevolver;
        
    }
    
    private Estado setEdicicon(AlfaNumerico edicionRecibido){
        
        Estado estadoDevolver = Estado.EXITO;
        
        //Asignar el valor recibido
        this.edicion = edicionRecibido;
        
        return estadoDevolver;
        
    }
    
    private Estado setMateria(Materia materiaRecibido){
        
        Estado estadoDevolver = Estado.EXITO;
        
        //Asignar el valor recibido
        this.materia = materiaRecibido;
        
        return estadoDevolver;
        
    }

    private Estado setIdDocumento(int idDocumentoRecibido) {
        
        Estado estadoDevolver = Estado.EXITO;
        
        this.idDocumento = idDocumentoRecibido;
        
        return estadoDevolver;
    }

    private Estado setIdCategoria(int idCategoriaRecibido) {
        
        Estado estadoDevolver = Estado.EXITO;
        
        this.idCategoria = idCategoriaRecibido;
        
        return estadoDevolver;
    }

    private Estado setIdNombre(int idNombreRecibido) {
        
        Estado estadoDevolver = Estado.EXITO;
        
        this.idNombre = idNombreRecibido;
        
        return estadoDevolver;
    }

    private Estado setIdAutor(int idAutorRecibido) {
        
        Estado estadoDevolver = Estado.EXITO;
        
        this.idAutor = idAutorRecibido;
        
        return estadoDevolver;
    }

    private Estado setIdEditorial(int idEditorialRecibido) {
        
        Estado estadoDevolver = Estado.EXITO;
        
        this.idEditorial = idEditorialRecibido;
        
        return estadoDevolver;
    }

    private Estado setIdEdicion(int idEdicionRecibido) {
        
        Estado estadoDevolver = Estado.EXITO;
        
        this.idEdicion = idEdicionRecibido;
        
        return estadoDevolver;
    }

    private Estado setIdMateria(int idMateriaRecibido) {
        
        Estado estadoDevolver = Estado.EXITO;
        
        this.idMateria = idMateriaRecibido;
        
        return estadoDevolver;
    }
    
    //Getter
    
    protected static Set<Articulo> getListaObjetos() {
        
        Set<Articulo> listaDevolver = new HashSet<>();
        
        listaDevolver = listaObjetos;
        
        return listaDevolver;
    }

    public int getId() {
        return id;
    }

    public AlfaNumerico getDocumento() {
        
        AlfaNumerico alfanumericoDevolver = AlfaNumerico.OBJETO_INVALIDO;
        
        alfanumericoDevolver = this.documento;
        
        return alfanumericoDevolver;
    }

    public Estado getCategoria() {
        
        Estado estadoDevolver = Estado.ERROR;
        
        estadoDevolver = this.categoria;
        
        return estadoDevolver;
    }

    public double getPrecio() {
        return precio;
    }

    public java.util.Date getFechaIngreso() {
        
        java.sql.Date fechaDevolver = new java.sql.Date(1);
        
        fechaDevolver = this.fechaIngreso;
        
        return fechaDevolver;
    }

    public AlfaNumerico getNombre() {
        
        AlfaNumerico alfanumericoDevolver = AlfaNumerico.OBJETO_INVALIDO;
        
        alfanumericoDevolver = this.nombre;
        
        return alfanumericoDevolver;
    }

    public AlfaNumerico getAutor() {
        
        AlfaNumerico alfanumericoDevolver = AlfaNumerico.OBJETO_INVALIDO;
        
        alfanumericoDevolver = this.autor;
        
        return alfanumericoDevolver;
    }

    public AlfaNumerico getEditorial() {
        
        AlfaNumerico alfanumericoDevolver = AlfaNumerico.OBJETO_INVALIDO;
        
        alfanumericoDevolver = this.editorial;
        
        return alfanumericoDevolver;
    }

    public AlfaNumerico getEdicion() {
        
        AlfaNumerico alfanumericoDevolver = AlfaNumerico.OBJETO_INVALIDO;
        
        alfanumericoDevolver = this.edicion;
        
        return alfanumericoDevolver;
    }

    public Materia getMateria() {
        
        Materia materiaDevolver = Materia.OBJETO_INVALIDO;
        
        materiaDevolver = this.materia;
        
        return materiaDevolver;
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
