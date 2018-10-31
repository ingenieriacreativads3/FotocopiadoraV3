/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fotocopiadorav3.Controlador;

import fotocopiadorav3.Modelo.AlfaNumerico;
import fotocopiadorav3.Modelo.Estado;

/**
 *Clase que se encargara del ABM de Clientes
 * @author David Alonso
 */
public class GestorCliente {
    
    protected Estado altaCliente(int legajo, AlfaNumerico nombreCliente){
        Estado Exito = Estado.ERROR;
        if(datosCorrectos(legajo, nombreCliente)){
            //Persona nuevoCliente = ModeloInterfaz.get
            //Exito = ModeloInterfaz.getNuevoAlumno(legajo, personaRecibida);
        }
        
        return Exito;
    }
    
    protected Estado bajaCliente(int legajo){
        Estado Exito = Estado.ERROR;
        
        //Dar de baja
        
        return Exito;
    }
    
    protected Estado modificacionCliente(int legajo, AlfaNumerico nombreCliente){
        Estado Exito = Estado.ERROR;
        
        if(datosCorrectos(legajo, nombreCliente)){
            //Persona nuevoCliente = ModeloInterfaz.get
            //Exito = ModeloInterfaz.getNuevoAlumno(legajo, personaRecibida);
        }
        
        return Exito;
    }
    
    private boolean datosCorrectos(int legajo, AlfaNumerico nombreCliente){
        
        try{
            boolean exito = false;
            boolean exitoLegajo = false;
            boolean exitoNombreCliente = false;
            if(legajo < 0){
                exitoLegajo=true;
            }
            if(nombreCliente != null){
                exitoNombreCliente=true;
            }
            if(exitoLegajo && exitoNombreCliente){
                exito = true;
            }
        
        return exito;
        }   catch(Exception e){
            return false;
        }     
    }
}
