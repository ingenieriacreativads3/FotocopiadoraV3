/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fotocopiadorav3.Controlador;

import fotocopiadorav3.Modelo.AlfaNumerico;
import fotocopiadorav3.Modelo.Alumno;
import fotocopiadorav3.Modelo.Direccion;
import fotocopiadorav3.Modelo.Estado;
import fotocopiadorav3.Modelo.ModeloInterfaz;
import fotocopiadorav3.Modelo.Persona;

/**
 *Clase que se encargara del ABM de Clientes
 * @author David Alonso
 */
public class GestorCliente {
    
    protected static Estado altaCliente(int legajo, AlfaNumerico nombreCliente, AlfaNumerico apellidoCliente, AlfaNumerico direccionClienteRecibido, int numeroCalle, int DNICliente){
        Estado Exito = Estado.ERROR;
        
        System.out.println("entra a hacer un nuevo alumno");
        //if(datosCorrectos(legajo, nombreCliente, apellidoCliente, direccionClienteRecibido, numeroCalle)){
        if(true){
            
            Direccion direccionCliente = ModeloInterfaz.getDireccion(direccionClienteRecibido, numeroCalle);
            direccionCliente.guardar();
            Persona nuevoCliente = ModeloInterfaz.getNuevaPersona(nombreCliente, apellidoCliente, DNICliente, direccionCliente);
            nuevoCliente.guardar();
            Alumno nuevoAlumno = ModeloInterfaz.getNuevoAlumno(legajo, nuevoCliente);
            Exito = nuevoAlumno.guardar();
            System.out.println("guarda un alumno nuevo");
            //Exito = ModeloInterfaz.getNuevoAlumno(legajo, personaRecibida);
            
        } else {
            Exito = Estado.ERROR_DATOS_INVALIDOS;
        }
        
        return Exito;
    }
    
    protected static Estado bajaCliente(int idRecibido){
        
        Estado Exito = Estado.ERROR;
        
        System.out.println("id alumno: " + idRecibido);
        
        //Dar de baja
        Alumno alumnoABajar = ModeloInterfaz.getAlumnoForId(idRecibido);
        
        if(alumnoABajar != Alumno.OBJETO_INVALIDO){
        
            Exito = alumnoABajar.borrar();
            
        }else{
            
            //...se establecio un valor por defecto
            
        }
        
        
        return Exito;
    }
    
    protected static Estado modificacionCliente(int legajoRecibido, AlfaNumerico nombreCliente, AlfaNumerico apellidoCliente, Direccion direccionClienteRecibido, int DNICliente){
        Estado Exito = Estado.ERROR;
        
        //if(datosCorrectos(legajo, nombreCliente, apellidoCliente, direccionClienteRecibido, numeroCalle)){
        if(true){
            //Persona nuevoCliente = ModeloInterfaz.get
            //Exito = ModeloInterfaz.getNuevoAlumno(legajo, personaRecibida);
            Alumno alumnoAModificar = ModeloInterfaz.getAlumnoForLegajo(legajoRecibido);
            
            Persona personaAModificar = alumnoAModificar.getPersona();
            personaAModificar.modificar(nombreCliente, apellidoCliente, DNICliente, direccionClienteRecibido);
            Exito = alumnoAModificar.modificar(legajoRecibido, personaAModificar);
        }
        
        return Exito;
    }
    
    private static boolean datosCorrectos(int legajo, AlfaNumerico nombreCliente, AlfaNumerico apellidoCliente, AlfaNumerico direccionCliente, int numeroCalle){
        
        try{
            boolean exito = false;
            boolean exitoLegajo = false;
            boolean exitoNombreCliente = false;
            boolean exitoApellidoCliente = false;
            boolean exitoDireccionCliente = false;
            boolean exitoNumeroCalleCliente = false;
            if(legajo < 0){
                exitoNumeroCalleCliente=true;
            }
            if(numeroCalle < 0){
                exitoLegajo=true;
            }
            if(nombreCliente != null){
                exitoNombreCliente=true;
            }
            if(apellidoCliente != null){
                exitoApellidoCliente=true;
            }
            if(direccionCliente != null){
                exitoDireccionCliente=true;
            }
            if(exitoLegajo && exitoNombreCliente && exitoNumeroCalleCliente && exitoApellidoCliente &&exitoDireccionCliente){
                exito = true;
            }
        
        return exito;
        }   catch(Exception e){
            return false;
        }     
    }
}
