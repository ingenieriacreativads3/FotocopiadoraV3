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
    
    protected Estado altaCliente(int legajo, AlfaNumerico nombreCliente, AlfaNumerico apellidoCliente, AlfaNumerico direccionClienteRecibido, int numeroCalle, int DNICliente){
        Estado Exito = Estado.ERROR;
        if(datosCorrectos(legajo, nombreCliente, apellidoCliente, direccionClienteRecibido, numeroCalle)){
            
            Direccion direccionCliente = ModeloInterfaz.getDireccion(direccionClienteRecibido, numeroCalle);
            Persona nuevoCliente = ModeloInterfaz.getNuevaPersona(nombreCliente, apellidoCliente, DNICliente, direccionCliente);
            Alumno nuevoAlumno = ModeloInterfaz.getNuevoAlumno(legajo, nuevoCliente);
            nuevoAlumno.guardar();
            //Exito = ModeloInterfaz.getNuevoAlumno(legajo, personaRecibida);
            
        }
        
        return Exito;
    }
    
    protected Estado bajaCliente(int legajo){
        Estado Exito = Estado.ERROR;
        
        //Dar de baja
        //Alumno alumnoABajar = ModeloInterfaz.getAlumnoForID();
        //alumnoABajar.borrar();
        
        return Exito;
    }
    
    protected Estado modificacionCliente(int legajo, AlfaNumerico nombreCliente, AlfaNumerico apellidoCliente, AlfaNumerico direccionClienteRecibido, int numeroCalle, int DNICliente){
        Estado Exito = Estado.ERROR;
        
        if(datosCorrectos(legajo, nombreCliente, apellidoCliente, direccionClienteRecibido, numeroCalle)){
            //Persona nuevoCliente = ModeloInterfaz.get
            //Exito = ModeloInterfaz.getNuevoAlumno(legajo, personaRecibida);
        }
        
        return Exito;
    }
    
    private boolean datosCorrectos(int legajo, AlfaNumerico nombreCliente, AlfaNumerico apellidoCliente, AlfaNumerico direccionCliente, int numeroCalle){
        
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
