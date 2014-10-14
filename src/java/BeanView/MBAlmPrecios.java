/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanView;

import Clases.Sentencias;
import Dao.Dao_DetalCart;
import Dao.Dao_GenAlmacen;
import Dao.Dao_MaeCart;
import Dao.Dao_Producctos;
import POJOS.GenAlmacenes;
import POJOS.GenConsecA;
import POJOS.GenConsecAId;
import POJOS.GenConsecM;
import POJOS.GenConsecMId;
import POJOS.GenConsecS;
import POJOS.GenConsecSId;
import POJOS.VenListaPrecios;
import Util.HibernateUtil;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Jhonbarranco
 */
@ManagedBean
@ViewScoped
public class MBAlmPrecios implements Serializable {

    //  private GenAlmacenes genAlmacenes;
    private VenListaPrecios venListaPrecios;
    private Dao_GenAlmacen dao_GenAlmacen;

    private List<GenAlmacenes> listAlmacen;
    private List<VenListaPrecios> listPrecio;
    private List<VenListaPrecios> listVacia;
    private boolean btnDisable;

    private String almE;
    private String precE;

    private Session session;
    private Transaction transaccion;
    private Dao_Producctos dao_Producctos;
    private Dao_DetalCart  dao_DetalCart;
    private String consecutivocompleto;
    private Dao_MaeCart  dao_MaeCart;
    
      
    /**
     * 
     * Creates a new instance of MBAlmPrecios
     */
    public MBAlmPrecios() {
        dao_GenAlmacen = new Dao_GenAlmacen();
        dao_Producctos = new  Dao_Producctos();
        dao_DetalCart  = new Dao_DetalCart();
        dao_MaeCart = new Dao_MaeCart();
        //   genAlmacenes = new GenAlmacenes();
        venListaPrecios = new VenListaPrecios();
        btnDisable = true;
        
        getAll();
    }

    /**
     * Retorna todo los almacenes en una listAlmacen
     *
     * @return
     */
    public List<GenAlmacenes> getAll() {
        this.session = null;
        this.transaccion = null;

        try {
            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaccion = this.session.beginTransaction();

            this.listAlmacen = dao_GenAlmacen.getAll(this.session);

            this.transaccion.commit();

            return this.listAlmacen;
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
     * Apartir del codigo almacen llena una lista con los respectivos precios
     *
     * @param codalm
     * @return
     */
    public List<VenListaPrecios> getPrecios(String codalm) {

        this.session = null;
        this.transaccion = null;

        try {
            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaccion = this.session.beginTransaction();

            if ("".equals(codalm)) {
                return this.listPrecio;
            } else {
                this.listPrecio = dao_GenAlmacen.getAlmacen(this.session, codalm);

                this.transaccion.commit();
                 HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
                 httpSession.setAttribute("almacen", dao_GenAlmacen.NombreAlm(this.session, almE));
                return this.listPrecio;
            }

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
     * @return 
     */
    public String VizualiSarConsecutivo() {
        this.session = null;
        this.transaccion = null;

        try {
            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaccion = this.session.beginTransaction();
            int año = 2014;//int) httpSession.getAttribute("año");//falta
            int mes = 1;//(int) httpSession.getAttribute("mes");//falta
            String idProcess = "PEDIDO_VENTAS";//(String) httpSession.getAttribute("idProcess");//falta
            String codcon = "";
            codcon = dao_Producctos.idProseso(this.session, idProcess);

            char tipoCon = ' ';
            String añorSimple = (año + "").replace("0", "");//EJEMPLO AÑO 2014,  DEVUELVE 214
            String consec = "";
            int consecutivoTabl = 0;
            int ConseFinal = 0;
            HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
            String Codalm =(String) httpSession.getAttribute("codalm");

            tipoCon = dao_Producctos.getTipoConsecutivo(this.session, codcon);
            if (tipoCon == 'A') {
                try {
                    
                    //Codalm 
                    consecutivoTabl = dao_Producctos.getConsecutivoA(this.session, Codalm, codcon, año);
        
                } catch (Exception e) {
                    dao_Producctos.createConsecA(this.session, new GenConsecA(new GenConsecAId(Codalm, codcon, año), 0));
                }

                consec = Sentencias.npadl((consecutivoTabl + 1), 5, '0');

            } else if (tipoCon == 'M') {
                try {
                    consecutivoTabl = dao_Producctos.getConsecutivoM(this.session, Codalm, codcon, año, mes);
                    dao_Producctos.updateConsecM(this.session, new GenConsecM(new GenConsecMId(Codalm, codcon, año, mes), consecutivoTabl));
                } catch (Exception e) {
                    dao_Producctos.createConsecM(this.session, new GenConsecM(new GenConsecMId(Codalm, codcon, año, mes), 0));
                }

                consec = Sentencias.npadl((consecutivoTabl + 1), 5, '0');

            } else if (tipoCon == 'S') {
                try {
                    consecutivoTabl = dao_Producctos.getConsecutivoS(this.session, codcon);
                    dao_Producctos.updateConsecS(this.session, new GenConsecS(new GenConsecSId(Codalm, codcon), consecutivoTabl));
                } catch (Exception e) {
                    dao_Producctos.createConsecS(this.session, new GenConsecS(new GenConsecSId(Codalm, codcon), 0));

                }

                consec = Sentencias.npadl((consecutivoTabl + 1), 5, '0');

            }

            this.consecutivocompleto = añorSimple + consec;
            String intermedio = "";

            if (dao_MaeCart.getConsecutivoMae(this.session, consecutivocompleto)) {

                int a = dao_Producctos.updateConsecA(this.session, codcon, año, consecutivoTabl + 1, Codalm);
                if (tipoCon == 'A') {
                    try {
                        consecutivoTabl = dao_Producctos.getConsecutivoA(this.session, Codalm, codcon, año);
                       } catch (Exception e) {
                        dao_Producctos.createConsecA(this.session, new GenConsecA(new GenConsecAId(Codalm, codcon, año), 0));
                      }

                    consec = Sentencias.npadl((consecutivoTabl + 1), 5, '0');
                  
                }

                this.consecutivocompleto = añorSimple + consec;
               
            }

            //consultar 
            //
            this.transaccion.commit();

            return consecutivocompleto;

        } catch (Exception ex) {

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error fatal:", "Por favor contacte con su administrador " + ex.getMessage()));

            return null;
        }
    }

    /**
     *
     * @param event
     */
    public void onChange(ActionEvent event) {
        if (almE == null || almE.equals("")) {
            listPrecio = listVacia;
            btnDisable = true;
        } else {
            btnDisable = true;
            listPrecio = getPrecios(almE);
            HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
            httpSession.setAttribute("codalm", almE);
            httpSession.setAttribute("numePedido",  VizualiSarConsecutivo());
           
           

        }
    }

    /**
     *
     * @param event
     */
    public void onChangePrecio(ActionEvent event) {
        btnDisable = precE == null || precE.equals("");
        if(precE!=null){
            HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
            httpSession.setAttribute("codList", precE);
        }
    }

    /**
     * Para redirrir peticion
     *
     * @param event
     */
    public void getProduc(ActionEvent event) {
        try {
            FacesContext contex = FacesContext.getCurrentInstance();
            contex.getExternalContext().redirect("/AppComercializadora/faces/CLientes/ListaProductos.xhtml");
        } catch (Exception e) {
            addMessage("Error !!");
        }

    }

    /**
     * 
     * @param event 
     */
    public void getAtras(ActionEvent event) {
        try {
            FacesContext contex = FacesContext.getCurrentInstance();
            contex.getExternalContext().redirect("/AppComercializadora/faces/CLientes/ListaClientes.xhtml");
        } catch (Exception e) {
            addMessage("Error !!");
        }

    }
    /**
     * 
     * @param event 
     */
    public void getInicio(ActionEvent event) {
        try {
            FacesContext contex = FacesContext.getCurrentInstance();
            contex.getExternalContext().redirect("/AppComercializadora/faces/Menu/Principal.xhtml");
        } catch (Exception e) {
            addMessage("Error !!");
        }

    }

    /**
     * 
     * @param summary 
     */
    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    //getter and setter
    public VenListaPrecios getVenListaPrecios() {
        return venListaPrecios;
    }

    public void setVenListaPrecios(VenListaPrecios venListaPrecios) {
        this.venListaPrecios = venListaPrecios;
    }

    public Dao_GenAlmacen getDao_GenAlmacen() {
        return dao_GenAlmacen;
    }

    public void setDao_GenAlmacen(Dao_GenAlmacen dao_GenAlmacen) {
        this.dao_GenAlmacen = dao_GenAlmacen;
    }

    public List<GenAlmacenes> getListAlmacen() {
        return listAlmacen;
    }

    public void setListAlmacen(List<GenAlmacenes> listAlmacen) {
        this.listAlmacen = listAlmacen;
    }

    public List<VenListaPrecios> getListPrecio() {
        return listPrecio;
    }

    public void setListPrecio(List<VenListaPrecios> listPrecio) {
        this.listPrecio = listPrecio;
    }

    public String getAlmE() {
        return almE;
    }

    public void setAlmE(String almE) {
        this.almE = almE;
    }

    public String getPrecE() {
        return precE;
    }

    public void setPrecE(String precE) {
        this.precE = precE;
    }

    public boolean isBtnDisable() {
        return btnDisable;
    }

    public void setBtnDisable(boolean btnDisable) {
        this.btnDisable = btnDisable;
    }

    public List<VenListaPrecios> getListVacia() {
        return listVacia;
    }

    public void setListVacia(List<VenListaPrecios> listVacia) {
        this.listVacia = listVacia;
    }

}
