package br.uem.din.yandre.sctmf.view.modelos_formais.ling_enum_rec.post;


import br.uem.din.yandre.sctmf.model.pojo.Estado;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Paint;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

import org.netbeans.api.visual.model.ObjectState;
import org.netbeans.api.visual.widget.LabelWidget;
import org.netbeans.api.visual.widget.Scene;


class MyLabelWidget extends LabelWidget{

    private static final Border NORMAL_BORDER = BorderFactory.createLineBorder(Color.BLACK, 1);
    private static final Border HOOVER_BORDER = BorderFactory.createLineBorder(new Color(48, 162, 255));
    //private EstadoGui gui = new EstadoGui();
    //private Workflow workflow = new Workflow();
    private Estado estado = new Estado("oi");

    public MyLabelWidget(Scene s) {
        super(s);
        init();
    }

    public MyLabelWidget(Scene s, String str) {
        super(s, str);
        try {
            estado.setNome(str);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        init();
    }

    @Override
    public void setLabel(String arg0) {
        String oldLabel = getLabel();
        try {
            super.setLabel(arg0);
            if (estado != null)
                estado.setNome(arg0);
        } catch (Exception ex) {
            super.setLabel(oldLabel);
            System.out.println("Nome ja existe!!");
        }

    }

    public void init() {
        setVerticalAlignment(LabelWidget.VerticalAlignment.CENTER);
        setAlignment(LabelWidget.Alignment.CENTER);
        setPreferredSize(new Dimension(70, 40));
        setOpaque(true);
        normalLook();
    }

    public void normalLook() {
        setBorder(NORMAL_BORDER);
        setBackground(backgroundPaint());
    }

    @Override
    protected void notifyStateChanged(ObjectState previousState, ObjectState newState) {
        super.notifyStateChanged(previousState, newState);
        if (newState.isSelected()) {
            setBackground(selectedPaint());
            setBorder(NORMAL_BORDER);
        } else if (newState.isHovered()) {
            setBackground(backgroundPaint());
            setBorder(HOOVER_BORDER);
        } else {
            normalLook();
        }
    }

    protected Paint selectedPaint() {
        return new GradientPaint(0, 0, Color.WHITE, 200, 200, Color.CYAN, false);
    }

    protected Paint backgroundPaint() {
        return new GradientPaint(0, 0, Color.WHITE, 200, 200, Color.YELLOW, false);
    }

    public void saveState() {
        /*try {
        setLabel(gui.getNome());
        estado.setPreScripts(gui.getPreScriptsRightItems());
        estado.setPostScript(gui.getPostScriptsRightItems());
        } catch (Exception ex) {
        System.out.println(ex);
        }*/
    }

    public void loadState() {        
        /*gui.setNome(estado.getNome());
        //TODO CARREGAR TODOS SCRIPTS DO BD
        gui.setPreScriptsRightItems(estado.getPreScripts());
        gui.setPostScriptsRightItems(estado.getPreScripts());*/

    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
        setLabel(estado.getNome());
        loadState();
    }

    public JPanel getPanel() {
        return null;
    }

    public void onDelete() {
      //  getEstado().delete();
    }
}
