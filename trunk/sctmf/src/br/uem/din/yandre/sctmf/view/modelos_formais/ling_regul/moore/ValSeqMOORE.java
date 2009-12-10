/*
 * ValSeqMOORe.java
 *
 * Created on 23 de Agosto de 2007, 09:06
 */
package br.uem.din.yandre.sctmf.view.modelos_formais.ling_regul.moore;

import br.uem.din.yandre.sctmf.model.pojo.Estado;
import br.uem.din.yandre.sctmf.model.pojo.Moore;
import br.uem.din.yandre.sctmf.model.pojo.Simbolo;
import br.uem.din.yandre.sctmf.model.pojo.Transicao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author  rafael2009_00
 */
public class ValSeqMOORE extends javax.swing.JPanel {

    private MooreGUI gui = null;

    /** Creates new form ValSeqMOORe */
    public ValSeqMOORE(MooreGUI gui) {
        this.gui = gui;
        initComponents();
        posInitComponents();
    }

    void observer(Moore moore) {
        this.validaSequenciaGUI.clearArea();
        this.validaSequenciaGUI.setTextAInf(
                "M = \u03a3, S, \u03B4, S\u2080, F, \u0394 \n");

        StringBuffer sb = new StringBuffer();
        sb.append("\u03a3 = {");  // Add Simbolos
        for (Simbolo s : moore.getSimbolos()) {
            sb.append(s.getNome() + ", ");
        }
        sb = this.validaSequenciaGUI.formataSb(sb);

        sb.append("S = {"); // Add Estados
        for (Estado e : moore.getEstados()) {
            sb.append(e.getNome() + ", ");
        }
        sb = this.validaSequenciaGUI.formataSb(sb);

        Estado aux = moore.getEstadoInicial(); // Estado Inicial
        sb.append("S\u2080 = ");
        if (aux != null) {
            sb.append(aux.getNome());
        }
        sb.append("\n");
        this.validaSequenciaGUI.setTextAInf(sb.toString());

        sb = new StringBuffer();

        sb.append("F = {"); // Add Estados FInais
        for (Estado e : moore.getEstadosFinais()) {
            sb.append(e.getNome() + ", ");
        }
        sb = this.validaSequenciaGUI.formataSb(sb);

        sb.append("\u0394 = {");  // Add Simbolos da Pilha
        for (Simbolo s : moore.getSimbolosSaida()) {
            sb.append(s.getNome() + ", ");
        }
        sb = this.validaSequenciaGUI.formataSb(sb);



        for (Transicao t : moore.getTransicoes()) {
            sb.append("\n") // pula a linha
                    .append("\u03B4(").append(t.getEstOri().getNome()).append(",").append(t.getSimbolo().getNome()).append(") -> ").append(t.getEstDest().getNome());
        }

        sb.append("\n");
        for (Estado e : moore.getEstados()) {
            sb.append("\n").append("\u03B4\u2080 " + e.getNome() + " -> " + e.getSaida().getNome());
        }

        this.validaSequenciaGUI.setTextAInf(sb.toString());

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        validaSequenciaGUI = new br.uem.din.yandre.sctmf.view.components.ValidaSequenciaGUI();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());
        add(validaSequenciaGUI, java.awt.BorderLayout.CENTER);

        jLabel1.setPreferredSize(new java.awt.Dimension(0, 10));
        add(jLabel1, java.awt.BorderLayout.NORTH);
    }// </editor-fold>//GEN-END:initComponents

    private void posInitComponents() {
        this.validaSequenciaGUI.setSplitPaneLocation(150);

        this.validaSequenciaGUI.getBValidar().addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent ae) {
                        validarSequencia();
                    }
                });

    }

    private void validarSequencia() {
        this.validaSequenciaGUI.validarSequencia(
                (Moore) this.gui.getModeloFormal(),
                this.validaSequenciaGUI.getSequencia());
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private br.uem.din.yandre.sctmf.view.components.ValidaSequenciaGUI validaSequenciaGUI;
    // End of variables declaration//GEN-END:variables
}
