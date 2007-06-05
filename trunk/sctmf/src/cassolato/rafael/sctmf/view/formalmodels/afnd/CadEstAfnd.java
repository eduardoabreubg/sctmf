/*
 * CadEstAfnd.java
 *
 * Created on 26 de Maio de 2007, 14:04
 */

package cassolato.rafael.sctmf.view.formalmodels.afnd;

import cassolato.rafael.sctmf.model.pojo.Estado;
import cassolato.rafael.sctmf.view.formalmodels.afd.CadEst;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 *
 * @author  Cassolato
 */
public class CadEstAfnd extends CadEst {
    
    /** Creates new form CadEstAfnd */
    public CadEstAfnd() {
        //initComponents();       
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" C�digo Gerado ">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
     
   protected void addActionEstadoInicial() {
        Object item = getCbEstInicial().getSelectedItem();
        if(item!=null)             
            getListEstInicial().addItem(item.toString());
    }
    
    // Declara��o de vari�veis - n�o modifique//GEN-BEGIN:variables
    // Fim da declara��o de vari�veis//GEN-END:variables

    Set<Estado> getEstadosIniciais() {
        Set<Estado> estIni = new LinkedHashSet<Estado>();
        Iterator<Object> i = getListEstInicial().getAllItens().iterator();
        while(i.hasNext())
            estIni.add(new Estado(i.next().toString()));
        
        return estIni; 
    }

    void setEstadosIniciais(Set<Estado> estados) {
        getListEstInicial().removeAllItens();
        
        Iterator<Estado> i = estados.iterator();
        while(i.hasNext()) 
            getListEstInicial().addItem(i.next().getNome());
        
    }
    
}