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
    private Nombre nombreUsuario;
    private Nombre pass;

    protected static Usuario objetoInvalido = new Usuario(Persona.objetoInvalido);

    private static Set<Usuario> listaObjetos = new HashSet<>();

    //funciones

    protected static Persona getPersonaForID(int id){

        Persona personaDevolver = Persona.objetoInvalido;
        int idPersonaBuscada = id;
        int idPersonaDevolver = Persona.objetoInvalido.getId();
        
        for(Usuario objetoActual : listaObjetos){
            
            
            
        }

        return personaDevolver;

    }

    public static boolean existePass(Nombre passRecibido){

        boolean existe = false;

        //Recorrer el conjunto de usuarios
        for(Usuario usuarioActual : listaObjetos){

            //Obtener el pass del usuario actual
            Nombre passUsuarioActual =
                    usuarioActual.getPass();

            //Si el pass actual es igual al pass recibido
            if(passUsuarioActual.equals(passRecibido)){

                //...establecer la expresion correspondiente
                existe = true;

            }

        }

        return existe;

    }

    public static boolean existeNombreUsuario(Nombre nombreRecibido){

        boolean existe = false;

        //Recorrer el conjunto de usuarios
        for(Usuario usuarioActual : listaObjetos){

            //Obtener el nombre del usuario actual
            Nombre nombreUsuarioActual = usuarioActual.getNombreUsuario();

            //Si el nombre actual es igual al nombre recibido
            if(nombreUsuarioActual.equals(nombreRecibido)){

                //...establecer la expresion correspondiente
                existe = true;

            }

        }

        return existe;

    }

    private int getNewId(){

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
        Usuario objetoDevolver = Usuario.objetoInvalido;

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
        Estado estadoDevolver= Estado.FRACASO;

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

    protected void setNombreUsuario(Nombre nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    protected void setPass(Nombre pass) {
        this.pass = pass;
    }

    private static void setObjetoInvalido(Usuario objetoInvalido) {
        Usuario.objetoInvalido = objetoInvalido;
    }

    private static void setListaObjetos(Set<Usuario> listaObjetos) {
        Usuario.listaObjetos = listaObjetos;
    }

    //Getter

    private int getId() {
        return id;
    }

    private Persona getPersona() {
        return persona;
    }

    private Nombre getNombreUsuario() {
        return nombreUsuario;
    }

    private Nombre getPass() {
        return pass;
    }

    private static Usuario getObjetoInvalido() {
        return objetoInvalido;
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
