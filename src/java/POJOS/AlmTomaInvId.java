package POJOS;
// Generated 25-oct-2014 9:20:16 by Hibernate Tools 3.6.0



/**
 * AlmTomaInvId generated by hbm2java
 */
public class AlmTomaInvId  implements java.io.Serializable {


     private String codToma;
     private String codalm;

    public AlmTomaInvId() {
    }

    public AlmTomaInvId(String codToma, String codalm) {
       this.codToma = codToma;
       this.codalm = codalm;
    }
   
    public String getCodToma() {
        return this.codToma;
    }
    
    public void setCodToma(String codToma) {
        this.codToma = codToma;
    }
    public String getCodalm() {
        return this.codalm;
    }
    
    public void setCodalm(String codalm) {
        this.codalm = codalm;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof AlmTomaInvId) ) return false;
		 AlmTomaInvId castOther = ( AlmTomaInvId ) other; 
         
		 return ( (this.getCodToma()==castOther.getCodToma()) || ( this.getCodToma()!=null && castOther.getCodToma()!=null && this.getCodToma().equals(castOther.getCodToma()) ) )
 && ( (this.getCodalm()==castOther.getCodalm()) || ( this.getCodalm()!=null && castOther.getCodalm()!=null && this.getCodalm().equals(castOther.getCodalm()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getCodToma() == null ? 0 : this.getCodToma().hashCode() );
         result = 37 * result + ( getCodalm() == null ? 0 : this.getCodalm().hashCode() );
         return result;
   }   


}


