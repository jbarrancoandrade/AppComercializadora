package POJOS;
// Generated 25-oct-2014 9:20:16 by Hibernate Tools 3.6.0


import java.math.BigDecimal;

/**
 * AlmComVenxProd generated by hbm2java
 */
public class AlmComVenxProd  implements java.io.Serializable {


     private String codIns;
     private BigDecimal porEmp;
     private BigDecimal porTrab;
     private String codVen;
     private BigDecimal valTrab;

    public AlmComVenxProd() {
    }

    public AlmComVenxProd(String codIns, BigDecimal porEmp, BigDecimal porTrab, String codVen, BigDecimal valTrab) {
       this.codIns = codIns;
       this.porEmp = porEmp;
       this.porTrab = porTrab;
       this.codVen = codVen;
       this.valTrab = valTrab;
    }
   
    public String getCodIns() {
        return this.codIns;
    }
    
    public void setCodIns(String codIns) {
        this.codIns = codIns;
    }
    public BigDecimal getPorEmp() {
        return this.porEmp;
    }
    
    public void setPorEmp(BigDecimal porEmp) {
        this.porEmp = porEmp;
    }
    public BigDecimal getPorTrab() {
        return this.porTrab;
    }
    
    public void setPorTrab(BigDecimal porTrab) {
        this.porTrab = porTrab;
    }
    public String getCodVen() {
        return this.codVen;
    }
    
    public void setCodVen(String codVen) {
        this.codVen = codVen;
    }
    public BigDecimal getValTrab() {
        return this.valTrab;
    }
    
    public void setValTrab(BigDecimal valTrab) {
        this.valTrab = valTrab;
    }




}


