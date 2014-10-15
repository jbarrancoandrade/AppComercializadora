/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Interface.Interface_DetalCart;
import POJOS.CntTerceros;
import POJOS.VenDetaCart;
import POJOS.VenMaeCart;
import java.math.BigDecimal;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Jhonbarranco
 */
public class Dao_DetalCart implements Interface_DetalCart {

    @Override
    public boolean insert(Session session, VenDetaCart tVentaDetalle) throws Exception {
        session.save(tVentaDetalle);
        return true;
    }

    @Override
    public List<VenDetaCart> getall(Session session, String numPed, String codAlm, String tipPed) throws Exception {
        Query query = session.createQuery("From VenDetaCart u where u.id.numPed=:numPed and u.id.codAlm=:codAlm and u.id.tipPed=:tipPed ");
        query.setParameter("numPed", numPed);
        query.setParameter("codAlm", codAlm);
        query.setParameter("tipPed", tipPed);
        List<VenDetaCart> ListInsumos = (List<VenDetaCart>) query.list();
        return ListInsumos;
    }

    @Override
    public List<VenDetaCart> getall2(Session session) throws Exception {
        Query query = session.createQuery("From VenDetaCart  ");
        List<VenDetaCart> ListInsumos = (List<VenDetaCart>) query.list();
        return ListInsumos;
    }

    @Override
    public boolean ExisteCodins(Session session, String codAlm, String numPed, String tipPed, String codIns, String codTalla) throws Exception {
        Query query = session.createQuery("From VenDetaCart u where  u.id.codAlm=:codAlm and u.id.numPed=:numPed and u.id.codIns=:codIns and u.id.tipPed=:tipPed and u.id.codTalla=:codTalla");
        query.setParameter("codAlm", codAlm);
        query.setParameter("numPed", numPed);
        query.setParameter("tipPed", tipPed);
        query.setParameter("codIns", codIns);
        query.setParameter("codTalla", codTalla);

        VenDetaCart vn = (VenDetaCart) query.uniqueResult();

        return (vn != null);
    }

    @Override
    public BigDecimal cantidad(Session session, String codAlm, String numPed, String tipPed, String codIns, String codTalla) throws Exception {
        Query query = session.createQuery("From VenDetaCart u where  u.id.codAlm=:codAlm and u.id.numPed=:numPed and u.id.codIns=:codIns and u.id.tipPed=:tipPed and u.id.codTalla=:codTalla");
        query.setParameter("codAlm", codAlm);
        query.setParameter("numPed", numPed);
        query.setParameter("tipPed", tipPed);
        query.setParameter("codIns", codIns);
        query.setParameter("codTalla", codTalla);

        VenDetaCart vn = (VenDetaCart) query.uniqueResult();
        return vn.getQtyPed();

    }

    @Override
    public boolean Eliminar(Session session, String codAlm, String numPed, String tipPed, String codTalla) throws Exception {
        boolean respuesta = false;
        String hql = "DELETE FROM VenDetaCart u where  u.id.codAlm=:codAlm and u.id.numPed=:numPed  and u.id.tipPed=:tipPed and u.id.codTalla=:codTalla";
        Query query = session.createQuery(hql);
        query.setParameter("codAlm", codAlm);
        query.setParameter("numPed", numPed);
        query.setParameter("tipPed", tipPed);
        query.setParameter("codTalla", codTalla);
        int result = query.executeUpdate();
        if (result != 0) {
            respuesta = true;
        } else {
            System.err.println("Error");
        }
        return respuesta;
    }

    @Override
    public int ActualizarEstado(Session session, String numPed, String codAlm, String estado) throws Exception {
        String hqlUpdate = "update VenDetaCart c set c.estado = :estado where  c.id.codAlm=:codAlm and  c.id.numPed=:numPed";

        int updatedEntities = session.createQuery(hqlUpdate)
                .setString("numPed", numPed)
                .setString("codAlm", codAlm)
                .setString("estado", estado)
                .executeUpdate();
        return updatedEntities;//respuesta es un entero de fila afectada debe ser 1  

    }
    
    
    @Override
    public boolean existenPendientes(Session session,String codVen) throws Exception{
        Query query = session.createQuery("From VenMaeCart u where codVen=:codVen  and estado='A'");
        query.setParameter("codVen", codVen);
        VenMaeCart vn = (VenMaeCart) query.uniqueResult();
        boolean x = (vn != null); 
       
        return x;
    }

}
