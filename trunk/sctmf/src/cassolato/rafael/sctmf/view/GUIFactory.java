/*
 * GUIFactory.java
 *
 * Created on 11 de Abril de 2007, 08:30
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package cassolato.rafael.sctmf.view;

import cassolato.rafael.sctmf.view.formalmodels.AfdGUI;

/**
 *
 * @author rafael2009_00
 */
public class GUIFactory {
    
    /** Creates a new instance of GUIFactory */
    public GUIFactory() {
    }
    
    public static FormalModelGUI getInstanceFM(int fm) {
        switch(fm) {
            case IdFormalModels.AFD : 
                return new AfdGUI();
             
            case IdFormalModels.AFND : 
                return new AfdGUI();
                
            default : 
                return null;
        }
    }
    
}
