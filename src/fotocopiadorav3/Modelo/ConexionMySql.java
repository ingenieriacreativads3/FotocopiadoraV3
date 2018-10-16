/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fotocopiadorav3.Modelo;

import fotocopiadorav3.Environment;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
    
}
