/*
 * CadEstSimIniAP.java
 *
 * Created on 19 de Junho de 2007, 09:22
 */

package br.uem.din.yandre.sctmf.view.modelos_formais.ling_liv_contex.ap;

import br.uem.din.yandre.sctmf.model.pojo.Estado;
import br.uem.din.yandre.sctmf.model.pojo.Simbolo;
import br.uem.din.yandre.sctmf.view.components.CEstado;
import java.util.Set;

/**
 *
 * @author  rafael2009_00
 */
public class CadEstSimIniAP extends javax.swing.JPanel implements CEstado {
    
    private CEstado cEstado;
    
    /** Creates new form CadEstSimIniAP */
    public CadEstSimIniAP(CEstado cEstado) {
        this.cEstado = cEstado;
        initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        cadEstado = new br.uem.din.yandre.sctmf.view.components.CadEstado(this);
        jLabel16 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        cbEstadoInicial = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        cbSimTopoPilha = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        jLabel6.setPreferredSize(new java.awt.Dimension(0, 10));
        add(jLabel6, java.awt.BorderLayout.NORTH);

        jLabel8.setPreferredSize(new java.awt.Dimension(34, 10));
        add(jLabel8, java.awt.BorderLayout.SOUTH);

        jLabel9.setPreferredSize(new java.awt.Dimension(15, 0));
        add(jLabel9, java.awt.BorderLayout.EAST);

        jLabel10.setPreferredSize(new java.awt.Dimension(15, 0));
        add(jLabel10, java.awt.BorderLayout.WEST);

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.Y_AXIS));

        jPanel1.add(cadEstado);

        jLabel16.setText(" ");
        jPanel1.add(jLabel16);

        jPanel2.setLayout(new java.awt.GridLayout(1, 2));

        jPanel2.setPreferredSize(new java.awt.Dimension(10, 120));
        jPanel3.setBackground(new java.awt.Color(255, 255, 204));
        jPanel6.setLayout(new java.awt.BorderLayout(0, 3));

        jPanel6.setBackground(new java.awt.Color(255, 255, 204));
        jPanel6.setPreferredSize(new java.awt.Dimension(100, 60));
        cbEstadoInicial.setFont(new java.awt.Font("Verdana", 1, 16));
        jPanel6.add(cbEstadoInicial, java.awt.BorderLayout.CENTER);

        jLabel1.setBackground(new java.awt.Color(255, 255, 204));
        jLabel1.setFont(new java.awt.Font("Bitstream Vera Sans", 0, 14));
        jLabel1.setText("Estado Inicial");
        jPanel6.add(jLabel1, java.awt.BorderLayout.NORTH);

        jLabel3.setPreferredSize(new java.awt.Dimension(10, 14));
        jPanel6.add(jLabel3, java.awt.BorderLayout.EAST);

        jLabel7.setPreferredSize(new java.awt.Dimension(34, 10));
        jPanel6.add(jLabel7, java.awt.BorderLayout.SOUTH);

        jLabel11.setPreferredSize(new java.awt.Dimension(10, 14));
        jPanel6.add(jLabel11, java.awt.BorderLayout.WEST);

        jPanel3.add(jPanel6);

        jPanel2.add(jPanel3);

        jPanel4.setBackground(new java.awt.Color(204, 255, 204));
        jPanel8.setLayout(new java.awt.BorderLayout(0, 3));

        jPanel8.setBackground(new java.awt.Color(204, 255, 204));
        jPanel8.setPreferredSize(new java.awt.Dimension(130, 60));
        cbSimTopoPilha.setFont(new java.awt.Font("Verdana", 1, 16));
        jPanel8.add(cbSimTopoPilha, java.awt.BorderLayout.CENTER);

        jLabel12.setBackground(new java.awt.Color(255, 255, 204));
        jLabel12.setFont(new java.awt.Font("Bitstream Vera Sans", 0, 14));
        jLabel12.setText("S\u00edm. Base da Pilha");
        jPanel8.add(jLabel12, java.awt.BorderLayout.NORTH);

        jLabel13.setPreferredSize(new java.awt.Dimension(20, 14));
        jPanel8.add(jLabel13, java.awt.BorderLayout.EAST);

        jLabel14.setPreferredSize(new java.awt.Dimension(34, 10));
        jPanel8.add(jLabel14, java.awt.BorderLayout.SOUTH);

        jLabel15.setPreferredSize(new java.awt.Dimension(20, 14));
        jPanel8.add(jLabel15, java.awt.BorderLayout.WEST);

        jPanel4.add(jPanel8);

        jPanel2.add(jPanel4);

        jPanel1.add(jPanel2);

        add(jPanel1, java.awt.BorderLayout.CENTER);

    }// </editor-fold>//GEN-END:initComponents

    public void addEstado(Estado estado) {
        this.cbEstadoInicial.addItem(estado.getNome());        
        this.cEstado.addEstado(estado);
    }

    public void remEstados(Set<Estado> estados) {
        for(Estado e : estados) 
            this.cbEstadoInicial.removeItem(e.getNome());
        
        this.cEstado.remEstados(estados);
    }

    public void removeAllItens() {
        this.cadEstado.removeAllItens();
        this.cbEstadoInicial.removeAllItems();
        this.cEstado.removeAllItens();
    }
    
    Set<Estado> getEstados() {
        return this.cadEstado.getAllItens();
    }
    
    Simbolo getSimbTopoPilha() {
        Object o = this.cbSimTopoPilha.getSelectedItem();
        if(o!=null)
            return new Simbolo((Character)o);
        else
            return null;
    }
    
    Estado getEstadoInicial() {
        Object o = this.cbEstadoInicial.getSelectedItem();
        if(o!=null)
            return new Estado(o.toString());
        
        return null;
    }
    
    void setEstados(Set<Estado> estados) {   
        this.removeAllItens();
                
        for(Estado e : estados) 
            this.cadEstado.addEstado(e);
            
    }
    
    void setSimbTopoPilha(Simbolo sTP) {
        if(sTP!=null)
            this.cbSimTopoPilha.setSelectedItem(sTP.getNome());
    }
    
    void setEstadoInicial(Estado ei) {
        if(ei!=null)
            this.cbEstadoInicial.setSelectedItem(ei.getNome());
    }
        
    void addSimPilha(Simbolo s) {
        this.cbSimTopoPilha.addItem(s.getNome());
    }
    
    void addSimbolosPilha(Set<Simbolo> simbolos) {
        this.cbSimTopoPilha.removeAllItems();
        for(Simbolo s : simbolos)
            this.addSimPilha(s);
    }
    
    
    void remSimPilha(Simbolo s) {
        this.cbSimTopoPilha.removeItem(s.getNome());
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private br.uem.din.yandre.sctmf.view.components.CadEstado cadEstado;
    private javax.swing.JComboBox cbEstadoInicial;
    private javax.swing.JComboBox cbSimTopoPilha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    // End of variables declaration//GEN-END:variables
    
}
