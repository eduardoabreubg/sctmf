/*
 * ValSeq.java
 *
 * Created on 7 de Maio de 2007, 09:08
 */

package cassolato.rafael.sctmf.view.formalmodels.afd;

/**
 *
 * @author  rafael2009_00
 */
public class ValSeq extends javax.swing.JPanel {
    
    /** Creates new form ValSeq */
    public ValSeq() {
        initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jPanel3 = new javax.swing.JPanel();
        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.X_AXIS));

        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, " Valida\u00e7\u00e3o de Seq\u00fc\u00eancias ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(51, 51, 255)));
        jSplitPane1.setDividerLocation(105);
        jPanel2.setLayout(new java.awt.GridLayout(3, 0));

        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 30));

        jLabel1.setFont(new java.awt.Font("DialogInput", 3, 14));
        jLabel1.setText("Digite a seq\u00fc\u00eancia a ser testada");
        jPanel1.add(jLabel1);

        jPanel2.add(jPanel1);

        jPanel4.setLayout(new java.awt.BorderLayout());

        jLabel5.setPreferredSize(new java.awt.Dimension(34, 10));
        jPanel4.add(jLabel5, java.awt.BorderLayout.NORTH);

        jLabel6.setPreferredSize(new java.awt.Dimension(34, 10));
        jPanel4.add(jLabel6, java.awt.BorderLayout.SOUTH);

        jTextField1.setFont(new java.awt.Font("Bitstream Vera Sans Mono", 0, 24));
        jTextField1.setText("abcdef");
        jPanel4.add(jTextField1, java.awt.BorderLayout.CENTER);

        jLabel7.setPreferredSize(new java.awt.Dimension(20, 14));
        jPanel4.add(jLabel7, java.awt.BorderLayout.EAST);

        jLabel8.setPreferredSize(new java.awt.Dimension(20, 14));
        jPanel4.add(jLabel8, java.awt.BorderLayout.WEST);

        jPanel2.add(jPanel4);

        jPanel5.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 10));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/toolbarButtonGraphics/general/Preferences24.gif")));
        jButton1.setText("Validar");
        jButton1.setPreferredSize(new java.awt.Dimension(150, 40));
        jPanel5.add(jButton1);

        jPanel2.add(jPanel5);

        jSplitPane1.setRightComponent(jPanel2);

        jTextArea1.setRows(5);
        jTextArea1.setText("E = {1,2,2,2}");
        jScrollPane1.setViewportView(jTextArea1);

        jSplitPane1.setLeftComponent(jScrollPane1);

        jPanel3.add(jSplitPane1, java.awt.BorderLayout.CENTER);

        jLabel2.setPreferredSize(new java.awt.Dimension(34, 10));
        jPanel3.add(jLabel2, java.awt.BorderLayout.SOUTH);

        jLabel3.setPreferredSize(new java.awt.Dimension(10, 14));
        jPanel3.add(jLabel3, java.awt.BorderLayout.EAST);

        jLabel4.setPreferredSize(new java.awt.Dimension(10, 14));
        jPanel3.add(jLabel4, java.awt.BorderLayout.WEST);

        add(jPanel3);

    }// </editor-fold>//GEN-END:initComponents
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
    
}
