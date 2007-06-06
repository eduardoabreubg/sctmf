/*
 * JfcOpenSave.java
 *
 * Created on 16 de Abril de 2007, 08:34
 */

package cassolato.rafael.sctmf.view.components;

import cassolato.rafael.sctmf.model.pojo.AFD;
import cassolato.rafael.sctmf.model.pojo.AFND;
import cassolato.rafael.sctmf.view.*;
import java.awt.Component;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author  rafael2009_00
 */
public class JfcOpenSave extends javax.swing.JFileChooser {
    
    public static final int SAVE = 0;
    public static final int OPEN = 1;
    
    private Component c;
    private IdModeloFormal idFormalModel;
    private int codOperation;
    
    /** Creates new form BeanForm */
    public JfcOpenSave(
            final int codOperation, final Component c, IdModeloFormal idFM) {        
        this.c = c;
        this.idFormalModel = idFM;
        this.codOperation = codOperation;
        
        initComponents();
        this.posInitCompoents();        
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {

    }// </editor-fold>//GEN-END:initComponents
    
    private void posInitCompoents() {
        this.setLocale(new java.util.Locale("pt","BR"));
        switch(this.codOperation) {
            case OPEN: 
                this.setDialogTitle("Selecione o Modelo Formal a ser Aberto.");
                this.setFileSelectionMode(FILES_ONLY);   
                
                break;
                
            case SAVE:
                this.setDialogTitle(                        
                        "Selecione o Diret�rio a ser salvo o Modelo Formal.");
                this.setFileSelectionMode(DIRECTORIES_ONLY);
                
                break;
        }
        
        this.setFileFilter(this.getFilter());       
        
    }
    
    public java.io.File getFile() {
        switch(this.codOperation) {
            case OPEN:
                if(this.showOpenDialog(this.c) == APPROVE_OPTION) 
                    return this.getSelectedFile();
                
                else                
                    return null;
                                
            case SAVE:
                if(this.showSaveDialog(this.c) == APPROVE_OPTION) 
                    return this.getSelectedFile();
                
                else
                    return null;
                
            default : 
                return null;
                
        }
        
    }
    
    private FileNameExtensionFilter getFilter() {
        switch(this.idFormalModel) {
            case AFD :
                return new FileNameExtensionFilter(
                        "Aut�mato Finito Determin�stico", "afd", "AFD");
                
            case AFND:
                return new FileNameExtensionFilter(
                        "Aut�mato Finito N�o Determin�stico", "afnd", "AFND");
                 
            default: return null;
            
        }
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
 }
