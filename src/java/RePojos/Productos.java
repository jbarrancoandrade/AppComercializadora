/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package RePojos;

import java.math.BigDecimal;

/**
 *
 * @author Jhonbarranco
 */
public class Productos {
    
    private String nombre;
    private String codIns;
    private String cantInven;
    private String precio;
    private String valIva;

    public Productos() {
    }

    public Productos(String nombre, String codIns, String cantInven, String precio, String valIva) {
        this.nombre = nombre;
        this.codIns = codIns;
        this.cantInven = cantInven;
        this.precio = precio;
        this.valIva = valIva;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodIns() {
        return codIns;
    }

    public void setCodIns(String codIns) {
        this.codIns = codIns;
    }

    public String getCantInven() {
        return cantInven;
    }

    public void setCantInven(String cantInven) {
        this.cantInven = cantInven;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getValIva() {
        return valIva;
    }

    public void setValIva(String valIva) {
        this.valIva = valIva;
    }

   
    
}
