/*
 * AFMV.java
 *
 * Created on 10 de Setembro de 2007, 20:21
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package cassolato.rafael.sctmf.model.pojo;

/**
 *
 * @author Cassolato
 */
public class AFMV extends AFND {
    
    private Simbolo simbInicial;
    
    /** Creates a new instance of AFMV */
    public AFMV() {
    }

    public Simbolo getSimbInicial() {
        return simbInicial;
    }

    public void setSimbInicial(Simbolo simbInicial) {
        this.simbInicial = simbInicial;
    }
    
}