/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uem.din.yandre.sctmf.view.modelos_formais.ling_enum_rec.post;

import br.uem.din.yandre.sctmf.model.pojo.Estado;
import br.uem.din.yandre.sctmf.model.pojo.TransicaoMP;
import org.netbeans.api.visual.layout.LayoutFactory;
import org.netbeans.api.visual.widget.ConnectionWidget;
import org.netbeans.api.visual.widget.LabelWidget;
import org.netbeans.api.visual.widget.Scene;
import org.netbeans.api.visual.widget.Widget;

/**
 *
 * @author gustavo
 */
public class MyConnectionWidget extends ConnectionWidget {

    public MyConnectionWidget(Scene scene) {
        super(scene);
    }
    //private AssociacaoGui gui = new AssociacaoGui();
    private LabelWidget connectionLabel;
    private TransicaoMP transicao;

    public TransicaoMP getTransicao() {
        return transicao;
    }

    public void setTransicao(TransicaoMP transicao) {
        this.transicao = transicao;
        loadState();
        connectionLabel.setLabel(transicao.getNome());
    }

    public MyConnectionWidget(CustomGraphScene scene, String nome) {
        super(scene);
        try {
            transicao = new TransicaoMP();
            transicao.setNome(nome);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        connectionLabel = new LabelWidget(scene, nome);
        addChild(connectionLabel);
        setConstraint(connectionLabel, LayoutFactory.ConnectionWidgetLayoutAlignment.CENTER_RIGHT, 0.5f);
    }

    public void setLabel(String s) {
        connectionLabel.setToolTipText(s);
    }

    // public JPanel getPanel() {
    //    return gui;
    //}
    public void onDelete() {
        transicao.delete();
    }

    public void saveState() {
        try {
            Widget fonte = getSourceAnchor().getRelatedWidget();
            Widget destino = getTargetAnchor().getRelatedWidget();
            if (fonte instanceof MyLabelWidget && destino instanceof MyLabelWidget) {
                MyLabelWidget fonteCast = (MyLabelWidget) fonte;
                MyLabelWidget destinoCast = (MyLabelWidget) destino;
                Estado estadoOrigem = fonteCast.getEstado();
                Estado estadoDestino = destinoCast.getEstado();
                transicao.setEstadoOrigem(estadoOrigem);
                transicao.setEstadoDestino(estadoDestino);
            }
            //  transicao.setNome(gui.getNome());
            // setLabel(gui.getNome());
            //transicao.setScripts(gui.getScripts());
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void loadState() {
        // gui.setNome(transicao.getNome());
        // gui.setScript(transicao.getScripts());
        //TODO CARREGAR TODOS SCRIPTS DO BD
    }


}
