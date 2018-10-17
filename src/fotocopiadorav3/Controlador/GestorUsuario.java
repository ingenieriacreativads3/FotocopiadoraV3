/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fotocopiadorav3.Controlador;

import fotocopiadorav3.Modelo.Estado;
import fotocopiadorav3.Modelo.ModeloInterfaz;

/**
 *Clase que se encargara del ABM de usuario.
 * @author David Alonso
 */
public class GestorUsuario {
    
    protected Estado altaUsuario(String nombre, String permisos){
        Estado usuarioCreado = Estado.ERROR;
        
        //Verificaciones del nombre, autor, precio, materia.
        
        if(datosCorrectos(nombre, permisos)){
            usuarioCreado = ModeloInterfaz.adicionarUsuario(nombre, permisos);
        }
        
        return usuarioCreado;
    }
    
    protected void bajaUsuario(){
        
    }
    
    protected void modificacionUsuario(){
        
    }
    
    private boolean datosCorrectos(String nombre, String permisos){
        boolean exito = false;
        boolean exitoNombre = false;
        boolean exitoPermisos = false;
        
        if(nombre != null){
            exitoNombre = true;
        }
        if(permisos != null){
            exitoPermisos = true;
        }
        if(exitoNombre && exitoPermisos){
            exito = true;
        }
        
        return exito;
    }
}
