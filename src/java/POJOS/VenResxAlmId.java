package POJOS;
// Generated 25-oct-2014 9:20:16 by Hibernate Tools 3.6.0



/**
 * VenResxAlmId generated by hbm2java
 */
public class VenResxAlmId  implements java.io.Serializable {


     private String codalm;
     private String codres;

    public VenResxAlmId() {
    }

    public VenResxAlmId(String codalm, String codres) {
       this.codalm = codalm;
       this.codres = codres;
    }
   
    public String getCodalm() {
        return this.codalm;
    }
    
    public void setCodalm(String codalm) {
        this.codalm = codalm;
    }
    public String getCodres() {
        return this.codres;
    }
    
    public void setCodres(String codres) {
        this.codres = codres;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof VenResxAlmId) ) return false;
		 VenResxAlmId castOther = ( VenResxAlmId ) other; 
         
		 return ( (this.getCodalm()==castOther.getCodalm()) || ( this.getCodalm()!=null && castOther.getCodalm()!=null && this.getCodalm().equals(castOther.getCodalm()) ) )
 && ( (this.getCodres()==castOther.getCodres()) || ( this.getCodres()!=null && castOther.getCodres()!=null && this.getCodres().equals(castOther.getCodres()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getCodalm() == null ? 0 : this.getCodalm().hashCode() );
         result = 37 * result + ( getCodres() == null ? 0 : this.getCodres().hashCode() );
         return result;
   }   


}


