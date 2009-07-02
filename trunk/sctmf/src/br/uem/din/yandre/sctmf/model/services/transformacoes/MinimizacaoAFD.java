package br.uem.din.yandre.sctmf.model.services.transformacoes;

import br.uem.din.yandre.sctmf.model.pojo.AFD;
import br.uem.din.yandre.sctmf.model.pojo.Estado;
import br.uem.din.yandre.sctmf.model.pojo.EstadoComparavel;
import br.uem.din.yandre.sctmf.model.pojo.ModeloFormal;
import br.uem.din.yandre.sctmf.model.pojo.SimboloComparavel;
import br.uem.din.yandre.sctmf.model.pojo.Transicao;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.HashSet;

/**
 *
 * @author Fabio Schnaider Bortolotto
 */
public class MinimizacaoAFD implements Transformacao {
    private Set<HashSet<Estado>> naoEquivalencias;
    private Map<HashSet<Estado>, List<HashSet<Estado>>> dependencias;
    private AFD src;
    
    public MinimizacaoAFD () { }
    
    @Override
    public AFD transformar() throws Exception {
        AFD ret = new AFD();
        Set<Estado> acessiveis = gerarAcessiveis();
        if (!acessiveis.containsAll(src.getEstados()))
            throw new Exception("Existe ao menos 1 estado inacessivel!");
        
        naoEquivalencias = gerarNaoEquivalenciasTriviais();
        
        dependencias = new HashMap<HashSet<Estado>, List<HashSet<Estado>>>();
        Object[] estados = src.getEstados().toArray();
        TreeMap<SimboloComparavel,TreeMap<EstadoComparavel,Set<Estado>>> mapT;
        mapT = AutomatoUtil.getMapTrasicao(src);
        for (int i = 0; i < estados.length; i++) {
            for (int j = i+1; j< estados.length; j++) {
                HashSet<Estado> d = new HashSet<Estado>();
                d.add((Estado)estados[i]); d.add((Estado)estados[j]);
                if (naoEquivalencias.contains(d)) { 
                    continue; 
                }
                
                for (TreeMap<EstadoComparavel,Set<Estado>> t : mapT.values()) {
                    EstadoComparavel ec1 = new EstadoComparavel((Estado)estados[i]);
                    EstadoComparavel ec2 = new EstadoComparavel((Estado)estados[j]);
                    boolean containI = t.containsKey(ec1);
                    boolean containJ = t.containsKey(ec2);
                    if (containI ^ containJ) {
                        naoEquivalencias.add(d);
                        dependencias.remove(d);
                        break;
                    }
                    
                    if ((!containI) && (!containJ)) continue;
                    
                    HashSet<Estado> des = new HashSet<Estado>();
                    des.add(t.get(ec1).iterator().next());
                    des.add(t.get(ec2).iterator().next());
                    
                    if (naoEquivalencias.contains(des)) {
                        naoEquivalencias.add(d);
                        dependencias.remove(d);
                        break;
                    }
                    
                    List<HashSet<Estado>> l = dependencias.get(d);
                    if (l == null) {
                        l = new ArrayList<HashSet<Estado>>();
                        dependencias.put(d, l);
                    }
                    l.add(des);
                }
            }
        }
        
        resolverDependencias();
        
        src.getEstadoInicial();
        List<Set<Estado>> estadosMin = new ArrayList<Set<Estado>>();
        estadosMin.addAll(dependencias.keySet());
        for(int i = 0; i < estadosMin.size(); i++) {
            Set<Estado> s = estadosMin.get(i);
            for(int j = i+1; j < estadosMin.size(); j++) {
                Set<Estado> s1 = estadosMin.get(j);
                for (Estado e : s) if (s1.contains(e)) {
                    s.addAll(s1); estadosMin.remove(j);
                    i--; j = estadosMin.size(); break;
                }
            }
        }
        
        for (Set<Estado> s : estadosMin) 
            ret.addEstado(new Estado(AutomatoUtil.concatNomes(s)));
        
        for (Object e : estados) {
            boolean fundido = false;
            for (Set<Estado> s : estadosMin) if (s.contains(e)) {
                fundido = true; break;
            }
            if (!fundido) ret.addEstado((Estado)e);
        }
        
        boolean eiFundido = false; Estado ei = src.getEstadoInicial();
        for (Set<Estado> s : estadosMin) {
            if (s.contains(ei)) {
                eiFundido = true; 
                ret.setEstadoInicial(new Estado(AutomatoUtil.concatNomes(s)));
                break;
            }
        }
        if (!eiFundido) ret.setEstadoInicial(ei);
        
        Set<Estado> ef = src.getEstadosFinais();
        for (Estado e : ef) {
            boolean efFundido = false;
            for (Set<Estado> s : estadosMin) {
                if (s.contains(e)) {
                    efFundido = true; 
                    ret.addEstadoFinal(new Estado(AutomatoUtil.concatNomes(s)));
                    break;
                }
            }
            if (!efFundido) { ret.addEstadoFinal(e); }
        }
        
        ret.addAllSimbolos(src.getSimbolos());
        
        // adicionar as transicoes
        for (Transicao t : src.getTransicoes()) {
            Transicao novaT = new Transicao();
            novaT.setSimbolo(t.getSimbolo());
            
            boolean oriFundido = false, destFundido = false;
            for (Set<Estado> s : estadosMin) {
                if (s.contains(t.getEstOri())) {
                    oriFundido = true;
                    novaT.setEstOri(new Estado(AutomatoUtil.concatNomes(s)));
                    if (destFundido) break;
                }
                if (s.contains(t.getEstDest())) {
                    destFundido = true;
                    novaT.setEstDest(new Estado(AutomatoUtil.concatNomes(s)));
                    if (oriFundido) break;
                }
            }
            if (!oriFundido) novaT.setEstOri(t.getEstOri());
            if (!destFundido) novaT.setEstDest(t.getEstDest());
            
            ret.addTransicao(novaT);
        }
        
        return ret;
    }
    
    private boolean resolverDependencia(HashSet<Estado> des, List<HashSet<Estado>> caminho) {
        if (naoEquivalencias.contains(des)) return false;
        List<HashSet<Estado>> l = dependencias.get(des);
        if (caminho.contains(des) || l == null) return true;
        
        boolean ret = true;
        for (HashSet<Estado> deps : l) {
            ArrayList<HashSet<Estado>> c = new ArrayList<HashSet<Estado>>(caminho);
            c.add(des);
            if (!resolverDependencia(deps, c)) {
                naoEquivalencias.add(des);
                ret = false;
                break;
            }
        }
        
        return ret;
    }
    
    private void resolverDependencias() {
        int lastSize;
        do {
            lastSize = dependencias.size();
            Iterator<HashSet<Estado>> it = dependencias.keySet().iterator();
            while ( it.hasNext() ) {
                HashSet<Estado> d = it.next();
                if (!resolverDependencia(d, new ArrayList<HashSet<Estado>>()))
                    it.remove();
            }
        } while(lastSize != dependencias.size());
    }
    
    private void populateAcessiveis(Set<Estado> acessiveis, Set<Transicao> trans, Estado origem) {
        acessiveis.add(origem);
        for (Transicao t : trans) {
            Estado o = t.getEstOri(); Estado d = t.getEstDest();
            if (o.equals(origem) && acessiveis.add(d))
                populateAcessiveis(acessiveis, trans, d);
        }
    }
    
    private Set<Estado> gerarAcessiveis() {
        Set<Estado> acessiveis = new HashSet<Estado>();
        
        populateAcessiveis(acessiveis, src.getTransicoes(), src.getEstadoInicial());
        
        return acessiveis;
    }
    
    private Set<HashSet<Estado>> gerarNaoEquivalenciasTriviais() {
        Set<HashSet<Estado>> ret = new HashSet<HashSet<Estado>>();
        
        Set<Estado> finais = src.getEstadosFinais();
        Set<Estado> estados = new HashSet<Estado>(src.getEstados());
        estados.removeAll(finais);
        for (Iterator<Estado> it = estados.iterator(); it.hasNext(); ) {
            Estado e = it.next();
            for (Iterator<Estado> itf = finais.iterator(); itf.hasNext(); ) {
                HashSet<Estado> s = new HashSet();
                s.add(e); s.add(itf.next()); 
                ret.add(s);
            }
        }
        
        return ret;
    }

    @Override
    public void setModeloFormalOrigem(ModeloFormal mf) {
        src = (AFD) mf;
    }
}