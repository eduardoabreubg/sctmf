
/*
 * AbrirException.java
 *
 * Created on 13 de Abril de 2007, 10:10
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package cassolato.rafael.sctmf.model.services.abrir;

/**
 *
 * @author rafael2009_00
 */
public class AbrirException extends Exception {
    
    /**
     * Creates a new instance of AbrirException
     */
    public AbrirException(String msg) {
        super(msg);
        javax.swing.JOptionPane.showMessageDialog(null, 
                msg,"Atenção",javax.swing.JOptionPane.WARNING_MESSAGE);
    }
    
}
