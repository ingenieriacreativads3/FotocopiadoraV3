/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fotocopiadorav3.Controlador;

import fotocopiadorav3.Modelo.*;
import java.util.*;
import java.sql.*;

/**
 *Clase que se encargara del ABM de Articulos
 * @author David Alonso
 */
public class GestorArticulo {
    
    /**
     * 
     * @param nombreRecibido
     * @param autorRecibido
     * @param precioRecibido
     * @param materia
     * @return
     */
    
    protected static Estado altaArticulo(AlfaNumerico nombreRecibido, AlfaNumerico editorialRecibida, Estado estadoRecibido, AlfaNumerico autorRecibido, AlfaNumerico edicionRecibida, Materia materiaRecibida, double precioRecibido, AlfaNumerico documentorecibido){
        
        Estado ArticuloCreado = Estado.ERROR;
        
        //materi
        //nombre,categoria, materia, editorial, edicion, rutadocumento, autor, precio
        
        java.sql.Date fechaActual = new java.sql.Date(2018, 10, 31);
        
        Articulo articuloNuevo = ModeloInterfaz.getNuevoArticulo(nombreRecibido, autorRecibido, precioRecibido, materiaRecibida, fechaActual, editorialRecibida, edicionRecibida);
        articuloNuevo.guardar();
        
        return Estado.EXITO;
    }
    /**
     * 
     * @param IDArticulo 
     * @return  
     */
    protected static Estado bajaArticulo(int IDArticulo){
        
        
        Estado ArticuloEliminado = Estado.ERROR;
        
        //Verificaciones del nombre, autor, precio, materia.
        
        
        //ArticuloEliminado = ModeloInterfaz.bajaArticulo(IDArticulo);
        
        System.out.println("idArticulo a borrar:" + IDArticulo); 
        Articulo articuloABajar = ModeloInterfaz.getArticuloForId(IDArticulo);
        
        ArticuloEliminado = articuloABajar.borrar();
        
        return Estado.EXITO;
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
    protected static Estado modificacionArticulo(int IDArticulo, AlfaNumerico nombre, AlfaNumerico autor, double precio, Materia materia){
        Estado ArticuloModificadoConExito = Estado.ERROR;
        
        //Verificaciones del nombreRecibido, autor, precio, materia.
        
        if(datosCorrectos(nombre, autor, precio, materia)){
            
            //ArticuloModificadoConExito = ModeloInterfaz.modificarArticulo(IDUusuarioRecibido, nombreRecibido, apellidoRecibido, nombreUsuarioRecibido, passwordRecibida, domicilioRecibido, dniRecibido);
            Articulo articuloAModificar = ModeloInterfaz.getArticuloForId(IDArticulo);
            AlfaNumerico test1 = ModeloInterfaz.getAlfaNumerico("test");
            test1.guardar();
            AlfaNumerico test2 = ModeloInterfaz.getAlfaNumerico("test");
            test2.guardar();
            java.sql.Date fechaActual = new java.sql.Date(2018, 10, 31);
            ArticuloModificadoConExito = articuloAModificar.modificar(precio, fechaActual, nombre, autor, test1, test2, materia);
            
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
    private static boolean datosCorrectos(AlfaNumerico nombre, AlfaNumerico autor, double precio, Materia materia){
        
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
