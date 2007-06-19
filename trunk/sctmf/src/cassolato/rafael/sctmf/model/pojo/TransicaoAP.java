/*
 * TransicaoAP.java
 *
 * Created on 18 de Junho de 2007, 20:27
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package cassolato.rafael.sctmf.model.pojo;

import java.util.List;

/**
 *
 * @author Cassolato
 */
public class TransicaoAP {
    private Estado estOri;
    private Simbolo simbolo;
    private Simbolo simBasePilha;
    private Estado estDest;
    private List<Simbolo> simbDesPilha;
    
    /** Creates a new instance of TransicaoAP */
    public TransicaoAP(Estado estOri, Simbolo simbolo, Simbolo simBasePilha, 
            Estado estDest, List<Simbolo> simbDesPilha ) {
        this.setEstOri(estOri);
        this.setSimbolo(simbolo);
        this.setSimBasePilha(simBasePilha);
        this.setEstDest(estDest);
        this.setSimbDesPilha(simbDesPilha);
        
    }
    
    public TransicaoAP() {}

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

    public Simbolo getSimBasePilha() {
        return simBasePilha;
    }

    public void setSimBasePilha(Simbolo simBasePilha) {
        this.simBasePilha = simBasePilha;
    }

    public Estado getEstDest() {
        return estDest;
    }

    public void setEstDest(Estado estDest) {
        this.estDest = estDest;
    }

    public List<Simbolo> getSimbDesPilha() {
        return simbDesPilha;
    }

    public void setSimbDesPilha(List<Simbolo> simbDesPilha) {
        this.simbDesPilha = simbDesPilha;
    }
    
}