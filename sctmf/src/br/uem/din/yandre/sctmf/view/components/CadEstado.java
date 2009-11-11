/*
 * CadEstado.java
 *
 * Created on 13 de Junho de 2007, 19:35
 */
package br.uem.din.yandre.sctmf.view.components;

import br.uem.din.yandre.sctmf.model.pojo.Estado;
import br.uem.din.yandre.sctmf.model.pojo.Simbolo;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author  Cassolato
 */
public class CadEstado extends javax.swing.JPanel
        implements CEstado {

    private CEstado component = null;
    private List<Simbolo> simbolos = new ArrayList<Simbolo>();
    private List<String> estados = new ArrayList<String>();

    /** Creates new form CadEstado */
    public CadEstado() {
        initComponents();
    }

    public CadEstado(CEstado component) {
        this.component = component;

        initComponents();
        this.posInitComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel28 = new javax.swing.JPanel();
        lN = new br.uem.din.yandre.sctmf.view.components.LetterNumber();
        pSimbSaida = new javax.swing.JPanel();
        cbSimbSaida = new javax.swing.JComboBox();
        jPanel29 = new javax.swing.JPanel();
        addRemEstado = new br.uem.din.yandre.sctmf.view.components.AddRemButtonsPanel();
        jLabel45 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jPanel30 = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        genericJList = new br.uem.din.yandre.sctmf.view.components.GenericJList();

        setMinimumSize(new java.awt.Dimension(400, 130));
        setPreferredSize(new java.awt.Dimension(400, 155));
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

        jPanel28.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        jPanel28.add(lN, gridBagConstraints);

        pSimbSaida.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "S�mbolo de Sa�da", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 51, 51))); // NOI18N

        pSimbSaida.add(cbSimbSaida);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        jPanel28.add(pSimbSaida, gridBagConstraints);

        add(jPanel28);

        jPanel29.setMaximumSize(new java.awt.Dimension(80, 180));
        jPanel29.setMinimumSize(new java.awt.Dimension(80, 180));
        jPanel29.setPreferredSize(new java.awt.Dimension(80, 180));
        jPanel29.setLayout(new java.awt.BorderLayout());

        addRemEstado.setPreferredSize(new java.awt.Dimension(70, 140));
        jPanel29.add(addRemEstado, java.awt.BorderLayout.CENTER);

        jLabel45.setPreferredSize(new java.awt.Dimension(34, 20));
        jPanel29.add(jLabel45, java.awt.BorderLayout.NORTH);

        jLabel49.setPreferredSize(new java.awt.Dimension(40, 20));
        jPanel29.add(jLabel49, java.awt.BorderLayout.SOUTH);

        jLabel50.setPreferredSize(new java.awt.Dimension(20, 14));
        jPanel29.add(jLabel50, java.awt.BorderLayout.WEST);

        add(jPanel29);

        jPanel30.setMinimumSize(new java.awt.Dimension(50, 42));
        jPanel30.setLayout(new java.awt.BorderLayout());

        jLabel51.setFont(new java.awt.Font("Verdana", 1, 14));
        jLabel51.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel51.setText("Estados");
        jPanel30.add(jLabel51, java.awt.BorderLayout.NORTH);

        jLabel52.setPreferredSize(new java.awt.Dimension(40, 0));
        jPanel30.add(jLabel52, java.awt.BorderLayout.WEST);

        jLabel53.setPreferredSize(new java.awt.Dimension(40, 0));
        jPanel30.add(jLabel53, java.awt.BorderLayout.EAST);
        jPanel30.add(genericJList, java.awt.BorderLayout.CENTER);

        add(jPanel30);
    }// </editor-fold>//GEN-END:initComponents

    private void posInitComponents() {
        lN.setCustomTextInBorderTitle("Nome do Estado");
        lN.hideRadioButtons();

        this.addRemEstado.getBAdd().addActionListener(
                new java.awt.event.ActionListener() {

                    public void actionPerformed(java.awt.event.ActionEvent ae) {
                        addEstado(null);
                    }
                });

        this.addRemEstado.getBRemove().addActionListener(
                new java.awt.event.ActionListener() {

                    public void actionPerformed(java.awt.event.ActionEvent ae) {
                        remEstados(null);
                    }
                });

        showSimbSaida(false);
    }

    public void showSimbSaida(boolean hide) {
        pSimbSaida.setVisible(hide);
    }

    public void remEstados(Set<Estado> estados) {
        estados = new LinkedHashSet<Estado>();
        for (Object o : genericJList.removeItens()) {
            estados.add(new Estado(o.toString()));


        }
        this.component.remEstados(estados);
        //this.estados.removeAll(estados);
    }

    public void addEstado(Estado estado) {

        if (estado == null) {
            estado = new Estado(lN.getLetterAndNumber());

            if (pSimbSaida.isVisible()) {
                estado.setSaida(new Simbolo((Character) cbSimbSaida.getSelectedItem()));
            }
        }
        if (!estados.contains(estado.getNome())) {
            String nomeEst = estado.getNome();
            if (pSimbSaida.isVisible()) {
                nomeEst = nomeEst + " -> " + estado.getSaida().getNome();
            }
            if (this.genericJList.addItem(nomeEst) != null) {
                this.component.addEstado(estado);
            }
            this.estados.add(estado.getNome());
        }

    }

    public void removeAllItens() {
        this.genericJList.removeAllItens();
    }

    public Set<Estado> getAllItens() {
        Set<Estado> estados = new LinkedHashSet<Estado>();
        for (Object o : this.genericJList.getAllItens()) {
            estados.add(new Estado(o.toString()));


        }
        return estados;
    }

    public void setCbSimbSaida(Simbolo s, boolean oper) {
        if (oper && !simbolos.contains(s)) {
            this.cbSimbSaida.addItem(s.getNome());
            simbolos.add(s);
        } else if (!oper) {
            this.cbSimbSaida.removeItem(s.getNome());
            simbolos.remove(s);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private br.uem.din.yandre.sctmf.view.components.AddRemButtonsPanel addRemEstado;
    private javax.swing.JComboBox cbSimbSaida;
    private br.uem.din.yandre.sctmf.view.components.GenericJList genericJList;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel30;
    private br.uem.din.yandre.sctmf.view.components.LetterNumber lN;
    private javax.swing.JPanel pSimbSaida;
    // End of variables declaration//GEN-END:variables
}
