/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanView;

import Clases.Sentencias;
import Dao.Dao_Clientes;
import Dao.Dao_MaeCart;
import Dao.Dao_Producctos;
import Dao.Dao_vendedor;
import POJOS.GenConsecA;
import POJOS.GenConsecAId;
import POJOS.GenConsecM;
import POJOS.GenConsecMId;
import POJOS.GenConsecS;
import POJOS.GenConsecSId;
import POJOS.VenClientes;
import Util.HibernateUtil;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.primefaces.event.FlowEvent;

/**
 *
 * @author Jhonbarranco
 */
@ManagedBean
@ViewScoped
public class MBClientes implements Serializable {

    private VenClientes clientepj;
    private List<VenClientes> listClientes;
    private Dao_Clientes dao_Clientes;
    private Dao_vendedor dao_vendedor;
    private List<VenClientes> listfitrado;
    private String parametroBus;

    private String clienteEsj;

    private boolean skip;

    private Session session;
    private Transaction transaccion;
    private Dao_Producctos dao_Producctos;

    public HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
    public String Codalm = (String) httpSession.getAttribute("codalm");
    public String CodList = (String) httpSession.getAttribute("codList");
    public String codven = (String) httpSession.getAttribute("codven");
    private  String consecutivocompleto;
    
    private  Dao_MaeCart dao_MaeCart;

    /**
     * Creates a new instance of MBClientes
     */
    public MBClientes() {
        clientepj = new VenClientes();
        dao_Clientes = new Dao_Clientes();
        dao_vendedor = new Dao_vendedor();
        parametroBus = "";
        dao_MaeCart = new Dao_MaeCart();
        dao_Producctos = new Dao_Producctos();
        getAll();
       
    }

    public List<VenClientes> getAll() {
        this.session = null;
        this.transaccion = null;

        try {

            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaccion = this.session.beginTransaction();

      

            this.listClientes = dao_Clientes.getId(this.session, codven);

            this.transaccion.commit();
          
            return this.listClientes;
        } catch (Exception ex) {
            if (this.transaccion != null) {
                this.transaccion.rollback();
            }

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error fatal:", "Por favor contacte con su administrador " + ex.getMessage()));

            return null;
        } finally {
            if (this.session != null) {
                this.session.close();
            }
        }
    }

    public void getAlmVenta(ActionEvent event) {
        try {
            FacesContext contex = FacesContext.getCurrentInstance();
            contex.getExternalContext().redirect("/AppComercializadora/faces/CLientes/AlmPrecios.xhtml");
            HttpSession httpSessions = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
            httpSessions.setAttribute("NombreCliente", clientepj.getNombreCom());
        } catch (IOException e) {
            addMessage("Error Fatal "+ e.getMessage());
        }

    }



    /**
     * BUsqueda de clientes
     *
     * @param event
     */
    public void Filter(ActionEvent event) {
        this.session = null;
        this.transaccion = null;

        try {

            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaccion = this.session.beginTransaction();

            parametroBus = parametroBus.replace("", "%");
            listClientes = dao_Clientes.Buscar(this.session, parametroBus);
            this.transaccion.commit();

        } catch (Exception ex) {
            if (this.transaccion != null) {
                this.transaccion.rollback();
            }

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error fatal:", "Por favor contacte con su administrador " + ex.getMessage()));

        } finally {
            if (this.session != null) {
                this.session.close();
            }
        }
    }

    public List<VenClientes> getListClientes() {
        return listClientes;
    }

    public void setListClientes(List<VenClientes> listClientes) {
        this.listClientes = listClientes;
    }

    public String getClienteEsj() {
        return clienteEsj;
    }

    public void setClienteEsj(String clienteEsj) {
        this.clienteEsj = clienteEsj;
    }

    public List<VenClientes> getListfitrado() {
        return listfitrado;
    }

    public void setListfitrado(List<VenClientes> listfitrado) {
        this.listfitrado = listfitrado;
    }

    public VenClientes getClientepj() {
        return clientepj;
    }

    public void setClientepj(VenClientes clientepj) {
        this.clientepj = clientepj;
    }

    public Dao_Clientes getDao_Clientes() {
        return dao_Clientes;
    }

    public void setDao_Clientes(Dao_Clientes dao_Clientes) {
        this.dao_Clientes = dao_Clientes;
    }

    public Dao_vendedor getDao_vendedor() {
        return dao_vendedor;
    }

    public void setDao_vendedor(Dao_vendedor dao_vendedor) {
        this.dao_vendedor = dao_vendedor;
    }

    public boolean isSkip() {
        return skip;
    }

    public void setSkip(boolean skip) {
        this.skip = skip;
    }

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_FATAL, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public String getParametroBus() {
        return parametroBus;
    }

    public void setParametroBus(String parametroBus) {
        this.parametroBus = parametroBus;
    }

    public Dao_Producctos getDao_Producctos() {
        return dao_Producctos;
    }

    public void setDao_Producctos(Dao_Producctos dao_Producctos) {
        this.dao_Producctos = dao_Producctos;
    }

    public String getConsecutivocompleto() {
        return consecutivocompleto;
    }

    public void setConsecutivocompleto(String consecutivocompleto) {
        this.consecutivocompleto = consecutivocompleto;
    }
    
    

}
