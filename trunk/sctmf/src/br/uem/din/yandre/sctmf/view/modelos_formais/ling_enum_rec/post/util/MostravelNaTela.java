/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.uem.din.yandre.sctmf.view.modelos_formais.ling_enum_rec.post.util;

import javax.swing.JPanel;

/**
 *
 * @author gustavo
 */
public interface MostravelNaTela {
    public void saveState();
    public void loadState();
    public JPanel getPanel();
    public void onDelete();
}
