

package br.uem.din.yandre.sctmf.model.pojo;

/**
 *
 * @author Cassolato $ Michel Menega
 */
public class TransicaoALL {
    
    private Estado estAtual;
    private Simbolo simLido;
    
    private Estado estDestino;
    private Simbolo simbEscrito;
    private Direcao direcao;
    
    /** Creates a new instance of TransicaoALL*/
    public TransicaoALL() {
    }

    public Estado getEstAtual() {
        return estAtual;
    }

    public void setEstAtual(Estado estAtual) {
        this.estAtual = estAtual;
    }

    public Simbolo getSimLido() {
        return simLido;
    }

    public void setSimLido(Simbolo simLido) {
        this.simLido = simLido;
    }

    public Estado getEstDestino() {
        return estDestino;
    }

    public void setEstDestino(Estado estDestino) {
        this.estDestino = estDestino;
    }

    public Simbolo getSimbEscrito() {
        return simbEscrito;
    }

    public void setSimbEscrito(Simbolo simbEscrito) {
        this.simbEscrito = simbEscrito;
    }

    public Direcao getDirecao() {
        return direcao;
    }

    public void setDirecao(Direcao direcao) {
        this.direcao = direcao;
    }
       
}