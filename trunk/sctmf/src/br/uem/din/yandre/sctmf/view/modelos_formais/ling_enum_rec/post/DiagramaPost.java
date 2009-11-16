/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DiagramaPost.java
 *
 * Created on 12/11/2009, 22:47:13
 */

package br.uem.din.yandre.sctmf.view.modelos_formais.ling_enum_rec.post;

import br.uem.din.yandre.sctmf.view.modelos_formais.ling_enum_rec.post.util.LinguagemRegularScene;
import java.awt.BorderLayout;
import java.awt.Point;
import javax.swing.JComponent;
import javax.swing.JScrollPane;
import org.netbeans.api.visual.widget.LayerWidget;
import org.netbeans.api.visual.widget.Widget;

/**
 *
 * @author michelmenega
 */
public class DiagramaPost extends javax.swing.JPanel {
    PostGUI gui = null;
    private final LinguagemRegularScene lrs = new LinguagemRegularScene();


    /** Creates new form DiagramaPost */
    public DiagramaPost(PostGUI gui) {
        this.gui = gui;
        initComponents();
        //populateScene();
    }



     public void populateScene() {
        
         System.out.println("OI!");

        LayerWidget connectionLayer = new LayerWidget(lrs);
        //Scene s = new Scene;

        Widget s0 = lrs.addNode("S0");

        s0.setPreferredLocation(new Point(100, 100));

        Widget s1 = lrs.addNode("S1");

        s1.setPreferredLocation(new Point(200, 100));

        Widget s2 = lrs.addNode("S2");

        s2.setPreferredLocation(new Point(300, 100));

        Widget s3 = lrs.addNode("S3");

        s3.setPreferredLocation(new Point(400, 100));

        String simbolo = "a";
        lrs.addEdge(simbolo);

        //s.attachEdgeWidget("edge");
        lrs.setEdgeSource(simbolo, "S0");
        lrs.setEdgeTarget(simbolo, "S1");

        String simbolo1 = "b";
        lrs.addEdge(simbolo1);

        //s.attachEdgeWidget("edge");
        lrs.setEdgeSource(simbolo1, "S1");
        lrs.setEdgeTarget(simbolo1, "S2");

        String simbolo2 = "a";

        lrs.addEdge(simbolo2);

        //s.attachEdgeWidget("edge");
        lrs.setEdgeSource(simbolo2, "S2");
        lrs.setEdgeTarget(simbolo2, "S3");




        JComponent sceneView = lrs.createView();
        JScrollPane panel = new JScrollPane(sceneView);

        //JDialog dia = new JDialog (new JDialog (), true);

       this.add(panel, BorderLayout.CENTER);

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
