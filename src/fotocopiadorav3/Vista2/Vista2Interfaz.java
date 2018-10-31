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
    
    private static PaginaPrincipalMejorada paginaPrincipal = new PaginaPrincipalMejorada();
    
    public static void renderizarLogin(){
        
        Login login = new Login();
        login.setVisible(true);
        
    }
    
    public static void renderizarPaginaPrincipal(){
        
        PaginaPrincipalMejorada asd = new PaginaPrincipalMejorada();
        asd.setVisible(true);
        paginaPrincipal = asd;
        
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
        
        ModificarPedido modificarPedido = new ModificarPedido();
        JPanel panel = new JPanel();
        panel.add(modificarPedido.getContentPane());
        paginaPrincipal.getAreaTrabajo().addTab("Modificar Pedido", panel);
        
    }

    public static void renderizarCancelarPedido(){
        
    }

    public static void renderizarNuevoArticulo(){
        
        NuevoArticulo nuevoArticulo = new NuevoArticulo();
        JPanel panel = new JPanel();
        panel.add(nuevoArticulo.getContentPane());
        paginaPrincipal.getAreaTrabajo().addTab("Nuevo Articulo", panel);
        
    }

    public static void renderizarModificarArticulo(){
        
        ModificarArticulo modificarArticulo = new ModificarArticulo();
        JPanel panel = new JPanel();
        panel.add(modificarArticulo.getContentPane());
        paginaPrincipal.getAreaTrabajo().addTab("Modificar Articulo", panel);
        
    }

    public static void renderizarEliminarArticulo(){
        
    }
    
    public static void renderizarNuevoUsuario(){
        
        NuevoUsuario nuevoUsuario = new NuevoUsuario();
        JPanel panel = new JPanel();
        panel.add(nuevoUsuario.getContentPane());
        paginaPrincipal.getAreaTrabajo().addTab("Nuevo Usuario", panel);
        
    }

    public static void renderizarModificarUsuario(){
        
        ModificarUsuario modificarUsuario = new ModificarUsuario();
        JPanel panel = new JPanel();
        panel.add(modificarUsuario.getContentPane());
        paginaPrincipal.getAreaTrabajo().addTab("Modificar Usuario", panel);
        
    }

    public static void renderizarEliminarUsuario(){
        
    }
    
    public static void renderizarNuevoAlumno(){
        
        NuevoAlumno nuevoAlumno = new NuevoAlumno();
        JPanel panel = new JPanel();
        panel.add(nuevoAlumno.getContentPane());
        paginaPrincipal.getAreaTrabajo().addTab("Nuevo Alumno", panel);
        
    }

    public static void renderizarModificarAlumno(){
        
        ModificarAlumno modificarAlumno = new ModificarAlumno();
        JPanel panel = new JPanel();
        panel.add(modificarAlumno.getContentPane());
        paginaPrincipal.getAreaTrabajo().addTab("Modificar Alumno", panel);
        
    }

    public static void renderizarEliminarAlumno(){
        
    }
    
    public static void enviarDatosInicioSesion(String nombreUsuario, String contrasenia){
        
        System.out.println("interfaz vista");
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
    
    public static void enviarDatosNuevoAlumno(String nombre, String apellido, String legajo, String domicilio, String altura, String dni){
        
        //ControladorInterfaz.modificarUsuario(nombre, apellido, nombreUsuario, contrasenia, domicilio, altura, dni);
        
    }
    
    public static void enviarDatosModificarAlumno(String nombre, String apellido, String legajo, String domicilio, String altura, String dni){
        
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
