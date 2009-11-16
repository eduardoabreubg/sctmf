/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.uem.din.yandre.sctmf.model.pojo;
import java.util.LinkedHashSet;
import java.util.Set;
/**
 *
 * @author michelmenega
 */
public class ALL extends ModeloFormal{

    private Set<Simbolo> alfabeto = new LinkedHashSet<Simbolo>();
    private Set<Estado> estados = new LinkedHashSet<Estado>();
    private Set<TransicaoALL> transicoes = new LinkedHashSet<TransicaoALL>();
    private Estado estIni;
    private Set<Estado> estFinais = new LinkedHashSet<Estado>();
    private Set<Simbolo> alfabetoAux = new LinkedHashSet<Simbolo>();
    private Simbolo simbIni;
    private Set<Estado> estadosND;//estados q possuem nao determinismo

    /** Creates a new instance of MT */
    public ALL() {
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

    public Set<TransicaoALL> getTransicoes() {
        return transicoes;
    }

    public void setTransicoes(Set<TransicaoALL> transicoes) {
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

    public void addTransicao(TransicaoALL t) {
        this.transicoes.add(t);
    }

    public void addSimbAlf(Simbolo simbolo) {
        this.alfabeto.add(simbolo);
    }

    public void addSimbAlfAux(Simbolo simbolo) {
         this.alfabetoAux.add(simbolo);
    }

    public void addEstado(Estado estado) {
       this.estados.add(estado);
    }

    public void addEstadoFinal(Estado estado) {
        this.estFinais.add(estado);
    }

    public Set<Estado> getEstadosND() {
        return estadosND;
    }

    public void setEstadosND(Set<Estado> estadosND) {
        this.estadosND = estadosND;
    }

}
