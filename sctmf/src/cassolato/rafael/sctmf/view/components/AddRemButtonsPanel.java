/*
 * AddRemButtonsPanel.java
 *
 * Created on 13 de Mar�o de 2007, 13:52
 */

package cassolato.rafael.sctmf.view.components;

/**
 *
 * @author  rafael2009_00
 */
public class AddRemButtonsPanel extends javax.swing.JPanel {
       
    /** Creates new form AddRemButtonsPanel */
    public AddRemButtonsPanel() {
        initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" C�digo Gerado ">//GEN-BEGIN:initComponents
    private void initComponents() {
        bAdd = new javax.swing.JButton();
        bRemove = new javax.swing.JButton();

        setLayout(new java.awt.GridLayout(2, 0, 0, 10));

        bAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/toolbarButtonGraphics/general/Add24.gif")));
        add(bAdd);

        bRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/toolbarButtonGraphics/general/Remove24.gif")));
        add(bRemove);

    }// </editor-fold>//GEN-END:initComponents
        
    public javax.swing.JButton getBAdd() {
        return this.bAdd;
    }
    
    public javax.swing.JButton getBRemove() {
        return this.bRemove;
    }
    
    // Declara��o de vari�veis - n�o modifique//GEN-BEGIN:variables
    private javax.swing.JButton bAdd;
    private javax.swing.JButton bRemove;
    // Fim da declara��o de vari�veis//GEN-END:variables
    
}
