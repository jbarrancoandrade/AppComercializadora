package POJOS;
// Generated 25-oct-2014 9:20:16 by Hibernate Tools 3.6.0



/**
 * GenTrazaDocFromDoc generated by hbm2java
 */
public class GenTrazaDocFromDoc  implements java.io.Serializable {


     private GenTrazaDocFromDocId id;
     private String numDocNew;

    public GenTrazaDocFromDoc() {
    }

    public GenTrazaDocFromDoc(GenTrazaDocFromDocId id, String numDocNew) {
       this.id = id;
       this.numDocNew = numDocNew;
    }
   
    public GenTrazaDocFromDocId getId() {
        return this.id;
    }
    
    public void setId(GenTrazaDocFromDocId id) {
        this.id = id;
    }
    public String getNumDocNew() {
        return this.numDocNew;
    }
    
    public void setNumDocNew(String numDocNew) {
        this.numDocNew = numDocNew;
    }




}


