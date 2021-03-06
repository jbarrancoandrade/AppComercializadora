package POJOS;
// Generated 25-oct-2014 9:20:16 by Hibernate Tools 3.6.0



/**
 * VenMovAmarresId generated by hbm2java
 */
public class VenMovAmarresId  implements java.io.Serializable {


     private String codAlm;
     private String tipDoc;
     private String numDoc;
     private String codres;
     private String codInsBase;
     private String codIns;

    public VenMovAmarresId() {
    }

    public VenMovAmarresId(String codAlm, String tipDoc, String numDoc, String codres, String codInsBase, String codIns) {
       this.codAlm = codAlm;
       this.tipDoc = tipDoc;
       this.numDoc = numDoc;
       this.codres = codres;
       this.codInsBase = codInsBase;
       this.codIns = codIns;
    }
   
    public String getCodAlm() {
        return this.codAlm;
    }
    
    public void setCodAlm(String codAlm) {
        this.codAlm = codAlm;
    }
    public String getTipDoc() {
        return this.tipDoc;
    }
    
    public void setTipDoc(String tipDoc) {
        this.tipDoc = tipDoc;
    }
    public String getNumDoc() {
        return this.numDoc;
    }
    
    public void setNumDoc(String numDoc) {
        this.numDoc = numDoc;
    }
    public String getCodres() {
        return this.codres;
    }
    
    public void setCodres(String codres) {
        this.codres = codres;
    }
    public String getCodInsBase() {
        return this.codInsBase;
    }
    
    public void setCodInsBase(String codInsBase) {
        this.codInsBase = codInsBase;
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
		 if ( !(other instanceof VenMovAmarresId) ) return false;
		 VenMovAmarresId castOther = ( VenMovAmarresId ) other; 
         
		 return ( (this.getCodAlm()==castOther.getCodAlm()) || ( this.getCodAlm()!=null && castOther.getCodAlm()!=null && this.getCodAlm().equals(castOther.getCodAlm()) ) )
 && ( (this.getTipDoc()==castOther.getTipDoc()) || ( this.getTipDoc()!=null && castOther.getTipDoc()!=null && this.getTipDoc().equals(castOther.getTipDoc()) ) )
 && ( (this.getNumDoc()==castOther.getNumDoc()) || ( this.getNumDoc()!=null && castOther.getNumDoc()!=null && this.getNumDoc().equals(castOther.getNumDoc()) ) )
 && ( (this.getCodres()==castOther.getCodres()) || ( this.getCodres()!=null && castOther.getCodres()!=null && this.getCodres().equals(castOther.getCodres()) ) )
 && ( (this.getCodInsBase()==castOther.getCodInsBase()) || ( this.getCodInsBase()!=null && castOther.getCodInsBase()!=null && this.getCodInsBase().equals(castOther.getCodInsBase()) ) )
 && ( (this.getCodIns()==castOther.getCodIns()) || ( this.getCodIns()!=null && castOther.getCodIns()!=null && this.getCodIns().equals(castOther.getCodIns()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getCodAlm() == null ? 0 : this.getCodAlm().hashCode() );
         result = 37 * result + ( getTipDoc() == null ? 0 : this.getTipDoc().hashCode() );
         result = 37 * result + ( getNumDoc() == null ? 0 : this.getNumDoc().hashCode() );
         result = 37 * result + ( getCodres() == null ? 0 : this.getCodres().hashCode() );
         result = 37 * result + ( getCodInsBase() == null ? 0 : this.getCodInsBase().hashCode() );
         result = 37 * result + ( getCodIns() == null ? 0 : this.getCodIns().hashCode() );
         return result;
   }   


}


