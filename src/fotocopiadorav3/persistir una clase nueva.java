/*
///Verificar que todos sus atributos, 
///sean tipo bd, ninguna referencia a objetos.
///Si hay una referencia a un objeto, 
///crear una clave foranea.

private int idNombreObjeto;

///Establecer valores para referenciar 
///al conjunto de datos

private static final String NOMBRE_TABLA = 
    "nombreTabla";

private static final String CAMPO_ID = "id";
private static final String CAMPO_VALOR = "valor";

private static final int CANTIDAD_DE_CAMPOS = 2;
private static final int LUGAR_DEL_CAMPO_ID = 1;
private static final int LUGAR_DEL_CAMPO_VALOR = 2;

///Crear la bd con los datos establecido 
///anteriormente

create table alfanumerico ( 
    id int primary key, 
    valor varchar(30));

///Cambiar el metodo nuevo

protected static Direccion nuevo();

///Por privado

private static Direccion nuevo();

///Copiar el metodo, en donde corresponda,
///y cambiar el objeto devolvido

protected static AlfaNumerico nuevo(
    String palabraRecibida);

///Crear un constructor sobrecargado que reciba 
///el identificador adecuado

private Direccion(int idActual);

///Copiar las funciones en su totalidad

private static int getNewId();
private static int getLastId();
protected static Estado getInformacion();

///Arreglar el while de getInformation(),
///para la convenincia de la clase, 
///solicitando todos los datos que
///hay en la tabla, y agregandolos
///a la lista

while (rs.next());

///Copiar la funcion

public static AlfaNumerico getForId(
        int idRecibido);

///Copiar la funcion que recibe,
///todos los parametros

private static AlfaNumerico nuevo(
    int idActual, String valorActual);

///Modificarla firma para que tenga absolutamente 
///todos sus argumentos
///Esta, debe crear todos los objetos que vengan
///de la bd con los atributos recibidos

///Dar por terminada la funcion
///que recibe TODOS sus parametros

private static Direccion nuevo(
    int idActual, 
    AlfaNumerico calleActual, 
    int numeroActual, 
    int idAlfaRecibido);

///Dar por terminada la funcion

protected static Estado getInformacion();

///en la clase ConexionMysql agragar la
///linea

Pedido.getInformacion();

///Seguir cambiando la funcion

private static int getLastId();

///Dar por terminada la funcion

private static int getLastId();

///Dar por terminada la funcion

private static int getNewId();

///Seguir modificando la funcion

protected static Direccion nuevo(
    AlfaNumerico calle, 
    int numero);

///Arreglar las funciones de set, que quedan, 
///hacerlas todas private
///y copiarlas de esta funcion en alfanumerico

private Estado setValor(String valorRecibido);

///Hacer la funcion 

public static Estado guardar();


*/

//******************************************

/*
///HACER ESTO EN TODAS LAS CALSES

///modificar la funcion

private static int getLastId();

///en la linea

Estado estadoConsulta = getInformacion();

///por la linea

Estado estadoConsulta = Estado.EXITO;

///ir a la clase 

ConexionMySql.java

///a la funcion

getAllInformacion();

///Agregar getInformacion de la clase modificada
///terminar de modificar la funcion 

getLastId();

///poner todo dentro de in if

if(listaObjetos != null);

///Modificar la funcion 

getForId();

///cambiar la linea

Estado seObtuvo = getInformacion();

// por la linea

Estado seObtuvo = Estado.EXITO;

///poner todo en un if

if(listaObjetos != null);

///en la funcion 

protected static AlfaNumerico nuevo(
    String palabraRecibida);

///comentar las lineas

Estado seGuardo = objetoDevolver.guardar();

///y el if que sigue

if(seGuardo == Estado.EXITO);

///la linea 

listaObjetos.remove(objetoDevolver);

///colocarla en el else siguiente del if

if(seSeteo == Estado.EXITO);

///ir a la funcion guardar y hacerla public

///no olvidarse de colocar todos los set
///de todos los atributos para usarlos
///en el while de getinformacion
///y en el constructor que recibe todos
///los parametros. y no olvidar colocar
///el objeto nuevo en la lista en la misma
///funcion

///Controlar que la funcion

private static Estado addNewObjeto(Object objetoActual);

///este correcta en el if de control de clase


///copiar la funcion en su clase

protected static Set<Articulo> getLista();

///y la funcion 

public static Set<Pedido> getListaPedidos();

///en la clase interfaz


*/


