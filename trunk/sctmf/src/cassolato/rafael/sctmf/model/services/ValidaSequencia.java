/*
 * ValidaSequencia.java
 *
 * Created on 10 de Maio de 2007, 09:50
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package cassolato.rafael.sctmf.model.services;

import cassolato.rafael.sctmf.model.pojo.AFD;
import cassolato.rafael.sctmf.model.pojo.AFND;
import cassolato.rafael.sctmf.model.pojo.AP;
import cassolato.rafael.sctmf.model.pojo.Estado;
import cassolato.rafael.sctmf.model.pojo.ModeloFormal;
import cassolato.rafael.sctmf.model.pojo.Simbolo;
import cassolato.rafael.sctmf.model.pojo.Transicao;
import cassolato.rafael.sctmf.model.pojo.TransicaoAP;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Stack;



/**
 *
 * @author rafael2009_00
 */
public class ValidaSequencia implements Validacao {
    
    private static ValidaSequencia singleton;
    
    /** Creates a new instance of ValidaSequencia */
    private ValidaSequencia() {
    }
    
    public void valida(ModeloFormal mf, String sequencia) {
        boolean status = false;
        
        if(mf instanceof AP)
            status = this.valida((AP)mf, sequencia);
        
        else if(mf instanceof AFD )
            status = this.valida((AFD)mf, sequencia);
        
        else if(mf instanceof AFND )
            status = this.valida((AFND)mf, sequencia);               
        
        this.sendMessage(status);
    }
    
    /**
     * Metodo que faz a validação de uma sequencia.
     *
     * @param afd - Automato finito deterministico
     * @param sequencia - Sequencia digitada pelo usuário
     *
     * @return boolean;
     */
    private boolean valida(AFD afd, String sequencia) {
        // Estado Inicial
        Estado estadoAtual = afd.getEstadoInicial();
        
        for(char c : sequencia.toCharArray())  {
            label : {
                for(Transicao t : afd.getTransicoes()) {
                    Estado e = t.getEstOri();
                    Simbolo s = t.getSimbolo();
                    if(estadoAtual.getNome().equals(e.getNome())
                    &&c==(s.getNome())) {
                        
                        estadoAtual = t.getEstDest();
                        break label;
                    }
                }
                
                // caso nao exista nenhuma transicao que o leve ao proximo estado
                return false;
            }
            
        }
        
        // Verifica se o Estado atual Ã© algum
        // Dos estados finais
        for(Estado x : afd.getEstadosFinais())
            if(estadoAtual.getNome().equals(x.getNome()))
                return true;
        
        return false;
        
    }
    
    /**
     * Valida o Autômato Finito Não Determinístico.
     *
     * @param afnd - Autômato Finito Não Determinístico.
     * @param sequencia - Sequencia a ser Validada.
     * @return boolean
     */
    private boolean valida(AFND afnd, String sequencia) {
        // Estados que podem estar ativo no AFND
        Map<String, Estado> estadosAtivos = new HashMap<String, Estado>();
        // Estados ativos - Var Auxiliar
        Map<String, Estado> auxEA = new HashMap<String, Estado>();
        
        // Preeche os estados ativos com os estados iniciais.
        for(Estado e : afnd.getEstadosIniciais())
            estadosAtivos.put(e.getNome(), e);
        
        // Percorre a sequencia
        for(char c : sequencia.toCharArray()) {
            // Percorre as transicoes
            for(Transicao t : afnd.getTransicoes()) {
                Estado e = t.getEstOri();
                Simbolo s = t.getSimbolo();
                
                Estado aux = estadosAtivos.get(e.getNome());
                // Verifica se existe uma transicao cadastrada
                // que ativa um estado novo
                if(aux!=null&&c==s.getNome().charValue()) {
                    Estado ed = t.getEstDest();
                    auxEA.put(ed.getNome(), ed);
                }
                
            }
            
            if(auxEA.size()==0)  // retorna falso caso nao existe uma transicao
                return false;    // que leve um determinado estado a outro
            
            // Atribui o clone do objeto auxEA para os estados ativos
            // e limpa o auxEA
            try {
                estadosAtivos = (Map) auxEA.getClass().
                        getMethod("clone").invoke(auxEA);
                auxEA.clear();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            
        }
        
        // Vefirica se existe algum estado ativo
        // contem dentro dos estados finais.
        for(Estado ef : afnd.getEstadosFinais())
            if(estadosAtivos.containsKey(ef.getNome()))
                return true;
        
        return false;
    }
    
    /**
     * Valida o Autômato com Pilha
     *
     * @param ap - Autômato com Pilha
     * @param sequencia - Sequencia a ser Validada.
     * @return boolean
     */
    private boolean valida(AP ap, String sequencia) {
        // Pilha do Automato
        final Stack<Simbolo> pilha = new Stack<Simbolo>();
        
        // Estado Inicial
        Estado estadoAtual = ap.getEstadoInicial();        
        // Transicoes Cadastradas
        Set<TransicaoAP> transicoes = ap.getTransicoesAP();
        
        // Add o simbolo cadastrado no topo da pilha, na pilha do automato
        pilha.push(ap.getTopoPilha());
        
        for(char sS : sequencia.toCharArray()) {
            for(TransicaoAP tAP : transicoes) {
                   // verifica o simbolo
                if(sS==tAP.getSimbolo().getNome().charValue()&& 
                   // estado de origem
                   estadoAtual.getNome().equals(tAP.getEstOri().getNome())&&
                   // Base da pilha
                   pilha.peek().getNome().equals(
                        tAP.getSimBasePilha().getNome()) ) {
                    
                   estadoAtual = tAP.getEstDest();            
                   // remove o simbolo do topo da pilha                     
                   pilha.pop();
                   
                   int tamPilha = tAP.getEntradaPilha().size()-1;
                    // Add o que esta na entrada da transicao   
                   for(int i=tamPilha;i>=0;i--) {
                       Simbolo s = tAP.getEntradaPilha().get(i);
                       
                       // se nao for igual a lambida
                       if(s.getNome().charValue()=='\u03BB') {
                           // Remove novamente somente se o simbolo ja foi 
                           // removido uma vez, ou seja.. caso para entrada da
                           // pilha.. AlambidaB
                           if(i!=tamPilha)
                            pilha.pop();
                           
                       }else
                           pilha.push(s);
                   }
                                           
                    break;
                }
            }
        }
        
        // se a pilha ja esta vazia, e a sequencia terminou, é retornado true        
        if(pilha.size()==0) return true;
        
        // Quando os simbolos da sequencia sao finalizados e a pilha 
        // ainda contem simbolos, é verificado se existem transicoes 
        // que contenham o lambinda como simbolo do alfabeto
        // e tenta-se aplicar a regra de producao.        
        for(TransicaoAP t : ap.getTransicoesAP()) {
            // procura os simbolos lambida
            if(t.getSimbolo().getNome().charValue()=='\u03BB'&&
               // verifica se existe um estado de origem igual ao estado atual
               estadoAtual.getNome().equals(t.getEstOri())&& 
               // Base da pilha
               pilha.peek().getNome().equals(
                    t.getSimBasePilha().getNome())) {
                
                   estadoAtual = t.getEstDest();            
                   // remove o simbolo do topo da pilha                     
                   pilha.pop();
                   
                   int tamPilha = t.getEntradaPilha().size()-1;
                    // Add o que esta na entrada da transicao   
                   for(int i=tamPilha;i>=0;i--) {
                       Simbolo s = t.getEntradaPilha().get(i);
                       
                       // se nao for igual a lambida
                       if(s.getNome().charValue()=='\u03BB') {                         
                           if(i!=tamPilha)
                             pilha.pop();
                           
                       }else
                           pilha.push(s);
                   }
                                           
                   break;
            }
        }
        
        return (pilha.size()==0)?true:false;     
        
    }
    
    private void sendMessage(boolean isOK) {
        if(isOK)
            javax.swing.JOptionPane.showMessageDialog(null,
                    "Seqüência ACEITA", "!! OK !!",
                    javax.swing.JOptionPane.INFORMATION_MESSAGE);
        else
            javax.swing.JOptionPane.showMessageDialog(null,
                    "Seqüência REJEITADA", "!! Atenção !!",
                    javax.swing.JOptionPane.WARNING_MESSAGE);
        
    }
    
    public static ValidaSequencia getInstance() {
        return singleton;
    }
    
    static {
        singleton =
                new ValidaSequencia();
    }
    
}