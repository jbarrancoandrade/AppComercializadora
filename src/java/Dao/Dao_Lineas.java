/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Interface.Interface_Listas;
import POJOS.AlmLineas;
import POJOS.AlmSubLineas;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Jhonbarranco
 */
public class Dao_Lineas implements Interface_Listas{

    @Override
    public List<AlmLineas> getLinea(Session session) throws Exception {
        Query query = session.createQuery("From AlmLineas u where u.id.clase !='S'");
        List<AlmLineas> ListAlmLineas = (List<AlmLineas>) query.list();
        return ListAlmLineas;
    }

    @Override
    public List<AlmSubLineas> getSublinea(Session session, String codLinea) throws Exception {
        Query query = session.createQuery("From AlmSubLineas u where u.id.codLinea=:codLinea AND u.id.clase !='S'");
        query.setParameter("codLinea", codLinea);
        List<AlmSubLineas> ListAlmSubLineas = (List<AlmSubLineas>) query.list();
        return ListAlmSubLineas;
    }

}
