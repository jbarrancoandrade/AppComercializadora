/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Interface.Interface_User;
import POJOS.CfgUsuarios;
import java.io.Serializable;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Jhonbarranco 
 * 
 */
public class Dao_User implements Interface_User{

    @Override
    public boolean isValidUserName(Session session, String userName) throws Exception {
        Query query = session.createQuery("From CfgUsuarios u WHERE u.userName =:userName");
        query.setParameter("userName", userName);
        CfgUsuarios user = (CfgUsuarios) query.uniqueResult();
        return (user != null);
        
    }

    @Override
    public String Contraseña(Session session, String userName) throws Exception {
        Query query = session.createQuery("From CfgUsuarios u WHERE u.userName =:userName");
        query.setParameter("userName", userName);
        CfgUsuarios user = (CfgUsuarios) query.uniqueResult();
        return user.getPwd();
    }

    @Override
    public boolean ischecking(Session session, String userName, String pwd) throws Exception {
        Query query = session.createQuery("From CfgUsuarios u WHERE u.userName =:userName And u.pwd=:pwd");
        query.setParameter("userName", userName);
        query.setParameter("pwd", pwd);
        CfgUsuarios user = (CfgUsuarios) query.uniqueResult();
        return user != null;
    }

    @Override
    public String obtenerCedula(Session session, String userName) throws Exception {
        Query query = session.createQuery("From CfgUsuarios u WHERE u.userName =:userName");
        query.setParameter("userName", userName);
        CfgUsuarios user = (CfgUsuarios) query.uniqueResult();
        return user.getNombreCom();

    }
    
    

    @Override
    public String Cargo(Session session, String userName) throws Exception {
        Query query = session.createQuery("From CfgUsuarios u WHERE u.userName =:userName");
        query.setParameter("userName", userName);
        CfgUsuarios user = (CfgUsuarios) query.uniqueResult();
        return user.getCargo();    
    
    }
    

}
