/*
 * ValSeqMT.java
 *
 * Created on 23 de Agosto de 2007, 09:06
 */

package br.uem.din.yandre.sctmf.view.modelos_formais.ling_enum_rec.mt;

import br.uem.din.yandre.sctmf.model.pojo.Direcao;
import br.uem.din.yandre.sctmf.model.pojo.Estado;
import br.uem.din.yandre.sctmf.model.pojo.MT;
import br.uem.din.yandre.sctmf.model.pojo.Simbolo;
import br.uem.din.yandre.sctmf.model.pojo.TransicaoMT;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author  rafael2009_00
 */
public class ValSeqMT extends javax.swing.JPanel {
    private MtGUI gui = null;
    
    /** Creates new form ValSeqMT */
    public ValSeqMT(MtGUI gui) {
        this.gui = gui;
        initComponents();
        posInitComponents(); 
    }
    
    void observer(MT mt) {
        this.validaSequenciaGUI.clearArea();   
        this.validaSequenciaGUI.setTextAInf(
                "M = \u03a3, Q, \u03B4, q\u2080, F, V, \u03B2, <\n");
                
        StringBuffer sb = new StringBuffer();        
        sb.append("\u03a3 = {");  // Add Simbolos
        for(Simbolo s : mt.getAlfabeto())
            sb.append(s.getNome()+", ");                
        sb = this.validaSequenciaGUI.formataSb(sb);
                
        sb.append("Q = {"); // Add Estados
        for(Estado e : mt.getEstados())
            sb.append(e.getNome()+", ");          
        sb = this.validaSequenciaGUI.formataSb(sb);
        
        Estado aux = mt.getEstIni(); // Estado Inicial
        sb.append("Q\u2080 = ");
        if(aux!=null)
             sb.append(aux.getNome());        
        sb.append("\n");
        this.validaSequenciaGUI.setTextAInf(sb.toString());
        
        sb = new StringBuffer();
        
        sb.append("F = {"); // Add Estados FInais
        for(Estado e : mt.getEstFinais())
            sb.append(e.getNome()+", ");          
        sb = this.validaSequenciaGUI.formataSb(sb);
        
        sb.append("V = {");  // Add Simbolos da Pilha
        for(Simbolo s : mt.getAlfabetoAux())
            sb.append(s.getNome()+", ");                
        sb = this.validaSequenciaGUI.formataSb(sb);
                        
        for(TransicaoMT t : mt.getTransicoes()) {
             sb.append("\n")           // pula a linha
             .append("\u03B4(")
             .append(t.getEstAtual().getNome())
             .append(",")
             .append(t.getSimLido().getNome())
             .append(") -> (")            
             .append(t.getEstDestino().getNome())             
             .append(" ,")
             .append(t.getSimbEscrito().getNome())             
             .append(" ,")
             .append(t.getDirecao()==Direcao.ESQUERDA?"E":"D")
             .append(")");             
        }
        
        this.validaSequenciaGUI.setTextAInf(sb.toString());
        
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        validaSequenciaGUI = new br.uem.din.yandre.sctmf.view.components.ValidaSequenciaGUI();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        add(validaSequenciaGUI, java.awt.BorderLayout.CENTER);

        jLabel1.setPreferredSize(new java.awt.Dimension(0, 10));
        add(jLabel1, java.awt.BorderLayout.NORTH);

    }// </editor-fold>//GEN-END:initComponents
    
     private void posInitComponents() { 
        this.validaSequenciaGUI.setSplitPaneLocation(150);
       
        this.validaSequenciaGUI.getBValidar().addActionListener(
                new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                validarSequencia();
            }
        });   
        
    }         
     
    private void validarSequencia() {
        this.validaSequenciaGUI.validarSequencia(
                (MT)this.gui.getModeloFormal(),
                this.validaSequenciaGUI.getSequencia());
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private br.uem.din.yandre.sctmf.view.components.ValidaSequenciaGUI validaSequenciaGUI;
    // End of variables declaration//GEN-END:variables
    
}
