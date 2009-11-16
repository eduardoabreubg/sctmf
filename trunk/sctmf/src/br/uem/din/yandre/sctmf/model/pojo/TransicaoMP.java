/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uem.din.yandre.sctmf.model.pojo;


import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author gustavo
 */
public class TransicaoMP {

    private String nome;
    private Estado estadoOrigem;
    private Estado estadoDestino;
    private List<Simbolo> scripts = new ArrayList<Simbolo>();

    public void delete() {
        //estadoOrigem.removeTransicao(this);
        estadoOrigem = null;
        estadoDestino = null;
    }

    public List<Simbolo> getScripts() {
        return scripts;
    }

    public void setScripts(List<Simbolo> scripts) {
        this.scripts = scripts;
    }

    public TransicaoMP(){
    }

    public TransicaoMP(Estado estadoOrigem, Estado estadoDestino)  {
        validarTransicoes(estadoOrigem, estadoDestino);
        //estadoOrigem.addOrigemTransicao(this);
        this.estadoOrigem = estadoOrigem;
        this.estadoDestino = estadoDestino;
    }

    private void validarTransicoes(Estado origem, Estado destino)  {
        if (origem != null && destino != null) {
  //          if (!origem.getWorkflow().equals(destino.getWorkflow())) {
   //             throw new BusinessException("Transição entre workflows diferentes");
            }
            //List<TransicaoMP> transicoes = origem.getOrigemTransicoes();
            //int count = 0;
            //for (TransicaoMP t : transicoes) {
             //   if (this.equals(t)) {
              //      count++;
               // }
            //}
         //   if (count > 1) {
          //      throw new BusinessException("Estado associado com duas transicoes iguais");
           // }
        //}
    }

   // public Workflow getWorkflow() {
    //    return estadoDestino.getWorkflow();
   // }

    public Estado getEstadoDestino() {
        return estadoDestino;
    }

    public void setEstadoDestino(Estado estadoDestino){
        validarTransicoes(getEstadoOrigem(), estadoDestino);
        this.estadoDestino = estadoDestino;
    }

    public Estado getEstadoOrigem() {
        return estadoOrigem;
    }

    public void setEstadoOrigem(Estado estadoOrigem){
        validarTransicoes(estadoOrigem, getEstadoDestino());
       // if (this.estadoOrigem != null) {
        //    this.estadoOrigem.removeTransicao(this);
       // }
        //estadoOrigem.addOrigemTransicao(this);
        this.estadoOrigem = estadoOrigem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome){
        validarTransicoes(estadoOrigem, estadoDestino);
        this.nome = nome;
    }

    @Override
    /**
     * equals com nome, origem, destino
     */
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TransicaoMP other = (TransicaoMP) obj;
        if (this.nome != other.nome && (this.nome == null || !this.nome.equals(other.nome))) {
            return false;
        }
        if (this.estadoOrigem != other.estadoOrigem && (this.estadoOrigem == null || !this.estadoOrigem.equals(other.estadoOrigem))) {
            return false;
        }
        if (this.estadoDestino != other.estadoDestino && (this.estadoDestino == null || !this.estadoDestino.equals(other.estadoDestino))) {
            return false;
        }
        return true;
    }
}
