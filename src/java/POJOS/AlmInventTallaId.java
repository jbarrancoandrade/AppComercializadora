package POJOS;
// Generated 25-oct-2014 9:20:16 by Hibernate Tools 3.6.0



/**
 * AlmInventTallaId generated by hbm2java
 */
public class AlmInventTallaId  implements java.io.Serializable {


     private String codAlm;
     private String codIns;
     private String codTalla;

    public AlmInventTallaId() {
    }

    public AlmInventTallaId(String codAlm, String codIns, String codTalla) {
       this.codAlm = codAlm;
       this.codIns = codIns;
       this.codTalla = codTalla;
    }
   
    public String getCodAlm() {
        return this.codAlm;
    }
    
    public void setCodAlm(String codAlm) {
        this.codAlm = codAlm;
    }
    public String getCodIns() {
        return this.codIns;
    }
    
    public void setCodIns(String codIns) {
        this.codIns = codIns;
    }
    public String getCodTalla() {
        return this.codTalla;
    }
    
    public void setCodTalla(String codTalla) {
        this.codTalla = codTalla;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof AlmInventTallaId) ) return false;
		 AlmInventTallaId castOther = ( AlmInventTallaId ) other; 
         
		 return ( (this.getCodAlm()==castOther.getCodAlm()) || ( this.getCodAlm()!=null && castOther.getCodAlm()!=null && this.getCodAlm().equals(castOther.getCodAlm()) ) )
 && ( (this.getCodIns()==castOther.getCodIns()) || ( this.getCodIns()!=null && castOther.getCodIns()!=null && this.getCodIns().equals(castOther.getCodIns()) ) )
 && ( (this.getCodTalla()==castOther.getCodTalla()) || ( this.getCodTalla()!=null && castOther.getCodTalla()!=null && this.getCodTalla().equals(castOther.getCodTalla()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getCodAlm() == null ? 0 : this.getCodAlm().hashCode() );
         result = 37 * result + ( getCodIns() == null ? 0 : this.getCodIns().hashCode() );
         result = 37 * result + ( getCodTalla() == null ? 0 : this.getCodTalla().hashCode() );
         return result;
   }   


}


