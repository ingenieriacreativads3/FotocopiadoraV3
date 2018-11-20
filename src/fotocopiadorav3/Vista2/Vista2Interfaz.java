/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fotocopiadorav3.Vista2;

import fotocopiadorav3.Vista2.Usuario.NuevoUsuario;
import fotocopiadorav3.Vista2.Usuario.ModificarUsuario;
import fotocopiadorav3.Vista2.Pedido.NuevoPedido;
import fotocopiadorav3.Vista2.Pedido.ModificarPedido;
import fotocopiadorav3.Vista2.Articulo.ModificarArticulo;
import fotocopiadorav3.Vista2.Articulo.NuevoArticulo;
import fotocopiadorav3.Vista2.Alumno.NuevoAlumno;
import fotocopiadorav3.Vista2.Alumno.ModificarAlumno;
import fotocopiadorav3.Controlador.*;
import fotocopiadorav3.Modelo.Alumno;
import fotocopiadorav3.Modelo.Articulo;
import fotocopiadorav3.Modelo.Usuario;
import fotocopiadorav3.Modelo.ModeloInterfaz;
import fotocopiadorav3.Modelo.Pedido;
import fotocopiadorav3.Vista2.Alumno.ListaAlumnos;
import fotocopiadorav3.Vista2.Articulo.ListaArticulos;
import fotocopiadorav3.Vista2.Pedido.ListaPedidos;
import fotocopiadorav3.Vista2.Usuario.ListaUsuarios;
import java.util.*;
import javax.swing.JPanel;

/**
 *
 * @author claudio
 */
public class Vista2Interfaz {
    
    private static PaginaPrincipalMejorada paginaPrincipal = new PaginaPrincipalMejorada();
    private static ListaAlumnos listaAlumnos = new ListaAlumnos();
    private static ListaArticulos listaArticulos = new ListaArticulos();
    private static ListaUsuarios listaUsuarios = new ListaUsuarios();
    private static ListaPedidos listaPedidos = new ListaPedidos();
    private static int numeroListaAlumnosTab;
    private static int numeroListaArticulosTab;
    private static int numeroListaUsuariosTab;
    private static int numeroListaPedidosTab;
    
    
    
    /*RENDERIZADO DE VENTANAS Y FORMULARIOS*/
    
    public static void renderizarLogin(){
        
        Login login = new Login();
        login.setVisible(true);
        
    }
    
    public static void renderizarPaginaPrincipal(){
        
        paginaPrincipal.establecerListados(listaAlumnos, listaArticulos, listaUsuarios);
        paginaPrincipal.setVisible(true);
        
    }
    
    public static void renderizarMensajeConfirmacion(int tipoMensaje, int idElemento){
        
        MensajeConfirmacion mensajeConfirmacion = new MensajeConfirmacion();
        
        String titulo = "Eliminar ";
        String mensaje = "Está seguro de que quiere eliminar el ";
        
        switch(tipoMensaje){
            
            case 0: titulo.concat("Pedido");
                        mensaje.concat("pedido: ");
                        Pedido pedido = ModeloInterfaz.getPedidoForId(idElemento);
                        mensaje.concat("id: " + Integer.toString(pedido.getId()));
                        break;
            
            case 1: titulo.concat("Artículo");
                        mensaje.concat("artículo: ");
                        Articulo articulo = ModeloInterfaz.getArticuloForId(idElemento);
                        mensaje.concat("id: " + Integer.toString(articulo.getId()));
                        mensaje.concat("\nnombre" + articulo.getNombre().toString());
                        break;
            
            case 2: titulo.concat("Alumno");
                        mensaje.concat("alumno: ");
                        Alumno alumno = ModeloInterfaz.getAlumnoForId(idElemento);
                        mensaje.concat("id: " + Integer.toString(alumno.getId()));
                        mensaje.concat("\nnombre: " + alumno.getPersona().getNombre().toString());
                        break;
            
            case 3: titulo.concat("Usuario");
                        mensaje.concat("Usuario: ");
                        Usuario usuario = ModeloInterfaz.getUsuarioForId(idElemento);
                        mensaje.concat("id: " + Integer.toString(usuario.getId()));
                        mensaje.concat("\nnombre: " + usuario.getPersona().getNombre().toString());
                        break;
            
            default: renderizarMensajeError("Error de eliminación", "Há ocurrido un error al intentar dar de baja a algún elemento en el sistema");
        }
        
        mensajeConfirmacion.setTipoElemento(tipoMensaje);
        mensajeConfirmacion.setIdElemento(idElemento);
        mensajeConfirmacion.setTituloConfirmacion(titulo);
        mensajeConfirmacion.setMensajeConfirmacion(mensaje);
        mensajeConfirmacion.setVisible(true);
        
    }
    
    public static void renderizarMensajeError(String codigo, String mensaje){
        
        MensajeError mensajeError = new MensajeError();
        mensajeError.setCodigoError(codigo);
        mensajeError.setMensajeError(mensaje);
        mensajeError.setVisible(true);
        
    }
    
    public static void renderizarInventario(){
        
    }

    public static void renderizarListadoAlumnos(){
        
        if (!listaAlumnos.isExiste()) {
            
            listaAlumnos.setExiste(true);
            JPanel panel = new JPanel();
            panel.add(listaAlumnos.getContentPane());
            paginaPrincipal.getAreaTrabajo().addTab("Listado Alumnos", panel);
            numeroListaAlumnosTab = paginaPrincipal.getAreaTrabajo().getTabCount()-1;
            paginaPrincipal.getAreaTrabajo().setSelectedIndex(numeroListaAlumnosTab);
        
        } else{
            
            paginaPrincipal.getAreaTrabajo().setSelectedIndex(numeroListaAlumnosTab);
            Set<Alumno> alumnos = Vista2Interfaz.obtenerListaAlumnos();
            listaAlumnos.recargarTabla(alumnos);
            
        }
    }

    public static void renderizarListadoUsuarios(){
        
        if (!listaUsuarios.isExiste()) {
            
            listaUsuarios.setExiste(true);
            JPanel panel = new JPanel();
            panel.add(listaUsuarios.getContentPane());
            paginaPrincipal.getAreaTrabajo().addTab("Listado Usuarios", panel);
            numeroListaUsuariosTab = paginaPrincipal.getAreaTrabajo().getTabCount()-1;
            paginaPrincipal.getAreaTrabajo().setSelectedIndex(numeroListaUsuariosTab);
        
        } else{
            
            paginaPrincipal.getAreaTrabajo().setSelectedIndex(numeroListaUsuariosTab);
            Set<Usuario> usuarios = Vista2Interfaz.obtenerListaUsuarios();
            listaUsuarios.recargarTabla(usuarios);
            
        }
    }

    public static void renderizarListadoArticulos(){
        
        if (!listaArticulos.isExiste()) {
            
            listaArticulos.setExiste(true);
            JPanel panel = new JPanel();
            panel.add(listaArticulos.getContentPane());
            paginaPrincipal.getAreaTrabajo().addTab("Listado Artículos", panel);
            numeroListaArticulosTab = paginaPrincipal.getAreaTrabajo().getTabCount()-1;
            paginaPrincipal.getAreaTrabajo().setSelectedIndex(numeroListaArticulosTab);
        
        } else{
            
            paginaPrincipal.getAreaTrabajo().setSelectedIndex(numeroListaArticulosTab);
            Set<Articulo> articulos = Vista2Interfaz.obtenerListaArticulos();
            listaArticulos.recargarTabla(articulos);
            
        }
    }

    public static void renderizarListadoPedidos(){
        
        if (!listaPedidos.isExiste()) {
            
            listaPedidos.setExiste(true);
            JPanel panel = new JPanel();
            panel.add(listaPedidos.getContentPane());
            paginaPrincipal.getAreaTrabajo().addTab("Listado Pedidos", panel);
            numeroListaPedidosTab = paginaPrincipal.getAreaTrabajo().getTabCount()-1;
            paginaPrincipal.getAreaTrabajo().setSelectedIndex(numeroListaPedidosTab);
        
        } else{
            
            paginaPrincipal.getAreaTrabajo().setSelectedIndex(numeroListaPedidosTab);
            Set<Pedido> pedidos = Vista2Interfaz.obtenerListaPedidos();
            listaPedidos.recargarTabla(pedidos);
            
        }
    }

    public static void renderizarNuevoPedido(){
        
        NuevoPedido nuevoPedido = new NuevoPedido();
        JPanel panel = new JPanel();
        panel.add(nuevoPedido.getContentPane());
        paginaPrincipal.getAreaTrabajo().addTab("Nuevo Pedido", panel);
        
    }

    public static void renderizarModificarPedido(int idPedido){
        
        ModificarPedido modificarPedido = new ModificarPedido();
        modificarPedido.setIdPedido(idPedido);
        JPanel panel = new JPanel();
        panel.add(modificarPedido.getContentPane());
        paginaPrincipal.getAreaTrabajo().addTab("Modificar Pedido", panel);
        
    }

    public static void renderizarNuevoArticulo(){
        
        NuevoArticulo nuevoArticulo = new NuevoArticulo();
        JPanel panel = new JPanel();
        panel.add(nuevoArticulo.getContentPane());
        paginaPrincipal.getAreaTrabajo().addTab("Nuevo Articulo", panel);
        
    }

    public static void renderizarModificarArticulo(int idArticulo){
        
        ModificarArticulo modificarArticulo = new ModificarArticulo();
        modificarArticulo.setIdArticulo(idArticulo);
        JPanel panel = new JPanel();
        panel.add(modificarArticulo.getContentPane());
        paginaPrincipal.getAreaTrabajo().addTab("Modificar Articulo", panel);
        
    }

    public static void renderizarNuevoUsuario(){
        
        NuevoUsuario nuevoUsuario = new NuevoUsuario();
        JPanel panel = new JPanel();
        panel.add(nuevoUsuario.getContentPane());
        paginaPrincipal.getAreaTrabajo().addTab("Nuevo Usuario", panel);
        
    }

    public static void renderizarModificarUsuario(int idUsuario){
        
        ModificarUsuario modificarUsuario = new ModificarUsuario();
        modificarUsuario.setIdUsuario(idUsuario);
        JPanel panel = new JPanel();
        panel.add(modificarUsuario.getContentPane());
        paginaPrincipal.getAreaTrabajo().addTab("Modificar Usuario", panel);
        
    }

    public static void renderizarNuevoAlumno(){
        
        NuevoAlumno nuevoAlumno = new NuevoAlumno();
        JPanel panel = new JPanel();
        panel.add(nuevoAlumno.getContentPane());
        paginaPrincipal.getAreaTrabajo().addTab("Nuevo Alumno", panel);
        
    }

    public static void renderizarModificarAlumno(int idAlumno){
        
        ModificarAlumno modificarAlumno = new ModificarAlumno();
        modificarAlumno.setIdAlumno(idAlumno);
        JPanel panel = new JPanel();
        panel.add(modificarAlumno.getContentPane());
        paginaPrincipal.getAreaTrabajo().addTab("Modificar Alumno", panel);
        
    }

    /*FIN DE RENDERIZADOS*/
    
    /*ENVÍO DE DATOS -> ControladorInterfaz*/
    
    public static void enviarDatosInicioSesion(String nombreUsuario, String contrasenia){
        
        ControladorInterfaz.iniciarSesion(nombreUsuario, contrasenia);
        
    }
    
    /*ALTAS*/
    
    public static void enviarDatosNuevoArticulo(String nombre, String editorial, String categoria, String autor, String edicion, String materia, String precio, String documento){
        
        ControladorInterfaz.crearArticulo(nombre, autor, precio, materia);
        
    }
    
    public static void enviarDatosNuevoUsuario(String nombre, String apellido, String nombreUsuario, String contrasenia, String domicilio, String altura, String dni){
        
        ControladorInterfaz.altaUsuario(nombreUsuario, apellido, nombreUsuario, contrasenia, domicilio, domicilio, dni);
        
    }
    
    public static void enviarDatosNuevoAlumno(String nombre, String apellido, String legajo, String domicilio, String altura, String dni){
        
        ControladorInterfaz.adicionarClienteComoRegistrado(legajo, nombre, apellido, domicilio, altura, dni);
        
    }
    
    public static void enviarDatosNuevoPedido(String alumno, ArrayList<String> nombresArticulos, ArrayList<String> fechaEstimadaArticulos, ArrayList<String> cantidadArticulos, ArrayList<String> precioUnitarioArticulos, ArrayList<String> precioTotalArticulos, String importeTotal, String senia){
        
        //ControladorInterfaz.crearNuevoPedido(alumno, nombresArticulos, fechaEstimadaArticulos, cantidadArticulos, precioUnitarioArticulos, precioTotalArticulos, importeTotal, senia);
        
    }
    
    /*MODIFICACIONES*/
    
    public static void enviarDatosModificarArticulo(String idArticulo, String nombre, String editorial, String categoria, String autor, String edicion, String materia, String precio, String documento){
        
        ControladorInterfaz.modificacionArticulo(idArticulo, nombre, autor, precio, 0);     //idMateria
        
    }
    
    public static void enviarDatosModificarUsuario(String idUsuario, String nombre, String apellido, String nombreUsuario, String contrasenia, String domicilio, String altura, String dni){
        
        ControladorInterfaz.modificacionUsuario(idUsuario, nombreUsuario, apellido, nombreUsuario, contrasenia, domicilio, altura, dni);
        
    }
    
    public static void enviarDatosModificarAlumno(String nombre, String apellido, String legajo, String domicilio, String altura, String dni){
        
        ControladorInterfaz.modificacionClienteComoRegistrado(legajo, nombre, apellido, domicilio, altura, dni);
        
    }
    
    public static void enviarDatosModificarPedido(String alumno, ArrayList<String> nombresArticulos, ArrayList<String> fechaEstimadaArticulos, ArrayList<String> cantidadArticulos, ArrayList<String> precioUnitarioArticulos, ArrayList<String> precioTotalArticulos, String importeTotal, String senia){
        
        //ControladorInterfaz.modificarPedido(alumno, nombresArticulos, fechaEstimadaArticulos, cantidadArticulos, precioUnitarioArticulos, precioTotalArticulos, importeTotal, senia);
        
    }
    
    /*BAJAS*/
    
    /*FIN DE ENVÍOS DE DATOS*/
    
    /*OBTENCIÓN DE DATOS -> ModeloInterfaz*/
    
//    public static Set<String> obtenerListaInventario(){
//        
//        Set<String> listaInventario = new Set<>();
//        
//        return listaInventario;
//        
//    }
    
    public static Set<Usuario> obtenerListaUsuarios(){
        
        Set<Usuario> listaUsuarios = ModeloInterfaz.getListaUsuarios();
        
        return listaUsuarios;
        
    }
    
    public static Set<Alumno> obtenerListaAlumnos(){
        
        Set<Alumno> listaAlumnos = ModeloInterfaz.getListaAlumnos();
        
        return listaAlumnos;
        
    }
    
    public static Set<Articulo> obtenerListaArticulos(){
        
        Set<Articulo> listaArticulos = ModeloInterfaz.getListaArticulos();
        
        return listaArticulos;
        
    }
    
    public static Set<Pedido> obtenerListaPedidos(){
        
        Set<Pedido> listaPedidos = ModeloInterfaz.getListaPedidos();
        
        return listaPedidos;
        
    }
    
    /*FIN DE OBTENCIÓN DE DATOS*/
    
}
