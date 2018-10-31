/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fotocopiadorav3.Modelo;

import java.sql.*;
import java.util.*;

/**

 @author Tomas
 */
public class Usuario{
    
    //atributos
    
    private static final String NOMBRE_TABLA = "usuario";
    
    private static final String CAMPO_ID = "id";
    private static final String CAMPO_ID_PERSONA = "id_persona";
    private static final String CAMPO_ID_NOMBRE_USUARIO = "id_nombre_usuario";
    private static final String CAMPO_ID_PASS = "id_pass";
    
    private static final int CANTIDAD_DE_CAMPOS = 4;
    private static final int LUGAR_DEL_CAMPO_ID = 1;
    private static final int LUGAR_DEL_CAMPO_ID_PERSONA = 2;
    private static final int LUGAR_DEL_CAMPO_ID_NOMBRE_USUARIO = 3;
    private static final int LUGAR_DEL_CAMPO_ID_PASS = 4;

    private int id;
    private Persona persona;
    private AlfaNumerico nombreUsuario;
    private AlfaNumerico pass;
    private int idPersona;
    private int idNombreUsuario;
    private int idPass;

    protected final static Usuario OBJETO_INVALIDO = new Usuario(Persona.OBJETO_INVALIDO);

    private static Set<Usuario> listaObjetos = new HashSet<>();

    //Rutinas
    
    protected static Usuario getForId(int idRecibido){
        
        Usuario usuarioDevolver = OBJETO_INVALIDO;
        
        Estado seObtuvo = Estado.EXITO;
        //Estado seObtuvo = getInformacion();
        
        if(listaObjetos != null){
            
            if(seObtuvo == Estado.EXITO){

                for(Usuario usuarioActual : listaObjetos){

                    if(usuarioActual.id == idRecibido){

                        usuarioDevolver = usuarioActual;

                    }else{

                        //...se establecion un valor por defecto

                    }
                }

            }else{

                //TODO capturar el error producido por no haber capturado la info de la db
                System.out.println("Se rompio en Direccion.getForId();");

            }
            
        }else{
            
            //...no hacer nada
            
        }
        return usuarioDevolver;
        
    }
    
    public Estado guardar(){
        
        Estado estadoDevolver = Estado.ERROR;
        
        ConexionMySql conn = new ConexionMySql();
        PreparedStatement prepared = conn.getPreparedStatement(CANTIDAD_DE_CAMPOS, NOMBRE_TABLA);
        
        try {
            
            prepared.setInt(LUGAR_DEL_CAMPO_ID, this.id);
            prepared.setInt(LUGAR_DEL_CAMPO_ID_PERSONA, this.idPersona);
            prepared.setInt(LUGAR_DEL_CAMPO_ID_NOMBRE_USUARIO, this.idNombreUsuario);
            prepared.setInt(LUGAR_DEL_CAMPO_ID_PASS, this.idPass);
            
            prepared.executeUpdate();
            
            estadoDevolver = Estado.EXITO;
            prepared.close();
            conn.closeConn(Usuario.class.toString() + "guardar");
            
        } catch (Exception e) {
            
            estadoDevolver = Estado.ERROR_PERSISTENCIA_INCORRECTA;
            
        }
        
        return estadoDevolver;
        
    }
    
    protected static Estado getInformacion(){
        
        Estado estadoDevolver = Estado.ERROR;
        
        System.out.println("pregunta por los usuarios");
        
        ResultSet rs = null;
        
        ConexionMySql conn = new ConexionMySql();
        PreparedStatement prepared = conn.getPreparedStatement(NOMBRE_TABLA);
        
        try {
            
            rs = prepared.executeQuery();
            
            while (rs.next()) {
                
                int id = rs.getInt(CAMPO_ID);
                int idPersona = rs.getInt(CAMPO_ID_PERSONA);
                int idNombreUsuario = rs.getInt(CAMPO_ID_NOMBRE_USUARIO);
                int idPass = rs.getInt(CAMPO_ID_PASS);
                
                Persona personaObjeto = Persona.getForId(idPersona);
                AlfaNumerico nombreUsuarioObjeto = AlfaNumerico.getForId(idNombreUsuario);
                AlfaNumerico passObjeto = AlfaNumerico.getForId(idPass);
                
                Usuario asd = Usuario.nuevo(id, personaObjeto, nombreUsuarioObjeto, passObjeto, personaObjeto.getId(), nombreUsuarioObjeto.getId(), passObjeto.getId());
                
                System.out.println(id);
                
            }
            
            estadoDevolver = Estado.EXITO;
            prepared.close();
            conn.closeConn(Usuario.class.toString() + "getInformacion");
            
        } catch (Exception e) {
            
            estadoDevolver = Estado.ERROR_PERSISTENCIA_INCORRECTA;
            
        }
        
        return estadoDevolver;
        
    }
    
    private static int getLastId(){
        
        int ultimoID = 0;
        
        Estado estadoConsulta = Estado.EXITO;
        //Estado estadoConsulta = getInformacion();

        if(listaObjetos != null){

            if(estadoConsulta == Estado.EXITO){

                for(Usuario usuarioActual : listaObjetos){

                    if(usuarioActual.id > ultimoID){

                        ultimoID = usuarioActual.id;

                    }else{

                        //...no hacer nada

                    }

                }

            }else{

                //...no hacer nada

            }

        }else{

            //...se establecio unvalor por defecto

        }
        
        return ultimoID;
        
    }

    private static int getNewId(){

        //Obtener el ultimo identificador
        int idActual = getLastId();

        //Buscar el siguiente identificador
        int siguienteIdentificador = Valor.SIGUIENTE_IDENTIFICADOR;

        //Combinar ambos valores
        idActual = idActual + siguienteIdentificador;

        //Devolver el nuevo identificador
        return idActual;

    }
    
    protected static Estado verificarUsserPass(String nombreActual, String passActual){
        
        //Establecer un valor por defecto
        Estado loginVerificado = Estado.ERROR;
        
        //Obtener los argumentos
        AlfaNumerico nombreRecibido = AlfaNumerico.nuevo(nombreActual);
        AlfaNumerico passRecibido = AlfaNumerico.nuevo(passActual);
        
        System.out.println("verificar usser pass");
        if(!existeNombreUsuario(nombreRecibido)){
            
            //...establecer valor de usuarioDevolver inexistente
            loginVerificado = Estado.ERROR_NOMBRE_INEXISTENTE;
            System.out.println("no existe nombre");
            
        }else{
            
            if(!existePass(passRecibido)){
                
                //...establecer valor de password inexistente
                loginVerificado = Estado.ERROR_PASS_INCORRECTA;
                System.out.println("no existe pass");
                
            }else{
                
                //...establecer valor de login correcto
                loginVerificado = Estado.USSER_PASS_CORRECTOS;
                System.out.println("pasa");
                
            }
            
        }
        
        return loginVerificado;
        
    }

    protected static boolean existePass(AlfaNumerico passRecibido){

        boolean existe = false;

        //Recorrer el conjunto de usuarios
        for(Usuario usuarioActual : listaObjetos){

            //Obtener el pass del usuarioDevolver actual
            AlfaNumerico passUsuarioActual =
                    usuarioActual.getPass();

            //Si el pass actual es igual al pass recibido
            if(passUsuarioActual.getValor().equals(passRecibido.getValor())){

                //...establecer la expresion correspondiente
                existe = true;
                System.out.println("entra uno");

            }

        }

        return existe;

    }
    
    protected static boolean existeNombreUsuario(AlfaNumerico nombreRecibido){

        boolean existe = false;

        System.out.println("viene a preguntar si existe el usuario");
        //Recorrer el conjunto de usuarios
        for(Usuario usuarioActual : listaObjetos){

            //Obtener el nombre del usuarioDevolver actual
            AlfaNumerico nombreUsuarioActual = usuarioActual.getNombreUsuario();

            //Si el nombre actual es igual al nombre recibido
            if(nombreUsuarioActual.getValor().equals(nombreRecibido.getValor())){

                //...establecer la expresion correspondiente
                existe = true;
                System.out.println("entra uno");

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

            //Obtener el nombre del usuarioDevolver actual
            AlfaNumerico nombreUsuarioActual = usuarioActual.getNombreUsuario();

            //Si el nombre actual es igual al nombre recibido
            if(nombreUsuarioActual.getValor().equals(nombreRecibido.getValor())){

                //...establecer la expresion correspondiente
                existe = true;

            }else{
                
                //...se establecio un valor por defecto
                
            }

        }

        return existe;

    }

    //Constructor
    
    private Usuario(){}
    
    private static Usuario nuevo(int idRecibido, Persona personaRecibida, AlfaNumerico nombreRecibido, AlfaNumerico passRecibida, int idPersonaRecibido, int idNombreRecibido, int idPassRecibida){
        
        Usuario usuarioDevolver = new Usuario();
        
        usuarioDevolver.id = idRecibido;
        usuarioDevolver.persona = personaRecibida;
        usuarioDevolver.nombreUsuario = nombreRecibido;
        usuarioDevolver.pass = passRecibida;
        usuarioDevolver.idPersona = idPersonaRecibido;
        usuarioDevolver.idNombreUsuario = idNombreRecibido;
        
        Estado seAgrego = Usuario.addNewObjeto(usuarioDevolver);
        
        if(!(seAgrego == Estado.EXITO)){
            
            //listaObjetos.remove(usuarioDevolver);
            
        }else{
            
            //...no hacer nada
            
        }
        
        return usuarioDevolver;
    }
    
    private Usuario(int identificador){
        
        this.id = identificador;
        
    }

    private Usuario(Persona personaFinal) {

        //Asignar un identificador
        this.id = getNewId();

        //Asignar una persona
        this.persona = personaFinal;

    }
    
    protected static Usuario nuevo(Persona personaRecibida, AlfaNumerico nombreUsuarioRecibido, AlfaNumerico passRecibida){

        //Crear un objeto a devolver
        Usuario objetoDevolver = Usuario.OBJETO_INVALIDO;

        //Obtener el siguiente identificador
        int identificador = getNewId();
        
        //Crear un nuevo objeto
        Usuario objetoNuevo = new Usuario(identificador);

        //Agregar a la lista de control
        Estado seAgrego = addNewObjeto(objetoNuevo);

        //Si se agrega con exito
        if(seAgrego == Estado.EXITO){
            
            //Asignar el valor recibido por defecto
            Estado seSeteoPersona = objetoNuevo.setPersona(personaRecibida);
            Estado seSeteoNombreUsuario = objetoNuevo.setNombreUsuario(nombreUsuarioRecibido);
            Estado seSeteoPass = objetoNuevo.setPass(passRecibida);
            
            Estado seSeteoIdPersona = objetoNuevo.setIdPersona(personaRecibida.getId());
            Estado seSeteoIdNombreUsuario = objetoNuevo.setIdNombreUsuario(nombreUsuarioRecibido.getId());
            Estado seSeteoIdPass = objetoNuevo.setIdPass(passRecibida.getId());
            
            objetoDevolver = objetoNuevo;
            
            //Estado seGuardo = objetoDevolver.guardar();

        }else{

            //TODO capturar el error generado por un ingreso erroneo a la lista
            listaObjetos.remove(objetoDevolver);
            //...se establecio un valor por defecto

        }

        //Devolver el objeto requerido
        return objetoDevolver;

    }

    private static Usuario nuevo(Persona personaFinal){

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

    private Estado setIdPersona(int idPersona) {
        
        Estado estadoDevolver = Estado.EXITO;
        
        this.idPersona = idPersona;
        
        return estadoDevolver;
    }

    private Estado setIdNombreUsuario(int idNombreUsuario) {
        
        Estado estadoDevolver = Estado.EXITO;
        
        this.idNombreUsuario = idNombreUsuario;
        
        return estadoDevolver;
    }

    private Estado setIdPass(int idPass) {
        
        Estado estadoDevolver = Estado.EXITO;
        
        this.idPass = idPass;
        
        return estadoDevolver;
    }

    private Estado setPersona(Persona personaRecibida) {
        
        Estado estadoDevolver = Estado.EXITO;
        
        this.persona = personaRecibida;
        
        return estadoDevolver;
    }

    private Estado setNombreUsuario(AlfaNumerico nombreUsuario) {
        
        Estado estadoDevolver = Estado.EXITO;
        
        this.nombreUsuario = nombreUsuario;
        
        return estadoDevolver;
    }

    private Estado setPass(AlfaNumerico pass) {
        
        Estado estadoDevolver = Estado.EXITO;
        
        this.pass = pass;
        
        return estadoDevolver;
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
     * Esta funcion devuelve el nombre de usuarioDevolver de un usuarioDevolver en particular
     * 
     * @return AlfaNumerico nombreUsuario
     */
    public AlfaNumerico getNombreUsuario() {
        
        AlfaNumerico nombreDevolver = AlfaNumerico.OBJETO_INVALIDO;
        
        nombreDevolver = this.nombreUsuario;
        
        return nombreDevolver;
        
    }

    /**
     * Esta funcion devuelve la contraseña de este usuarioDevolver
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
