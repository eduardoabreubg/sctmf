/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uem.din.yandre.sctmf.view.modelos_formais.ling_enum_rec.post.util;

import br.uem.din.yandre.sctmf.view.modelos_formais.ling_enum_rec.post.*;
import br.uem.din.yandre.sctmf.model.pojo.Estado;
import br.uem.din.yandre.sctmf.model.pojo.Simbolo;
import br.uem.din.yandre.sctmf.model.pojo.TransicaoPost;
import java.awt.Point;
import java.awt.event.MouseEvent;
import org.netbeans.api.visual.action.ActionFactory;
import org.netbeans.api.visual.action.ConnectProvider;
import org.netbeans.api.visual.action.ConnectorState;
import org.netbeans.api.visual.action.WidgetAction;
import org.netbeans.api.visual.anchor.AnchorFactory;
import org.netbeans.api.visual.anchor.AnchorShape;
import org.netbeans.api.visual.anchor.PointShape;
import org.netbeans.api.visual.graph.GraphScene;
import org.netbeans.api.visual.layout.LayoutFactory;
import org.netbeans.api.visual.router.Router;
import org.netbeans.api.visual.router.RouterFactory;
import org.netbeans.api.visual.widget.ConnectionWidget;
import org.netbeans.api.visual.widget.LabelWidget;
import org.netbeans.api.visual.widget.LayerWidget;
import org.netbeans.api.visual.widget.Scene;
import org.netbeans.api.visual.widget.Widget;

/**
 *
 * @author michelmenega
 */
public class CustomGraphScene extends GraphScene.StringGraph {

    private LayerWidget mainLayer;
    private LayerWidget connectionLayer;
    private LayerWidget interactionLayer;
    private WidgetAction moveAction = ActionFactory.createMoveAction();
    private WidgetAction addRemoveControlPoint = ActionFactory.createAddRemoveControlPointAction();
    private WidgetAction moveControlPoint = ActionFactory.createFreeMoveControlPointAction();
    private Router router;
    private WidgetAction connectAction;
    private SceneTool sceneTool;
    private int contadorAceita = 0;
    private int contadorRejeita = 0;
    private int contadorLer = 0;
    private int contadorAtr = 0;
    private PostGUI gui = null;

    public CustomGraphScene(PostGUI gui) {
        this.gui = gui;
        

        mainLayer = new LayerWidget(this);
        addChild(mainLayer);

        interactionLayer = new LayerWidget(this);
        addChild(interactionLayer);

        connectionLayer = new LayerWidget(this);

        getActions().addAction(ActionFactory.createZoomAction());
        addChild(connectionLayer);

        createActions(sceneTool.INSERCAO.toString());
        createActions(sceneTool.SELECAO.toString());
        createActions(sceneTool.ASSOCIACAO.toString());

        getActions(sceneTool.INSERCAO.toString()).addAction(new InsercaoWidgetAction());

        connectAction = ActionFactory.createConnectAction(connectionLayer, new SceneConnectProvider());
        router = RouterFactory.createFreeRouter();

    }

    public SceneTool getSceneTool() {
        return sceneTool;
    }

    public void setSceneTool(SceneTool sceneTool) {
        setActiveTool(sceneTool.toString());
        this.sceneTool = sceneTool;

    }

    public Widget criarNodo() {
        String nome = null;

        if (PostGUI.bEstadoPartida.isSelected()) {
            nome = "Partida";
            PostGUI.bEstadoPartida.setEnabled(false);
            PostGUI.bEstadoAceita.setSelected(true);
        } else if (PostGUI.bEstadoAceita.isSelected()) {
            nome = "Aceita " + ++contadorAceita;
        } else if (PostGUI.bEstadoRejeita.isSelected()) {
            nome = "Rejeita " + ++contadorRejeita;
        } else if (PostGUI.bEstadoLer.isSelected()) {
            nome = "X <- Ler(X) " + ++contadorLer;
        } else if (PostGUI.bEstadoAtribuicao.isSelected()) {
            Character concatena = gui.showMySimbolosEstadoAtribuicao();
            nome = ++contadorAtr + " X <- X" + concatena;
        }
        gui.addEstado(new Estado(nome));
        Widget newNode = addNode(nome);
        return newNode;
    }

    public String criarTransicao(String source, String target, String name) {
        addEdge(name);
        setEdgeSource(name, source);
        setEdgeTarget(name, target);

        if (source.contains("X <- X")) {
            gui.addTransicao(new TransicaoPost(new Estado(source), new Estado(target), new Simbolo(source.charAt(source.length() - 1))));
        } else if (source.contains("Ler")) {
            if ((name.length() > 1) && name.contains(",")) {
                String[] simbolo = name.split(",");
                for (String s : simbolo) {
                    gui.addTransicao(new TransicaoPost(new Estado(source), new Estado(target), new Simbolo(s.charAt(0))));
                }
            } else {
                gui.addTransicao(new TransicaoPost(new Estado(source), new Estado(target), new Simbolo(name.charAt(0))));
            }
        } else {
            gui.addTransicao(new TransicaoPost(new Estado(source), new Estado(target), new Simbolo(' ')));
        }
        
        return name;
    }

    public String criarTransicao(String source, String target) {
        if (source.contains("Ler")) {
            String a = this.gui.showMySimbolosTransicaoLer(source);
            return criarTransicao(source, target, a);
        }
        return criarTransicao(source, target, "");
    }

    protected Widget attachNodeWidget(String node) {
        LabelWidget label = new MyLabelWidget(this, node);
        String selecaoTool = sceneTool.SELECAO.toString();
        label.createActions(selecaoTool);
        label.getActions(selecaoTool).addAction(
                ActionFactory.createAlignWithMoveAction(
                mainLayer, interactionLayer, ActionFactory.createDefaultAlignWithMoveDecorator()));
        label.getActions(selecaoTool).addAction(moveAction);
        label.getActions(selecaoTool).addAction(createObjectHoverAction());
        label.getActions(selecaoTool).addAction(createSelectAction());
      //  label.getActions(selecaoTool).addAction(selectAction);
        label.createActions(SceneTool.ASSOCIACAO.toString());
        label.getActions(SceneTool.ASSOCIACAO.toString()).addAction(connectAction);

        mainLayer.addChild(label);
        return label;
    }

    protected Widget attachEdgeWidget(String edge) {

        ConnectionWidget connection = new MyConnectionWidget(this, edge);
        connection.setTargetAnchorShape(AnchorShape.TRIANGLE_FILLED);

        connection.setPaintControlPoints(true);
        connection.setControlPointShape(PointShape.SQUARE_FILLED_SMALL);
        connection.setRouter(router);

        String selecaoTool = sceneTool.SELECAO.toString();
        connection.createActions(selecaoTool);
        connection.createActions(selecaoTool).addAction(addRemoveControlPoint);
        connection.getActions(selecaoTool).addAction(moveControlPoint);

        connection.getActions(selecaoTool).addAction(createObjectHoverAction());
        connection.getActions(selecaoTool).addAction(createSelectAction());
      //  connection.getActions(selecaoTool).addAction(selectAction);
        connectionLayer.addChild(connection);

        return connection;
    }

    protected void attachEdgeSourceAnchor(String edge, String oldSourceNode, String sourceNode) {
        Widget w = sourceNode != null ? findWidget(sourceNode) : null;

        ConnectionWidget connection = (ConnectionWidget) findWidget(edge);
        connection.setSourceAnchor(AnchorFactory.createRectangularAnchor(w));

        connection.setConstraint(w, LayoutFactory.ConnectionWidgetLayoutAlignment.BOTTOM_RIGHT, -10);


    }

    protected void attachEdgeTargetAnchor(String edge, String oldTargetNode, String targetNode) {
        Widget w = targetNode != null ? findWidget(targetNode) : null;
        ConnectionWidget connection = (ConnectionWidget) findWidget(edge);
        connection.setTargetAnchor(AnchorFactory.createRectangularAnchor(w));

        connection.setConstraint(w, LayoutFactory.ConnectionWidgetLayoutAlignment.TOP_LEFT, 10);

    }



////////////////
//inner classes/
////////////////
    private class SceneConnectProvider implements ConnectProvider {

        private String source = null;
        private String target = null;

        public boolean isSourceWidget(Widget sourceWidget) {
            Object object = findObject(sourceWidget);
            source = isNode(object) ? (String) object : null;
            return source != null;
        }

        public boolean hasCustomTargetWidgetResolver(Scene scene) {
            return false;
        }

        public Widget resolveTargetWidget(Scene scene, Point sceneLocation) {
            return null;

        }

        public void createConnection(Widget sourceWidget, Widget targetWidget) {
            if (sourceWidget == null || targetWidget == null) {
                return;
            }
            if ((!source.contains("Aceita")) && (!source.contains("Rejeita")) && (!target.equals("Partida"))) {
                criarTransicao(source, target);
            }

        }

        public ConnectorState isTargetWidget(Widget sourceWidget, Widget targetWidget) {
            Object object = findObject(targetWidget);
            target = isNode(object) ? (String) object : null;
            if (target != null) {
                return !source.equals(target) ? ConnectorState.ACCEPT : ConnectorState.REJECT_AND_STOP;
            }
            return object != null ? ConnectorState.REJECT_AND_STOP : ConnectorState.REJECT;
        }
    }

    private class InsercaoWidgetAction extends WidgetAction.Adapter {

        @Override
        public State mousePressed(Widget widget, WidgetMouseEvent event) {
            CustomGraphScene scene = (CustomGraphScene) widget;
            if (event.getButton() == MouseEvent.BUTTON1) {

                Widget newNode = criarNodo();
                newNode.setPreferredLocation(event.getPoint());

                return State.CONSUMED;
            }
            return State.REJECTED;
        }
    }
 
}



