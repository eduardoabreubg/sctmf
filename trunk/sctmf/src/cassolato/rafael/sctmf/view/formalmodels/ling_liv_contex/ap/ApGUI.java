/*
 * ApGUI.java
 *
 * Created on 4 de Junho de 2007, 21:13
 */

package cassolato.rafael.sctmf.view.formalmodels.ling_liv_contex.ap;

import cassolato.rafael.sctmf.model.pojo.FormalModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author  Cassolato
 */
public class ApGUI extends cassolato.rafael.sctmf.view.FormalModelGUI {
    
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
    // <editor-fold defaultstate="collapsed" desc=" C�digo Gerado ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tpCadAlf = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel4.setText("\u03a3");
        listSim = new cassolato.rafael.sctmf.view.components.GenericJList();
        jPanel5 = new javax.swing.JPanel();
        listSimPilha = new cassolato.rafael.sctmf.view.components.GenericJList();
        jLabel5 = new javax.swing.JLabel();
        jLabel5.setText("\u0393");
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        jLabel1.setPreferredSize(new java.awt.Dimension(10, 0));
        add(jLabel1, java.awt.BorderLayout.EAST);

        jLabel2.setPreferredSize(new java.awt.Dimension(0, 10));
        add(jLabel2, java.awt.BorderLayout.SOUTH);

        jLabel3.setPreferredSize(new java.awt.Dimension(10, 0));
        add(jLabel3, java.awt.BorderLayout.WEST);

        jPanel1.setLayout(null);

        jPanel4.setLayout(new java.awt.BorderLayout());

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 18));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel4.add(jLabel4, java.awt.BorderLayout.NORTH);

        jPanel4.add(listSim, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel4);
        jPanel4.setBounds(20, 30, 40, 190);

        jPanel5.setLayout(new java.awt.BorderLayout());

        jPanel5.add(listSimPilha, java.awt.BorderLayout.CENTER);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel5.add(jLabel5, java.awt.BorderLayout.NORTH);

        jPanel1.add(jPanel5);
        jPanel5.setBounds(340, 30, 40, 190);

        tpCadAlf.addTab("Cad. Alfabetos", jPanel1);

        tpCadAlf.addTab("tab2", jPanel2);

        tpCadAlf.addTab("tab3", jPanel3);

        add(tpCadAlf, java.awt.BorderLayout.CENTER);
        tpCadAlf.getAccessibleContext().setAccessibleName("ca");

    }// </editor-fold>//GEN-END:initComponents
    
   private void posInitComponents() {
        /*this.letterNumber.enableCbNumber(false);
                
        // Para o alfabeto dos simbolos da pilha
        this.addRemoveButtonsS.getBAdd().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae) {
                addActionSim();
            }
        });
        
        this.addRemoveButtonsS.getBRemove().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae) {
                removeActionSimP();
            }
        });
        
        // Para o alfabeto dos simbolos da pilha
        this.addRemoveButtonsSP.getBAdd().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae) {
                addActionSimP();
            }
        });
        
        this.addRemoveButtonsSP.getBRemove().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae) {
                removeActionSim();
            }
        });*/
    }
   
   /*
   private void removeActionSim() {
        for(Object o : this.genericJList.removeItens())
            this.letterNumberCA.addItem(o.toString().toUpperCase());  
        
    }
        
    private void addActionSim() {
        Character item = this.genericJList.addItem(
                    this.letterNumberCA.getLetter());
        this.letterNumberCA.removeItem(item.toString().toUpperCase());
    }
    
    
   private void removeActionSimP() {
        for(Object o : this.genericJList.removeItens())
            this.letterNumberCA.addItem(o.toString().toUpperCase());  
        
    }
        
    private void addActionSimP() {
        Character item = this.genericJList.addItem(
                    this.letterNumberCA.getLetter());
        this.letterNumberCA.removeItem(item.toString().toUpperCase());
    }*/
    
    // Declara��o de vari�veis - n�o modifique//GEN-BEGIN:variables
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
    private cassolato.rafael.sctmf.view.components.GenericJList listSim;
    private cassolato.rafael.sctmf.view.components.GenericJList listSimPilha;
    private javax.swing.JTabbedPane tpCadAlf;
    // Fim da declara��o de vari�veis//GEN-END:variables

    public void setFormalModel(FormalModel fm) {
    }

    public FormalModel getFormalModel() {
        return null;
    }
    
}
