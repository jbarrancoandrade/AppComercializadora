package POJOS;
// Generated 25-oct-2014 9:20:16 by Hibernate Tools 3.6.0



/**
 * AlmLineas generated by hbm2java
 */
public class AlmLineas  implements java.io.Serializable {


     private AlmLineasId id;
     private String nomlinea;
     private boolean modificado;
     private String codgrutdef;

    public AlmLineas() {
    }

	
    public AlmLineas(AlmLineasId id, boolean modificado, String codgrutdef) {
        this.id = id;
        this.modificado = modificado;
        this.codgrutdef = codgrutdef;
    }
    public AlmLineas(AlmLineasId id, String nomlinea, boolean modificado, String codgrutdef) {
       this.id = id;
       this.nomlinea = nomlinea;
       this.modificado = modificado;
       this.codgrutdef = codgrutdef;
    }
   
    public AlmLineasId getId() {
        return this.id;
    }
    
    public void setId(AlmLineasId id) {
        this.id = id;
    }
    public String getNomlinea() {
        return this.nomlinea;
    }
    
    public void setNomlinea(String nomlinea) {
        this.nomlinea = nomlinea;
    }
    public boolean isModificado() {
        return this.modificado;
    }
    
    public void setModificado(boolean modificado) {
        this.modificado = modificado;
    }
    public String getCodgrutdef() {
        return this.codgrutdef;
    }
    
    public void setCodgrutdef(String codgrutdef) {
        this.codgrutdef = codgrutdef;
    }




}


