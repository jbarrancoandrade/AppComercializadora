package POJOS;
// Generated 25-oct-2014 9:20:16 by Hibernate Tools 3.6.0



/**
 * VenVendxAlmId generated by hbm2java
 */
public class VenVendxAlmId  implements java.io.Serializable {


     private String codalm;
     private String codven;

    public VenVendxAlmId() {
    }

    public VenVendxAlmId(String codalm, String codven) {
       this.codalm = codalm;
       this.codven = codven;
    }
   
    public String getCodalm() {
        return this.codalm;
    }
    
    public void setCodalm(String codalm) {
        this.codalm = codalm;
    }
    public String getCodven() {
        return this.codven;
    }
    
    public void setCodven(String codven) {
        this.codven = codven;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof VenVendxAlmId) ) return false;
		 VenVendxAlmId castOther = ( VenVendxAlmId ) other; 
         
		 return ( (this.getCodalm()==castOther.getCodalm()) || ( this.getCodalm()!=null && castOther.getCodalm()!=null && this.getCodalm().equals(castOther.getCodalm()) ) )
 && ( (this.getCodven()==castOther.getCodven()) || ( this.getCodven()!=null && castOther.getCodven()!=null && this.getCodven().equals(castOther.getCodven()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getCodalm() == null ? 0 : this.getCodalm().hashCode() );
         result = 37 * result + ( getCodven() == null ? 0 : this.getCodven().hashCode() );
         return result;
   }   


}


