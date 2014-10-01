package POJOS;
// Generated 19-sep-2014 10:35:39 by Hibernate Tools 3.6.0



/**
 * AlmLineasxTomaId generated by hbm2java
 */
public class AlmLineasxTomaId  implements java.io.Serializable {


     private String codalm;
     private String codToma;
     private String codLinea;

    public AlmLineasxTomaId() {
    }

    public AlmLineasxTomaId(String codalm, String codToma, String codLinea) {
       this.codalm = codalm;
       this.codToma = codToma;
       this.codLinea = codLinea;
    }
   
    public String getCodalm() {
        return this.codalm;
    }
    
    public void setCodalm(String codalm) {
        this.codalm = codalm;
    }
    public String getCodToma() {
        return this.codToma;
    }
    
    public void setCodToma(String codToma) {
        this.codToma = codToma;
    }
    public String getCodLinea() {
        return this.codLinea;
    }
    
    public void setCodLinea(String codLinea) {
        this.codLinea = codLinea;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof AlmLineasxTomaId) ) return false;
		 AlmLineasxTomaId castOther = ( AlmLineasxTomaId ) other; 
         
		 return ( (this.getCodalm()==castOther.getCodalm()) || ( this.getCodalm()!=null && castOther.getCodalm()!=null && this.getCodalm().equals(castOther.getCodalm()) ) )
 && ( (this.getCodToma()==castOther.getCodToma()) || ( this.getCodToma()!=null && castOther.getCodToma()!=null && this.getCodToma().equals(castOther.getCodToma()) ) )
 && ( (this.getCodLinea()==castOther.getCodLinea()) || ( this.getCodLinea()!=null && castOther.getCodLinea()!=null && this.getCodLinea().equals(castOther.getCodLinea()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getCodalm() == null ? 0 : this.getCodalm().hashCode() );
         result = 37 * result + ( getCodToma() == null ? 0 : this.getCodToma().hashCode() );
         result = 37 * result + ( getCodLinea() == null ? 0 : this.getCodLinea().hashCode() );
         return result;
   }   


}

