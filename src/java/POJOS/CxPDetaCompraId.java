package POJOS;
// Generated 25-oct-2014 9:20:16 by Hibernate Tools 3.6.0



/**
 * CxPDetaCompraId generated by hbm2java
 */
public class CxPDetaCompraId  implements java.io.Serializable {


     private String codalm;
     private String numcom;
     private String codins;
     private String codtalla;

    public CxPDetaCompraId() {
    }

    public CxPDetaCompraId(String codalm, String numcom, String codins, String codtalla) {
       this.codalm = codalm;
       this.numcom = numcom;
       this.codins = codins;
       this.codtalla = codtalla;
    }
   
    public String getCodalm() {
        return this.codalm;
    }
    
    public void setCodalm(String codalm) {
        this.codalm = codalm;
    }
    public String getNumcom() {
        return this.numcom;
    }
    
    public void setNumcom(String numcom) {
        this.numcom = numcom;
    }
    public String getCodins() {
        return this.codins;
    }
    
    public void setCodins(String codins) {
        this.codins = codins;
    }
    public String getCodtalla() {
        return this.codtalla;
    }
    
    public void setCodtalla(String codtalla) {
        this.codtalla = codtalla;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof CxPDetaCompraId) ) return false;
		 CxPDetaCompraId castOther = ( CxPDetaCompraId ) other; 
         
		 return ( (this.getCodalm()==castOther.getCodalm()) || ( this.getCodalm()!=null && castOther.getCodalm()!=null && this.getCodalm().equals(castOther.getCodalm()) ) )
 && ( (this.getNumcom()==castOther.getNumcom()) || ( this.getNumcom()!=null && castOther.getNumcom()!=null && this.getNumcom().equals(castOther.getNumcom()) ) )
 && ( (this.getCodins()==castOther.getCodins()) || ( this.getCodins()!=null && castOther.getCodins()!=null && this.getCodins().equals(castOther.getCodins()) ) )
 && ( (this.getCodtalla()==castOther.getCodtalla()) || ( this.getCodtalla()!=null && castOther.getCodtalla()!=null && this.getCodtalla().equals(castOther.getCodtalla()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getCodalm() == null ? 0 : this.getCodalm().hashCode() );
         result = 37 * result + ( getNumcom() == null ? 0 : this.getNumcom().hashCode() );
         result = 37 * result + ( getCodins() == null ? 0 : this.getCodins().hashCode() );
         result = 37 * result + ( getCodtalla() == null ? 0 : this.getCodtalla().hashCode() );
         return result;
   }   


}


