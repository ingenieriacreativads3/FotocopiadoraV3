/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fotocopiadorav3.Modelo;
import java.util.*;
import fotocopiadorav3.*;
import java.sql.*;


/**

 @author Tomas
 */
public class Direccion{
    
    private final int id;
    private AlfaNumerico calle;
    private int numero;
            
    public final static Direccion OBJETO_INVALIDO = new Direccion();

    protected static Set<Direccion> listaObjetos = new HashSet<>();

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
    
    //Base de datos
    
    public static Estado guardar(int i){
        
        Estado estadoDevolver = Estado.ERROR;
        
        String valorAgregar = "sdf";
        int idAgregar = 2;
        String idAgregarString = String.valueOf(idAgregar);
        
        Connection conn = null;
        PreparedStatement prepStmt = null;
        ResultSet rs = null;
        
        System.out.println(2.1);
        try {
            System.out.println(2.2);
            Class.forName(Environment.DRIVER).newInstance();
            String connectionUrl = Environment.URL;
            String connectionUser = Environment.USERNAME;
            String connectionPassword = Environment.PASSWORD;
            conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
            System.out.println(2.3);
//            String sqlStmt = "SELECT * FROM " + AlfaNumerico.NOMBRE_TABLA;
            String sqlStmt = "INSERT INTO alfanumerico VALUES (?,?)";
            System.out.println("SQL Statement:\n\t" + sqlStmt);
            prepStmt = conn.prepareStatement(sqlStmt);
            
            prepStmt.setInt(1, idAgregar);
            prepStmt.setString(2, valorAgregar);
            
            
            System.out.println(prepStmt.toString());
            
            rs = prepStmt.executeQuery();
            
            System.out.println("Query ejecutada");
            System.out.println(2.4);
//            while (rs.next()) {
//                
//                String id = rs.getString("id");
//                String valor = rs.getString("valor");
//                
//                System.out.println("ID: " + id + ", Valor: " + valor);
//                
//            }
            System.out.println(2.5);
            
        } catch (Exception e) {
            
            System.out.println(2.6);
            
        }finally {
            System.out.println(2.7);
            try {
                System.out.println(2.8);
                
                if (rs != null) rs.close();
                    
            } catch (SQLException e) {
                
                e.printStackTrace();
                    
            }
            try { 
                System.out.println(2.9);
                    
                if (prepStmt != null) prepStmt.close();
                
            } catch (SQLException e) {
                    
                e.printStackTrace();
                
            }
            try {
                System.out.println(2.1234);
                    
                if (conn != null) conn.close();
                
            } catch (SQLException e) {
                
                e.printStackTrace();
                
            }
        }
        System.out.println(2.11);
        
        //INSERT INTO Store_Information (Store_Name, Sales, Txn_Date) VALUES ('Los Angeles', 900, '10-Jan-1999');
        //INSERT INTO alfanumerico (valor, id) VALUES ('sdf', '2');
        return estadoDevolver;
        
    }
    
    public static Estado guardar(){
        
        Estado estadoDevolver = Estado.ERROR;
        
        System.out.println(1.1);
        // Instancias la clase que hemos creado anteriormente
        ConexionMySql conexionLocalSQL = ConexionMySql.nuevo();
        
        System.out.println(1.2);
        // Llamas al método que tiene la clase y te devuelve una conexión
        Connection conector = conexionLocalSQL.conectarMySQL();
        
        System.out.println(1.3);
        // Query que usarás para hacer lo que necesites
        String sentenciaSQL = "";

        // Query
        sentenciaSQL =  "INSERT INTO alfanumerico (valor) VALUES (\"fghj\")";
        try{
            
            // PreparedStatement
            System.out.println(1.4);
            PreparedStatement pstm = conector.prepareStatement(sentenciaSQL);
            System.out.println(1.5);
            System.out.println(pstm);
            ResultSet asd = pstm.executeQuery();
            System.out.println(1.6);
            System.out.println("Funciona la conexion");
            
        }catch(Exception e){
            
            System.out.println("Fallo la consulta en modelo/direccion.guardar");
            
        }
        
        return estadoDevolver;
        
    }

    //Constructor

    private Direccion() {

        //Asignar un identificador
        this.id = getNewId();


    }

    protected static Direccion nuevo(){

        //Crear un objeto a devolver
        Direccion objetoDevolver = Direccion.OBJETO_INVALIDO;

        //Crear un nuevo objeto
        Direccion objetoNuevo = new Direccion();

        //Agregar a la lista de control
        Estado seAgrego = addNewObjeto(objetoNuevo);

        //Si se agrega con exito
        if(seAgrego == Estado.EXITO){

            //Establecer el objeto a devolver
            objetoDevolver = objetoNuevo;

        }else{

            //TODO capturar el error generado por un ingreso erroneo a la lista
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
        if(objetoActual.getClass() == Direccion.class){

            //Obtener el objeto requerido
            Direccion objetoAgregar = (Direccion)objetoActual;

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
    
    //Getter

    /**
     *Devuelve la calle de una direccion.
     * 
     * @return AlfaNUmerico calle
     * 
     */

    public AlfaNumerico getCalle() {
        
        AlfaNumerico calleDevolver = AlfaNumerico.OBJETO_INVALIDO;
        
        calleDevolver = this.calle;
        
        return calleDevolver;
    }

    /**
     * Esta funcion devuelve el numero de calle de una direccion.
     * Se debe establecer su validez a traves de una
     * funcion de la interfaz del paquete contenedor.
     * 
     * @return int numero
     */
    public int getNumero() {
        
        int numeroDevolver = Valor.numeroDeCalleInvalido;
        
        numeroDevolver = numero;
        
        return numeroDevolver;
    }
    
    //Others
    
    @Override
    public boolean equals(Object objetoActual) {

        if(objetoActual == null){return false;}
        if(this.getClass() != objetoActual.getClass()){return false;}

        final Direccion objetoRecibido = (Direccion) objetoActual;

        if(this.hashCode() != objetoRecibido.hashCode()){return false;}

        return true;

    }

    @Override
    public int hashCode() {

        return this.id;

    }
    
    @Override
    public String toString() {
        
        return this.calle.toString() + " " + this.numero;
        
    }
    
}
