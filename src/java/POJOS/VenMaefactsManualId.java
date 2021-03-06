package POJOS;
// Generated 25-oct-2014 9:20:16 by Hibernate Tools 3.6.0



/**
 * VenMaefactsManualId generated by hbm2java
 */
public class VenMaefactsManualId  implements java.io.Serializable {


     private String codAlm;
     private String numdoc;

    public VenMaefactsManualId() {
    }

    public VenMaefactsManualId(String codAlm, String numdoc) {
       this.codAlm = codAlm;
       this.numdoc = numdoc;
    }
   
    public String getCodAlm() {
        return this.codAlm;
    }
    
    public void setCodAlm(String codAlm) {
        this.codAlm = codAlm;
    }
    public String getNumdoc() {
        return this.numdoc;
    }
    
    public void setNumdoc(String numdoc) {
        this.numdoc = numdoc;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof VenMaefactsManualId) ) return false;
		 VenMaefactsManualId castOther = ( VenMaefactsManualId ) other; 
         
		 return ( (this.getCodAlm()==castOther.getCodAlm()) || ( this.getCodAlm()!=null && castOther.getCodAlm()!=null && this.getCodAlm().equals(castOther.getCodAlm()) ) )
 && ( (this.getNumdoc()==castOther.getNumdoc()) || ( this.getNumdoc()!=null && castOther.getNumdoc()!=null && this.getNumdoc().equals(castOther.getNumdoc()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getCodAlm() == null ? 0 : this.getCodAlm().hashCode() );
         result = 37 * result + ( getNumdoc() == null ? 0 : this.getNumdoc().hashCode() );
         return result;
   }   


}


