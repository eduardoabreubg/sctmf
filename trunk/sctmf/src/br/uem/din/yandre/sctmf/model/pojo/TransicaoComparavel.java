package br.uem.din.yandre.sctmf.model.pojo;

/**
 *
 * @author Fabio Schnaider Bortolotto
 */
public class TransicaoComparavel extends Transicao implements Comparable<Transicao> {

    public TransicaoComparavel(Transicao t) {
        setEstOri(t.getEstOri());
        setSimbolo(t.getSimbolo());
        setEstDest(t.getEstDest());
    }

    @Override
    public int compareTo(Transicao o) {
        int ret = (new EstadoComparavel(getEstOri())).compareTo(o.getEstOri());
        if (ret != 0) return ret;
        ret = (new SimboloComparavel(getSimbolo())).compareTo(o.getSimbolo());
        if (ret != 0) return ret;
        ret = (new EstadoComparavel(getEstDest())).compareTo(o.getEstDest());
        return ret;
    }
}
