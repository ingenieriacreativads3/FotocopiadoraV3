package Otros;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JTextField;

public class Validador{
    
    private static boolean datosValidos;
    
    public Validador() {
        
        datosValidos = false;
        
    }
    
    public boolean validar(JTextField campo){
        
        if (!campo.getText().isEmpty()) {
            
            campo.setBorder(BorderFactory.createLineBorder(Color.green));
            //inicio validación específica
            
            //fin validación
            datosValidos = true;
            
        } else{
            
            campo.setBorder(BorderFactory.createLineBorder(Color.red));
            datosValidos = false;
            
        }
        
        return datosValidos;
    }
    
    
}