/*
 * CadEstado.java
 *
 * Created on 13 de Junho de 2007, 19:35
 */

package cassolato.rafael.sctmf.view.components;

import cassolato.rafael.sctmf.model.pojo.Estado;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 *
 * @author  Cassolato
 */
public class CadEstado extends javax.swing.JPanel 
    implements CEstado {
    
     private CEstado component = null;
    
    /** Creates new form CadEstado */
    public CadEstado() {
        initComponents();
    }
    
    public CadEstado(CEstado component) {    
        this.component = component;
                
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
        jPanel28 = new javax.swing.JPanel();
        lN = new cassolato.rafael.sctmf.view.components.LetterNumber();
        jPanel29 = new javax.swing.JPanel();
        addRemEstado = new cassolato.rafael.sctmf.view.components.AddRemButtonsPanel();
        jLabel45 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jPanel30 = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        genericJList = new cassolato.rafael.sctmf.view.components.GenericJList();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.X_AXIS));

        setMinimumSize(new java.awt.Dimension(400, 130));
        setPreferredSize(new java.awt.Dimension(400, 130));
        jPanel28.add(lN);

        add(jPanel28);

        jPanel29.setLayout(new java.awt.BorderLayout());

        jPanel29.setMaximumSize(new java.awt.Dimension(80, 180));
        jPanel29.setMinimumSize(new java.awt.Dimension(80, 180));
        jPanel29.setPreferredSize(new java.awt.Dimension(80, 180));
        addRemEstado.setPreferredSize(new java.awt.Dimension(70, 140));
        jPanel29.add(addRemEstado, java.awt.BorderLayout.CENTER);

        jLabel45.setPreferredSize(new java.awt.Dimension(34, 20));
        jPanel29.add(jLabel45, java.awt.BorderLayout.NORTH);

        jLabel49.setPreferredSize(new java.awt.Dimension(40, 20));
        jPanel29.add(jLabel49, java.awt.BorderLayout.SOUTH);

        jLabel50.setPreferredSize(new java.awt.Dimension(20, 14));
        jPanel29.add(jLabel50, java.awt.BorderLayout.WEST);

        add(jPanel29);

        jPanel30.setLayout(new java.awt.BorderLayout());

        jPanel30.setMinimumSize(new java.awt.Dimension(50, 42));
        jLabel51.setFont(new java.awt.Font("Verdana", 1, 14));
        jLabel51.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel51.setText("Estados");
        jPanel30.add(jLabel51, java.awt.BorderLayout.NORTH);

        jLabel52.setPreferredSize(new java.awt.Dimension(40, 0));
        jPanel30.add(jLabel52, java.awt.BorderLayout.WEST);

        jLabel53.setPreferredSize(new java.awt.Dimension(40, 0));
        jPanel30.add(jLabel53, java.awt.BorderLayout.EAST);

        jPanel30.add(genericJList, java.awt.BorderLayout.CENTER);

        add(jPanel30);

    }// </editor-fold>//GEN-END:initComponents
    
    private void posInitComponents() {
        this.addRemEstado.getBAdd().addActionListener(
                new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                addEstado(null);
            }
        });
        
        this.addRemEstado.getBRemove().addActionListener(
                new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                remEstados(null);
            }
        });
    }

    public void remEstados(Set<Estado> estados) {
        estados = new LinkedHashSet<Estado>();
        for(Object o : genericJList.removeItens())
            estados.add(new Estado(o.toString()));
        
        this.component.remEstados(estados);
    }

    public void addEstado(Estado estado) {
         if(estado==null)
            estado = new Estado(lN.getLetter()+
                            ""+lN.getNumber());
        
        String nomeEst = estado.getNome();
        if(this.genericJList.addItem(nomeEst)!=null)  
            this.component.addEstado(new Estado(nomeEst));
    }    

    public void removeAllItens() {
        this.genericJList.removeAllItens();
    }
    
    public Set<Estado> getAllItens() {
        Set<Estado> estados = new LinkedHashSet<Estado>();
        for(Object o : this.genericJList.getAllItens())
            estados.add(new Estado(o.toString()));
        
        return estados;
    }    
    
    // Declara��o de vari�veis - n�o modifique//GEN-BEGIN:variables
    private cassolato.rafael.sctmf.view.components.AddRemButtonsPanel addRemEstado;
    private cassolato.rafael.sctmf.view.components.GenericJList genericJList;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel30;
    private cassolato.rafael.sctmf.view.components.LetterNumber lN;
    // Fim da declara��o de vari�veis//GEN-END:variables
    
}