package POJOS;
// Generated 25-oct-2014 9:20:16 by Hibernate Tools 3.6.0



/**
 * NomPeriodosId generated by hbm2java
 */
public class NomPeriodosId  implements java.io.Serializable {


     private String codSec;
     private int año;
     private int mes;
     private int PIni;
     private int PFin;

    public NomPeriodosId() {
    }

    public NomPeriodosId(String codSec, int año, int mes, int PIni, int PFin) {
       this.codSec = codSec;
       this.año = año;
       this.mes = mes;
       this.PIni = PIni;
       this.PFin = PFin;
    }
   
    public String getCodSec() {
        return this.codSec;
    }
    
    public void setCodSec(String codSec) {
        this.codSec = codSec;
    }
    public int getAño() {
        return this.año;
    }
    
    public void setAño(int año) {
        this.año = año;
    }
    public int getMes() {
        return this.mes;
    }
    
    public void setMes(int mes) {
        this.mes = mes;
    }
    public int getPIni() {
        return this.PIni;
    }
    
    public void setPIni(int PIni) {
        this.PIni = PIni;
    }
    public int getPFin() {
        return this.PFin;
    }
    
    public void setPFin(int PFin) {
        this.PFin = PFin;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof NomPeriodosId) ) return false;
		 NomPeriodosId castOther = ( NomPeriodosId ) other; 
         
		 return ( (this.getCodSec()==castOther.getCodSec()) || ( this.getCodSec()!=null && castOther.getCodSec()!=null && this.getCodSec().equals(castOther.getCodSec()) ) )
 && (this.getAño()==castOther.getAño())
 && (this.getMes()==castOther.getMes())
 && (this.getPIni()==castOther.getPIni())
 && (this.getPFin()==castOther.getPFin());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getCodSec() == null ? 0 : this.getCodSec().hashCode() );
         result = 37 * result + this.getAño();
         result = 37 * result + this.getMes();
         result = 37 * result + this.getPIni();
         result = 37 * result + this.getPFin();
         return result;
   }   


}


