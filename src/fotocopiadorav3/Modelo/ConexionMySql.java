/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fotocopiadorav3.Modelo;

import fotocopiadorav3.*;
import java.sql.*;

/**
 *
 * @author claudio
 */
public class ConexionMySql {
    
    // Librería de MySQL
    protected String driver = Environment.DRIVER;

    // Nombre de la base de datos
    protected String database = Environment.DATABASE;

    // Host
    protected String hostname = Environment.HOSTNAME;

    // Puerto
    protected String port = Environment.PORT;

    // Ruta de nuestra base de datos (desactivamos el uso de SSL con "?useSSL=false")
    protected String url = Environment.URL;

    // Nombre de usuario
    protected String username = Environment.USERNAME;

    // Clave de usuario
    protected String password = Environment.PASSWORD;
    
    private static ConexionMySql conexionMySql = null;
    
    //Constructor
    private ConexionMySql(){}
    
    protected static ConexionMySql nuevo(){
        
        ConexionMySql conexionDevolver = conexionMySql;
        
        if(conexionDevolver == null){
            
            conexionDevolver = new ConexionMySql();
            
        }else{
            
            //...se establecio un valor por defecto
            
        }
        
        conexionMySql = conexionDevolver;
        
        return conexionDevolver;
        
    }

    public Connection conectarMySQL() {
        
        Connection conn = null;

        try {
            
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
            
        } catch (ClassNotFoundException | SQLException e) {
            
            e.printStackTrace();
            
        }

        return conn;
        
    }
    
    public static Estado asd(){
        
        Estado estadoDevolver = null;
        
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
            
            prepStmt.executeUpdate();
            
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
    
}
