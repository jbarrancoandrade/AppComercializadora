package POJOS;
// Generated 25-oct-2014 9:20:16 by Hibernate Tools 3.6.0


import java.math.BigDecimal;

/**
 * CxPDetaPedProv generated by hbm2java
 */
public class CxPDetaPedProv  implements java.io.Serializable {


     private CxPDetaPedProvId id;
     private BigDecimal qtyPed;

    public CxPDetaPedProv() {
    }

    public CxPDetaPedProv(CxPDetaPedProvId id, BigDecimal qtyPed) {
       this.id = id;
       this.qtyPed = qtyPed;
    }
   
    public CxPDetaPedProvId getId() {
        return this.id;
    }
    
    public void setId(CxPDetaPedProvId id) {
        this.id = id;
    }
    public BigDecimal getQtyPed() {
        return this.qtyPed;
    }
    
    public void setQtyPed(BigDecimal qtyPed) {
        this.qtyPed = qtyPed;
    }




}


