/*
 * CadEstMT.java
 *
 * Created on 23 de Agosto de 2007, 08:52
 */

package cassolato.rafael.sctmf.view.modelos_formais.ling_enum_rec.mt;

import cassolato.rafael.sctmf.model.pojo.Estado;
import cassolato.rafael.sctmf.view.components.CEstado;
import java.util.Set;

/**
 *
 * @author  rafael2009_00
 */
public class CadEstMT extends javax.swing.JPanel implements CEstado {
    
    /** Creates new form CadEstMT */
    public CadEstMT() {
        initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        cadEstado = cadEstado = new cassolato.rafael.sctmf.view.components.CadEstado(this);
        pSul = new javax.swing.JPanel();
        pEstIni = new javax.swing.JPanel();
        jLabel77 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        cbEstIni = new javax.swing.JComboBox();
        jPanel7 = new javax.swing.JPanel();
        addRemEstIni = new cassolato.rafael.sctmf.view.components.AddRemButtonsPanel();
        jLabel79 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        listEstIni = new cassolato.rafael.sctmf.view.components.GenericJList();
        pEstFin = new javax.swing.JPanel();
        jLabel81 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        panel = new javax.swing.JPanel();
        jPanel40 = new javax.swing.JPanel();
        cbEstFin = new javax.swing.JComboBox();
        jPanel41 = new javax.swing.JPanel();
        addRemEstFin = new cassolato.rafael.sctmf.view.components.AddRemButtonsPanel();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        jPanel42 = new javax.swing.JPanel();
        listEstFin = new cassolato.rafael.sctmf.view.components.GenericJList();

        setLayout(new java.awt.GridLayout(2, 0));

        add(cadEstado);

        pSul.setLayout(new java.awt.GridLayout(1, 2));

        pSul.setPreferredSize(new java.awt.Dimension(10, 150));
        pEstIni.setLayout(new java.awt.BorderLayout());

        pEstIni.setBorder(javax.swing.BorderFactory.createTitledBorder(null, " Estado Inicial ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(19, 92, 34)));
        jLabel77.setPreferredSize(new java.awt.Dimension(0, 5));
        pEstIni.add(jLabel77, java.awt.BorderLayout.SOUTH);

        jLabel78.setPreferredSize(new java.awt.Dimension(5, 0));
        pEstIni.add(jLabel78, java.awt.BorderLayout.WEST);

        jPanel5.setLayout(new java.awt.GridLayout(1, 3, 10, 0));

        jPanel6.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 25));

        cbEstIni.setFont(new java.awt.Font("Tahoma", 1, 14));
        cbEstIni.setPreferredSize(new java.awt.Dimension(50, 22));
        jPanel6.add(cbEstIni);

        jPanel5.add(jPanel6);

        jPanel7.setLayout(new java.awt.BorderLayout());

        addRemEstIni.setPreferredSize(new java.awt.Dimension(59, 140));
        jPanel7.add(addRemEstIni, java.awt.BorderLayout.CENTER);

        jLabel79.setPreferredSize(new java.awt.Dimension(0, 5));
        jPanel7.add(jLabel79, java.awt.BorderLayout.NORTH);

        jLabel80.setPreferredSize(new java.awt.Dimension(0, 5));
        jPanel7.add(jLabel80, java.awt.BorderLayout.SOUTH);

        jPanel5.add(jPanel7);

        jPanel8.setLayout(new java.awt.BorderLayout());

        jPanel8.add(listEstIni, java.awt.BorderLayout.CENTER);

        jPanel5.add(jPanel8);

        pEstIni.add(jPanel5, java.awt.BorderLayout.CENTER);

        pSul.add(pEstIni);

        pEstFin.setLayout(new java.awt.BorderLayout());

        pEstFin.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Estados Finais", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(125, 82, 134)));
        jLabel81.setPreferredSize(new java.awt.Dimension(0, 5));
        pEstFin.add(jLabel81, java.awt.BorderLayout.SOUTH);

        jLabel82.setPreferredSize(new java.awt.Dimension(10, 0));
        pEstFin.add(jLabel82, java.awt.BorderLayout.WEST);

        panel.setLayout(new java.awt.GridLayout(1, 3, 10, 0));

        jPanel40.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 25));

        cbEstFin.setFont(new java.awt.Font("Tahoma", 1, 14));
        cbEstFin.setPreferredSize(new java.awt.Dimension(50, 22));
        jPanel40.add(cbEstFin);

        panel.add(jPanel40);

        jPanel41.setLayout(new java.awt.BorderLayout());

        addRemEstFin.setPreferredSize(new java.awt.Dimension(59, 140));
        jPanel41.add(addRemEstFin, java.awt.BorderLayout.CENTER);

        jLabel83.setPreferredSize(new java.awt.Dimension(0, 5));
        jPanel41.add(jLabel83, java.awt.BorderLayout.NORTH);

        jLabel84.setPreferredSize(new java.awt.Dimension(0, 5));
        jPanel41.add(jLabel84, java.awt.BorderLayout.SOUTH);

        panel.add(jPanel41);

        jPanel42.setLayout(new java.awt.BorderLayout());

        jPanel42.add(listEstFin, java.awt.BorderLayout.CENTER);

        panel.add(jPanel42);

        pEstFin.add(panel, java.awt.BorderLayout.CENTER);

        pSul.add(pEstFin);

        add(pSul);

    }// </editor-fold>//GEN-END:initComponents

    public void addEstado(Estado estado) {
    }

    public void remEstados(Set<Estado> estados) {
    }

    public void removeAllItens() {
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private cassolato.rafael.sctmf.view.components.AddRemButtonsPanel addRemEstFin;
    private cassolato.rafael.sctmf.view.components.AddRemButtonsPanel addRemEstIni;
    private cassolato.rafael.sctmf.view.components.CadEstado cadEstado;
    private javax.swing.JComboBox cbEstFin;
    private javax.swing.JComboBox cbEstIni;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private cassolato.rafael.sctmf.view.components.GenericJList listEstFin;
    private cassolato.rafael.sctmf.view.components.GenericJList listEstIni;
    private javax.swing.JPanel pEstFin;
    private javax.swing.JPanel pEstIni;
    private javax.swing.JPanel pSul;
    private javax.swing.JPanel panel;
    // End of variables declaration//GEN-END:variables
    
}
