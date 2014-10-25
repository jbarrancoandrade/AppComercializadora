package POJOS;
// Generated 25-oct-2014 9:20:16 by Hibernate Tools 3.6.0



/**
 * NomTransxVarId generated by hbm2java
 */
public class NomTransxVarId  implements java.io.Serializable {


     private String codVar;
     private String codTran;

    public NomTransxVarId() {
    }

    public NomTransxVarId(String codVar, String codTran) {
       this.codVar = codVar;
       this.codTran = codTran;
    }
   
    public String getCodVar() {
        return this.codVar;
    }
    
    public void setCodVar(String codVar) {
        this.codVar = codVar;
    }
    public String getCodTran() {
        return this.codTran;
    }
    
    public void setCodTran(String codTran) {
        this.codTran = codTran;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof NomTransxVarId) ) return false;
		 NomTransxVarId castOther = ( NomTransxVarId ) other; 
         
		 return ( (this.getCodVar()==castOther.getCodVar()) || ( this.getCodVar()!=null && castOther.getCodVar()!=null && this.getCodVar().equals(castOther.getCodVar()) ) )
 && ( (this.getCodTran()==castOther.getCodTran()) || ( this.getCodTran()!=null && castOther.getCodTran()!=null && this.getCodTran().equals(castOther.getCodTran()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getCodVar() == null ? 0 : this.getCodVar().hashCode() );
         result = 37 * result + ( getCodTran() == null ? 0 : this.getCodTran().hashCode() );
         return result;
   }   


}


