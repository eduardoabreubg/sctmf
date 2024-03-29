/*
 * AP.java
 *
 * Created on 16 de Junho de 2007, 13:30
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.uem.din.yandre.sctmf.model.pojo;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 *
 * @author Cassolato
 */
public class AP extends AFD {
    
    private Set<Simbolo> alfabetoPilha = new LinkedHashSet<Simbolo>();
    private Simbolo topoPilha; 
    private Set<TransicaoAP> transicoes = new LinkedHashSet<TransicaoAP>();
    
    /** Creates a new instance of AP */
    public AP() {
    }
    
    public void addSimboloPilha(Simbolo s) {
        this.alfabetoPilha.add(s);
    }
    
    public void addAllSimbolosPilha(Collection<Simbolo> c) {
        this.alfabetoPilha.clear();
        this.alfabetoPilha.addAll(c);
    }
    
    public void setTopoPilha(Simbolo s) {
        this.topoPilha = s;
    }
    
    public void addTransicao(TransicaoAP t) {
        this.transicoes.add(t);
    }
    
    public void addAllTransicoes(Set<TransicaoAP> t) {
        this.transicoes = t;
    }
    
    public Set<TransicaoAP> getTransicoesAP() {
        return this.transicoes;
    }
    
    public Set<Simbolo> getSimbolosPilha() {
        return this.alfabetoPilha;
    }
    
    public Simbolo getTopoPilha() {
        return this.topoPilha;
    }
    
}