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

    public Set<Simbolo> getAlfabeto() {
        return alfabeto;
    }

    public void setAlfabeto(Set<Simbolo> alfabeto) {
        this.alfabeto = alfabeto;
    }

    public Set<Estado> getEstados() {
        return estados;
    }

    public void setEstados(Set<Estado> estados) {
        this.estados = estados;
    }

    public Set<TransicaoMT> getTransicoes() {
        return transicoes;
    }

    public void setTransicoes(Set<TransicaoMT> transicoes) {
        this.transicoes = transicoes;
    }

    public Estado getEstIni() {
        return estIni;
    }

    public void setEstIni(Estado estIni) {
        this.estIni = estIni;
    }

    public Set<Estado> getEstFinais() {
        return estFinais;
    }

    public void setEstFinais(Set<Estado> estFinais) {
        this.estFinais = estFinais;
    }

    public Set<Simbolo> getAlfabetoAux() {
        return alfabetoAux;
    }

    public void setAlfabetoAux(Set<Simbolo> alfabetoAux) {
        this.alfabetoAux = alfabetoAux;
    }

    public Simbolo getSimbIni() {
        return simbIni;
    }

    public void setSimbIni(Simbolo simbIni) {
        this.simbIni = simbIni;
    }

    public Simbolo getSimbBranco() {
        return simbBranco;
    }

    public void setSimbBranco(Simbolo simbBranco) {
        this.simbBranco = simbBranco;
    }
    
    
    
}