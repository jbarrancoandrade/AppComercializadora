package POJOS;
// Generated 25-oct-2014 9:20:16 by Hibernate Tools 3.6.0



/**
 * NomTersxTran generated by hbm2java
 */
public class NomTersxTran  implements java.io.Serializable {


     private NomTersxTranId id;
     private String idter;

    public NomTersxTran() {
    }

    public NomTersxTran(NomTersxTranId id, String idter) {
       this.id = id;
       this.idter = idter;
    }
   
    public NomTersxTranId getId() {
        return this.id;
    }
    
    public void setId(NomTersxTranId id) {
        this.id = id;
    }
    public String getIdter() {
        return this.idter;
    }
    
    public void setIdter(String idter) {
        this.idter = idter;
    }




}


