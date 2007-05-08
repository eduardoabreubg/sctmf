/*
 * Transicao.java
 *
 * Created on 7 de Maio de 2007, 20:30
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package cassolato.rafael.sctmf.model.pojo;

/**
 *
 * @author Cassolato
 */
public class Transicao {
    private Estado estOri;
    private Simbolo simbolo;
    private Estado estDest;    
    
    /** Creates a new instance of Transicao */
    public Transicao() {
    }

    public Estado getEstOri() {
        return estOri;
    }

    public void setEstOri(Estado estOri) {
        this.estOri = estOri;
    }

    public Simbolo getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(Simbolo simbolo) {
        this.simbolo = simbolo;
    }

    public Estado getEstDest() {
        return estDest;
    }

    public void setEstDest(Estado estDest) {
        this.estDest = estDest;
    }
    
}