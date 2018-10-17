/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fotocopiadorav3.Controlador;

import fotocopiadorav3.Modelo.AlfaNumerico;
import fotocopiadorav3.Modelo.Estado;
import fotocopiadorav3.Modelo.ModeloInterfaz;
import fotocopiadorav3.Modelo.Usuario;

/**
 *Clase que se encargara del ABM de usuario.
 * @author David Alonso
 */
public class GestorUsuario {
    
    protected Estado altaUsuario(AlfaNumerico nombre, AlfaNumerico apellido, AlfaNumerico nombreUsuario, AlfaNumerico contrasenia, AlfaNumerico Domicilio, AlfaNumerico DNI){
        Estado usuarioCreado = Estado.ERROR;
        
        //Verificaciones del nombre, autor, precio, materia.
        
        if(datosCorrectos(nombre, apellido, nombreUsuario, contrasenia, Domicilio, DNI)){
            
            //Usuario usuarioCreado = ModeloInterfaz.getNuevoUsuario();
            
            //usuarioCreado.getPersona().setNombre();
            //usuarioCreado.getPersona().setApellido();
            //usuarioCreado.setNombreUsuario();
            //usuarioCreado.setPassword();
            //usuarioCreado.getPersona().setDomicilio();
            //usuarioCreado.getPersona().setDNI();
            
            //usuarioCreado = ModeloInterfaz.adicionarUsuario(nombre, apellido, nombreUsuario, contrasenia, Domicilio, DNI);
        }
        
        return usuarioCreado;
    }
    
    protected void bajaUsuario(){
        
    }
    
    protected void modificacionUsuario(){
        
    }
    
    private boolean datosCorrectos(AlfaNumerico nombre, AlfaNumerico apellido, AlfaNumerico nombreUsuario, AlfaNumerico contrasenia, AlfaNumerico Domicilio, AlfaNumerico DNI){
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
        if(DNI != null){
            exitoDomicilio = true;
        }
        if(exitoNombre && exitoApellido && exitoNombreUsuario && exitoContrasenia && exitoDomicilio){
            exito = true;
        }
        
        return exito;
    }
}
