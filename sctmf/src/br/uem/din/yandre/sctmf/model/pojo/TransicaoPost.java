/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uem.din.yandre.sctmf.model.pojo;


/**
 *
 * @author michelmenega
 */
public class TransicaoPost {

    private String nome;
    private Estado estadoOrigem;
    private Estado estadoDestino;
    private Simbolo simbolo;
    //private List<Simbolo> scripts = new ArrayList<Simbolo>();

    public void delete() {
        //estadoOrigem.removeTransicao(this);
        estadoOrigem = null;
        estadoDestino = null;
    }



    public TransicaoPost(){
    }

    public TransicaoPost(Estado estadoOrigem, Estado estadoDestino, Simbolo simbolo)  {
        this.estadoOrigem = estadoOrigem;
        this.estadoDestino = estadoDestino;
        this.simbolo = simbolo;
    }


    public Estado getEstadoDestino() {
        return estadoDestino;
    }

    public void setEstadoDestino(Estado estadoDestino){
        this.estadoDestino = estadoDestino;
    }

    public Estado getEstadoOrigem() {
        return estadoOrigem;
    }

    public void setEstadoOrigem(Estado estadoOrigem){
        this.estadoOrigem = estadoOrigem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public Simbolo getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(Simbolo simbolo) {
        this.simbolo = simbolo;
    }


}
