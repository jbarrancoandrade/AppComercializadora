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
import Dao.Dao_Lineas;
import Dao.Dao_MaeCart;
import Dao.Dao_Producctos;
import POJOS.AlmInsumos;
import POJOS.AlmInvent;
import POJOS.AlmLineas;
import POJOS.AlmSubLineas;
import POJOS.GenAlmacenes;
import POJOS.GenConsecA;
import POJOS.GenConsecAId;
import POJOS.GenConsecM;
import POJOS.GenConsecMId;
import POJOS.GenConsecS;
import POJOS.GenConsecSId;
import POJOS.VenDetaCart;
import POJOS.VenDetaCartId;
import POJOS.VenDetaPrecios;
import POJOS.VenMaeCart;
import POJOS.VenMaeCartId;
import RePojos.Productos;
import Util.HibernateUtil;
import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.primefaces.context.RequestContext;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.FlowEvent;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author Jhonbarranco
 */
@ManagedBean
@ViewScoped
public class MBCatProductos implements Serializable {

    private AlmInsumos almInsumos;
    private AlmInsumos select;
    private VenDetaCart sel;
    private AlmLineas almLineas;
    private AlmSubLineas almSubLineas;

    private List<Productos> tempoProduc;
    private Productos produc;

    private List<AlmLineas> listaCate;
    private List<AlmInvent> listInven;

    private List<AlmSubLineas> listaSubCat;

    private List<AlmInsumos> listInsumos;
    private List<AlmInsumos> listInsumos2;

    private Dao_Producctos dao_Producctos;
    private String parametroBus;
    private Dao_Lineas dao_Lineas;

    private Session session;
    private Transaction transaccion;

    private String CatE;
    private String SubCatE;
    private Date fechaVenta;
    private boolean BtnCart;
    private List<VenDetaPrecios> productosprecios;
    private List<VenDetaCart> ListdetaCarts;
    private List<VenDetaCart> ListdetaCarts2;
    public List<VenMaeCart> ListMaeCart;
    private Dao_MaeCart dao_MaeCart;
    private Dao_DetalCart dao_DetalCart;
    private Dao_Clientes dao_Clientes;
    private VenDetaCart venDetaCart;
    private String Cliente, vendedor, almacen;
    private String comprados = "0";
    private String minimo, maximo = "";

    //variables para la vista en cuanto a calculos
    private String ParcialLinea;//muestra el valor del producto en la tabla carrito
    private String subtotalDefinitivo; //muestra subtotal
    private String DescuentoTotal; // muestra descuento total
    private String IvaValorFinal; //muestra el iva Total
    private String baseTotal; // muestra el valor base Total
    private String TotalVenta; //muestra el total de una venta
    private List<GenAlmacenes> listAlm;
    private Dao_GenAlmacen dao_GenAlmacen;
    //finvariables

    public HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
    public String Codalm = (String) httpSession.getAttribute("codalm");
    public String CodList = (String) httpSession.getAttribute("codList");
    public String codven = (String) httpSession.getAttribute("codven");
    public String consecutivocompleto = (String) httpSession.getAttribute("numePedido");

    /**
     * Creates a new instance of MBCatProductos
     */
    public MBCatProductos() {
        dao_Clientes = new Dao_Clientes();
        almInsumos = new AlmInsumos();
        almLineas = new AlmLineas();
        almSubLineas = new AlmSubLineas();
        dao_DetalCart = new Dao_DetalCart();
        dao_MaeCart = new Dao_MaeCart();
        produc = new Productos();
        dao_Lineas = new Dao_Lineas();
        dao_Producctos = new Dao_Producctos();
        dao_GenAlmacen = new Dao_GenAlmacen();
        sel = new VenDetaCart();
        BtnCart = true;
        this.ListdetaCarts2 = new ArrayList<>();
        this.ListMaeCart = new ArrayList<>();
        this.tempoProduc = new ArrayList<>();
        vendedor = (String) httpSession.getAttribute("NombreVendedor");
        Cliente = (String) httpSession.getAttribute("NombreCliente");
        almacen = (String) httpSession.getAttribute("almacen");
        fechaVenta = new Date();
        parametroBus = "";
        getCategorias();
        getProductos("", "");
      //  Calculos(new BigDecimal(16.0), new BigDecimal(100000.00), new BigDecimal(10.00), new BigDecimal("1"), true, false);

    }

    /**
     * Metodo que devuelve una lista con los productos dependiendo categorias o
     * subcategorias en caso de no haber categoria seleccionada este listara
     * todos los productos en existencias
     *
     * @param cat
     * @param subcat
     * @return
     */
    public List<AlmInsumos> getProductos(String cat, String subcat) {
        this.session = null;
        this.transaccion = null;

        try {
            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaccion = this.session.beginTransaction();

            if ("".equals(cat) && "".equals(subcat)) {
                this.listInsumos = dao_Producctos.getAll(this.session);

            } else if (!"".equals(cat) && "".equals(subcat)) {
                this.listInsumos = dao_Producctos.getLinea(this.session, cat);
            } else {
                this.listInsumos = dao_Producctos.getsubLinea(this.session, cat, subcat);
            }

            this.transaccion.commit();

            return this.listInsumos;
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
     * @param val
     * @return
     */
    public BigDecimal convertirBig(String val) {
        BigDecimal a;
        a = new BigDecimal(val);
        return a;
    }

    /**
     * Metodo que devulve una lista con todas las categorias existentes para
     * proceder al filtrado
     *
     * @return
     */
    public List<AlmLineas> getCategorias() {
        this.session = null;
        this.transaccion = null;

        try {
            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaccion = this.session.beginTransaction();

            this.listaCate = dao_Lineas.getLinea(this.session);

            this.transaccion.commit();

            return this.listaCate;
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
     * Metodo que devuelve todas las subcategorias dependientes de una categoria
     *
     * @param cat
     * @return
     */
    public List<AlmSubLineas> getSucategoria(String cat) {
        this.session = null;
        this.transaccion = null;

        try {
            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaccion = this.session.beginTransaction();

            this.listaSubCat = dao_Lineas.getSublinea(this.session, cat);

            this.transaccion.commit();

            return this.listaSubCat;
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
     * Metodo que llena el la lista de subcategorias y ademas unos productos
     * apartir de la categoria que cambio
     *
     * @param event
     */
    public void onChangeCategorias(ActionEvent event) {
        if (CatE == null || CatE.equals("")) {
            listaSubCat = getSucategoria("");
            listInsumos = getProductos("", "");

        } else {

            listaSubCat = getSucategoria(CatE);
            listInsumos = getProductos(CatE, "");

        }

    }

    /**
     * Metodo que llena los productos de acuerdo a una subcategoria
     *
     * @param event
     */
    public void onChangeSubCategorias(ActionEvent event) {

        if (SubCatE != null || !"".equals(SubCatE)) {

            listInsumos = getProductos(CatE, SubCatE);

        }
    }

    /**
     * De acuerdo al codigo de insumos devuelve el precio real con su formato
     * para la vista
     *
     * @param codins
     * @return
     */
    public String Precios(String codins) {
        this.session = null;
        this.transaccion = null;

        try {
            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaccion = this.session.beginTransaction();

            String a = "";
            a = dao_Producctos.precios(this.session, codins, Codalm, CodList);
            double amount = Double.parseDouble(a);
            //metodo que le da formato a un precio
            DecimalFormat formatter = new DecimalFormat("#,###.00");
            String pre = "";
            pre = formatter.format(amount);

            this.transaccion.commit();

            return pre;

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

    public String Precios2(String codins) {
        this.session = null;
        this.transaccion = null;

        try {
            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaccion = this.session.beginTransaction();

            String a = "";
            a = dao_Producctos.precios(this.session, codins, Codalm, CodList);

            this.transaccion.commit();

            return a;

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

    public BigDecimal Descuentos(String codins) {
        this.session = null;
        this.transaccion = null;

        try {
            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaccion = this.session.beginTransaction();

            BigDecimal a = dao_Producctos.Cantidad(this.session, codins);

            this.transaccion.commit();

            return a;

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
     * Devuelve cantidades en inventarios
     *
     * @param codins
     * @return
     */
    public String Inventarios(String codins) {
        this.session = null;
        this.transaccion = null;

        try {
            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaccion = this.session.beginTransaction();

            String Inventar = "";
            //  System.out.println(codins);

            Inventar = dao_Producctos.getCantInven(this.session, codins, Codalm);

            this.transaccion.commit();

            return Inventar;

        } catch (Exception ex) {

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error fatal:", "Por favor contacte con su administrador " + ex.getMessage()));

            return null;
        }

    }
    
    /**
     * 
     * @param codins
     * @return 
     */
    public String Comprometidas(String codins) {
        this.session = null;
        this.transaccion = null;

        try {
            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaccion = this.session.beginTransaction();

         //for que recorra las comprometidas
            
            
            this.transaccion.commit();

            return "";

        } catch (Exception ex) {

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error fatal:", "Por favor contacte con su administrador " + ex.getMessage()));

            return null;
        }

    }

    /**
     *
     * @param codins
     */
    public String CantidadesMaximas() {
        maximo = Inventarios(almInsumos.getCodins());

        Double x = Double.parseDouble(maximo);
        if (x > 0) {
            return "1";

        } else {
            return "0";
        }
    }

    /**
     *
     * @param codins
     */
    public String Precioview() {
        return Precios(almInsumos.getCodins());
    }

    /**
     *
     * @return
     */
    public String IVaView() {
        return Iva(almInsumos.getCodins());
    }

    /**
     *
     * @return
     */
    public String Dsc() {
        return "0";
    }

    public String margenIvaf(String codins) {

        this.session = null;
        this.transaccion = null;

        try {
            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaccion = this.session.beginTransaction();

            String a = "";
            a = dao_Producctos.margendescuento(this.session, codins, Codalm, CodList);
            System.out.println(a);
            this.transaccion.commit();

            return a;

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

    public void onRowEdit(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Producto Editado");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Cancelado");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();

        if (newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Celda Editada", "Antiguo: " + oldValue + ", Nueva:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    /**
     * Devuelve la fecha actual De Sistema
     */
    public void dateNow() {
        fechaVenta = new Date();
        RequestContext.getCurrentInstance().execute("PF('confirmation').show()");
    }

    /**
     * Para guardar en la bd
     *
     * @param codins
     * @throws Exception
     */
    public void agregarListaVentaDetalle(String codins) throws Exception {
        this.session = null;
        this.transaccion = null;

        try {
            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaccion = this.session.beginTransaction();

            ListdetaCarts = new ArrayList<>();

            ListMaeCart = new ArrayList<>();

            if (dao_DetalCart.ExisteCodins(this.session, codins, consecutivocompleto)) {

                BigDecimal precioCuen = dao_Producctos.precio(this.session, codins);
                precioCuen = precioCuen.add(dao_Producctos.precio(this.session, codins));
                BigDecimal nuevode = dao_Producctos.Cantidad(this.session, codins);

                nuevode = nuevode.add(BigDecimal.ONE);

                dao_Producctos.updateCartCant(this.session, codins, nuevode);
            
            } else {
                BigDecimal precio = convertirBig(dao_Producctos.precios(this.session, codins, Codalm, CodList));
                BigDecimal Iva = convertirBig(dao_Producctos.getmargeIva(this.session, dao_Producctos.getIdIva(this.session, codins)));
                BigDecimal margendesc = convertirBig(dao_Producctos.margendescuento(this.session, codins, Codalm, CodList));
                BigDecimal valIva = CalcularSoloIVa(Iva, precio);
                BigDecimal valDsto = CalcularSoloDescuentos(margendesc, precio);
                this.ListdetaCarts.add(new VenDetaCart(new VenDetaCartId(Codalm, this.consecutivocompleto, "_PV", codins, ""), BigDecimal.ONE, BigDecimal.ZERO, "", BigDecimal.ZERO, valIva, valDsto, margendesc, Iva, precio));
                getProCart();
            }

            /*  if (dao_MaeCart.getConsecutivoMae(this.session, consecutivocompleto)) {
             System.out.println("consecutivo existe");
             getProCart();
             } else {
                
             this.ListMaeCart.add(new VenMaeCart(new VenMaeCartId(Codalm, consecutivocompleto, "_PV"), fechaVenta, fechaVenta, "cliente", "vapc", "", "ss", codven, CodList, ""));
             getProCart21();
               
             }
             getProCart();*/
            this.transaccion.commit();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Producto agregado"));

            RequestContext.getCurrentInstance().update("frmRealizarVentas:tablaListaProductosVenta");
            RequestContext.getCurrentInstance().update("frmRealizarVentas:mensajeGeneral");

        } catch (HibernateException ex) {
            if (this.transaccion != null) {
                transaccion.rollback();
            }

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", ex.getMessage()));

        } finally {
            if (this.session != null) {
                this.session.close();
            }
        }
    }

    public String save() {

        return "/CLientes/ListarPedidos.xhtml";
    }

    public void getProCart21() {

        this.session = null;
        this.transaccion = null;

        try {
            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaccion = this.session.beginTransaction();

            for (VenMaeCart item : ListMaeCart) {
                System.out.println("pedido" + item.getId().getNumPed());
                boolean a = dao_MaeCart.insert(this.session, item);

                if (a == true) {
                    System.out.println("Fue Exitoso el mae cart");

                }

            }

        } catch (Exception e) {
            System.out.println("Error " + e);

        }

    }

    /**
     * Cargar Datos a la tabla De cart
     */
    public void getProCart() {

        this.session = null;
        this.transaccion = null;

        try {
            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaccion = this.session.beginTransaction();
            if (dao_MaeCart.getConsecutivoMae(this.session, consecutivocompleto)) {
                for (VenDetaCart item : ListdetaCarts) {
                    dao_DetalCart.insert(this.session, item);
                    
                }

            } else {
                this.ListMaeCart.add(new VenMaeCart(new VenMaeCartId(Codalm, consecutivocompleto, "_PV"), fechaVenta, fechaVenta, "usuario", "vapc", "", dao_Clientes.CodTerCero(session, Cliente), codven, CodList, ""));
                getProCart21();

                for (VenDetaCart item : ListdetaCarts) {
                    dao_DetalCart.insert(this.session, item);
                }
            }


        } catch (Exception e) {

        }

    }

    public void deleteProduCart(String codIns) {

        this.session = null;
        this.transaccion = null;

        try {

            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaccion = this.session.beginTransaction();

            dao_Producctos.delete(this.session, codIns);

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

    /**
     *
     * @return
     */
    public List<VenDetaCart> getAll() {
        this.session = null;
        this.transaccion = null;

        try {

            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaccion = this.session.beginTransaction();

            this.ListdetaCarts2 = dao_DetalCart.getall(this.session, consecutivocompleto, Codalm, "_PV");
            boolean FacturaIva = false;
            boolean IvaIncluido = false;
            listAlm = dao_GenAlmacen.getAll(this.session);
            //saber si el almacen factura iva y si esta esta incluid
            for (GenAlmacenes item: listAlm) {
               if(item.getCodalm().equalsIgnoreCase(Codalm)){
                    FacturaIva = item.isFacturaIva();
                    IvaIncluido = item.isIvaIncluido();
               }                 
            }
            for (VenDetaCart item : ListdetaCarts2) {
                     Calculos(item.getMargenIva(),item.getValUnitario(),item.getMargenDcto(),item.getQtyPed(),FacturaIva,IvaIncluido);
                }
           
                    
            this.transaccion.commit();

            return this.ListdetaCarts2;
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
     * devuelve nombre insumo
     *
     * @param id
     * @return
     */
    public String datosInsumo(String id) {
        String variable = "";
        for (AlmInsumos productos : listInsumos) {
            if (id.equalsIgnoreCase(productos.getCodins())) {
                variable = productos.getNomins();

            }
        }
        return variable;
    }

    /**
     *
     * @param id
     * @return
     */
    public String Iva(String id) {

        this.session = null;
        this.transaccion = null;

        try {
            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaccion = this.session.beginTransaction();

            String Iva = "";
            Iva = dao_Producctos.getmargeIva(this.session, dao_Producctos.getIdIva(this.session, id));

            this.transaccion.commit();

            return Iva;

        } catch (Exception ex) {

            return "0.0";
        }

    }

    /**
     *
     * @return
     */
    public String Totaldescuento() {
        BigDecimal desc = BigDecimal.ZERO;
        BigDecimal margendescuento = BigDecimal.ZERO;
        String pre = "";

        for (VenDetaCart item : ListdetaCarts2) {
            BigDecimal valpro = item.getValUnitario();
            margendescuento = item.getMargenDcto().divide(new BigDecimal("100"));
            desc = valpro.multiply(margendescuento);

            double amount = desc.doubleValue();
            if (amount == 0) {
                pre = "0";
            } else {
                //metodo que le da formato a un precio
                DecimalFormat formatter = new DecimalFormat("#,###.00");

                pre = formatter.format(amount);

            }

        }

        return pre;
    }

    public double Totaldescuento2() {
        BigDecimal desc = BigDecimal.ZERO;
        BigDecimal margendescuento = BigDecimal.ZERO;
        String pre = "";
        double amount = 0.0;

        for (VenDetaCart item : ListdetaCarts2) {
            BigDecimal valpro = item.getValUnitario();
            margendescuento = item.getMargenDcto().divide(new BigDecimal("100"));
            desc = valpro.multiply(margendescuento);

            amount = desc.doubleValue();
            if (amount == 0) {
                pre = "0";
            } else {
                //metodo que le da formato a un precio
                DecimalFormat formatter = new DecimalFormat("#,###.00");

                pre = formatter.format(amount);

            }

        }

        return amount;
    }

    /**
     *
     * @return
     */
    public String TotalBase() {
        BigDecimal desc = BigDecimal.ZERO;
        String pre = "";

        // double amount = desc.doubleValue();
        double subtotal = Subtotal2();
        double descuento = Totaldescuento2();

        double ope = subtotal - descuento;

        //metodo que le da formato a un precio
        DecimalFormat formatter = new DecimalFormat("#,###.00");

        pre = formatter.format(ope);

        return pre;
    }

    public double TotalBase2() {
        BigDecimal desc = BigDecimal.ZERO;
        String pre = "";

        // double amount = desc.doubleValue();
        double subtotal = Subtotal2();
        double descuento = Totaldescuento2();

        double ope = subtotal - descuento;

        return ope;
    }

    /**
     *
     * @return
     */
    public String TotalIvas() {
        BigDecimal desc = BigDecimal.ZERO;
        String pre = "";

        for (VenDetaCart item : ListdetaCarts2) {

            desc = desc.add(item.getValIva());
            double amount = desc.doubleValue();
            if (amount == 0) {
                pre = "0";
            } else {
                //metodo que le da formato a un precio
                DecimalFormat formatter = new DecimalFormat("#,###.00");

                pre = formatter.format(amount);

            }

        }

        return pre;
    }

    public double TotalIvas2() {
        BigDecimal desc = BigDecimal.ZERO;
        String pre = "";
        double amount = 0.0;
        for (VenDetaCart item : ListdetaCarts2) {

            desc = desc.add(item.getValIva());
            amount = desc.doubleValue();

        }

        return amount;
    }

    /**
     *
     * @return
     */
    public String SumaParciales() {
        BigDecimal preciosuma = new BigDecimal("0");
        String pre = "";
        double ivas = TotalIvas2();
        double base = TotalBase2();

        double respuesta = base + ivas;

        DecimalFormat formatter = new DecimalFormat("#,###.00");

        pre = formatter.format(respuesta);

        return pre;
    }

    /**
     * Calcular Parciales De La ventas
     *
     * @param codins
     * @return
     */
    public String PARCIAL(String codins) {
        BigDecimal porcentaje;
        BigDecimal margendescuento;
        BigDecimal preciocant;
        BigDecimal valdesc;
        BigDecimal precioiva;
        BigDecimal precifin;

        for (VenDetaCart item : ListdetaCarts2) {
            if (codins.equalsIgnoreCase(item.getId().getCodIns())) {
                porcentaje = item.getMargenIva().divide(new BigDecimal("100"));//porcentaje/100
                margendescuento = item.getMargenDcto().divide(new BigDecimal("100"));
                preciocant = item.getQtyPed().multiply(item.getValUnitario());

                valdesc = preciocant.multiply(margendescuento);
                preciocant = preciocant.subtract(valdesc);
                precioiva = preciocant.multiply(porcentaje);//precio * porcentaje;
                precifin = (item.getValUnitario().subtract(valdesc)).add(precioiva);
                double amount = precifin.doubleValue();
                //metodo que le da formato a un precio
                DecimalFormat formatter = new DecimalFormat("#,###.00");
                String pre = "";
                pre = formatter.format(amount);

                return pre;
            }
        }

        return "0";
    }

    public BigDecimal PARCIAL2(String codins) {
        BigDecimal porcentaje;
        BigDecimal margendescuento;
        BigDecimal preciocant;
        BigDecimal valdesc;
        BigDecimal precioiva;
        BigDecimal precifin;

        for (VenDetaCart item : ListdetaCarts2) {
            if (codins.equalsIgnoreCase(item.getId().getCodIns())) {
                porcentaje = item.getMargenIva().divide(new BigDecimal("100"));//porcentaje/100
                margendescuento = item.getMargenDcto().divide(new BigDecimal("100"));
                preciocant = item.getQtyPed().multiply(item.getValUnitario());
                valdesc = preciocant.multiply(margendescuento);
                preciocant = preciocant.subtract(valdesc);
                precioiva = preciocant.multiply(porcentaje);//precio * porcentaje;
                precifin = (item.getValUnitario().subtract(valdesc)).add(precioiva);

                return precifin;
            }
        }

        return BigDecimal.ZERO;
    }

    /**
     *
     * @param valor
     * @return
     */
    public String Formato(String valor) {
        double amount = Double.parseDouble(valor);
        //metodo que le da formato a un precio
        DecimalFormat formatter = new DecimalFormat("#,###.00");
        String pre = "";
        pre = formatter.format(amount);
        return pre;

    }

    /**
     *
     * @return
     */
    public String Subtotal() {
        BigDecimal sumatoria = new BigDecimal("0");
        String pre = "";
        double amount;
        for (VenDetaCart item : ListdetaCarts2) {
            sumatoria = sumatoria.add(PARCIAL2(item.getId().getCodIns()));

            amount = sumatoria.doubleValue();
            //metodo que le da formato a un precio
            DecimalFormat formatter = new DecimalFormat("#,###.00");

            pre = formatter.format(amount);

        }
        return pre;
    }

    public double Subtotal2() {
        BigDecimal sumatoria = new BigDecimal("0");

        double amount = 0.0;
        for (VenDetaCart item : ListdetaCarts2) {
            sumatoria = sumatoria.add(PARCIAL2(item.getId().getCodIns()));

            amount = sumatoria.doubleValue();

        }
        return amount;
    }

    /**
     *
     * @param margen
     * @param valor
     * @return
     */
    public BigDecimal CalcularSoloIVa(BigDecimal margen, BigDecimal valor) {
        BigDecimal a = margen.divide(new BigDecimal("100"));
        System.out.println("ivas" + a);
        System.out.println("valor" + valor);
        return valor.multiply(a);
    }

    /**
     *
     * @param margen
     * @param valor
     * @return
     */
    public BigDecimal CalcularSoloDescuentos(BigDecimal margen, BigDecimal valor) {
        BigDecimal a = margen.divide(new BigDecimal("100"));

        return valor.multiply(a);
    }

    /**
     *
     */
    public void Filter(ActionEvent event) {

        this.session = null;
        this.transaccion = null;

        try {

            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaccion = this.session.beginTransaction();

            parametroBus = parametroBus.replace("", "%");

            listInsumos = dao_Producctos.FiltradoProductos(this.session, parametroBus);

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

    /**
     * MEtodo para calcular todo sobre la venta
     *
     * @param Miva
     * @param prod
     * @param Mdesc
     * @param cant
     * @param facturaIva
     * @param ivaIncluido
     */
    public void Calculos(BigDecimal MivaB, BigDecimal prodB, BigDecimal MdescB, BigDecimal cantB, boolean facturaIva, boolean ivaIncluido) {
        //Empanada temporal cambiar luego
        DecimalFormat formatter = new DecimalFormat("#,###.00");
        double Miva = Double.parseDouble(MivaB.toString());
        double prod = Double.parseDouble(prodB.toString());
        double Mdesc = Double.parseDouble(MdescB.toString());
        double cant = Double.parseDouble(cantB.toString());

        //fin empanada
        double descuentoT = 0;
        double valiva = 0;
        double valivain = 0;

        if (facturaIva == false || (facturaIva == true && ivaIncluido == false)) {

            descuentoT = (prod * (Mdesc / 100));

        } else {
            descuentoT = (prod / (1 + Miva / 100)) * (Mdesc / 100);

        }

        if (facturaIva == true) {
            if (ivaIncluido == true) {
                valiva = ((prod / (1 + (Miva / 100))) - descuentoT) * (Miva / 100);

                valivain = (prod / (1 + (Miva / 100))) * (Miva / 100);

            } else {
                valiva = (prod - descuentoT) * (Miva / 100);
            }
        } else {
            valiva = 0;
        }
        //caso del la vista 
        double subtotal = prod * cant;

        double resultado = subtotal - (valivain * cant);//mostrar subtotal
        double valNIva = valiva * cant;
        double valdescuento = descuentoT * cant;

        //adicionales 
        double base = resultado - valdescuento;

        double totaldefinitivo = base + valNIva;

        //**********************LLenando Variables********************formatter.format(amount);
        ParcialLinea = formatter.format(subtotal);
        subtotalDefinitivo = formatter.format(resultado);
        DescuentoTotal = formatter.format(valdescuento);
        baseTotal = formatter.format(base);
        IvaValorFinal = formatter.format(valNIva);
        TotalVenta = formatter.format(totaldefinitivo);
        //Fin

        System.out.println("Subtotal = " + resultado + "\n" + "Descuento :" + valdescuento + "\n" + "valIvaGeneral " + valNIva + "\n" + "total a pagar" + totaldefinitivo);

    }

    ///Fin Metodos

    /**
     * get and set
     */
    public AlmInsumos getAlmInsumos() {
        return almInsumos;
    }

    public void setAlmInsumos(AlmInsumos almInsumos) {
        this.almInsumos = almInsumos;
    }

    public AlmLineas getAlmLineas() {
        return almLineas;
    }

    public void setAlmLineas(AlmLineas almLineas) {
        this.almLineas = almLineas;
    }

    public AlmSubLineas getAlmSubLineas() {
        return almSubLineas;
    }

    public void setAlmSubLineas(AlmSubLineas almSubLineas) {
        this.almSubLineas = almSubLineas;
    }

    public List<AlmLineas> getListaCate() {
        return listaCate;
    }

    public void setListaCate(List<AlmLineas> listaCate) {
        this.listaCate = listaCate;
    }

    public List<AlmSubLineas> getListaSubCat() {
        return listaSubCat;
    }

    public void setListaSubCat(List<AlmSubLineas> listaSubCat) {
        this.listaSubCat = listaSubCat;
    }

    public Dao_Producctos getDao_Producctos() {
        return dao_Producctos;
    }

    public void setDao_Producctos(Dao_Producctos dao_Producctos) {
        this.dao_Producctos = dao_Producctos;
    }

    public Dao_Lineas getDao_Lineas() {
        return dao_Lineas;
    }

    public void setDao_Lineas(Dao_Lineas dao_Lineas) {
        this.dao_Lineas = dao_Lineas;
    }

    public String getCatE() {
        return CatE;
    }

    public void setCatE(String CatE) {
        this.CatE = CatE;
    }

    public String getSubCatE() {
        return SubCatE;
    }

    public void setSubCatE(String SubCatE) {
        this.SubCatE = SubCatE;
    }

    public List<AlmInsumos> getListInsumos() {
        return listInsumos;
    }

    public void setListInsumos(List<AlmInsumos> listInsumos) {
        this.listInsumos = listInsumos;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Transaction getTransaccion() {
        return transaccion;
    }

    public void setTransaccion(Transaction transaccion) {
        this.transaccion = transaccion;
    }

    public String onFlowProcess(FlowEvent event) {

        return event.getNewStep();

    }

    public boolean isBtnCart() {
        return BtnCart;
    }

    public void setBtnCart(boolean BtnCart) {
        this.BtnCart = BtnCart;
    }

    public String getCliente() {
        return Cliente;
    }

    public void setCliente(String Cliente) {
        this.Cliente = Cliente;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public String getAlmacen() {
        return almacen;
    }

    public void setAlmacen(String almacen) {
        this.almacen = almacen;
    }

    public List<VenDetaPrecios> getProductosprecios() {
        return productosprecios;
    }

    public void setProductosprecios(List<VenDetaPrecios> productosprecios) {
        this.productosprecios = productosprecios;
    }

    public List<VenDetaCart> getListdetaCarts() {
        return ListdetaCarts;
    }

    public void setListdetaCarts(List<VenDetaCart> ListdetaCarts) {
        this.ListdetaCarts = ListdetaCarts;
    }

    public Dao_DetalCart getDao_DetalCart() {
        return dao_DetalCart;
    }

    public void setDao_DetalCart(Dao_DetalCart dao_DetalCart) {
        this.dao_DetalCart = dao_DetalCart;
    }

    public AlmInsumos getSelect() {
        return select;
    }

    public void setSelect(AlmInsumos select) {
        this.select = select;
    }

    public List<VenDetaCart> getListdetaCarts2() {
        return ListdetaCarts2;
    }

    public void setListdetaCarts2(List<VenDetaCart> ListdetaCarts2) {
        this.ListdetaCarts2 = ListdetaCarts2;
    }

    public VenDetaCart getVenDetaCart() {
        return venDetaCart;
    }

    public void setVenDetaCart(VenDetaCart venDetaCart) {
        this.venDetaCart = venDetaCart;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public List<Productos> getTempoProduc() {
        return tempoProduc;
    }

    public void setTempoProduc(List<Productos> tempoProduc) {
        this.tempoProduc = tempoProduc;
    }

    public Productos getProduc() {
        return produc;
    }

    public void setProduc(Productos produc) {
        this.produc = produc;
    }

    public List<AlmInvent> getListInven() {
        return listInven;
    }

    public void setListInven(List<AlmInvent> listInven) {
        this.listInven = listInven;
    }

    public String getConsecutivocompleto() {
        return consecutivocompleto;
    }

    public void setConsecutivocompleto(String consecutivocompleto) {
        this.consecutivocompleto = consecutivocompleto;
    }

    public String getComprados() {
        return comprados;
    }

    public void setComprados(String comprados) {
        this.comprados = comprados;
    }

    public List<VenMaeCart> getListMaeCart() {
        return ListMaeCart;
    }

    public void setListMaeCart(List<VenMaeCart> ListMaeCart) {
        this.ListMaeCart = ListMaeCart;
    }

    public Dao_MaeCart getDao_MaeCart() {
        return dao_MaeCart;
    }

    public void setDao_MaeCart(Dao_MaeCart dao_MaeCart) {
        this.dao_MaeCart = dao_MaeCart;
    }

    public VenDetaCart getSel() {
        return sel;
    }

    public void setSel(VenDetaCart sel) {
        this.sel = sel;
    }

    public String getMinimo() {
        return minimo;
    }

    public void setMinimo(String minimo) {
        this.minimo = minimo;
    }

    public String getMaximo() {
        return maximo;
    }

    public void setMaximo(String maximo) {
        this.maximo = maximo;
    }

    public List<AlmInsumos> getListInsumos2() {
        return listInsumos2;
    }

    public void setListInsumos2(List<AlmInsumos> listInsumos2) {
        this.listInsumos2 = listInsumos2;
    }

    public String getParametroBus() {
        return parametroBus;
    }

    public void setParametroBus(String parametroBus) {
        this.parametroBus = parametroBus;
    }

    public Dao_Clientes getDao_Clientes() {
        return dao_Clientes;
    }

    public void setDao_Clientes(Dao_Clientes dao_Clientes) {
        this.dao_Clientes = dao_Clientes;
    }

    public String getParcialLinea() {
        return ParcialLinea;
    }

    public void setParcialLinea(String ParcialLinea) {
        this.ParcialLinea = ParcialLinea;
    }

    public String getSubtotalDefinitivo() {
        return subtotalDefinitivo;
    }

    public void setSubtotalDefinitivo(String subtotalDefinitivo) {
        this.subtotalDefinitivo = subtotalDefinitivo;
    }

    public String getDescuentoTotal() {
        return DescuentoTotal;
    }

    public void setDescuentoTotal(String DescuentoTotal) {
        this.DescuentoTotal = DescuentoTotal;
    }

    public String getIvaValorFinal() {
        return IvaValorFinal;
    }

    public void setIvaValorFinal(String IvaValorFinal) {
        this.IvaValorFinal = IvaValorFinal;
    }

    public String getBaseTotal() {
        return baseTotal;
    }

    public void setBaseTotal(String baseTotal) {
        this.baseTotal = baseTotal;
    }

    public String getTotalVenta() {
        return TotalVenta;
    }

    public void setTotalVenta(String TotalVenta) {
        this.TotalVenta = TotalVenta;
    }

    public List<GenAlmacenes> getListAlm() {
        return listAlm;
    }

    public void setListAlm(List<GenAlmacenes> listAlm) {
        this.listAlm = listAlm;
    }

    public Dao_GenAlmacen getDao_GenAlmacen() {
        return dao_GenAlmacen;
    }

    public void setDao_GenAlmacen(Dao_GenAlmacen dao_GenAlmacen) {
        this.dao_GenAlmacen = dao_GenAlmacen;
    }
    
    

}
