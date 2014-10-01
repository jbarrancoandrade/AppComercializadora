package POJOS;
// Generated 19-sep-2014 10:35:39 by Hibernate Tools 3.6.0



/**
 * GenConsecAId generated by hbm2java
 */
public class GenConsecAId  implements java.io.Serializable {


     private String codalm;
     private String codcon;
     private int año;

    public GenConsecAId() {
    }

    public GenConsecAId(String codalm, String codcon, int año) {
       this.codalm = codalm;
       this.codcon = codcon;
       this.año = año;
    }
   
    public String getCodalm() {
        return this.codalm;
    }
    
    public void setCodalm(String codalm) {
        this.codalm = codalm;
    }
    public String getCodcon() {
        return this.codcon;
    }
    
    public void setCodcon(String codcon) {
        this.codcon = codcon;
    }
    public int getAño() {
        return this.año;
    }
    
    public void setAño(int año) {
        this.año = año;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof GenConsecAId) ) return false;
		 GenConsecAId castOther = ( GenConsecAId ) other; 
         
		 return ( (this.getCodalm()==castOther.getCodalm()) || ( this.getCodalm()!=null && castOther.getCodalm()!=null && this.getCodalm().equals(castOther.getCodalm()) ) )
 && ( (this.getCodcon()==castOther.getCodcon()) || ( this.getCodcon()!=null && castOther.getCodcon()!=null && this.getCodcon().equals(castOther.getCodcon()) ) )
 && (this.getAño()==castOther.getAño());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getCodalm() == null ? 0 : this.getCodalm().hashCode() );
         result = 37 * result + ( getCodcon() == null ? 0 : this.getCodcon().hashCode() );
         result = 37 * result + this.getAño();
         return result;
   }   


}

