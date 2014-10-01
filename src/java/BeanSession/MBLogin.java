/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanSession;

import Dao.Dao_User;
import Dao.Dao_vendedor;
import Util.HibernateUtil;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Jhonbarranco
 */
@ManagedBean
@SessionScoped
public class MBLogin implements Serializable {

    private final Dao_User dao_User;
    private final Dao_vendedor dao_vendedor;
    

    private String username;

    private String password;
    private Session session;
    private Transaction transaccion;
    private String baul, cargo;

    /**
     * Creates a new instance of MBLogin
     */
    public MBLogin() {
        HttpSession miSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        miSession.setMaxInactiveInterval(5000);
        //
        dao_User = new Dao_User();
        dao_vendedor = new Dao_vendedor();
        baul = "UsuarioDefecto";
        cargo = "";

    }
    
    /**
     * Verifica las credenciales permitiendo el acceso si todo es correcto
     * @param event
     * @return 
     */
    public void login(ActionEvent event) {
        this.session = null;
        this.transaccion = null;

        try {

            this.session = HibernateUtil.getSessionFactory().openSession();
            this.transaccion = this.session.beginTransaction();
            ExternalContext ctx = FacesContext.getCurrentInstance().getExternalContext();
            String ctxPath = ((ServletContext) ctx.getContext()).getContextPath();

            boolean tUsuario = dao_User.isValidUserName(this.session, this.username);
            //Encrypt.sha512
            if (tUsuario == true) {
                if (dao_User.Contraseña(this.session, this.username).isEmpty()) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error de acceso:", "Usuario sin contraseña/ prueba solamente"));
                    

                } else {
                    
                    if (dao_User.ischecking(this.session, this.username, this.password)) {
                        
                        HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
                        httpSession.setAttribute("NombreVendedor", dao_User.obtenerCedula(this.session, this.username));
                        this.baul = dao_User.obtenerCedula(this.session, this.username);
                        this.cargo = dao_User.Cargo(this.session, this.username);
                        httpSession.setAttribute("codven", dao_vendedor.getByNombre(this.session, dao_User.obtenerCedula(this.session, this.username)));
                        ctx.redirect(ctxPath + "/faces/Menu/Principal.xhtml");
                        
                    }
                }

            }

            this.transaccion.commit();

            this.username = null;
            this.password = null;

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error de acceso:", "Usuario o contraseña incorrecto"));

         

        } catch (Exception ex) {
            if (this.transaccion != null) {
                this.transaccion.rollback();
            }

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error fatal:", "Por favor contacte con su administrador " + ex.getMessage()));

          
        } finally {
            if (this.session != null) {
                this.session.close();
            }
        }
    }
    

    
    public String cerrarSesion(ActionEvent event) {
        this.username = null;
        this.password = null;

        HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        httpSession.invalidate();

        return "/Login";
    }
    
    
    public  String obtenerMacWin(){
       
       return "Ip : ";
    }
    
    


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBaul() {
        return baul;
    }

    public void setBaul(String baul) {
        this.baul = baul;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void onIdle() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, 
                                        "No activity.", "What are you doing over there?"));
    }
 
    public void onActive() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
                                        "Welcome Back", "Well, that's a long coffee break!"));
    }
}
