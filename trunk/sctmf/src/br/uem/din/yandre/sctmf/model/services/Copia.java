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


    public Copia(int cursor, String estAtual, int fitaInt) {
        this.cursor = cursor;
        this.estAtualNome = estAtual;
        this.fitaInt = fitaInt;
    }
    
    public Copia(int cursor, Estado estAtual,List<Simbolo> fita) {
        this.cursor = cursor;
        this.estAtual = estAtual;
        this.fita = fita;
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

    @Override
    public boolean equals(Object obj){
        Copia auxCompara = (Copia) obj;
        if (this.cursor == auxCompara.cursor &&
                this.estAtualNome.equals(auxCompara.estAtualNome) &&
                this.fitaInt == auxCompara.fitaInt){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + this.cursor;
        hash = 23 * hash + (this.estAtualNome != null ? this.estAtualNome.hashCode() : 0);
        hash = 23 * hash + this.fitaInt;
        return hash;
    }



 







}
