/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Clases;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jhonbarranco
 */
@WebFilter("*.xhtml")
public class SessionUrlFilter implements Filter{

    FilterConfig filterConfig;
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig=filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req=(HttpServletRequest) request;
        HttpServletResponse res=(HttpServletResponse) response;
        HttpSession session=req.getSession(true);
        
        String requestUrl=req.getRequestURL().toString();
        
        //si no existe sesion esta seran las url permitidas 
        String[] urlPermitidaSinSesion=new String[]
        {
            "faces/Login.xhtml"
            
        };
        
        boolean redireccionarPeticion;
       //verificamos si hay una session activa
        if(session.getAttribute("NombreVendedor")==null)
        {            
            redireccionarPeticion=true;
           
            
            for(String item : urlPermitidaSinSesion)
            {
                if(requestUrl.contains(item))
                {
                    redireccionarPeticion=false;
                    
                    break;
                }
            }
        }
        else
        {
            redireccionarPeticion=false;
            //si hay session no se permitira al usuario estar en la paguina de loguin hasta que halla finalizado la session actual de su equipo
            if(requestUrl.equalsIgnoreCase("http://localhost:8090/AppComercializadora/faces/Login.xhtml") || requestUrl.equalsIgnoreCase("http://localhost:8090/AppComercializadora/")){
                res.sendRedirect(req.getContextPath()+"/faces/Menu/Principal.xhtml");
                
            }
        }
        //si la no hay session, debera ser obligado a ir al login
        if(redireccionarPeticion)
        {
            res.sendRedirect(req.getContextPath()+"/faces/Login.xhtml");
            
        }
        else
        {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
        this.filterConfig=null;
    }
    
}
