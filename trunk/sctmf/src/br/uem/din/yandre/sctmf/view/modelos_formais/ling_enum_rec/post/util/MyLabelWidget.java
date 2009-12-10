package br.uem.din.yandre.sctmf.view.modelos_formais.ling_enum_rec.post.util;

import br.uem.din.yandre.sctmf.model.pojo.Estado;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Paint;

import javax.swing.JPanel;


import org.netbeans.api.visual.border.Border;
import org.netbeans.api.visual.border.BorderFactory;
import org.netbeans.api.visual.model.ObjectState;
import org.netbeans.api.visual.widget.LabelWidget;
import org.netbeans.api.visual.widget.Scene;

class MyLabelWidget extends LabelWidget {

    private static final Border NORMAL_BORDER = BorderFactory.createRoundedBorder(10, 10, Color.LIGHT_GRAY, Color.BLACK);
    private static final Border HOOVER_BORDER = BorderFactory.createRoundedBorder(10, 10, Color.gray, Color.BLUE);

    public MyLabelWidget(Scene s) {
        super(s);
        init();
    }

    public MyLabelWidget(Scene s, String str) {
        super(s, str);
        init();
    }

    @Override
    public void setLabel(String arg0) {
            super.setLabel(arg0);
    }

    public void init() {
        setVerticalAlignment(LabelWidget.VerticalAlignment.CENTER);
        setAlignment(LabelWidget.Alignment.CENTER);
        setPreferredSize(new Dimension(90, 35));
        setOpaque(true);
        normalLook();
    }

    public void normalLook() {
        setBorder(NORMAL_BORDER);
    }

    @Override
    protected void notifyStateChanged(ObjectState previousState, ObjectState newState) {
        super.notifyStateChanged(previousState, newState);
        if (newState.isSelected()) {
            setBorder(NORMAL_BORDER);
        } else if (newState.isHovered()) {
            setBorder(HOOVER_BORDER);
        } else {
            normalLook();
        }
    }
}
