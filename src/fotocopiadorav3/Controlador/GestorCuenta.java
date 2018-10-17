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
    
   protected void iniciarSecion(){
       /**
        * El metodo recibe por parametros un usuario y una contraseña.
        * En caso de ser datos validos, devuelve true.
        * En case de ser datos incorrectos, devuelve false.
        */
   }
   
   protected void cerrarSecion(){
       
   }
   
   protected Estado VerificarUsuarioYContraseña(String usuario, String contraseña){
       Estado exitoAlIniciar = Estado.ERROR;
        //Primero se debe verificar si existe el usuario.
        //Luego se debe verificar si el usuairo y la contraseña son correctas
        try{
            if(ModeloInterfaz.existeUsuario(usuario)){
                exitoAlIniciar = ModeloInterfaz.verificaUsuarioPassword(usuario, contraseña);
            }
            else{
                exitoAlIniciar = Estado.ERROR_NOMBRE_INEXISTENTE;
            }
            return exitoAlIniciar;
        }catch(Exception e){
            return exitoAlIniciar;
        }
   }
   
}
