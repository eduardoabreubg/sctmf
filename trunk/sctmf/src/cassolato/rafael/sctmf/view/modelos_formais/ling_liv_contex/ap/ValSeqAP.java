/*
 * ValSeqAP.java
 *
 * Created on 19 de Junho de 2007, 09:27
 */

package cassolato.rafael.sctmf.view.modelos_formais.ling_liv_contex.ap;

import cassolato.rafael.sctmf.model.pojo.AP;
import cassolato.rafael.sctmf.model.pojo.Estado;
import cassolato.rafael.sctmf.model.pojo.Simbolo;
import cassolato.rafael.sctmf.model.pojo.TransicaoAP;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author  rafael2009_00
 */
public class ValSeqAP extends javax.swing.JPanel {
    
    private AP ap;
    
    /** Creates new form ValSeqAP */
    public ValSeqAP() {        
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
        validaSequenciaGUI = new cassolato.rafael.sctmf.view.components.ValidaSequenciaGUI();

        setLayout(new java.awt.GridLayout());

        add(validaSequenciaGUI);

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
                this.ap,
                this.validaSequenciaGUI.getSequencia());
    }
    
    /**
     * Atualiza os dados do automato com pilha, da Area de Informações.
     */
    void observerValSeq(AP ap) {
        this.ap = ap;
        
        this.validaSequenciaGUI.clearArea();   
        this.validaSequenciaGUI.setTextAInf(
                "V = <\u03a3,\u0393, S, S\u2080, \u03B4, B>\n");
                
        StringBuffer sb = new StringBuffer();        
        sb.append("\u03a3 = {");  // Add Simbolos
        for(Simbolo s : ap.getSimbolos())
            sb.append(s.getNome()+", ");                
        sb = this.validaSequenciaGUI.formataSb(sb);
                
        sb.append("\u0393 = {");  // Add Simbolos da Pilha
        for(Simbolo s : ap.getSimbolosPilha())
            sb.append(s.getNome()+", ");                
        sb = this.validaSequenciaGUI.formataSb(sb);
        
        sb.append("S = {");
        for(Estado e : ap.getEstados())
            sb.append("<"+e.getNome()+">, ");          
        sb = this.validaSequenciaGUI.formataSb(sb);
                      
        Estado aux = ap.getEstadoInicial();
        sb.append("S\u2080 = <");
        if(aux!=null)
             sb.append(aux.getNome());        
        sb.append(">\n");
        this.validaSequenciaGUI.setTextAInf(sb.toString()
        );
        sb = new StringBuffer();
        
        Simbolo s = ap.getTopoPilha();
        sb.append("B = <");
        if(s!=null)
             sb.append(s.getNome());        
        sb.append(">\n");
        
        for(TransicaoAP t : ap.getTransicoesAP()) {
             sb.append("\n");           // pula a linha
             sb.append("\u03B4(");
             sb.append(t.getEstOri().getNome());
             sb.append(",");
             sb.append(t.getSimbolo().getNome());
             sb.append(",");
             sb.append(t.getSimBasePilha().getNome());
             sb.append(") = {<");
             sb.append(t.getEstDest().getNome());
             sb.append(",");
             for(Simbolo x : t.getEntradaPilha())
                 sb.append(x.getNome());
             sb.append(">}");
        }
        
        this.validaSequenciaGUI.setTextAInf(sb.toString());
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private cassolato.rafael.sctmf.view.components.ValidaSequenciaGUI validaSequenciaGUI;
    // End of variables declaration//GEN-END:variables
    
}
