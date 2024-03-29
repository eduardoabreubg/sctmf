/*
 * CadAlfAP.java
 *
 * Created on 19 de Junho de 2007, 09:19
 */

package br.uem.din.yandre.sctmf.view.modelos_formais.ling_liv_contex.ap;

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
public class CadAlfAP extends javax.swing.JPanel {
    
    private ApGUI apGUI = null;
    
    /** Creates new form CadAlfAP */
    public CadAlfAP(ApGUI apGUI) {
        this.apGUI = apGUI;
        initComponents();
        posInitComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" C�digo Gerado ">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel4.setText("\u03a3");
        listSim = new br.uem.din.yandre.sctmf.view.components.GenericJList();
        jPanel5 = new javax.swing.JPanel();
        listSimPilha = new br.uem.din.yandre.sctmf.view.components.GenericJList();
        jLabel5 = new javax.swing.JLabel();
        jLabel5.setText("\u0393");
        addRemButtonsS = new br.uem.din.yandre.sctmf.view.components.AddRemButtonsPanel();
        addRemButtonsSP = new br.uem.din.yandre.sctmf.view.components.AddRemButtonsPanel();
        letterNumber = new br.uem.din.yandre.sctmf.view.components.LetterNumber();

        setLayout(new java.awt.GridBagLayout());

        jPanel4.setLayout(new java.awt.BorderLayout());

        jPanel4.setToolTipText("S\u00edmbolos do Alfabeto da Linguagem");
        jLabel4.setFont(new java.awt.Font("Verdana", 0, 18));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setToolTipText("S\u00edmbolos do Alfabeto da Linguagem");
        jPanel4.add(jLabel4, java.awt.BorderLayout.NORTH);

        listSim.setToolTipText("S\u00edmbolos do Alfabeto da Linguagem");
        jPanel4.add(listSim, java.awt.BorderLayout.CENTER);

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
        listSimPilha.setToolTipText("S\u00edmbolos do Alfabeto da Pilha");
        jPanel5.add(listSimPilha, java.awt.BorderLayout.CENTER);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setToolTipText("S\u00edmbolos do Alfabeto da Pilha");
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
        add(addRemButtonsS, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 131, 0, 0);
        add(addRemButtonsSP, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 1, 0, 0);
        add(letterNumber, gridBagConstraints);

    }// </editor-fold>//GEN-END:initComponents
    
    Set<Simbolo> getSimbsAfabeto() {
        Set<Simbolo> simbolos = new LinkedHashSet<Simbolo>();
        for(Object o : this.listSim.getAllItens())
            simbolos.add(new Simbolo((Character)o));
            
        return simbolos;
    }
    
    Set<Simbolo> getSimbsAfabetoPilha() {
        Set<Simbolo> simbolos = new LinkedHashSet<Simbolo>();                
        for(Object o : this.listSimPilha.getAllItens())
            simbolos.add(new Simbolo((Character)o));
        
        return simbolos;
    }
    
    void setSimbsAfabeto(Collection<Simbolo> simbAlf) {
        this.listSim.removeAllItens();
        
        for(Simbolo s :simbAlf )
            this.listSim.addItem(s.getNome());
    }
    
    void setSimbsAfabetoPilha(Collection<Simbolo> simbAlfPilha) {
        this.listSimPilha.removeAllItens();
        
        for(Simbolo s : simbAlfPilha )
            this.listSimPilha.addItem(s.getNome());
    }

    private void posInitComponents() {
        this.letterNumber.forceAllLowerCase(true);
        this.listSim.setToolTipText("S�mbolos do Alfabeto da Linguagem");
        this.listSimPilha.setToolTipText("S�mbolos do Alfabeto da Pilha");
        
         // Para o alfabeto dos simbolos da pilha
        this.addRemButtonsS.getBAdd().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae) {
                addActionSim();
            }
        });
        
        this.addRemButtonsS.getBRemove().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae) {
                removeActionSim();
            }
        });
        
        // Para o alfabeto dos simbolos da pilha
        this.addRemButtonsSP.getBAdd().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae) {
                addActionSimP();
            }
        });
        
        this.addRemButtonsSP.getBRemove().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae) {
                removeActionSimP();
            }
        });
    }
    
    private void removeActionSim() {
      this.listSim.removeItens();           
    }
        
    private void addActionSim() {    
        this.listSim.addItem(this.letterNumber.getValue());
    }
       
   private void removeActionSimP() {
       for(Object o : this.listSimPilha.removeItens())
            this.apGUI.remSimPilha(new Simbolo((Character)o));                      
    }
        
    private void addActionSimP() {  
        Character c = letterNumber.getValue();
        if (!Character.isDigit(c)) {
            this.apGUI.addSimPilha(
            new Simbolo(
                this.listSimPilha.addItem(
                    Character.toUpperCase(c))));             
            
        } else {
            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "S�o permitidos somente LETRAS para\n" +
                    "os S�mbolos do Alfabeto da Pilha",
                    "Aten��o",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
        }
        
        
    }
    
    // Declara��o de vari�veis - n�o modifique//GEN-BEGIN:variables
    private br.uem.din.yandre.sctmf.view.components.AddRemButtonsPanel addRemButtonsS;
    private br.uem.din.yandre.sctmf.view.components.AddRemButtonsPanel addRemButtonsSP;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private br.uem.din.yandre.sctmf.view.components.LetterNumber letterNumber;
    private br.uem.din.yandre.sctmf.view.components.GenericJList listSim;
    private br.uem.din.yandre.sctmf.view.components.GenericJList listSimPilha;
    // Fim da declara��o de vari�veis//GEN-END:variables
    
}
