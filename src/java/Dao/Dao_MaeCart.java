/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Interface.Interface_MaeCart;
import POJOS.CntTerceros;
import POJOS.VenDetaCart;
import POJOS.VenMaeCart;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Jhonbarranco
 */
public class Dao_MaeCart implements Interface_MaeCart {

    @Override
    public boolean insert(Session session, VenMaeCart maeCart) throws Exception {
        session.save(maeCart);
        return true;
    }

    @Override
    public List<VenMaeCart> Listar(Session session) throws Exception {
        Query query = session.createQuery("From VenMaeCart where estado='P'");
        List<VenMaeCart> List = (List<VenMaeCart>) query.list();
        return List;
    }
    
    @Override
    public List<VenMaeCart> Listar2(Session session) throws Exception {
        Query query = session.createQuery("From VenMaeCart where estado='A'");
        List<VenMaeCart> List = (List<VenMaeCart>) query.list();
        return List;
    }

    @Override
    public boolean getConsecutivoMae(Session session, String numPed) throws Exception {
        Query query = session.createQuery("From  VenMaeCart u where u.id.numPed=:numPed");
        query.setParameter("numPed", numPed);
        VenMaeCart ven = (VenMaeCart) query.uniqueResult();
        return (ven != null);
    }

    @Override
    public String ClienteNombre(Session session, String codter) throws Exception {
        Query query = session.createQuery("From CntTerceros u WHERE u.codter=:codter");
        query.setParameter("codter", codter);
        CntTerceros cliente = (CntTerceros) query.uniqueResult();
        return cliente.getNombreBus();
    }

    @Override
    public String ClienteDireccion(Session session, String codter) throws Exception {
        Query query = session.createQuery("From CntTerceros u WHERE u.codter=:codter");
        query.setParameter("codter", codter);
        CntTerceros cliente = (CntTerceros) query.uniqueResult();
        return cliente.getDireccion();
    }

    @Override
    public String ClienteTelfono(Session session, String codter) throws Exception {
        Query query = session.createQuery("From CntTerceros u WHERE u.codter=:codter");
        query.setParameter("codter", codter);
        CntTerceros cliente = (CntTerceros) query.uniqueResult();
        return cliente.getTelefono1() + "-" + cliente.getTelefono2();

    }

    @Override
    public Date fechaVenta(Session session, String numPed) throws Exception {
        Query query = session.createQuery("From  VenMaeCart u where u.id.numPed=:numPed");
        query.setParameter("numPed", numPed);
        VenMaeCart ven = (VenMaeCart) query.uniqueResult();
        return ven.getFecPed();
    }

    @Override
    public boolean Eliminar(Session session, String codAlm, String numPed, String tipPed) throws Exception {
        boolean respuesta= false;
        String hql = "DELETE FROM VenMaeCart u WHERE u.id.codAlm = :codAlm and u.id.numPed=:numPed  and u.id.tipPed=:tipPed";
        Query query = session.createQuery(hql);
        query.setParameter("codAlm", codAlm);
        query.setParameter("numPed", numPed);
        query.setParameter("tipPed", tipPed);
        int result = query.executeUpdate();
        if(result!=0){
            respuesta=true;
        }else{
            System.err.println("Error");
        }
      return respuesta;
    }
    
    
    @Override
    public int ActualizarEstado(Session session, String numPed, String codAlm, String estado) throws Exception {
        String hqlUpdate = "update VenMaeCart c set c.estado = :estado where  c.id.codAlm=:codAlm and  c.id.numPed=:numPed";

        int updatedEntities = session.createQuery(hqlUpdate)
                .setString("numPed", numPed)
                .setString("codAlm", codAlm)
                .setString("estado", estado)
                .executeUpdate();
        return updatedEntities;//respuesta es un entero de fila afectada debe ser 1  
    }

}
