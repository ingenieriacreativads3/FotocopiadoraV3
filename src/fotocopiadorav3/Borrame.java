package fotocopiadorav3;
// Generated Oct 15, 2018 2:25:18 PM by Hibernate Tools 4.3.1

import java.util.*;

/**
 * Borrame generated by hbm2java
 */
public class Borrame  implements java.io.Serializable {


     private int asd;
     private Date fecha;

    public Borrame() {
    }

	
    public Borrame(int asd) {
        this.asd = asd;
    }
    public Borrame(int asd, Date fecha) {
       this.asd = asd;
       this.fecha = fecha;
    }
   
    public int getAsd() {
        return this.asd;
    }
    
    public void setAsd(int asd) {
        this.asd = asd;
    }
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }




}


