package POJOS;
// Generated 25-oct-2014 9:20:16 by Hibernate Tools 3.6.0


import java.math.BigDecimal;

/**
 * VenRetxFac generated by hbm2java
 */
public class VenRetxFac  implements java.io.Serializable {


     private VenRetxFacId id;
     private BigDecimal base;
     private BigDecimal valRet;
     private String regPropiet;
     private BigDecimal margen;
     private boolean autoRet;

    public VenRetxFac() {
    }

    public VenRetxFac(VenRetxFacId id, BigDecimal base, BigDecimal valRet, String regPropiet, BigDecimal margen, boolean autoRet) {
       this.id = id;
       this.base = base;
       this.valRet = valRet;
       this.regPropiet = regPropiet;
       this.margen = margen;
       this.autoRet = autoRet;
    }
   
    public VenRetxFacId getId() {
        return this.id;
    }
    
    public void setId(VenRetxFacId id) {
        this.id = id;
    }
    public BigDecimal getBase() {
        return this.base;
    }
    
    public void setBase(BigDecimal base) {
        this.base = base;
    }
    public BigDecimal getValRet() {
        return this.valRet;
    }
    
    public void setValRet(BigDecimal valRet) {
        this.valRet = valRet;
    }
    public String getRegPropiet() {
        return this.regPropiet;
    }
    
    public void setRegPropiet(String regPropiet) {
        this.regPropiet = regPropiet;
    }
    public BigDecimal getMargen() {
        return this.margen;
    }
    
    public void setMargen(BigDecimal margen) {
        this.margen = margen;
    }
    public boolean isAutoRet() {
        return this.autoRet;
    }
    
    public void setAutoRet(boolean autoRet) {
        this.autoRet = autoRet;
    }




}


