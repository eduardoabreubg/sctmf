/*
 * MT.java
 *
 * Created on 24 de Agosto de 2007, 17:21
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package cassolato.rafael.sctmf.model.pojo;

import java.util.Set;

/**
 *
 * @author Cassolato
 */
public class MT extends ModeloFormal {
    
    private Set<Simbolo> alfabeto;
    private Set<Estado> estados;
    private Set<TransicaoMT> transicoes;
    private Estado estIni;
    private Set<Estado> estFinais;
    private Set<Simbolo> alfabetoAux;
    private Simbolo simbIni;
    private Simbolo simbBranco;
    
    /** Creates a new instance of MT */
    public MT() {
    }
    
}