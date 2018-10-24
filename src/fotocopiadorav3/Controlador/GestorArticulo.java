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
     * @param materiaz
     * @return
     */
    
    protected Estado altaArticulo(String nombre, String autor, float precio, String materia){
        Estado ArticuloCreado = Estado.ERROR;
        
        //Verificaciones del nombre, autor, precio, materia.
        
        if(datosCorrectos(nombre, autor, precio, materia)){
            ArticuloCreado = ModeloInterfaz.adicionarArticulo(nombre, autor, precio, materia);
        }
        
        return ArticuloCreado;
    }
    
    /**
     * 
     * @param IDArticulo 
     */
    protected void bajaArticulo(AlfaNumerico IDArticulo){
        
    }
    
    /**
     *
     * @param IDArticulo
     */
    protected void modificacionArticulo(AlfaNumerico IDArticulo){
        
    }
    
    
    /**
     * 
     * @param nombre
     * @param autor
     * @param precio
     * @param materia
     * @return 
     */
    private boolean datosCorrectos(String nombre, String autor, float precio, String materia){
        
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
