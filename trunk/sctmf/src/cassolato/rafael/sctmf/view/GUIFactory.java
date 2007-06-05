/*
 * GUIFactory.java
 *
 * Created on 11 de Abril de 2007, 08:30
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package cassolato.rafael.sctmf.view;

import cassolato.rafael.sctmf.view.formalmodels.ling_liv_contex.ap.ApGUI;
import cassolato.rafael.sctmf.view.formalmodels.ling_reg.afd.AfdGUI;
import cassolato.rafael.sctmf.view.formalmodels.ling_reg.afnd.AfndGUI;


/**
 *
 * @author rafael2009_00
 */
public class GUIFactory {
    
    /** Creates a new instance of GUIFactory */
    private GUIFactory() {
    }
    
    public static FormalModelGUI getInstanceFM(IdFormalModel fm) {
        switch(fm) {
            case AFD : 
                return new AfdGUI();
             
            case AFND : 
                return new AfndGUI();
                
            case AP : 
                return new ApGUI();
                
            default : 
                return null;
        }
    }
    
}
