package POJOS;
// Generated 25-oct-2014 9:20:16 by Hibernate Tools 3.6.0



/**
 * CntFuentes generated by hbm2java
 */
public class CntFuentes  implements java.io.Serializable {


     private String codFue;
     private String codAnu;
     private String nomFue;
     private boolean anulacion;
     private boolean sistema;
     private boolean modificado;

    public CntFuentes() {
    }

    public CntFuentes(String codFue, String codAnu, String nomFue, boolean anulacion, boolean sistema, boolean modificado) {
       this.codFue = codFue;
       this.codAnu = codAnu;
       this.nomFue = nomFue;
       this.anulacion = anulacion;
       this.sistema = sistema;
       this.modificado = modificado;
    }
   
    public String getCodFue() {
        return this.codFue;
    }
    
    public void setCodFue(String codFue) {
        this.codFue = codFue;
    }
    public String getCodAnu() {
        return this.codAnu;
    }
    
    public void setCodAnu(String codAnu) {
        this.codAnu = codAnu;
    }
    public String getNomFue() {
        return this.nomFue;
    }
    
    public void setNomFue(String nomFue) {
        this.nomFue = nomFue;
    }
    public boolean isAnulacion() {
        return this.anulacion;
    }
    
    public void setAnulacion(boolean anulacion) {
        this.anulacion = anulacion;
    }
    public boolean isSistema() {
        return this.sistema;
    }
    
    public void setSistema(boolean sistema) {
        this.sistema = sistema;
    }
    public boolean isModificado() {
        return this.modificado;
    }
    
    public void setModificado(boolean modificado) {
        this.modificado = modificado;
    }




}


