package POJOS;
// Generated 19-sep-2014 10:35:39 by Hibernate Tools 3.6.0



/**
 * NomSecciones generated by hbm2java
 */
public class NomSecciones  implements java.io.Serializable {


     private String codSec;
     private String nomSec;
     private int periodoLiq;

    public NomSecciones() {
    }

    public NomSecciones(String codSec, String nomSec, int periodoLiq) {
       this.codSec = codSec;
       this.nomSec = nomSec;
       this.periodoLiq = periodoLiq;
    }
   
    public String getCodSec() {
        return this.codSec;
    }
    
    public void setCodSec(String codSec) {
        this.codSec = codSec;
    }
    public String getNomSec() {
        return this.nomSec;
    }
    
    public void setNomSec(String nomSec) {
        this.nomSec = nomSec;
    }
    public int getPeriodoLiq() {
        return this.periodoLiq;
    }
    
    public void setPeriodoLiq(int periodoLiq) {
        this.periodoLiq = periodoLiq;
    }




}

