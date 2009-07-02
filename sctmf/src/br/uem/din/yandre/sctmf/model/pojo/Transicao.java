/*
 * Transicao.java
 *
 * Created on 7 de Maio de 2007, 20:30
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.uem.din.yandre.sctmf.model.pojo;

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
    
    public Transicao(Estado estOri, Simbolo simbolo, Estado estDest) {
        this.estOri = estOri;
        this.simbolo = simbolo;
        this.estDest = estDest;
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

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Transicao other = (Transicao) obj;
        if (this.estOri != other.estOri && (this.estOri == null || !this.estOri.equals(other.estOri))) {
            return false;
        }
        if (this.simbolo != other.simbolo && (this.simbolo == null || !this.simbolo.equals(other.simbolo))) {
            return false;
        }
        if (this.estDest != other.estDest && (this.estDest == null || !this.estDest.equals(other.estDest))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + (this.estOri != null ? this.estOri.hashCode() : 0);
        hash = 53 * hash + (this.simbolo != null ? this.simbolo.hashCode() : 0);
        hash = 53 * hash + (this.estDest != null ? this.estDest.hashCode() : 0);
        return hash;
    }

}