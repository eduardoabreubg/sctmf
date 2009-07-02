package br.uem.din.yandre.sctmf.model.pojo;

/**
 *
 * @author Fabio Schnaider Bortolotto
 */
public class EstadoComparavel extends Estado implements Comparable<Estado> {

    public EstadoComparavel(String nome) {
        super(nome);
    }
    
    public EstadoComparavel(Estado e) {
        super(e.getNome());
    }
    
    @Override
    public int compareTo(Estado o) {
        return getNome().compareTo(o.getNome());
    }
}
