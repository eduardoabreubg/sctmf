/*
 * GLC.java
 *
 * Created on 8 de Agosto de 2007, 09:33
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package cassolato.rafael.sctmf.model.pojo;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 *
 * @author rafael2009_00
 */
public class GLC extends Gramatica {
    
    private Simbolo simbInicial;
    private Set<Simbolo> simbTerm = new LinkedHashSet<Simbolo>();
    private Set<Simbolo> simbNTerm = new LinkedHashSet<Simbolo>() ;
    private Set<RegraProducao> regrasProducao = new LinkedHashSet<RegraProducao>();
        
    /** Creates a new instance of GLC */
    public GLC() {
    }

    public Simbolo getSimbInicial() {
        return simbInicial;
    }

    public void setSimbInicial(Simbolo simbInicial) {
        this.simbInicial = simbInicial;
    }

    public Set<Simbolo> getSimbTerm() {
        return simbTerm;
    }

    public void setSimbTerm(Set<Simbolo> simbTerm) {
        this.simbTerm = simbTerm;
    }

    public Set<Simbolo> getSimbNTerm() {
        return simbNTerm;
    }

    public void setSimbNTerm(Set<Simbolo> simbNTerm) {
        this.simbNTerm = simbNTerm;
    }
           
    public void addSimbNTerm(Simbolo s) {
        this.simbNTerm.add(s);
    }
    
    public void addSimbTerm(Simbolo s) {
        this.simbTerm.add(s);
    }
    
    public void addRegraProducao(RegraProducao rp) {
        this.getRegrasProducao().add(rp);
    }

    public Set<RegraProducao> getRegrasProducao() {
        return regrasProducao;
    }

    public void setRegrasProducao(Set<RegraProducao> regrasProducao) {
        this.regrasProducao = regrasProducao;
    }
    
}