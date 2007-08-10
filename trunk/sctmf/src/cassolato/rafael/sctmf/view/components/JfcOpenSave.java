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
    
    public static final int SALVAR = 0;
    public static final int ABRIR = 1;
    
    private IdModeloFormal idModeloFormal;
    private int codOperation;
    
    /** Creates new form BeanForm */
    public JfcOpenSave(
            final int codOperation, IdModeloFormal idMF) {        
        
        this.idModeloFormal = idMF;
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
            case ABRIR: 
                this.setDialogTitle("Selecione o Modelo Formal a ser Aberto.");
                this.setFileSelectionMode(FILES_ONLY);   
                
                break;
                
            case SALVAR:
                this.setDialogTitle(                        
                        "Selecione o Diret�rio a ser salvo o Modelo Formal.");
               
                break;
        }
        
        this.setFileFilter(this.getFilter());       
        
    }
    
    public java.io.File getFile() {
        switch(this.codOperation) {
            case ABRIR:
                if(this.showOpenDialog(null) == APPROVE_OPTION) 
                    return this.getSelectedFile();
                
                else                
                    return null;
                                
            case SALVAR:
                if(this.showSaveDialog(null) == APPROVE_OPTION) 
                    return this.getSelectedFile();
                
                else
                    return null;
                
            default : 
                return null;
                
        }
        
    }
    
    private FileNameExtensionFilter getFilter() {
        switch(this.idModeloFormal) {
            case AFD :
                return new FileNameExtensionFilter(
                        "Aut�mato Finito Determin�stico", "afd", "AFD");
                
            case AFND:
                return new FileNameExtensionFilter(
                        "Aut�mato Finito N�o Determin�stico", "afnd", "AFND");
                
            case AP:
                return new FileNameExtensionFilter(
                        "Aut�mato com Pilha", "ap", "AP");
                
             case GLC:
                return new FileNameExtensionFilter(
                        "Gram�tica Livre de Contexto", "glc", "GLC");
                 
            default: return null;
            
        }
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
 }
