/*
 * Automato.java
 *
 * Created on 9 de Abril de 2007, 08:25
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package cassolato.rafael.sctmf.model.pojo;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author rafael2009_00
 */
public abstract class Automato extends FormalModel {
    
    private Set<Simbolo> simbolos = new HashSet<Simbolo>();
    private Set<Estado> estados = new HashSet<Estado>();
    private Set<Transicao> transicoes = new HashSet<Transicao>();   
    
    private Set<Estado> estadosFinais = new HashSet<Estado>();
    
    /** Creates a new instance of Automato */
    public Automato() {
    }
    
    public void addAllSimbolos(Collection<Simbolo> c) {        
        this.simbolos.clear();
        this.simbolos.addAll(c);
    }
    
    public void addSimbolo(Simbolo s) {
        simbolos.add(s);        
    }
    
    public void removeSimbolo(Simbolo s) {
        simbolos.remove(s);
    }
    
    public void addEstado(Estado e) {
        estados.add(e);        
    }
    
    public void removeEstado(Estado e) {
        estados.remove(e);
    }
    
    public void addTransicao(Transicao t) {
        transicoes.add(t);
    }
    
    public void removeTransicao(Transicao t) {
        if(transicoes.contains(t))
            transicoes.remove(t);
    }
    
    public void addAllEstFinais(Collection<Estado> c) {        
        this.estadosFinais.clear();
        this.estadosFinais.addAll(c);
    }
    
    public void addEstadoFinal(Estado ef) {
        if(!estadosFinais.contains(ef))
            estadosFinais.add(ef);
    }
    
    public void removeEstadoFinal(Estado ef) {
        if(estadosFinais.contains(ef))
            estadosFinais.remove(ef);
    }
    
}