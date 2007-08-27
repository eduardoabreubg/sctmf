/*
 * CadAlfMT.java
 *
 * Created on 23 de Agosto de 2007, 08:37
 */

package cassolato.rafael.sctmf.view.modelos_formais.ling_enum_rec.mt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author  rafael2009_00
 */
public class CadAlfMT extends javax.swing.JPanel {
    
    /** Creates new form CadAlfMT */
    public CadAlfMT() {
        initComponents();
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
        listAlf = new cassolato.rafael.sctmf.view.components.GenericJList();
        jPanel5 = new javax.swing.JPanel();
        listAlfAux = new cassolato.rafael.sctmf.view.components.GenericJList();
        jLabel5 = new javax.swing.JLabel();
        addRemButtonsAlf = new cassolato.rafael.sctmf.view.components.AddRemButtonsPanel();
        addRemButtonsAlfAux = new cassolato.rafael.sctmf.view.components.AddRemButtonsPanel();
        letterNumber = new cassolato.rafael.sctmf.view.components.LetterNumber();

        setLayout(new java.awt.GridBagLayout());

        jPanel4.setLayout(new java.awt.BorderLayout());

        jPanel4.setToolTipText("S\u00edmbolos do Alfabeto da Linguagem");
        jLabel4.setFont(new java.awt.Font("Verdana", 0, 18));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setToolTipText("S\u00edmbolos N\u00e3o-Terminais");
        jLabel4.setText("\u03a3");
        jPanel4.add(jLabel4, java.awt.BorderLayout.NORTH);

        listAlf.setToolTipText("");
        jPanel4.add(listAlf, java.awt.BorderLayout.CENTER);

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
        listAlfAux.setToolTipText("");
        jPanel5.add(listAlfAux, java.awt.BorderLayout.CENTER);

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 18));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("V");
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
        add(addRemButtonsAlf, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 131, 0, 0);
        add(addRemButtonsAlfAux, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 1, 0, 0);
        add(letterNumber, gridBagConstraints);

    }// </editor-fold>//GEN-END:initComponents
    
    private void posInitComponents() {
        this.letterNumber.enableCbNumber(false);
        this.letterNumber.forceAllLowerCase(true);
        
         // Para o alfabeto dos alfAuxbolos nao-alfAuxinais
        this.addRemButtonsAlf.getBAdd().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae) {
                addActionalf(null);
            }
        });
        
        this.addRemButtonsAlf.getBRemove().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae) {
                removeActionalf();
            }
        });
        
        // Para o alfabeto dos alfAuxbolos da pilha
        this.addRemButtonsAlfAux.getBAdd().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae) {
                addActioAlf(null);
            }
        });
        
        this.addRemButtonsAlfAux.getBRemove().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae) {
                removeActioalf();
            }
        });
    }
    
    private void removeActionAlf() {
      for(Object o : this.listAlf.removeItens())
          this.glcGUI.removeSimbolo(
                new Simbolo((Character)o));            
    }
        
    private void addActionAlf(Simbolo simbalf) {
        if(simbalf==null)
            simbalf = new Simbolo(
                    Character.toUpperCase(this.letterNumber.getLetter()));
        
         this.listAlf.addItem(simbalf.getNome());
    }
       
   private void removeActioAlfAux() {
      for(Object o : this.listAlfAux.removeItens())
          this.glcGUI.removeSimbolo(
                new Simbolo((Character)o));                      
    }
        
    private void addActioAlfAux(Simbolo simbalfAux) { 
        if(simbAlfAux==null)
            simbAlfAux = new Simbolo(
                    Character.toLowerCase(this.letterNumber.getLetter()));
        
        this.listAlfAux.addItem(simbalfAux.getNome());
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private cassolato.rafael.sctmf.view.components.AddRemButtonsPanel addRemButtonsAlf;
    private cassolato.rafael.sctmf.view.components.AddRemButtonsPanel addRemButtonsAlfAux;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private cassolato.rafael.sctmf.view.components.LetterNumber letterNumber;
    private cassolato.rafael.sctmf.view.components.GenericJList listAlf;
    private cassolato.rafael.sctmf.view.components.GenericJList listAlfAux;
    // End of variables declaration//GEN-END:variables
    
}
