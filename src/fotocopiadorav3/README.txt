

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


