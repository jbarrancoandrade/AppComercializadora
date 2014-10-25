package POJOS;
// Generated 25-oct-2014 9:20:16 by Hibernate Tools 3.6.0



/**
 * TesChequerasId generated by hbm2java
 */
public class TesChequerasId  implements java.io.Serializable {


     private String codCta;
     private String codChq;

    public TesChequerasId() {
    }

    public TesChequerasId(String codCta, String codChq) {
       this.codCta = codCta;
       this.codChq = codChq;
    }
   
    public String getCodCta() {
        return this.codCta;
    }
    
    public void setCodCta(String codCta) {
        this.codCta = codCta;
    }
    public String getCodChq() {
        return this.codChq;
    }
    
    public void setCodChq(String codChq) {
        this.codChq = codChq;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof TesChequerasId) ) return false;
		 TesChequerasId castOther = ( TesChequerasId ) other; 
         
		 return ( (this.getCodCta()==castOther.getCodCta()) || ( this.getCodCta()!=null && castOther.getCodCta()!=null && this.getCodCta().equals(castOther.getCodCta()) ) )
 && ( (this.getCodChq()==castOther.getCodChq()) || ( this.getCodChq()!=null && castOther.getCodChq()!=null && this.getCodChq().equals(castOther.getCodChq()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getCodCta() == null ? 0 : this.getCodCta().hashCode() );
         result = 37 * result + ( getCodChq() == null ? 0 : this.getCodChq().hashCode() );
         return result;
   }   


}


