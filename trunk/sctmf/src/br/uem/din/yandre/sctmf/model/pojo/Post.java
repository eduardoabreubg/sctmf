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
 *
 */
public class Post extends ModeloFormal {

    private Set<Simbolo> alfabeto = new LinkedHashSet<Simbolo>();
    private Set<TransicaoPost> transicoes = new LinkedHashSet<TransicaoPost>();
    private Set<Estado> estados = new LinkedHashSet<Estado>();

    public Post() {
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

    public Set<TransicaoPost> getTransicoes() {
        return transicoes;
    }

    public void setTransicoes(Set<TransicaoPost> transicoes) {
        this.transicoes = transicoes;
    }


}
