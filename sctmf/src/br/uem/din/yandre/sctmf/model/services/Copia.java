/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.uem.din.yandre.sctmf.model.services;

import br.uem.din.yandre.sctmf.model.pojo.Estado;
import br.uem.din.yandre.sctmf.model.pojo.Simbolo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author michelmenega
 */
public class Copia {

    private int cursor;
    private String estAtualNome;
    private Estado estAtual;
    private int fitaInt;
    private List<Simbolo> fita;
    private int transicao;
    private char simboloAtualNome;


    public Copia(int cursor, String estAtual, int fitaInt, int transicao) {
        this.cursor = cursor;
        this.estAtualNome = estAtual;
        this.fitaInt = fitaInt;
        this.transicao = transicao;
    }

    
    public Copia(int cursor, Estado estAtual,List<Simbolo> fita) {
        this.cursor = cursor;
        this.estAtual = estAtual;
        try {
            this.fita = (List)fita.getClass().getMethod("clone").invoke(fita);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Copia(String estAtualNome, char simboloAtualNome) {
        this.estAtualNome = estAtualNome;
        this.simboloAtualNome = simboloAtualNome;
    }

    public Estado getEstAtual() {
        return estAtual;
    }

    public void setEstAtual(Estado estAtual) {
        this.estAtual = estAtual;
    }

    public List<Simbolo> getFita() {
        return fita;
    }

    public void setFita(ArrayList<Simbolo> copiaFita) {
        this.fita = copiaFita;
    }

    public int getFitaInt() {
        return fitaInt;
    }

    public void setFitaInt(int copiaFita) {
        this.fitaInt = copiaFita;
    }

    public int getCursor() {
        return cursor;
    }

    public void setCursor(int cursor) {
        this.cursor = cursor;
    }

    public String getEstAtualNome() {
        return estAtualNome;
    }

    public void setEstAtualNome(String estAtualNome) {
        this.estAtualNome = estAtualNome;
    }

    public char getSimboloAtualNome() {
        return simboloAtualNome;
    }

    public void setSimboloAtualNome(char simboloAtualNome) {
        this.simboloAtualNome = simboloAtualNome;
    }

    public int getTransicao() {
        return transicao;
    }

    public void setTransicao(int transicao) {
        this.transicao = transicao;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Copia other = (Copia) obj;
        if (this.cursor != other.cursor) {
            return false;
        }
        if ((this.estAtualNome == null) ? (other.estAtualNome != null) : !this.estAtualNome.equals(other.estAtualNome)) {
            return false;
        }
        if (this.fitaInt != other.fitaInt) {
            return false;
        }
        if (this.transicao != other.transicao) {
            return false;
        }
        if (this.simboloAtualNome != other.simboloAtualNome) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + this.cursor;
        hash = 31 * hash + (this.estAtualNome != null ? this.estAtualNome.hashCode() : 0);
        hash = 31 * hash + this.fitaInt;
        hash = 31 * hash + this.transicao;
        hash = 31 * hash + this.simboloAtualNome;
        return hash;
    }









 







}
