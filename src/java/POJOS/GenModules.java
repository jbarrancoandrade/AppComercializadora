package POJOS;
// Generated 25-oct-2014 9:20:16 by Hibernate Tools 3.6.0



/**
 * GenModules generated by hbm2java
 */
public class GenModules  implements java.io.Serializable {


     private String nomDll;
     private String pathDestino;
     private String pathDestinoBck;
     private String lastUpdate;

    public GenModules() {
    }

    public GenModules(String nomDll, String pathDestino, String pathDestinoBck, String lastUpdate) {
       this.nomDll = nomDll;
       this.pathDestino = pathDestino;
       this.pathDestinoBck = pathDestinoBck;
       this.lastUpdate = lastUpdate;
    }
   
    public String getNomDll() {
        return this.nomDll;
    }
    
    public void setNomDll(String nomDll) {
        this.nomDll = nomDll;
    }
    public String getPathDestino() {
        return this.pathDestino;
    }
    
    public void setPathDestino(String pathDestino) {
        this.pathDestino = pathDestino;
    }
    public String getPathDestinoBck() {
        return this.pathDestinoBck;
    }
    
    public void setPathDestinoBck(String pathDestinoBck) {
        this.pathDestinoBck = pathDestinoBck;
    }
    public String getLastUpdate() {
        return this.lastUpdate;
    }
    
    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }




}


