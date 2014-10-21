/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Interface;

import POJOS.VenClientes;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Jhonbarranco
 */
public interface Interface_Clientes {
    
    /**
     * Devuelve la Lista de todos los clientes De un vendedor
     * @param session
     * @param CodVen
     * @return
     * @throws Exception 
     */
     public List <VenClientes> getId(Session session, String CodVen) throws Exception;
     
     public List <VenClientes> Buscar(Session session, String codVen,String Parametro) throws Exception;
     
     public String ClienteId(Session session, String nit) throws Exception;
     
     public String CodTerCero(Session session,String NombreBus) throws Exception;
     
     
    
}
