/*
 * GLC.java
 *
 * Created on 8 de Agosto de 2007, 09:33
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.uem.din.yandre.sctmf.model.pojo;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 *
 * @author rafael2009_00
 */
public class GLC extends Gramatica {
    
    private SimboloString simbInicial;
    private Set<SimboloString> simbTerm = new LinkedHashSet<SimboloString>();
    private Set<SimboloString> simbNTerm = new LinkedHashSet<SimboloString>() ;
    private Set<RegraProducao> regrasProducao = new LinkedHashSet<RegraProducao>();
    public static SimboloString LAMBDA = new SimboloString("\u03bb");
        
    /** Creates a new instance of GLC */
    public GLC() {
    }

    public SimboloString getSimbInicial() {
        return simbInicial;
    }

    public void setSimbInicial(SimboloString simbInicial) {
        this.simbInicial = simbInicial;
    }

    public Set<SimboloString> getSimbTerm() {
        return simbTerm;
    }

    public void setSimbTerm(Set<SimboloString> simbTerm) {
        this.simbTerm = simbTerm;
    }

    public Set<SimboloString> getSimbNTerm() {
        return simbNTerm;
    }

    public void setSimbNTerm(Set<SimboloString> simbNTerm) {
        this.simbNTerm = simbNTerm;
    }
           
    public void addSimbNTerm(SimboloString s) {
        this.simbNTerm.add(s);
    }
    
    public void addSimbTerm(SimboloString s) {
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