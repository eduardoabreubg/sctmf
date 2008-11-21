/*
 * AFD.java
 *
 * Created on 9 de Abril de 2007, 08:25
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.uem.din.yandre.sctmf.model.pojo;

/**
 *
 * @author rafael2009_00
 */
public class AFD extends Automato {
    private Estado estadoInicial;
    
    /** Creates a new instance of AFD */
    public AFD() {
    }

    public Estado getEstadoInicial() {
        return estadoInicial;
    }

    public void setEstadoInicial(Estado ei) {
        this.estadoInicial = ei;
    }       
        
}