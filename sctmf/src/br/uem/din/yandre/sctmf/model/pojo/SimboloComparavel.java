package br.uem.din.yandre.sctmf.model.pojo;

/**
 *
 * @author Fabio Schnaider Bortolotto
 */
public class SimboloComparavel extends Simbolo implements Comparable<Simbolo> {
    
    public SimboloComparavel(Character nome) {
        super(nome);
    }
    
    public SimboloComparavel(Simbolo s) {
        super(s.getNome());
    }
    
    @Override
    public int compareTo(Simbolo o) {
        return getNome() -o.getNome();
    }
}