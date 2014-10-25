package POJOS;
// Generated 25-oct-2014 9:20:16 by Hibernate Tools 3.6.0


import java.math.BigDecimal;

/**
 * VenMaeAnticipos generated by hbm2java
 */
public class VenMaeAnticipos  implements java.io.Serializable {


     private VenMaeAnticiposId id;
     private BigDecimal valAnt;

    public VenMaeAnticipos() {
    }

	
    public VenMaeAnticipos(VenMaeAnticiposId id) {
        this.id = id;
    }
    public VenMaeAnticipos(VenMaeAnticiposId id, BigDecimal valAnt) {
       this.id = id;
       this.valAnt = valAnt;
    }
   
    public VenMaeAnticiposId getId() {
        return this.id;
    }
    
    public void setId(VenMaeAnticiposId id) {
        this.id = id;
    }
    public BigDecimal getValAnt() {
        return this.valAnt;
    }
    
    public void setValAnt(BigDecimal valAnt) {
        this.valAnt = valAnt;
    }




}


