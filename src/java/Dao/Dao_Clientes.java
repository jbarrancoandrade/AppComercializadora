/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Interface.Interface_Clientes;
import POJOS.VenClientes;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Jhonbarranco este es distinto al del session este es un elemnto
 */
public class Dao_Clientes implements Interface_Clientes {

    @Override
    public List<VenClientes> getId(Session session, String codVen) throws Exception {

        Query query = session.createQuery("From VenClientes u where u.codVen=:codVen order by nombreCom asc");
        query.setParameter("codVen", codVen);
        List<VenClientes> Lista = (List<VenClientes>) query.list();

        return Lista;
    }

    @Override
    public List<VenClientes> Buscar(Session session, String codVen ,String Parametro) throws Exception {
        Query query = session.createQuery("From VenClientes  u where u.codVen=:codVen and u.cedula like '" + Parametro + "' or nombreBus like '" + Parametro + "'");
        query.setParameter("codVen", codVen);

        List<VenClientes> List = (List<VenClientes>) query.list();
        

        return List;

    }

    @Override
    public String ClienteId(Session session, String cedula) throws Exception {
        Query query = session.createQuery("From VenClientes u where u. cedula=:cedula ");
        query.setParameter("cedula", cedula);
        VenClientes Li = (VenClientes) query.uniqueResult();
        return Li.getNombreBus();
    }

    @Override
    public String CodTerCero(Session session, String nombreBus) throws Exception {
        Query query = session.createQuery("From VenClientes u where u.nombreBus=:nombreBus ");
        query.setParameter("nombreBus", nombreBus);
        VenClientes Li = (VenClientes) query.uniqueResult();
        return Li.getCedula();
    }

}
