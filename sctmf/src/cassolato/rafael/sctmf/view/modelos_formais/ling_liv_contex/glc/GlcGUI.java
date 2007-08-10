/*
 * GlcGUI.java
 *
 * Created on 7 de Agosto de 2007, 08:21
 */

package cassolato.rafael.sctmf.view.modelos_formais.ling_liv_contex.glc;

import cassolato.rafael.sctmf.model.pojo.GLC;
import cassolato.rafael.sctmf.model.pojo.ModeloFormal;
import cassolato.rafael.sctmf.model.pojo.Simbolo;

/**
 *
 * @author  rafael2009_00
 */
public class GlcGUI 
        extends cassolato.rafael.sctmf.view.modelos_formais.ModeloFormalGUI  {
    
    private CadAlfGLC cadAlf = new CadAlfGLC(this);
    private CadFunTransGLC cadFTrans = new CadFunTransGLC();
    private ValSeqGLC valSeq = new ValSeqGLC();
    
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
        jTabbedPane1 = new javax.swing.JTabbedPane();
        pCadAlfabetos = new javax.swing.JPanel();
        pCadFuncTrans = new javax.swing.JPanel();
        pValSeq = new javax.swing.JPanel();

        setLayout(new java.awt.GridLayout(1, 0));

        pCadAlfabetos.setLayout(new java.awt.GridLayout(1, 0));

        pCadAlfabetos.add(this.cadAlf);
        jTabbedPane1.addTab("Alfabetos", pCadAlfabetos);

        pCadFuncTrans.setLayout(new java.awt.GridLayout(1, 0));

        pCadFuncTrans.add(this.cadFTrans);
        pCadFuncTrans.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                pCadFuncTransComponentShown(evt);
            }
        });

        jTabbedPane1.addTab("Trasi\u00e7\u00f5es/Simb.Ini", pCadFuncTrans);

        pValSeq.setLayout(new java.awt.GridLayout(1, 0));

        pValSeq.add(this.valSeq);
        jTabbedPane1.addTab("Valida\u00e7\u00e3o", pValSeq);

        add(jTabbedPane1);

    }// </editor-fold>//GEN-END:initComponents

    private void pCadFuncTransComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_pCadFuncTransComponentShown
        this.cadFTrans.observer(cadAlf.getSimbTerminais(),
                cadAlf.getSimNTermimais());        
    }//GEN-LAST:event_pCadFuncTransComponentShown
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel pCadAlfabetos;
    private javax.swing.JPanel pCadFuncTrans;
    private javax.swing.JPanel pValSeq;
    // End of variables declaration//GEN-END:variables

    public void setModeloFormal(ModeloFormal mf) {
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
     * Observa o add e remove dos simbolos terminais e nao terminais
     * o parametro status, se for true, indica que � um simbolo terminal
     * se for false, um simbolo nao terminal
     * o parametro oper pode ser 0 que indica um add e um 1 que indica um remove
     */
    void addRemoveSimbolo(Simbolo s, int oper, boolean status) {
        
    }
}
