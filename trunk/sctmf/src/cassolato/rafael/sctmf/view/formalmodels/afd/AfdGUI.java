/*
 * AfdGUI.java
 *
 * Created on 4 de Abril de 2007, 09:41
 */

package cassolato.rafael.sctmf.view.formalmodels.afd;

import cassolato.rafael.sctmf.model.pojo.AFD;
import cassolato.rafael.sctmf.model.pojo.Automato;
import cassolato.rafael.sctmf.model.pojo.FormalModel;
import cassolato.rafael.sctmf.model.pojo.Simbolo;
import cassolato.rafael.sctmf.view.FormalModelGUI;
import java.util.Iterator;

/**
 *
 * @author  rafael2009_00
 */
public class AfdGUI extends FormalModelGUI {    
    private final CadAlf pCadAlf = new CadAlf();
    private final CadEst pCadEst = new CadEst();
    private final CadFunTrans pCadFunTrans = new CadFunTrans();
    private final ValSeq vs = new ValSeq();
                
    /** Creates new form AfdGUI */
    public AfdGUI() {
        initComponents();
        this.addCards();
    }
      
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        pCard = new javax.swing.JPanel();
        pRolagem = new javax.swing.JPanel();
        bBack = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        bNext = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout(0, 1));

        pCard.setLayout(new java.awt.CardLayout());

        add(pCard, java.awt.BorderLayout.CENTER);

        pRolagem.setLayout(new java.awt.GridLayout(1, 4, 20, 0));

        pRolagem.setPreferredSize(new java.awt.Dimension(217, 30));
        bBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/toolbarButtonGraphics/navigation/Back24.gif")));
        bBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBackActionPerformed(evt);
            }
        });

        pRolagem.add(bBack);

        pRolagem.add(jLabel2);

        bNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/toolbarButtonGraphics/navigation/Forward24.gif")));
        bNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNextActionPerformed(evt);
            }
        });

        pRolagem.add(bNext);

        add(pRolagem, java.awt.BorderLayout.SOUTH);

    }// </editor-fold>//GEN-END:initComponents

    private void bNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNextActionPerformed
        if(!bBack.isEnabled())
            bBack.setEnabled(true);
        
        this.changeCards(NEXT);
        
        if(cardNames.get(activeCard).startsWith("last"))
            bNext.setEnabled(false);
        
    }//GEN-LAST:event_bNextActionPerformed

    private void bBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBackActionPerformed
        bNext.setEnabled(true);
        
        this.changeCards(PREVIOUS);
        
        if(cardNames.get(activeCard).startsWith("first"))
            bBack.setEnabled(false);
         
    }//GEN-LAST:event_bBackActionPerformed

    public void setFormalModel(FormalModel fm) {
        AFD afd = (AFD)fm;
        
    }

    public FormalModel getFormalModel() {
        AFD afd = new AFD();
        afd.addAllSimbolos(pCadAlf.getSimbolos());
        
        afd.addAllEstados(pCadEst.getEstados());
        afd.setEstadoInicial(pCadEst.getEstadoInicial());
        afd.addAllEstFinais(pCadEst.getEstadosFinais());
        
        afd.addAllTransicoes(pCadFunTrans.getFuncTrans());
                
        return afd;
    }
    
    /**
     * Create a String[] and add cards into<br>
     * standard card.
     */
    private void addCards() {        
        cardNames.add("first-cadAlf");
        cardNames.add("cadEst");
        cardNames.add("cadFunTrans");
        cardNames.add("last-valSeq");
        
        pCard.add(pCadAlf,cardNames.get(0));
        pCard.add(pCadEst,cardNames.get(1) );
        pCard.add(pCadFunTrans,cardNames.get(2));
        pCard.add(vs,cardNames.get(3));
        
        bBack.setEnabled(false);                
    }
    
    private void changeCards(final int direction) {
        switch(direction) {
            case NEXT :
                activeCard++;
                
                if(activeCard==2)
                    pCadFunTrans.addEstadosSimbolosComboBox(
                            pCadEst.getEstados(),pCadAlf.getSimbolos());
                else if(activeCard==3)                    
                    vs.managerAFD((AFD)getFormalModel());
                
                break;
            case PREVIOUS : 
                activeCard--;
                break;
        }
        
        ((java.awt.CardLayout)pCard.getLayout()).
                show(pCard,cardNames.get(activeCard));
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bBack;
    private javax.swing.JButton bNext;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel pCard;
    private javax.swing.JPanel pRolagem;
    // End of variables declaration//GEN-END:variables
    
}
