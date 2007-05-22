/*
 * CadFunTrans.java
 *
 * Created on 3 de Maio de 2007, 10:22
 */

package cassolato.rafael.sctmf.view.formalmodels.afd;

import cassolato.rafael.sctmf.model.pojo.Estado;
import cassolato.rafael.sctmf.model.pojo.Simbolo;
import cassolato.rafael.sctmf.model.pojo.Transicao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author  rafael2009_00
 */
class CadFunTrans extends javax.swing.JPanel {
    
    /** Creates new form CadFunTrans */
    public CadFunTrans() {
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
        pWest = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        pS0 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        cbEstOri = new javax.swing.JComboBox();
        jLabel17 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        cbSimb = new javax.swing.JComboBox();
        jLabel14 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        cbEstDes = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        pCenter = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        addRemButtonsPanel = new view.AddRemButtonsPanel();
        jLabel6 = new javax.swing.JLabel();
        pEast = new javax.swing.JPanel();
        genericJList = new cassolato.rafael.sctmf.view.components.GenericJList();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.X_AXIS));

        setBorder(javax.swing.BorderFactory.createTitledBorder(null, " Cadastro das Fun\u00e7\u00f5es de Transi\u00e7\u00e3o de Estados ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(51, 51, 255)));
        pWest.setLayout(new javax.swing.BoxLayout(pWest, javax.swing.BoxLayout.Y_AXIS));

        pWest.setPreferredSize(new java.awt.Dimension(160, 100));
        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.X_AXIS));

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel1.setPreferredSize(new java.awt.Dimension(20, 30));
        jLabel9.setFont(new java.awt.Font("Verdana", 1, 16));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel9.setPreferredSize(new java.awt.Dimension(0, 30));
        jLabel9.setText("\u03B4:");
        jPanel1.add(jLabel9, java.awt.BorderLayout.NORTH);

        jPanel2.add(jPanel1);

        pS0.setLayout(new java.awt.BorderLayout(0, 5));

        jLabel19.setPreferredSize(new java.awt.Dimension(40, 13));
        pS0.add(jLabel19, java.awt.BorderLayout.SOUTH);

        cbEstOri.setForeground(new java.awt.Color(51, 204, 0));
        pS0.add(cbEstOri, java.awt.BorderLayout.CENTER);

        jLabel17.setFont(new java.awt.Font("Verdana", 1, 16));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("S");
        jLabel17.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel17.setPreferredSize(new java.awt.Dimension(12, 30));
        pS0.add(jLabel17, java.awt.BorderLayout.NORTH);

        jPanel2.add(pS0);

        jPanel5.setLayout(new java.awt.BorderLayout(0, 5));

        jLabel12.setFont(new java.awt.Font("Verdana", 1, 16));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("x");
        jLabel12.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel12.setPreferredSize(new java.awt.Dimension(11, 30));
        jPanel5.add(jLabel12, java.awt.BorderLayout.NORTH);

        jPanel2.add(jPanel5);

        jPanel4.setLayout(new java.awt.BorderLayout(0, 5));

        jLabel21.setPreferredSize(new java.awt.Dimension(0, 13));
        jPanel4.add(jLabel21, java.awt.BorderLayout.SOUTH);

        cbSimb.setForeground(new java.awt.Color(255, 204, 0));
        cbSimb.setPreferredSize(new java.awt.Dimension(40, 22));
        jPanel4.add(cbSimb, java.awt.BorderLayout.CENTER);

        jLabel14.setFont(new java.awt.Font("Verdana", 1, 16));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel14.setPreferredSize(new java.awt.Dimension(0, 30));
        jLabel14.setText("\u03a3");
        jPanel4.add(jLabel14, java.awt.BorderLayout.NORTH);

        jPanel2.add(jPanel4);

        jPanel16.setLayout(new java.awt.BorderLayout(0, 10));

        jPanel18.setLayout(new java.awt.BorderLayout());

        jLabel16.setFont(new java.awt.Font("Arial", 1, 25));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel16.setPreferredSize(new java.awt.Dimension(20, 30));
        jLabel16.setText("\u2192");
        jPanel18.add(jLabel16, java.awt.BorderLayout.CENTER);

        jLabel15.setText(" ");
        jLabel15.setPreferredSize(new java.awt.Dimension(3, 5));
        jPanel18.add(jLabel15, java.awt.BorderLayout.NORTH);

        jPanel16.add(jPanel18, java.awt.BorderLayout.NORTH);

        jLabel20.setText(" ");
        jPanel16.add(jLabel20, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel16);

        jPanel6.setLayout(new java.awt.BorderLayout(0, 5));

        jLabel23.setPreferredSize(new java.awt.Dimension(0, 13));
        jPanel6.add(jLabel23, java.awt.BorderLayout.SOUTH);

        cbEstDes.setForeground(new java.awt.Color(255, 102, 102));
        jPanel6.add(cbEstDes, java.awt.BorderLayout.CENTER);

        jLabel10.setFont(new java.awt.Font("Verdana", 1, 16));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("S");
        jLabel10.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel10.setPreferredSize(new java.awt.Dimension(12, 30));
        jPanel6.add(jLabel10, java.awt.BorderLayout.NORTH);

        jLabel11.setPreferredSize(new java.awt.Dimension(5, 0));
        jPanel6.add(jLabel11, java.awt.BorderLayout.EAST);

        jPanel2.add(jPanel6);

        pWest.add(jPanel2);

        jLabel4.setPreferredSize(new java.awt.Dimension(0, 30));
        pWest.add(jLabel4);

        jPanel3.setLayout(new java.awt.GridLayout(3, 0));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), "Legenda", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(153, 0, 153)));
        jPanel3.setPreferredSize(new java.awt.Dimension(100, 100));
        jPanel7.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jPanel10.setBackground(new java.awt.Color(51, 204, 0));
        jPanel7.add(jPanel10);

        jPanel11.setLayout(new java.awt.BorderLayout());

        jLabel24.setFont(new java.awt.Font("Dialog", 1, 10));
        jLabel24.setText("Estado de Origem");
        jPanel11.add(jLabel24, java.awt.BorderLayout.CENTER);

        jPanel7.add(jPanel11);

        jPanel3.add(jPanel7);

        jPanel8.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jPanel12.setBackground(new java.awt.Color(255, 204, 0));
        jPanel8.add(jPanel12);

        jPanel13.setLayout(new java.awt.BorderLayout());

        jLabel25.setFont(new java.awt.Font("Dialog", 1, 10));
        jLabel25.setText("S\u00edmbolo do Alfabeto");
        jPanel13.add(jLabel25, java.awt.BorderLayout.CENTER);

        jPanel8.add(jPanel13);

        jPanel3.add(jPanel8);

        jPanel9.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jPanel14.setBackground(new java.awt.Color(255, 102, 102));
        jPanel9.add(jPanel14);

        jPanel15.setLayout(new java.awt.BorderLayout());

        jLabel26.setFont(new java.awt.Font("Dialog", 1, 10));
        jLabel26.setText("Estado de Destino");
        jPanel15.add(jLabel26, java.awt.BorderLayout.CENTER);

        jPanel9.add(jPanel15);

        jPanel3.add(jPanel9);

        pWest.add(jPanel3);

        jLabel18.setPreferredSize(new java.awt.Dimension(40, 5));
        pWest.add(jLabel18);

        add(pWest);

        pCenter.setLayout(new java.awt.BorderLayout());

        pCenter.setOpaque(false);
        pCenter.setPreferredSize(new java.awt.Dimension(2, 10));
        jLabel1.setPreferredSize(new java.awt.Dimension(0, 70));
        pCenter.add(jLabel1, java.awt.BorderLayout.NORTH);

        jLabel2.setPreferredSize(new java.awt.Dimension(0, 70));
        pCenter.add(jLabel2, java.awt.BorderLayout.SOUTH);

        pCenter.add(addRemButtonsPanel, java.awt.BorderLayout.CENTER);

        jLabel6.setPreferredSize(new java.awt.Dimension(5, 0));
        pCenter.add(jLabel6, java.awt.BorderLayout.WEST);

        add(pCenter);

        pEast.setLayout(new java.awt.BorderLayout());

        pEast.setPreferredSize(new java.awt.Dimension(70, 100));
        genericJList.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pEast.add(genericJList, java.awt.BorderLayout.CENTER);

        jLabel7.setPreferredSize(new java.awt.Dimension(0, 10));
        pEast.add(jLabel7, java.awt.BorderLayout.SOUTH);

        jLabel5.setPreferredSize(new java.awt.Dimension(5, 0));
        pEast.add(jLabel5, java.awt.BorderLayout.WEST);

        jPanel17.setLayout(new java.awt.GridLayout(2, 0));

        jLabel3.setFont(new java.awt.Font("Georgia", 1, 11));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Fun\u00e7\u00f5es de");
        jLabel3.setPreferredSize(new java.awt.Dimension(0, 15));
        jPanel17.add(jLabel3);

        jLabel13.setFont(new java.awt.Font("Georgia", 1, 11));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Transi\u00e7\u00e3o");
        jLabel13.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel13.setPreferredSize(new java.awt.Dimension(0, 15));
        jPanel17.add(jLabel13);

        pEast.add(jPanel17, java.awt.BorderLayout.NORTH);

        add(pEast);

    }// </editor-fold>//GEN-END:initComponents
     
    private void removeAction() {                                        
        this.genericJList.removeItens();  
    }                                       

    private void addAction(Estado estOri, Simbolo s, Estado estFin) {                                     
        StringBuffer sb = new StringBuffer("\u03B4 (");
       
        // Indica que foi executada uma acao pelo usu�rio
        // de adicao de Transicao
        if(estOri==null) {
            estOri = new Estado(cbEstOri.getSelectedItem().toString());
            s = new Simbolo(cbSimb.getSelectedItem().toString().charAt(0));
            estFin = new Estado(cbEstDes.getSelectedItem().toString());
        }
        
        sb.append(estOri.getNome()); // EstOri
        sb.append(", ");
        sb.append(s.getNome());   // Simb
        sb.append(") = ");
        sb.append(estFin.getNome()); // EstOri
                       
        String transicao = sb.toString();
        if(wayAdd(transicao))
            genericJList.addItem(transicao);
        
        else
            javax.swing.JOptionPane.showMessageDialog(this, 
                    "N�o � permitido cadastrar um mesmo estado inicial,\n" +
                    "e um s�mbolo, para mais de UM estado destino.",
                    "Tentativa de Viola��o de Integridade do AFD",
                    javax.swing.JOptionPane.WARNING_MESSAGE);
    }
    
    /**
     * M�todo que assegura a integridade da transicao do AFD,<br>
     * ou seja, ele n�o permite que o mesmo estado inicial, e o mesmo simbolo,<br>
     * possam ir para 2 estados diferentes ou seja.<br>
     * <i>A1,a -> A2<br>
     * A1,a -> A1 (ele nao permite issso)</i>
     */
    private boolean wayAdd(String transicao) {
        transicao = transicao.substring(0,7);
        for(Object o :genericJList.getAllItens())
            if(o.toString().startsWith(transicao))
                return false;
        
        return true;
    }
    
    /**
     * Retorna um Set<Transicao> contendo as transicoes<br>
     * contidas na JList da GUI.<br>
     * <i><b>Obs:</b> Antes desse metodo ser chamado � necess�rio a<br>
     * chamado do metodo <b>addSimbolosComboBox</b></i>.
     * 
     * @return Set
     */
    Set<Transicao> getFuncTrans() {
        Set<Transicao> transicoes = new LinkedHashSet<Transicao>();
        
        for(Object obj : genericJList.getAllItens()) {            
            Matcher m = this.getMatcher(obj.toString());
            Transicao t = new Transicao();
            
            if(m.find()) {
                t.setEstOri(new Estado(m.group(1)));
                t.setSimbolo(new Simbolo(m.group(2).charAt(0)));
                t.setEstDest(new Estado(m.group(3)));
                
                transicoes.add(t);
            }
        }
        
        return transicoes;
    }
    
    void setFuncTrans(Collection<Transicao> c) {
        genericJList.removeAllItens();
        for(Transicao t : c) 
            this.addAction(t.getEstOri(),
                           t.getSimbolo(),
                           t.getEstDest());
        
    }
        
    /**
     * Limpa os JComboBoxs e Add os valores nele.
     *
     */
    void observer(
            Collection<Estado> estados, Collection<Simbolo> simbolos) {
        String sim = "";
        String est = "";
               
        cbEstOri.removeAllItems();
        cbEstDes.removeAllItems();
        
        Iterator<Estado> ie = estados.iterator();
        while(ie.hasNext()) {
            String e = ie.next().getNome();
            cbEstOri.addItem(e);
            cbEstDes.addItem(e);
            
            est+= e+"-";
        }
        
        cbSimb.removeAllItems();
        
        Iterator<Simbolo> is = simbolos.iterator();
        while(is.hasNext()) {
            Character s = is.next().getNome();
            cbSimb.addItem(s);
            
            sim += s+"-";
        }
        
        this.observerFuncCad(sim, est);
    }    
    
    /**
     * Verifica se algum simbolo ou estado foi removido<br>
     * nos cadastros anteriores e remove a funcao de transicao.
     *
     * @param simbolos
     * @param estados
     */
    private void observerFuncCad(String simbolos, String estados) {
        List<String> sim = Arrays.asList(simbolos.split("-"));
        List<String> est = Arrays.asList(estados.split("-"));
        
        for(Object obj : genericJList.getAllItens()) {
            Matcher m = this.getMatcher(obj.toString());
            
            if(m.find())
                if(!(est.contains(m.group(1))&&est.contains(m.group(3))&&
                        sim.contains(m.group(2))))            
                    genericJList.removeItem(obj);
                
        }        
    }    
    
    /**
     * Retorna o matcher para ser feito a pesquisa.<br>
     * Usando o metodo <b>group</b> obtemos:<br>
     * <i>Posicao 1</i> contem o estado de origem<br>
     * <i>Posicao 2</i> esta o simbolo<br>
     * <i>Posicao 3</i> esta o estado de destino.
     *
     * @param str
     * @return Matcher
     */
    private Matcher getMatcher(String str) {
        //String regex = ".*\\((.{2}),.*(.{1})\\).*=.*(.{2})$";
        String regex = ".?\\((.{2}), (.{1})\\).?=.?(.{2})";        
                
        return Pattern.compile(regex).matcher(str);
    }
    
     private void posInitComponents() {
        this.addRemButtonsPanel.getBAdd().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae) {
                addAction(null,null,null);
            }
        });
        
        this.addRemButtonsPanel.getBRemove().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae) {
                removeAction();
            }
        });        
     }
    
    // Declara��o de vari�veis - n�o modifique//GEN-BEGIN:variables
    private view.AddRemButtonsPanel addRemButtonsPanel;
    private javax.swing.JComboBox cbEstDes;
    private javax.swing.JComboBox cbEstOri;
    private javax.swing.JComboBox cbSimb;
    private cassolato.rafael.sctmf.view.components.GenericJList genericJList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel pCenter;
    private javax.swing.JPanel pEast;
    private javax.swing.JPanel pS0;
    private javax.swing.JPanel pWest;
    // Fim da declara��o de vari�veis//GEN-END:variables
    
}