/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import org.hibernate.Session;

/**
 *
 * @author Jhonbarranco
 */
public interface Interface_User {

    /**
     *
     * @param session
     * @param userName
     * @return
     * @throws Exception
     */
    public boolean isValidUserName(Session session, String userName) throws Exception;

    /**
     *
     * @param session
     * @param userName
     * @return
     * @throws Exception
     */
    public String Contraseña(Session session, String userName) throws Exception;

    /**
     *
     * @param session
     * @param userName
     * @param pwd
     * @return
     * @throws Exception
     */
    public boolean ischecking(Session session, String userName, String pwd) throws Exception;

    /**
     *
     * @param session
     * @param username
     * @return
     * @throws Exception
     */
    public String obtenerCedula(Session session, String username) throws Exception;
    
       /**
     * 
     * @param session
     * @param userName
     * @return
     * @throws Exception 
     */
    public String Cargo(Session session,String userName) throws Exception;

}
