/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.uem.din.yandre.sctmf.view.modelos_formais.ling_enum_rec.post.util;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Collection;
import org.netbeans.api.visual.action.ActionFactory;
import org.netbeans.api.visual.action.ConnectProvider;
import org.netbeans.api.visual.action.ConnectorState;
import org.netbeans.api.visual.action.WidgetAction;
import org.netbeans.api.visual.anchor.Anchor;
import org.netbeans.api.visual.anchor.AnchorFactory;
import org.netbeans.api.visual.anchor.AnchorShape;
import org.netbeans.api.visual.border.BorderFactory;
import org.netbeans.api.visual.graph.GraphScene;
import org.netbeans.api.visual.layout.LayoutFactory;
import org.netbeans.api.visual.widget.ConnectionWidget;
import org.netbeans.api.visual.widget.LabelWidget;
import org.netbeans.api.visual.widget.Scene;
import org.netbeans.api.visual.widget.Widget;
import org.netbeans.api.visual.widget.general.IconNodeWidget;

/**
 *
 * @author root
 */
public class LinguagemRegularScene extends GraphScene.StringGraph  {


    private Widget mainLayer;
    private Widget connectionLayer;

    private WidgetAction moveAction = ActionFactory.createMoveAction ();

    public LinguagemRegularScene () {
        mainLayer = new Widget (this);
        addChild (mainLayer);
        connectionLayer = new Widget (this);
        addChild (connectionLayer);
    }

    protected Widget attachNodeWidget (String node) {
        IconNodeWidget widget = new IconNodeWidget (this);
        widget.setLabel (node);
        widget.setBorder(BorderFactory.createRoundedBorder(150, 150, 15, 15, Color.WHITE, Color.GREEN));
        WidgetAction.Chain actions = widget.getActions ();
        actions.addAction (createObjectHoverAction ());
//        actions.addAction (createSelectAction ());
        actions.addAction (moveAction);

        mainLayer.addChild (widget);
        return widget;
    }

    protected Widget attachEdgeWidget (String edge) {
        ConnectionWidget widget = new ConnectionWidget (this);
        widget.setTargetAnchorShape (AnchorShape.TRIANGLE_FILLED);

        LabelWidget connectionLabel = new LabelWidget(this, edge);
        widget.addChild(connectionLabel);
        widget.setConstraint(connectionLabel
                ,LayoutFactory.ConnectionWidgetLayoutAlignment.TOP_CENTER
                ,0.5f);

        WidgetAction.Chain actions = widget.getActions ();
        actions.addAction (createObjectHoverAction ());
        actions.addAction (createSelectAction ());

        connectionLayer.addChild (widget);
        return widget;
    }

    protected void attachEdgeSourceAnchor (String edge, String oldSourceNode, String sourceNode) {
        ConnectionWidget edgeWidget = (ConnectionWidget) findWidget (edge);
        Widget sourceNodeWidget = findWidget (sourceNode);
        Anchor sourceAnchor = AnchorFactory.createRectangularAnchor (sourceNodeWidget);
        edgeWidget.setSourceAnchor (sourceAnchor);
    }

    protected void attachEdgeTargetAnchor (String edge, String oldTargetNode, String targetNode) {
        ConnectionWidget edgeWidget = (ConnectionWidget) findWidget (edge);
        Widget targetNodeWidget = findWidget (targetNode);
        Anchor targetAnchor = AnchorFactory.createRectangularAnchor (targetNodeWidget);
        edgeWidget.setTargetAnchor (targetAnchor);
    }

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
