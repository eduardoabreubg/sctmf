/*
 * Estado.java
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
public class Estado {
    private String nome;
    private boolean naoDeterministico;
    private Simbolo simboloSaida;
    
    /** Creates a new instance of Estado */
    public Estado(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isNDeterministico() {
        return naoDeterministico;
    }

    public void setNDeterministico(boolean naoDeterministico) {
        this.naoDeterministico = naoDeterministico;
    }

    public Simbolo getSaida() {
        return simboloSaida;
    }

    public void setSaida(Simbolo saida) {
        this.simboloSaida = saida;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Estado other = (Estado) obj;
        if ((this.nome == null) ? (other.nome != null) : !this.nome.equals(other.nome)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + (this.nome != null ? this.nome.hashCode() : 0);
        return hash;
    }

}