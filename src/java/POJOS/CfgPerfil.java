package POJOS;
// Generated 25-oct-2014 9:20:16 by Hibernate Tools 3.6.0



/**
 * CfgPerfil generated by hbm2java
 */
public class CfgPerfil  implements java.io.Serializable {


     private String codper;
     private String nomper;

    public CfgPerfil() {
    }

    public CfgPerfil(String codper, String nomper) {
       this.codper = codper;
       this.nomper = nomper;
    }
   
    public String getCodper() {
        return this.codper;
    }
    
    public void setCodper(String codper) {
        this.codper = codper;
    }
    public String getNomper() {
        return this.nomper;
    }
    
    public void setNomper(String nomper) {
        this.nomper = nomper;
    }




}


