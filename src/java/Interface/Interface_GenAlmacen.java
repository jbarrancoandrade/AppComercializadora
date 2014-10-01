/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Interface;

import POJOS.GenAlmacenes;
import POJOS.VenListaPrecios;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Jhonbarranco
 */
public interface Interface_GenAlmacen {
    
    /**
     * 
     * @param session
     * @return
     * @throws Exception 
     */
    public List<GenAlmacenes> getAll(Session session) throws Exception;
    
    /**
     * 
     * @param session
     * @param codalm
     * @return
     * @throws Exception 
     */
    
    public List<VenListaPrecios> getAlmacen(Session session, String codalm) throws Exception;
    
    
    public String NombreAlm(Session session, String codalm ) throws Exception;
    
 
    
    
}
