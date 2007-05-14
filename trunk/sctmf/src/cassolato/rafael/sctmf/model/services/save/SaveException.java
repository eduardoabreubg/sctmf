/*
 * SaveException.java
 *
 * Created on 13 de Abril de 2007, 08:58
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package cassolato.rafael.sctmf.model.services.save;

/**
 *
 * @author rafael2009_00
 */
public class SaveException extends Exception {
    
    /** Creates a new instance of SaveException */
    public SaveException(String msg) {
        super(msg);
        javax.swing.JOptionPane.showMessageDialog(null, 
                msg,"Atenção",javax.swing.JOptionPane.WARNING_MESSAGE);
    }
    
}
