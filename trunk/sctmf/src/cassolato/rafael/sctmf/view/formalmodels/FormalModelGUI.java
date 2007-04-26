/*
 * FomalModelGUI.java
 *
 * Created on 11 de Abril de 2007, 09:01
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package cassolato.rafael.sctmf.view;

import cassolato.rafael.sctmf.model.pojo.FormalModel;

/**
 *
 * @author rafael2009_00
 */
public abstract class FormalModelGUI extends javax.swing.JPanel{
    
    /** Creates a new instance of FomalModelGUI */
    public FormalModelGUI() {
    }
    
    public abstract void setFormalModel(FormalModel fm);
    public abstract FormalModel getFormalModel(); 
    
}
