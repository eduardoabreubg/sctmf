/*
 * GUIFactory.java
 *
 * Created on 11 de Abril de 2007, 08:30
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package cassolato.rafael.sctmf.view;

import cassolato.rafael.sctmf.view.modelos_formais.ling_enum_rec.mt.MtGUI;
import cassolato.rafael.sctmf.view.modelos_formais.ling_liv_contex.glc.GlcGUI;
import cassolato.rafael.sctmf.view.modelos_formais.ling_regul.afd.AfdGUI;
import cassolato.rafael.sctmf.view.modelos_formais.ling_regul.afnd.AfndGUI;
import cassolato.rafael.sctmf.view.modelos_formais.ling_liv_contex.ap.ApGUI;
import cassolato.rafael.sctmf.view.modelos_formais.ModeloFormalGUI;


/**
 *
 * @author rafael2009_00
 */
public class GUIFactory {
    
    /** Creates a new instance of GUIFactory */
    private GUIFactory() {
    }
    
    public static ModeloFormalGUI getInstanceMF(IdModeloFormal mf) {
        switch(mf) {
            case AFD : 
                return new AfdGUI();
             
            case AFND : 
                return new AfndGUI();
                
            case AP : 
                return new ApGUI();
                
           case GLC : 
                return new GlcGUI();
                
           case MT : 
                return new MtGUI();     
                
            default : 
                return null;
        }
    }
    
}
