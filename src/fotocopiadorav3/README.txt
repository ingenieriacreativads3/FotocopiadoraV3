

///Abrir phpmyadmin

///crear una nueva bd, con el nombre que prefiera, en el atributo del costado,
///creo que pide el tipo de caracteres permitidos, con cualquiera andaria,
///pero lo hice con el que aparece por default, 

latin1_swedish_ci

///ese nombre colocarlo en 

..\FotocopiadoraV3\src\fotocopiadorav3\Environment.java

///en el atributo 

public static String DATABASE = "nombre que prefiera";

///en la barra de herramientas se encuentran los siguientes tab

Estructura/SQL/BUscar/...

///Presionar en SQL, debe aparecer una consola, con un titulo que diga, 

Ejecutar la(s) consulta(s) SQL en la base de datos fotocopiadora:

///En la consola colocar las siguientes lineas


create table alfanumerico ( id int primary key, valor varchar(30));
create table direccion( id int primary key, numero int, id_alfanumerico int);
create table persona( id int primary key, dni int, id_nombre int, id_apellido int, id_direccion int);
create table usuario( id int primary key, id_persona int, id_nombre_usuario int, id_pass int);
create table alumno ( id int primary key, legajo int, id_persona int);
create table articulo ( id int primary key, id_documento int, id_categoria int, precio double, fecha_ingreso date, id_nombre int, id_autor int, id_editorial int, id_edicion int, id_materia int);
create table pedido ( id int primary key, fecha date, importe double, id_alumno int, id_codigo_transaccion int, pago_anticipado double);
