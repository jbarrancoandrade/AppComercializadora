package POJOS;
// Generated 25-oct-2014 9:20:16 by Hibernate Tools 3.6.0



/**
 * CntMmdetaSchemas generated by hbm2java
 */
public class CntMmdetaSchemas  implements java.io.Serializable {


     private CntMmdetaSchemasId id;
     private int orden;

    public CntMmdetaSchemas() {
    }

    public CntMmdetaSchemas(CntMmdetaSchemasId id, int orden) {
       this.id = id;
       this.orden = orden;
    }
   
    public CntMmdetaSchemasId getId() {
        return this.id;
    }
    
    public void setId(CntMmdetaSchemasId id) {
        this.id = id;
    }
    public int getOrden() {
        return this.orden;
    }
    
    public void setOrden(int orden) {
        this.orden = orden;
    }




}


