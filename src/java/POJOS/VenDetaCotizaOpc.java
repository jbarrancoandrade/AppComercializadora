package POJOS;
// Generated 25-oct-2014 9:20:16 by Hibernate Tools 3.6.0


import java.math.BigDecimal;

/**
 * VenDetaCotizaOpc generated by hbm2java
 */
public class VenDetaCotizaOpc  implements java.io.Serializable {


     private VenDetaCotizaOpcId id;
     private long qtyIns;
     private BigDecimal valIns;
     private BigDecimal ivaIns;
     private BigDecimal dcto;

    public VenDetaCotizaOpc() {
    }

    public VenDetaCotizaOpc(VenDetaCotizaOpcId id, long qtyIns, BigDecimal valIns, BigDecimal ivaIns, BigDecimal dcto) {
       this.id = id;
       this.qtyIns = qtyIns;
       this.valIns = valIns;
       this.ivaIns = ivaIns;
       this.dcto = dcto;
    }
   
    public VenDetaCotizaOpcId getId() {
        return this.id;
    }
    
    public void setId(VenDetaCotizaOpcId id) {
        this.id = id;
    }
    public long getQtyIns() {
        return this.qtyIns;
    }
    
    public void setQtyIns(long qtyIns) {
        this.qtyIns = qtyIns;
    }
    public BigDecimal getValIns() {
        return this.valIns;
    }
    
    public void setValIns(BigDecimal valIns) {
        this.valIns = valIns;
    }
    public BigDecimal getIvaIns() {
        return this.ivaIns;
    }
    
    public void setIvaIns(BigDecimal ivaIns) {
        this.ivaIns = ivaIns;
    }
    public BigDecimal getDcto() {
        return this.dcto;
    }
    
    public void setDcto(BigDecimal dcto) {
        this.dcto = dcto;
    }




}


