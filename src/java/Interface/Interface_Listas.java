/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Interface;

import POJOS.AlmLineas;
import POJOS.AlmSubLineas;
import POJOS.VenListaPrecios;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Jhonbarranco
 */
public interface Interface_Listas {
    /**
     * 
     * @param session
     * @return
     * @throws Exception 
     */
    public List<AlmLineas> getLinea(Session session) throws Exception;
    
    /**
     * 
     * @param session
     * @param CodLinea
     * @return
     * @throws Exception 
     */
    public List<AlmSubLineas> getSublinea(Session session, String CodLinea) throws Exception;
    
    
}
