/*
 * LetterNumber.java
 *
 * Created on 13 de Mar�o de 2007, 08:38
 */

package cassolato.rafael.sctmf.view.components;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author  rafael2009_00
 */
public class LetterNumber extends javax.swing.JPanel {
    
    public static final int JCB_NUMBER = 1;
    public static final int JCB_LETTER = 2;
    
    /** Creates new form LetterNumber */
    public LetterNumber() {
        initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        cbLetter = new javax.swing.JComboBox();
        cbNumber = new javax.swing.JComboBox();
        jcb = new javax.swing.JCheckBox();

        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 5));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "S\u00edmbolos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 51, 51)));
        jPanel1.setMaximumSize(new java.awt.Dimension(150, 80));
        jPanel1.setMinimumSize(new java.awt.Dimension(150, 80));
        jPanel1.setPreferredSize(new java.awt.Dimension(150, 80));
        cbLetter.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 18));
        cbLetter.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" }));
        cbLetter.setPreferredSize(new java.awt.Dimension(50, 25));
        jPanel1.add(cbLetter);

        cbNumber.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 18));
        cbNumber.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "0" }));
        cbNumber.setPreferredSize(new java.awt.Dimension(50, 25));
        jPanel1.add(cbNumber);

        jcb.setToolTipText("Letra Min\u00fascula");
        jcb.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jcb.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jPanel1.add(jcb);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents
        
    public void enableCbNumber(boolean arg) {
        this.cbNumber.setEnabled(arg);
    }
    
    public void enableCbLetter(boolean arg) {
        this.cbLetter.setEnabled(arg);
    }
    
    public char getLetter() {
        char c = this.cbLetter.getSelectedItem().toString().charAt(0);
        if(this.jcb.isSelected())
            return Character.toLowerCase(c);
        else
            return c;
    }
    
    public int getNumber() {
        return Integer.parseInt(
                this.cbNumber.getSelectedItem().toString());
    }
    
    public void addItem(String s) {
        List<String> l = new ArrayList<String>();
        l.add(s); // add o simbolo
        int size = cbLetter.getModel().getSize();
        for(int i =0;i<size;i++) 
            l.add(cbLetter.getItemAt(i).toString());
        
        this.cbLetter.removeAllItems(); // remove todos os itens do JComoBox
        Collections.sort(l); // Ordena            
        for(String str : l)
            this.cbLetter.addItem(str);
        
    }
    
    public void removeItem(Object o) {
        this.cbLetter.removeItem(o.toString());        
    }
    
    /**
     * Forca as letras serem todas min�sculas
     */
    public void forceAllLowerCase(boolean status) {
        if(status) {
            this.jcb.setSelected(true);
            this.jcb.setEnabled(false);
            
        }else {        
            this.jcb.setSelected(false);
            this.jcb.setEnabled(true);
        }
        
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbLetter;
    private javax.swing.JComboBox cbNumber;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JCheckBox jcb;
    // End of variables declaration//GEN-END:variables
    
}