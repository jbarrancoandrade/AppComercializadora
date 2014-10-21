/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BeanView;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Jhonbarranco
 */
@ManagedBean
@SessionScoped
public class ConfigurarDispositivo {
   
    private String text1;
    private String text2;
    
    
    public ConfigurarDispositivo() {
    }
     
    public void save() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Data Saved"));
    }
     
    public void reset() {
        RequestContext.getCurrentInstance().reset("form:panel");
    }

    public String getText1() {
        return text1;
        
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }

    public String getText2() {
        return text2;
    }

    public void setText2(String text2) {
        this.text2 = text2;
    }
    
    
     
   
}
