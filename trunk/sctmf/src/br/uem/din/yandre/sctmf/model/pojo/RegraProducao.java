/*
 * RegraProducao.java
 *
 * Created on 8 de Agosto de 2007, 09:34
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.uem.din.yandre.sctmf.model.pojo;

import java.util.List;

/**
 *
 * @author rafael2009_00
 */
public class RegraProducao {
    
    private SimboloString simbLEsq;
    private List<SimboloString> simbLDireito;
    
    /** Creates a new instance of RegraProducao */
    public RegraProducao() {
    }

    public SimboloString getSimbLEsq() {
        return simbLEsq;
    }

    public void setSimbLEsq(SimboloString simbLEsq) {
        this.simbLEsq = simbLEsq;
    }

    public List<SimboloString> getSimbLDireito() {
        return simbLDireito;
    }

    public void setSimbLDireito(List<SimboloString> simbLDireito) {
        this.simbLDireito = simbLDireito;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final RegraProducao other = (RegraProducao) obj;
        if (this.simbLEsq != other.simbLEsq && (this.simbLEsq == null || !this.simbLEsq.equals(other.simbLEsq))) {
            return false;
        }
        if (this.simbLDireito != other.simbLDireito && (this.simbLDireito == null || !this.simbLDireito.equals(other.simbLDireito))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + (this.simbLEsq != null ? this.simbLEsq.hashCode() : 0);
        hash = 23 * hash + (this.simbLDireito != null ? this.simbLDireito.hashCode() : 0);
        return hash;
    }
    
    @Override
    public String toString() { 
        StringBuilder sb = new StringBuilder();
        sb.append(simbLEsq.toString() +" -> ");
        for(SimboloString s :simbLDireito) sb.append(s.toString() +"|");
        return sb.toString();
    }
}
