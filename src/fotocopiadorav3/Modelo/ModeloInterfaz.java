/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fotocopiadorav3.Modelo;

import com.sun.javafx.geom.transform.BaseTransform;

/**

 @author Tomas
 */
public class ModeloInterfaz{
    
    public static Alumno getNuevo(){
        
        Alumno alumnoDevolver = Alumno.nuevo();
        
        
        
        return alumnoDevolver;
        
    }
    
    public static Nombre getNombreAlumnoByAlumno(Alumno alumnorecibido){
        
        Nombre nombreDevolver = Nombre.objetoInvalido;
        
        
        
        return nombreDevolver;
        
    }
    
}
