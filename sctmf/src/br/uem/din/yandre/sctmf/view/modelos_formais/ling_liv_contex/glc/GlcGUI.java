/*
 * GlcGUI.java
 *
 * Created on 7 de Agosto de 2007, 08:21
 */

package br.uem.din.yandre.sctmf.view.modelos_formais.ling_liv_contex.glc;

import br.uem.din.yandre.sctmf.model.pojo.GLC;
import br.uem.din.yandre.sctmf.model.pojo.ModeloFormal;
import br.uem.din.yandre.sctmf.model.pojo.SimboloString;

/**
 *
 * @author  rafael2009_00
 */
public class GlcGUI 
        extends br.uem.din.yandre.sctmf.view.modelos_formais.ModeloFormalGUI  {
    
    private CadAlfGLC cadAlf = new CadAlfGLC(this);
    private CadFunTransGLC cadFTrans = new CadFunTransGLC();
    private ValSeqGLC valSeq = new ValSeqGLC(this);
    
    /** Creates new form GlcGUI */
    public GlcGUI() {
        initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        tpGlc = new javax.swing.JTabbedPane();
        pCadAlfabetos = new javax.swing.JPanel();
        pCadFuncTrans = new javax.swing.JPanel();
        pValSeq = new javax.swing.JPanel();

        setLayout(new java.awt.GridLayout(1, 0));

        pCadAlfabetos.setLayout(new java.awt.GridLayout(1, 0));

        pCadAlfabetos.add(this.cadAlf);
        tpGlc.addTab("Alfabetos", pCadAlfabetos);

        pCadFuncTrans.setLayout(new java.awt.GridLayout(1, 0));

        pCadFuncTrans.add(this.cadFTrans);
        pCadFuncTrans.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                pCadFuncTransComponentShown(evt);
            }
        });

        tpGlc.addTab("Trasi\u00e7\u00f5es/Simb.Ini", pCadFuncTrans);

        pValSeq.setLayout(new java.awt.GridLayout(1, 0));

        pValSeq.add(this.valSeq);
        pValSeq.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                pValSeqComponentShown(evt);
            }
        });

        tpGlc.addTab("Valida\u00e7\u00e3o", pValSeq);

        add(tpGlc);

    }// </editor-fold>//GEN-END:initComponents

    private void pValSeqComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_pValSeqComponentShown
        this.valSeq.observer((GLC)this.getModeloFormal());
    }//GEN-LAST:event_pValSeqComponentShown

    private void pCadFuncTransComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_pCadFuncTransComponentShown
        this.cadFTrans.observer(cadAlf.getSimbTerminais(),
                cadAlf.getSimNTermimais());        
    }//GEN-LAST:event_pCadFuncTransComponentShown
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel pCadAlfabetos;
    private javax.swing.JPanel pCadFuncTrans;
    private javax.swing.JPanel pValSeq;
    private javax.swing.JTabbedPane tpGlc;
    // End of variables declaration//GEN-END:variables

    public void setModeloFormal(ModeloFormal mf) {
        GLC glc = (GLC)mf;
        
        cadAlf.setSimNTerminais(glc.getSimbNTerm());
        cadAlf.setSimTerminais(glc.getSimbTerm());
        
        cadFTrans.observer(glc.getSimbTerm(),glc.getSimbNTerm());
        cadFTrans.setSimbInicial(glc.getSimbInicial());
        cadFTrans.setProducoes(glc.getRegrasProducao());
                
        tpGlc.setSelectedIndex(0);
    }

    public ModeloFormal getModeloFormal() {
        final GLC glc = new GLC();
        glc.setSimbTerm(cadAlf.getSimbTerminais());
        glc.setSimbNTerm(cadAlf.getSimNTermimais());
        
        this.cadFTrans.observer(
                glc.getSimbTerm(),
                glc.getSimbNTerm()); 
        
        glc.setSimbInicial(cadFTrans.getSimboloInicial());
        glc.setRegrasProducao(cadFTrans.getProducoes());
        
        return glc;
    }
    
    /**
     * Observa o add e remove dos simbolos terminais e nao terminais.
     */
    void addSimbolo(SimboloString s, boolean terminal) {
        this.cadFTrans.getFormaSentencial().adicionaSimbolo(s);
        if (terminal) this.valSeq.getFormaSentencial().adicionaSimbolo(s);
    }
    void removeSimbolo(SimboloString s, boolean terminal) {
        this.cadFTrans.removeSimbolo(s);
        this.valSeq.getFormaSentencial().removeSimbolo(s);
    }
}
