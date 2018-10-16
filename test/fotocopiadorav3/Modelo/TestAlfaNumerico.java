/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fotocopiadorav3.Modelo;

import java.util.*;
import javax.persistence.*;
import org.hibernate.annotations.common.util.impl.*;
import fotocopiadorav3.Modelo.*;

/**
 *
 * @author claudio
 */
public class TestAlfaNumerico {
//    
//    //Esta etiqueta se usa en JE, web aplication, 
//    @PersistenceContext(name = "persistencia")
    private static EntityManager manager;
    
    //private static EntityManagerFactory emf;
    
    public static void main(String[] args) {
//        //para insertar
//        //manager.persist(args);
//        
//        //para modificar
//        //manager.merge(args);
//        
//        //para eliminar
//        //manager.remove(args);
//        
//        //para obtener una entidad de la bd, a partir de su clave primaria
//        //manager.find(entityClass, manager);
//        
//        //para una trasanction, que nos permite insertar multiples elementos
//        //manager.getTransaction();
//        
//        //para hacer consultas
//        //manager.createQuery(deleteQuery);
//        
//        //Sino podemos generar el context, usamos un factory
//        
//        //Crear el gestor de persistencia (EM)

        try {
            
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("FotocopiadoraV3PU");
            
            manager = emf.createEntityManager();
        
            String query = "FROM " + AlfaNumerico.getClase();

            List<AlfaNumerico> conjunto = (List<AlfaNumerico>) manager.createQuery(query).getResultList();
            System.out.println("Hay " + conjunto.size() + "lineas");
            
        } catch (Exception e) {
            
            System.out.println(1);
            LoggerFactory.logger(TestAlfaNumerico.class);
            
        }
        
        
 
            
        
//
//        EntityManager manager = TestAlfaNumerico.getEntityManager();
//        System.out.println("EntityManager class ==> " + manager.getClass().getCanonicalName());
//    


    
      
//    public static EntityManager getEntityManager(){
//        EntityManagerFactory factory = Persistence.createEntityManagerFactory("FotocopiadoraV3PU");
//        EntityManager manager = factory.createEntityManager();
//        return manager;
        
    }
    
}
