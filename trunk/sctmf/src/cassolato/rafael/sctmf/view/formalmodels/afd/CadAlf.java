/*
 * CadAlf.java
 *
 * Created on 3 de Maio de 2007, 09:47
 */

package cassolato.rafael.sctmf.view.formalmodels.afd;

import cassolato.rafael.sctmf.model.pojo.Simbolo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;


/**
 *
 * @author  rafael2009_00
 */
public class CadAlf extends javax.swing.JPanel {
    
    /** Creates new form CadAlf */
    public CadAlf() {
        initComponents();   
        this.posInitComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" C�digo Gerado ">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        pCadAlf = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        genericJList = new cassolato.rafael.sctmf.view.components.GenericJList();
        addRemoveButtons = new view.AddRemButtonsPanel();
        letterNumberCA = new view.LetterNumber();

        setLayout(new java.awt.GridLayout(1, 0));

        pCadAlf.setLayout(new java.awt.GridBagLayout());

        pCadAlf.setBorder(javax.swing.BorderFactory.createTitledBorder(null, " Cadastro do Alfabeto ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(51, 51, 255)));
        pCadAlf.setMinimumSize(new java.awt.Dimension(420, 240));
        pCadAlf.setPreferredSize(new java.awt.Dimension(420, 240));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jLabel1.setPreferredSize(new java.awt.Dimension(0, 5));
        jPanel3.add(jLabel1, java.awt.BorderLayout.NORTH);

        jLabel3.setPreferredSize(new java.awt.Dimension(35, 0));
        jPanel3.add(jLabel3, java.awt.BorderLayout.EAST);

        jLabel4.setPreferredSize(new java.awt.Dimension(35, 0));
        jPanel3.add(jLabel4, java.awt.BorderLayout.WEST);

        jPanel4.setLayout(new java.awt.BorderLayout());

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 18));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("\u03a3");
        jPanel4.add(jLabel6, java.awt.BorderLayout.NORTH);

        jPanel4.add(genericJList, java.awt.BorderLayout.CENTER);

        jPanel3.add(jPanel4, java.awt.BorderLayout.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.ipadx = 126;
        gridBagConstraints.ipady = 173;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(1, 6, 3, 0);
        pCadAlf.add(jPanel3, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(79, 4, 0, 0);
        pCadAlf.add(addRemoveButtons, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 28, 0, 30);
        pCadAlf.add(letterNumberCA, gridBagConstraints);

        add(pCadAlf);

    }// </editor-fold>//GEN-END:initComponents
          
    public Collection<Simbolo> getSimbolos() {
        Set<Simbolo> simbolos = new LinkedHashSet<Simbolo>();
        Iterator<Object> i = 
                this.genericJList.getAllItens().iterator();
        
        while(i.hasNext()) 
            simbolos.add(new Simbolo((Character)i.next())) ;
        
        return simbolos;            
    }
    
    public void addSimbolos(Collection<Simbolo> simbolos ) {
        this.genericJList.removeAllItens();
        
        Iterator<Simbolo> i = simbolos.iterator();        
        while(i.hasNext())
            this.genericJList.addItem(i.next().getNome());
        
    }
    
    private void posInitComponents() {
        this.letterNumberCA.enableCbNumber(false);
        this.letterNumberCA.forceAllLowerCase(true);
        
        this.addRemoveButtons.getBAdd().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae) {
                addAction();
            }
        });
        
        this.addRemoveButtons.getBRemove().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae) {
                removeAction();
            }
        });
    }
    
    private void removeAction() {
        for(Object o : this.genericJList.removeItens())
            this.letterNumberCA.addItem(o.toString().toUpperCase());  
        
    }
    
    private void addAction() {
        Character item = this.genericJList.addItem(
                    this.letterNumberCA.getLetter());
        this.letterNumberCA.removeItem(item.toString().toUpperCase());
    }
    // Declara��o de vari�veis - n�o modifique//GEN-BEGIN:variables
    private view.AddRemButtonsPanel addRemoveButtons;
    private cassolato.rafael.sctmf.view.components.GenericJList genericJList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private view.LetterNumber letterNumberCA;
    private javax.swing.JPanel pCadAlf;
    // Fim da declara��o de vari�veis//GEN-END:variables
    
}
