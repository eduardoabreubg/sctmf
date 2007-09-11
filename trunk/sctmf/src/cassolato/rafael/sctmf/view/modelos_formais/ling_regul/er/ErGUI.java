/*
 * ErGUI.java
 *
 * Created on 6 de Setembro de 2007, 08:31
 */

package cassolato.rafael.sctmf.view.modelos_formais.ling_regul.er;

import cassolato.rafael.sctmf.model.pojo.ER;
import cassolato.rafael.sctmf.model.pojo.ModeloFormal;
import cassolato.rafael.sctmf.model.pojo.Simbolo;
import cassolato.rafael.sctmf.model.services.ValidaSequencia;
import cassolato.rafael.sctmf.model.services.Validacao;
import cassolato.rafael.sctmf.view.modelos_formais.ModeloFormalGUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 *
 * @author  rafael2009_00
 */
public class ErGUI extends ModeloFormalGUI {
    private Validacao validacao = ValidaSequencia.getInstance();
        
    /** Creates new form ErGUI */
    public ErGUI() {
        initComponents();
        posInitComponents();
    }
    
    public void setModeloFormal(ModeloFormal mf) {
        ER er = (ER)mf;
        this.listSimb.removeAllItens();
        this.cbSimbolo.removeAllItems();
        this.fExprReg.setText("");
        
        for(Simbolo s :er.getAlfabeto())
            this.addAction(s);
        
        this.fExprReg.setText(er.getExpressaoRegular());
            
    }

    public ModeloFormal getModeloFormal() {
        ER er = new ER();
        for(Object o :this.listSimb.getAllItens())
            er.addSimboAlf(new Simbolo((Character)o));
        
        er.setExpressaoRegular(this.fExprReg.getText());
        
        return er;
    }    
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        listSimb = new cassolato.rafael.sctmf.view.components.GenericJList();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        addRemButtons = new cassolato.rafael.sctmf.view.components.AddRemButtonsPanel();
        letterNumber = new cassolato.rafael.sctmf.view.components.LetterNumber();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        cbSimbolo = new javax.swing.JComboBox();
        bAddSimbolo = new javax.swing.JButton();
        bAddParEsq = new javax.swing.JButton();
        bAddParDir = new javax.swing.JButton();
        bAddUniao = new javax.swing.JButton();
        bAddConcatSuc = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        bDesfazer = new javax.swing.JButton();
        fExprReg = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        fSequencia = new javax.swing.JTextField();
        bTestar = new javax.swing.JButton();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));

        setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        jPanel2.setPreferredSize(new java.awt.Dimension(607, 75));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel1.add(listSimb, java.awt.BorderLayout.CENTER);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("E");
        jLabel1.setText("\u03a3");
        jPanel1.add(jLabel1, java.awt.BorderLayout.NORTH);

        jLabel2.setPreferredSize(new java.awt.Dimension(0, 5));
        jPanel1.add(jLabel2, java.awt.BorderLayout.SOUTH);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.ipadx = 26;
        gridBagConstraints.ipady = 96;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        jPanel2.add(jPanel1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(27, 50, 0, 0);
        jPanel2.add(addRemButtons, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(17, 41, 0, 18);
        jPanel2.add(letterNumber, gridBagConstraints);

        add(jPanel2);

        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel3.setPreferredSize(new java.awt.Dimension(10, 5));
        jLabel3.setPreferredSize(new java.awt.Dimension(30, 14));
        jPanel3.add(jLabel3, java.awt.BorderLayout.WEST);

        jLabel4.setPreferredSize(new java.awt.Dimension(30, 14));
        jPanel3.add(jLabel4, java.awt.BorderLayout.EAST);

        jPanel5.setLayout(new java.awt.GridLayout(2, 0, 0, 5));

        jPanel6.setLayout(new java.awt.GridLayout(1, 5, 10, 0));

        jPanel8.setLayout(new java.awt.BorderLayout());

        cbSimbolo.setFont(new java.awt.Font("Tahoma", 1, 14));
        jPanel8.add(cbSimbolo, java.awt.BorderLayout.CENTER);

        bAddSimbolo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/toolbarButtonGraphics/navigation/Down16.gif")));
        bAddSimbolo.setToolTipText("Adiciona o S\u00edmbolo");
        bAddSimbolo.setPreferredSize(new java.awt.Dimension(17, 25));
        bAddSimbolo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAddSimboloActionPerformed(evt);
            }
        });

        jPanel8.add(bAddSimbolo, java.awt.BorderLayout.EAST);

        jPanel6.add(jPanel8);

        bAddParEsq.setFont(new java.awt.Font("Verdana", 1, 14));
        bAddParEsq.setText("(");
        bAddParEsq.setToolTipText("");
        bAddParEsq.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bAddParEsq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAddParEsqActionPerformed(evt);
            }
        });

        jPanel6.add(bAddParEsq);

        bAddParDir.setFont(new java.awt.Font("Verdana", 1, 14));
        bAddParDir.setText(")");
        bAddParDir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bAddParDir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAddParDirActionPerformed(evt);
            }
        });

        jPanel6.add(bAddParDir);

        bAddUniao.setFont(new java.awt.Font("Verdana", 1, 14));
        bAddUniao.setText("+");
        bAddUniao.setToolTipText("Uni\u00e3o");
        bAddUniao.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bAddUniao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAddUniaoActionPerformed(evt);
            }
        });

        jPanel6.add(bAddUniao);

        bAddConcatSuc.setFont(new java.awt.Font("Verdana", 1, 14));
        bAddConcatSuc.setText("*");
        bAddConcatSuc.setToolTipText("Concatena\u00e7\u00e3o Sucessiva");
        bAddConcatSuc.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bAddConcatSuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAddConcatSucActionPerformed(evt);
            }
        });

        jPanel6.add(bAddConcatSuc);

        jPanel5.add(jPanel6);

        jPanel7.setLayout(new java.awt.BorderLayout(10, 0));

        bDesfazer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/toolbarButtonGraphics/general/Undo16.gif")));
        bDesfazer.setToolTipText("Desfazer");
        bDesfazer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDesfazerActionPerformed(evt);
            }
        });

        jPanel7.add(bDesfazer, java.awt.BorderLayout.EAST);

        fExprReg.setEditable(false);
        fExprReg.setFont(new java.awt.Font("Verdana", 0, 18));
        fExprReg.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fExprReg.setAlignmentY(0.0F);
        jPanel7.add(fExprReg, java.awt.BorderLayout.CENTER);

        jPanel5.add(jPanel7);

        jPanel3.add(jPanel5, java.awt.BorderLayout.CENTER);

        jLabel5.setPreferredSize(new java.awt.Dimension(34, 5));
        jPanel3.add(jLabel5, java.awt.BorderLayout.NORTH);

        add(jPanel3);

        jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 5));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Valida\u00e7\u00e3o", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 204)));
        fSequencia.setFont(new java.awt.Font("Verdana", 0, 18));
        fSequencia.setPreferredSize(new java.awt.Dimension(150, 25));
        jPanel4.add(fSequencia);

        bTestar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/toolbarButtonGraphics/general/History24.gif")));
        bTestar.setText("Testar");
        bTestar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bTestarActionPerformed(evt);
            }
        });

        jPanel4.add(bTestar);

        add(jPanel4);

    }// </editor-fold>//GEN-END:initComponents

    private void bTestarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bTestarActionPerformed
        validacao.valida(this.getModeloFormal(), this.fExprReg.getText());
    }//GEN-LAST:event_bTestarActionPerformed

    private void bDesfazerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDesfazerActionPerformed
        String str = fExprReg.getText();
        int tamStr = str.length();
        if(tamStr>0)
            fExprReg.setText(str.substring(0,tamStr-1));        
    }//GEN-LAST:event_bDesfazerActionPerformed

    private void bAddConcatSucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAddConcatSucActionPerformed
         this.fExprReg.setText(fExprReg.getText()+"*");              
    }//GEN-LAST:event_bAddConcatSucActionPerformed

    private void bAddUniaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAddUniaoActionPerformed
        this.fExprReg.setText(fExprReg.getText()+"+");  
    }//GEN-LAST:event_bAddUniaoActionPerformed

    private void bAddParDirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAddParDirActionPerformed
        this.fExprReg.setText(fExprReg.getText()+")");     
    }//GEN-LAST:event_bAddParDirActionPerformed

    private void bAddParEsqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAddParEsqActionPerformed
        this.fExprReg.setText(fExprReg.getText()+"(");     
    }//GEN-LAST:event_bAddParEsqActionPerformed

    private void bAddSimboloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAddSimboloActionPerformed
        Object o = this.cbSimbolo.getSelectedItem();
        if(o!=null)
            this.fExprReg.setText(fExprReg.getText()+o.toString());     
    }//GEN-LAST:event_bAddSimboloActionPerformed
    
    private void posInitComponents() {        
        this.addRemButtons.getBAdd().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae) {
                addAction(null);
            }
        });
        
        this.addRemButtons.getBRemove().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae) {
                removeAction();
            }
        });
        
        letterNumber.enableCbNumber(false);
    }
    
    private void addAction(Simbolo s) {
        if(s==null) 
            s = new Simbolo(letterNumber.getLetter());                   
               
        final char name = s.getNome();
        if(this.listSimb.addItem(name)!=null)      
            this.cbSimbolo.addItem(name);
        
    }
    
    private void removeAction() {
        for(Object o : this.listSimb.removeItens())
            observerRemove((Character)o);
    }
    
    private void observerRemove(Character c) {
        this.cbSimbolo.removeItem(c);
        // Verifica se existe o simbolo na str, caso ache, remove
        String str = this.fExprReg.getText();
        str = str.replaceAll(c.toString(),"");
        this.fExprReg.setText(str);
    }        
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private cassolato.rafael.sctmf.view.components.AddRemButtonsPanel addRemButtons;
    private javax.swing.JButton bAddConcatSuc;
    private javax.swing.JButton bAddParDir;
    private javax.swing.JButton bAddParEsq;
    private javax.swing.JButton bAddSimbolo;
    private javax.swing.JButton bAddUniao;
    private javax.swing.JButton bDesfazer;
    private javax.swing.JButton bTestar;
    private javax.swing.JComboBox cbSimbolo;
    private javax.swing.JTextField fExprReg;
    private javax.swing.JTextField fSequencia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private cassolato.rafael.sctmf.view.components.LetterNumber letterNumber;
    private cassolato.rafael.sctmf.view.components.GenericJList listSimb;
    // End of variables declaration//GEN-END:variables
}