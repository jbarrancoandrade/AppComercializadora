package POJOS;
// Generated 25-oct-2014 9:20:16 by Hibernate Tools 3.6.0



/**
 * VenMaeCotizaOpcId generated by hbm2java
 */
public class VenMaeCotizaOpcId  implements java.io.Serializable {


     private String codalm;
     private String numcot;
     private String codopc;

    public VenMaeCotizaOpcId() {
    }

    public VenMaeCotizaOpcId(String codalm, String numcot, String codopc) {
       this.codalm = codalm;
       this.numcot = numcot;
       this.codopc = codopc;
    }
   
    public String getCodalm() {
        return this.codalm;
    }
    
    public void setCodalm(String codalm) {
        this.codalm = codalm;
    }
    public String getNumcot() {
        return this.numcot;
    }
    
    public void setNumcot(String numcot) {
        this.numcot = numcot;
    }
    public String getCodopc() {
        return this.codopc;
    }
    
    public void setCodopc(String codopc) {
        this.codopc = codopc;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof VenMaeCotizaOpcId) ) return false;
		 VenMaeCotizaOpcId castOther = ( VenMaeCotizaOpcId ) other; 
         
		 return ( (this.getCodalm()==castOther.getCodalm()) || ( this.getCodalm()!=null && castOther.getCodalm()!=null && this.getCodalm().equals(castOther.getCodalm()) ) )
 && ( (this.getNumcot()==castOther.getNumcot()) || ( this.getNumcot()!=null && castOther.getNumcot()!=null && this.getNumcot().equals(castOther.getNumcot()) ) )
 && ( (this.getCodopc()==castOther.getCodopc()) || ( this.getCodopc()!=null && castOther.getCodopc()!=null && this.getCodopc().equals(castOther.getCodopc()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getCodalm() == null ? 0 : this.getCodalm().hashCode() );
         result = 37 * result + ( getNumcot() == null ? 0 : this.getNumcot().hashCode() );
         result = 37 * result + ( getCodopc() == null ? 0 : this.getCodopc().hashCode() );
         return result;
   }   


}


