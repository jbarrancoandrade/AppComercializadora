package POJOS;
// Generated 25-oct-2014 9:20:16 by Hibernate Tools 3.6.0



/**
 * GenCentros generated by hbm2java
 */
public class GenCentros  implements java.io.Serializable {


     private String codcen;
     private String nomcen;
     private boolean modificado;

    public GenCentros() {
    }

	
    public GenCentros(String codcen, boolean modificado) {
        this.codcen = codcen;
        this.modificado = modificado;
    }
    public GenCentros(String codcen, String nomcen, boolean modificado) {
       this.codcen = codcen;
       this.nomcen = nomcen;
       this.modificado = modificado;
    }
   
    public String getCodcen() {
        return this.codcen;
    }
    
    public void setCodcen(String codcen) {
        this.codcen = codcen;
    }
    public String getNomcen() {
        return this.nomcen;
    }
    
    public void setNomcen(String nomcen) {
        this.nomcen = nomcen;
    }
    public boolean isModificado() {
        return this.modificado;
    }
    
    public void setModificado(boolean modificado) {
        this.modificado = modificado;
    }




}


