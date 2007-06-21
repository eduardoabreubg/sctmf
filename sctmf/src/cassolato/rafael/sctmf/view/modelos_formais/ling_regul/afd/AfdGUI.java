/*
 * AfdGUI.java
 *
 * Created on 4 de Abril de 2007, 09:41
 */
package cassolato.rafael.sctmf.view.modelos_formais.ling_regul.afd;

import cassolato.rafael.sctmf.model.pojo.AFD;
import cassolato.rafael.sctmf.model.pojo.Estado;
import cassolato.rafael.sctmf.model.pojo.ModeloFormal;
import cassolato.rafael.sctmf.model.pojo.Simbolo;
import cassolato.rafael.sctmf.view.modelos_formais.ModeloFormalGUI;
import java.util.Collection;

/**
 *
 * @author  rafael2009_00
 */
public class AfdGUI extends ModeloFormalGUI {    
    
    private final CadAlfAFD pCadAlf = new CadAlfAFD();
    private final CadEstAFD pCadEst = new CadEstAFD();
    private final CadFunTransAFD pCadFunTrans = new CadFunTransAFD();
    private final ValSeqAFD vs = new ValSeqAFD();
                
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

    public void setModeloFormal(ModeloFormal fm) {
        AFD afd = (AFD)fm;
        this.getPCadAlf().addSimbolos(afd.getSimbolos());  
        
        this.pCadEst.setEstados(afd.getEstados());
        this.pCadEst.setEstadoInicial(afd.getEstadoInicial());
        this.pCadEst.setEstadosFinais(afd.getEstadosFinais());
        
        this.pCadFunTrans.setFuncTrans(afd.getTransicoes());
        
        this.changeCards(-1); // volta o card para o primeiro card
    }

    public ModeloFormal getModeloFormal() {
        AFD afd = new AFD();
        Collection<Simbolo> simbolos = getPCadAlf().getSimbolos();
        afd.addAllSimbolos(simbolos);
        
        Collection<Estado> estados = pCadEst.getEstados();
        afd.addAllEstados(estados);
        afd.setEstadoInicial(pCadEst.getEstadoInicial());
        afd.addAllEstFinais(pCadEst.getEstadosFinais());
                
        pCadFunTrans.observer(estados,simbolos);        
        afd.addAllTransicoes(pCadFunTrans.getFuncTrans());
                
        return afd;
    }
    
    /**
     * Add cards into standard card.
     */
    protected void addCards() {                
        cardNames.add("first-cadAlf");
        cardNames.add("cadEst");
        cardNames.add("cadFunTrans");
        cardNames.add("last-valSeq");
          
        getPCard().add(getPCadAlf(), cardNames.get(0));
        getPCard().add(pCadEst,cardNames.get(1) );
        getPCard().add(pCadFunTrans,cardNames.get(2));
        getPCard().add(vs,cardNames.get(3));        
        
        bBack.setEnabled(false);  
        
    }
    
    protected void changeCards(int direcao) {
        switch(direcao) {
            case NEXT :
                activeCard++;
                
                if(activeCard==2)
                    pCadFunTrans.observer(
                            pCadEst.getEstados(),
                            getPCadAlf().getSimbolos());
                
                else if(activeCard==3)                    
                    vs.observerValSeq((AFD)getModeloFormal());
                
                break;
                
            case PREVIOUS : 
                activeCard--;
                
                break;
                
            default : {
                activeCard = 0;
                this.bNext.setEnabled(true);
                this.bBack.setEnabled(false);
            }                
        }
        
        ((java.awt.CardLayout)getPCard().getLayout()).
                show(getPCard(),cardNames.get(activeCard));
    }

    protected CadAlfAFD getPCadAlf() {
        return pCadAlf;
    }
    
    protected javax.swing.JPanel getPCard() {
        return this.pCard;
    }
    
    protected javax.swing.JButton getBNext() {
        return this.bNext;
    }
    
    protected javax.swing.JButton getBBack() {
        return this.bBack;
    }
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bBack;
    private javax.swing.JButton bNext;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel pCard;
    private javax.swing.JPanel pRolagem;
    // End of variables declaration//GEN-END:variables
    
}