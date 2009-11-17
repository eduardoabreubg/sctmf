/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uem.din.yandre.sctmf.view.modelos_formais.ling_enum_rec.post.util;

/**
 *
 * @author Administrador
 */
import br.uem.din.yandre.sctmf.view.modelos_formais.ling_enum_rec.post.PostGUI;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collection;
import org.netbeans.api.visual.action.ActionFactory;
import org.netbeans.api.visual.action.ConnectProvider;
import org.netbeans.api.visual.action.ConnectorState;
import org.netbeans.api.visual.action.WidgetAction;
import org.netbeans.api.visual.action.WidgetAction.State;
import org.netbeans.api.visual.action.WidgetAction.WidgetMouseEvent;
import org.netbeans.api.visual.anchor.Anchor;
import org.netbeans.api.visual.anchor.AnchorFactory;
import org.netbeans.api.visual.anchor.AnchorShape;
import org.netbeans.api.visual.graph.GraphScene;
import org.netbeans.api.visual.layout.LayoutFactory;
import org.netbeans.api.visual.widget.ConnectionWidget;
import org.netbeans.api.visual.widget.LabelWidget;
import org.netbeans.api.visual.widget.LayerWidget;
import org.netbeans.api.visual.widget.Scene;
import org.netbeans.api.visual.widget.Widget;
import org.netbeans.api.visual.widget.general.IconNodeWidget;
import org.netbeans.api.visual.border.BorderFactory;

public class GraphSceneImpl extends GraphScene.StringGraph {

    private LayerWidget mainLayer;
    private LayerWidget connectionLayer;
    private LayerWidget interactionLayer;

    public GraphSceneImpl() {
        mainLayer = new LayerWidget(this);
        connectionLayer = new LayerWidget(this);
        interactionLayer = new LayerWidget(this);
        addChild(mainLayer);
        addChild(connectionLayer);
        addChild(interactionLayer);
        //Widget w1 = addNode("1. Hammer");
        //w1.setPreferredLocation(new Point(10, 100));
        //Widget w2 = addNode("2. Saw");
        //w2.setPreferredLocation(new Point(100, 250));
        //Widget w3 = addNode("Nail");
        //w3.setPreferredLocation(new Point(250, 250));
        //Widget w4 = addNode("Bolt");
        //w4.setPreferredLocation(new Point(250, 350));
        getActions().addAction(new InsercaoWidgetAction());
        getActions().addAction(ActionFactory.createZoomAction());
        getActions().addAction(ActionFactory.createResizeAction());

    }

    @Override
    protected Widget attachNodeWidget(String arg) {
        IconNodeWidget widget = new IconNodeWidget(this);

        widget.setBorder(BorderFactory.createRoundedBorder(150, 150, 15, 15, Color.WHITE, Color.GREEN));
        //WidgetAction.Chain actions = widget.getActions();
        //actions.addAction(createObjectHoverAction());

        widget.getActions().addAction(
                ActionFactory.createExtendedConnectAction(
                connectionLayer, new SceneConnectProvider()));

        widget.getActions().addAction(
                ActionFactory.createAlignWithMoveAction(
                mainLayer, interactionLayer,
                ActionFactory.createDefaultAlignWithMoveDecorator()));

        if (PostGUI.bEstadoPartida.isSelected()) {
            widget.setLabel("Partida");
        } else if (PostGUI.bEstadoAceita.isSelected()) {
            widget.setLabel("Parada");
        } else if (PostGUI.bEstadoLer.isSelected()) {
            widget.setLabel("Ler");
        } else if (PostGUI.bEstadoAtribuicao.isSelected()) {
            widget.setLabel("Atribuicao");
        }

        mainLayer.addChild(widget);
        return widget;

    }

    @Override
    protected Widget attachEdgeWidget(String edge) {
        ConnectionWidget widget = new ConnectionWidget(this);
        widget.setTargetAnchorShape(AnchorShape.TRIANGLE_FILLED);

        LabelWidget connectionLabel = new LabelWidget(this, edge);
        widget.addChild(connectionLabel);
        widget.setConstraint(connectionLabel, LayoutFactory.ConnectionWidgetLayoutAlignment.BOTTOM_LEFT, 2f);

        WidgetAction.Chain actions = widget.getActions();
        actions.addAction(createObjectHoverAction());
        actions.addAction(createSelectAction());

        connectionLayer.addChild(widget);
        return widget;
    }

    @Override
    protected void attachEdgeSourceAnchor(String edge, String oldSourceNode, String sourceNode) {
        Widget w = sourceNode != null ? findWidget(sourceNode) : null;

        ConnectionWidget connection = (ConnectionWidget) findWidget(edge);
        connection.setSourceAnchor(AnchorFactory.createRectangularAnchor(w));

        connection.setConstraint(w, LayoutFactory.ConnectionWidgetLayoutAlignment.BOTTOM_RIGHT, -10);
    }

    @Override
    protected void attachEdgeTargetAnchor(String edge, String oldTargetNode, String targetNode) {
        Widget w = targetNode != null ? findWidget(targetNode) : null;
        ConnectionWidget connection = (ConnectionWidget) findWidget(edge);
        connection.setTargetAnchor(AnchorFactory.createRectangularAnchor(w));

        connection.setConstraint(w, LayoutFactory.ConnectionWidgetLayoutAlignment.TOP_LEFT, 10);
    }

    private class InsercaoWidgetAction extends WidgetAction.Adapter {

        @Override
        public State mousePressed(Widget widget, WidgetMouseEvent event) {

            if (event.getButton() == MouseEvent.BUTTON1) {

                if (!PostGUI.bConexao.isSelected()) {
                    Widget newNode = addNode("");
                    newNode.setPreferredLocation(event.getPoint());

                    return State.CONSUMED;
                }


            }
            return State.REJECTED;
        }
    }

    //////////////////////////////////////////////////**************************////////////////////
   /* private class MyConnectProvider implements ConnectProvider {

    public boolean isSourceWidget(Widget source) {
    return source instanceof IconNodeWidget && source != null ? true : false;
    }

    public ConnectorState isTargetWidget(Widget src, Widget trg) {
    return src != trg && trg instanceof IconNodeWidget ? ConnectorState.ACCEPT : ConnectorState.REJECT;
    }

    public boolean hasCustomTargetWidgetResolver(Scene arg0) {
    return false;
    }

    public Widget resolveTargetWidget(Scene arg0, Point arg1) {
    return null;
    }

    public void createConnection(Widget source, Widget target) {
    if (PostGUI.bConexao.isSelected()) {
    IconNodeWidget widgetSource = (IconNodeWidget) source;
    IconNodeWidget widgetTarget = (IconNodeWidget) target;

    System.out.println("source " + widgetSource.getLabelWidget().getLabel());
    System.out.println("target " + widgetTarget.getLabelWidget().getLabel());
    String nome = JOptionPane.showInputDialog("escreve ai");
    addEdge(nome);

    setEdgeSource(nome, widgetSource.getLabelWidget().getLabel());
    setEdgeTarget(nome, widgetTarget.getLabelWidget().getLabel());

    /*ConnectionWidget conn = new ConnectionWidget(GraphSceneImpl.this);
    //conn.setToolTipText("oila");
    conn.setTargetAnchorShape(AnchorShape.TRIANGLE_FILLED);
    conn.setTargetAnchor(AnchorFactory.createRectangularAnchor(target));
    conn.setSourceAnchor(AnchorFactory.createRectangularAnchor(source));
    connectionLayer.addChild(conn);
    }
    }*/
    public String criarTransicao(String source, String target, String name) {
        addEdge(name);
        setEdgeSource(name, source);
        setEdgeTarget(name, target);
        return name;
    }

    public String criarTransicao(String source, String target) {
        return criarTransicao(source, target, "TRUCO");
    }

//vai via
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
            String edge = criarTransicao(source, target);
            if (sourceWidget.equals(targetWidget)) { //adiciona uma rota se origem e igual destino

                Widget edgeWidget = findWidget(edge);
                if (edgeWidget instanceof ConnectionWidget) {
                    ConnectionWidget cw = (ConnectionWidget) edgeWidget;
                    Collection<Point> points = new ArrayList<Point>();
                    points.add(new Point(20, 20));
                    points.add(new Point(20, 30));
                    cw.setControlPoints(points, false);
                }
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
}
