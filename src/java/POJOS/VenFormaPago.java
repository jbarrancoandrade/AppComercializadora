package POJOS;
// Generated 25-oct-2014 9:20:16 by Hibernate Tools 3.6.0



/**
 * VenFormaPago generated by hbm2java
 */
public class VenFormaPago  implements java.io.Serializable {


     private String codfor;
     private String nomfor;
     private String abrevia;
     private Boolean documento;
     private int prioridad;
     private String codCue;

    public VenFormaPago() {
    }

	
    public VenFormaPago(String codfor, int prioridad, String codCue) {
        this.codfor = codfor;
        this.prioridad = prioridad;
        this.codCue = codCue;
    }
    public VenFormaPago(String codfor, String nomfor, String abrevia, Boolean documento, int prioridad, String codCue) {
       this.codfor = codfor;
       this.nomfor = nomfor;
       this.abrevia = abrevia;
       this.documento = documento;
       this.prioridad = prioridad;
       this.codCue = codCue;
    }
   
    public String getCodfor() {
        return this.codfor;
    }
    
    public void setCodfor(String codfor) {
        this.codfor = codfor;
    }
    public String getNomfor() {
        return this.nomfor;
    }
    
    public void setNomfor(String nomfor) {
        this.nomfor = nomfor;
    }
    public String getAbrevia() {
        return this.abrevia;
    }
    
    public void setAbrevia(String abrevia) {
        this.abrevia = abrevia;
    }
    public Boolean getDocumento() {
        return this.documento;
    }
    
    public void setDocumento(Boolean documento) {
        this.documento = documento;
    }
    public int getPrioridad() {
        return this.prioridad;
    }
    
    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }
    public String getCodCue() {
        return this.codCue;
    }
    
    public void setCodCue(String codCue) {
        this.codCue = codCue;
    }




}


