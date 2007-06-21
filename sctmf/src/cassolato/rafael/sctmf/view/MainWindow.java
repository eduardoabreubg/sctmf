/*
 * MainWindow.java
 *
 * Created on 10 de Fevereiro de 2007, 12:56
 */

package cassolato.rafael.sctmf.view;

import cassolato.rafael.sctmf.control.Controller;
import cassolato.rafael.sctmf.view.components.SobreGUI;
import java.beans.PropertyVetoException;

/**
 *
 * @author  Cassolato
 */
public class MainWindow extends javax.swing.JFrame {
       
    private Controller ctrl = null;
    
    /** Creates new form MainWindow */
    public MainWindow(Controller ctrl) {
        this.ctrl = ctrl;
        
        this.initComponents();
        this.posInitComponents();
        this.setLocationRelativeTo(null);        
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jop = new javax.swing.JOptionPane();
        oFundo = new javax.swing.JDesktopPane();
        jToolBar = new javax.swing.JToolBar();
        pLingRegul = new javax.swing.JPanel();
        bAFD = new javax.swing.JButton();
        bAFND = new javax.swing.JButton();
        bExpReg = new javax.swing.JButton();
        pLingLivContex = new javax.swing.JPanel();
        bAutComPilha = new javax.swing.JButton();
        bGramLivrContex = new javax.swing.JButton();
        pLingSensContex = new javax.swing.JPanel();
        bGramSensContex = new javax.swing.JButton();
        bAutComDuasPilhas = new javax.swing.JButton();
        pLingEnumRec = new javax.swing.JPanel();
        bMaqTuring = new javax.swing.JButton();
        bGramEstruFrase = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        mArquivo = new javax.swing.JMenu();
        jSeparator1 = new javax.swing.JSeparator();
        miSair = new javax.swing.JMenuItem();
        mModelos = new javax.swing.JMenu();
        mLingRegul = new javax.swing.JMenu();
        miAFD = new javax.swing.JMenuItem();
        miAFND = new javax.swing.JMenuItem();
        miExpReg = new javax.swing.JMenuItem();
        mLingLivContex = new javax.swing.JMenu();
        miAutComPilha = new javax.swing.JMenuItem();
        miGramLivrContex = new javax.swing.JMenuItem();
        mLingSensContex = new javax.swing.JMenu();
        miGramSensContex = new javax.swing.JMenuItem();
        miAutComDuasPilha = new javax.swing.JMenuItem();
        mLingEnumRec = new javax.swing.JMenu();
        miMaqTuring = new javax.swing.JMenuItem();
        miGramEstruFrase = new javax.swing.JMenuItem();
        mAjuda = new javax.swing.JMenu();
        miSobre = new javax.swing.JMenuItem();

        jop.setBackground(new java.awt.Color(255, 102, 102));

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 600));
        setName("frame");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        getContentPane().add(oFundo, java.awt.BorderLayout.CENTER);

        pLingRegul.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(255, 204, 153), null, new java.awt.Color(255, 204, 0)));
        pLingRegul.setToolTipText("Linguagens Regulares");
        bAFD.setBackground(new java.awt.Color(255, 255, 204));
        bAFD.setText("AFD");
        bAFD.setToolTipText("Aut\u00f4matos Finitos Determin\u00edsticos");
        bAFD.setPreferredSize(new java.awt.Dimension(70, 25));
        bAFD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAFDActionPerformed(evt);
            }
        });

        pLingRegul.add(bAFD);

        bAFND.setBackground(new java.awt.Color(255, 255, 204));
        bAFND.setText("AFND");
        bAFND.setToolTipText("Aut\u00f4matos Finitos N\u00e3o Determin\u00edsticos");
        bAFND.setPreferredSize(new java.awt.Dimension(70, 25));
        bAFND.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAFNDActionPerformed(evt);
            }
        });

        pLingRegul.add(bAFND);

        bExpReg.setBackground(new java.awt.Color(255, 255, 204));
        bExpReg.setText("ER");
        bExpReg.setToolTipText("Express\u00f5es Regulares ");
        bExpReg.setEnabled(false);
        bExpReg.setPreferredSize(new java.awt.Dimension(70, 25));
        bExpReg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bExpRegActionPerformed(evt);
            }
        });

        pLingRegul.add(bExpReg);

        jToolBar.add(pLingRegul);

        pLingLivContex.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(51, 255, 51), null, new java.awt.Color(51, 153, 0)));
        pLingLivContex.setToolTipText("Linguagens Livres de Contexto ");
        bAutComPilha.setBackground(new java.awt.Color(204, 255, 204));
        bAutComPilha.setText("AP");
        bAutComPilha.setToolTipText("Aut\u00f4mato com Pilha ");
        bAutComPilha.setPreferredSize(new java.awt.Dimension(70, 25));
        bAutComPilha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAutComPilhaActionPerformed(evt);
            }
        });

        pLingLivContex.add(bAutComPilha);

        bGramLivrContex.setBackground(new java.awt.Color(204, 255, 204));
        bGramLivrContex.setText("GLC");
        bGramLivrContex.setToolTipText("Gram\u00e1tica Livre de Contexto ");
        bGramLivrContex.setEnabled(false);
        bGramLivrContex.setPreferredSize(new java.awt.Dimension(70, 25));
        bGramLivrContex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bGramLivrContexActionPerformed(evt);
            }
        });

        pLingLivContex.add(bGramLivrContex);

        jToolBar.add(pLingLivContex);

        pLingSensContex.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(255, 153, 153), null, new java.awt.Color(255, 0, 0)));
        pLingSensContex.setToolTipText("Linguagens Sens\u00edveis ao Contexto");
        bGramSensContex.setBackground(new java.awt.Color(255, 204, 204));
        bGramSensContex.setText("GSC");
        bGramSensContex.setToolTipText("Gram\u00e1tica Sens\u00edvel ao Contexto ");
        bGramSensContex.setEnabled(false);
        bGramSensContex.setPreferredSize(new java.awt.Dimension(70, 25));
        pLingSensContex.add(bGramSensContex);

        bAutComDuasPilhas.setBackground(new java.awt.Color(255, 204, 204));
        bAutComDuasPilhas.setText("ACDP");
        bAutComDuasPilhas.setToolTipText("Aut\u00f4mato com Duas Pilhas");
        bAutComDuasPilhas.setEnabled(false);
        bAutComDuasPilhas.setPreferredSize(new java.awt.Dimension(70, 25));
        pLingSensContex.add(bAutComDuasPilhas);

        jToolBar.add(pLingSensContex);

        pLingEnumRec.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(153, 153, 255), null, new java.awt.Color(102, 0, 255)));
        pLingEnumRec.setToolTipText("Linguagens Enumer\u00e1veis Recursivamente ");
        bMaqTuring.setBackground(new java.awt.Color(204, 204, 255));
        bMaqTuring.setText("MT");
        bMaqTuring.setToolTipText("M\u00e1quina de Turing ");
        bMaqTuring.setEnabled(false);
        bMaqTuring.setPreferredSize(new java.awt.Dimension(70, 25));
        bMaqTuring.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bMaqTuringActionPerformed(evt);
            }
        });

        pLingEnumRec.add(bMaqTuring);

        bGramEstruFrase.setBackground(new java.awt.Color(204, 204, 255));
        bGramEstruFrase.setText("GEF");
        bGramEstruFrase.setToolTipText("Gram\u00e1tica com Estrutura de Frase ");
        bGramEstruFrase.setEnabled(false);
        bGramEstruFrase.setPreferredSize(new java.awt.Dimension(70, 25));
        pLingEnumRec.add(bGramEstruFrase);

        jToolBar.add(pLingEnumRec);

        getContentPane().add(jToolBar, java.awt.BorderLayout.NORTH);

        mArquivo.setText("Arquivo");
        mArquivo.add(jSeparator1);

        miSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/toolbarButtonGraphics/general/Stop16.gif")));
        miSair.setText("Sair");
        miSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miSairActionPerformed(evt);
            }
        });

        mArquivo.add(miSair);

        menuBar.add(mArquivo);

        mModelos.setText("Modelos");
        mLingRegul.setText("Linguagens Regulares");
        miAFD.setText("AFD");
        miAFD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAFDActionPerformed(evt);
            }
        });

        mLingRegul.add(miAFD);

        miAFND.setText("AFND ");
        miAFND.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAFNDActionPerformed(evt);
            }
        });

        mLingRegul.add(miAFND);

        miExpReg.setText("Express\u00f5es Regulares ");
        miExpReg.setEnabled(false);
        miExpReg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miExpRegActionPerformed(evt);
            }
        });

        mLingRegul.add(miExpReg);

        mModelos.add(mLingRegul);

        mLingLivContex.setText("Linguagens Livres de Contexto ");
        miAutComPilha.setText("Aut\u00f4mato com Pilha ");
        miAutComPilha.setEnabled(false);
        miAutComPilha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAutComPilhaActionPerformed(evt);
            }
        });

        mLingLivContex.add(miAutComPilha);

        miGramLivrContex.setText("Gram\u00e1tica Livre de Contexto ");
        miGramLivrContex.setEnabled(false);
        miGramLivrContex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miGramLivrContexActionPerformed(evt);
            }
        });

        mLingLivContex.add(miGramLivrContex);

        mModelos.add(mLingLivContex);

        mLingSensContex.setText("Linguagens Sens\u00edveis ao Contexto");
        miGramSensContex.setText("Gram\u00e1tica Sens\u00edvel ao Contexto ");
        miGramSensContex.setEnabled(false);
        miGramSensContex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miGramSensContexActionPerformed(evt);
            }
        });

        mLingSensContex.add(miGramSensContex);

        miAutComDuasPilha.setText("Aut\u00f4mato com Duas Pilhas");
        miAutComDuasPilha.setEnabled(false);
        miAutComDuasPilha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAutComDuasPilhaActionPerformed(evt);
            }
        });

        mLingSensContex.add(miAutComDuasPilha);

        mModelos.add(mLingSensContex);

        mLingEnumRec.setText("Linguagens Enumer\u00e1veis Recursivamente ");
        miMaqTuring.setText("M\u00e1quina de Turing ");
        miMaqTuring.setEnabled(false);
        miMaqTuring.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miMaqTuringActionPerformed(evt);
            }
        });

        mLingEnumRec.add(miMaqTuring);

        miGramEstruFrase.setText("Gram\u00e1tica com Estrutura de Frase ");
        miGramEstruFrase.setEnabled(false);
        miGramEstruFrase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miGramEstruFraseActionPerformed(evt);
            }
        });

        mLingEnumRec.add(miGramEstruFrase);

        mModelos.add(mLingEnumRec);

        menuBar.add(mModelos);

        mAjuda.setText("Ajuda");
        miSobre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/toolbarButtonGraphics/general/About16.gif")));
        miSobre.setText("Sobre...");
        miSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miSobreActionPerformed(evt);
            }
        });

        mAjuda.add(miSobre);

        menuBar.add(mAjuda);

        setJMenuBar(menuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bAutComPilhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAutComPilhaActionPerformed
        this.showFormalModel(IdModeloFormal.AP);
    }//GEN-LAST:event_bAutComPilhaActionPerformed

    private void bMaqTuringActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bMaqTuringActionPerformed
// TODO adicione seu c�digo de manipula��o aqui:
    }//GEN-LAST:event_bMaqTuringActionPerformed

    private void bGramLivrContexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bGramLivrContexActionPerformed
// TODO adicione seu c�digo de manipula��o aqui:
    }//GEN-LAST:event_bGramLivrContexActionPerformed

    private void bExpRegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bExpRegActionPerformed
// TODO adicione seu c�digo de manipula��o aqui:
    }//GEN-LAST:event_bExpRegActionPerformed

    private void bAFNDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAFNDActionPerformed
        this.showFormalModel(IdModeloFormal.AFND);
    }//GEN-LAST:event_bAFNDActionPerformed

    private void bAFDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAFDActionPerformed
       this.showFormalModel(IdModeloFormal.AFD);
    }//GEN-LAST:event_bAFDActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.actionSair();
    }//GEN-LAST:event_formWindowClosing

    private void miSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miSobreActionPerformed
        new SobreGUI(this,true);
    }//GEN-LAST:event_miSobreActionPerformed

    private void miGramEstruFraseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miGramEstruFraseActionPerformed
// TODO adicione seu c�digo de manipula��o aqui:
    }//GEN-LAST:event_miGramEstruFraseActionPerformed

    private void miMaqTuringActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miMaqTuringActionPerformed
// TODO adicione seu c�digo de manipula��o aqui:
    }//GEN-LAST:event_miMaqTuringActionPerformed

    private void miAutComDuasPilhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAutComDuasPilhaActionPerformed
// TODO adicione seu c�digo de manipula��o aqui:
    }//GEN-LAST:event_miAutComDuasPilhaActionPerformed

    private void miGramSensContexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miGramSensContexActionPerformed
// TODO adicione seu c�digo de manipula��o aqui:
    }//GEN-LAST:event_miGramSensContexActionPerformed

    private void miGramLivrContexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miGramLivrContexActionPerformed
// TODO adicione seu c�digo de manipula��o aqui:
    }//GEN-LAST:event_miGramLivrContexActionPerformed

    private void miAutComPilhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAutComPilhaActionPerformed
        this.showFormalModel(IdModeloFormal.AP);
    }//GEN-LAST:event_miAutComPilhaActionPerformed

    private void miExpRegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miExpRegActionPerformed
// TODO adicione seu c�digo de manipula��o aqui:
    }//GEN-LAST:event_miExpRegActionPerformed

    private void miAFNDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAFNDActionPerformed
        this.showFormalModel(IdModeloFormal.AFND);
    }//GEN-LAST:event_miAFNDActionPerformed

    private void miAFDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAFDActionPerformed
        this.showFormalModel(IdModeloFormal.AFD);
    }//GEN-LAST:event_miAFDActionPerformed
    
    private void miSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miSairActionPerformed
        this.actionSair();        
    }//GEN-LAST:event_miSairActionPerformed
    
    /**
     * Manipula a a��o de Sa�da do Sistema
     */
    private void actionSair() {           
        int i = jop.showOptionDialog(null, "Deseja Sair do Sistema ?", "",   
                 jop.YES_NO_OPTION,jop.QUESTION_MESSAGE,   
                 null, new String[]{"Sim","N�o"}, null);
        
        if(i==0) {
            this.setVisible(false);            
            System.exit(0);
        }
            
    }
    
    /**
     * Add o JInternalFrame no Fundo
     */
    private void addJIF(javax.swing.JInternalFrame jif) {
        this.oFundo.add(jif);
        try {
            jif.setSelected(true);
        } catch (PropertyVetoException ex) {
            ex.printStackTrace();
        }
        jif.setVisible(true);
    }
    
    /**
     * P�s inicia os componentes 
     */
    private void posInitComponents() {
        this.miSair.setAccelerator(
                javax.swing.KeyStroke.getKeyStroke( 
                   java.awt.event.KeyEvent.VK_F4, 
                    java.awt.event.ActionEvent.ALT_MASK));
        
        this.miSobre.setAccelerator(
                javax.swing.KeyStroke.getKeyStroke("F1"));
                
        this.notVisible();
    }
    
    /**
     * Retira os componentes que a principio n�o vao 
     * estar no TCC
     */
    private void notVisible() {
        this.pLingSensContex.setVisible(false);
        this.bGramEstruFrase.setVisible(false);
        this.mLingSensContex.setVisible(false);
        this.miGramEstruFrase.setVisible(false);
    }
    
    private void showFormalModel(IdModeloFormal idFM) {        
        this.addJIF(
                new GenericJInternalFrame(ctrl, idFM));
    }
            
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAFD;
    private javax.swing.JButton bAFND;
    private javax.swing.JButton bAutComDuasPilhas;
    private javax.swing.JButton bAutComPilha;
    private javax.swing.JButton bExpReg;
    private javax.swing.JButton bGramEstruFrase;
    private javax.swing.JButton bGramLivrContex;
    private javax.swing.JButton bGramSensContex;
    private javax.swing.JButton bMaqTuring;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JToolBar jToolBar;
    private javax.swing.JOptionPane jop;
    private javax.swing.JMenu mAjuda;
    private javax.swing.JMenu mArquivo;
    private javax.swing.JMenu mLingEnumRec;
    private javax.swing.JMenu mLingLivContex;
    private javax.swing.JMenu mLingRegul;
    private javax.swing.JMenu mLingSensContex;
    private javax.swing.JMenu mModelos;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem miAFD;
    private javax.swing.JMenuItem miAFND;
    private javax.swing.JMenuItem miAutComDuasPilha;
    private javax.swing.JMenuItem miAutComPilha;
    private javax.swing.JMenuItem miExpReg;
    private javax.swing.JMenuItem miGramEstruFrase;
    private javax.swing.JMenuItem miGramLivrContex;
    private javax.swing.JMenuItem miGramSensContex;
    private javax.swing.JMenuItem miMaqTuring;
    private javax.swing.JMenuItem miSair;
    private javax.swing.JMenuItem miSobre;
    private javax.swing.JDesktopPane oFundo;
    private javax.swing.JPanel pLingEnumRec;
    private javax.swing.JPanel pLingLivContex;
    private javax.swing.JPanel pLingRegul;
    private javax.swing.JPanel pLingSensContex;
    // End of variables declaration//GEN-END:variables
    
}