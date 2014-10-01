/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;


import POJOS.VenVendedor;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Jhonbarranco
 */
public interface Interface_Vendedores {

 /**
     *
     * @param session
     * @param nombrecom
     * @return
     * @throws Exception
     */
    public String getByNombre(Session session, String nombrecom) throws Exception;

    /**
     *
     * @param session
     * @param codVen
     * @return
     * @throws Exception
     */
    public String getByCodVen(Session session, String codVen) throws Exception;

    /**
     *
     * @param session
     * @return
     * @throws Exception
     */
    public List<VenVendedor> getListVendedores(Session session) throws Exception;
    
 

}
