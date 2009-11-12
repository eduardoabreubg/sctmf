/*
 * ValidaSequencia.java
 *
 * Created on 10 de Maio de 2007, 09:50
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package br.uem.din.yandre.sctmf.model.services;

import br.uem.din.yandre.sctmf.model.pojo.AFD;
import br.uem.din.yandre.sctmf.model.pojo.AFMV;
import br.uem.din.yandre.sctmf.model.pojo.AFND;
import br.uem.din.yandre.sctmf.model.pojo.ALL;
import br.uem.din.yandre.sctmf.model.pojo.AP;
import br.uem.din.yandre.sctmf.model.pojo.Direcao;
import br.uem.din.yandre.sctmf.model.pojo.ER;
import br.uem.din.yandre.sctmf.model.pojo.Estado;
import br.uem.din.yandre.sctmf.model.pojo.GLCFNC;
import br.uem.din.yandre.sctmf.model.pojo.MT;
import br.uem.din.yandre.sctmf.model.pojo.Mealy;
import br.uem.din.yandre.sctmf.model.pojo.ModeloFormal;
import br.uem.din.yandre.sctmf.model.pojo.Moore;
import br.uem.din.yandre.sctmf.model.pojo.RegraProducao;
import br.uem.din.yandre.sctmf.model.pojo.Simbolo;
import br.uem.din.yandre.sctmf.model.pojo.SimboloString;
import br.uem.din.yandre.sctmf.model.pojo.Transicao;
import br.uem.din.yandre.sctmf.model.pojo.TransicaoALL;
import br.uem.din.yandre.sctmf.model.pojo.TransicaoAP;
import br.uem.din.yandre.sctmf.model.pojo.TransicaoMT;
import br.uem.din.yandre.sctmf.view.modelos_formais.ling_enum_rec.mt.util.ShowFitaMT;
//import br.uem.din.yandre.sctmf.view.modelos_formais.ling_regul.util.ShowFitaLingRegul;
import br.uem.din.yandre.sctmf.view.modelos_formais.ling_regul.util.ShowFitaLingRegul;
import br.uem.din.yandre.sctmf.view.modelos_formais.ling_sens_cont.all.util.ShowFitaALL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import javax.swing.JOptionPane;

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

        if (mf instanceof AP) {
            status = this.valida((AP) mf, sequencia);
        } else if (mf instanceof AFMV) {
            status = this.valida((AFMV) mf, sequencia);
        } else if (mf instanceof AFND) {
            status = this.valida((AFND) mf, sequencia);
        } else if (mf instanceof AFD) {
            status = this.valida((AFD) mf, sequencia);
        } else if (mf instanceof ER) {
            status = this.valida((ER) mf, sequencia);
        } else if (mf instanceof MT) {
            status = this.valida((MT) mf, sequencia);
        } else if (mf instanceof ALL) {
            status = this.valida((ALL) mf, sequencia);
        } else if (mf instanceof Mealy) {
            status = this.valida((Mealy) mf, sequencia);
        } else if (mf instanceof Moore) {
            status = this.valida((Moore) mf, sequencia);
        }
        this.sendMessage(status);
    }

    public void valida(ModeloFormal mf, List<SimboloString> sequencia) {
        boolean status = false;

        if (mf instanceof GLCFNC) {
            status = this.valida((GLCFNC) mf, sequencia);
        }

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

        for (char c : sequencia.toCharArray()) {
            label:
            {
                for (Transicao t : afd.getTransicoes()) {
                    Estado e = t.getEstOri();
                    Simbolo s = t.getSimbolo();
                    if (estadoAtual.getNome().equals(e.getNome()) && c == (s.getNome())) {

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
        for (Estado x : afd.getEstadosFinais()) {
            if (estadoAtual.getNome().equals(x.getNome())) {
                return true;
            }
        }

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
        for (Estado e : afnd.getEstadosIniciais()) {
            estadosAtivos.put(e.getNome(), e);
        }

        // Percorre a sequencia
        for (char c : sequencia.toCharArray()) {
            // Percorre as transicoes
            for (Transicao t : afnd.getTransicoes()) {
                Estado e = t.getEstOri();
                Simbolo s = t.getSimbolo();

                Estado aux = estadosAtivos.get(e.getNome());
                // Verifica se existe uma transicao cadastrada
                // que ativa um estado novo
                if (aux != null && c == s.getNome().charValue()) {
                    Estado ed = t.getEstDest();
                    auxEA.put(ed.getNome(), ed);
                }

            }

            if (auxEA.size() == 0) // retorna falso caso nao existe uma transicao
            {
                return false;    // que leve um determinado estado a outro
            }
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
        for (Estado ef : afnd.getEstadosFinais()) {
            if (estadosAtivos.containsKey(ef.getNome())) {
                return true;
            }
        }

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
        // Estados que garantiram que os estados ativos continuaram ativos
        Map<String, Estado> auxEANNAtivSeq = new HashMap<String, Estado>();

        // Preeche o estado ativo
        Estado est = afmv.getEstadoInicial();
        estadosAtivos.put(est.getNome(), est);
        auxEANNAtivSeq.put(est.getNome(), est);

        // Percorre a sequencia
        //for(char c : sequencia.toCharArray()) {
        int tamSeq = sequencia.length();
        //for(int i = 0; i<tamSeq; i++) {
        //  char c = sequencia.charAt(i);

        for (char c : sequencia.toCharArray()) {

            estadosAtivos = UtilAFMV.getLambidaCase(estadosAtivos,
                    afmv.getTransicoes(),
                    auxEANNAtivSeq);

            // boolean statusValidador = false;

            /* Map<String, Estado> check = null;
            / try {
            check = (Map) estadosAtivos.getClass().
            getMethod("clone").invoke(auxEA);
            //}catch(Exception ex) {
            ex.printStackTrace();
            }*/

            estadosAtivos = UtilAFMV.getLambidaCase(estadosAtivos,
                    afmv.getTransicoes(),
                    auxEANNAtivSeq);

            //statusValidador = !estadosAtivos.equals(check);

            //if(i==tamSeq-1)  // caso validador
            // statusValidador = false;

            // Percorre as transicoes
            for (Transicao t : afmv.getTransicoes()) {
                Estado e = t.getEstOri();
                Simbolo s = t.getSimbolo();

                Estado aux = estadosAtivos.get(e.getNome());
                char nSim = s.getNome();
                // Verifica se existe uma transicao cadastrada
                // que ativa um estado novo
                if (aux != null && c == nSim) {
                    Estado ed = t.getEstDest();
                    auxEA.put(ed.getNome(), ed);
                    auxEANNAtivSeq.remove(t.getEstOri().getNome());

                    // if(!statusValidador&&i==tamSeq-1) {
                    //     for(Estado ef : afmv.getEstadosFinais())
                    //        if(ef.getNome().equals(ed.getNome()))
                    //             statusValidador = true;
                    // }
                }

            } // fim for...

            // if(!statusValidador)  // indica que o ultimo simbolo da sequencia
            //     return false;     // nao ativou um estadoo final

            if (auxEA.size() == 0) // retorna falso caso nao existe uma transicao
            {
                return false;    // que leve um determinado estado a outro
            }
            // Atribui o clone do objeto auxEA para os estados ativos
            // e limpa o auxEA
            try {
                estadosAtivos.clear();
                estadosAtivos = (Map) auxEA.getClass().
                        getMethod("clone").invoke(auxEA);
                auxEA.clear();
                estadosAtivos.putAll(auxEANNAtivSeq); // garante os estados
                auxEANNAtivSeq.clear();
                auxEANNAtivSeq.putAll(estadosAtivos);

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } // fim for

        // Verifica o caso do lambida para o fim da sequencia
        /*for(Transicao tt : afmv.getTransicoes())
        if(estadosAtivos.containsKey(tt.getEstOri().getNome())&&
        tt.getSimbolo().getNome()=='\u03BB') {
        Estado e = tt.getEstDest();
        estadosAtivos.put(e.getNome(),e);
        }*/

        estadosAtivos = UtilAFMV.getLambidaCase(estadosAtivos,
                afmv.getTransicoes(),
                auxEANNAtivSeq);

        // Vefirica se existe algum estado ativo
        // contem dentro dos estados finais.
        for (Estado ef : afmv.getEstadosFinais()) {
            if (estadosAtivos.containsKey(ef.getNome())) {
                return true;
            }
        }

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
        String expressaoRegular = er.getExpressaoRegular();


        expressaoRegular = expressaoRegular.replace('(', '[');
        expressaoRegular = expressaoRegular.replace(')', ']');
        //System.out.println(expressaoRegular);

        //Pattern expressao = Pattern.compile(expressaoRegular);
        //Matcher testar = expressao.matcher(sequencia);

        if (sequencia.matches(expressaoRegular)) {
            return true;
        } else {
            return false;
        }
        /*if(expressaoRegular.length()==0||sequencia.length()==0) return false;

        final ConversoesERparaAFMV serviceClass = new ConversoesERparaAFMV();

        AFMV afmv = null;  // AFMV que sera retornado
        String str = serviceClass.new UtilsER()
        .getExpressaoPosFixa(expressaoRegular);

        final Stack<AFMV> pilha = new Stack<AFMV>();
        for(char c : str.toCharArray()) {
        if(Character.isLetterOrDigit(c))
        pilha.push(serviceClass.getNewAFMV(c));

        else {
        AFMV a1 = null;
        if(c!='%')
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
        serviceClass.processaContatenacao(
        pilha.pop(),a1));

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

        return this.valida(afmv,sequencia);*/
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

        for (char sS : sequencia.toCharArray()) {
            // verifica se o, é do alfabeto da linguagem
            boolean status = false;
            for (Simbolo s : ap.getSimbolos()) {
                if (s.getNome().charValue() == sS) {
                    status = true;
                    break;
                }
            }

            if (!status) {
                return false;
            }

            for (TransicaoAP tAP : transicoes) {
                // verifica o simbolo
                if (sS == tAP.getSimbolo().getNome().charValue() &&
                        // estado de origem
                        estadoAtual.getNome().equals(tAP.getEstOri().getNome())) {

                    // Se a pilha estiver vazia, procura uma transicao
                    // para alterar o estado, caso nao encontre, return false
                    if (pilha.empty()) {
                        label:
                        {
                            for (TransicaoAP t : transicoes) {
                                if (t.getSimBasePilha().getNome().charValue() == '\u03BB') {
                                    // Faz a alteração na pilha
                                    this.alterarPilha(pilha, estadoAtual, t);
                                    break label;
                                }
                            }

                            return false; // caso nao encontre a transicao
                        }
                        break;

                        // verifica a pilha
                    } else if (pilha.peek().getNome().equals(
                            tAP.getSimBasePilha().getNome())) {
                        // Faz a alteração na pilha
                        this.alterarPilha(pilha, estadoAtual, tAP);
                        break;
                    }
                }
            }
        }

        // se a pilha ja esta vazia, e a sequencia terminou, é retornado true
        if (pilha.empty()) {
            return true;
        } else {
            // Quando os simbolos da sequencia sao finalizados e a pilha
            // ainda contem simbolos, é verificado se existem transicoes
            // que contenham o lambinda como simbolo do alfabeto
            // e tenta-se aplicar a regra de producao.
            boolean status = false;
            do {
                for (TransicaoAP t : ap.getTransicoesAP()) {
                    if ((t.getSimbolo().getNome().charValue() == '\u03BB') &&
                            (estadoAtual.getNome().equals(t.getEstOri().getNome())) &&
                            (t.getSimBasePilha().getNome().equals(
                            pilha.peek().getNome()))) {

                        // Faz a alteração na pilha
                        this.alterarPilha(pilha, estadoAtual, t);

                        if (pilha.empty()) {
                            return true;
                        }
                        status = true;
                        break;

                    } else {
                        status = false; // seta o status para sair do while
                    }
                }
            } while (status);

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
    public boolean valida(GLCFNC glc, List<SimboloString> sequencia) {
        // caso nao exista simbolo inicial cadastrado
        if (glc.getSimbInicial() == null) {
            return false;
        }

        final int tamSeq = sequencia.size();

        // cria a tabela
        Set[][] tabela = new Set[tamSeq + 1][tamSeq];

        // add a sequencia na posicao 0 da tabela
        for (int i = 0; i < sequencia.size(); i++) {
            Set s = tabela[0][i];
            if (s == null) {
                s = new HashSet<SimboloString>();
            }

            s.add(sequencia.get(i));
            tabela[0][i] = s;
        }

        // regride os nao terminais nos seus terminais
        for (int i = 0; i < sequencia.size(); i++) {
            SimboloString s = (SimboloString) tabela[0][i].iterator().next();
            String c = s.getNome();
            for (RegraProducao rp : glc.getRegrasProducao()) {
                List<SimboloString> simbs = rp.getSimbLDireito();
                // busca as regras de producao com terminais no lado direito
                if (simbs.size() == 1 && simbs.get(0).getNome().equals(c)) {
                    Set<SimboloString> simbolos = tabela[1][i];
                    if (simbolos == null) // inicia a lista
                    {
                        simbolos = new HashSet<SimboloString>();
                    }

                    simbolos.add(rp.getSimbLEsq());
                    tabela[1][i] = simbolos;
                }
            }
            // caso nao exista uma producao para o simbolo da sequencia
            if (tabela[1][i] == null) {
                return false;
            }
        }

        for (int j = 2; j <= tamSeq; j++) // Cantos da piramede....
        {
            for (int i = 0; i <= tamSeq - j; i++) {// Vertical da pirâmede
                // Posicao[j,i] -> (a,b);(c,d)
                int a = j - 1, b = i, c = 0, d = j - 1 + i;

                for (int k = a; k > 0; k--) {// percorre as linhas
                    c++;
                    // posicao mais a esquerda
                    Set<SimboloString> simb1 = tabela[k][b];
                    // posicao mais a direita
                    Set<SimboloString> simb2 = tabela[c][(d - c + 1)];

                    if (simb1 != null && simb2 != null) {
                        for (SimboloString x : simb1) {
                            for (SimboloString y : simb2) {
                                // valores encontrados
                                String valFounds = "" + x.getNome() + y.getNome();
                                // Verifica se existe alguma producao
                                // com esses simbolos encontrados
                                for (RegraProducao rp : glc.getRegrasProducao()) // so compara as produções com simbolos n-terminais
                                {
                                    if (rp.getSimbLDireito().size() == 2) {
                                        String valRP = "";
                                        for (SimboloString s : rp.getSimbLDireito()) {
                                            valRP += s.getNome();
                                        }

                                        if (valFounds.equals(valRP)) {
                                            // se a List da posicao estiver nula
                                            // cria e add
                                            Set pos = tabela[j][i];
                                            if (pos == null) {
                                                pos = new HashSet<Simbolo>();
                                                tabela[j][i] = pos;
                                            }

                                            pos.add(rp.getSimbLEsq());

                                        }
                                    }
                                }

                            }
                        }
                    }

                } // for das linhas                        
            }
        }

        // caso o simbolo do topo da piramede esteje null
        Set<SimboloString> topoPiramede = tabela[tabela.length - 1][0];
        if (topoPiramede == null) {
            return false;
        } else // Verifica se o simbolo no topo da piramete é o simbolo inicial
        {
            for (SimboloString s : topoPiramede) {
                if (s.getNome() == glc.getSimbInicial().getNome()) {
                    return true;
                }
            }
        }

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
        List<Copia> sera = new ArrayList<Copia>();

        fita.add(new Simbolo('<'));
        // Coloca os simbolos na fita da maquina
        for (char c : sequencia.toCharArray()) {
            Simbolo s = new Simbolo(c);
            if (mt.getAlfabeto().contains(s)) {
                fita.add(s);
            } else {
                JOptionPane.showMessageDialog(null, "Sua Sequencia contem " +
                        "Simbolo(s) nao pertencente(s) ao Alfabeto", "Atenção",
                        JOptionPane.INFORMATION_MESSAGE);
                return false;
            }
        }
        Estado estadoAtual = mt.getEstIni();
        int cursor = 1;
        //int cursor = (sequencia.length() > 0) ? 1 : 0;
        //adiciona beta na fita se for vazia
        if (sequencia.length() == 0) {
            fita.add(new Simbolo('\u03B2'));
        }

        while (true) {
            label:
            {
                for (TransicaoMT t : mt.getTransicoes()) {
                    if (t.getEstAtual().getNome().equals(estadoAtual.getNome()) && t.getSimLido().getNome().equals(fita.get(cursor).getNome())) {

                        /*BEGIN da verificação de looping make by michelmenega*/
                        Copia c1 = new Copia(cursor, estadoAtual.getNome(), fita.hashCode(), t.hashCode());

//                        System.out.println(c1.getCopiaFita());
//                        System.out.println(c1.getEstAtual());
//                        System.out.println(c1.getCursor());
//                        System.out.println("------------");

                        if (sera.contains(c1)) {
                            //System.out.println("OILA");
                            //System.out.println(sera.toString());
                            JOptionPane.showMessageDialog(null, "MT em Looping", "Atenção",
                                    JOptionPane.INFORMATION_MESSAGE);
                            ShowFitaMT.getInstance().showFitaMT(fita);
                            return false;
                        }

                        sera.add(c1);
                        /*END da verificação de looping make by michelmenega*/

                        estadoAtual = t.getEstDestino(); // altera o estado
                        fita.set(cursor, t.getSimbEscrito()); // Escreve o simbolo na fita
                        if (t.getDirecao() == Direcao.DIREITA) {
                            cursor++;
                            if (fita.size() == cursor) // add um simbolo em branco
                            {
                                fita.add(new Simbolo('\u03B2'));
                            }

                        } else {
                            cursor--; // altera o valor do cursor
                        }

                        //for(Estado e : mt.getEstFinais())
                        //   if(e.getNome().equals(estadoAtual.getNome()))
                        //     return true; // estado final foi assumido

                        break label;
                    }
                }

                for (Estado e : mt.getEstFinais()) {
                    if (e.getNome().equals(estadoAtual.getNome())) {
                        ShowFitaMT.getInstance().showFitaMT(fita);
                        return true; // estado final foi assumido
                    }
                }

                ShowFitaMT.getInstance().showFitaMT(fita);
                return false; // Nenhuma transica foi encontrada
            } // label
        } // while
    }

    /**
     * Faz o reconhecimento da sequencia digitada pelo usuáro.
     *
     * @param ALL - Automato Linearmente Limitado
     * @param sequencia - Sequencia a ser reconhecida
     */
    private boolean valida(ALL all, String sequencia) {
        List<Simbolo> fita = new ArrayList<Simbolo>();
        List<Simbolo> fitaAux = new ArrayList<Simbolo>();
        LinkedList<Copia> salva = new LinkedList<Copia>();
        List<Copia> sera = new ArrayList<Copia>();
        boolean loop = false;
        boolean loop2 = false;


        int cursorAux;
        fita.add(new Simbolo('<'));
        // Coloca os simbolos na fita da maquina

        for (char c : sequencia.toCharArray()) {
            Simbolo s = new Simbolo(c);
            if (all.getAlfabeto().contains(s)) {
                fita.add(s);
            } else {
                JOptionPane.showMessageDialog(null, "Sua Sequencia contem " +
                        "Simbolo(s) nao pertencente(s) ao Alfabeto", "Atenção",
                        JOptionPane.INFORMATION_MESSAGE);
                return false;
            }
        }
        fita.add(new Simbolo('>'));
        Estado estadoAtual = all.getEstIni();
        int cursor = 1;
        //int cursor = (sequencia.length() > 0) ? 1 : 0;

        //salva.addLast(new Copia(cursor, estadoAtual, fita));
        System.out.println(estadoAtual.getNome());
        while (true) {
            label:
            {
                //para cada transiçao no conjunto de transicoes

                for (TransicaoALL transicaoALL : all.getTransicoes()) {

                    //System.out.println(transicaoALL.getEstAtual().getNome() + " " + transicaoALL.getSimLido().getNome() + " " + transicaoALL.getEstDestino().getNome() + " " + transicaoALL.getSimbEscrito().getNome());
                    //se tiver uma transiçao com o estado igual ao estado atual
                    //e o simblido for igual ao da posiçao atual da fita
                    if (transicaoALL.getEstAtual().getNome().equals(estadoAtual.getNome()) && transicaoALL.getSimLido().getNome().equals(fita.get(cursor).getNome())) {
                        //System.out.println("OI");
                        //estadoAtual = transicaoALL.getEstDestino(); // altera o estado
                        //System.out.println(transicaoALL.getEstAtual().getNome());
                        if (all.getEstadosND().contains(transicaoALL.getEstAtual())) {//ele esta no grupo de estados ND?
                            //System.out.println(transicaoALL.getEstAtual().getNome() + "33");

                            for (TransicaoALL tALL : all.getTransicoes()) {

                                if ((tALL.getEstAtual().getNome().equals(transicaoALL.getEstAtual().getNome()) && tALL.getSimLido().getNome().equals(fita.get(cursor).getNome())) && tALL != transicaoALL) {

                                    //System.out.println(tALL.getSimbEscrito().getNome());
                                    try {
                                        fitaAux = (List) fita.getClass().getMethod("clone").invoke(fita);
                                    } catch (Exception ex) {
                                        ex.printStackTrace();
                                    }

                                    cursorAux = cursor;
                                    // Escreve o simbolo na fita
                                    if (tALL.getDirecao() == Direcao.DIREITA) {
                                        cursorAux++;
                                    } else {
                                        cursorAux--;
                                    }
                                    fitaAux.set(cursor, tALL.getSimbEscrito());
                                    salva.addLast(new Copia(cursorAux, tALL.getEstDestino(), fitaAux));
                                    fitaAux.clear();

                                }
                            }
                        }// fim verificacao de nao determinismo
                        Copia c1 = new Copia(cursor, estadoAtual.getNome(), fita.hashCode(), transicaoALL.hashCode());

                        /*System.out.println(c1.getFitaInt());
                        System.out.println(c1.getEstAtualNome());
                        System.out.println(c1.getCursor());
                        System.out.println("------------");*/

                        if (sera.contains(c1)) {
                            //System.out.println("OILA");
                            //System.out.println(sera.toString());
                            loop = true;
                            break;

                        }
                        sera.add(c1);
                        //    System.out.println("NAO determinismo");
                        //}
                        estadoAtual = transicaoALL.getEstDestino();
                        //System.out.println(estadoAtual.getNome() + "32");

                        fita.set(cursor, transicaoALL.getSimbEscrito()); // Escreve o simbolo na fita
                        if (transicaoALL.getDirecao() == Direcao.DIREITA) {
                            cursor++;
                        } else {
                            cursor--;
                        }
                        /*System.out.println(fita.get(cursor).getNome());
                        System.out.println(estadoAtual.getNome());
                        System.out.println(cursor);
                        System.out.println(transicaoALL.getDirecao());
                        System.out.println("_________");*/

                        //System.out.println("break label");
                        break label;
                    }//if
                }//for
                sera.clear();

                //System.out.println("saiu do for");


                for (Estado e : all.getEstFinais()) {
                    if (e.getNome().equals(estadoAtual.getNome()) && (!loop)) {
                        ShowFitaALL.getInstance().showFitaALL(fita);
                        return true; // estado final foi assumido
                    }
                }
                loop2 = loop;
                loop = false;

                if (!salva.isEmpty()) {
                    Copia copia = salva.removeFirst();
                    try {
                        fita.clear();
                        fita = (List) copia.getFita().getClass().getMethod("clone").invoke(copia.getFita());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    cursor = copia.getCursor();
                    estadoAtual = copia.getEstAtual();
                    /*System.out.println("__recuperou____");
                    System.out.println(fita.get(cursor).getNome());
                    System.out.println(estadoAtual.getNome());
                    System.out.println(cursor);
                    System.out.println("__out for____");*/
                } else {

                    if (loop2) {
                        JOptionPane.showMessageDialog(null, "ALL em Looping", "Atenção",
                                JOptionPane.INFORMATION_MESSAGE);
                        ShowFitaMT.getInstance().showFitaMT(fita);
                        return false;
                    } else {
                        ShowFitaALL.getInstance().showFitaALL(fita);
                        return false; // Nenhuma transica foi encontrada
                    }
                }
            } //label
        } // while
    }

    /*private boolean naoDeterminismo(){

    }*/
    /**
     * Faz a alteração na pilha do automato com pilha.
     */
    private void alterarPilha(Stack pilha, Estado ea, TransicaoAP t) {
        // Altera o estado Destino
        ea.setNome(t.getEstDest().getNome());

        // remove o simbolo do topo da pilha
        if (!pilha.empty()) {
            pilha.pop();
        }

        int tamPilha = t.getEntradaPilha().size() - 1;
        // Add o que esta na entrada da transicao
        for (int i = tamPilha; i >= 0; i--) {
            Simbolo s = t.getEntradaPilha().get(i);

            // se nao for igual a lambida
            if (s.getNome().charValue() == '\u03BB') {
                // Remove novamente somente se o simbolo ja foi
                // removido uma vez, ou seja.. caso para entrada da
                // pilha.. AlambidaB
                if (i != tamPilha) {
                    pilha.pop();
                }

            } else {
                pilha.push(s);
            }
        }
    }

    private void sendMessage(boolean isOK) {
        if (isOK) {
            javax.swing.JOptionPane.showMessageDialog(null,
                    "Seqüência ACEITA", "!! OK !!",
                    javax.swing.JOptionPane.INFORMATION_MESSAGE);
        } else {
            javax.swing.JOptionPane.showMessageDialog(null,
                    "Seqüência REJEITADA", "!! Atenção !!",
                    javax.swing.JOptionPane.WARNING_MESSAGE);
        }

    }

    public static ValidaSequencia getInstance() {
        return singleton;
    }

    static {
        singleton = new ValidaSequencia();
    }

    /**
     * Classe utilitaria pra o AFMV
     */
    private static final class UtilAFMV {

        /**
         * Trata o caso do lambida, recebe a lista de estados ativos
         * caso existe alguma transicao capaz de ativar outra que tenha somente
         * UMA TRANSICAO para um UM ESTADO, entao remove o estado ativo, e colo
         * ca o estado ativo atual, caso exista mais de uma, entao mantem.
         *
         */
        private static Map<String, Estado> getLambidaCase(
                Map<String, Estado> estadosAtivos,
                Set<Transicao> transicoesAFMV,
                Map<String, Estado> estadSeguros) {

            final Map<String, Estado> aux = new HashMap<String, Estado>();
            boolean novamente = false; // verifica ate nao ocorre nenhuma
            boolean primVez = true;
            do {
                if (primVez) {
                    aux.putAll(estadosAtivos);
                } else {
                    estadosAtivos.clear();
                    estadosAtivos.putAll(aux);
                }

                novamente = false;
                for (Transicao t : transicoesAFMV) {
                    final Estado e = estadosAtivos.get(t.getEstOri().getNome());
                    if (e != null && t.getSimbolo().getNome() == '\u03BB') {
                        final String nEst = e.getNome();
                        boolean canRemove = true;
                        for (Transicao tt : transicoesAFMV) {
                            if (tt.getEstOri().getNome().equals(nEst) &&
                                    tt.getSimbolo().getNome() != '\u03BB') {
                                canRemove = false;
                            }
                        }

                        if (canRemove) {
                            estadSeguros.remove(nEst);
                            aux.remove(nEst);
                        }
                        String nomeEstDest = t.getEstDest().getNome();

                        if (!aux.containsKey(nomeEstDest)) {
                            aux.put(nomeEstDest, t.getEstDest());
                            novamente = true;

                        } else {
                            novamente = false;

                        }


                    }
                }

                primVez = false;
            } while (novamente);

            return aux;

        }
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
            afmv.addTransicao(new Transicao(afmv_aux.getEstadosFinais().iterator().next(),
                    new Simbolo('\u03BB'),
                    afmv_aux.getEstadoInicial()));

            // add transicao da esquerda
            afmv.addTransicao(new Transicao(afmv.getEstadoInicial(),
                    new Simbolo('\u03BB'),
                    afmv_aux.getEstadoInicial()));

            // add transicao da direita
            afmv.addTransicao(new Transicao(afmv_aux.getEstadosFinais().iterator().next(),
                    new Simbolo('\u03BB'),
                    afmv.getEstadosFinais().iterator().next()));

            // add transicao esquerda/direita inferior
            afmv.addTransicao(new Transicao(afmv.getEstadoInicial(),
                    new Simbolo('\u03BB'),
                    afmv.getEstadosFinais().iterator().next()));
            // add as transicoes
            afmv.addAllTransicoes(afmv_aux.getTransicoes());
            return afmv;
        }

        /**
         * Processa a sequencia xx
         * Simbolo de ligacao
         */
        private final AFMV processaContatenacao(final AFMV afmv_1,
                final AFMV afmv_2) {

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
            afmv.addTransicao(new Transicao(afmv_1.getEstadosFinais().iterator().next(),
                    new Simbolo('\u03BB'),
                    afmv.getEstadosFinais().iterator().next()));

            // Add transicao inferior direita
            afmv.addTransicao(new Transicao(afmv_2.getEstadosFinais().iterator().next(),
                    new Simbolo('\u03BB'),
                    afmv.getEstadosFinais().iterator().next()));

            return afmv;
        }

        /**
         * Método usado para verificar se já exste um automato finito com
         * movimentos vazio na lista. Metodo usado para tranformacao de uma
         * ER em um AFND.
         */
        private boolean existeAFMV(List<AFMV> values, char nomeSimboloTrans) {
            for (AFMV a : values) {
                for (Transicao t : a.getTransicoes()) {
                    if (t.getSimbolo().getNome() == nomeSimboloTrans) {
                        return false;
                    }
                }
            }

            return true;
        }

        /**
         * Retorna um novo estado
         */
        private Estado getNewEstado() {
            return new Estado("S" + cEstado++);
        }

        /**
         * Cria um novo AFMV com o simbolo recebido na transicao
         */
        private AFMV getNewAFMV(char c) {
            final AFMV afmv = new AFMV();

            final Estado eOrig = this.getNewEstado();
            final Estado eDest = this.getNewEstado();
            afmv.addTransicao(new Transicao(eOrig, new Simbolo(c), eDest));

            afmv.setEstadoInicial(eOrig);
            afmv.addEstadoFinal(eDest);

            return afmv;

        }

        private class UtilsER {

            final Stack<Character> pilha = new Stack<Character>();

            private final String getExpressaoPosFixa(String expressao) {
                StringBuilder saida = new StringBuilder();
                for (char c : formatExpressao(expressao)) {
                    if (Character.isLetterOrDigit(c)) {
                        saida.append(c);
                    } else if (pilha.empty()) {
                        pilha.push(c);
                    } else {
                        if (c == 41) {
                            while (true) {
                                saida.append(pilha.pop());

                                if (pilha.peek() == 40) {
                                    pilha.pop();
                                    break;
                                }
                            }
                        } else if (!pilha.isEmpty() && c != 40 &&
                                this.getValorOperador(c) <=
                                this.getValorOperador(pilha.peek())) {
                            saida.append(pilha.pop());
                        }

                        if (c != 41) {
                            pilha.push(c);
                        }
                    }
                }

                // esvazia a pilha
                while (!pilha.empty()) {
                    saida.append(pilha.pop());
                }

                List<Character> values = null;

                // Caso da concatenação *AA| é necessário inserir um |
                // como... *A|A|
                if (saida.length() > 4) {
                    boolean status1 = false;
                    boolean status2 = false;
                    boolean status3 = false;

                    values = new ArrayList<Character>();
                    for (char c : saida.toString().toCharArray()) {
                        values.add(c);
                    }

                    for (int i = 0; i < values.size(); i++) {
                        char c = values.get(i);
                        if (c == '*' || c == '+') {
                            status1 = true;
                            status2 = false;
                            status3 = false;
                            continue;

                        } else if (status1 && Character.isLetterOrDigit(c)) {
                            status1 = false;
                            status2 = true;
                            continue;

                        } else if (status2 && Character.isLetterOrDigit(c)) {
                            status2 = false;
                            status3 = true;
                            continue;

                        } else if (status3 && c == '|') {
                            status3 = false;
                            values.add(i - 1, '|');
                            continue;
                        }

                    }

                    saida = new StringBuilder();
                    for (Character c : values) {
                        saida.append(c);
                    }
                }

                return saida.toString();

            }

            private int getValorOperador(char c) {
                switch (c) {
                    case '+':
                        return 0;
                    case '|':
                        return 1;
                    case '*':
                        return 2;
                    default:
                        return -1;
                }
            }

            private ArrayList<Character> formatExpressao(String expressao) {
                ArrayList<Character> list = new ArrayList<Character>();
                for (char c : expressao.toCharArray()) {
                    list.add(c);
                }

                for (int i = 0; i < list.size(); i++) {
                    char c = list.get(i);

                    if (Character.isLetterOrDigit(c) && i > 0 && Character.isLetterOrDigit(list.get(i - 1))) {

                        list.add(i, '|');
                        continue;
                    }

                    if (c == '*') {
                        list.add(++i, '%'); // case a*
                    }
                }

                return list;
            }
        } // fim da classe
    }

    private boolean valida(Mealy mealy, String sequencia) {
        // Estado Inicial
        Estado estadoAtual = mealy.getEstadoInicial();
        //fita de saida
        List<Simbolo> fita = new ArrayList<Simbolo>();
        System.out.println(sequencia);
        for (char c : sequencia.toCharArray()) {
            label:
            {
                for (Transicao t : mealy.getTransicoes()) {
                    System.out.println(t.getEstOri().getNome());
                    Estado e = t.getEstOri();
                    Simbolo s = t.getSimbolo();
                    if (estadoAtual.getNome().equals(e.getNome()) && c == (s.getNome())) {
                        estadoAtual = t.getEstDest();
                        fita.add(t.getSimboloSaida());
                        break label;
                    }
                }
                System.out.println(estadoAtual.getNome());

                // caso nao exista nenhuma transicao que o leve ao proximo estado

            }

        }

        // Verifica se o Estado atual eh algum
        // Dos estados finais
        for (Estado x : mealy.getEstadosFinais()) {
            if (estadoAtual.getNome().equals(x.getNome())) {
                ShowFitaLingRegul.getInstance().showFitaMT(fita);
                return true;
            }
        }
        ShowFitaLingRegul.getInstance().showFitaMT(fita);
        return false;
    }

    private boolean valida(Moore moore, String sequencia) {
        // Estado Inicial
        Estado estadoAtual = moore.getEstadoInicial();
        System.out.println("moore saida  " + estadoAtual.getSaida().getNome());
        //fita de saida
        List<Simbolo> fita = new ArrayList<Simbolo>();
        System.out.println(sequencia);
        for (char c : sequencia.toCharArray()) {
            label:
            {
                for (Transicao t : moore.getTransicoes()) {
                    System.out.println(t.getEstOri().getNome());
                    System.out.println(t.getSimbolo().getNome());
                    System.out.println(t.getEstDest().getNome());
                    Estado e = t.getEstOri();
                    Simbolo s = t.getSimbolo();
                    
                    if (estadoAtual.getNome().equals(e.getNome()) && c == (s.getNome())) {
                        System.out.println("AH TAh");
                        estadoAtual = t.getEstDest();
                        System.out.println("saida " + estadoAtual.getSaida().getNome());
                        fita.add(estadoAtual.getSaida());
                        break label;
                    }
                }
                System.out.println(estadoAtual.getNome());

                // caso nao exista nenhuma transicao que o leve ao proximo estado

            }

        }

        // Verifica se o Estado atual eh algum
        // Dos estados finais
        for (Estado x : moore.getEstadosFinais()) {
            if (estadoAtual.getNome().equals(x.getNome())) {
                ShowFitaLingRegul.getInstance().showFitaMT(fita);
                return true;
            }
        }
        ShowFitaLingRegul.getInstance().showFitaMT(fita);
        return false;

    }
}
