/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fotocopiadorav3.Modelo;
import java.util.*;

/**

 @author Tomas
 */
public class Usuario{
    
    //atributos

    private final int id;
    private final Persona persona;
    private AlfaNumerico nombreUsuario;
    private AlfaNumerico pass;

    protected final static Usuario OBJETO_INVALIDO = new Usuario(Persona.OBJETO_INVALIDO);

    private static Set<Usuario> listaObjetos = new HashSet<>();

    //funciones
    
    protected static Estado verificarUsserPass(String nombreActual, String passActual){
        
        //Establecer un valor por defecto
        Estado loginVerificado = Estado.ERROR;
        
        //Obtener los argumentos
        AlfaNumerico nombreRecibido = AlfaNumerico.nuevo(nombreActual);
        AlfaNumerico passRecibido = AlfaNumerico.nuevo(passActual);
        
        if(!existeNombreUsuario(nombreRecibido)){
            
            //...establecer valor de usuario inexistente
            loginVerificado = Estado.ERROR_NOMBRE_INEXISTENTE;
            
        }else{
            
            if(!existePass(passRecibido)){
                
                //...establecer valor de password inexistente
                loginVerificado = Estado.ERROR_PASS_INCORRECTA;
                
            }else{
                
                //...establecer valor de login correcto
                loginVerificado = Estado.USSER_PASS_CORRECTOS;
                
            }
            
        }
        
        return loginVerificado;
        
    }

    protected static boolean existePass(AlfaNumerico passRecibido){

        boolean existe = false;

        //Recorrer el conjunto de usuarios
        for(Usuario usuarioActual : listaObjetos){

            //Obtener el pass del usuario actual
            AlfaNumerico passUsuarioActual =
                    usuarioActual.getPass();

            //Si el pass actual es igual al pass recibido
            if(passUsuarioActual.equals(passRecibido)){

                //...establecer la expresion correspondiente
                existe = true;

            }

        }

        return existe;

    }
    
    protected static boolean existeNombreUsuario(AlfaNumerico nombreRecibido){

        boolean existe = false;

        //Recorrer el conjunto de usuarios
        for(Usuario usuarioActual : listaObjetos){

            //Obtener el nombre del usuario actual
            AlfaNumerico nombreUsuarioActual = usuarioActual.getNombreUsuario();

            //Si el nombre actual es igual al nombre recibido
            if(nombreUsuarioActual.equals(nombreRecibido)){

                //...establecer la expresion correspondiente
                existe = true;

            }

        }

        return existe;

    }

    protected static boolean existeNombreUsuario(String nombreActual){

        boolean existe = false;
        
        //Obtener el argumento recibido
        AlfaNumerico nombreRecibido = AlfaNumerico.nuevo(nombreActual);

        //Recorrer el conjunto de usuarios
        for(Usuario usuarioActual : listaObjetos){

            //Obtener el nombre del usuario actual
            AlfaNumerico nombreUsuarioActual = usuarioActual.getNombreUsuario();

            //Si el nombre actual es igual al nombre recibido
            if(nombreUsuarioActual.equals(nombreRecibido)){

                //...establecer la expresion correspondiente
                existe = true;

            }

        }

        return existe;

    }

    private static int getNewId(){

        //Crear un nuevo identificador
        int idActual = 0;

        //Obtener la cantidad de elementos no nulos del conjunto
        if(listaObjetos != null){

            if(listaObjetos.size() != 0){

                idActual = listaObjetos.size();

            }else{

                //...se establecio un valor por defecto

            }

        }else{

            //...se establecio unvalor por defecto

        }

        //Buscar el siguiente identificador
        int siguienteIdentificador = Valor.SIGUIENTE_IDENTIFICADOR;

        //Combinar ambos valores
        idActual = idActual + siguienteIdentificador;

        //Devolver el nuevo identificador
        return idActual;

    }

    //Constructor

    private Usuario(Persona personaFinal) {

        //Asignar un identificador
        this.id = getNewId();

        //Asignar una persona
        this.persona = personaFinal;

    }

    protected static Usuario nuevo(Persona personaFinal){

        //Crear un objeto a devolver
        Usuario objetoDevolver = Usuario.OBJETO_INVALIDO;

        //Crear un nuevo objeto
        Usuario objetoNuevo = new Usuario(personaFinal);

        //Agregar a la lista de control
        Estado seAgrego = addNewObjeto(objetoNuevo);

        //Si se agrega con exito
        if(seAgrego == Estado.EXITO){

            //Establecer el objeto a devolver
            objetoDevolver = objetoNuevo;

        }else{

            //...se establecio un valor por defecto

        }

        //Devolver el objeto requerido
        return objetoDevolver;

    }

    //Manejo de lista

    private static Estado addNewObjeto(Object objetoActual){

        //Establecer un valor por defecto
        Estado estadoDevolver= Estado.ERROR;

        //Si el objeto recibido es del tipo correcto
        if(objetoActual.getClass() == Usuario.class){

            //Obtener el objeto requerido
            Usuario objetoAgregar = (Usuario)objetoActual;

            //Agregar el nuevo elemento a la lista
            boolean seAgrego;
            seAgrego = listaObjetos.add(objetoAgregar);

            if(seAgrego){

                //...asignar el estado correspondiente
                estadoDevolver = Estado.EXITO;

            }else{

                //...se establecio un valor por defecto

            }//...fin if


        }else{

            //...se establecio un valor por defecto

        }//...fin if

        //Devolver el estado correspondiente
        return estadoDevolver;

    }//...fin funcion

    //Setter

    public void setNombreUsuario(AlfaNumerico nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public void setPass(AlfaNumerico pass) {
        this.pass = pass;
    }

    private static void setListaObjetos(Set<Usuario> listaObjetos) {
        Usuario.listaObjetos = listaObjetos;
    }

    //Getter

    private int getId() {
        return id;
    }

    public Persona getPersona() {
        
        Persona personaDevolver = null;
        
        personaDevolver = persona;
        
        return personaDevolver;
        
    }

    /**
     * Esta funcion devuelve el nombre de usuario de un usuario en particular
     * 
     * @return AlfaNumerico nombreUsuario
     */
    public AlfaNumerico getNombreUsuario() {
        
        AlfaNumerico nombreDevolver = AlfaNumerico.OBJETO_INVALIDO;
        
        nombreDevolver = this.nombreUsuario;
        
        return nombreDevolver;
        
    }

    /**
     * Esta funcion devuelve la contraseña de este usuario
     * @return AlfaNumerico password
     */
    private AlfaNumerico getPass() {
        
        AlfaNumerico passDevolver = AlfaNumerico.OBJETO_INVALIDO;
        
        passDevolver = this.pass;
        
        return passDevolver;
    }

    private static Usuario getObjetoInvalido() {
        return OBJETO_INVALIDO;
    }

    private static Set<Usuario> getListaObjetos() {
        return listaObjetos;
    }

    @Override
    public int hashCode() {

        return this.id;

    }

    @Override
    public boolean equals(Object objetoActual) {

        if(objetoActual == null){return false;}
        if(this.getClass() != objetoActual.getClass()){return false;}

        final Usuario usuarioAuxiliar = (Usuario) objetoActual;

        if(this.hashCode() != usuarioAuxiliar.hashCode()){return false;}

        return true;

    }

    @Override
    public String toString() {

        return this.nombreUsuario.getValor();

    }
    
    
}
