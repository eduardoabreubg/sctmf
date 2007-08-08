/*
 * RegraProducao.java
 *
 * Created on 8 de Agosto de 2007, 09:34
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package cassolato.rafael.sctmf.model.pojo;

import java.util.List;

/**
 *
 * @author rafael2009_00
 */
public class RegraProducao {
    
    private Simbolo simbLEsq;
    private List<Simbolo> simbLDireito;
    
    /** Creates a new instance of RegraProducao */
    public RegraProducao() {
    }

    public Simbolo getSimbLEsq() {
        return simbLEsq;
    }

    public void setSimbLEsq(Simbolo simbLEsq) {
        this.simbLEsq = simbLEsq;
    }

    public List<Simbolo> getSimbLDireito() {
        return simbLDireito;
    }

    public void setSimbLDireito(List<Simbolo> simbLDireito) {
        this.simbLDireito = simbLDireito;
    }
    
    
}
