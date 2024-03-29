
package br.uem.din.yandre.sctmf.view.modelos_formais.ling_enum_rec.post;

import br.uem.din.yandre.sctmf.model.pojo.Simbolo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 *
 * @author  michelmenega
 *
 */
public class CadAlfPost extends javax.swing.JPanel {
    PostGUI gui = null;
    
    /** Creates new form CadAlfPost*/
    public CadAlfPost(PostGUI gui) {
        this.gui = gui;
        initComponents();
        posInitComponents();
    }
    
    Set<Simbolo> getSimbAfabeto() {
        Set<Simbolo> simbolos = new LinkedHashSet<Simbolo>();
        for(Object o : this.listAlf.getAllItens())
            simbolos.add(new Simbolo((Character)o));
            
        return simbolos;
    }
    
    
    void setSimbAfabeto(Collection<Simbolo> simbAlf) {
        this.listAlf.removeAllItens();
        
        for(Simbolo s : simbAlf)
           // this.listAlf.addItem(s.getNome());
            this.addActionAlf(s);
    }
    

    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        listAlf = new br.uem.din.yandre.sctmf.view.components.GenericJList();
        addRemButtonsAlf = new br.uem.din.yandre.sctmf.view.components.AddRemButtonsPanel();
        letterNumber = new br.uem.din.yandre.sctmf.view.components.LetterNumber();

        setLayout(new java.awt.GridBagLayout());

        jPanel4.setToolTipText("S�mbolos do Alfabeto da Linguagem");
        jPanel4.setLayout(new java.awt.BorderLayout());

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setToolTipText("S�mbolos de Entrada");
        jLabel4.setText("\u03a3");
        jPanel4.add(jLabel4, java.awt.BorderLayout.NORTH);

        listAlf.setToolTipText("");
        jPanel4.add(listAlf, java.awt.BorderLayout.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.ipadx = 16;
        gridBagConstraints.ipady = 166;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 10, 0);
        add(jPanel4, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 10, 20);
        add(addRemButtonsAlf, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 10, 20);
        add(letterNumber, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents
    
   private void posInitComponents() {
       this.letterNumber.forceAllLowerCase(true);
        
        this.addRemButtonsAlf.getBAdd().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae) {
                addActionAlf(null);
            }
        });
        
        this.addRemButtonsAlf.getBRemove().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae) {
                removeActionAlf();
            }
        });
        

    }
    
    private void removeActionAlf() {
      for(Object o : this.listAlf.removeItens())
          this.gui.removeSimbolo(
                new Simbolo((Character)o), 0);            
    }
        
    private void addActionAlf(Simbolo simbAlf) {
        Character c = letterNumber.getValue();
        
        if(simbAlf==null)
            simbAlf = new Simbolo(
                    Character.toLowerCase(c));
        
        this.listAlf.addItem(simbAlf.getNome());         
        this.gui.addSimbolo(simbAlf, 0);          
    }
       /*
   private void removeActionAlfAux() {
      for(Object o : this.listAlfAux.removeItens())
          this.gui.removeSimbolo(
               new Simbolo((Character)o),1);                      
    }
        
    private void addActionAlfAux(Simbolo simbAlfAux) { 
        Character c = letterNumber.getValue();
        
        if (!Character.isDigit(c)) {
            if(simbAlfAux==null)
            simbAlfAux = new Simbolo(
                    Character.toUpperCase(this.letterNumber.getValue()));
        
            this.listAlfAux.addItem(simbAlfAux.getNome());
            this.gui.addSimbolo(simbAlfAux,1);
                                 
        } else {
            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "S�o permitidos somente LETRAS para\n" +
                    "o Alfabeto Auxiliar",
                    "Aten��o",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }*/
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private br.uem.din.yandre.sctmf.view.components.AddRemButtonsPanel addRemButtonsAlf;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel4;
    private br.uem.din.yandre.sctmf.view.components.LetterNumber letterNumber;
    private br.uem.din.yandre.sctmf.view.components.GenericJList listAlf;
    // End of variables declaration//GEN-END:variables
    
}
