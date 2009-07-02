package br.uem.din.yandre.sctmf.model.services.transformacoes;

import br.uem.din.yandre.sctmf.model.pojo.AFD;
import br.uem.din.yandre.sctmf.model.pojo.AFND;
import br.uem.din.yandre.sctmf.model.pojo.Estado;
import br.uem.din.yandre.sctmf.model.pojo.EstadoComparavel;
import br.uem.din.yandre.sctmf.model.pojo.ModeloFormal;
import br.uem.din.yandre.sctmf.model.pojo.Simbolo;
import br.uem.din.yandre.sctmf.model.pojo.SimboloComparavel;
import br.uem.din.yandre.sctmf.model.pojo.Transicao;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 * @author Fabio Schnaider Bortolotto
 */
public class AFND2AFD implements ListIterator, Transformacao {
    AFND src;
    AFD dst = new AFD();
    TreeMap<SimboloComparavel,TreeMap<EstadoComparavel,Set<Estado>>> transicoes;
    List<Transicao> elementos = new ArrayList();
    int elemAtual = -1;
    List<Set<Estado>> filaEstadosAtuais = new ArrayList();
    Iterator<SimboloComparavel> iterTransicoes;
//    List<Iterator<Simbolo>> pilhaTransicoes = new ArrayList<Iterator<Simbolo>>();
    
    
    public AFND2AFD() { }
    
    public AFD getDest() { return dst; }
    
    private boolean temEstadoFinal(Set<Estado> estados) {
        Set<Estado> finais = src.getEstadosFinais();
        for (Estado est : estados) { 
            if (finais.contains(est)) { return true; }
        }
        return false;
    }
    
    @Override
    public boolean hasNext() {
        return (filaEstadosAtuais.size() > 0) || (elemAtual < (elementos.size()-1));
    }
    
    private void genNext() {
        boolean adiciono;
        while (filaEstadosAtuais.size() > 0) {
            Set<Estado> estadosAtuais = filaEstadosAtuais.get(0);
            Estado e = new Estado(AutomatoUtil.concatNomes(estadosAtuais));
            if (dst.getEstados().add(e)) { 
                iterTransicoes = transicoes.keySet().iterator();
                if (temEstadoFinal(estadosAtuais)) dst.addEstadoFinal(e);
            }
            
            Simbolo s = iterTransicoes.next();
            TreeMap<EstadoComparavel, Set<Estado>> srcDst = transicoes.get(s);
            Set<Estado> proxEst = new LinkedHashSet<Estado>();
            boolean ehFinal = false;
            for (Estado est : estadosAtuais) {
                if (!srcDst.containsKey(est))  continue;
                Set<Estado> estSet = srcDst.get(est);
                ehFinal = ehFinal || temEstadoFinal(estSet);
                proxEst.addAll(estSet);
            }
            
            String estDestNome = AutomatoUtil.concatNomes(proxEst);
            adiciono = false;
            if (!estDestNome.isEmpty()) {
                Estado eDest = new Estado(estDestNome);
                if (dst.getEstados().add(eDest) && ehFinal)
                    dst.addEstadoFinal(eDest);
                Transicao t = new Transicao(e,s,eDest);
                adiciono = dst.getTransicoes().add(t);
                if (adiciono) {
                    filaEstadosAtuais.add(proxEst);
                    elementos.add(t);
                }
            }
            
            if (!iterTransicoes.hasNext()) {
                filaEstadosAtuais.remove(0);
                iterTransicoes = transicoes.keySet().iterator();
            }
            
            if (adiciono) return;
        }
    }
    
    @Override
    public Transicao next() {
        elemAtual++;
        if (elemAtual == (elementos.size()-1)) { 
            genNext();
        }
        return elementos.get(elemAtual); 
    }
    
    @Override
    public boolean hasPrevious() {
        return elemAtual > 0;
    }
    
    @Override
    public Object previous() {
        elemAtual--;
        return elementos.get(elemAtual);
    }
    
    @Override
    public int nextIndex() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public int previousIndex() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public void remove() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public void set(Object e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public void add(Object e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public AFD transformar() throws Exception {
        while (hasNext()) next();
        return getDest();
    }

    @Override
    public void setModeloFormalOrigem(ModeloFormal mf) {
        src = (AFND) mf;
        
        transicoes = AutomatoUtil.getMapTrasicao(src);
                
        filaEstadosAtuais.add(src.getEstadosIniciais());
        for (Simbolo s : src.getSimbolos()) dst.addSimbolo(s);
        String nomeEst = AutomatoUtil.concatNomes(src.getEstadosIniciais());
        dst.setEstadoInicial(new Estado(nomeEst));
        genNext();
   }
}