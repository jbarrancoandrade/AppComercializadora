/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Interface.Interface_Productos;
import POJOS.AlmImgInsumos;
import POJOS.AlmInsumos;
import POJOS.AlmInvent;
import POJOS.CfgConsecxTrans;
import POJOS.CfgUsuarios;
import POJOS.GenConsecA;
import POJOS.GenConsecM;
import POJOS.GenConsecS;
import POJOS.GenConsecutivos;
import POJOS.VenDetaCart;
import POJOS.VenDetaPrecios;
import POJOS.VenIvas;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Jhonbarranco
 */
public class Dao_Producctos implements Interface_Productos {

    @Override
    public List<AlmInsumos> getAll(Session session) throws Exception {
        Query query = session.createQuery("From AlmInsumos where  activo=true");
        List<AlmInsumos> ListInsumos = (List<AlmInsumos>) query.list();
        return ListInsumos;
    }

    @Override
    public List<AlmInsumos> getLinea(Session session, String codLinea) throws Exception {
        Query query = session.createQuery("From AlmInsumos U Where U.codLinea=:codLinea  and activo='true'");
        query.setParameter("codLinea", codLinea);
        List<AlmInsumos> ListInsumos = (List<AlmInsumos>) query.list();
        return ListInsumos;

    }

    @Override
    public List<AlmInsumos> getsubLinea(Session session, String codLinea, String codSub) throws Exception {
        Query query = session.createQuery("From AlmInsumos U Where U.codLinea=:codLinea and U.codSub=:codSub and activo='true'");
        query.setParameter("codLinea", codLinea);
        query.setParameter("codSub", codSub);
        List<AlmInsumos> ListInsumos = (List<AlmInsumos>) query.list();
        return ListInsumos;
    }

    @Override
    public byte[] imagenProd(String codins, Session session) throws Exception {
        Query query = session.createQuery("From CfgUsuarios u WHERE u.codins =:codins");
        query.setParameter("codins", codins);
        AlmImgInsumos img = (AlmImgInsumos) query.uniqueResult();
        return img.getGraficos();
    }

    @Override
    public String precios(Session session, String codins, String codalm, String codList) throws Exception {
        Query query = session.createQuery("From VenDetaPrecios u Where u.id.codins=:codins and u.id.codalm=:codalm and u.id.codList=:codList");
        query.setParameter("codins", codins);
        query.setParameter("codalm", codalm);
        query.setParameter("codList", codList);
        VenDetaPrecios precio = (VenDetaPrecios) query.uniqueResult();
        String resultado;
        if (precio == null) {
            resultado = "0";
        } else {
            resultado = precio.getValVta().toString();
        }
        return resultado;

    }

    @Override
    public String margendescuento(Session session, String codins, String codalm, String codList) throws Exception {
        Query query = session.createQuery("From VenDetaPrecios u Where u.id.codins=:codins and u.id.codalm=:codalm and u.id.codList=:codList");
        query.setParameter("codins", codins);
        query.setParameter("codalm", codalm);
        query.setParameter("codList", codList);
        VenDetaPrecios precio = (VenDetaPrecios) query.uniqueResult();
        String resultado;
        if (precio == null) {
            resultado = "0";
        } else {
            resultado = precio.getMargenDcto().toString();
        }
        return resultado;
    }

    @Override
    public AlmInsumos getByIdProducto(Session session, String codins) throws Exception {
        return (AlmInsumos) session.load(AlmInsumos.class, codins);
    }

    @Override
    public String getCantInven(Session session, String codins, String codalm) throws Exception {
        Query query = session.createQuery("From AlmInvent u WHERE  u.id.codalm=:codalm and u.id.codins=:codins");
        query.setParameter("codins", codins);
        query.setParameter("codalm", codalm);
        AlmInvent inven = (AlmInvent) query.uniqueResult();
        String resultado;
        if (inven == null) {
            resultado = "0.0";
        } else {
            resultado = inven.getCaninv().toString();
        }
        return resultado;
    }

    @Override
    public String getmargeIva(Session session, String codIva) throws Exception {
        Query query = session.createQuery("From VenIvas u where u.codIva=:codIva");
        query.setParameter("codIva", codIva);
        VenIvas ivas = (VenIvas) query.uniqueResult();
        return ivas.getMargenIva().toString();
    }

    @Override
    public boolean existePreci(Session session, String codins, String codalm, String codlist) throws Exception {
        Query query = session.createQuery("From VenDetaPrecios u Where u.id.codins=:codins and u.id.codalm=:codalm and u.id.codList=:codList");
        query.setParameter("codins", codins);
        query.setParameter("codalm", codalm);
        query.setParameter("codList", codlist);
        VenDetaPrecios precio = (VenDetaPrecios) query.uniqueResult();
        return (precio != null);
    }

    ///MEtodos Consecutivos
    @Override
    public String idProseso(Session session, String idProcess) throws Exception {//PEDIDO_VENTAS
        Query query = session.createQuery("From CfgConsecxTrans u WHERE  u.idProcess=:idProcess ");
        query.setParameter("idProcess", idProcess);
        CfgConsecxTrans conse = (CfgConsecxTrans) query.uniqueResult();
        return conse.getCodcon();
    }

    @Override
    public char getTipoConsecutivo(Session session, String codcon) throws Exception {//PVN
        Query query = session.createQuery("From GenConsecutivos u WHERE  u.codcon=:codcon ");
        query.setParameter("codcon", codcon);
        GenConsecutivos conse = (GenConsecutivos) query.uniqueResult();
        return conse.getTipcon();
    }

    @Override
    public char getTipoConseg2(Session session, String nomcon) throws Exception {//PEDIDOS DE VENTAS
        Query query = session.createQuery("From GenConsecutivos u WHERE  u.nomcon=:nomcon ");
        query.setParameter("nomcon", nomcon);
        GenConsecutivos conse = (GenConsecutivos) query.uniqueResult();
        return conse.getTipcon();
    }

    @Override
    public int getConsecutivoA(Session session, String codalm, String codcon, int año) throws Exception {
        Query query = session.createQuery("From GenConsecA u WHERE   u.id.codalm=:codalm and  u.id.codcon=:codcon and  u.id.año=:año");
        query.setParameter("codalm", codalm);
        query.setParameter("codcon", codcon);
        query.setParameter("año", año);

        GenConsecA conse = (GenConsecA) query.uniqueResult();

        return conse.getConsecutivo();

    }

    @Override
    public int getConsecutivoM(Session session, String codalm, String codcon, int año, int mes) throws Exception {
        Query query = session.createQuery("From GenConsecA u WHERE   u.id.codalm=:codalm and  u.id.codcon=:codcon and  u.id.año=:año  and u.id.mes=:mes");
        query.setParameter("codalm", codalm);
        query.setParameter("codcon", codcon);
        query.setParameter("año", año);
        query.setParameter("mes", mes);

        GenConsecM conse = (GenConsecM) query.uniqueResult();

        return conse.getConsecutivo();

    }

    @Override
    public int getConsecutivoS(Session session, String codcon) throws Exception {
        Query query = session.createQuery("From GenConsecA u WHERE   u.id.codalm=:codalm and  u.id.codcon=:codcon and  u.id.año=:año  and u.id.mes=:mes");
        query.setParameter("codcon", codcon);
        GenConsecS conse = (GenConsecS) query.uniqueResult();

        return conse.getConsecutivo();

    }

    @Override
    public int IncrementarConsecutivoA(Session session, String codalm, String codcon, int año, int consecutivo) throws Exception {
        String hqlUpdate = "update GenConsecA c set c.consecutivo = :consecutivo where  c.id.codalm=:codalm and  c.id.codcon=:codcon and  c.id.año=:año";

        int updatedEntities = session.createQuery(hqlUpdate)
                .setInteger("consecutivo", consecutivo)
                .setString("codalm", codalm)
                .setString("codcon", codcon)
                .setInteger("año", año)
                .executeUpdate();
        return updatedEntities;//respuesta es un entero de fila afectada debe ser 1
    }

    @Override
    public int IncrementarConsecutivoM(Session session, String codalm, String codcon, int año, int mes, int consecutivo) throws Exception {
        String hqlUpdate = "update GenConsecM c set c.consecutivo = :consecutivo where  c.id.codalm=:codalm and  c.id.codcon=:codcon and  c.id.año=:año and  c.id.mes=:mes";
        int updatedEntities = session.createQuery(hqlUpdate)
                .setInteger("consecutivo", consecutivo)
                .setString("codalm", codalm)
                .setString("codcon", codcon)
                .setInteger("año", año)
                .setInteger("año", mes)
                .executeUpdate();
        return updatedEntities;//respuesta es un entero de fila afectada debe ser 1

    }

    @Override
    public int IncrementarConsecutivoS(Session session, String codcon, int consecutivo) throws Exception {
        String hqlUpdate = "update GenConsecM c set c.consecutivo = :consecutivo where  c.id.codalm=:codalm and  c.id.codcon=:codcon and  c.id.año=:año and  c.id.mes=:mes";
        int updatedEntities = session.createQuery(hqlUpdate)
                .setInteger("consecutivo", consecutivo)
                .setString("codcon", codcon)
                .executeUpdate();
        return updatedEntities;//respuesta es un entero de fila afectada debe ser 1

    }

    @Override
    public String getIdIva(Session session, String codins) throws Exception {
        Query query = session.createQuery("From AlmInsumos u where  u.codins=:codins");
        query.setParameter("codins", codins);
        AlmInsumos insumo = (AlmInsumos) query.uniqueResult();
        return insumo.getCodIva();

    }

    @Override
    public int updateCart(Session session,  String codAlm, String numPed, String tipPed, String codTalla ,String codIns, BigDecimal qtyPed,BigDecimal valUnitario,BigDecimal margenDcto,BigDecimal valIva,BigDecimal valDcto ) throws Exception {
        String hqlUpdate = "update VenDetaCart c set   c.qtyPed=:qtyPed,c.margenDcto=:margenDcto,c.valDcto=:valDcto,c.valUnitario=:valUnitario,c.valIva=:valIva  where c.id.codIns=:codIns and c.id.codAlm=:codAlm and c.id.numPed=:numPed  and c.id.tipPed=:tipPed and id.codTalla=:codTalla";
        int updatedEntities = session.createQuery(hqlUpdate)
                .setBigDecimal("qtyPed", qtyPed)
                .setBigDecimal("valUnitario",valUnitario)
                .setBigDecimal("valIva",valIva)
                .setBigDecimal("margenDcto",margenDcto)
                .setBigDecimal("valDcto",valDcto)
                .setString("codIns",codIns)
                .setString("codAlm",codAlm)
                .setString("numPed",numPed)
                .setString("tipPed",tipPed)
                .setString("codTalla",codTalla)
                .executeUpdate();
        System.out.println("actualizado "+updatedEntities);
        return updatedEntities;//respuesta es un entero de fila afectada debe ser 1 
    }

    @Override
    public int upCantCart(Session session, String codAlm,String numPed,String tipPed,String codIns,String codTalla,BigDecimal qtyPed) throws Exception{
          String hqlUpdate = "update VenDetaCart c set   c.qtyPed=:qtyPed,c.margenDcto=:margenDcto,c.valDcto=:valDcto,c.valUnitario=:valUnitario,c.valIva=:valIva  where c.id.codIns=:codIns and c.id.codAlm=:codAlm and c.id.numPed=:numPed  and c.id.tipPed=:tipPed and id.codTalla=:codTalla";
        int updatedEntities = session.createQuery(hqlUpdate)
                
                .setString("codIns",codIns)
                .setString("codAlm",codAlm)
                .setString("numPed",numPed)
                .setString("tipPed",tipPed)
                .setString("codTalla",codTalla)
                .executeUpdate();
        return updatedEntities;//respuesta es un entero de fila afectada debe ser 1 
    }
    
    
    @Override
    public int updateCartPrecio(Session session, String codIns, BigDecimal valUnitario) throws Exception {
        String hqlUpdate = "update VenDetaCart c set c.valUnitario=:valUnitario where c.id.codIns=:codIns ";
        int updatedEntities = session.createQuery(hqlUpdate)
                .setBigDecimal("valUnitario", valUnitario)
                .setString("codIns", codIns)
                .executeUpdate();
        return updatedEntities;//respuesta es un entero de fila afectada debe ser 1
    }

    @Override
    public int updateCartDesc(Session session, String codins, BigDecimal margenDcto) throws Exception {
        String hqlUpdate = "update VenDetaCart c set c.id.codins=:codins where  c.margenDcto=:margenDcto";
        int updatedEntities = session.createQuery(hqlUpdate)
                .setBigDecimal("margenDcto", margenDcto)
                .setString("codins", codins)
                .executeUpdate();
        return updatedEntities;//respuesta es un entero de fila afectada debe ser 1
    }

    @Override
    public boolean createConsecA(Session session, GenConsecA a) throws Exception {
        session.save(a);
        return true;

    }

    @Override
    public boolean createConsecM(Session session, GenConsecM a) throws Exception {
        session.save(a);
        return true;

    }

    @Override
    public boolean createConsecS(Session session, GenConsecS a) throws Exception {
        session.save(a);
        return true;
    }

    @Override
    public int updateConsecA(Session session, String codcon, int año, int consecutivo, String codalm) throws Exception {
        String hqlUpdate = "update GenConsecA c set c.consecutivo=:consecutivo where  c.id.codcon=:codcon and  c.id.año=:año and c.id.codalm=:codalm";
        int updatedEntities = session.createQuery(hqlUpdate)
                .setInteger("consecutivo", consecutivo)
                .setString("codcon", codcon)
                .setInteger("año", año)
                .setString("codalm", codalm)
                .executeUpdate();
        return updatedEntities;//respuesta es un entero de fila afectada debe ser 1

    }

    @Override
    public boolean updateConsecM(Session session, GenConsecM a) throws Exception {
        session.update(a);
        return true;

    }

    @Override
    public boolean updateConsecS(Session session, GenConsecS a) throws Exception {
        session.update(a);
        return true;
    }

    @Override
    public int actualizarValorDescuento(Session session, String codins, BigDecimal valDcto) throws Exception {
        String hqlUpdate = "update VenDetaCart c set c.id.codins=:codins where  c.valDcto=:margenDcto";
        int updatedEntities = session.createQuery(hqlUpdate)
                .setBigDecimal("valDcto", valDcto)
                .setString("codins", codins)
                .executeUpdate();
        return updatedEntities;//respuesta es un entero de fila afectada debe ser 1

    }

    @Override
    public BigDecimal Cantidad(Session session, String codAlm, String numPed, String tipPed, String codIns, String codTalla) throws Exception {

        Query query = session.createQuery("From VenDetaCart u Where u.id.codAlm=:codAlm and u.id.numPed=:numPed  and u.id.tipPed=:tipPed  and u.id.codIns=:codIns  and u.id.codTalla=:codTalla");
        query.setParameter("codAlm", codAlm);
        query.setParameter("numPed", numPed);
        query.setParameter("tipPed", tipPed);
        query.setParameter("codIns", codIns);
        query.setParameter("codTalla", codTalla);
        VenDetaCart precio = (VenDetaCart) query.uniqueResult();

        return precio.getQtyPed();

    }

    @Override
    public BigDecimal precio(Session session, String codAlm, String numPed, String tipPed, String codIns, String codTalla) throws Exception {

        Query query = session.createQuery("From VenDetaCart u Where u.id.codAlm=:codAlm and u.id.numPed=:numPed  and u.id.tipPed=:tipPed  and u.id.codIns=:codIns  and u.id.codTalla=:codTalla");
        query.setParameter("codAlm", codAlm);
        query.setParameter("numPed", numPed);
        query.setParameter("tipPed", tipPed);
        query.setParameter("codIns", codIns);
        query.setParameter("codTalla", codTalla);
        VenDetaCart precio = (VenDetaCart) query.uniqueResult();

        return precio.getValUnitario();

    }

    @Override
    public boolean delete(Session session, String codIns) throws Exception {
        boolean resp = false;
        Query query = session.createQuery("DELETE From VenDetaCart u Where u.id.codIns=:codIns");
        query.setParameter("codIns", codIns);
        int result = query.executeUpdate();
        resp = result == 1;
        return resp;
    }

    @Override
    public int actualizarConsecutivo(Session session) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<AlmInsumos> FiltradoProductos(Session session, String Parametro) throws Exception {

        Query query = session.createQuery("From AlmInsumos as u where u.nomins like '" + Parametro + "' or refins like '" + Parametro + "' or eanins like '" + Parametro + "' or codins like '" + Parametro + "' or codbar like '" + Parametro + "' or codrap like '" + Parametro + "'");

        List<AlmInsumos> ListInsumos = (List<AlmInsumos>) query.list();

        return ListInsumos;

    }

}
