/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Clases;

/**
 *
 * @author Jhonbarranco
 */
public class Sentencias {
    
   //funciones especiales
    
    /**
     * Recibe un numero y la cantidad para colocar
     * a la derrecha el num y rellenar espacios con char acordado
     * 11,5,'0'
     * respuesta 00011 
     * @param expresion
     * @param longitud
     * @param cComplemento
     * @return 
     */
     public static String npadl(int expresion, int longitud, char cComplemento ){
        String consec = String.valueOf(expresion);
        int stringLenth = consec.length();
        for(int i=0;i<longitud-stringLenth;i++){
            consec = cComplemento + consec;    
        }
        return consec;
    }
    
    
}
