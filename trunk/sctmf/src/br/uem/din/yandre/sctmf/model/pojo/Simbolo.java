/*
 * Simbolo.java
 *
 * Created on 7 de Maio de 2007, 20:17
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.uem.din.yandre.sctmf.model.pojo;

/**
 *
 * @author Cassolato
 */
public class Simbolo {
    private Character nome;
    
    /** Creates a new instance of Simbolo */
    public Simbolo(Character nome) {
        this.nome = nome;
    }  

    public Character getNome() {
        return nome;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Simbolo other = (Simbolo) obj;
        if (this.nome != other.nome && (this.nome == null || !this.nome.equals(other.nome))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + (this.nome != null ? this.nome.hashCode() : 0);
        return hash;
    }
}