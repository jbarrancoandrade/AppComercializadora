/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Interface.Interface_GenAlmacen;
import POJOS.GenAlmacenes;
import POJOS.VenListaPrecios;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Jhonbarranco
 */
public class Dao_GenAlmacen implements Interface_GenAlmacen {

    @Override
    public List<GenAlmacenes> getAll(Session session) throws Exception {
        Query query = session.createQuery("From GenAlmacenes");
        List<GenAlmacenes> ListalmCen = (List<GenAlmacenes>) query.list();

        return ListalmCen;
    }

    @Override
    public List<VenListaPrecios> getAlmacen(Session session, String codalm) throws Exception {
        Query query = session.createQuery("From VenListaPrecios U Where U.codalm=:codalm");
        query.setParameter("codalm", codalm);
        List<VenListaPrecios> Lista = (List<VenListaPrecios>) query.list();
        return Lista;

    }

    @Override
    public String NombreAlm(Session session, String codalm) throws Exception {
        Query query = session.createQuery("From GenAlmacenes U Where U.codalm=:codalm");
        query.setParameter("codalm", codalm);
        GenAlmacenes alm = (GenAlmacenes) query.uniqueResult();
        return alm.getNomalm(); 
    
    }

}
