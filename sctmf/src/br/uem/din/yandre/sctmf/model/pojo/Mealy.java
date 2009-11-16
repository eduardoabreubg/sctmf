/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.uem.din.yandre.sctmf.model.pojo;

/**
 *
 * @author michelmenega
 */
public class Mealy extends Automato {

    private Estado estadoInicial;

    /** Creates a new instance of moore */
    public Mealy() {
    }

    public Estado getEstadoInicial() {
        return estadoInicial;
    }

    public void setEstadoInicial(Estado ei) {
        this.estadoInicial = ei;
    }

}
