package POJOS;
// Generated 25-oct-2014 9:20:16 by Hibernate Tools 3.6.0



/**
 * AlmFamiliasId generated by hbm2java
 */
public class AlmFamiliasId  implements java.io.Serializable {


     private String codins;
     private String codbar;

    public AlmFamiliasId() {
    }

    public AlmFamiliasId(String codins, String codbar) {
       this.codins = codins;
       this.codbar = codbar;
    }
   
    public String getCodins() {
        return this.codins;
    }
    
    public void setCodins(String codins) {
        this.codins = codins;
    }
    public String getCodbar() {
        return this.codbar;
    }
    
    public void setCodbar(String codbar) {
        this.codbar = codbar;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof AlmFamiliasId) ) return false;
		 AlmFamiliasId castOther = ( AlmFamiliasId ) other; 
         
		 return ( (this.getCodins()==castOther.getCodins()) || ( this.getCodins()!=null && castOther.getCodins()!=null && this.getCodins().equals(castOther.getCodins()) ) )
 && ( (this.getCodbar()==castOther.getCodbar()) || ( this.getCodbar()!=null && castOther.getCodbar()!=null && this.getCodbar().equals(castOther.getCodbar()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getCodins() == null ? 0 : this.getCodins().hashCode() );
         result = 37 * result + ( getCodbar() == null ? 0 : this.getCodbar().hashCode() );
         return result;
   }   


}


