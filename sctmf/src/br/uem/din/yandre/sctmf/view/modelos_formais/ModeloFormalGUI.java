/*
 * FomalModelGUI.java
 *
 * Created on 11 de Abril de 2007, 09:01
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.uem.din.yandre.sctmf.view.modelos_formais;

import br.uem.din.yandre.sctmf.model.pojo.ModeloFormal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rafael2009_00
 */
public abstract class ModeloFormalGUI extends javax.swing.JPanel{
    protected static final int PREVIOUS = 0;
    protected static final int NEXT = 1;
    
    protected List<String> cardNames = new ArrayList<String>();    
    protected int activeCard;
        
    /** Creates a new instance of FomalModelGUI */
    public ModeloFormalGUI() {
    }
    
    public abstract void setModeloFormal(ModeloFormal mf);
    public abstract ModeloFormal getModeloFormal();
    
}
