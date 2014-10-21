/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanView;

import Clases.Sentencias;
import Dao.Dao_Clientes;
import Dao.Dao_DetalCart;
import Dao.Dao_GenAlmacen;
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
import POJOS.VenDetaCart;
import POJOS.VenMaeCart;
import Util.HibernateUtil;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FlowEvent;
import org.primefaces.event.SelectEvent;

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
    private Dao_GenAlmacen dao_GenAlmacen;
    private boolean skip;

    private Session session;
    private Transaction transaccion;
    private Dao_Producctos dao_Producctos;
    private Dao_DetalCart dao_DetalCart;

    public HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
    public String Codalm = (String) httpSession.getAttribute("codalm");
    public String CodList = (String) httpSession.getAttribute("codList");
    public String codven = (String) httpSession.getAttribute("codven");
    private String consecutivocompleto;

    private Dao_MaeCart dao_MaeCart;
    private boolean Alerta;

    private VenMaeCart pedidoExistente;

    /**
     * Creates a new instance of MBClientes
     */
    public MBClientes() {
        clientepj = new VenClientes();
        pedidoExistente = new VenMaeCart();
        dao_Clientes = new Dao_Clientes();
        dao_vendedor = new Dao_vendedor();
        dao_DetalCart = new Dao_DetalCart();
        dao_GenAlmacen = new Dao_GenAlmacen();
        parametroBus = "";
        dao_MaeCart = new Dao_MaeCart();
        dao_Producctos = new Dao_Producctos();
        getAll();
        activeBotonAlerta();

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

    /**
     * Activar las alertas
     */
    public void activeBotonAlerta() {
        this.session = null;
        this.transaccion = null;

        try {

            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaccion = this.session.beginTransaction();
            //Alerta = true;
            //   Alerta = dao_DetalCart.existenPendientes(this.session, codven);
            Alerta = Alerta == false;

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

    public void chooseCar() {
        RequestContext.getCurrentInstance().openDialog("PenDiente");
    }

    public void onCarChosen(SelectEvent event) {
        VenDetaCart car = (VenDetaCart) event.getObject();
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Car Selected", "Id:" + car.getId());

        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void getAlmVenta(ActionEvent event) {
        
         this.session = null;
        this.transaccion = null;
        try {
             this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaccion = this.session.beginTransaction();
            ExternalContext ctx = FacesContext.getCurrentInstance().getExternalContext();
            String ctxPath = ((ServletContext) ctx.getContext()).getContextPath();

            //metodo que verifique si hay un pedido pendiente/
            System.out.println("entre aqui con la cedula :" + clientepj.getCedula() + "codVen" + codven);
            boolean c = dao_DetalCart.existePendientes(this.session, codven, clientepj.getCedula());
            System.out.println("caaasa" + c);
            if (c) {
                System.out.println("entre aqui dos");
                pedidoExistente = dao_DetalCart.Pendientes(this.session, codven, clientepj.getCedula());

                HttpSession httpSessions = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
                httpSessions.setAttribute("codalm", pedidoExistente.getId().getCodAlm());//nombre del almacen
                httpSessions.setAttribute("codList", pedidoExistente.getCodList());//nombre codigo lista
                httpSessions.setAttribute("numePedido", pedidoExistente.getId().getNumPed());//nombre pedido
                httpSessions.setAttribute("NombreVendedor", getNombreven(pedidoExistente.getCodVen()));// nombre del vendedor
                httpSessions.setAttribute("NombreCliente", getNombreCliente(pedidoExistente.getCodter()));// Nombre Del Cliente
                httpSessions.setAttribute("almacen", getAlm(pedidoExistente.getId().getCodAlm()));// Nombre Almacenes
                httpSessions.setAttribute("tipPed", pedidoExistente.getId().getTipPed());
                ctx.redirect(ctxPath + "/faces/CLientes/ListaProductos.xhtml");

            } else {
                HttpSession httpSessions = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
                httpSessions.setAttribute("NombreCliente", clientepj.getNombreCom());
                ctx.redirect(ctxPath + "/faces/CLientes/AlmPrecios.xhtml");
            }
          this.transaccion.commit();
        } catch (Exception e) {
            if (this.transaccion != null) {
                this.transaccion.rollback();
            }

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error fatal:", "Por favor contacte con su administrador " + e.getMessage()));
           
        } finally {
            if (this.session != null) {
                this.session.close();
            }

        }

    }

    public String getNombreven(String dato) {
        this.session = null;
        this.transaccion = null;

        try {

            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaccion = this.session.beginTransaction();
            String res = "";
            res = dao_vendedor.getByCodVen(this.session, dato);
            //codigoo
            this.transaccion.commit();
            return res;
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

    public String getNombreCliente(String dato) {
        this.session = null;
        this.transaccion = null;

        try {

            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaccion = this.session.beginTransaction();
            String res = "";
            res = dao_Clientes.ClienteId(this.session, dato);
            //codigoo
            this.transaccion.commit();
            return res;
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

    public String getAlm(String dato) {
        this.session = null;
        this.transaccion = null;

        try {

            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaccion = this.session.beginTransaction();
            String res = "";
            res = dao_GenAlmacen.NombreAlm(this.session, dato);
            //codigoo
            this.transaccion.commit();
            return res;
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

    public void getAlmPendientes(ActionEvent event) {
        try {
            FacesContext contex = FacesContext.getCurrentInstance();
            contex.getExternalContext().redirect("/AppComercializadora/faces/CLientes/Pendientes.xhtml");
            HttpSession httpSessions = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
            httpSessions.setAttribute("NombreCliente", clientepj.getNombreCom());
        } catch (IOException e) {
            addMessage("Error Fatal " + e.getMessage());
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
            listClientes = dao_Clientes.Buscar(this.session, codven, parametroBus);
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

    public Dao_DetalCart getDao_DetalCart() {
        return dao_DetalCart;
    }

    public void setDao_DetalCart(Dao_DetalCart dao_DetalCart) {
        this.dao_DetalCart = dao_DetalCart;
    }

    public Dao_MaeCart getDao_MaeCart() {
        return dao_MaeCart;
    }

    public void setDao_MaeCart(Dao_MaeCart dao_MaeCart) {
        this.dao_MaeCart = dao_MaeCart;
    }

    public boolean isAlerta() {
        return Alerta;
    }

    public void setAlerta(boolean Alerta) {
        this.Alerta = Alerta;
    }

    public VenMaeCart getPedidoExistente() {
        return pedidoExistente;
    }

    public void setPedidoExistente(VenMaeCart pedidoExistente) {
        this.pedidoExistente = pedidoExistente;
    }

    public Dao_GenAlmacen getDao_GenAlmacen() {
        return dao_GenAlmacen;
    }

    public void setDao_GenAlmacen(Dao_GenAlmacen dao_GenAlmacen) {
        this.dao_GenAlmacen = dao_GenAlmacen;
    }

}
