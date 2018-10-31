/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fotocopiadorav3.Controlador;

import fotocopiadorav3.Modelo.*;

/**
 *Clase que se encargara del ABM de usuario.
 * @author David Alonso
 */
public class GestorUsuario {
    
    protected Estado altaUsuario(AlfaNumerico nombreRecibido, AlfaNumerico apellidoRecibido, AlfaNumerico nombreUsuarioRecibido, AlfaNumerico passwordRecibida, Direccion domicilioRecibido, int dniRecibido){
        Estado usuarioCreadoConExito = Estado.ERROR;
        
        //Verificaciones del nombreRecibido, autor, precio, materia.
        
        if(datosCorrectos(nombreRecibido, apellidoRecibido, nombreUsuarioRecibido, passwordRecibida, domicilioRecibido, dniRecibido)){
            
            Usuario usuarioCreado = ModeloInterfaz.getNuevoUsuario(nombreRecibido, apellidoRecibido, dniRecibido, domicilioRecibido, nombreUsuarioRecibido, passwordRecibida);
            
            usuarioCreadoConExito = usuarioCreado.guardar();
            //usuarioCreadoConExito = ModeloInterfaz.adicionarUsuario(nombreRecibido, apellidoRecibido, nombreUsuarioRecibido, passwordRecibida, domicilioRecibido, dniRecibido);
        }
        else{
            usuarioCreadoConExito = Estado.ERROR_DATOS_INVALIDOS;
        }
        
        return usuarioCreadoConExito;
    }
    
    protected Estado bajaUsuario(int IDusuario){
        Estado exitoBaja = Estado.ERROR;
        //Usuario userABorrar = ModeloInterfaz.getUsuarioForID(IDusuario);
        Usuario userABorrar = ModeloInterfaz.getUsuarioForId(IDusuario);
        //ModeloInterfaz.borrarUsuario(userABorrar);
        //userABorrar.borrar();
        
        return exitoBaja;
    }
    
    protected Estado modificacionUsuario(AlfaNumerico IDUusuarioRecibido, AlfaNumerico nombreRecibido, AlfaNumerico apellidoRecibido, AlfaNumerico nombreUsuarioRecibido, AlfaNumerico passwordRecibida, Direccion domicilioRecibido, int dniRecibido){
        Estado usuarioCreadoConExito = Estado.ERROR;
        
        //Verificaciones del nombreRecibido, autor, precio, materia.
        
        if(datosCorrectos(nombreRecibido, apellidoRecibido, nombreUsuarioRecibido, passwordRecibida, domicilioRecibido, dniRecibido)){
            
            //usuarioCreadoConExito = ModeloInterfaz.modificarUsuario(IDUusuarioRecibido, nombreRecibido, apellidoRecibido, nombreUsuarioRecibido, passwordRecibida, domicilioRecibido, dniRecibido);
        }
        else{
            usuarioCreadoConExito = Estado.ERROR_DATOS_INVALIDOS;
        }
        
        return usuarioCreadoConExito;
    }
    
    private boolean datosCorrectos(AlfaNumerico nombre, AlfaNumerico apellido, AlfaNumerico nombreUsuario, AlfaNumerico contrasenia, Direccion Domicilio, int DNI){
        boolean exito = false;
        boolean exitoNombre = false;
        boolean exitoApellido = false;
        boolean exitoNombreUsuario = false;
        boolean exitoContrasenia = false;
        boolean exitoDomicilio = false;
        
        if(nombre != null){
            exitoNombre = true;
        }
        if(apellido != null){
            exitoApellido = true;
        }
        if(nombreUsuario != null){
            exitoNombreUsuario = true;
        }
        if(contrasenia != null){
            exitoContrasenia = true;
        }
        if(Domicilio != null){
            exitoDomicilio = true;
        }
        if(DNI != Valor.DNI_INVALIDO){
            exitoDomicilio = true;
        }
        if(exitoNombre && exitoApellido && exitoNombreUsuario && exitoContrasenia && exitoDomicilio){
            exito = true;
        }
        
        return exito;
    }
}
