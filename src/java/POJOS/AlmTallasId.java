package POJOS;
// Generated 25-oct-2014 9:20:16 by Hibernate Tools 3.6.0



/**
 * AlmTallasId generated by hbm2java
 */
public class AlmTallasId  implements java.io.Serializable {


     private String codGruT;
     private String codTalla;

    public AlmTallasId() {
    }

    public AlmTallasId(String codGruT, String codTalla) {
       this.codGruT = codGruT;
       this.codTalla = codTalla;
    }
   
    public String getCodGruT() {
        return this.codGruT;
    }
    
    public void setCodGruT(String codGruT) {
        this.codGruT = codGruT;
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
		 if ( !(other instanceof AlmTallasId) ) return false;
		 AlmTallasId castOther = ( AlmTallasId ) other; 
         
		 return ( (this.getCodGruT()==castOther.getCodGruT()) || ( this.getCodGruT()!=null && castOther.getCodGruT()!=null && this.getCodGruT().equals(castOther.getCodGruT()) ) )
 && ( (this.getCodTalla()==castOther.getCodTalla()) || ( this.getCodTalla()!=null && castOther.getCodTalla()!=null && this.getCodTalla().equals(castOther.getCodTalla()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getCodGruT() == null ? 0 : this.getCodGruT().hashCode() );
         result = 37 * result + ( getCodTalla() == null ? 0 : this.getCodTalla().hashCode() );
         return result;
   }   


}


