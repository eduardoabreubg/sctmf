/*
 * CadAlfGLC.java
 *
 * Created on 7 de Agosto de 2007, 08:39
 */

package br.uem.din.yandre.sctmf.view.modelos_formais.ling_liv_contex.glc;

import br.uem.din.yandre.sctmf.model.pojo.Simbolo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 *
 * @author  rafael2009_00
 */
public class CadAlfGLC extends javax.swing.JPanel {
    
    private GlcGUI glcGUI;
    
    /** Creates new form CadAlfGLC */
    public CadAlfGLC(GlcGUI glcGUI) {
        this.glcGUI = glcGUI;
        initComponents();
        posInitComponents();
    }
    
    /**
     * Retorna os simbolos terminais cadastrados
     */
    Set<Simbolo> getSimbTerminais() {
        Set<Simbolo> simbolos = new LinkedHashSet<Simbolo>();
        for(Object o : this.listTerm.getAllItens())
            simbolos.add(new Simbolo((Character)o));
            
        return simbolos;
    }
    
    /**
     * Retorna os simbolos nao-terminais cadastrados
     */
    Set<Simbolo> getSimNTermimais() {
        Set<Simbolo> simbolos = new LinkedHashSet<Simbolo>();
        for(Object o : this.listNTerm.getAllItens())
            simbolos.add(new Simbolo((Character)o));
            
        return simbolos;
    }
    
    /**
     * Limpa a lista dos simbolos terminais e add os recebidos no parametro.
     */
    void setSimTerminais(Collection<Simbolo> simbolos) {
        this.listTerm.removeAllItens();
        
        for(Simbolo s :simbolos )
            this.listTerm.addItem(s.getNome());
    }
    
    /**
     * Limpa a lista dos simbolos nao-terminais e add os recebidos no parametro.
     */
    void setSimNTerminais(Collection<Simbolo> simbolos) {
        this.listNTerm.removeAllItens();
        
        for(Simbolo s :simbolos)
            this.listNTerm.addItem(s.getNome());
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        listNTerm = new br.uem.din.yandre.sctmf.view.components.GenericJList();
        jPanel5 = new javax.swing.JPanel();
        listTerm = new br.uem.din.yandre.sctmf.view.components.GenericJList();
        jLabel5 = new javax.swing.JLabel();
        addRemButtonsNTerm = new br.uem.din.yandre.sctmf.view.components.AddRemButtonsPanel();
        addRemButtonsTerm = new br.uem.din.yandre.sctmf.view.components.AddRemButtonsPanel();
        letterNumber = new br.uem.din.yandre.sctmf.view.components.LetterNumber();

        setLayout(new java.awt.GridBagLayout());

        jPanel4.setLayout(new java.awt.BorderLayout());

        jPanel4.setToolTipText("S\u00edmbolos do Alfabeto da Linguagem");
        jLabel4.setFont(new java.awt.Font("Verdana", 0, 18));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("V");
        jLabel4.setToolTipText("S\u00edmbolos N\u00e3o-Terminais");
        jPanel4.add(jLabel4, java.awt.BorderLayout.NORTH);

        listNTerm.setToolTipText("");
        jPanel4.add(listNTerm, java.awt.BorderLayout.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.ipadx = 16;
        gridBagConstraints.ipady = 166;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 10, 0);
        add(jPanel4, gridBagConstraints);

        jPanel5.setLayout(new java.awt.BorderLayout());

        jPanel5.setToolTipText("S\u00edmbolos do Alfabeto da Pilha");
        listTerm.setToolTipText("");
        jPanel5.add(listTerm, java.awt.BorderLayout.CENTER);

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 18));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("T");
        jLabel5.setToolTipText("S\u00edmbolos Terminais");
        jPanel5.add(jLabel5, java.awt.BorderLayout.NORTH);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.ipadx = 16;
        gridBagConstraints.ipady = 166;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 21, 10, 21);
        add(jPanel5, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 0, 0);
        add(addRemButtonsNTerm, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 131, 0, 0);
        add(addRemButtonsTerm, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 1, 0, 0);
        add(letterNumber, gridBagConstraints);

    }// </editor-fold>//GEN-END:initComponents
    
     private void posInitComponents() {
        this.letterNumber.forceAllLowerCase(true);
        
         // Para o alfabeto dos Termbolos nao-terminais
        this.addRemButtonsNTerm.getBAdd().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae) {
                addActionNTerm(null);
            }
        });
        
        this.addRemButtonsNTerm.getBRemove().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae) {
                removeActionNTerm();
            }
        });
        
        // Para o alfabeto dos Termbolos da pilha
        this.addRemButtonsTerm.getBAdd().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae) {
                addActionTerm(null);
            }
        });
        
        this.addRemButtonsTerm.getBRemove().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae) {
                removeActionTerm();
            }
        });
    }
    
    private void removeActionNTerm() {
      for(Object o : this.listNTerm.removeItens())
          this.glcGUI.removeSimbolo(
                new Simbolo((Character)o));            
    }
        
    private void addActionNTerm(Simbolo simbNTerm) {
        Character c = this.letterNumber.getValue();
        if (!Character.isDigit(c)) {
            if(simbNTerm==null)
                simbNTerm = new Simbolo(
                        Character.toUpperCase(c));

             this.listNTerm.addItem(simbNTerm.getNome());    
             
        } else {
            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "S�o permitidos somente LETRAS para\n" +
                    "os S�mbolos N�o-Terminais",
                    "Aten��o",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
        }
                
    }
       
   private void removeActionTerm() {
      for(Object o : this.listTerm.removeItens())
          this.glcGUI.removeSimbolo(
                new Simbolo((Character)o));                      
    }
        
    private void addActionTerm(Simbolo simbTerm) { 
        if(simbTerm==null)
            simbTerm = new Simbolo(
                    Character.toLowerCase(this.letterNumber.getValue()));
        
        this.listTerm.addItem(simbTerm.getNome());
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private br.uem.din.yandre.sctmf.view.components.AddRemButtonsPanel addRemButtonsNTerm;
    private br.uem.din.yandre.sctmf.view.components.AddRemButtonsPanel addRemButtonsTerm;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private br.uem.din.yandre.sctmf.view.components.LetterNumber letterNumber;
    private br.uem.din.yandre.sctmf.view.components.GenericJList listNTerm;
    private br.uem.din.yandre.sctmf.view.components.GenericJList listTerm;
    // End of variables declaration//GEN-END:variables
    
}