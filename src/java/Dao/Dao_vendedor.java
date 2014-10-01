/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Interface.Interface_Vendedores;
import POJOS.VenVendedor;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Jhonbarranco
 */
public class Dao_vendedor implements Interface_Vendedores{

    @Override
    public String getByNombre(Session session, String nombreCom) throws Exception {

        Query query = session.createQuery("From VenVendedor u WHERE u.nombreCom =:nombreCom");
        query.setParameter("nombreCom", nombreCom);
        VenVendedor vendedor = (VenVendedor) query.uniqueResult();

        return vendedor.getCodven();
    }

    @Override
    public String getByCodVen(Session session, String codven) throws Exception {
        Query query = session.createQuery("From VenVendedor u WHERE u.codven =:codven");
        query.setParameter("codven", codven);
        VenVendedor vendedor = (VenVendedor) query.uniqueResult();
        return vendedor.getNombreCom();

    }

    @Override
    public List<VenVendedor> getListVendedores(Session session) throws Exception {
        Query query = session.createQuery("From VenClientes u where u.codVen=:codVen");
        List<VenVendedor> Lista = (List<VenVendedor>) query.list();
        return Lista;
    }

 

}
