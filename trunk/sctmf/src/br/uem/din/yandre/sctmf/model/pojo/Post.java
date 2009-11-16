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

    public Post() {
    }

    public Set<Simbolo> getAlfabeto() {
        return alfabeto;
    }

    public void setAlfabeto(Set<Simbolo> alfabeto) {
        this.alfabeto = alfabeto;
    }
}
