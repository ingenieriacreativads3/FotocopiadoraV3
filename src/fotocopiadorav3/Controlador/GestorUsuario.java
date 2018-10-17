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
    
    protected Estado altaUsuario(AlfaNumerico nombre, AlfaNumerico apellido, AlfaNumerico nombreUsuario, AlfaNumerico contrasenia, Direccion domicilio, int DNI){
        Estado usuarioCreadoConExito = Estado.ERROR;
        
        //Verificaciones del nombre, autor, precio, materia.
        
        if(datosCorrectos(nombre, apellido, nombreUsuario, contrasenia, domicilio, DNI)){
            
            Usuario usuarioCreado = ModeloInterfaz.getNuevoUsuario();
            
            usuarioCreado.getPersona().setNombre(nombre);
            usuarioCreado.getPersona().setApellido(apellido);
            usuarioCreado.setNombreUsuario(nombreUsuario);
            usuarioCreado.setPass(contrasenia);
            usuarioCreado.getPersona().setDireccion(domicilio);
            usuarioCreado.getPersona().setDni(DNI);
            
            //usuarioCreadoConExito = ModeloInterfaz.adicionarUsuario(nombre, apellido, nombreUsuario, contrasenia, domicilio, DNI);
        }
        
        return usuarioCreadoConExito;
    }
    
    protected void bajaUsuario(){
        
    }
    
    protected void modificacionUsuario(){
        
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
