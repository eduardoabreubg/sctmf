/*
 * AfdGUI.java
 *
 * Created on 4 de Abril de 2007, 09:41
 */

package cassolato.rafael.sctmf.view.formalmodels;

import cassolato.rafael.sctmf.model.pojo.AFD;
import cassolato.rafael.sctmf.model.pojo.FormalModel;
import cassolato.rafael.sctmf.view.FormalModelGUI;
import java.util.Iterator;
import java.util.Vector;
import javax.swing.DefaultListModel;
import javax.swing.ListModel;

/**
 *
 * @author  rafael2009_00
 */
public class AfdGUI extends FormalModelGUI {
    
    /** Creates new form AfdGUI */
    public AfdGUI() {
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
        pRolagem = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        pCard = new javax.swing.JPanel();
        pCadAlf = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listAlf = new javax.swing.JList();
        addRemoveButtons = new view.AddRemButtonsPanel();
        letterNumberCA = new view.LetterNumber();
        pCadEst = new javax.swing.JPanel();
        pNort = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        letterNumber2 = new view.LetterNumber();
        jPanel10 = new javax.swing.JPanel();
        addRemButtonsPanel3 = new view.AddRemButtonsPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jList6 = new javax.swing.JList();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        pSul = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jPanel7 = new javax.swing.JPanel();
        addRemButtonsPanel1 = new view.AddRemButtonsPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        pCadFuncTrans = new javax.swing.JPanel();

        bAdd.setText("jButton3");
        bAdd = addRemoveButtons.getButton(addRemoveButtons.ADD);
        bAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAddActionPerformed(evt);
            }
        });

        bRemove.setText("jButton3");
        bRemove = addRemoveButtons.getButton(addRemoveButtons.REMOVE);
        bRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRemoveActionPerformed(evt);
            }
        });

        setLayout(new java.awt.BorderLayout());

        pRolagem.setLayout(new java.awt.GridLayout(1, 4, 20, 0));

        jButton2.setText("<<");
        pRolagem.add(jButton2);

        pRolagem.add(jLabel2);

        jButton1.setText(">>");
        pRolagem.add(jButton1);

        add(pRolagem, java.awt.BorderLayout.SOUTH);

        pCard.setLayout(new java.awt.CardLayout());

        pCadAlf.setLayout(new java.awt.GridBagLayout());

        pCadAlf.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED), " Cadastro do Alfabeto ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(51, 51, 255)));
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
        jLabel6.setText("E");
        jPanel4.add(jLabel6, java.awt.BorderLayout.NORTH);

        listAlf.setBackground(new java.awt.Color(247, 247, 214));
        listAlf.setFont(new java.awt.Font("Tahoma", 0, 14));
        listAlf.setValueIsAdjusting(true);
        jScrollPane1.setViewportView(listAlf);

        jPanel4.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel3.add(jPanel4, java.awt.BorderLayout.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 111;
        gridBagConstraints.ipady = 172;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(15, 8, 8, 1);
        pCadAlf.add(jPanel3, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(40, 28, 0, 0);
        pCadAlf.add(addRemoveButtons, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 31, 0, 17);
        pCadAlf.add(letterNumberCA, gridBagConstraints);

        pCard.add(pCadAlf, "card2");

        pCadEst.setLayout(new java.awt.GridLayout(2, 0));

        pCadEst.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), " Cadastro de Estados ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(51, 51, 255)));
        pNort.setLayout(new javax.swing.BoxLayout(pNort, javax.swing.BoxLayout.X_AXIS));

        pNort.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pNort.setMinimumSize(new java.awt.Dimension(40, 40));
        pNort.setPreferredSize(new java.awt.Dimension(30, 40));
        jPanel16.add(letterNumber2);

        pNort.add(jPanel16);

        addRemButtonsPanel3.setPreferredSize(new java.awt.Dimension(59, 100));
        jPanel10.add(addRemButtonsPanel3);

        pNort.add(jPanel10);

        jPanel11.setLayout(new java.awt.BorderLayout());

        jPanel11.setMinimumSize(new java.awt.Dimension(50, 42));
        jLabel13.setFont(new java.awt.Font("Verdana", 1, 14));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Estados");
        jPanel11.add(jLabel13, java.awt.BorderLayout.NORTH);

        jScrollPane6.setPreferredSize(new java.awt.Dimension(37, 40));
        jList6.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jList6.setPreferredSize(new java.awt.Dimension(33, 50));
        jScrollPane6.setViewportView(jList6);

        jPanel11.add(jScrollPane6, java.awt.BorderLayout.CENTER);

        jLabel14.setPreferredSize(new java.awt.Dimension(40, 0));
        jPanel11.add(jLabel14, java.awt.BorderLayout.WEST);

        jLabel15.setPreferredSize(new java.awt.Dimension(40, 0));
        jPanel11.add(jLabel15, java.awt.BorderLayout.EAST);

        pNort.add(jPanel11);

        pCadEst.add(pNort);

        pSul.setLayout(new java.awt.GridLayout(1, 2));

        pSul.setPreferredSize(new java.awt.Dimension(10, 150));
        jPanel9.setLayout(new java.awt.BorderLayout());

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), " Estado Inicial ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(19, 92, 34)));
        jLabel8.setPreferredSize(new java.awt.Dimension(0, 5));
        jPanel9.add(jLabel8, java.awt.BorderLayout.SOUTH);

        jLabel9.setPreferredSize(new java.awt.Dimension(10, 0));
        jPanel9.add(jLabel9, java.awt.BorderLayout.WEST);

        jPanel5.setLayout(new java.awt.GridLayout(1, 3));

        jPanel6.setLayout(new java.awt.GridLayout(5, 1));

        jLabel7.setPreferredSize(new java.awt.Dimension(34, 30));
        jPanel6.add(jLabel7);

        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 18));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel6.add(jComboBox1);

        jPanel5.add(jPanel6);

        jPanel7.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        addRemButtonsPanel1.setPreferredSize(new java.awt.Dimension(59, 140));
        jPanel7.add(addRemButtonsPanel1);

        jPanel5.add(jPanel7);

        jPanel8.setLayout(new java.awt.BorderLayout());

        jLabel10.setPreferredSize(new java.awt.Dimension(40, 15));
        jPanel8.add(jLabel10, java.awt.BorderLayout.NORTH);

        jList2.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList2);

        jPanel8.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jLabel16.setPreferredSize(new java.awt.Dimension(15, 0));
        jPanel8.add(jLabel16, java.awt.BorderLayout.EAST);

        jLabel17.setPreferredSize(new java.awt.Dimension(15, 0));
        jPanel8.add(jLabel17, java.awt.BorderLayout.WEST);

        jPanel5.add(jPanel8);

        jPanel9.add(jPanel5, java.awt.BorderLayout.CENTER);

        pSul.add(jPanel9);

        jPanel12.setLayout(new javax.swing.BoxLayout(jPanel12, javax.swing.BoxLayout.X_AXIS));

        pSul.add(jPanel12);

        pCadEst.add(pSul);

        pCard.add(pCadEst, "card3");

        pCard.add(pCadFuncTrans, "card4");

        add(pCard, java.awt.BorderLayout.CENTER);

    }// </editor-fold>//GEN-END:initComponents

    private void bAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAddActionPerformed
        Character c = this.letterNumberCA.getLetter(); 
        boolean add = true;
        Vector<Character> vector = new Vector<Character>();
         
        for(int i=0;i<this.listAlf.getModel().getSize();i++)
            vector.add((Character)this.listAlf.getModel().getElementAt(i)); 
         
        Iterator i = vector.iterator();         
        while(i.hasNext()) 
             if(i.next().equals(c))
                 add = false;
           
         if(add) {
        	 DefaultListModel dlm = new DefaultListModel();
        	 for(int j=0;j<vector.size();j++)
        		 dlm.addElement(vector.get(j));
        	 
        	 dlm.addElement(c);
        	 
             this.listAlf.setModel(dlm);
             this.listAlf.repaint();
         }
            
    }//GEN-LAST:event_bAddActionPerformed

    private void bRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRemoveActionPerformed
        int[] o = this.listAlf.getSelectedIndices();
        if(o.length>0) {            
            int pos = this.listAlf.getSelectedIndex();
            if (pos > -1) {
                lm = this.listAlf.getModel();
            //this.lm.removeElementAt(pos);                        
            }    
        }
              
        
	
    }//GEN-LAST:event_bRemoveActionPerformed

    public void setFormalModel(FormalModel fm) {
        AFD afd = (AFD)fm;
        //this.jTextField1.setText(afd.getTeste());
    }

    public FormalModel getFormalModel() {
        AFD afd = new AFD();
        //afd.setTeste(this.jTextField1.getText());
        
        return afd;
    }
    
   private ListModel lm = null;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private view.AddRemButtonsPanel addRemButtonsPanel1;
    private view.AddRemButtonsPanel addRemButtonsPanel3;
    private view.AddRemButtonsPanel addRemoveButtons;
    private javax.swing.JButton bAdd;
    private javax.swing.JButton bRemove;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList jList2;
    private javax.swing.JList jList6;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane6;
    private view.LetterNumber letterNumber2;
    private view.LetterNumber letterNumberCA;
    private javax.swing.JList listAlf;
    private javax.swing.JPanel pCadAlf;
    private javax.swing.JPanel pCadEst;
    private javax.swing.JPanel pCadFuncTrans;
    private javax.swing.JPanel pCard;
    private javax.swing.JPanel pNort;
    private javax.swing.JPanel pRolagem;
    private javax.swing.JPanel pSul;
    // End of variables declaration//GEN-END:variables
    
}
