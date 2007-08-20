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
import cassolato.rafael.sctmf.model.pojo.GLC;
import cassolato.rafael.sctmf.model.pojo.ModeloFormal;
import cassolato.rafael.sctmf.model.pojo.RegraProducao;
import cassolato.rafael.sctmf.model.pojo.Simbolo;
import cassolato.rafael.sctmf.model.pojo.Transicao;
import cassolato.rafael.sctmf.model.pojo.TransicaoAP;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
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
        
        else if(mf instanceof GLC )
            status = this.valida((GLC)mf, sequencia);
        
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
            // verifica se o, é do alfabeto da linguagem
            boolean status = false;
            for(Simbolo s : ap.getSimbolos())
                if(s.getNome().charValue()==sS) {
                status = true;
                break;
                }
            
            if(!status) return false;
            
            for(TransicaoAP tAP : transicoes) {
                // verifica o simbolo
                if(sS==tAP.getSimbolo().getNome().charValue()&&
                        // estado de origem
                        estadoAtual.getNome().equals(tAP.getEstOri().getNome())){
                    
                    // Se a pilha estiver vazia, procura uma transicao
                    // para alterar o estado, caso nao encontre, return false
                    if(pilha.empty()) {
                        label : {
                            for(TransicaoAP t : transicoes)
                                if(t.getSimBasePilha().getNome().charValue()=='\u03BB') {
                                // Faz a alteração na pilha
                                this.alterarPilha(pilha, estadoAtual, t);
                                break label;
                                }
                            
                            return false; // caso nao encontre a transicao
                        }
                        break;
                        
                        // verifica a pilha
                    } else if(pilha.peek().getNome().equals(
                            tAP.getSimBasePilha().getNome())) {
                        // Faz a alteração na pilha
                        this.alterarPilha(pilha, estadoAtual, tAP);
                        break;
                    }
                }
            }
        }
        
        // se a pilha ja esta vazia, e a sequencia terminou, é retornado true
        if(pilha.empty())
            return true;
        
        else {
            // Quando os simbolos da sequencia sao finalizados e a pilha
            // ainda contem simbolos, é verificado se existem transicoes
            // que contenham o lambinda como simbolo do alfabeto
            // e tenta-se aplicar a regra de producao.
            boolean status;
            do {
                label : {
                    for(TransicaoAP t : ap.getTransicoesAP()) {
                        if((t.getSimbolo().getNome().charValue()=='\u03BB')&&
                                (estadoAtual.getNome().equals(t.getEstOri().getNome()))&&
                                (t.getSimBasePilha().getNome().equals(
                                pilha.peek().getNome()))){
                            
                            // Faz a alteração na pilha
                            this.alterarPilha(pilha, estadoAtual, t);
                            
                            if(pilha.empty()) return true;
                            status = true;
                            break label;
                        }
                    }
                    
                    status = false; // seta o status para sair do while
                }// final break label;
            }while(status);
            
        }// fim do else
        
        return false;
        
    }
    
    /**
     * Valida a Gramática Livre de Contexto<br>
     * Algoritmo de CYK.
     *
     * @param glc - Gramática Livre de Contexto
     * @param sequencia - Sequencia a ser Validada.
     * @return boolean
     */
    private boolean valida(GLC glc, String sequencia) {
        final int tamSeq = sequencia.length();
        
        // cria a tabela 
        Set[][] tabela = new Set[tamSeq+1][tamSeq+1];
        
        // regride os nao terminais nos seus terminais
        for(int i=0;i<sequencia.length();i++) {
            char c = sequencia.charAt(i);
            for(RegraProducao rp : glc.getRegrasProducao()) {
                List<Simbolo> simbs = rp.getSimbLDireito();
                // busca as regras de producao com terminais no lado direito
                if(simbs.size()==1&&simbs.get(0).getNome()==c) {
                    Set<Simbolo> lista = new HashSet<Simbolo>();
                    lista.add(rp.getSimbLEsq());
                    tabela[0][i] = lista;
                    break;
                }
            }
            // caso nao exista uma producao para o simbolo da sequencia
            if(tabela[0][i]==null) return false;            
        }
        
        for(int j=2;j<=tamSeq;j++) // Cantos da piramede....
         for(int i=0;i<=tamSeq-j;i++) {// Vertical da pirâmede
	    System.out.println("\nPosicao ["+j+","+i+"]");        
            // Posicao[j,i] -> (a,b);(c,d)	    
            int a = j-1, b = i, c = 0, d = j-1+i;

	    for(int k=a;k>0;k--) {// percorre as linhas          
                System.out.println("("+k+","+b+");("+(++c)+","+(d-c+1)+")"); 
               
                // posicao mais a esquerda
                Set<Simbolo> simb1 = tabela[k][b]; 
                // posicao mais a direita
                Set<Simbolo> simb2 = tabela[++c][d-(c+1)]; 
                
                if(simb1!=null&&simb2!=null)
                    for(Simbolo x : simb1)
                            for(Simbolo y : simb2) {
                                // valores encontrados
                                String valFounds = ""+x.getNome()+y.getNome();
                                // Verifica se existe alguma producao 
                                // com esses simbolos encontrados
                                for(RegraProducao rp : glc.getRegrasProducao()) {
                                    String valRP = "";
                                    for(Simbolo s : rp.getSimbLDireito())
                                        valRP += s.getNome();
                                        
                                    if(valFounds.equals(valRP)) {
                                        // se a List da posicao estiver nula
                                        // cria e add
                                        Set pos = tabela[j][i];
                                        if(pos==null)
                                            pos = new HashSet<Simbolo>();
                                        
                                        pos.add(rp.getSimbLEsq());
                                    }    
                                        
                                }
                                
                            }                                                   

               
            } // for das linhas
            
            System.out.println();
                
         }
        
        return false;        
    }
    
    /**
     * Faz a alteração na pilha do automato com pilha.
     */
    private void alterarPilha(Stack pilha, Estado ea, TransicaoAP t) {
        // Altera o estado Destino
        ea = t.getEstDest();
        
        // remove o simbolo do topo da pilha
        if(!pilha.empty()) pilha.pop();
        
        int tamPilha = t.getEntradaPilha().size()-1;
        // Add o que esta na entrada da transicao
        for(int i=tamPilha;i>=0;i--) {
            Simbolo s = t.getEntradaPilha().get(i);
            
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