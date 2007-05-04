/*
 * CadAlf.java
 *
 * Created on 3 de Maio de 2007, 09:47
 */

package cassolato.rafael.sctmf.view.formalmodels.afd;

/**
 *
 * @author  rafael2009_00
 */
public class CadAlf extends javax.swing.JPanel {
    
    /** Creates new form CadAlf */
    public CadAlf() {
        initComponents();     
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        bAdd = new javax.swing.JButton();
        bRemove = new javax.swing.JButton();
        pCadAlf = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        genericJList = new cassolato.rafael.sctmf.view.components.GenericJList();
        addRemoveButtons = new view.AddRemButtonsPanel();
        letterNumberCA = new view.LetterNumber();

        bAdd.setText("jButton1");
        bAdd = this.addRemoveButtons.getButton(
            this.addRemoveButtons.ADD);
        bAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAddActionPerformed(evt);
            }
        });

        bRemove.setText("jButton1");
        bRemove = this.addRemoveButtons.getButton(
            this.addRemoveButtons.REMOVE);
        bRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRemoveActionPerformed(evt);
            }
        });

        setLayout(new java.awt.GridLayout(1, 0));

        pCadAlf.setLayout(new java.awt.GridBagLayout());

        pCadAlf.setBorder(javax.swing.BorderFactory.createTitledBorder(null, " Cadastro do Alfabeto ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(51, 51, 255)));
        pCadAlf.setMinimumSize(new java.awt.Dimension(420, 240));
        pCadAlf.setPreferredSize(new java.awt.Dimension(420, 240));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jLabel1.setPreferredSize(new java.awt.Dimension(0, 5));
        jPanel3.add(jLabel1, java.awt.BorderLayout.NORTH);

        jLabel3.setPreferredSize(new java.awt.Dimension(35, 0));
        jPanel3.add(jLabel3, java.awt.BorderLayout.EAST);

        jLabel4.setPreferredSize(new java.awt.Dimension(35, 0));
        jPanel3.add(jLabel4, java.awt.BorderLayout.WEST);

        jLabel5.setPreferredSize(new java.awt.Dimension(0, 14));
        jPanel3.add(jLabel5, java.awt.BorderLayout.SOUTH);

        jPanel4.setLayout(new java.awt.BorderLayout());

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 18));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("\u03a3");
        jPanel4.add(jLabel6, java.awt.BorderLayout.NORTH);

        jPanel4.add(genericJList, java.awt.BorderLayout.CENTER);

        jPanel3.add(jPanel4, java.awt.BorderLayout.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.ipadx = 126;
        gridBagConstraints.ipady = 173;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(24, 6, 3, 0);
        pCadAlf.add(jPanel3, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(79, 4, 0, 0);
        pCadAlf.add(addRemoveButtons, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 28, 0, 30);
        pCadAlf.add(letterNumberCA, gridBagConstraints);

        add(pCadAlf);

    }// </editor-fold>//GEN-END:initComponents

    private void bRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRemoveActionPerformed
        this.genericJList.removeItens();         
    }//GEN-LAST:event_bRemoveActionPerformed

    private void bAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAddActionPerformed
          this.genericJList.addItem(
                this.letterNumberCA.getLetter());
    }//GEN-LAST:event_bAddActionPerformed
      
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private view.AddRemButtonsPanel addRemoveButtons;
    private javax.swing.JButton bAdd;
    private javax.swing.JButton bRemove;
    private cassolato.rafael.sctmf.view.components.GenericJList genericJList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private view.LetterNumber letterNumberCA;
    private javax.swing.JPanel pCadAlf;
    // End of variables declaration//GEN-END:variables
    
}
