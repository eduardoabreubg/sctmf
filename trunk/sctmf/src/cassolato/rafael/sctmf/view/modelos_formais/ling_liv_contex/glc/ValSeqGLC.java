/*
 * ValSeqGLC.java
 *
 * Created on 8 de Agosto de 2007, 08:57
 */

package cassolato.rafael.sctmf.view.modelos_formais.ling_liv_contex.glc;

import cassolato.rafael.sctmf.model.pojo.GLC;
import cassolato.rafael.sctmf.model.pojo.RegraProducao;
import cassolato.rafael.sctmf.model.pojo.Simbolo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author  rafael2009_00
 */
public class ValSeqGLC extends javax.swing.JPanel {
    
    private GLC glc;
    
    /** Creates new form ValSeqGLC */
    public ValSeqGLC() {
        initComponents();
         posInitComponents();
    }
    
    public void observer(GLC glc) {
        this.glc = glc;
        this.validaSequenciaGUI.clearArea();   
         
        this.validaSequenciaGUI.setTextAInf(
                "G = <V, T, P, S>\n");
                
        StringBuffer sb = new StringBuffer();        
        sb.append("V = {");  // Add Simbolos Nao-Terminais
        for(Simbolo s : glc.getSimbNTerm())
            sb.append(s.getNome()+", ");                
        sb = this.validaSequenciaGUI.formataSb(sb);
                
        sb.append("T = {");  // Add Simbolos Terminais
        for(Simbolo s : glc.getSimbTerm())
            sb.append(s.getNome()+", ");                
        sb = this.validaSequenciaGUI.formataSb(sb);
                              
        Simbolo aux = glc.getSimbInicial();
        sb.append("S = <");
        if(aux!=null)
             sb.append(aux.getNome());        
        sb.append(">\n");
        this.validaSequenciaGUI.setTextAInf(sb.toString());
        
        sb = new StringBuffer("P = {");              
        int i = 1;
        for(RegraProducao rp : glc.getRegrasProducao()) {
             sb.append("\n")           // pula a linha
             .append(i+") ")
             .append(rp.getSimbLEsq().getNome())
             .append(" -> ");             
             for(Simbolo x : rp.getSimbLDireito())
                 sb.append(x.getNome());
             
             i++;
        }
        sb.append(glc.getRegrasProducao().size()>0?"\n      }":"}");
        
        this.validaSequenciaGUI.setTextAInf(sb.toString());
        
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        validaSequenciaGUI = new cassolato.rafael.sctmf.view.components.ValidaSequenciaGUI();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        add(validaSequenciaGUI, java.awt.BorderLayout.CENTER);

        jLabel1.setPreferredSize(new java.awt.Dimension(0, 10));
        add(jLabel1, java.awt.BorderLayout.NORTH);

    }// </editor-fold>//GEN-END:initComponents
    
     private void posInitComponents() { 
        this.validaSequenciaGUI.setSplitPaneLocation(115);
       
        this.validaSequenciaGUI.getBValidar().addActionListener(
                new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                validarSequencia();
            }
        });   
        
    }         
     
     private void validarSequencia() {   
        this.validaSequenciaGUI.validarSequencia(
                this.glc, 
                this.validaSequenciaGUI.getSequencia());
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private cassolato.rafael.sctmf.view.components.ValidaSequenciaGUI validaSequenciaGUI;
    // End of variables declaration//GEN-END:variables
    
}
