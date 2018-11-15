package Otros;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JTextField;

public class Validador{
    
    public Validador() {}
    
    public boolean validar(JTextField campo, int tipoValidacion){
        
        boolean datosValidos = false;
        String contenido = campo.getText();
        
        if (!contenido.isEmpty()) {
            
            datosValidos = validarCampo(contenido, tipoValidacion);
            
            if(datosValidos){
                
                campo.setBorder(BorderFactory.createLineBorder(Color.green, 2));
                
            } else{
                
                campo.setBorder(BorderFactory.createLineBorder(Color.red, 2));
                
            }
            
        } else{
            
            campo.setBorder(BorderFactory.createLineBorder(Color.red, 2));
            
        }
        
        return datosValidos;
    }
    
    private boolean validarCampo(String contenido, int tipoValidacion){
        
        boolean datosValidos = false;
        
        switch(tipoValidacion){
            
            case 0: validarAlfanumerico(contenido);
            case 1: validarNombre(contenido);
            case 2: validarLegajo(contenido);
            case 3: validarAltura(contenido);
            case 4: validarDni(contenido);
            case 5: validarContrasenia(contenido);
            
        }
        
        
        return datosValidos;
    }
    
    private boolean validarAlfanumerico(String contenido){
        
        boolean datosValidos = false;
        
        return datosValidos;
    }
    
    private boolean esTexto(String contenido){
        
        boolean datosValidos = false;
        
        for (int i = 0; i < contenido.length(); i++) {
            
            if (!Character.isLetter(contenido.charAt(i))) {
                
                datosValidos = false;
                
            }
        }
        
        return datosValidos;
    }
    
    private boolean esNumero(String contenido){
        
        boolean datosValidos = true;
        
        for (int i = 0; i < contenido.length(); i++) {
            
            if (!Character.isDigit(contenido.charAt(i))) {
                
                datosValidos = false;
                
            }
        }
        
        return datosValidos;
    }
    
    private boolean validarNombre(String contenido){
        
        boolean datosValidos = false;
        
        if (esTexto(contenido)) {
            
            
            
            
        }
        
        return datosValidos;
    }
    
    private boolean validarAltura(String contenido){
        
        boolean datosValidos = false;
        
        if (esNumero(contenido)) {
            
            
            
            
        }
        
        return datosValidos;
    }
    
    private boolean validarLegajo(String contenido){
        
        boolean datosValidos = false;
        
        if (esNumero(contenido)) {
            
            
            
            
        }
        
        return datosValidos;
    }
    
    private boolean validarDni(String contenido){
        
        boolean datosValidos = false;
        
        if (esNumero(contenido)) {
            
            
            
            
        }
        
        return datosValidos;
    }
    
    private boolean validarContrasenia(String contenido){
        
        boolean datosValidos = false;
        
        return datosValidos;
    }
    
    
    
    
    
}