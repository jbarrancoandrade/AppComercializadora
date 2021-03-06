package POJOS;
// Generated 25-oct-2014 9:20:16 by Hibernate Tools 3.6.0



/**
 * CxPObservaComId generated by hbm2java
 */
public class CxPObservaComId  implements java.io.Serializable {


     private String codAlm;
     private String numCom;

    public CxPObservaComId() {
    }

    public CxPObservaComId(String codAlm, String numCom) {
       this.codAlm = codAlm;
       this.numCom = numCom;
    }
   
    public String getCodAlm() {
        return this.codAlm;
    }
    
    public void setCodAlm(String codAlm) {
        this.codAlm = codAlm;
    }
    public String getNumCom() {
        return this.numCom;
    }
    
    public void setNumCom(String numCom) {
        this.numCom = numCom;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof CxPObservaComId) ) return false;
		 CxPObservaComId castOther = ( CxPObservaComId ) other; 
         
		 return ( (this.getCodAlm()==castOther.getCodAlm()) || ( this.getCodAlm()!=null && castOther.getCodAlm()!=null && this.getCodAlm().equals(castOther.getCodAlm()) ) )
 && ( (this.getNumCom()==castOther.getNumCom()) || ( this.getNumCom()!=null && castOther.getNumCom()!=null && this.getNumCom().equals(castOther.getNumCom()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getCodAlm() == null ? 0 : this.getCodAlm().hashCode() );
         result = 37 * result + ( getNumCom() == null ? 0 : this.getNumCom().hashCode() );
         return result;
   }   


}


