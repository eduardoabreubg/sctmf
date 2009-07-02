package br.uem.din.yandre.sctmf.model.services.transformacoes;

import br.uem.din.yandre.sctmf.model.pojo.GLC;
import br.uem.din.yandre.sctmf.model.pojo.GLCFNG;
import br.uem.din.yandre.sctmf.model.pojo.ModeloFormal;
import br.uem.din.yandre.sctmf.model.pojo.RegraProducao;
import br.uem.din.yandre.sctmf.model.pojo.SimboloString;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Fabio Schnaider Bortolotto
 */
public class GLC2FNG implements Transformacao {
    private GLC gramatica;
    
    public GLC2FNG() { }
    
    @Override
    public void setModeloFormalOrigem (ModeloFormal mf) {
        gramatica = (GLC) mf;
    }
    
    @Override
    public GLCFNG transformar() {
        GLCFNG ret = new GLCFNG();
        
        SimplificacaoGLC tSimp = new SimplificacaoGLC();
        tSimp.setModeloFormalOrigem(gramatica);
        GLC simp = tSimp.transformar();
        
        ret.setSimbInicial(simp.getSimbInicial());
        ret.setSimbNTerm(simp.getSimbNTerm());
        ret.setSimbTerm(simp.getSimbTerm());
        
        // etapa 1
        Map<SimboloString,Integer> mapa2int = new HashMap();
        Map<Integer,SimboloString> mapa2ss = new HashMap();
        int i = 1;
        for (SimboloString s : ret.getSimbNTerm()) {
            mapa2int.put(s, i); mapa2ss.put(i, s); i++;
        }
        
        List<RegraProducao> rps = new LinkedList();
        
        for (RegraProducao rp : simp.getRegrasProducao()) {
            RegraProducao nrp = new RegraProducao();
            String esq = String.valueOf(mapa2int.get(rp.getSimbLEsq()));
            nrp.setSimbLEsq(new SimboloString(esq));
            List<SimboloString> dir = new LinkedList();
            for(SimboloString s : rp.getSimbLDireito()) {
                Integer sRen = mapa2int.get(s);
                String ns = (sRen == null) ?s.getNome() :String.valueOf(sRen);
                dir.add(new SimboloString(ns));
            }
            nrp.setSimbLDireito(dir);
            rps.add(nrp);
        }
        
        // etapa 2
        for (i = 1; i <= mapa2ss.size(); i++) {
            int lEsq = i; 
            SimboloString sEsq = new SimboloString(String.valueOf(lEsq));
            for (int j = 0; j < rps.size(); j++) {
                RegraProducao rpSrc = rps.get(j);
                if (!rpSrc.getSimbLEsq().equals(sEsq)) continue;
                
                List<SimboloString> lDirSrc = rpSrc.getSimbLDireito();
                SimboloString primeiro = lDirSrc.get(0);
                if (ret.getSimbTerm().contains(primeiro) 
                        || GLC.LAMBDA.equals(primeiro)) continue;
                
                int iPrimeiro = Integer.parseInt(primeiro.getNome());
                if (iPrimeiro < lEsq) {
                    rps.remove(j); j--; int tam = rps.size();
                    for (int k = 0; k < tam; k++) {
                        RegraProducao rp = rps.get(k);
                        if (!rp.getSimbLEsq().equals(primeiro)) continue;
                        
                        List<SimboloString> lDir = new LinkedList(rp.getSimbLDireito());
                        if (lDirSrc.size() > 1)
                            lDir.addAll(lDirSrc.subList(1, lDirSrc.size()));
                        
                        RegraProducao nRp = new RegraProducao();
                        nRp.setSimbLEsq(rpSrc.getSimbLEsq());
                        nRp.setSimbLDireito(lDir);
                        
                        if (!rps.contains(nRp)) rps.add(nRp);
                    }
                }
            }
        }
        
        // etapa 3
        Set<RegraProducao> prodRec = new HashSet();
        Set<SimboloString> adicionados = new HashSet();
        int recCount = 0; int tam = rps.size();
        for (i = 1; i <= mapa2ss.size(); i++) {
            SimboloString sEsq = new SimboloString(String.valueOf(i));
            for (int j = 0; j < tam; j++) {
                RegraProducao rpSrc = rps.get(j);
                if (!rpSrc.getSimbLEsq().equals(sEsq)) continue;
                List<SimboloString> lDirSrc = rpSrc.getSimbLDireito();
                if (lDirSrc.size() < 1 || !rpSrc.getSimbLEsq().equals(lDirSrc.get(0)))
                    continue;
                
                rps.remove(j); j--; tam--;
                SimboloString rec = new SimboloString("R" +rpSrc.getSimbLEsq().getNome());
                while (!adicionados.contains(rec) && ret.getSimbNTerm().contains(rec)) {
                    rec = new SimboloString(rec.getNome() +String.valueOf(recCount));
                    recCount++;
                }
                
                ret.addSimbNTerm(rec); adicionados.add(rec);
                
                List<SimboloString> slDir = new LinkedList();
                slDir.addAll(lDirSrc.subList(1, lDirSrc.size()));
                RegraProducao nRp = new RegraProducao();
                nRp.setSimbLEsq(rec); nRp.setSimbLDireito(slDir);
                prodRec.add(nRp);
                
                slDir = new LinkedList(lDirSrc.subList(1, lDirSrc.size()));
                slDir.add(rec);
                nRp = new RegraProducao();
                nRp.setSimbLEsq(rec); nRp.setSimbLDireito(slDir);
                prodRec.add(nRp);
                
                for (int k = 0; k < tam; k++) {
                    RegraProducao rp = rps.get(k);
                    List<SimboloString> lDir = rp.getSimbLDireito();
                    if (!rpSrc.getSimbLEsq().equals(rp.getSimbLEsq()) 
                            || rpSrc.getSimbLEsq().equals(lDir.get(0))) 
                        continue;
                    
                    slDir = new LinkedList(lDir);
                    slDir.add(rec);
                    nRp = new RegraProducao();
                    nRp.setSimbLEsq(rp.getSimbLEsq());
                    nRp.setSimbLDireito(slDir);
                    if (!rps.contains(nRp)) rps.add(nRp);
                }
            }
        }

System.out.println("apos etapa 3:");
for(RegraProducao rp : rps) System.out.println(rp);
for(RegraProducao rp : prodRec) System.out.println(rp);
        // etapa 4
        for (i = mapa2ss.size()-1; i >= 1; i--) {
            SimboloString sEsq = new SimboloString(String.valueOf(i));
            for (int j = 0; j < rps.size(); j++) {
                RegraProducao rpAval = rps.get(j);
                if (!rpAval.getSimbLEsq().equals(sEsq)) continue;
                
                List<SimboloString> lDir = rpAval.getSimbLDireito();
                if (lDir.size() == 0 || ret.getSimbTerm().contains(lDir.get(0)) 
                        || GLC.LAMBDA.equals(lDir.get(0)))
                    continue;
                
                rps.remove(j); j--;
                SimboloString as = lDir.get(0); tam = rps.size();
                for (int k = 0; k < tam; k++) {
                    RegraProducao rp = rps.get(k);
                    if (!as.equals(rp.getSimbLEsq())) continue;
                    RegraProducao nRp = new RegraProducao();
                    nRp.setSimbLEsq(rpAval.getSimbLEsq());
                    List<SimboloString> nlDir = new LinkedList();
                    nlDir.addAll(rp.getSimbLDireito());
                    nlDir.addAll(lDir.subList(1, lDir.size()));
                    nRp.setSimbLDireito(nlDir);
                    if (!rps.contains(nRp)) rps.add(nRp);
                }
            }
        }
        
        for (RegraProducao rp: prodRec) {
            List<SimboloString> lDir = rp.getSimbLDireito();
            if (lDir.size() == 0 || ret.getSimbTerm().contains(lDir.get(0)) 
                        || GLC.LAMBDA.equals(lDir.get(0))) {
                rps.add(rp);
            } else {
                SimboloString as = lDir.get(0); tam = rps.size();
                for (i = 0; i < tam; i++) {
                    RegraProducao rp2find = rps.get(i);
                    if (!as.equals(rp2find.getSimbLEsq())) continue;
                    RegraProducao nRp = new RegraProducao();
                    nRp.setSimbLEsq(rp.getSimbLEsq());
                    List<SimboloString> nlDir = new LinkedList();
                    nlDir.addAll(rp2find.getSimbLDireito());
                    nlDir.addAll(lDir.subList(1, lDir.size()));
                    nRp.setSimbLDireito(nlDir);
                    if (!rps.contains(nRp)) rps.add(nRp);
                }
            }
        }
        
        for (RegraProducao rp : rps) {
            SimboloString lEsq = rp.getSimbLEsq();
            try { lEsq = mapa2ss.get(Integer.parseInt(lEsq.getNome())); } 
            catch (Exception ex) {}
            rp.setSimbLEsq(lEsq);
            List<SimboloString> lDir = rp.getSimbLDireito();
            for(i = 0; i < lDir.size(); i++) {
                SimboloString s = lDir.get(i);
                try { lDir.set(i, mapa2ss.get(Integer.parseInt(s.getNome()))); } 
                catch (Exception ex) {}
            }
        }
        
        ret.setRegrasProducao(new LinkedHashSet(rps));
        
        return ret;
    }
}