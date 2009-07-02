package br.uem.din.yandre.sctmf.model.services.transformacoes;

import br.uem.din.yandre.sctmf.model.pojo.Automato;
import br.uem.din.yandre.sctmf.model.pojo.Estado;
import br.uem.din.yandre.sctmf.model.pojo.EstadoComparavel;
import br.uem.din.yandre.sctmf.model.pojo.SimboloComparavel;
import br.uem.din.yandre.sctmf.model.pojo.Transicao;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 *
 * @author Fabio Schnaider Bortolotto
 */
public class AutomatoUtil {
    public static TreeMap<SimboloComparavel,TreeMap<EstadoComparavel,Set<Estado>>> 
    getMapTrasicao(Automato a) {
        TreeMap<SimboloComparavel,TreeMap<EstadoComparavel,Set<Estado>>> ret;
        ret = new TreeMap<SimboloComparavel,TreeMap<EstadoComparavel,Set<Estado>>>();
        
        for (Transicao t : a.getTransicoes()) {
            SimboloComparavel s = new SimboloComparavel(t.getSimbolo());
            if (!ret.containsKey(s)) 
                ret.put(s, new TreeMap<EstadoComparavel, Set<Estado>>());
            TreeMap<EstadoComparavel, Set<Estado>> estadoTree = ret.get(s);
            EstadoComparavel estOri = new EstadoComparavel(t.getEstOri());
            if (!estadoTree.containsKey(estOri))
                estadoTree.put(estOri, new TreeSet<Estado>());
            Set<Estado> estadoSet = estadoTree.get(estOri);
            estadoSet.add(t.getEstDest());
        }
        
        return ret;
    }
    
    public static String concatNomes(Set<Estado> estados) {
        String estNome = new String();
        for (Estado est : estados) { estNome = estNome +est.getNome(); }
        return estNome;
    }
}
