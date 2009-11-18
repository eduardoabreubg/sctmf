/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SimbolosAtribuicao.java
 *
 * Created on 18/11/2009, 12:39:07
 */
package br.uem.din.yandre.sctmf.view.modelos_formais.ling_enum_rec.post;

import br.uem.din.yandre.sctmf.model.pojo.Simbolo;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Administrador
 */
public class SimbolosAtribuicao extends javax.swing.JDialog {

    private PostGUI post;
    private Set<Simbolo> simbolos = new HashSet<Simbolo>();
    private Character retorno = null;

    /** Creates new form SimbolosAtribuicao */
    public SimbolosAtribuicao(java.awt.Frame parent, boolean modal, PostGUI post) {
        super(parent, modal);
        initComponents();
        this.post = post;
        for (Simbolo s : post.getSimbolos()) {
            this.cbSimbolos.addItem(s.getNome());
            this.simbolos.add(s);
        }
        this.cbSimbolos.addItem('#');
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cbSimbolos = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        cbOk = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle(org.openide.util.NbBundle.getMessage(SimbolosAtribuicao.class, "SimbolosAtribuicao.title")); // NOI18N
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.add(cbSimbolos);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        cbOk.setText(org.openide.util.NbBundle.getMessage(SimbolosAtribuicao.class, "SimbolosAtribuicao.cbOk.text")); // NOI18N
        cbOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbOkActionPerformed(evt);
            }
        });
        jPanel2.add(cbOk);

        getContentPane().add(jPanel2, java.awt.BorderLayout.SOUTH);

        jLabel2.setText(org.openide.util.NbBundle.getMessage(SimbolosAtribuicao.class, "SimbolosAtribuicao.jLabel2.text")); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 342, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(0, 40, Short.MAX_VALUE)
                    .addComponent(jLabel2)
                    .addGap(0, 40, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 14, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel2)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        getContentPane().add(jPanel3, java.awt.BorderLayout.NORTH);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-350)/2, (screenSize.height-130)/2, 350, 130);
    }// </editor-fold>//GEN-END:initComponents

    private void cbOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbOkActionPerformed
        System.out.println("cb " + cbSimbolos.getSelectedItem().toString());
        setRetorno(cbSimbolos.getSelectedItem().toString().charAt(0));
        this.dispose();
    }//GEN-LAST:event_cbOkActionPerformed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cbOk;
    private javax.swing.JComboBox cbSimbolos;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables

    public Character getRetorno() {
        return retorno;
    }

    public void setRetorno(Character retorno) {
        this.retorno = retorno;
    }

    @Override
    public void setVisible(boolean b) {
        for (Simbolo s : post.getSimbolos()) {
            if ((!this.simbolos.contains(s))) {
                this.cbSimbolos.addItem(s.getNome());
            }
        }
        super.setVisible(b);

    }
}
