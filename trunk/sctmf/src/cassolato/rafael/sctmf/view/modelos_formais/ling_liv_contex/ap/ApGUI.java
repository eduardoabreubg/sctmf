/*
 * ApGUI.java
 *
 * Created on 4 de Junho de 2007, 21:13
 */

package cassolato.rafael.sctmf.view.modelos_formais.ling_liv_contex.ap;

import cassolato.rafael.sctmf.model.pojo.ModeloFormal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author  Cassolato
 */
public class ApGUI extends cassolato.rafael.sctmf.view.modelos_formais.ModeloFormalGUI {
    
    /** Creates new form BeanForm */
    public ApGUI() {
        initComponents();
        posInitComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel2 = new javax.swing.JLabel();
        tpAp = new javax.swing.JTabbedPane();
        pCadAlf = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel4.setText("\u03a3");
        listSim = new cassolato.rafael.sctmf.view.components.GenericJList();
        jPanel5 = new javax.swing.JPanel();
        listSimPilha = new cassolato.rafael.sctmf.view.components.GenericJList();
        jLabel5 = new javax.swing.JLabel();
        jLabel5.setText("\u0393");
        addRemButtonsS = new cassolato.rafael.sctmf.view.components.AddRemButtonsPanel();
        addRemButtonsSP = new cassolato.rafael.sctmf.view.components.AddRemButtonsPanel();
        letterNumber = new cassolato.rafael.sctmf.view.components.LetterNumber();
        pCadEstSimIni = new javax.swing.JPanel();
        pCadTrans = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        jLabel2.setPreferredSize(new java.awt.Dimension(0, 10));
        add(jLabel2, java.awt.BorderLayout.SOUTH);

        pCadAlf.setLayout(new java.awt.GridBagLayout());

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
        pCadAlf.add(jPanel4, gridBagConstraints);

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
        pCadAlf.add(jPanel5, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 20, 0, 0);
        pCadAlf.add(addRemButtonsS, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 131, 0, 0);
        pCadAlf.add(addRemButtonsSP, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 1, 0, 0);
        pCadAlf.add(letterNumber, gridBagConstraints);

        tpAp.addTab("Cad. Alfabetos", pCadAlf);

        pCadEstSimIni.setLayout(new javax.swing.BoxLayout(pCadEstSimIni, javax.swing.BoxLayout.Y_AXIS));

        tpAp.addTab("Cad. Est. e Sim. Ini(s)", pCadEstSimIni);

        tpAp.addTab("tab3", pCadTrans);

        add(tpAp, java.awt.BorderLayout.CENTER);
        tpAp.getAccessibleContext().setAccessibleName("ca");

    }// </editor-fold>//GEN-END:initComponents
    
   private void posInitComponents() {
        this.letterNumber.enableCbNumber(false);
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
        this.listSim.addItem(
            Character.toLowerCase(
                this.letterNumber.getLetter()));        
    }
    
    
   private void removeActionSimP() {
        this.listSimPilha.removeItens();          
    }
        
    private void addActionSimP() {
       this.listSimPilha.addItem(
            Character.toUpperCase(
                this.letterNumber.getLetter()));        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private cassolato.rafael.sctmf.view.components.AddRemButtonsPanel addRemButtonsS;
    private cassolato.rafael.sctmf.view.components.AddRemButtonsPanel addRemButtonsSP;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private cassolato.rafael.sctmf.view.components.LetterNumber letterNumber;
    private cassolato.rafael.sctmf.view.components.GenericJList listSim;
    private cassolato.rafael.sctmf.view.components.GenericJList listSimPilha;
    private javax.swing.JPanel pCadAlf;
    private javax.swing.JPanel pCadEstSimIni;
    private javax.swing.JPanel pCadTrans;
    private javax.swing.JTabbedPane tpAp;
    // End of variables declaration//GEN-END:variables

    public void setModeloFormal(ModeloFormal fm) {
    }

    public ModeloFormal getModeloFormal() {
        return null;
    }
    
}
