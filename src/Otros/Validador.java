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
            
            case 0: datosValidos = validarAlfanumerico(contenido);
                        break;
            case 1: datosValidos = validarNombre(contenido);
                        break;
            case 2: datosValidos = validarLegajo(contenido);
                        break;
            case 3: datosValidos = validarAltura(contenido);
                        break;
            case 4: datosValidos = validarDni(contenido);
                        break;
            case 5: datosValidos = validarContrasenia(contenido);
                        break;
            case 6: datosValidos = esNumero(contenido);
                        break;
            
        }
        
        
        return datosValidos;
    }
    
    private boolean validarAlfanumerico(String contenido){
        
        boolean datosValidos = true;
        
        if (contenido.length() < 3 || contenido.length() > 25) {
            
            datosValidos = false;
            
        }
        
        return datosValidos;
    }
    
    private boolean esTexto(String contenido){
        
        boolean datosValidos = true;
        
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
        
        boolean datosValidos = true;
        
        if (esTexto(contenido)) {
            
            if (contenido.length() < 2 || contenido.length() > 20) {
                
                datosValidos = false;
                
            }
            
        } else{
            
            datosValidos = false;
            
        }
        
        return datosValidos;
    }
    
    private boolean validarAltura(String contenido){
        
        boolean datosValidos = true;
        
        if (esNumero(contenido)) {
            
            try {
                
                int altura = Integer.valueOf(contenido);
                
                if (altura < 0 || altura > 10000) {
                    
                    datosValidos = false;
                    
                }
                
            } catch (Exception e) {
                
                datosValidos = false;
                
            }
            
        } else{
            
            datosValidos = false;
            
        }
        
        return datosValidos;
    }
    
    private boolean validarLegajo(String contenido){
        
        boolean datosValidos = true;
        
        if (esNumero(contenido)) {
            
            try {
                
                int altura = Integer.valueOf(contenido);
                
                if (altura < 0 || altura > 50000) {
                    
                    datosValidos = false;
                    
                }
                
            } catch (Exception e) {
                
                datosValidos = false;
                
            }
            
        } else{
            
            datosValidos = false;
            
        }
        
        return datosValidos;
    }
    
    private boolean validarDni(String contenido){
        
        boolean datosValidos = true;
        
        if (esNumero(contenido)) {
            
            try {
                
                long altura = Long.valueOf(contenido);
                
                if (altura < 10000000 || altura > 50000000) {
                    
                    datosValidos = false;
                    
                }
                
            } catch (Exception e) {
                
                datosValidos = false;
                
            }
            
        } else{
            
            datosValidos = false;
            
        }
        
        return datosValidos;
    }
    
    private boolean validarContrasenia(String contenido){
        
        boolean datosValidos = true;
        
        if (contenido.length() < 6 || contenido.length() > 16) {
            
            datosValidos = false;
            
        }
        
        return datosValidos;
    }
}