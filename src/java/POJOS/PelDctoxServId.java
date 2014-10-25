package POJOS;
// Generated 25-oct-2014 9:20:16 by Hibernate Tools 3.6.0



/**
 * PelDctoxServId generated by hbm2java
 */
public class PelDctoxServId  implements java.io.Serializable {


     private String codAlm;
     private String codIns;

    public PelDctoxServId() {
    }

    public PelDctoxServId(String codAlm, String codIns) {
       this.codAlm = codAlm;
       this.codIns = codIns;
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


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof PelDctoxServId) ) return false;
		 PelDctoxServId castOther = ( PelDctoxServId ) other; 
         
		 return ( (this.getCodAlm()==castOther.getCodAlm()) || ( this.getCodAlm()!=null && castOther.getCodAlm()!=null && this.getCodAlm().equals(castOther.getCodAlm()) ) )
 && ( (this.getCodIns()==castOther.getCodIns()) || ( this.getCodIns()!=null && castOther.getCodIns()!=null && this.getCodIns().equals(castOther.getCodIns()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getCodAlm() == null ? 0 : this.getCodAlm().hashCode() );
         result = 37 * result + ( getCodIns() == null ? 0 : this.getCodIns().hashCode() );
         return result;
   }   


}


