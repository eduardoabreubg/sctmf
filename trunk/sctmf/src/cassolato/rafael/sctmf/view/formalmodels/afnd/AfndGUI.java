/*
 * AfndGUI.java
 *
 * Created on 26 de Maio de 2007, 15:12
 */

package cassolato.rafael.sctmf.view.formalmodels.afnd;

import cassolato.rafael.sctmf.model.pojo.AFD;
import cassolato.rafael.sctmf.model.pojo.AFND;
import cassolato.rafael.sctmf.model.pojo.Estado;
import cassolato.rafael.sctmf.model.pojo.FormalModel;
import cassolato.rafael.sctmf.model.pojo.Simbolo;
import cassolato.rafael.sctmf.view.formalmodels.afd.AfdGUI;
import java.util.Collection;

/**
 *
 * @author  Cassolato
 */
public class AfndGUI extends AfdGUI {
    private CadEstAfnd cea = null;
    private CadFunTransAfnd cfta = null;
    private ValSeqAfnd vsa = null;
    
    /** Creates new form BeanForm */
    public AfndGUI() {
        cea = new CadEstAfnd();
        cfta = new CadFunTransAfnd();
        vsa = new ValSeqAfnd();
        this.posInit();
    } 
    
    private void posInit() {
        // Substitui o Panel de Cadastro de Estados
        getPCard().remove(1);
        getPCard().add(cea, cardNames.get(1),1);
        // Substitui o Panel de Cadastro de Transicoes
        getPCard().remove(2);
        getPCard().add(cfta, cardNames.get(2),2);        
        // Substitui o Panel de Validacao de Sequencias
        getPCard().remove(3);
        getPCard().add(vsa, cardNames.get(3),3);
    }
    
    protected void changeCards(final int direction) {
        switch(direction) {
            case NEXT :
                activeCard++;
                
                if(activeCard==2)
                    cfta.observer(
                            cea.getEstados(),
                            getPCadAlf().getSimbolos());
                
                else if(activeCard==3)                  
                    vsa.managerFM(getFormalModel());
                
                break;
                
            case PREVIOUS : 
                activeCard--;
                
                break;
                
            default : {
                activeCard = 0;
                getBNext().setEnabled(true);
                getBBack().setEnabled(false);
            }                
        }
        
        ((java.awt.CardLayout)getPCard().getLayout()).
                show(getPCard(),cardNames.get(activeCard));
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" C�digo Gerado ">//GEN-BEGIN:initComponents
    private void initComponents() {

    }// </editor-fold>//GEN-END:initComponents
    
    
    public void setFormalModel(FormalModel fm) {
        AFND afnd = (AFND)fm;
        this.getPCadAlf().addSimbolos(afnd.getSimbolos());  
        
        cea.setEstados(afnd.getEstados());
        cea.setEstadosIniciais(afnd.getEstadosIniciais());
        cea.setEstadosFinais(afnd.getEstadosFinais());
        
        cfta.setFuncTrans(afnd.getTransicoes());
        
        this.changeCards(-1); // volta o card para o primeiro card
    }

    public FormalModel getFormalModel() {
        AFND afnd = new AFND();
        Collection<Simbolo> simbolos = getPCadAlf().getSimbolos();
        afnd.addAllSimbolos(simbolos);
        
        Collection<Estado> estados = cea.getEstados();
        afnd.addAllEstados(estados);
        afnd.addAllEstadosIniciais(cea.getEstadosIniciais());
        afnd.addAllEstFinais(cea.getEstadosFinais());
                
        cfta.observer(estados,simbolos);        
        afnd.addAllTransicoes(cfta.getFuncTrans());
                
        return afnd;
    }
    
    // Declara��o de vari�veis - n�o modifique//GEN-BEGIN:variables
    // Fim da declara��o de vari�veis//GEN-END:variables
    
}