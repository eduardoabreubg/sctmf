/*
 * SalvarException.java
 *
 * Created on 13 de Abril de 2007, 08:58
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.uem.din.yandre.sctmf.model.services.salvar;

/**
 *
 * @author rafael2009_00
 */
public class SalvarException extends Exception {
    
    /**
     * Creates a new instance of SalvarException
     */
    public SalvarException(String msg) {
        super(msg);
        javax.swing.JOptionPane.showMessageDialog(null, 
                msg,"Atenção",javax.swing.JOptionPane.WARNING_MESSAGE);
    }
    
}
