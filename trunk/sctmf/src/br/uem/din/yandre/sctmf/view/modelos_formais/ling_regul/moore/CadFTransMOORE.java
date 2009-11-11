/*
 * CadFTransMOORE.java
 *
 * Created on 23 de Agosto de 2007, 09:14
 */
package br.uem.din.yandre.sctmf.view.modelos_formais.ling_regul.moore;

import br.uem.din.yandre.sctmf.model.pojo.Estado;
import br.uem.din.yandre.sctmf.model.pojo.Simbolo;
import br.uem.din.yandre.sctmf.model.pojo.Transicao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author  rafael2009_00
 */
public class CadFTransMOORE extends javax.swing.JPanel {

    private MooreGUI gui = null;
    // Collections com os nomes dos itens
    final Set<Character> alf = new LinkedHashSet<Character>();
    final Set<Character> alfSaida = new LinkedHashSet<Character>();
    private HashMap<Estado, ArrayList<Simbolo>> determinismo = new HashMap<Estado, ArrayList<Simbolo>>();

    /** Creates new form CadFTransMOORE */
    public CadFTransMOORE(MooreGUI gui) {
        this.gui = gui;
        initComponents();
        posInitComponents();
    }

    Set<Transicao> getTransicoes() {
        Set<Transicao> trans = new LinkedHashSet<Transicao>();
        for (Object o : this.listTrans.getAllItens()) {
            Matcher m = this.getMatcher(o.toString());
            Transicao t = new Transicao();

            if (m.find()) {
                t.setEstOri(new Estado(m.group(1)));
                t.setSimbolo(new Simbolo(m.group(2).charAt(0)));

                t.setEstDest(new Estado(m.group(3)));
                t.setSimboloSaida(new Simbolo(m.group(4).charAt(0)));

                trans.add(t);
            }

        }

        return trans;
    }

    void setTransicoes(Set<Transicao> transicoes) {
        this.listTrans.removeAllItens();

        for (Transicao t : transicoes) {
            this.addActionTrans(t.getEstOri(), t.getSimbolo(),
                    t.getEstDest(), t.getSimboloSaida());
        }

    }

    private void posInitComponents() {
        this.addRemTran.getBAdd().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {
                addActionTrans(null, null, null, null);
            }
        });

        this.addRemTran.getBRemove().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {
                removeActionTrans();
            }
        });
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jPanel24 = new javax.swing.JPanel();
        cbEstOri = new javax.swing.JComboBox();
        jLabel24 = new javax.swing.JLabel();
        jPanel25 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jPanel26 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        fSimASerLido = new javax.swing.JTextField();
        jPanel29 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jPanel30 = new javax.swing.JPanel();
        cbEstDest = new javax.swing.JComboBox();
        jLabel33 = new javax.swing.JLabel();
        jPanel27 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jPanel32 = new javax.swing.JPanel();
        fSimASerGravado = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel54 = new javax.swing.JPanel();
        jLabel58 = new javax.swing.JLabel();
        jPanel55 = new javax.swing.JPanel();
        jPanel56 = new javax.swing.JPanel();
        jPanel58 = new javax.swing.JPanel();
        jLabel62 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jPanel59 = new javax.swing.JPanel();
        jPanel60 = new javax.swing.JPanel();
        jPanel61 = new javax.swing.JPanel();
        bAddSimbBrancDir = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jPanel62 = new javax.swing.JPanel();
        jPanel63 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jPanel35 = new javax.swing.JPanel();
        jPanel36 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        addRemTran = new br.uem.din.yandre.sctmf.view.components.AddRemButtonsPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        listTrans = new br.uem.din.yandre.sctmf.view.components.GenericJList();

        setLayout(new java.awt.BorderLayout());

        jLabel17.setPreferredSize(new java.awt.Dimension(40, 10));
        add(jLabel17, java.awt.BorderLayout.NORTH);

        jLabel18.setPreferredSize(new java.awt.Dimension(5, 14));
        add(jLabel18, java.awt.BorderLayout.EAST);

        jLabel19.setPreferredSize(new java.awt.Dimension(40, 10));
        add(jLabel19, java.awt.BorderLayout.SOUTH);

        jLabel20.setText("  ");
        add(jLabel20, java.awt.BorderLayout.WEST);

        jPanel1.setLayout(new java.awt.BorderLayout(0, 5));

        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel8.setLayout(new javax.swing.BoxLayout(jPanel8, javax.swing.BoxLayout.LINE_AXIS));

        jPanel10.setMaximumSize(new java.awt.Dimension(20, 60));
        jPanel10.setPreferredSize(new java.awt.Dimension(20, 60));
        jPanel10.setLayout(new java.awt.BorderLayout(0, 5));

        jLabel22.setFont(new java.awt.Font("Verdana", 1, 14));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel22.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel22.setPreferredSize(new java.awt.Dimension(10, 30));
        jLabel22.setText("\u03B4:");
        jPanel10.add(jLabel22, java.awt.BorderLayout.NORTH);

        jPanel8.add(jPanel10);

        jPanel24.setOpaque(false);
        jPanel24.setPreferredSize(new java.awt.Dimension(20, 30));
        jPanel24.setLayout(new java.awt.BorderLayout(0, 5));

        cbEstOri.setBackground(new java.awt.Color(204, 255, 204));
        cbEstOri.setToolTipText("Estado de Origem");
        jPanel24.add(cbEstOri, java.awt.BorderLayout.CENTER);

        jLabel24.setFont(new java.awt.Font("Verdana", 1, 14));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Q");
        jLabel24.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel24.setPreferredSize(new java.awt.Dimension(20, 30));
        jPanel24.add(jLabel24, java.awt.BorderLayout.NORTH);

        jPanel8.add(jPanel24);

        jPanel25.setMaximumSize(new java.awt.Dimension(20, 60));
        jPanel25.setOpaque(false);
        jPanel25.setPreferredSize(new java.awt.Dimension(10, 60));
        jPanel25.setLayout(new java.awt.BorderLayout(0, 5));

        jLabel28.setFont(new java.awt.Font("Verdana", 1, 12));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("x");
        jLabel28.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel28.setPreferredSize(new java.awt.Dimension(20, 30));
        jPanel25.add(jLabel28, java.awt.BorderLayout.NORTH);

        jPanel8.add(jPanel25);

        jPanel26.setOpaque(false);
        jPanel26.setPreferredSize(new java.awt.Dimension(60, 30));
        jPanel26.setLayout(new java.awt.BorderLayout(0, 5));

        jLabel34.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 12));
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel34.setPreferredSize(new java.awt.Dimension(20, 30));
        jLabel34.setText("\u03a3");
        jPanel26.add(jLabel34, java.awt.BorderLayout.NORTH);

        fSimASerLido.setBackground(new java.awt.Color(255, 255, 204));
        fSimASerLido.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 14));
        fSimASerLido.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fSimASerLido.setToolTipText("S�mbolo a ser lido");
        fSimASerLido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fSimASerLidoKeyReleased(evt);
            }
        });
        jPanel26.add(fSimASerLido, java.awt.BorderLayout.CENTER);

        jPanel8.add(jPanel26);

        jPanel29.setPreferredSize(new java.awt.Dimension(10, 30));
        jPanel29.setLayout(new java.awt.BorderLayout(0, 5));

        jLabel32.setFont(new java.awt.Font("Arial", 1, 15));
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel32.setPreferredSize(new java.awt.Dimension(20, 30));
        jLabel32.setText("\u2192");
        jPanel29.add(jLabel32, java.awt.BorderLayout.NORTH);

        jPanel8.add(jPanel29);

        jPanel30.setOpaque(false);
        jPanel30.setPreferredSize(new java.awt.Dimension(20, 30));
        jPanel30.setLayout(new java.awt.BorderLayout(0, 5));

        cbEstDest.setBackground(new java.awt.Color(204, 204, 255));
        cbEstDest.setToolTipText("Estado de Destino");
        jPanel30.add(cbEstDest, java.awt.BorderLayout.CENTER);

        jLabel33.setFont(new java.awt.Font("Verdana", 1, 14));
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("Q");
        jLabel33.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel33.setPreferredSize(new java.awt.Dimension(20, 30));
        jPanel30.add(jLabel33, java.awt.BorderLayout.NORTH);

        jPanel8.add(jPanel30);

        jPanel27.setMaximumSize(new java.awt.Dimension(20, 60));
        jPanel27.setPreferredSize(new java.awt.Dimension(10, 60));
        jPanel27.setLayout(new java.awt.BorderLayout(0, 5));

        jLabel29.setFont(new java.awt.Font("Verdana", 1, 12));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("x");
        jLabel29.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel29.setPreferredSize(new java.awt.Dimension(20, 30));
        jPanel27.add(jLabel29, java.awt.BorderLayout.NORTH);

        jPanel8.add(jPanel27);

        jPanel32.setPreferredSize(new java.awt.Dimension(60, 30));
        jPanel32.setLayout(new java.awt.BorderLayout(0, 5));

        fSimASerGravado.setBackground(new java.awt.Color(255, 204, 204));
        fSimASerGravado.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 14));
        fSimASerGravado.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fSimASerGravado.setToolTipText("S�mbolo a ser gravado");
        fSimASerGravado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fSimASerGravadoKeyReleased(evt);
            }
        });
        jPanel32.add(fSimASerGravado, java.awt.BorderLayout.CENTER);

        jLabel36.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 12));
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel36.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel36.setPreferredSize(new java.awt.Dimension(20, 30));
        jLabel36.setText("\u0394");
        jPanel32.add(jLabel36, java.awt.BorderLayout.NORTH);

        jPanel8.add(jPanel32);

        jPanel31.setMaximumSize(new java.awt.Dimension(20, 60));
        jPanel31.setPreferredSize(new java.awt.Dimension(10, 60));
        jPanel31.setLayout(new java.awt.BorderLayout(0, 5));
        jPanel8.add(jPanel31);

        jPanel3.add(jPanel8, java.awt.BorderLayout.NORTH);

        jPanel7.setPreferredSize(new java.awt.Dimension(250, 30));
        jPanel7.setLayout(new javax.swing.BoxLayout(jPanel7, javax.swing.BoxLayout.LINE_AXIS));

        jPanel54.setMaximumSize(new java.awt.Dimension(20, 60));
        jPanel54.setPreferredSize(new java.awt.Dimension(20, 60));
        jPanel54.setLayout(new java.awt.BorderLayout(0, 5));

        jLabel58.setFont(new java.awt.Font("Verdana", 1, 14));
        jLabel58.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel58.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel58.setPreferredSize(new java.awt.Dimension(10, 30));
        jLabel22.setText("\u03B4:");
        jPanel54.add(jLabel58, java.awt.BorderLayout.NORTH);

        jPanel7.add(jPanel54);

        jPanel55.setOpaque(false);
        jPanel55.setPreferredSize(new java.awt.Dimension(20, 30));
        jPanel55.setLayout(new java.awt.BorderLayout(0, 5));
        jPanel7.add(jPanel55);

        jPanel56.setMaximumSize(new java.awt.Dimension(20, 60));
        jPanel56.setOpaque(false);
        jPanel56.setPreferredSize(new java.awt.Dimension(10, 60));
        jPanel56.setLayout(new java.awt.BorderLayout(0, 5));
        jPanel7.add(jPanel56);

        jPanel58.setPreferredSize(new java.awt.Dimension(10, 30));
        jPanel58.setLayout(new java.awt.BorderLayout(0, 5));

        jLabel62.setFont(new java.awt.Font("Arial", 1, 15));
        jLabel62.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel62.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel62.setPreferredSize(new java.awt.Dimension(20, 30));
        jLabel32.setText("\u2192");
        jPanel58.add(jLabel62, java.awt.BorderLayout.NORTH);
        jPanel58.add(jPanel9, java.awt.BorderLayout.LINE_END);

        jPanel7.add(jPanel58);

        jPanel59.setOpaque(false);
        jPanel59.setPreferredSize(new java.awt.Dimension(20, 30));
        jPanel59.setLayout(new java.awt.BorderLayout(0, 5));
        jPanel7.add(jPanel59);

        jPanel60.setMaximumSize(new java.awt.Dimension(20, 60));
        jPanel60.setPreferredSize(new java.awt.Dimension(10, 60));
        jPanel60.setLayout(new java.awt.BorderLayout(0, 5));
        jPanel7.add(jPanel60);

        jPanel61.setPreferredSize(new java.awt.Dimension(60, 30));

        bAddSimbBrancDir.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 10));
        bAddSimbBrancDir.setPreferredSize(new java.awt.Dimension(45, 23));
        bAddSimbBrancDir.setText("\u03B2");
        bAddSimbBrancDir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAddSimbBrancDirActionPerformed(evt);
            }
        });
        jPanel61.add(bAddSimbBrancDir);

        jLabel8.setPreferredSize(new java.awt.Dimension(34, 5));
        jPanel61.add(jLabel8);

        jPanel7.add(jPanel61);

        jPanel62.setMaximumSize(new java.awt.Dimension(20, 60));
        jPanel62.setPreferredSize(new java.awt.Dimension(10, 60));
        jPanel62.setLayout(new java.awt.BorderLayout(0, 5));
        jPanel7.add(jPanel62);

        jPanel63.setOpaque(false);
        jPanel63.setPreferredSize(new java.awt.Dimension(15, 30));
        jPanel63.setLayout(new java.awt.BorderLayout(0, 2));
        jPanel7.add(jPanel63);

        jPanel3.add(jPanel7, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel3, java.awt.BorderLayout.NORTH);

        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.LINE_AXIS));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Legenda", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(153, 0, 153))); // NOI18N
        jPanel4.setLayout(new java.awt.GridLayout(7, 0));

        jPanel19.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jPanel13.setBackground(new java.awt.Color(204, 255, 204));
        jPanel19.add(jPanel13);

        jLabel23.setFont(new java.awt.Font("Verdana", 0, 10));
        jLabel23.setText("Estado de Origem");
        jPanel19.add(jLabel23);

        jPanel4.add(jPanel19);

        jPanel20.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jPanel14.setBackground(new java.awt.Color(255, 255, 204));
        jPanel20.add(jPanel14);

        jLabel35.setFont(new java.awt.Font("Verdana", 0, 10));
        jLabel35.setText("S�mbolo a ser lido");
        jPanel20.add(jLabel35);

        jPanel4.add(jPanel20);

        jPanel22.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jPanel23.setBackground(new java.awt.Color(204, 204, 255));
        jPanel22.add(jPanel23);

        jLabel39.setFont(new java.awt.Font("Verdana", 0, 10));
        jLabel39.setText("Estado de Destino");
        jPanel22.add(jLabel39);

        jPanel4.add(jPanel22);

        jPanel35.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jPanel36.setBackground(new java.awt.Color(255, 204, 204));
        jPanel35.add(jPanel36);

        jLabel40.setFont(new java.awt.Font("Verdana", 0, 10));
        jLabel40.setText("S�mbolo a ser gravado");
        jPanel35.add(jLabel40);

        jPanel4.add(jPanel35);

        jPanel21.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));
        jPanel4.add(jPanel21);

        jPanel11.setLayout(new javax.swing.BoxLayout(jPanel11, javax.swing.BoxLayout.LINE_AXIS));
        jPanel4.add(jPanel11);

        jPanel12.setLayout(new javax.swing.BoxLayout(jPanel12, javax.swing.BoxLayout.LINE_AXIS));

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 10));
        jLabel5.setText("B");
        jLabel5.setText("\u03B2 ");
        jPanel12.add(jLabel5);

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 10));
        jLabel6.setText("C�lula em branco");
        jPanel12.add(jLabel6);

        jPanel4.add(jPanel12);

        jPanel2.add(jPanel4);

        jPanel5.setLayout(new java.awt.BorderLayout());

        jLabel25.setPreferredSize(new java.awt.Dimension(40, 20));
        jPanel5.add(jLabel25, java.awt.BorderLayout.NORTH);

        jLabel26.setPreferredSize(new java.awt.Dimension(40, 20));
        jPanel5.add(jLabel26, java.awt.BorderLayout.SOUTH);

        jLabel27.setPreferredSize(new java.awt.Dimension(5, 14));
        jPanel5.add(jLabel27, java.awt.BorderLayout.WEST);

        jLabel31.setPreferredSize(new java.awt.Dimension(5, 14));
        jPanel5.add(jLabel31, java.awt.BorderLayout.EAST);
        jPanel5.add(addRemTran, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel5);

        jPanel6.setLayout(new java.awt.BorderLayout());

        jLabel21.setFont(new java.awt.Font("Bitstream Vera Sans", 3, 12));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Transi��es");
        jPanel6.add(jLabel21, java.awt.BorderLayout.NORTH);

        listTrans.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.add(listTrans, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel6);

        jPanel1.add(jPanel2, java.awt.BorderLayout.CENTER);

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

     private void addActionTrans(Estado estOri, Simbolo simbLido,
            Estado estDest, Simbolo sGrav) {

        try {
            if (simbLido == null) {
                estOri = new Estado(this.cbEstOri.getSelectedItem().toString());
                simbLido = new Simbolo(this.fSimASerLido.getText().charAt(0));
                estDest = new Estado(this.cbEstDest.getSelectedItem().toString());
                sGrav = new Simbolo(this.fSimASerGravado.getText().charAt(0));
            }
            if (!determinismo.containsKey(estOri)) {
                determinismo.put(estOri, new ArrayList<Simbolo>());
            }
            if (!determinismo.get(estOri).contains(simbLido)) {
                determinismo.get(estOri).add(simbLido);
                StringBuilder sb = new StringBuilder("\u03B4(").append(estOri.getNome()).append(", ").
                        append(simbLido.getNome()).append(") -> (").
                        append(estDest.getNome()).append(", ").
                        append(sGrav.getNome()).append(")");
                this.listTrans.addItem(sb.toString());
            } else {
                JOptionPane.showMessageDialog(null, "N�o Determinismo n�o aplic�vel!");
            }




        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    private void removeActionTrans() {
        this.listTrans.removeItens();
    }

    private void fSimASerGravadoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fSimASerGravadoKeyReleased
        this.controlKeyListener(this.fSimASerGravado);
    }//GEN-LAST:event_fSimASerGravadoKeyReleased

    private void bAddSimbBrancDirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAddSimbBrancDirActionPerformed
        this.fSimASerGravado.setText("\u03B2");
    }//GEN-LAST:event_bAddSimbBrancDirActionPerformed

    private void fSimASerLidoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fSimASerLidoKeyReleased
        this.controlKeyListener(this.fSimASerLido);
    }//GEN-LAST:event_fSimASerLidoKeyReleased

    private final void controlKeyListener(final javax.swing.JTextField field) {
        String value = field.getText();
        int tam = value.length();
        Character s = tam > 0 ? value.substring(tam - 1).charAt(0) : null;
        if (s != null) // verifica se o simbolo pertence a um dos alfabetos
        {
            if (Character.isLowerCase(s) || Character.isDigit(s)) // alfabeto
            {
                if (this.alf.contains(s)) {
                    field.setText(s.toString());
                } else {
                    field.setText("");
                }
            } else // alfabeto auxiliar
            if (this.alfSaida.contains(s)) {
                field.setText(s.toString());
            } else {
                field.setText("");
            }
        } else {
            this.fSimASerLido.setText("");
        }
    }

    /**
     * O Estado a ser Observado e o tipo de opera��o,
     * se for true ADD, false REMOVE.
     */
    void observer(Estado e, boolean oper) {
        final String nomeEstado = e.getNome();
        if (oper) {
            this.cbEstOri.addItem(nomeEstado);
            this.cbEstDest.addItem(nomeEstado);

        } else {
            this.cbEstOri.removeItem(nomeEstado);
            this.cbEstDest.removeItem(nomeEstado);

            this.observerRemove(e.getNome());
        }
    }

    /**
     * Caso oper true, ADD. Caso false REMOVE.
     * Se o charater � Upper... simbolos alfSaida
     * caso lower  simbolos Alf
     *
     */
    void observer(Simbolo s, boolean oper, int alf) {
        Character c = s.getNome();
        if (alf == 0) { // Alfabeto
            if (oper) {
                this.alf.add(c);
            } else {
                this.alf.remove(c);
                this.observerRemove(c);
            }

        } else // Alfabeto auxiliar
        if (oper) {
            this.alfSaida.add(c);
        } else {
            this.alfSaida.remove(c);
            this.observerRemove(c);
        }
    }

    /**
     * Verifica se existe alguma transicao com o simbolo,
     * caso exista, remove esta.
     * 
     */
    private void observerRemove(Object o) {
        this.fSimASerLido.setText("");
        this.fSimASerGravado.setText("");

        String s = o.toString();
        for (Object obj : this.listTrans.getAllItens()) {
            if (obj.toString().contains(s)) {
                this.listTrans.removeItem(obj.toString());
            }
        }

    }

    /**
     * Retorna o matcher para ser feito a pesquisa.<br>
     * Usando o metodo <b>group</b> obtemos:<br>
     * <i>Posicao 1</i> Estado de Origem<br>
     * <i>Posicao 2</i> Simbolo a ser lido<br>
     * <i>Posicao 3</i> Estado de Destino<br>
     * <i>Posicao 4</i> Simbolo a ser escrito<br>
     * <i>Posicao 5</i> Direcao do movimento<br>
     *
     * @param str
     * @return Matcher
     */
    private Matcher getMatcher(String str) {
        String regex = ".?\\((.+), (.+)\\) -> \\((.+), (.+)\\)";

        return Pattern.compile(regex).matcher(str);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private br.uem.din.yandre.sctmf.view.components.AddRemButtonsPanel addRemTran;
    private javax.swing.JButton bAddSimbBrancDir;
    private javax.swing.JComboBox cbEstDest;
    private javax.swing.JComboBox cbEstOri;
    private javax.swing.JTextField fSimASerGravado;
    private javax.swing.JTextField fSimASerLido;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel54;
    private javax.swing.JPanel jPanel55;
    private javax.swing.JPanel jPanel56;
    private javax.swing.JPanel jPanel58;
    private javax.swing.JPanel jPanel59;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel60;
    private javax.swing.JPanel jPanel61;
    private javax.swing.JPanel jPanel62;
    private javax.swing.JPanel jPanel63;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private br.uem.din.yandre.sctmf.view.components.GenericJList listTrans;
    // End of variables declaration//GEN-END:variables
}
