/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fotocopiadorav3.Vista2;

import fotocopiadorav3.Controlador.*;
import java.util.*;
import javax.swing.JPanel;

/**
 *
 * @author claudio
 */
public class Vista2Interfaz {
    
    private static final PaginaPrincipal paginaPrincipal = new PaginaPrincipal();
    
    public static void renderizarLogin(){
        
        Login login = new Login();
        login.setVisible(true);
        
    }
    
    public static void renderizarPaginaPrincipal(){
        
        paginaPrincipal.setVisible(true);
        
    }
    
    public static void renderizarInventario(){
        
    }

    public static void renderizarNuevoPedido(){
        
        NuevoPedido nuevoPedido = new NuevoPedido();
        JPanel panel = new JPanel();
        panel.add(nuevoPedido.getContentPane());
        paginaPrincipal.getAreaTrabajo().addTab("Nuevo Pedido", panel);
        
    }

    public static void renderizarModificarPedido(){
        
    }

    public static void renderizarCancelarPedido(){
        
    }

    public static void renderizarNuevoDocumento(){
        
        NuevoDocumento nuevoDocumento = new NuevoDocumento();
        nuevoDocumento.setVisible(true);
        
    }

    public static void renderizarModificarDocumento(){
        
    }

    public static void renderizarEliminarDocumento(){
        
    }
    
    public static void renderizarNuevoUsuario(){
        
        NuevoUsuario nuevoUsuario = new NuevoUsuario();
        nuevoUsuario.setVisible(true);
        
    }

    public static void renderizarModificarUsuario(){
        
    }

    public static void renderizarEliminarUsuario(){
        
    }
    
    public static void enviarDatosInicioSesion(String nombreUsuario, String contrasenia){
        
        ControladorInterfaz.iniciarSesion(nombreUsuario, contrasenia);
        
    }
    
    public static void enviarDatosNuevoDocumento(String nombre, String editorial, String categoria, String autor, String edicion, String materia, String precio, String documento){
        
        //ControladorInterfaz.crearNuevoDocumento(nombre, editorial, categoria, autor, edicion, materia, precio, documento);
        
    }
    
    public static void enviarDatosModificarDocumento(String nombre, String editorial, String categoria, String autor, String edicion, String materia, String precio, String documento){
        
        //ControladorInterfaz.modificarDocumento(nombre, editorial, categoria, autor, edicion, materia, precio, documento);
        
    }
    
    public static void enviarDatosNuevoUsuario(String nombre, String apellido, String nombreUsuario, String contrasenia, String domicilio, String altura, String dni){
        
        //ControladorInterfaz.crearNuevoUsuario(nombre, apellido, nombreUsuario, contrasenia, domicilio, altura, dni);
        
    }
    
    public static void enviarDatosModificarUsuario(String nombre, String apellido, String nombreUsuario, String contrasenia, String domicilio, String altura, String dni){
        
        //ControladorInterfaz.modificarUsuario(nombre, apellido, nombreUsuario, contrasenia, domicilio, altura, dni);
        
    }
    
    public static void enviarDatosNuevoPedido(String alumno, ArrayList<String> nombresArticulos, ArrayList<String> fechaEstimadaArticulos, ArrayList<String> cantidadArticulos, ArrayList<String> precioUnitarioArticulos, ArrayList<String> precioTotalArticulos, String importeTotal, String senia){
        
        //ControladorInterfaz.crearNuevoPedido(alumno, nombresArticulos, fechaEstimadaArticulos, cantidadArticulos, precioUnitarioArticulos, precioTotalArticulos, importeTotal, senia);
        
    }
    
    public static void enviarDatosModificarPedido(String alumno, ArrayList<String> nombresArticulos, ArrayList<String> fechaEstimadaArticulos, ArrayList<String> cantidadArticulos, ArrayList<String> precioUnitarioArticulos, ArrayList<String> precioTotalArticulos, String importeTotal, String senia){
        
        //ControladorInterfaz.modificarPedido(alumno, nombresArticulos, fechaEstimadaArticulos, cantidadArticulos, precioUnitarioArticulos, precioTotalArticulos, importeTotal, senia);
        
    }
    
    public static ArrayList<String> obtenerListaInventario(){
        
        ArrayList<String> asd = new ArrayList<>();
        
        return asd;
        
        //return ControladorInterfaz.enviarDatosInventario();
        
        
    }
    
    public static ArrayList<String> obtenerListaDocumentos(){
        
        ArrayList<String> asd = new ArrayList<>();
        
        return asd;
        
        //return ControladorInterfaz.enviarDatosDocumentos();
        
    }
    
    public static ArrayList<String> obtenerListaPedidos(){
        
        ArrayList<String> asd = new ArrayList<>();
        
        return asd;
        
        //return ControladorInterfaz.enviarDatosPedidos();
        
    }
    
}
