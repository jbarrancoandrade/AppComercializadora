package POJOS;
// Generated 25-oct-2014 9:20:16 by Hibernate Tools 3.6.0



/**
 * AlmTallas generated by hbm2java
 */
public class AlmTallas  implements java.io.Serializable {


     private AlmTallasId id;
     private String nomTalla;
     private int ordenTalla;
     private boolean modificado;

    public AlmTallas() {
    }

    public AlmTallas(AlmTallasId id, String nomTalla, int ordenTalla, boolean modificado) {
       this.id = id;
       this.nomTalla = nomTalla;
       this.ordenTalla = ordenTalla;
       this.modificado = modificado;
    }
   
    public AlmTallasId getId() {
        return this.id;
    }
    
    public void setId(AlmTallasId id) {
        this.id = id;
    }
    public String getNomTalla() {
        return this.nomTalla;
    }
    
    public void setNomTalla(String nomTalla) {
        this.nomTalla = nomTalla;
    }
    public int getOrdenTalla() {
        return this.ordenTalla;
    }
    
    public void setOrdenTalla(int ordenTalla) {
        this.ordenTalla = ordenTalla;
    }
    public boolean isModificado() {
        return this.modificado;
    }
    
    public void setModificado(boolean modificado) {
        this.modificado = modificado;
    }




}


