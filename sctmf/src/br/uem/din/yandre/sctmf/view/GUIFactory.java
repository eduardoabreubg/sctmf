/*
 * GUIFactory.java
 *
 * Created on 11 de Abril de 2007, 08:30
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package br.uem.din.yandre.sctmf.view;

import br.uem.din.yandre.sctmf.view.modelos_formais.ling_enum_rec.mt.MtGUI;
import br.uem.din.yandre.sctmf.view.modelos_formais.ling_liv_contex.glc.GlcGUI;
import br.uem.din.yandre.sctmf.view.modelos_formais.ling_regul.afd.AfdGUI;
import br.uem.din.yandre.sctmf.view.modelos_formais.ling_regul.afnd.AfndGUI;
import br.uem.din.yandre.sctmf.view.modelos_formais.ling_liv_contex.ap.ApGUI;
import br.uem.din.yandre.sctmf.view.modelos_formais.ModeloFormalGUI;
import br.uem.din.yandre.sctmf.view.modelos_formais.ling_enum_rec.post.PostGUI;
import br.uem.din.yandre.sctmf.view.modelos_formais.ling_regul.afmv.AfmvGUI;
import br.uem.din.yandre.sctmf.view.modelos_formais.ling_regul.er.ErGUI;
import br.uem.din.yandre.sctmf.view.modelos_formais.ling_regul.mealy.MealyGUI;
import br.uem.din.yandre.sctmf.view.modelos_formais.ling_regul.moore.MooreGUI;
import br.uem.din.yandre.sctmf.view.modelos_formais.ling_sens_cont.all.AllGUI;

/**
 *
 * @author rafael2009_00
 */
public class GUIFactory {

    /** Creates a new instance of GUIFactory */
    private GUIFactory() {
    }

    public static ModeloFormalGUI getInstanceMF(IdModeloFormal mf) {
        switch (mf) {
            case AFD:
                return new AfdGUI();

            case AFND:
                return new AfndGUI();

            case AFMV:
                return new AfmvGUI();

            case ER:
                return new ErGUI();

            case AP:
                return new ApGUI();

            case GLC:
                return new GlcGUI();

            case ALL:
                return new AllGUI();

            case MT:
                return new MtGUI();

            case MEALY:
                return new MealyGUI();

            case MOORE:
                return new MooreGUI();

            case POST:
                return new PostGUI();

            default:
                return null;
        }
    }
}
