package br.uem.din.yandre.sctmf.model.services.transformacoes;

import br.uem.din.yandre.sctmf.model.pojo.GLC;
import br.uem.din.yandre.sctmf.model.pojo.ModeloFormal;
import br.uem.din.yandre.sctmf.model.pojo.RegraProducao;
import br.uem.din.yandre.sctmf.model.pojo.SimboloString;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Fabio Schnaider Bortolotto
 */
public class SimplificacaoGLC implements Transformacao {
    private GLC src;
    private GLC ret;
    
    public SimplificacaoGLC() { }
    
    @Override
    public GLC transformar() {
        ret = new GLC();
        
        List<RegraProducao> lProds = new LinkedList<RegraProducao>();
        lProds.addAll(src.getRegrasProducao());
        Set<SimboloString> vazias = new HashSet<SimboloString>();
        SimboloString lambda = GLC.LAMBDA;
        for (int i = 0; i < lProds.size(); i++) {
            RegraProducao r = lProds.get(i);
            if (lambda.equals(r.getSimbLDireito().get(0))) {
                lProds.remove(i); i--;
                vazias.add(r.getSimbLEsq());
            }
        }
        int lastSize;
        do {
            lastSize = vazias.size();
            for (RegraProducao r : lProds) {
                boolean geraLambda = true;
                for (SimboloString s : r.getSimbLDireito()) {
                    if (!vazias.contains(s)) {
                        geraLambda = false;
                        break;
                    }
                }
                if (geraLambda) vazias.add(r.getSimbLEsq());
            }
        } while (lastSize != vazias.size());
        
        do {
            lastSize = lProds.size();
            for (int j = 0; j < lProds.size(); j++) {
                RegraProducao r = lProds.get(j);
                List<SimboloString> lDir = r.getSimbLDireito();
                if (lDir.size() <= 1) continue;
                for (int i = 0; i < lDir.size(); i++) {
                    if (vazias.contains(lDir.get(i))) {
                        List<SimboloString> l = new LinkedList<SimboloString>();
                        l.addAll(lDir);
                        l.remove(i);
                        RegraProducao n = new RegraProducao();
                        n.setSimbLEsq(r.getSimbLEsq());
                        n.setSimbLDireito(l);
                        if (!lProds.contains(n)) lProds.add(n);
                    }
                }
            }
        } while (lastSize != lProds.size());
        
        // Se a gramatica gera produção vazia o simbolo inicial vai estar no conjunto que gera cadeia vazia
        if (vazias.contains(src.getSimbInicial())) {
            RegraProducao rp = new RegraProducao();
            rp.setSimbLEsq(src.getSimbInicial());
            List<SimboloString> l = new LinkedList(); l.add(lambda);
            rp.setSimbLDireito(l);
            lProds.add(rp);
        }
        
        Set<RegraProducao> prods = new LinkedHashSet<RegraProducao>();
        prods.addAll(lProds);
        ret.setRegrasProducao(prods);
        
        ret.setSimbInicial(src.getSimbInicial());
        ret.setSimbNTerm(src.getSimbNTerm());
        ret.setSimbTerm(src.getSimbTerm());
        
        HashMap<SimboloString,Set<SimboloString>> fechos;
        fechos = new HashMap<SimboloString,Set<SimboloString>>();
        for (SimboloString s : src.getSimbNTerm()) {
            Set<SimboloString> prodsUnit = gerarProdUnit(s);
            if (prodsUnit.size() > 0) fechos.put(s, prodsUnit);
        }
        
        prods = new LinkedHashSet<RegraProducao>();
        for (RegraProducao p : ret.getRegrasProducao()) {
            if (p.getSimbLDireito().size() != 1 
            || !ret.getSimbNTerm().contains(p.getSimbLDireito().get(0))) 
                prods.add(p);
        }
        
        for (SimboloString origem : fechos.keySet()) {
            for (SimboloString prodUnit : fechos.get(origem)) {
                for (RegraProducao p : ret.getRegrasProducao()) {
                    if (!p.getSimbLEsq().equals(prodUnit)) continue;
                    
                    RegraProducao n = new RegraProducao();
                    n.setSimbLEsq(origem);
                    n.setSimbLDireito(p.getSimbLDireito());
                    prods.add(n);
                }
            }
        }
        
        ret.setRegrasProducao(prods);
        
        Set<SimboloString> variaveis = new LinkedHashSet<SimboloString>();
        gerarProdutivos(variaveis);
        ret.setSimbNTerm(variaveis);
        
        rmvProducoesInuteis(ret.getSimbNTerm(), ret.getSimbTerm());
        
        Set<SimboloString> t = new LinkedHashSet<SimboloString>();
        Set<SimboloString> nT = new LinkedHashSet<SimboloString>();
        gerarAcessiveis(nT, t, src.getSimbInicial());
        
        Set<SimboloString> terminais = new LinkedHashSet();
        for (SimboloString s : src.getSimbTerm()) 
            if (t.contains(s)) terminais.add(s);
        ret.setSimbTerm(terminais);
        
        Set<SimboloString> nTerminais = new LinkedHashSet();
        for (SimboloString s : src.getSimbNTerm()) 
            if (nT.contains(s)) nTerminais.add(s);
        ret.setSimbNTerm(nTerminais);
        
        rmvProducoesInuteis(ret.getSimbNTerm(), ret.getSimbTerm());
        
        return ret;
    }
    
    public void rmvProducoesInuteis (Set<SimboloString> nTerm, Set<SimboloString> term) {
        Iterator<RegraProducao> it = ret.getRegrasProducao().iterator();
        while ( it.hasNext() ) {
            RegraProducao r = it.next();
            boolean regraValida = nTerm.contains(r.getSimbLEsq());
            if (regraValida) {
                for (SimboloString s : r.getSimbLDireito()) {
                    if (!nTerm.contains(s) && !term.contains(s)) {
                        regraValida = false; break;
                    }
                }
            }
            
            if (!regraValida) it.remove();
        }
    }
    
    public void gerarProdutivos(Set<SimboloString> v) {
        int lastSize = 0;
        do {
            lastSize = v.size();
            for(RegraProducao r : ret.getRegrasProducao()) {
                boolean produtivo = true;
                for (SimboloString s : r.getSimbLDireito()) {
                    if (!v.contains(s) && !ret.getSimbTerm().contains(s)) {
                        produtivo = false; break;
                    }
                }
                if (produtivo) v.add(r.getSimbLEsq());
            }
        } while (v.size() != lastSize);
    }
    
    public void gerarAcessiveis(Set<SimboloString> nTerm, Set<SimboloString> term, SimboloString lEsq) {
        if (!nTerm.add(lEsq)) return;
        for (RegraProducao r : ret.getRegrasProducao()) {
            if (!r.getSimbLEsq().equals(lEsq)) continue;
            for (SimboloString simb : r.getSimbLDireito()) {
                if (src.getSimbTerm().contains(simb)) term.add(simb);
                else gerarAcessiveis(nTerm, term, simb);
            }
        }
    }
    
    public Set<SimboloString> gerarProdUnit(SimboloString s) {
        Set<SimboloString> prodUnit = new LinkedHashSet<SimboloString>();
        gerarProdUnit(s, prodUnit);
        return prodUnit;
    }
    
    public void gerarProdUnit(SimboloString s, Set<SimboloString> prodUnit) {
        for (RegraProducao p : ret.getRegrasProducao()) {
            List<SimboloString> l = p.getSimbLDireito();
            if (l.size() == 1 && p.getSimbLEsq().equals(s)) {
                SimboloString dest = l.get(0);
                if (ret.getSimbNTerm().contains(dest) && prodUnit.add(dest)) 
                    gerarProdUnit(dest,prodUnit);
            }
        }
    }

    @Override
    public void setModeloFormalOrigem(ModeloFormal mf) {
         src = (GLC) mf;
   }
}