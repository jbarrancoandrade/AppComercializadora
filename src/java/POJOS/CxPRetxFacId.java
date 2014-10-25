package POJOS;
// Generated 25-oct-2014 9:20:16 by Hibernate Tools 3.6.0



/**
 * CxPRetxFacId generated by hbm2java
 */
public class CxPRetxFacId  implements java.io.Serializable {


     private String codAlm;
     private String numFac;
     private String tipFac;
     private String numRad;
     private String codRet;

    public CxPRetxFacId() {
    }

    public CxPRetxFacId(String codAlm, String numFac, String tipFac, String numRad, String codRet) {
       this.codAlm = codAlm;
       this.numFac = numFac;
       this.tipFac = tipFac;
       this.numRad = numRad;
       this.codRet = codRet;
    }
   
    public String getCodAlm() {
        return this.codAlm;
    }
    
    public void setCodAlm(String codAlm) {
        this.codAlm = codAlm;
    }
    public String getNumFac() {
        return this.numFac;
    }
    
    public void setNumFac(String numFac) {
        this.numFac = numFac;
    }
    public String getTipFac() {
        return this.tipFac;
    }
    
    public void setTipFac(String tipFac) {
        this.tipFac = tipFac;
    }
    public String getNumRad() {
        return this.numRad;
    }
    
    public void setNumRad(String numRad) {
        this.numRad = numRad;
    }
    public String getCodRet() {
        return this.codRet;
    }
    
    public void setCodRet(String codRet) {
        this.codRet = codRet;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof CxPRetxFacId) ) return false;
		 CxPRetxFacId castOther = ( CxPRetxFacId ) other; 
         
		 return ( (this.getCodAlm()==castOther.getCodAlm()) || ( this.getCodAlm()!=null && castOther.getCodAlm()!=null && this.getCodAlm().equals(castOther.getCodAlm()) ) )
 && ( (this.getNumFac()==castOther.getNumFac()) || ( this.getNumFac()!=null && castOther.getNumFac()!=null && this.getNumFac().equals(castOther.getNumFac()) ) )
 && ( (this.getTipFac()==castOther.getTipFac()) || ( this.getTipFac()!=null && castOther.getTipFac()!=null && this.getTipFac().equals(castOther.getTipFac()) ) )
 && ( (this.getNumRad()==castOther.getNumRad()) || ( this.getNumRad()!=null && castOther.getNumRad()!=null && this.getNumRad().equals(castOther.getNumRad()) ) )
 && ( (this.getCodRet()==castOther.getCodRet()) || ( this.getCodRet()!=null && castOther.getCodRet()!=null && this.getCodRet().equals(castOther.getCodRet()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getCodAlm() == null ? 0 : this.getCodAlm().hashCode() );
         result = 37 * result + ( getNumFac() == null ? 0 : this.getNumFac().hashCode() );
         result = 37 * result + ( getTipFac() == null ? 0 : this.getTipFac().hashCode() );
         result = 37 * result + ( getNumRad() == null ? 0 : this.getNumRad().hashCode() );
         result = 37 * result + ( getCodRet() == null ? 0 : this.getCodRet().hashCode() );
         return result;
   }   


}


