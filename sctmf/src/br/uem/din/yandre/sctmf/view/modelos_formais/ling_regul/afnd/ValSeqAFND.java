/*
 * ValSeqAFND.java
 *
 * Created on 21 de Junho de 2007, 09:01
 */

package br.uem.din.yandre.sctmf.view.modelos_formais.ling_regul.afnd;

import br.uem.din.yandre.sctmf.model.pojo.AFND;
import br.uem.din.yandre.sctmf.model.pojo.Estado;
import br.uem.din.yandre.sctmf.model.pojo.Simbolo;
import br.uem.din.yandre.sctmf.model.pojo.Transicao;

/**
 *
 * @author  rafael2009_00
 */
public class ValSeqAFND extends javax.swing.JPanel {
    private AfndGUI gui = null;
    
    /** Creates new form ValSeqAFND */
    public ValSeqAFND(AfndGUI gui) {
        this.gui = gui;
        initComponents();
        posInitComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        validaSequenciaGUI = new br.uem.din.yandre.sctmf.view.components.ValidaSequenciaGUI();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.X_AXIS));

        setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "Valida\u00e7\u00e3o de Sequ\u00eancias", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(51, 51, 255))));
        add(validaSequenciaGUI);

    }// </editor-fold>//GEN-END:initComponents
    
    private void posInitComponents() { 
        this.validaSequenciaGUI.setSplitPaneLocation(115);
       
        this.validaSequenciaGUI.getBValidar().addActionListener(
                new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                validarSequencia();
            }
        });            
    }
     
    private void validarSequencia() {        
        this.validaSequenciaGUI.validarSequencia(
                (AFND)this.gui.getModeloFormal(),
                this.validaSequenciaGUI.getSequencia());
    }
    
    /**
     * Atualiza os dados do automato com pilha, da Area de Informações.
     */
    void observerValSeq(AFND afnd) {   
        this.validaSequenciaGUI.clearArea();   
        this.validaSequenciaGUI.setTextAInf(
                "V = \u03a3, S, S\u2080, \u03B4, F\n");
                
        StringBuffer sb = new StringBuffer();
        
        sb.append("\u03a3 = {");  // Add Simbolos
        for(Simbolo s : afnd.getSimbolos())
            sb.append(s.getNome()+", ");                
        sb = this.validaSequenciaGUI.formataSb(sb);
                
        sb.append("S = {");
        for(Estado e : afnd.getEstados())
            sb.append(e.getNome()+", ");          
        sb = this.validaSequenciaGUI.formataSb(sb);
               
        
        sb.append("S\u2080 = {");
        for(Estado ef : afnd.getEstadosIniciais())            
            sb.append(ef.getNome()+", ");        
        sb = this.validaSequenciaGUI.formataSb(sb);
        
        sb.append("F = {");
       for(Estado e : afnd.getEstadosFinais())
            sb.append(e.getNome()+", "); 
        sb = this.validaSequenciaGUI.formataSb(sb);        
        
        for(Transicao t : afnd.getTransicoes()) {
            sb.append("\n");
            sb.append("\u03B4(");
            sb.append(t.getEstOri().getNome());
            sb.append(", ");
            sb.append(t.getSimbolo().getNome());
            sb.append(") = ");
            sb.append(t.getEstDest().getNome());
            sb.append("");
        }         
                
        this.validaSequenciaGUI.setTextAInf(sb.toString());
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private br.uem.din.yandre.sctmf.view.components.ValidaSequenciaGUI validaSequenciaGUI;
    // End of variables declaration//GEN-END:variables
    
}
