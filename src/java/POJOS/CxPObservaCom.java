package POJOS;
// Generated 25-oct-2014 9:20:16 by Hibernate Tools 3.6.0



/**
 * CxPObservaCom generated by hbm2java
 */
public class CxPObservaCom  implements java.io.Serializable {


     private CxPObservaComId id;
     private String observa;

    public CxPObservaCom() {
    }

    public CxPObservaCom(CxPObservaComId id, String observa) {
       this.id = id;
       this.observa = observa;
    }
   
    public CxPObservaComId getId() {
        return this.id;
    }
    
    public void setId(CxPObservaComId id) {
        this.id = id;
    }
    public String getObserva() {
        return this.observa;
    }
    
    public void setObserva(String observa) {
        this.observa = observa;
    }




}


