/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uem.din.yandre.sctmf.model.pojo;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 *
 * @author root
 */
public class Moore extends Automato {

    private Estado estadoInicial;

    /** Creates a new instance of moore */
    public Moore() {
    }

    public Estado getEstadoInicial() {
        return estadoInicial;
    }

    public void setEstadoInicial(Estado ei) {
        this.estadoInicial = ei;
    }
}
