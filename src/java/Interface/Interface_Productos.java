/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import POJOS.AlmInsumos;
import POJOS.AlmInvent;
import POJOS.GenConsecA;
import POJOS.GenConsecM;
import POJOS.GenConsecS;
import POJOS.GenConsecutivos;
import POJOS.VenDetaCart;
import POJOS.VenDetaPrecios;
import java.math.BigDecimal;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Jhonbarranco
 */
public interface Interface_Productos {

    /**
     *
     * @param session
     * @return
     * @throws Exception
     */
    public List<AlmInsumos> getAll(Session session) throws Exception;

    /**
     *
     * @param session
     * @param Codlinea
     * @return
     * @throws Exception
     */
    public List<AlmInsumos> getLinea(Session session, String Codlinea) throws Exception;

    /**
     *
     * @param session
     * @param Codlinea
     * @param SubLinea
     * @return
     * @throws Exception
     */
    public List<AlmInsumos> getsubLinea(Session session, String Codlinea, String SubLinea) throws Exception;

    /**
     * retorna la imgagen del producto por codigo
     *
     * @return
     * @throws Exception
     */
    public byte[] imagenProd(String codins, Session session) throws Exception;

    /**
     * Metodo que busca el valor de un producto determinado en la lista
     *
     * @param session
     * @param codins
     * @param codalm
     * @param codlist
     * @return
     * @throws Exception
     */
    public String precios(Session session, String codins, String codalm, String codlist) throws Exception;

    public boolean existePreci(Session session, String codins, String codalm, String codlist) throws Exception;

    public AlmInsumos getByIdProducto(Session session, String codins) throws Exception;

    public String getCantInven(Session session, String codins, String codalm) throws Exception;

    public String getmargeIva(Session session, String codIva) throws Exception;

    /**
     * Devuelve codcon de la tabla Cfg_ConsecxTrans
     *
     * @param session
     * @param idProcess
     * @return
     * @throws Exception
     */
    public String idProseso(Session session, String idProcess) throws Exception;

    /**
     * Me devuelve el tipo de consecutivo A si es anual M si es Mensual S si es
     * Simple
     *
     * @param session
     * @param codcon
     * @return
     * @throws Exception
     */
    public char getTipoConsecutivo(Session session, String codcon) throws Exception;

    /**
     *
     * @param session
     * @param Nomcon
     * @return
     * @throws Exception
     */
    public char getTipoConseg2(Session session, String Nomcon) throws Exception;

    /**
     * Devuelve consecutivo anual
     *
     * @param session
     * @param codalm
     * @param codcon
     * @param año
     * @return
     * @throws Exception
     */
    public int getConsecutivoA(Session session, String codalm, String codcon, int año) throws Exception;

    /**
     * devuelve consecutivo Mensual
     *
     * @param session
     * @param codalm
     * @param codcon
     * @param año
     * @param mes
     * @return
     * @throws Exception
     */
    public int getConsecutivoM(Session session, String codalm, String codcon, int año, int mes) throws Exception;

    /**
     * Devuelve consecutivo Simple
     *
     * @param session
     * @param codcon
     * @return
     * @throws Exception
     */
    public int getConsecutivoS(Session session, String codcon) throws Exception;

    /**
     * Metodo que incrementa un consecutivo
     *
     * @param session
     * @return
     * @throws Exception
     */
    public int IncrementarConsecutivoA(Session session, String codalm, String codcon, int año, int Incrementado) throws Exception;

    /**
     * Incrementa consecutivo Mensual
     *
     * @param session
     * @param codalm
     * @param codcon
     * @param año
     * @param mes
     * @param Incrementado
     * @return
     * @throws Exception
     */
    public int IncrementarConsecutivoM(Session session, String codalm, String codcon, int año, int mes, int Incrementado) throws Exception;

    /**
     * Incrementa Consecutivo Simple
     *
     * @param session
     * @param codcon
     * @param Incrementado
     * @return
     * @throws Exception
     */
    public int IncrementarConsecutivoS(Session session, String codcon, int Incrementado) throws Exception;

    /**
     *
     * @param session
     * @param codins
     * @return
     * @throws Exception
     */
    public String getIdIva(Session session, String codins) throws Exception;

    
    /**
     * Metodo que actualiza El DetaCart 
     * @param session
     * @param codAlm
     * @param numPed
     * @param tipPed
     * @param codTalla
     * @param codIns
     * @param qtyPed
     * @param valUnitario
     * @param margenDcto
     * @param valDcto
     * @return
     * @throws Exception 
     */
    public int updateCart(Session session,  String codAlm, String numPed, String tipPed, String codTalla ,String codIns, BigDecimal qtyPed,BigDecimal valUnitario,BigDecimal margenDcto,BigDecimal valDcto , BigDecimal valIva) throws Exception;

    
    /**
     * 
     * @param session
     * @param codAlm
     * @param numPed
     * @param tipPed
     * @param codTalla
     * @return
     * @throws Exception 
     */
    public int upCantCart(Session session, String codAlm,String numPed,String tipPed,String codIns,String codTalla,BigDecimal qtyPed) throws Exception;
    
    
    
    /**
     *
     * @param session
     * @param codins
     * @param valUnitario
     * @return
     * @throws Exception
     */
    public int updateCartPrecio(Session session, String codins, BigDecimal valUnitario) throws Exception;

    /**
     *
     * @param session
     * @param codins
     * @param margenDcto
     * @return
     * @throws Exception
     */
    public int updateCartDesc(Session session, String codins, BigDecimal margenDcto) throws Exception;

    /**
     * Crear el consecutivo si no existe
     *
     * @param session
     * @param a
     * @return
     * @throws Exception
     */
    public boolean createConsecA(Session session, GenConsecA a) throws Exception;

    /**
     *
     * @param session
     * @param a
     * @return
     * @throws Exception
     */
    public boolean createConsecM(Session session, GenConsecM a) throws Exception;

    /**
     *
     * @param session
     * @param a
     * @return
     * @throws Exception
     */
    public boolean createConsecS(Session session, GenConsecS a) throws Exception;
    
    /**
     * Crear el consecutivo si no existe
     *
     * @param session
     * @param a
     * @return
     * @throws Exception
     */
    public int  updateConsecA(Session session,String codcon,int año,int consecutivo, String codalm) throws Exception;

    /**
     *
     * @param session
     * @param a
     * @return
     * @throws Exception
     */
    public boolean updateConsecM(Session session, GenConsecM a) throws Exception;

    /**
     *
     * @param session
     * @param a
     * @return
     * @throws Exception
     */
    public boolean updateConsecS(Session session, GenConsecS a) throws Exception;
    /**
     *
     * @param session
     * @return
     * @throws Exception
     */
    public int actualizarValorDescuento(Session session, String codins, BigDecimal valDcto) throws Exception;

    /**
     * 
     * @param session
     * @param codins
     * @param codalm
     * @param codList
     * @return
     * @throws Exception 
     */
    public String margendescuento(Session session, String codins, String codalm, String codList) throws Exception;
    
    /**
     * 
     * @param session
     * @param codAlm
     * @param numPed
     * @param tipPed
     * @param codIns
     * @param codTalla
     * @return
     * @throws Exception 
     */
    public BigDecimal Cantidad (Session session,String codAlm,String numPed,String tipPed,String codIns,String codTalla)  throws Exception;
    
    /**
     * Retorna el precio Del producto En El detacart
     * Usando la llave Primaria Para obtener un unico Resultado
     * @param session
     * @param codAlm
     * @param numPed
     * @param tipPed
     * @param codIns
     * @param codTalla
     * @return
     * @throws Exception 
     */
    public BigDecimal precio (Session session,String codAlm,String numPed,String tipPed,String codIns,String codTalla) throws Exception;
     
    public boolean delete (Session session, String codins) throws Exception;
     
     public int actualizarConsecutivo(Session session) throws Exception;
     
     
     /**
      * 
      * @param session
      * @param Parametro
      * @return
      * @throws Exception 
      */
     public List<AlmInsumos> FiltradoProductos(Session session, String Parametro) throws Exception;

         
}
