/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fotocopiadorav3.Controlador;

import fotocopiadorav3.Modelo.*;

/**
 *Clase que se encargara del ABM de Articulos
 * @author David Alonso
 */
public class GestorArticulo {
    
    /**
     * 
     * @param nombre
     * @param autor
     * @param precio
     * @param materia
     * @return
     */
    
    protected Estado altaArticulo(AlfaNumerico nombre, AlfaNumerico autor, float precio, AlfaNumerico materia){
        Estado ArticuloCreado = Estado.ERROR;
        
        //Verificaciones del nombre, autor, precio, materia.
        
        if(datosCorrectos(nombre, autor, precio, materia)){
            //ArticuloCreado = ModeloInterfaz.adicionarArticulo(nombre, autor, precio, materia);
            //Documento nuevoArticulo = ModeloInterfaz.get
        }
        
        return ArticuloCreado;
    }
    
    /**
     * 
     * @param IDArticulo 
     * @return  
     */
    protected Estado bajaArticulo(AlfaNumerico IDArticulo){
        Estado ArticuloEliminado = Estado.ERROR;
        
        //Verificaciones del nombre, autor, precio, materia.
        
        
        //ArticuloEliminado = ModeloInterfaz.bajaArticulo(IDArticulo);
        
        
        return ArticuloEliminado;
    }
    
    /**
     *
     * @param IDArticulo
     * @param nombre
     * @param autor
     * @param precio
     * @param materia
     * @return 
     */
    protected Estado modificacionArticulo(AlfaNumerico IDArticulo, AlfaNumerico nombre, AlfaNumerico autor, float precio, AlfaNumerico materia){
        Estado ArticuloModificadoConExito = Estado.ERROR;
        
        //Verificaciones del nombreRecibido, autor, precio, materia.
        
        if(datosCorrectos(nombre, autor, precio, materia)){
            
            //ArticuloModificadoConExito = ModeloInterfaz.modificarArticulo(IDUusuarioRecibido, nombreRecibido, apellidoRecibido, nombreUsuarioRecibido, passwordRecibida, domicilioRecibido, dniRecibido);
        }
        else{
            ArticuloModificadoConExito = Estado.ERROR_DATOS_INVALIDOS;
        }
        
        return ArticuloModificadoConExito;
    }
    
    
    /**
     * 
     * @param nombre
     * @param autor
     * @param precio
     * @param materia
     * @return 
     */
    private boolean datosCorrectos(AlfaNumerico nombre, AlfaNumerico autor, float precio, AlfaNumerico materia){
        
        try{
            boolean exito = false;
            boolean exitoNombre = false;
            boolean exitoAutor = false;
            boolean exitoPrecio = false;
            boolean exitoMateria = false;
            if(nombre != null){
                exitoNombre=true;
            }
            if(autor != null){
                exitoAutor=true;
            }
            if(precio < 0){
                exitoPrecio=true;
            }
            if(materia != null){
                exitoMateria=true;
            }
            if(exitoNombre && exitoAutor && exitoPrecio && exitoMateria){
                exito = true;
            }
        
        return exito;
        }   catch(Exception e){
            return false;
        }     
    }
    
}
