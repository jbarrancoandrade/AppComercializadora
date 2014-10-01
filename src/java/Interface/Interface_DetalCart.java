/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import POJOS.VenDetaCart;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Jhonbarranco
 */
public interface Interface_DetalCart {
   /***
    * 
    * @param session
    * @param tVentaDetalle
    * @return
    * @throws Exception 
    */
    public boolean insert(Session session, VenDetaCart tVentaDetalle) throws Exception;
    /**
     * 
     * @param session
     * @return
     * @throws Exception 
     */
    public List<VenDetaCart> getall(Session session, String numPed , String codAlm, String tipPed ) throws Exception;
    
    /**
     * 
     * @param session
     * @param codIns
     * @return
     * @throws Exception 
     */
    public boolean ExisteCodins(Session session,String codIns,String numPed) throws Exception; 
    
    
    
    
    
    
    
    

}
