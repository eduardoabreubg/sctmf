package br.uem.din.yandre.sctmf.model.services.transformacoes;

import br.uem.din.yandre.sctmf.model.pojo.GLC;
import br.uem.din.yandre.sctmf.model.pojo.GLCFNC;
import br.uem.din.yandre.sctmf.model.pojo.ModeloFormal;
import br.uem.din.yandre.sctmf.model.pojo.RegraProducao;
import br.uem.din.yandre.sctmf.model.pojo.SimboloString;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Fabio Schnaider Bortolotto
 */
public class GLC2FNC implements Transformacao {
    private GLC gramatica;
    
    public GLC2FNC() { }
    
    @Override
    public void setModeloFormalOrigem (ModeloFormal mf) {
        gramatica = (GLC) mf;
    }
    
    @Override
    public GLCFNC transformar() {
        GLCFNC ret = new GLCFNC();
        
        SimplificacaoGLC tSimp = new SimplificacaoGLC();
        tSimp.setModeloFormalOrigem(gramatica);
        GLC simp = tSimp.transformar();
        
        ret.setSimbTerm(new HashSet(simp.getSimbTerm()));
        ret.setSimbNTerm(new HashSet(simp.getSimbNTerm()));
        ret.setSimbInicial(simp.getSimbInicial());
        
        Set<RegraProducao> rps = new HashSet<RegraProducao>();
        Set<RegraProducao> rps2proxEtapa = new HashSet<RegraProducao>();
        for (RegraProducao rp : simp.getRegrasProducao()) {
            List<SimboloString> ladoDireito = rp.getSimbLDireito();
            RegraProducao rp2add = new RegraProducao();
            rp2add.setSimbLEsq(rp.getSimbLEsq());
            
            if (ladoDireito.size() == 1) {
                rp2add.setSimbLDireito(new LinkedList(ladoDireito));
                rps.add(rp2add);
            } else {
                List<SimboloString> lDir = new LinkedList();
                for (SimboloString s : ladoDireito) {
                    if (ret.getSimbTerm().contains(s)) {
                        String nome = "C" +s.getNome().toUpperCase();
                        SimboloString tmp = new SimboloString(nome);
                        int i = 0;
                        while (ret.getSimbTerm().contains(tmp)) {
                            tmp = new SimboloString(tmp.getNome() +String.valueOf(i));
                            i++;
                        }
                        RegraProducao newRp = new RegraProducao();
                        List<SimboloString> l = new LinkedList(); l.add(s);
                        newRp.setSimbLEsq(tmp); newRp.setSimbLDireito(l);
                        rps.add(newRp);
                        s = tmp; ret.addSimbNTerm(s);
                    }
                    lDir.add(s);
                }
                rp2add.setSimbLDireito(lDir);
                rps2proxEtapa.add(rp2add);
            }
        }
        
        int i = 0;
        for (RegraProducao rpSrc : rps2proxEtapa) {
            Iterator<SimboloString> it = rpSrc.getSimbLDireito().iterator();
            SimboloString s = null, proximo = null;
            SimboloString anterior = rpSrc.getSimbLEsq();
            if (it.hasNext()) s = it.next();
            for ( ; it.hasNext(); s = proximo) {
                RegraProducao rp = new RegraProducao();
                rp.setSimbLEsq(anterior);

                String prefixo = "D";
                SimboloString ds = new SimboloString(prefixo +String.valueOf(i));
                while (ret.getSimbTerm().contains(ds)) {
                    ds = new SimboloString(prefixo +String.valueOf(i));
                    i++;
                }
                proximo = it.next();
                if (it.hasNext()) {
                    i++; ret.addSimbNTerm(ds);
                }
                
                List<SimboloString> lDir = new LinkedList();
                lDir.add(s); 
                
                lDir.add(it.hasNext() ?ds :proximo);
                rp.setSimbLDireito(lDir);
                
                rps.add(rp);
                
                anterior = ds;
            }
        }
        
        ret.setRegrasProducao(rps);
        
        return ret;
    }
}