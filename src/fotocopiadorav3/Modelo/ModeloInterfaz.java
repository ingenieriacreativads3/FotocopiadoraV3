/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fotocopiadorav3.Modelo;

import java.sql.*;
import java.util.*; 

/**
 * Esta clase determina la conexion con el exterior del paquete.
 * Aqui se reciben parametros y se solicitan datos por medio
 * de métdos estáticos. Desde ya muchas gracias.
 * 
 * 
 @author Tomas
 */
public class ModeloInterfaz {
    
    //Rutinas
    
    /**
     * Esta rutina verifica la existencia del password
 para un alfaNumericoDevolver específico.
     * 
     * @param nombreUsuario
     * @param passwordUsuario
     * @return boolean
     */
    public static Estado verificaUsuarioPassword(String nombreUsuario, String passwordUsuario){
        
        //Establecer un valor por defecto
        Estado usuarioVerificar = Estado.ERROR;
        
        if(nombreUsuario.getClass() == Valor.VERIFICADOR_DE_CLASE_STRING.getClass()){
            
            if(passwordUsuario.getClass() == Valor.VERIFICADOR_DE_CLASE_STRING.getClass()){
                
                usuarioVerificar = Usuario.verificarUsserPass(nombreUsuario, passwordUsuario);
                
            }else{
                
                usuarioVerificar = Estado.ERROR_DATOS_INVALIDOS;
                
            }
            
        }else{
            
            usuarioVerificar = Estado.ERROR_DATOS_INVALIDOS;
            
        }
        
        return usuarioVerificar;
        
    }
    
    /**
     *Esta rutina verifica la existencia de un alfaNumericoDevolver.
     * 
     * @param nombreActual
     * @return boolean
     */
    public static boolean existeUsuario(String nombreActual){
        
        boolean existe = false;
        
        //System.out.println("entra al modelo interfaz");
        
        if(Usuario.existeNombreUsuario(nombreActual)){
            
            //...establecer un valor de exitencia
            existe = true;
            //System.out.println("existe");
            
        }else{
            
            //...se establecio un valor por defecto
            
        }
        
        return existe;
        
    }
    
    /**
     *Este method devuelve el siguiente identificador de pedido
     * @return
     */
    public static AlfaNumerico getSiguienteCodigoTransaccion() {

        AlfaNumerico nombreDevolver = AlfaNumerico.nuevo("siguienteCodigoTransaccion");
        
        return nombreDevolver;

    }
    
    //getNuevos
    
    public static Persona getNuevaPersona(AlfaNumerico nombreRecibido, AlfaNumerico apellidoRecibido, int dniRecibido, Direccion direccionRecibida){
        
        Persona personaDevolver = Persona.OBJETO_INVALIDO;
        
        personaDevolver = Persona.nuevo(nombreRecibido, apellidoRecibido, dniRecibido, direccionRecibida);
        
        return personaDevolver;
    }
    
    public static Direccion getDireccion(AlfaNumerico calleRecibida, int numeroRecibido){
        
        Direccion direccionDevolver = Direccion.OBJETO_INVALIDO;
        
        Direccion direccionNueva = Direccion.nuevo(calleRecibida, numeroRecibido);
        direccionDevolver = direccionNueva;
        
        return direccionDevolver;
        
    }
    
    public static AlfaNumerico getAlfaNumerico(String palabraRecibida){
        
        AlfaNumerico alfaNumericoDevolver = AlfaNumerico.OBJETO_INVALIDO;
        
        alfaNumericoDevolver = AlfaNumerico.nuevo(palabraRecibida);
        
        return alfaNumericoDevolver;
        
    }
    
    public static Usuario getNuevoUsuario(Persona personaRecibida, AlfaNumerico nombreRecibido, AlfaNumerico passRecibida){
        
        Usuario usuarioDevolver = Usuario.OBJETO_INVALIDO;
        
        usuarioDevolver = Usuario.nuevo(personaRecibida, nombreRecibido, passRecibida);
        
        return usuarioDevolver;
        
    }
    
    public static Pedido getNuevoPedido(java.sql.Date fechaRecibida, double importeRecibida, Alumno alumnoRecibido, AlfaNumerico codigoTransaccionrecibido, double pagoAnticipadoRecibido) {

        Pedido pedidoDevolver = Pedido.OBJETO_INVALIDO;
        
        pedidoDevolver = Pedido.nuevo(fechaRecibida, importeRecibida, alumnoRecibido, codigoTransaccionrecibido, pagoAnticipadoRecibido);

        return pedidoDevolver;

    }
    
    public static Alumno getNuevoAlumno(int legajorecibido, Persona personaRecibida){
        
        Alumno alumnoDevolver = Alumno.OBJETO_INVALIDO;
        
        alumnoDevolver = Alumno.nuevo(legajorecibido, personaRecibida);
        
        return alumnoDevolver;
        
    }
    
    public static Usuario getNuevoUsuario(AlfaNumerico nombrePersonaRecibido, AlfaNumerico apellidoRecibido, int dniRecibido, Direccion direccionRecibida, AlfaNumerico nombreUsuarioRecibido, AlfaNumerico passRecibido){
        
        Persona personaFinal = Persona.nuevo(nombrePersonaRecibido, apellidoRecibido, dniRecibido, direccionRecibida);
        Usuario usuarioDevolver = Usuario.nuevo(personaFinal, nombreUsuarioRecibido, passRecibido);
        
        return usuarioDevolver;
        
    }
    
    public static Articulo getNuevoArticulo(AlfaNumerico nombreRecibido, AlfaNumerico autorRecibido, double precioRecibido, Materia materiaRecibida, java.sql.Date fechaIngresoRecibida, AlfaNumerico editorialRecibida, AlfaNumerico edicionRecibida){
        
        Articulo articuloDevolver = Articulo.OBJETO_INVALIDO;
        
        //Articulo articuloDevolver = Articulo.nuevo(nombreRecibido, autorRecibido, precioRecibido, materiaRecibida);
        articuloDevolver = Articulo.nuevo(precioRecibido, fechaIngresoRecibida, nombreRecibido, autorRecibido, editorialRecibida, edicionRecibida, materiaRecibida);
        
        return articuloDevolver;
    }
    
    public static Carrera getNuevoCarrera(AlfaNumerico identificadorRecibido, AlfaNumerico nombreRecibido){
        
        Carrera carreraDevolver = Carrera.OBJETO_INVALIDO;
        
        carreraDevolver = Carrera.nuevo(identificadorRecibido, nombreRecibido);
        
        return carreraDevolver;
    }
    
    public static Materia geNuevoMateria(AlfaNumerico nombreRecibido, int anioRecibido, Persona titularRecibido, Persona ayudanteRecibido, Persona tutorRecibido, Persona jtpRecibido, Carrera carreraRecibida){
        
        Materia materiaDevolver = Materia.OBJETO_INVALIDO;
        
        materiaDevolver = Materia.nuevo(nombreRecibido, anioRecibido, titularRecibido, ayudanteRecibido, tutorRecibido, jtpRecibido, carreraRecibida);
        
        return materiaDevolver;
    }
    
    public static PedidoArticulo getNuevoPedidoArticulo(double subtotalRecibido, int cantidadRecibida, Estado estadoRecibido, Articulo articuloRecibido, Pedido pedidoRecibido, double importeConDescuentoRecibido, boolean  seCobroConDescuentoRecibido){
        
        PedidoArticulo pedidoArticuloDevolver = PedidoArticulo.OBJETO_INVALIDO;
        
        pedidoArticuloDevolver = PedidoArticulo.nuevo(subtotalRecibido, cantidadRecibida, estadoRecibido, articuloRecibido, pedidoRecibido, importeConDescuentoRecibido, seCobroConDescuentoRecibido);
        
        return pedidoArticuloDevolver;
    }
    
    //getForId
    
    public static Alumno getAlumnoForLegajo(int legajoRecibido){
        
        Alumno alumnoDevolver = Alumno.getForLegajo(legajoRecibido);
        
        return alumnoDevolver;
        
    }
    
    public static AlfaNumerico getAlfanumericoForId(int idAlfanumericoRecibido){
        
        AlfaNumerico alfanumericoDevolver = AlfaNumerico.getForId(idAlfanumericoRecibido);
        
        return alfanumericoDevolver;
    }
    
    public static Direccion getDireccionForId(int idDireccionRecibido){
        
        Direccion direccionDevolver = Direccion.getForId(idDireccionRecibido);
        
        return direccionDevolver;
    }
    
    public static Direccion getDireccionForString(String direccionRecibida){
        
        Direccion direccionDevolver = Direccion.getForString(direccionRecibida);
        
        return direccionDevolver;
    }
    
    public static Usuario getUsuarioForId(int idUsuarioRecibido){
        
        Usuario usuarioDevolver = Usuario.getForId(idUsuarioRecibido);
        
        return usuarioDevolver;
    }
    
    public static Alumno getAlumnoForId(int idAlumnoRecibido){
        
        Alumno alumnoDevolver = Alumno.getForId(idAlumnoRecibido);
        
        return alumnoDevolver;
    }
    
    public static Articulo getArticuloForId(int idArticuloRecibo){
        
        Articulo articuloDevolver = Articulo.getForId(idArticuloRecibo);
        
        return articuloDevolver;
    }
    
    public static Carrera getCarreraForId(int idCarreraRecibida){
        
        Carrera carreraDevolver = Carrera.OBJETO_INVALIDO;
        
        carreraDevolver = Carrera.getForId(idCarreraRecibida);
        
        return carreraDevolver;
    }
    
    public static Materia getMateriaForId(int idMateriaRecibida){
        
        Materia materiaDevolver = Materia.OBJETO_INVALIDO;
        
        materiaDevolver = Materia.getForId(idMateriaRecibida);
        
        return materiaDevolver;
    }
    
    public static Materia getMateriaForNombre(String nombreMateriaRecibida){
        
        Materia materiaDevolver = Materia.OBJETO_INVALIDO;
        
        materiaDevolver = Materia.getForNombre(nombreMateriaRecibida);
        
        return materiaDevolver;
    }
    
    public static Pedido getPedidoForId(int idPedidoRecibido){
        
        Pedido pedidoDevolver = Pedido.OBJETO_INVALIDO;
        
        pedidoDevolver = Pedido.getForId(idPedidoRecibido);
        
        return pedidoDevolver;
    }
    
    public static PedidoArticulo getPedidoArticuloForId(int idPedidoArticuloRecibido){
        
        PedidoArticulo pedidoArticuloDevolver = PedidoArticulo.OBJETO_INVALIDO;
        
        pedidoArticuloDevolver = PedidoArticulo.getForId(idPedidoArticuloRecibido);
        
        return pedidoArticuloDevolver;
    }
    
    public static Persona getPersonaForId(int idPersonaRecibido){
        
        Persona personaDevolver = Persona.OBJETO_INVALIDO;
        
        personaDevolver = Persona.getForId(idPersonaRecibido);
        
        return personaDevolver;
    }
    
    public static Estado getCategoriaForNombre(String categoriaRecibida){
        
        Estado estadoDevolver = Estado.CATEDRA;
        
        if(Estado.TUTORIAS.getMensaje().equals(categoriaRecibida)){
            
            estadoDevolver = Estado.TUTORIAS;
            
        }
        
        return estadoDevolver;
        
    }
    
    //getListaForId
    
    public static Set<PedidoArticulo> getListaPedidoArticuloForIdPedido(int idPedidorecibido){
        
        Set<PedidoArticulo> listaDevolver = new HashSet<>();
        
        for(PedidoArticulo pedidoArticuloActual : PedidoArticulo.getListaObjetos()){
            
            if(pedidoArticuloActual.getPedido().getId() == idPedidorecibido){
                
                listaDevolver.add(pedidoArticuloActual);
                
            }else{
                
                //..se establecio un valor por defecto
                
            }
            
        }
        
        return listaDevolver;
    }
    
    public static Set<PedidoArticulo> getListaPedidoArticuloForIdArticulo(int idArticuloRecibido){
        
        Set<PedidoArticulo> listaDevolver = new HashSet<>();
        
        for(PedidoArticulo pedidoArticuloActual : PedidoArticulo.getListaObjetos()){
            
            if(pedidoArticuloActual.getArticulo().getId() == idArticuloRecibido){
                
                listaDevolver.add(pedidoArticuloActual);
                
            }else{
                
                //..se establecio un valor por defecto
                
            }
            
        }
        
        return listaDevolver;
    }
    
    public static Set<Materia> getListaMateriaForIdCarrera(int idCarreraRecibida){
        
        Set<Materia> listaDevolver = new HashSet<>();
        
        for(Materia materiaActual : Materia.getListaObjetos()){
            
            if(materiaActual.getCarrera().getId() == idCarreraRecibida){
                
                listaDevolver.add(materiaActual);
                
            }else{
                
                //..se establecio un valor por defecto
                
            }
            
        }
        
        return listaDevolver;
    }
    
    //getListaFor
    
    public static Set<PedidoArticulo> getListaPedidoArticuloForPedido(Pedido pedidoRecibido){
        
        Set<PedidoArticulo> listaDevolver = new HashSet<>();
        
        for(PedidoArticulo pedidoArticuloActual : PedidoArticulo.getListaObjetos()){
            
            if(pedidoArticuloActual.getPedido().equals(pedidoRecibido)){
                
                listaDevolver.add(pedidoArticuloActual);
                
            }else{
                
                //..se establecio un valor por defecto
                
            }
        }
        
        return listaDevolver;
    }
    
    public static Set<PedidoArticulo> getListaPedidoArticuloForArticulo(Articulo articuloRecibido){
        
        Set<PedidoArticulo> listaDevolver = new HashSet<>();
        
        for(PedidoArticulo pedidoArticuloActual : PedidoArticulo.getListaObjetos()){
            
            if(pedidoArticuloActual.getArticulo().equals(articuloRecibido)){
                
                listaDevolver.add(pedidoArticuloActual);
                
            }else{
                
                //..se establecio un valor por defecto
                
            }
        }
        
        return listaDevolver;
    }
    
    public static Set<Materia> getListaMateriaForCarrera(Carrera carreraRecibida){
        
        Set<Materia> listaDevolver = new HashSet<>();
        
        for(Materia materiaActual : Materia.getListaObjetos()){
            
            if(materiaActual.getCarrera().equals(carreraRecibida)){
                
                listaDevolver.add(materiaActual);
                
            }else{
                
                //...se establecio un valor por defecto
                
            }
        }
        
        return listaDevolver;
    }
    
    //getListas
    
    public static Set<AlfaNumerico> getListaAlfanumerico(){
        
        Set<AlfaNumerico> listaDevolver = new HashSet<>();
        
        listaDevolver = AlfaNumerico.getListaObjetos();
        
        return listaDevolver;
    }
    
    public static Set<Usuario> getListaUsuarios(){
        
        Set<Usuario> listaDevolver = new HashSet<>();
                
        listaDevolver = Usuario.getListaObjetos();
        
        return listaDevolver;
    }
    
    public static Set<Alumno> getListaAlumnos(){
        
        Set<Alumno> listaDevolver = new HashSet<>();
        
        listaDevolver = Alumno.getListaObjetos();
        
        return listaDevolver;
    }
    
    public static Set<Articulo> getListaArticulos(){
        
        Set<Articulo> listaDevolver = Articulo.getListaObjetos();
        
        return listaDevolver;
    }
    
    public static Set<Pedido> getListaPedidos(){
        
        Set<Pedido> listaDevolver = Pedido.getListaObjetos();
        
        return listaDevolver;
    }
    
    public static Set<PedidoArticulo> getListaPedidoArticulo(){
        
        Set<PedidoArticulo> listadevolver = PedidoArticulo.getListaObjetos();
        
        return listadevolver;
    }
    
    public static Set<Carrera> getListaCarrera(){
        
        Set<Carrera> listaDevolver = Carrera.getListaObjetos();
        
        return listaDevolver;
    }
    
    public static Set<Materia> getListaMateria(){
        
        Set<Materia> listaDevolver = Materia.getListaObjetos();
        
        return listaDevolver;
    }
    
    
    
}
