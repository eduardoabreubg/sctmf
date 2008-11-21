
/*
 * JMain.java
 *
 * Created on 10 de Fevereiro de 2007, 12:52
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.uem.din.yandre.sctmf;

import br.uem.din.yandre.sctmf.control.Controller;

/**
 *
 * @author Cassolato
 */
public class JMain {
    
    /** Creates a new instance of Main */
    public JMain() {        
        new Controller();       
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new JMain();
    }
        
}