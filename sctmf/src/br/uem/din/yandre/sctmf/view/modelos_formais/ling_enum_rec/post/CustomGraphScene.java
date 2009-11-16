/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uem.din.yandre.sctmf.view.modelos_formais.ling_enum_rec.post;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import javax.swing.JOptionPane;
import org.netbeans.api.visual.action.ActionFactory;
import org.netbeans.api.visual.action.ConnectProvider;
import org.netbeans.api.visual.action.ConnectorState;
import org.netbeans.api.visual.action.SelectProvider;
import org.netbeans.api.visual.action.WidgetAction;
import org.netbeans.api.visual.anchor.AnchorFactory;
import org.netbeans.api.visual.anchor.AnchorShape;
import org.netbeans.api.visual.anchor.PointShape;
import org.netbeans.api.visual.graph.GraphScene;
import org.netbeans.api.visual.graph.layout.GridGraphLayout;
import org.netbeans.api.visual.layout.LayoutFactory;
import org.netbeans.api.visual.layout.SceneLayout;
import org.netbeans.api.visual.router.Router;
import org.netbeans.api.visual.router.RouterFactory;
import org.netbeans.api.visual.widget.ConnectionWidget;
import org.netbeans.api.visual.widget.LabelWidget;
import org.netbeans.api.visual.widget.LayerWidget;
import org.netbeans.api.visual.widget.Scene;
import org.netbeans.api.visual.widget.Widget;

/**
 *
 * @author gustavo
 */// TODO: Descobrir como associar um nÃ³ com ele mesmo OK-> Se for nulo associa
// TODO: Interface com propriedades dos widgets para mostrar na tabela
// TODO: Integrar propriedades com meu modelo
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
    private int contadorParada = 0;
    private int contadorLer = 0;

    public SceneTool getSceneTool() {
        return sceneTool;
    }

    public void doGridLayout() {
        GridGraphLayout<String, String> graphLayout = new GridGraphLayout<String, String>();

        SceneLayout sceneGraphLayout = LayoutFactory.createSceneGraphLayout(this, graphLayout);
        sceneGraphLayout.invokeLayout();
        validate();
    }

    public void setSceneTool(SceneTool sceneTool) {
        setActiveTool(sceneTool.toString());
        this.sceneTool = sceneTool;

    }

    public CustomGraphScene() {

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

    public Widget criarNodo() {
        Widget newNode = null;
        if (PostGUI.bEstadoPartida.isSelected()) {
            newNode = addNode("Partida");
            PostGUI.bEstadoPartida.setEnabled(false);
            PostGUI.bEstadoParada.setSelected(true);
        } else if (PostGUI.bEstadoParada.isSelected()) {
            newNode = addNode("Parada " + ++contadorParada);
        } else if (PostGUI.bEstadoLer.isSelected()) {
            newNode = addNode("X <- Ler(X) " + ++contadorLer);
        } else if (PostGUI.bEstadoAtribuicao.isSelected()) {
            String concatena = JOptionPane.showInputDialog("Digite o Simbolo a ser concatenado a Direita de X");
            newNode = addNode("X <- X" + concatena.charAt(0));
        }
        return newNode;
    }

    /*public Widget criarNodo(String str) {

    Widget newNode = addNode(str);
    return newNode;
    }*/
    public String criarTransicao(String source, String target, String name) {
        addEdge(name);
        setEdgeSource(name, source);
        setEdgeTarget(name, target);
        return name;
    }

    public String criarTransicao(String source, String target) {
        if (source.contains("Ler")){
            String transicao = JOptionPane.showInputDialog("Digite o Simbolo(s) da transição. Utilize virgula para separar.");
            return criarTransicao(source, target, transicao);
        }
        return criarTransicao(source, target, "");
    }

    /*public void zoomIn() {
    double zoom = getZoomFactor();
    zoom += 0.2;
    setZoomFactor(zoom);
    validate();
    }

    public void zoomOut() {
    double zoom = getZoomFactor();
    zoom -= 0.2;
    setZoomFactor(zoom);
    validate();
    }*/
    private WidgetAction selectAction = ActionFactory.createSelectAction(new SelectProv());

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

        label.getActions(selecaoTool).addAction(selectAction);

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
        connection.getActions(selecaoTool).addAction(selectAction);



        //connection.addChild(connectionLabel);


        connectionLayer.addChild(connection);



        return connection;
    }

    protected void attachEdgeSourceAnchor(String edge, String oldSourceNode, String sourceNode) {
        Widget w = sourceNode != null ? findWidget(sourceNode) : null;

        ConnectionWidget connection = (ConnectionWidget) findWidget(edge);
        connection.setSourceAnchor(AnchorFactory.createRectangularAnchor(w));

        connection.setConstraint(w, LayoutFactory.ConnectionWidgetLayoutAlignment.BOTTOM_RIGHT, -10);

//        Widget source = findWidget(sourceNode);        
//        source.addChild(findWidget(edge));
    }

    protected void attachEdgeTargetAnchor(String edge, String oldTargetNode, String targetNode) {
        Widget w = targetNode != null ? findWidget(targetNode) : null;
        ConnectionWidget connection = (ConnectionWidget) findWidget(edge);
        connection.setTargetAnchor(AnchorFactory.createRectangularAnchor(w));

        connection.setConstraint(w, LayoutFactory.ConnectionWidgetLayoutAlignment.TOP_LEFT, 10);

//        Widget target = findWidget(targetNode);        
//        target.addChild(findWidget(edge));
    }
    /*  private int widgetCount = 0;

    public String generateNewNodeName() {
    widgetCount++;
    String nome = "Nodo" + widgetCount;
    if (findWidget(nome) == null) {
    return nome;
    } else {
    return generateNewNodeName();
    }
    }*/
    private int edgeCount = 0;

    public String generateNewEdgeName() {
        edgeCount++;
        String nome = "Transicao" + edgeCount;
        if (findWidget(nome) == null) {
            return nome;
        } else {
            return generateNewEdgeName();
        }
    }

    public void deleteSelectedWidgets() {
        Set widgets = getSelectedObjects();
        for (Object w : widgets) {
            removeNodeWithEdges((String) w);
//            Widget widget = findWidget(w);            
//            widget.removeFromParent();
//            if (widget instanceof MostravelNaTela) {
//                MostravelNaTela m = (MostravelNaTela) widget;
//                m.onDelete();
//            }
//            Collection<String> associacoes = null;
//            try {
//                associacoes = findNodeEdges((String) w, true, true);
//                if (associacoes instanceof MostravelNaTela) {
//                    MostravelNaTela m = (MostravelNaTela) widget;
//                    m.onDelete();
//                }
//            } catch (NullPointerException ex) {
//                //nao faz nada
//                //provavelmente buscou com identificador de um edge e nao achou nada
//            }
//            if (associacoes != null) {
//                for (String s : associacoes) {
//                    Widget assoc = findWidget(s);
//                    assoc.removeFromParent();
//                }
//            }
        }
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
            if((!source.contains("Parada")) && (!target.equals("Partida"))){
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
    private Widget selectedWidget = null;
    private Widget previousSelectedWidget;

    public Widget getSelectedWidget() {
        return selectedWidget;
    }
    List<CustomGraphSceneSelectionListener> selectListeners = new ArrayList<CustomGraphSceneSelectionListener>();

    public void addSelectionListener(CustomGraphSceneSelectionListener c) {
        selectListeners.add(c);
    }

    public void removeSelectionListener(CustomGraphScene c) {
        selectListeners.remove(c);
    }

    public void notifySelectionListeners() {
        for (CustomGraphSceneSelectionListener l : selectListeners) {
            l.update(this, selectedWidget, previousSelectedWidget);
        }
    }

    private class SelectProv implements SelectProvider {

        public boolean isAimingAllowed(Widget arg0, Point arg1, boolean arg2) {
            return true;
        }

        public boolean isSelectionAllowed(Widget arg0, Point arg1, boolean arg2) {
            return true;
        }

        public void select(Widget arg0, Point arg1, boolean arg2) {
            previousSelectedWidget = selectedWidget;
            selectedWidget = arg0;
            notifySelectionListeners();
        }
    }
}



