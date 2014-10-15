/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanView;

import Dao.Dao_Clientes;
import Dao.Dao_DetalCart;
import Dao.Dao_GenAlmacen;
import Dao.Dao_MaeCart;
import Dao.Dao_vendedor;
import POJOS.VenClientes;
import POJOS.VenDetaCart;
import POJOS.VenMaeCart;
import Util.HibernateUtil;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIData;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.primefaces.component.datascroller.DataScroller;

/**
 *
 * @author Jhonbarranco
 */
@ManagedBean
@ViewScoped
public class MBeanMaeCart implements Serializable {

    private VenMaeCart venMaeCart;
    private Dao_MaeCart dao_MaeCart;
    private VenDetaCart venDetaCart;
    private Dao_DetalCart  dao_DetalCart;
    private List<VenMaeCart> listMaetCar;
    private Dao_vendedor dao_vendedor;
    private Dao_Clientes dao_Clientes;
    private Dao_GenAlmacen dao_GenAlmacen;
    private DataScroller dat;
    private Session session;
    private Transaction transaccion;

    /**
     * Creates a new instance of MBeanMaeCart
     */
    public MBeanMaeCart() {
        dao_MaeCart = new Dao_MaeCart();
        dao_vendedor = new Dao_vendedor();
        dao_Clientes = new Dao_Clientes();
        dao_GenAlmacen = new Dao_GenAlmacen();
        dao_DetalCart = new Dao_DetalCart();
        dat = new DataScroller();

    }

    /**
     * todas los pedidos
     *
     * @return
     */
    public List<VenMaeCart> getAll() {
        this.session = null;
        this.transaccion = null;

        try {

            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaccion = this.session.beginTransaction();

            HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
            String codven = (String) httpSession.getAttribute("codven");

            this.listMaetCar = dao_MaeCart.Listar(this.session);

            this.transaccion.commit();

            return this.listMaetCar;
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

    
     public List<VenMaeCart> getAll2() {
        this.session = null;
        this.transaccion = null;

        try {

            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaccion = this.session.beginTransaction();

            HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
            String codven = (String) httpSession.getAttribute("codven");

            this.listMaetCar = dao_MaeCart.Listar2(this.session);

            this.transaccion.commit();

            return this.listMaetCar;
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
     * Nombre del cliente
     *
     * @param id
     * @return
     */
    public String nombreCliente(String id) {
        this.session = null;
        this.transaccion = null;

        try {

            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaccion = this.session.beginTransaction();

            String razon = dao_MaeCart.ClienteNombre(this.session, id);

            this.transaccion.commit();

            return razon;
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
     * Metodo que retorna el numero o los numeros que el cliente tiene
     *
     * @param id
     * @return
     */
    public String telefono(String id) {

        this.session = null;
        this.transaccion = null;

        try {

            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaccion = this.session.beginTransaction();

            String razon = dao_MaeCart.ClienteTelfono(this.session, id);

            this.transaccion.commit();

            return razon;
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
     * Metodo que revisa si tiene dirreccion un pedido y si tiene la imprime
     *
     * @param id
     * @return
     */
    public String dirrecion(String id) {
        this.session = null;
        this.transaccion = null;

        try {

            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaccion = this.session.beginTransaction();

            String razon = dao_MaeCart.ClienteDireccion(this.session, id);

            this.transaccion.commit();

            return razon;
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
     * Metodo para comvertir la fecha de sistema en fecha mas entendible ejemplo
     * Entra 26/09 / 2014 - debe retornar 26 de septiembre 2014
     *
     * @param numer
     * @return
     */
    public String fecha(String numer) {

        this.session = null;
        this.transaccion = null;

        try {

            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaccion = this.session.beginTransaction();

            SimpleDateFormat formateador = new SimpleDateFormat(
                    "dd 'de' MMMM 'de' yyyy", new Locale("es_ES"));
            Date fechaDate = dao_MaeCart.fechaVenta(this.session, numer);
            String fecha = formateador.format(fechaDate);

            this.transaccion.commit();

            return fecha;
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
     * Metodo que Recibe directamente de la vista El objeto
     *
     * @param d
     */
    public void datos(VenMaeCart d) {

        HttpSession httpSessions = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        httpSessions.setAttribute("codalm", d.getId().getCodAlm());//nombre del almacen
        httpSessions.setAttribute("codList", d.getCodList());//nombre codigo lista
        httpSessions.setAttribute("numePedido", d.getId().getNumPed());//nombre pedido
        httpSessions.setAttribute("NombreVendedor", getNombreven(d.getCodVen()));// nombre del vendedor
        httpSessions.setAttribute("NombreCliente", getNombreCliente(d.getCodter()));// Nombre Del Cliente
        httpSessions.setAttribute("almacen", getAlm(d.getId().getCodAlm()));// Nombre Almacenes
        httpSessions.setAttribute("tipPed", d.getId().getTipPed());
        System.out.println(d.getId().getCodAlm()+"\n"+d.getCodList()+"\n"+d.getId().getNumPed()+"\n"+getNombreven(d.getCodVen())+"\n"+getNombreCliente(d.getCodter())+"\n"+d.getId().getTipPed());
    }

    //obtener vendedor
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

    ///datos
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

    /**
     *
     * @param dato
     * @return
     */
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

    /**
     * Medoto que se encargar de redirigir a la pantalla de edicion de producto
     *
     * @param event
     */
    public void getEditar(ActionEvent event) {
        try {
            FacesContext contex = FacesContext.getCurrentInstance();
            contex.getExternalContext().redirect("/AppComercializadora/faces/CLientes/ListaProductos.xhtml");

        } catch (IOException e) {
            addMessage("Error Redirreccion " + e.getMessage());
        }

    }

    /**
     *
     * @param event
     */
    public void getElimininar(ActionEvent event) {
        //
        this.session = null;
        this.transaccion = null;

        try {

            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaccion = this.session.beginTransaction();
            HttpSession httpSessions = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
            String codalm = (String) httpSessions.getAttribute("codalm");
            String pedido = (String) httpSessions.getAttribute("numePedido");
            dao_MaeCart.Eliminar(this.session, codalm, pedido, "_PV");
            dao_DetalCart.Eliminar(this.session, codalm, pedido,"_PV", "");
            
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

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public Dao_MaeCart getDao_MaeCart() {
        return dao_MaeCart;
    }

    public void setDao_MaeCart(Dao_MaeCart dao_MaeCart) {
        this.dao_MaeCart = dao_MaeCart;
    }

    public List<VenMaeCart> getListMaetCar() {
        return listMaetCar;
    }

    public void setListMaetCar(List<VenMaeCart> listMaetCar) {
        this.listMaetCar = listMaetCar;
    }

    public VenMaeCart getVenMaeCart() {
        return venMaeCart;
    }

    public void setVenMaeCart(VenMaeCart venMaeCart) {
        this.venMaeCart = venMaeCart;
    }

    public Dao_vendedor getDao_vendedor() {
        return dao_vendedor;
    }

    public void setDao_vendedor(Dao_vendedor dao_vendedor) {
        this.dao_vendedor = dao_vendedor;
    }

    public Dao_Clientes getDao_Clientes() {
        return dao_Clientes;
    }

    public void setDao_Clientes(Dao_Clientes dao_Clientes) {
        this.dao_Clientes = dao_Clientes;
    }

    public Dao_GenAlmacen getDao_GenAlmacen() {
        return dao_GenAlmacen;
    }

    public void setDao_GenAlmacen(Dao_GenAlmacen dao_GenAlmacen) {
        this.dao_GenAlmacen = dao_GenAlmacen;
    }

    public DataScroller getDat() {
        return dat;
    }

    public void setDat(DataScroller dat) {
        this.dat = dat;
    }

    public VenDetaCart getVenDetaCart() {
        return venDetaCart;
    }

    public void setVenDetaCart(VenDetaCart venDetaCart) {
        this.venDetaCart = venDetaCart;
    }

    public Dao_DetalCart getDao_DetalCart() {
        return dao_DetalCart;
    }

    public void setDao_DetalCart(Dao_DetalCart dao_DetalCart) {
        this.dao_DetalCart = dao_DetalCart;
    }
    
    

}
