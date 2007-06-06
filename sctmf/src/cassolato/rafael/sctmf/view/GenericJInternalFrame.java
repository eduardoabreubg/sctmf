/*
 * GenericJInternalFrame.java
 *
 * Created on 10 de Fevereiro de 2007, 15:44
 */

package cassolato.rafael.sctmf.view;

import cassolato.rafael.sctmf.control.Controller;
import cassolato.rafael.sctmf.model.pojo.ModeloFormal;
import cassolato.rafael.sctmf.view.components.JfcOpenSave;
import cassolato.rafael.sctmf.view.modelos_formais.ModeloFormalGUI;

/**
 *
 * @author  Cassolato
 */
public class GenericJInternalFrame extends javax.swing.JInternalFrame {
    
    private Controller ctrl;
    private ModeloFormalGUI gui;
    private IdModeloFormal idMF;
    
    /** Creates new form GenericJInternalFrame */
    public GenericJInternalFrame(Controller ctrl, IdModeloFormal idMF) {
        this.ctrl = ctrl;
        this.idMF = idMF;
        
        initComponents();
        this.posInitComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        bOpen = new javax.swing.JButton();
        bSave = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setMinimumSize(new java.awt.Dimension(460, 350));
        setPreferredSize(new java.awt.Dimension(460, 350));
        jLabel2.setPreferredSize(new java.awt.Dimension(0, 5));
        getContentPane().add(jLabel2, java.awt.BorderLayout.SOUTH);

        jLabel3.setPreferredSize(new java.awt.Dimension(15, 14));
        getContentPane().add(jLabel3, java.awt.BorderLayout.EAST);

        jLabel4.setPreferredSize(new java.awt.Dimension(15, 0));
        getContentPane().add(jLabel4, java.awt.BorderLayout.WEST);

        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 10, 5));

        bOpen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/toolbarButtonGraphics/general/Open24.gif")));
        bOpen.setToolTipText("Abir Modelo");
        bOpen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bOpen.setPreferredSize(new java.awt.Dimension(35, 33));
        bOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bOpenActionPerformed(evt);
            }
        });

        jPanel1.add(bOpen);

        bSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/toolbarButtonGraphics/general/Save24.gif")));
        bSave.setToolTipText("Salvar Modelo");
        bSave.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bSave.setPreferredSize(new java.awt.Dimension(35, 33));
        bSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSaveActionPerformed(evt);
            }
        });

        jPanel1.add(bSave);

        jLabel1.setPreferredSize(new java.awt.Dimension(15, 0));
        jPanel1.add(jLabel1);

        getContentPane().add(jPanel1, java.awt.BorderLayout.NORTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void bOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bOpenActionPerformed
        JfcOpenSave fc = new JfcOpenSave(
                JfcOpenSave.ABRIR, this, this.idMF);
        
        // Envia para o Controller o Arquivo selecionado
        // e recebe o objeto correspondente
        java.io.File arquivo = fc.getFile();
        if(arquivo!=null) {
            ModeloFormal mf = this.ctrl.abrirModeloFormal(arquivo);
            // Envia pra a gui setar o Modelo Formal caso ele n�o esteja null
            if(mf!=null)
                this.gui.setModeloFormal(mf);
        }
    }//GEN-LAST:event_bOpenActionPerformed
    
    private void bSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSaveActionPerformed
        JfcOpenSave fc = new JfcOpenSave(
                JfcOpenSave.SALVAR, this, this.idMF);
        
        java.io.File arquivo = fc.getFile();
        if(arquivo!=null)            
            this.ctrl.salvarModeloFormal(arquivo, this.gui.getModeloFormal());
        
    }//GEN-LAST:event_bSaveActionPerformed
    
    private void posInitComponents() {
        switch(this.idMF) {
            case AFD :
                this.setTitle("AFD - Aut�matos Finitos Determin�sticos");
                break;
                
            case AFND :
                this.setTitle("AFND - Aut�matos Finitos N�o Determin�sticos");
                break;
                
            case AP :
                this.setTitle("AP - Aut�matos Com Pilha");
                break;
                
        }
        
        this.gui = GUIFactory.getInstanceMF(this.idMF);
        getContentPane().add(this.gui,java.awt.BorderLayout.CENTER);
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bOpen;
    private javax.swing.JButton bSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
    
}
