package POJOS;
// Generated 25-oct-2014 9:20:16 by Hibernate Tools 3.6.0



/**
 * AlmLineasxToma generated by hbm2java
 */
public class AlmLineasxToma  implements java.io.Serializable {


     private AlmLineasxTomaId id;
     private String codsub;

    public AlmLineasxToma() {
    }

    public AlmLineasxToma(AlmLineasxTomaId id, String codsub) {
       this.id = id;
       this.codsub = codsub;
    }
   
    public AlmLineasxTomaId getId() {
        return this.id;
    }
    
    public void setId(AlmLineasxTomaId id) {
        this.id = id;
    }
    public String getCodsub() {
        return this.codsub;
    }
    
    public void setCodsub(String codsub) {
        this.codsub = codsub;
    }




}


