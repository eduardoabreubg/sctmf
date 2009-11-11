/*
 * Automato.java
 *
 * Created on 9 de Abril de 2007, 08:25
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
 * @author rafael2009_00
 */
public abstract class Automato extends ModeloFormal {

    private Set<Simbolo> simbolos = new LinkedHashSet<Simbolo>();
    private Set<Simbolo> simbolosSaida = new LinkedHashSet<Simbolo>();
    private Set<Estado> estados = new LinkedHashSet<Estado>();
    private Set<Transicao> transicoes = new LinkedHashSet<Transicao>();
    private Set<Estado> estadosFinais = new LinkedHashSet<Estado>();

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

    public void addAllEstados(Collection<Estado> c) {
        this.estados.clear();
        this.estados.addAll(c);
    }

    public void addEstado(Estado e) {
        estados.add(e);
    }

    public void removeEstado(Estado e) {
        estados.remove(e);
    }

    public void addAllTransicoes(Collection<Transicao> c) {
        this.transicoes.addAll(c);
    }

    public void clearAllTransicoes() {
        this.transicoes.clear();
    }

    public void addTransicao(Transicao t) {
        transicoes.add(t);
    }

    public void removeTransicao(Transicao t) {
        if (transicoes.contains(t)) {
            transicoes.remove(t);
        }
    }

    public void addAllEstFinais(Collection<Estado> c) {
        this.estadosFinais.clear();
        this.estadosFinais.addAll(c);
    }

    public void addEstadoFinal(Estado ef) {
        if (!estadosFinais.contains(ef)) {
            estadosFinais.add(ef);
        }
    }

    public void removeEstadoFinal(Estado ef) {
        if (estadosFinais.contains(ef)) {
            estadosFinais.remove(ef);
        }
    }

    public Set<Simbolo> getSimbolos() {
        return this.simbolos;
    }

    public Set<Estado> getEstados() {
        return this.estados;
    }

    public Set<Estado> getEstadosFinais() {
        return this.estadosFinais;
    }

    public Set<Transicao> getTransicoes() {
        return this.transicoes;
    }

    public void addAllSimbolosSaida(Collection<Simbolo> c) {
        this.simbolosSaida.clear();
        this.simbolosSaida.addAll(c);
    }

    public void addSimboloSaida(Simbolo s) {
        simbolosSaida.add(s);
    }

    public void removeSimboloSaida(Simbolo s) {
        simbolosSaida.remove(s);
    }

    public Set<Simbolo> getSimbolosSaida() {
        return simbolosSaida;
    }


}