/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Interface.Interface_DetalCart;
import POJOS.CntTerceros;
import POJOS.VenDetaCart;
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
    public List<VenDetaCart> getall(Session session, String numPed , String codAlm, String tipPed ) throws Exception {
        Query query = session.createQuery("From VenDetaCart u where u.id.numPed=:numPed and u.id.codAlm=:codAlm and u.id.tipPed=:tipPed ");
        query.setParameter("numPed", numPed);
        query.setParameter("codAlm", codAlm);
        query.setParameter("tipPed", tipPed);
        List<VenDetaCart> ListInsumos = (List<VenDetaCart>) query.list();
        return ListInsumos;
    }

    @Override
    public boolean ExisteCodins(Session session, String codIns,String numPed) throws Exception {
        Query query = session.createQuery("From VenDetaCart u where  u.id.codIns=:codIns and u.id.numPed=:numPed ");
        query.setParameter("codIns", codIns);
         query.setParameter("numPed",numPed);
        VenDetaCart vn = (VenDetaCart) query.uniqueResult();

        return (vn != null);
    }

  
}
