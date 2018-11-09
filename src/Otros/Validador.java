package Otros;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JTextField;

public class Validador{
    
    public Validador() {}
    
    public boolean validar(JTextField campo){
        
        boolean datosValidos = false;
        
        if (!campo.getText().isEmpty()) {
            
            datosValidos = validarCampo();
            
            if(datosValidos){
                
                campo.setBorder(BorderFactory.createLineBorder(Color.green));
                
            } else{
                
                campo.setBorder(BorderFactory.createLineBorder(Color.red));
                
            }
            
        } else{
            
            campo.setBorder(BorderFactory.createLineBorder(Color.red));
            
        }
        
        return datosValidos;
    }
    
    private boolean validarCampo(){
        
        
        return true;
    }
    
    
    
    
    
    
    
}