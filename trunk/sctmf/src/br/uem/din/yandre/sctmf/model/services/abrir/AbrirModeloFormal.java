/*
 * AbrirModeloFormal.java
 *
 * Created on 13 de Abril de 2007, 09:26
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.uem.din.yandre.sctmf.model.services.abrir;

import br.uem.din.yandre.sctmf.model.pojo.AFD;
import br.uem.din.yandre.sctmf.model.pojo.AFMV;
import br.uem.din.yandre.sctmf.model.pojo.AFND;
import br.uem.din.yandre.sctmf.model.pojo.ALL;
import br.uem.din.yandre.sctmf.model.pojo.AP;
import br.uem.din.yandre.sctmf.model.pojo.Direcao;
import br.uem.din.yandre.sctmf.model.pojo.ER;
import br.uem.din.yandre.sctmf.model.pojo.Estado;
import br.uem.din.yandre.sctmf.model.pojo.EstadoComparavel;
import br.uem.din.yandre.sctmf.model.pojo.GLC;
import br.uem.din.yandre.sctmf.model.pojo.MT;
import br.uem.din.yandre.sctmf.model.pojo.ModeloFormal;
import br.uem.din.yandre.sctmf.model.pojo.RegraProducao;
import br.uem.din.yandre.sctmf.model.pojo.Simbolo;
import br.uem.din.yandre.sctmf.model.pojo.SimboloString;
import br.uem.din.yandre.sctmf.model.pojo.Transicao;
import br.uem.din.yandre.sctmf.model.pojo.TransicaoALL;
import br.uem.din.yandre.sctmf.model.pojo.TransicaoAP;
import br.uem.din.yandre.sctmf.model.pojo.TransicaoMT;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 *
 * @author rafael2009_00
 */
public class AbrirModeloFormal implements Abrir {
    
    /**
     * Creates a new instance of AbrirModeloFormal
     */
    public AbrirModeloFormal() {
    }
    
    public ModeloFormal abrir(File arquivo) throws AbrirException {
        // pega a extenção do arquivo
        String aux[] = arquivo.getName().split("\\.");
        String extencionFile = aux[aux.length - 1];

        // De acordo com a extencao, retorna o Modelo Formal equivalente
        if (extencionFile.equalsIgnoreCase("afd")) {
            return this.abrirAFD(arquivo);
        } else if (extencionFile.equalsIgnoreCase("afnd")) {
            return this.abrirAFND(arquivo);
        }

        if (extencionFile.equalsIgnoreCase("afmv")) {
            return this.abrirAFMV(arquivo);
        } else if (extencionFile.equalsIgnoreCase("er")) {
            return this.abrirER(arquivo);
        } else if (extencionFile.equalsIgnoreCase("ap")) {
            return this.abrirAP(arquivo);
        } else if (extencionFile.equalsIgnoreCase("glc")) {
            return this.abrirGLC(arquivo);
        } else if (extencionFile.equalsIgnoreCase("mt")) {
            return this.abrirMT(arquivo);
        } else if (extencionFile.equalsIgnoreCase("all")) {
            return this.abrirALL(arquivo);
        } else {
            return null;
        }
    }
    
    private AFD abrirAFD(File arquivo) throws AbrirException {
        AFD afd = new AFD();
        try {
            BufferedReader br = new BufferedReader(new FileReader(arquivo));
            while (br.ready()) {
                String line = br.readLine();
                if (line.length() > 2) {
                    if (line.startsWith("I")) {
                        afd.setEstadoInicial(
                                new Estado(line.substring(2)));

                    } else if (line.startsWith("T")) {
                        line = line.substring(2);
                        String str[] = line.split("-");

                        Transicao t = new Transicao();
                        t.setEstOri(new Estado(str[0]));
                        t.setSimbolo(new Simbolo(str[1].charAt(0)));
                        t.setEstDest(new Estado(str[2]));

                        afd.addTransicao(t);

                        continue;

                    } else if (line.startsWith("E")) {
                        for (String s : line.substring(2, line.length() - 1).split("-")) {
                            afd.addSimbolo(new Simbolo(s.charAt(0)));
                        }

                    } else if (line.startsWith("S")) {
                        for (String e : line.substring(2, line.length() - 1).split("-")) {
                            afd.addEstado(new Estado(e));
                        }

                    } else if (line.startsWith("F")) {
                        for (String f : line.substring(2, line.length() - 1).split("-")) {
                            afd.addEstadoFinal(new Estado(f));
                        }

                    }
                }

            }//end while

            br.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new AbrirException("Erro Ao abrir modelo Formal");
        }

        return afd;
    }

    private AFD abrirAFMV(File arquivo) throws AbrirException {
        final AFMV afmv = new AFMV();
        try {
            BufferedReader br = new BufferedReader(new FileReader(arquivo));
            while (br.ready()) {
                String line = br.readLine();
                if (line.length() > 2) {
                    if (line.startsWith("I")) {
                        afmv.setEstadoInicial(
                                new Estado(line.substring(2)));

                    } else if (line.startsWith("T")) {
                        line = line.substring(2);
                        String str[] = line.split("-");

                        Transicao t = new Transicao();
                        t.setEstOri(new Estado(str[0]));
                        char c = str[1].charAt(0);
                        t.setSimbolo(new Simbolo(Character.isLetter(c) ? c : '\u03BB'));
                        t.setEstDest(new Estado(str[2]));

                        afmv.addTransicao(t);
                        continue;

                    } else if (line.startsWith("E")) {
                        for (String s : line.substring(2, line.length() - 1).split("-")) {
                            afmv.addSimbolo(new Simbolo(s.charAt(0)));
                        }

                    } else if (line.startsWith("S")) {
                        for (String e : line.substring(2, line.length() - 1).split("-")) {
                            afmv.addEstado(new Estado(e));
                        }

                    } else if (line.startsWith("F")) {
                        for (String f : line.substring(2, line.length() - 1).split("-")) {
                            afmv.addEstadoFinal(new Estado(f));
                        }
                    }
                }

            }//end while

            br.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new AbrirException("Erro Ao abrir modelo Formal");
        }

        return afmv;
    }

    private AFND abrirAFND(File arquivo) throws AbrirException {
        AFND afnd = new AFND();
        try {
            BufferedReader br = new BufferedReader(new FileReader(arquivo));
            while (br.ready()) {
                String line = br.readLine();
                if (line.length() > 2) {
                    if (line.startsWith("T")) { // Transicoes
                        line = line.substring(2);
                        String str[] = line.split("-");

                        Transicao t = new Transicao();
                        t.setEstOri(new EstadoComparavel(str[0]));
                        t.setSimbolo(new Simbolo(str[1].charAt(0)));
                        t.setEstDest(new EstadoComparavel(str[2]));

                        afnd.addTransicao(t);

                    } else if (line.startsWith("E")) { // Alfabeto
                        for (String s : line.substring(2, line.length() - 1).split("-")) {
                            afnd.addSimbolo(new Simbolo(s.charAt(0)));
                        }

                    } else if (line.startsWith("S")) { // Simbolos
                        for (String e : line.substring(2, line.length() - 1).split("-")) {
                            afnd.addEstado(new EstadoComparavel(e));
                        }

                    } else if (line.startsWith("F")) { // Estados Finais
                        for (String f : line.substring(2, line.length() - 1).split("-")) {
                            afnd.addEstadoFinal(new EstadoComparavel(f));
                        }

                    } else if (line.startsWith("I")) { // Estados Iniciais
                        for (String ei : line.substring(2,
                                line.length() - 1).split("-")) {
                            afnd.addEstadoInicial(new EstadoComparavel(ei));
                        }
                    }
                }

            }//end while

            br.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new AbrirException("Erro Ao abrir modelo Formal");
        }

        return afnd;
    }

    private ModeloFormal abrirER(File arquivo) throws AbrirException {
        ER er = new ER();
        try {
            BufferedReader br = new BufferedReader(new FileReader(arquivo));
            while (br.ready()) {
                String line = br.readLine();
                if (line.length() > 2) {
                    if (line.startsWith("E")) {
                        for (String s : line.substring(2, line.length() - 1).split("-")) {
                            er.addSimboAlf(new Simbolo(s.charAt(0)));
                        }

                    } else if (line.startsWith("R")) {
                        er.setExpressaoRegular(line.substring(2));
                    }

                }
            }//end while

            br.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new AbrirException("Erro Ao abrir Modelo Formal");
        }

        return er;
    }

    private AP abrirAP(File arquivo) throws AbrirException {
        AP ap = new AP();
        try {
            BufferedReader br = new BufferedReader(new FileReader(arquivo));
            while (br.ready()) {
                String line = br.readLine();
                if (line.length() > 2) {
                    if (line.startsWith("I")) {
                        ap.setEstadoInicial(
                                new Estado(line.substring(2)));

                    } else if (line.startsWith("T")) {
                        line = line.substring(2);
                        String str[] = line.split("-");

                        TransicaoAP t = new TransicaoAP();
                        t.setEstOri(new Estado(str[0]));
                        char s = str[1].charAt(0);
                        t.setSimbolo(new Simbolo(s == '?' ? '\u03BB' : s));
                        s = str[2].charAt(0);
                        t.setSimBasePilha(new Simbolo(s));

                        t.setEstDest(new Estado(str[3]));
                        // Entrada da pilha
                        List<Simbolo> simbolos = new LinkedList<Simbolo>();
                        for (char c : str[4].toCharArray()) {
                            simbolos.add(new Simbolo(c == '?' ? '\u03BB' : c));
                        }

                        t.setEntradaPilha(simbolos);

                        ap.addTransicao(t);

                    } else if (line.startsWith("E")) { // Alfabeto
                        for (String s : line.substring(2, line.length() - 1).split("-")) {
                            ap.addSimbolo(new Simbolo(s.charAt(0)));
                        }

                    } else if (line.startsWith("P")) { // Alfabeto da Pilha
                        for (String s : line.substring(2, line.length() - 1).split("-")) {
                            ap.addSimboloPilha(new Simbolo(s.charAt(0)));
                        }

                    } else if (line.startsWith("S")) {
                        for (String e : line.substring(2, line.length() - 1).split("-")) {
                            ap.addEstado(new Estado(e));
                        }

                    } else if (line.startsWith("B")) {
                        ap.setTopoPilha(
                                new Simbolo(line.substring(2).charAt(0)));

                    }
                }

            }//end while

            br.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new AbrirException("Erro Ao abrir modelo Formal");
        }

        return ap;
    }
    
    private List<SimboloString> extractSimbolo(String simbolos) {
        String[] ss = simbolos.split("</simbolo>");
        List<SimboloString> ret = new LinkedList<SimboloString>();
        for (String s : ss) 
            ret.add(new SimboloString(s.replaceFirst("[^<]*<simbolo>", "")));
        return ret;
    }
    
    private GLC abrirGLC(File arquivo) throws AbrirException {
        GLC glc = new GLC();
       
        try {
         BufferedReader br = new BufferedReader(new FileReader(arquivo));
         while(br.ready()) {
             String line = br.readLine();
             if(line.length()>2) {                 
                 if(line.startsWith("S")) {
                     glc.setSimbInicial(extractSimbolo(line.substring(2)).get(0));
                 }else if(line.startsWith("P")) {
                     line = line.substring(2);
                     String str[] = line.split("-",2);
                     
                     RegraProducao rp = new RegraProducao();
                     rp.setSimbLEsq(extractSimbolo(str[0]).get(0));
                     
                     // Lado Direito da regra
                     List<SimboloString> simbolos = null;
                     if (str.length == 2) simbolos = extractSimbolo(str[1]);
                     else simbolos = new LinkedList<SimboloString>();
                     if (simbolos.size() == 1 && simbolos.get(0).getNome().isEmpty()) 
                         simbolos.set(0,GLC.LAMBDA);
                         
                     rp.setSimbLDireito(simbolos);
                     
                     glc.addRegraProducao(rp);
                     
                 } else if(line.startsWith("V")) { // Alfabeto Nao-Terminais
                     List<SimboloString> l = extractSimbolo(line.substring(2));
                     Set<SimboloString> s = new HashSet<SimboloString>();
                     s.addAll(l);
                     glc.setSimbNTerm(s);
                 }else if(line.startsWith("T")) { // Alfabeto Terminais
                     List<SimboloString> l = extractSimbolo(line.substring(2));
                     Set<SimboloString> s = new HashSet<SimboloString>();
                     s.addAll(l);
                     glc.setSimbTerm(s);
                 }
             }                 
             
         }//end while
         
         br.close();
        }catch(Exception ex) {
            ex.printStackTrace();
            throw new AbrirException("Erro Ao abrir modelo Formal - GLC");
        }

        return glc;
    }

    private MT abrirMT(File arquivo) throws AbrirException {
        MT mt = new MT();
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(arquivo));
            while (br.ready()) {
                String line = br.readLine();
                if (line.length() > 2) {
                    if (line.startsWith("T")) { // Transicoes
                        line = line.substring(2);
                        String str[] = line.split("-");

                        TransicaoMT t = new TransicaoMT();
                        t.setEstAtual(new Estado(str[0]));

                        char c = str[1].charAt(0);
                        t.setSimLido(new Simbolo(c == '?' ? '\u03B2' : c));

                        t.setEstDestino(new Estado(str[2]));
                        c = str[3].charAt(0);
                        t.setSimbEscrito(new Simbolo(c == '?' ? '\u03B2' : c));
                        t.setDirecao(str[4].equals("ESQUERDA") ? Direcao.ESQUERDA : Direcao.DIREITA);

                        mt.addTransicao(t);
                        continue;

                    } else if (line.startsWith("E")) { // Alfabeto
                        for (String s : line.substring(2, line.length() - 1).split("-")) {
                            mt.addSimbAlf(new Simbolo(s.charAt(0)));
                        }

                    } else if (line.startsWith("V")) { // Alfabeto Auxiliar
                        for (String s : line.substring(2, line.length() - 1).split("-")) {
                            mt.addSimbAlfAux(new Simbolo(s.charAt(0)));
                        }

                    } else if (line.startsWith("Q")) { // Estados
                        for (String e : line.substring(2, line.length() - 1).split("-")) {
                            mt.addEstado(new Estado(e));
                        }

                    } else if (line.startsWith("F")) { // Estados Finais
                        for (String f : line.substring(2, line.length() - 1).split("-")) {
                            mt.addEstadoFinal(new Estado(f));
                        }

                    }
                    if (line.startsWith("I")) {
                        mt.setEstIni(
                                new Estado(line.substring(2)));
                    }
                }

            }//end while

            br.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new AbrirException("Erro Ao abrir modelo Formal");
        }

        return mt;
    }

    private ALL abrirALL(File arquivo) throws AbrirException {
        ALL all = new ALL();

        try {
            BufferedReader br = new BufferedReader(new FileReader(arquivo));
            while (br.ready()) {
                String line = br.readLine();
                if (line.length() > 2) {
                    if (line.startsWith("T")) { // Transicoes
                        line = line.substring(2);
                        String str[] = line.split("-");

                        TransicaoALL t = new TransicaoALL();
                        t.setEstAtual(new Estado(str[0]));

                        char c = str[1].charAt(0);
                        t.setSimLido(new Simbolo(c == '?' ? '\u03B2' : c));

                        t.setEstDestino(new Estado(str[2]));
                        c = str[3].charAt(0);
                        t.setSimbEscrito(new Simbolo(c == '?' ? '\u03B2' : c));
                        t.setDirecao(str[4].equals("ESQUERDA") ? Direcao.ESQUERDA : Direcao.DIREITA);

                        all.addTransicao(t);
                        continue;

                    } else if (line.startsWith("E")) { // Alfabeto
                        for (String s : line.substring(2, line.length() - 1).split("-")) {
                            all.addSimbAlf(new Simbolo(s.charAt(0)));
                        }

                    } else if (line.startsWith("V")) { // Alfabeto Auxiliar
                        for (String s : line.substring(2, line.length() - 1).split("-")) {
                            all.addSimbAlfAux(new Simbolo(s.charAt(0)));
                        }

                    } else if (line.startsWith("Q")) { // Estados
                        for (String e : line.substring(2, line.length() - 1).split("-")) {
                            all.addEstado(new Estado(e));
                        }

                    } else if (line.startsWith("F")) { // Estados Finais
                        for (String f : line.substring(2, line.length() - 1).split("-")) {
                            all.addEstadoFinal(new Estado(f));
                        }

                    }
                    if (line.startsWith("I")) {
                        all.setEstIni(
                                new Estado(line.substring(2)));
                    }
                }

            }//end while

            br.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new AbrirException("Erro Ao abrir modelo Formal");
        }

        return all;
    }
}