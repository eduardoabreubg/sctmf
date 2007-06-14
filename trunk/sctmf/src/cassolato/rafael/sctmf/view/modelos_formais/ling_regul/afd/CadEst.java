/*
 * CadEst.java
 *
 * Created on 4 de Maio de 2007, 10:22
 */

package cassolato.rafael.sctmf.view.modelos_formais.ling_regul.afd;

import cassolato.rafael.sctmf.model.pojo.Estado;
import cassolato.rafael.sctmf.view.components.GenericJList;
import cassolato.rafael.sctmf.view.components.CEstado;
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
public class CadEst extends javax.swing.JPanel 
                    implements CEstado {
    
    /** Creates new form CadEst */
    public CadEst() {
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
        cadEstado = cadEstado = new cassolato.rafael.sctmf.view.components.CadEstado(this);
        pSul = new javax.swing.JPanel();
        pEstIni = new javax.swing.JPanel();
        jLabel77 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        cbEstIni = new javax.swing.JComboBox();
        jPanel7 = new javax.swing.JPanel();
        addRemEstIni = new cassolato.rafael.sctmf.view.components.AddRemButtonsPanel();
        jLabel79 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        listEstIni = new cassolato.rafael.sctmf.view.components.GenericJList();
        pEstFin = new javax.swing.JPanel();
        jLabel81 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        panel = new javax.swing.JPanel();
        jPanel40 = new javax.swing.JPanel();
        cbEstFin = new javax.swing.JComboBox();
        jPanel41 = new javax.swing.JPanel();
        addRemEstFin = new cassolato.rafael.sctmf.view.components.AddRemButtonsPanel();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        jPanel42 = new javax.swing.JPanel();
        listEstFin = new cassolato.rafael.sctmf.view.components.GenericJList();

        setLayout(new java.awt.GridLayout(2, 0));

        setBorder(javax.swing.BorderFactory.createTitledBorder(null, " Cadastro de Estados ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(51, 51, 255)));
        add(cadEstado);

        pSul.setLayout(new java.awt.GridLayout(1, 2));

        pSul.setPreferredSize(new java.awt.Dimension(10, 150));
        pEstIni.setLayout(new java.awt.BorderLayout());

        pEstIni.setBorder(javax.swing.BorderFactory.createTitledBorder(null, " Estado Inicial ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(19, 92, 34)));
        jLabel77.setPreferredSize(new java.awt.Dimension(0, 5));
        pEstIni.add(jLabel77, java.awt.BorderLayout.SOUTH);

        jLabel78.setPreferredSize(new java.awt.Dimension(5, 0));
        pEstIni.add(jLabel78, java.awt.BorderLayout.WEST);

        jPanel5.setLayout(new java.awt.GridLayout(1, 3, 10, 0));

        jPanel6.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 25));

        cbEstIni.setFont(new java.awt.Font("Tahoma", 1, 14));
        cbEstIni.setPreferredSize(new java.awt.Dimension(50, 22));
        jPanel6.add(cbEstIni);

        jPanel5.add(jPanel6);

        jPanel7.setLayout(new java.awt.BorderLayout());

        addRemEstIni.setPreferredSize(new java.awt.Dimension(59, 140));
        jPanel7.add(addRemEstIni, java.awt.BorderLayout.CENTER);

        jLabel79.setPreferredSize(new java.awt.Dimension(0, 5));
        jPanel7.add(jLabel79, java.awt.BorderLayout.NORTH);

        jLabel80.setPreferredSize(new java.awt.Dimension(0, 5));
        jPanel7.add(jLabel80, java.awt.BorderLayout.SOUTH);

        jPanel5.add(jPanel7);

        jPanel8.setLayout(new java.awt.BorderLayout());

        jPanel8.add(listEstIni, java.awt.BorderLayout.CENTER);

        jPanel5.add(jPanel8);

        pEstIni.add(jPanel5, java.awt.BorderLayout.CENTER);

        pSul.add(pEstIni);

        pEstFin.setLayout(new java.awt.BorderLayout());

        pEstFin.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Estados Finais", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(125, 82, 134)));
        jLabel81.setPreferredSize(new java.awt.Dimension(0, 5));
        pEstFin.add(jLabel81, java.awt.BorderLayout.SOUTH);

        jLabel82.setPreferredSize(new java.awt.Dimension(10, 0));
        pEstFin.add(jLabel82, java.awt.BorderLayout.WEST);

        panel.setLayout(new java.awt.GridLayout(1, 3, 10, 0));

        jPanel40.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 25));

        cbEstFin.setFont(new java.awt.Font("Tahoma", 1, 14));
        cbEstFin.setPreferredSize(new java.awt.Dimension(50, 22));
        jPanel40.add(cbEstFin);

        panel.add(jPanel40);

        jPanel41.setLayout(new java.awt.BorderLayout());

        addRemEstFin.setPreferredSize(new java.awt.Dimension(59, 140));
        jPanel41.add(addRemEstFin, java.awt.BorderLayout.CENTER);

        jLabel83.setPreferredSize(new java.awt.Dimension(0, 5));
        jPanel41.add(jLabel83, java.awt.BorderLayout.NORTH);

        jLabel84.setPreferredSize(new java.awt.Dimension(0, 5));
        jPanel41.add(jLabel84, java.awt.BorderLayout.SOUTH);

        panel.add(jPanel41);

        jPanel42.setLayout(new java.awt.BorderLayout());

        jPanel42.add(listEstFin, java.awt.BorderLayout.CENTER);

        panel.add(jPanel42);

        pEstFin.add(panel, java.awt.BorderLayout.CENTER);

        pSul.add(pEstFin);

        add(pSul);

    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * M�todo observer para as operacoes de 
     * ADD no painel de cadastro de estados.
     *
     * @param item
     */
    private void observerAdd(String item) {   
        cbEstIni.addItem(item);
        cbEstFin.addItem(item);        
    }
    
    /**
     * M�todo observer para as operacoes de 
     * REMOVE no painel de cadastro de estados.
     *
     * @param item
     */
    private void observerRemove(String item) {
        // Estado Inicial
        this.cbEstIni.removeItem(item);
        this.listEstIni.removeItem(item);
        
        // Estados Finais
        this.cbEstFin.removeItem(item);
        this.listEstFin.removeItem(item);
    }
    
    public void setEstados(Collection<Estado> estados) {
        this.cadEstado.removeAllItens();
        this.cbEstFin.removeAllItems();
        this.cbEstIni.removeAllItems();
        
        Iterator<Estado> i = estados.iterator();
        while(i.hasNext()) 
            this.cadEstado.addEstado(i.next());            
            
    }
    
    public Collection<Estado> getEstados() {
        return this.cadEstado.getAllItens();        
    }
    
    void setEstadoInicial(Estado ei) {
        this.listEstIni.removeAllItens();
        if(ei!=null)             
            this.listEstIni.addItem(ei.getNome());
                    
    }
    
    Estado getEstadoInicial() {
        for(Object o :listEstIni.getAllItens())
            return new Estado(o.toString());
        
        return null;
    }
    
    public void setEstadosFinais(Collection<Estado> ef) {
        listEstFin.removeAllItens();
        for(Estado e : ef)
            listEstFin.addItem(e.getNome());
                    
    }
    
    public Collection<Estado> getEstadosFinais() {
        Set<Estado> estFin = new LinkedHashSet<Estado>();
        Iterator<Object> i = this.listEstFin.getAllItens().iterator();
        while(i.hasNext())
            estFin.add(new Estado(i.next().toString()));
        
        return estFin;  
    }    
    
    private void posInitComponents() {         
        this.addRemEstIni.getBAdd().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae) {
                addActionEstadoInicial();
            }
        });
        
        this.addRemEstIni.getBRemove().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae) {
                removeActionEstadoInicial();
            }
        });
        
        this.addRemEstFin.getBAdd().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae) {
                addActionEstadoFinal();
            }
        });
        
        this.addRemEstFin.getBRemove().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae) {
                removeActionEstadoFinal();
            }
        });
    }
        
    private void removeActionEstadoInicial() {
         this.listEstIni.removeItens(); 
    }
    
    protected void addActionEstadoInicial() {
        Object item = this.cbEstIni.getSelectedItem();
        if(item!=null) {
            this.listEstIni.removeAllItens();
            this.listEstIni.addItem(item.toString());
        } 
    }
    
    private void removeActionEstadoFinal() {
        this.listEstFin.removeItens();
    }
    
    private void addActionEstadoFinal() {
        Object item = this.cbEstFin.getSelectedItem();
        if(item!=null) 
            this.listEstFin.addItem(item.toString());
    }
    
    protected javax.swing.JComboBox getCbEstInicial() {
        return this.cbEstIni;
    }
    
    protected GenericJList getListEstInicial() {
        return this.listEstIni;
    }

    public void addEstado(Estado estado) {
        this.observerAdd(estado.getNome());
    }

    public void remEstados(Set<Estado> estados) {
        for(Estado e : estados)
            this.observerRemove(e.getNome());
    }

    public void removeAllItens() {
        this.cadEstado.removeAllItens();
    }
    
    // Declara��o de vari�veis - n�o modifique//GEN-BEGIN:variables
    private cassolato.rafael.sctmf.view.components.AddRemButtonsPanel addRemEstFin;
    private cassolato.rafael.sctmf.view.components.AddRemButtonsPanel addRemEstIni;
    private cassolato.rafael.sctmf.view.components.CadEstado cadEstado;
    private javax.swing.JComboBox cbEstFin;
    private javax.swing.JComboBox cbEstIni;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private cassolato.rafael.sctmf.view.components.GenericJList listEstFin;
    private cassolato.rafael.sctmf.view.components.GenericJList listEstIni;
    private javax.swing.JPanel pEstFin;
    private javax.swing.JPanel pEstIni;
    private javax.swing.JPanel pSul;
    private javax.swing.JPanel panel;
    // Fim da declara��o de vari�veis//GEN-END:variables
    
}
