package POJOS;
// Generated 25-oct-2014 9:20:16 by Hibernate Tools 3.6.0



/**
 * CfgConfigReports generated by hbm2java
 */
public class CfgConfigReports  implements java.io.Serializable {


     private CfgConfigReportsId id;
     private String reportName;
     private boolean modificado;
     private long qtyColSerial;

    public CfgConfigReports() {
    }

    public CfgConfigReports(CfgConfigReportsId id, String reportName, boolean modificado, long qtyColSerial) {
       this.id = id;
       this.reportName = reportName;
       this.modificado = modificado;
       this.qtyColSerial = qtyColSerial;
    }
   
    public CfgConfigReportsId getId() {
        return this.id;
    }
    
    public void setId(CfgConfigReportsId id) {
        this.id = id;
    }
    public String getReportName() {
        return this.reportName;
    }
    
    public void setReportName(String reportName) {
        this.reportName = reportName;
    }
    public boolean isModificado() {
        return this.modificado;
    }
    
    public void setModificado(boolean modificado) {
        this.modificado = modificado;
    }
    public long getQtyColSerial() {
        return this.qtyColSerial;
    }
    
    public void setQtyColSerial(long qtyColSerial) {
        this.qtyColSerial = qtyColSerial;
    }




}


