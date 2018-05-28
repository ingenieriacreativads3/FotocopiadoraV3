/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fotocopiadorav3.Controlador;

/**

 @author Alonso David
 */
public class ControladorInterfaz{
    
    protected GestorPedido GestorPedidos = new GestorPedido();
    protected GestorCuenta GestorCuenta = new GestorCuenta();
    
    
    /**
     * Clase que se encarga de la creacion del pedido
     * @param nombreYApellidoPersona
     * @param identificadorDocumento
     * @param seña
     * Se calcula fecha actual?
     * @return: true si se creo el pedido, false en caso contrario
     */
    public String crearPedido(String nombreYApellidoPersona, String identificadorDocumento, double seña){
        
        String identificadorPedido;
        
        try {
            identificadorPedido = GestorPedidos.crearPedido (nombreYApellidoPersona, identificadorDocumento, seña);
            return identificadorPedido;
        }catch (Exception e) {
            return null;
        }
    }
    
    /**
     * Metodo para comprobar que 
     * 
     * @param usuario
     * @param contraseña
     */
    public boolean iniciarSecion(String usuario, String contraseña){
        
        boolean exitoAlIniciar=false;
        
        try{
            
            if(existeUsuario(usuario)){
                if(esValidoUsuarioYContraseña(usuario, contraseña)){
                    exitoAlIniciar=true;
                }
                else{
                    exitoAlIniciar=false;
                }
            }
            else{
                exitoAlIniciar=false;
            }
            return exitoAlIniciar;
        }catch(Exception e){
            return exitoAlIniciar;
        }
    }
    
    private boolean existeUsuario(String usuario){
        boolean existe=false;
        //existe=ModeloInterfaz.existeUsuario(usuario);
        return existe;
    }
    
    private boolean esValidoUsuarioYContraseña(String usuario, String contraseña){
        boolean esValido=false;
        //esValido = ModeloInterfaz.esValidoUsuarioYContraseña(usuario, contraseña);
        return esValido;
    }
    
}
