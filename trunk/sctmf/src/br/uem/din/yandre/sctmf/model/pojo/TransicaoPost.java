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

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TransicaoPost other = (TransicaoPost) obj;
        if ((this.nome == null) ? (other.nome != null) : !this.nome.equals(other.nome)) {
            return false;
        }
        if (this.estadoOrigem != other.estadoOrigem && (this.estadoOrigem == null || !this.estadoOrigem.equals(other.estadoOrigem))) {
            return false;
        }
        if (this.estadoDestino != other.estadoDestino && (this.estadoDestino == null || !this.estadoDestino.equals(other.estadoDestino))) {
            return false;
        }
        if (this.simbolo != other.simbolo && (this.simbolo == null || !this.simbolo.equals(other.simbolo))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + (this.nome != null ? this.nome.hashCode() : 0);
        hash = 23 * hash + (this.estadoOrigem != null ? this.estadoOrigem.hashCode() : 0);
        hash = 23 * hash + (this.estadoDestino != null ? this.estadoDestino.hashCode() : 0);
        hash = 23 * hash + (this.simbolo != null ? this.simbolo.hashCode() : 0);
        return hash;
    }

}
