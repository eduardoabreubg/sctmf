/*
 * SobreGUI.java
 *
 * Created on 15 de Fevereiro de 2007, 20:52
 */

package cassolato.rafael.sctmf.view.components;

/**
 *
 * @author  Cassolato
 */
public class SobreGUI extends javax.swing.JDialog {
    
    /** Creates new form SobreGUI */
    public SobreGUI(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(parent);
        this.setPreferredSize(new java.awt.Dimension(420,235));
        this.setVisible(true);        
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" C�digo Gerado ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jPanel11 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        pAutor = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        pOrientador = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Sobre...");
        setMinimumSize(new java.awt.Dimension(400, 280));
        jPanel11.setLayout(new java.awt.BorderLayout());

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.Y_AXIS));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(347, 150));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 153));
        jPanel2.setPreferredSize(new java.awt.Dimension(10, 200));
        jPanel8.setLayout(new java.awt.GridLayout(2, 0, 0, 3));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        pAutor.setLayout(new javax.swing.BoxLayout(pAutor, javax.swing.BoxLayout.X_AXIS));

        pAutor.setBackground(new java.awt.Color(255, 255, 255));
        pAutor.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(204, 204, 255), null, null), "Autor", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Sans Typewriter", 0, 11), new java.awt.Color(153, 0, 204)));
        jPanel12.setLayout(new javax.swing.BoxLayout(jPanel12, javax.swing.BoxLayout.X_AXIS));

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setLayout(new java.awt.GridLayout(2, 0));

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 0));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel12.setText("Nome :");
        jLabel12.setPreferredSize(new java.awt.Dimension(45, 17));
        jPanel4.add(jLabel12);

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 11));
        jLabel5.setText("Rafael Cassolato de Meneses");
        jLabel5.setPreferredSize(new java.awt.Dimension(200, 15));
        jPanel4.add(jLabel5);

        jPanel13.add(jPanel4);

        jPanel5.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 0));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel11.setText("e-mail :");
        jLabel11.setPreferredSize(new java.awt.Dimension(45, 17));
        jPanel5.add(jLabel11);

        jLabel13.setFont(new java.awt.Font("Dialog", 0, 11));
        jLabel13.setText("rcassolato@gmail.com");
        jLabel13.setPreferredSize(new java.awt.Dimension(200, 15));
        jPanel5.add(jLabel13);

        jPanel13.add(jPanel5);

        jPanel12.add(jPanel13);

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cassolato/rafael/sctmf/view/icons/duke.png")));
        jLabel18.setPreferredSize(new java.awt.Dimension(70, 40));
        jPanel12.add(jLabel18);

        pAutor.add(jPanel12);

        jPanel8.add(pAutor);

        pOrientador.setLayout(new java.awt.GridLayout(2, 0));

        pOrientador.setBackground(new java.awt.Color(255, 255, 255));
        pOrientador.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(255, 153, 153), null, null), "Orientador", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Sans Typewriter", 0, 11), new java.awt.Color(255, 51, 51)));
        jPanel9.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 0));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel14.setText("Nome :");
        jLabel14.setPreferredSize(new java.awt.Dimension(45, 17));
        jPanel9.add(jLabel14);

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 11));
        jLabel6.setText("Prof. Ms. Yandre Maldonado e Gomes da Costa ");
        jLabel6.setPreferredSize(new java.awt.Dimension(250, 17));
        jPanel9.add(jLabel6);

        pOrientador.add(jPanel9);

        jPanel10.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 0));

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel15.setText("e-mail :");
        jLabel15.setPreferredSize(new java.awt.Dimension(45, 17));
        jPanel10.add(jLabel15);

        jLabel16.setFont(new java.awt.Font("Dialog", 0, 11));
        jLabel16.setText("yandre@din.uem.br");
        jLabel16.setPreferredSize(new java.awt.Dimension(200, 17));
        jPanel10.add(jLabel16);

        pOrientador.add(jPanel10);

        jPanel8.add(pOrientador);

        jPanel2.add(jPanel8, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel2);

        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(347, 200));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cassolato/rafael/sctmf/view/icons/logo_help.png")));
        jLabel7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel7.setPreferredSize(new java.awt.Dimension(80, 80));
        jPanel3.add(jLabel7, java.awt.BorderLayout.WEST);

        jPanel6.setLayout(new java.awt.BorderLayout());

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new java.awt.GridLayout(4, 0));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel10.setForeground(new java.awt.Color(0, 0, 102));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("FAFIMAN / UEM");
        jPanel7.add(jLabel10);

        jLabel9.setFont(new java.awt.Font("Arial", 0, 11));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText(" Faculdade de Filosofia Ci\u00eancias e Letras de Mandaguari");
        jPanel7.add(jLabel9);

        jLabel19.setFont(new java.awt.Font("Arial", 0, 11));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Universidade Estadual de Maring\u00e1");
        jPanel7.add(jLabel19);

        jLabel8.setFont(new java.awt.Font("Verdana", 1, 11));
        jLabel8.setForeground(new java.awt.Color(51, 0, 51));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Ci\u00eancia da Computa\u00e7\u00e3o");
        jPanel7.add(jLabel8);

        jPanel6.add(jPanel7, java.awt.BorderLayout.NORTH);

        jPanel3.add(jPanel6, java.awt.BorderLayout.CENTER);

        jLabel17.setPreferredSize(new java.awt.Dimension(40, 10));
        jPanel3.add(jLabel17, java.awt.BorderLayout.NORTH);

        jPanel1.add(jPanel3);

        jPanel11.add(jPanel1, java.awt.BorderLayout.CENTER);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Bitstream Vera Sans", 1, 13));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Sistema de Cria\u00e7\u00e3o e Teste de Modelos Formais");
        jLabel1.setPreferredSize(new java.awt.Dimension(82, 40));
        jPanel11.add(jLabel1, java.awt.BorderLayout.NORTH);

        jLabel2.setPreferredSize(new java.awt.Dimension(10, 0));
        jPanel11.add(jLabel2, java.awt.BorderLayout.WEST);

        jLabel3.setPreferredSize(new java.awt.Dimension(10, 0));
        jPanel11.add(jLabel3, java.awt.BorderLayout.EAST);

        jLabel4.setPreferredSize(new java.awt.Dimension(0, 2));
        jPanel11.add(jLabel4, java.awt.BorderLayout.SOUTH);

        getContentPane().add(jPanel11);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    // Declara��o de vari�veis - n�o modifique//GEN-BEGIN:variables
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel pAutor;
    private javax.swing.JPanel pOrientador;
    // Fim da declara��o de vari�veis//GEN-END:variables
    
}
