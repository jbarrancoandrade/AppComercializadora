package POJOS;
// Generated 19-sep-2014 10:35:39 by Hibernate Tools 3.6.0


import java.util.Date;

/**
 * NomHistorialProvisionesId generated by hbm2java
 */
public class NomHistorialProvisionesId  implements java.io.Serializable {


     private String codEmp;
     private Date FCierre;

    public NomHistorialProvisionesId() {
    }

    public NomHistorialProvisionesId(String codEmp, Date FCierre) {
       this.codEmp = codEmp;
       this.FCierre = FCierre;
    }
   
    public String getCodEmp() {
        return this.codEmp;
    }
    
    public void setCodEmp(String codEmp) {
        this.codEmp = codEmp;
    }
    public Date getFCierre() {
        return this.FCierre;
    }
    
    public void setFCierre(Date FCierre) {
        this.FCierre = FCierre;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof NomHistorialProvisionesId) ) return false;
		 NomHistorialProvisionesId castOther = ( NomHistorialProvisionesId ) other; 
         
		 return ( (this.getCodEmp()==castOther.getCodEmp()) || ( this.getCodEmp()!=null && castOther.getCodEmp()!=null && this.getCodEmp().equals(castOther.getCodEmp()) ) )
 && ( (this.getFCierre()==castOther.getFCierre()) || ( this.getFCierre()!=null && castOther.getFCierre()!=null && this.getFCierre().equals(castOther.getFCierre()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getCodEmp() == null ? 0 : this.getCodEmp().hashCode() );
         result = 37 * result + ( getFCierre() == null ? 0 : this.getFCierre().hashCode() );
         return result;
   }   


}

