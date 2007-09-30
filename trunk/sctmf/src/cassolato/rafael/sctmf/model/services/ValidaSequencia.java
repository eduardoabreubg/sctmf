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
import cassolato.rafael.sctmf.model.pojo.AFMV;
import cassolato.rafael.sctmf.model.pojo.AFND;
import cassolato.rafael.sctmf.model.pojo.AP;
import cassolato.rafael.sctmf.model.pojo.Direcao;
import cassolato.rafael.sctmf.model.pojo.ER;
import cassolato.rafael.sctmf.model.pojo.Estado;
import cassolato.rafael.sctmf.model.pojo.GLC;
import cassolato.rafael.sctmf.model.pojo.MT;
import cassolato.rafael.sctmf.model.pojo.ModeloFormal;
import cassolato.rafael.sctmf.model.pojo.RegraProducao;
import cassolato.rafael.sctmf.model.pojo.Simbolo;
import cassolato.rafael.sctmf.model.pojo.Transicao;
import cassolato.rafael.sctmf.model.pojo.TransicaoAP;
import cassolato.rafael.sctmf.model.pojo.TransicaoMT;
import java.util.ArrayList;
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
        
        else if(mf instanceof AFMV)
            status = this.valida((AFMV)mf, sequencia);
        
        else if(mf instanceof AFND)
            status = this.valida((AFND)mf, sequencia);
                
        else if(mf instanceof AFD)
            status = this.valida((AFD)mf, sequencia);
                
        else if(mf instanceof ER)
            status = this.valida((ER)mf, sequencia);
        
        else if(mf instanceof GLC )
            status = this.valida((GLC)mf, sequencia);
        
        else if(mf instanceof MT)
            status = this.valida((MT)mf, sequencia);
        
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
     * Valida a expressao regular
     *
     * @param afmv - Automato Finito de Movimentos Vazios
     * @param sequencia - Sequencia a ser Validada.
     * @return boolean
     */
    private boolean valida(AFMV afmv, String sequencia) {
        // Estados que podem estar ativos no AFMV
        Map<String, Estado> estadosAtivos = new HashMap<String, Estado>();
        // Estados ativos - Var Auxiliar
        Map<String, Estado> auxEA = new HashMap<String, Estado>();
        
        // Preeche o estado ativo
        Estado est = afmv.getEstadoInicial();
        estadosAtivos.put(est.getNome(), est);
        
        // caso no inicio ja exista transicoes que contenham lambida
        for(Transicao tt : afmv.getTransicoes()) 
            if(estadosAtivos.containsKey(tt.getEstOri().getNome())&&
               tt.getSimbolo().getNome()=='\u03BB') {                        
               Estado e = tt.getEstDest();                
               estadosAtivos.put(e.getNome(),e);
            }
                
        // Percorre a sequencia
        for(char c : sequencia.toCharArray()) {
            // Percorre as transicoes
            for(Transicao t : afmv.getTransicoes()) {
                Estado e = t.getEstOri();
                Simbolo s = t.getSimbolo();
                
                Estado aux = estadosAtivos.get(e.getNome());
                char nSim = s.getNome();
                // Verifica se existe uma transicao cadastrada
                // que ativa um estado novo
                if(aux!=null&&(nSim=='\u03BB'||c==nSim)) {
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
        
        // Verifica o caso do lambida para o fim da sequencia
        for(Transicao tt : afmv.getTransicoes()) 
            if(estadosAtivos.containsKey(tt.getEstOri().getNome())&&
               tt.getSimbolo().getNome()=='\u03BB') {                        
               Estado e = tt.getEstDest();                
               estadosAtivos.put(e.getNome(),e);
            }
        
        // Vefirica se existe algum estado ativo
        // contem dentro dos estados finais.
        for(Estado ef : afmv.getEstadosFinais())
            if(estadosAtivos.containsKey(ef.getNome()))
                return true;
               
        return false;
    }
    
    /**
     * Valida a expressao regular
     *
     * @param er - Expressao Regular
     * @param sequencia - Sequencia a ser Validada.
     * @return boolean
     */ 
    private boolean valida(ER er, String sequencia) {                
        final String expressaoRegular = er.getExpressaoRegular();
        if(expressaoRegular.length()==0||sequencia.length()==0) return false;
        
        final ConversoesERparaAFMV serviceClass = new ConversoesERparaAFMV();
        
        // cria os AFMV inicialmente para cada um dos
        // simbolos distintos do alfabeto.
        final List<AFMV> list = new ArrayList<AFMV>();
        for(char c : expressaoRegular.toCharArray())             
            if(Character.isLetter(c)) {
                final AFMV afmv = new AFMV();
                
                if(serviceClass.existeAFMV(list,c)) {
                    final Estado eOrig = serviceClass.getNewEstado();
                    final Estado eDest = serviceClass.getNewEstado();                
                    afmv.addTransicao(new Transicao(eOrig, new Simbolo(c), eDest));

                    afmv.setEstadoInicial(eOrig);
                    afmv.addEstadoFinal(eDest);

                    list.add(afmv);
                }
           }      
           
        AFMV afmv = null;  // AFMV que sera retornado
        String str = serviceClass.new UtilsER()
                .getExpressaoPosFixa(expressaoRegular);  
        
        final Stack<AFMV> pilha = new Stack<AFMV>();
        for(char c : str.toCharArray()) {
            if(Character.isLetter(c))
                pilha.push(serviceClass.getAFMV(list, c));
            
            else {
                AFMV a1 = null;
                if(!Character.isDigit(c))
                   a1 = pilha.pop();
                            
                switch (c) {
                    case '*' : 
                        pilha.push(serviceClass.processaFechoKleene(a1));
                        
                        break;                        
                    case '+' : 
                        pilha.push(
                                serviceClass.processaUniao(a1,
                                                           pilha.pop()));
                        
                        break;
                    case '|' :
                         pilha.push(
                                serviceClass.processaContatenacao(pilha.pop(),
                                                                  a1));
                        break;                        
                }
            }            
        }
        
        afmv = pilha.pop();      
        
        for(Transicao t : afmv.getTransicoes())    
            System.out.println(t.getEstOri().getNome()+","+
                               t.getSimbolo().getNome()+"->"+
                               t.getEstDest().getNome());
        
        System.out.println("Estado Inicial: "+afmv.getEstadoInicial().getNome());
        System.out.println("Estado Final: "+afmv.getEstadosFinais().iterator().next().getNome());
        
        return this.valida(afmv,sequencia);
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
            boolean status = false;
            do {
                for(TransicaoAP t : ap.getTransicoesAP()) 
                    if((t.getSimbolo().getNome().charValue()=='\u03BB')&&
                            (estadoAtual.getNome().equals(t.getEstOri().getNome()))&&
                            (t.getSimBasePilha().getNome().equals(
                            pilha.peek().getNome()))){

                        // Faz a alteração na pilha
                        this.alterarPilha(pilha, estadoAtual, t);

                        if(pilha.empty()) return true;
                        status = true;
                        break;
                        
                    }else status = false; // seta o status para sair do while
                                                    
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
        // caso nao exista simbolo inicial cadastrado
        if(glc.getSimbInicial()==null) return false;
        
        final int tamSeq = sequencia.length();
        
        // cria a tabela
        Set[][] tabela = new Set[tamSeq+1][tamSeq];
        
        // add a sequencia na posicao 0 da tabela
        for(int i=0;i<sequencia.length();i++) {
            Set s = tabela[0][i];
            if(s==null) s = new HashSet<Simbolo>();
            
            s.add(new Simbolo(sequencia.charAt(i)));
            tabela[0][i] = s;
        }
        
        // regride os nao terminais nos seus terminais
        for(int i=0;i<sequencia.length();i++) {
            Simbolo s = (Simbolo)tabela[0][i].iterator().next();
            char c = s.getNome();
            for(RegraProducao rp : glc.getRegrasProducao()) {
                List<Simbolo> simbs = rp.getSimbLDireito();
                // busca as regras de producao com terminais no lado direito
                if(simbs.size()==1&&simbs.get(0).getNome()==c) {
                    Set<Simbolo> simbolos = tabela[1][i];                    
                    if(simbolos==null)  // inicia a lista
                        simbolos = new HashSet<Simbolo>();
                    
                    simbolos.add(rp.getSimbLEsq());                
                    tabela[1][i] = simbolos;               
                }
            }
            // caso nao exista uma producao para o simbolo da sequencia
            if(tabela[1][i]==null) return false;
        }
        
        for(int j=2;j<=tamSeq;j++) // Cantos da piramede....
            for(int i=0;i<=tamSeq-j;i++) {// Vertical da pirâmede
                // Posicao[j,i] -> (a,b);(c,d)
                int a = j-1, b = i, c = 0, d = j-1+i;

                for(int k=a;k>0;k--) {// percorre as linhas
                    c++;
                    // posicao mais a esquerda
                    Set<Simbolo> simb1 = tabela[k][b];
                    // posicao mais a direita
                    Set<Simbolo> simb2 = tabela[c][(d-c+1)];

                    if(simb1!=null&&simb2!=null)
                        for(Simbolo x : simb1)
                            for(Simbolo y : simb2) {
                                // valores encontrados
                                String valFounds = ""+x.getNome()+y.getNome();
                                // Verifica se existe alguma producao
                                // com esses simbolos encontrados
                                for(RegraProducao rp : glc.getRegrasProducao())
                                    // so compara as produções com simbolos n-terminais
                                    if(rp.getSimbLDireito().size()==2) {
                                        String valRP = "";
                                        for(Simbolo s : rp.getSimbLDireito())
                                            valRP += s.getNome();

                                        if(valFounds.equals(valRP)) {
                                            // se a List da posicao estiver nula
                                            // cria e add
                                            Set pos = tabela[j][i];
                                            if(pos==null) {
                                                pos = new HashSet<Simbolo>();
                                                tabela[j][i] = pos;
                                            }

                                            pos.add(rp.getSimbLEsq());

                                        }
                                    }

                            }

                } // for das linhas                        
            }
        
        // caso o simbolo do topo da piramede esteje null
        Set<Simbolo> topoPiramede = tabela[tabela.length-1][0];
        if(topoPiramede==null)
            return false;
        
        else // Verifica se o simbolo no topo da piramete é o simbolo inicial            
            for(Simbolo s : topoPiramede)
                if(s.getNome()==glc.getSimbInicial().getNome())
                    return true;
        
        return false;
    }
    
    /**
     * Faz o reconhecimento da sequencia digitada pelo usuáro.
     *
     * @param mt - Maquina de Turing
     * @param sequencia - Sequencia a ser reconhecida
     */
    private boolean valida(MT mt, String sequencia) {
        List<Simbolo> fita = new ArrayList<Simbolo>();
        // Coloca os simbolos na fita da maquina
        fita.add(new Simbolo('\u00A4'));
        for(char c : sequencia.toCharArray()) fita.add(new Simbolo(c));                       
        Estado estadoAtual = mt.getEstIni();
        
        int cursor = 0;        
        while(true) {
            label : {
                for(TransicaoMT t : mt.getTransicoes())        
                    if(t.getEstAtual().getNome().equals(estadoAtual.getNome())&&
                       t.getSimLido().getNome().equals(fita.get(cursor).getNome())) {

                       estadoAtual = t.getEstDestino(); // altera o estado
                       fita.set(cursor,t.getSimbEscrito()); // Escreve o simbolo na fita
                       if(t.getDirecao()==Direcao.DIREITA) {
                           cursor++;
                           if(fita.size()==cursor) // add um simbolo em braco                           
                               fita.add(new Simbolo('\u03B2'));
                           
                       }else cursor--; // altera o valor do cursor

                       // caso a fita ja se encontrava na celula mais a esquerda
                       if(cursor<0) return false;                                                   
                                                                   
                       //for(Estado e : mt.getEstFinais())
                        //   if(e.getNome().equals(estadoAtual.getNome()))
                          //     return true; // estado final foi assumido
                       
                      break label;
                    }
                
                for(Estado e : mt.getEstFinais())
                    if(e.getNome().equals(estadoAtual.getNome()))
                        return true; // estado final foi assumido

                return false; // Nenhuma transica foi encontrada
            } // label
        } // while
            
    }
    
    /**
     * Faz a alteração na pilha do automato com pilha.
     */
    private void alterarPilha(Stack pilha, Estado ea, TransicaoAP t) {
        // Altera o estado Destino
        ea.setNome(t.getEstDest().getNome());
        
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
        singleton = new ValidaSequencia();
    }
    
    /**
     * Classe especial para conversao das ER em AFMV
     * possui os tres metodos para conversao.
     *
     * A procedencia é:
     * 1) a*
     * 2) aa
     * 3) a+a
     *
     * OBS:Parentese funciona igual nas expressoes aritimeticas
     */
    private final class ConversoesERparaAFMV {
        private int cEstado = 0;    
        
        /**
         * Processa a sequencia x*
         */
        private final AFMV processaFechoKleene(final AFMV afmv_aux) {
            // caso nao estiver vazio
            final AFMV afmv = new AFMV(); 

            afmv.setEstadoInicial(this.getNewEstado());
            afmv.addEstadoFinal(this.getNewEstado());

            // add transicao direita/esquerda superior
            afmv.addTransicao(new Transicao(afmv_aux.getEstadosFinais()
                                                    .iterator().next(),
                                            new Simbolo('\u03BB'),
                                            afmv_aux.getEstadoInicial()));  

            // add transicao da esquerda
            afmv.addTransicao(new Transicao(afmv.getEstadoInicial(),
                                            new Simbolo('\u03BB'),
                                            afmv_aux.getEstadoInicial()));  

            // add transicao da direita
            afmv.addTransicao(new Transicao(afmv_aux.getEstadosFinais()
                                                    .iterator().next(),
                                            new Simbolo('\u03BB'),
                                            afmv.getEstadosFinais()
                                                     .iterator().next())); 

            // add transicao esquerda/direita inferior
            afmv.addTransicao(new Transicao(afmv.getEstadoInicial(),
                                            new Simbolo('\u03BB'),
                                            afmv.getEstadosFinais()
                                                    .iterator().next()));  
            // add as transicoes
            afmv.addAllTransicoes(afmv_aux.getTransicoes());    
            return afmv;
        }
        
        /**
         * Processa a sequencia xx
         * Simbolo de ligacao
         */
        private final AFMV processaContatenacao(final AFMV afmv_1, 
                                                final AFMV afmv_2 ) {                              
            
            final AFMV afmv = new AFMV();
            // Add o estado inicial do 1 e o estado final do 2
            afmv.setEstadoInicial(afmv_1.getEstadoInicial());
            afmv.addAllEstFinais(afmv_2.getEstadosFinais());
            
            // Add transicao de ligacao
            afmv.addTransicao(new Transicao(
                                afmv_1.getEstadosFinais().iterator().next(),
                                new Simbolo('\u03BB'),
                                afmv_2.getEstadoInicial()));
            
            afmv.addAllTransicoes(afmv_1.getTransicoes());
            afmv.addAllTransicoes(afmv_2.getTransicoes());
            
            return afmv;
        }
        
        /**
         * Processa a sequencia x+x
         */
        private final AFMV processaUniao(final AFMV afmv_1, 
                                         final AFMV afmv_2) {
            final AFMV afmv = new AFMV();
            
            afmv.setEstadoInicial(this.getNewEstado());
            afmv.addEstadoFinal(this.getNewEstado());

            // Add transicao superior esquerda
            afmv.addTransicao(new Transicao(afmv.getEstadoInicial(),
                                            new Simbolo('\u03BB'),
                                            afmv_1.getEstadoInicial()));

            // Add transicao inferior esquerda
            afmv.addTransicao(new Transicao(afmv.getEstadoInicial(),
                                            new Simbolo('\u03BB'),
                                            afmv_2.getEstadoInicial()));  

            // add as transições dos automatos anteriores
            afmv.addAllTransicoes(afmv_1.getTransicoes());
            afmv.addAllTransicoes(afmv_2.getTransicoes());   

            // Add transicao superior direita
            afmv.addTransicao(new Transicao(afmv_1.getEstadosFinais()
                                                    .iterator().next(),
                                            new Simbolo('\u03BB'),
                                            afmv.getEstadosFinais()
                                                    .iterator().next())); 

            // Add transicao inferior direita
            afmv.addTransicao(new Transicao(afmv_2.getEstadosFinais()
                                                    .iterator().next(),
                                            new Simbolo('\u03BB'),
                                            afmv.getEstadosFinais()
                                                    .iterator().next())); 
            
            return afmv;
        }                
        
        /**
         * Recebe o simbolo da transicao e a a lista de AFMVs como parametro, 
         * e retorna o AFMV no qual contem a transicao correspondente.
         */
        private AFMV getAFMV(List<AFMV> values, Character nomeSimbolo) {
            for(AFMV afmv : values)
                for(Transicao t : afmv.getTransicoes())
                    if(t.getSimbolo().getNome()==nomeSimbolo)
                        return afmv;

            return null;
        }
        
        /**
         * Método usado para verificar se já exste um automato finito com
         * movimentos vazio na lista. Metodo usado para tranformacao de uma
         * ER em um AFND.
         */
        private boolean existeAFMV(List<AFMV> values, char nomeSimboloTrans) {
            for(AFMV a : values)
                for(Transicao t : a.getTransicoes())
                    if(t.getSimbolo().getNome()==nomeSimboloTrans)
                        return false;

            return true;
        }
        
        /**
         * Retorna um novo estado
         */
        private Estado getNewEstado() {
            return new Estado("S"+cEstado++);
        }
        
        private class UtilsER {
            final Stack<Character> pilha = new Stack<Character>();

            private final String getExpressaoPosFixa(String expressao) {
                StringBuilder saida = new StringBuilder();
		for(char c : formatExpressao(expressao))     
			if(Character.isLetterOrDigit(c))
				saida.append(c);

			else 
                            if(pilha.empty()) 
				pilha.push(c);

                            else {
                                if(c==41) 
                                    while(true) {
                                        saida.append(pilha.pop());

                                        if(pilha.peek()==40) {
                                            pilha.pop();
                                            break;
					}
                                    }
				else 
                                    if(!pilha.isEmpty()&&c!=40&&
                                        this.getValorOperador(c)<=
					this.getValorOperador(pilha.peek())) 
					
                                        saida.append(pilha.pop());          

                                    if(c!=41) pilha.push(c);        
                            }
			
                // esvazia a pilha
		while(!pilha.empty()) saida.append(pilha.pop());

		return saida.toString();                	      

            }

            private int getValorOperador(char c) {
		switch (c) {
                    case '|': return 0;				
                    case '+': return 1;				
                    case '*': return 2;
                    default: return -1;
		}
            }
	
            private ArrayList<Character> formatExpressao(String expressao) {
		ArrayList<Character> list = new ArrayList<Character>();
		for(char c : expressao.toCharArray()) list.add(c);
		
		for(int i=0;i<list.size();i++) {
                    char c = list.get(i);

                    if(Character.isLetter(c)&&i>0&&Character.isLetterOrDigit(list.get(i-1))) {
                        list.add(i,'|');
                        continue;
                    }

                    if(c=='*') list.add(++i,'1'); // case a*

		}
		
		return list;
            }
            
        } // fim da classe
    
    }     
}