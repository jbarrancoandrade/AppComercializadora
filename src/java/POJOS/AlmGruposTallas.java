package POJOS;
// Generated 25-oct-2014 9:20:16 by Hibernate Tools 3.6.0



/**
 * AlmGruposTallas generated by hbm2java
 */
public class AlmGruposTallas  implements java.io.Serializable {


     private String codGruT;
     private String nomGruT;
     private boolean modificado;

    public AlmGruposTallas() {
    }

    public AlmGruposTallas(String codGruT, String nomGruT, boolean modificado) {
       this.codGruT = codGruT;
       this.nomGruT = nomGruT;
       this.modificado = modificado;
    }
   
    public String getCodGruT() {
        return this.codGruT;
    }
    
    public void setCodGruT(String codGruT) {
        this.codGruT = codGruT;
    }
    public String getNomGruT() {
        return this.nomGruT;
    }
    
    public void setNomGruT(String nomGruT) {
        this.nomGruT = nomGruT;
    }
    public boolean isModificado() {
        return this.modificado;
    }
    
    public void setModificado(boolean modificado) {
        this.modificado = modificado;
    }




}


