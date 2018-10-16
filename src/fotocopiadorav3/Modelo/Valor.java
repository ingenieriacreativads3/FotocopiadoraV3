/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fotocopiadorav3.Modelo;
import java.util.*;

/**

 @author Tomas
 */
public class Valor{
    
    /**
     * Este identificador, indica un numero de una calle
     * invalido. ES necesario para comparar los demas documentos.
     */
    public static final int numeroDeCalleInvalido = -1;
    
    /**
     * Este identificador, indica cada cuanto se debe iterar por cada
     * indentificador creado.
     */
    protected static final int SIGUIENTE_IDENTIFICADOR = 1;
    protected static final String VERIFICADOR_DE_CLASE_STRING = "ASD";
    
    /**
     * Este identificador, indica un numero de documento
     * invalido. ES necesario para comparar los demas numeros de calles.
     */
    public static final int dniInvalido = 0;
    

    private Valor(){}
    
}
