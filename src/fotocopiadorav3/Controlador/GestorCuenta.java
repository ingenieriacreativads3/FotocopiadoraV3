/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fotocopiadorav3.Controlador;

import fotocopiadorav3.Modelo.Estado;
import fotocopiadorav3.Modelo.ModeloInterfaz;

/**
 * Esta clase maneja aspectos relacionados con el logueo e inicio de secion.
 * 
 * @author Alonso David
 */
public class GestorCuenta {
    
//   protected void iniciarSecion(){
//       /**
//        * El method recibe por parametros un usuario y una contraseña.
//        * En caso de ser datos validos, devuelve true.
//        * En case de ser datos incorrectos, devuelve false.
//        */
//   }
//   
//   protected void cerrarSecion(){
//       
//   }
//   
   protected static Estado VerificarUsuarioYContraseña(String usuario, String contraseña){
       
       Estado exitoAlIniciar = Estado.ERROR;
        //Primero se debe verificar si existe el usuario.
        //Luego se debe verificar si el usuairo y la contraseña son correctas
        
        System.out.println("llega hasta el gestor cuenta");
        try{
            
            if(ModeloInterfaz.existeUsuario(usuario)){
                
                System.out.println("el usuario existe");
                exitoAlIniciar = ModeloInterfaz.verificaUsuarioPassword(usuario, contraseña);
                
            }else{
                
                exitoAlIniciar = Estado.ERROR_NOMBRE_INEXISTENTE;
                
            }
            
        }catch(Exception e){
            
        }
        
        return exitoAlIniciar;
   }
   
}
