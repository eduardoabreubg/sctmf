/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uem.din.yandre.sctmf.view.modelos_formais.ling_enum_rec.post.util;

import br.uem.din.yandre.sctmf.model.pojo.TransicaoPost;
import org.netbeans.api.visual.layout.LayoutFactory;
import org.netbeans.api.visual.widget.ConnectionWidget;
import org.netbeans.api.visual.widget.LabelWidget;
import org.netbeans.api.visual.widget.Scene;


public class MyConnectionWidget extends ConnectionWidget {

    public MyConnectionWidget(Scene scene) {
        super(scene);
    }
    //private AssociacaoGui gui = new AssociacaoGui();
    private LabelWidget connectionLabel;

    public void setTransicao(TransicaoPost transicao) {
        connectionLabel.setLabel(transicao.getNome());
    }

    public MyConnectionWidget(CustomGraphScene scene, String nome) {
        super(scene);
        connectionLabel = new LabelWidget(scene, nome);
        addChild(connectionLabel);
        setConstraint(connectionLabel, LayoutFactory.ConnectionWidgetLayoutAlignment.CENTER_RIGHT, 0.5f);
    }

    public void setLabel(String s) {
        connectionLabel.setToolTipText(s);
    }
}