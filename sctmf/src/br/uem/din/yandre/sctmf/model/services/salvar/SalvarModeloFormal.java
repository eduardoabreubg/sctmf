/*
 * Salvar.java
 *
 * Created on 11 de Abril de 2007, 09:57
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package br.uem.din.yandre.sctmf.model.services.salvar;

import br.uem.din.yandre.sctmf.model.pojo.AFD;
import br.uem.din.yandre.sctmf.model.pojo.AFMV;
import br.uem.din.yandre.sctmf.model.pojo.AFND;
import br.uem.din.yandre.sctmf.model.pojo.ALL;
import br.uem.din.yandre.sctmf.model.pojo.AP;
import br.uem.din.yandre.sctmf.model.pojo.ER;
import br.uem.din.yandre.sctmf.model.pojo.Estado;
import br.uem.din.yandre.sctmf.model.pojo.GLC;
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
import java.io.File;
import java.io.FileWriter;

/**
 *
 * @author rafael2009_00
 */
public class SalvarModeloFormal implements Salvar {

    private FileWriter fw;
    private File file;

    /**
     * Creates a new instance of Salvar
     */
    public SalvarModeloFormal() {
    }

    public void salvar(File arquivo, ModeloFormal mf) throws SalvarException {
        this.file = arquivo;

        if (mf instanceof AP) {
            this.salvarAP((AP) mf);
        } else if (mf instanceof AFMV) {
            this.salvarAFMV((AFMV) mf);
        } else if (mf instanceof AFD) {
            this.salvarAFD((AFD) mf);
        } else if (mf instanceof AFND) {
            this.salvarAFND((AFND) mf);
        } else if (mf instanceof ER) {
            this.salvarER((ER) mf);
        } else if (mf instanceof GLC) {
            this.salvarGLC((GLC) mf);
        } else if (mf instanceof MT) {
            this.salvarMT((MT) mf);
        } else if (mf instanceof ALL) {
            this.salvarALL((ALL) mf);
        } else if (mf instanceof Mealy) {
            this.salvarMealy((Mealy) mf);
        } else if (mf instanceof Moore) {
            this.salvarMoore((Moore) mf);
        }

    }

    private void salvarAFD(AFD afd) throws SalvarException {
        StringBuilder sb = new StringBuilder();

        sb.append("E:");  // Add Simbolos
        for (Simbolo s : afd.getSimbolos()) {
            sb.append(s.getNome() + "-");
        }

        sb.append("\nS:");
        for (Estado e : afd.getEstados()) {
            sb.append(e.getNome() + "-");
        }

        Estado aux = afd.getEstadoInicial();
        sb.append("\nI:");
        if (aux != null) {
            sb.append(aux.getNome());
        }

        sb.append("\nF:");
        for (Estado e : afd.getEstadosFinais()) {
            sb.append(e.getNome() + "-");
        }

        for (Transicao t : afd.getTransicoes()) {
            sb.append("\nT:" +
                    t.getEstOri().getNome() + "-" +
                    t.getSimbolo().getNome() + "-" +
                    t.getEstDest().getNome());
        }

        try {
            this.writeInFile(
                    new File(
                    this.file.getPath() + ".afd"), sb.toString());

            this.showOkMessage("AFD");
        } catch (Exception ioex) {
            throw new SalvarException("Erro ao Salvar AFD");
        }
    }

    private void salvarAFND(AFND afnd) throws SalvarException {
        StringBuilder sb = new StringBuilder();

        sb.append("E:");  // Add Simbolos
        for (Simbolo s : afnd.getSimbolos()) {
            sb.append(s.getNome() + "-");
        }

        sb.append("\nS:");
        for (Estado e : afnd.getEstados()) {
            sb.append(e.getNome() + "-");
        }

        sb.append("\nI:");
        for (Estado ei : afnd.getEstadosIniciais()) {
            sb.append(ei.getNome() + "-");
        }

        sb.append("\nF:");
        for (Estado e : afnd.getEstadosFinais()) {
            sb.append(e.getNome() + "-");
        }

        for (Transicao t : afnd.getTransicoes()) {
            sb.append("\nT:" +
                    t.getEstOri().getNome() + "-" +
                    t.getSimbolo().getNome() + "-" +
                    t.getEstDest().getNome());
        }

        try {
            this.writeInFile(
                    new File(
                    this.file.getPath() + ".afnd"), sb.toString());

            this.showOkMessage("AFND");
        } catch (Exception ioex) {
            throw new SalvarException("Erro ao Salvar AFND");
        }
    }

    private void salvarER(ER er) throws SalvarException {
        StringBuilder sb = new StringBuilder();

        sb.append("E:");  // Add Simbolos
        for (Simbolo s : er.getAlfabeto()) {
            sb.append(s.getNome() + "-");
        }

        sb.append("\nR:") // Add a expressao regular
                .append(er.getExpressaoRegular());

        try {
            this.writeInFile(
                    new File(
                    this.file.getPath() + ".er"), sb.toString());

            this.showOkMessage("ER");
        } catch (Exception ioex) {
            throw new SalvarException("Erro ao Salvar AFND");
        }
    }

    private void salvarAFMV(AFMV afmv) throws SalvarException {
        StringBuilder sb = new StringBuilder();

        sb.append("E:");  // Add Simbolos
        for (Simbolo s : afmv.getSimbolos()) {
            sb.append(s.getNome() + "-");
        }

        sb.append("\nS:");
        for (Estado e : afmv.getEstados()) {
            sb.append(e.getNome() + "-");
        }

        Estado aux = afmv.getEstadoInicial();
        sb.append("\nI:");
        if (aux != null) {
            sb.append(aux.getNome());
        }

        sb.append("\nF:");
        for (Estado e : afmv.getEstadosFinais()) {
            sb.append(e.getNome() + "-");
        }

        for (Transicao t : afmv.getTransicoes()) {
            sb.append("\nT:" +
                    t.getEstOri().getNome() + "-" +
                    t.getSimbolo().getNome() + "-" +
                    t.getEstDest().getNome());
        }

        try {
            this.writeInFile(
                    new File(
                    this.file.getPath() + ".afmv"), sb.toString());

            this.showOkMessage("AFMV");
        } catch (Exception ioex) {
            throw new SalvarException("Erro ao Salvar AFMV");
        }
    }

    private void salvarAP(AP ap) throws SalvarException {
        StringBuilder sb = new StringBuilder();

        sb.append("E:");  // Add Simbolos
        for (Simbolo s : ap.getSimbolos()) {
            sb.append(s.getNome() + "-");
        }

        sb.append("\nP:"); // Add Simbolos pilha
        for (Simbolo s : ap.getSimbolosPilha()) {
            sb.append(s.getNome() + "-");
        }

        sb.append("\nS:");
        for (Estado e : ap.getEstados()) {
            sb.append(e.getNome() + "-");
        }

        Estado aux = ap.getEstadoInicial();
        sb.append("\nI:");
        if (aux != null) {
            sb.append(aux.getNome());
        }

        Simbolo s = ap.getTopoPilha();
        sb.append("\nB:");
        if (s != null) {
            sb.append(s.getNome());
        }

        for (TransicaoAP t : ap.getTransicoesAP()) {
            sb.append("\nT:");
            sb.append(t.getEstOri().getNome());
            sb.append("-");
            sb.append(t.getSimbolo().getNome() == '\u03BB' ? "?" : t.getSimbolo().getNome());
            sb.append("-");
            sb.append(t.getSimBasePilha().getNome());
            sb.append("-");
            sb.append(t.getEstDest().getNome());
            sb.append("-");
            for (Simbolo x : t.getEntradaPilha()) {
                sb.append(x.getNome());
            }

        }

        try {
            this.writeInFile(
                    new File(
                    this.file.getPath() + ".ap"), sb.toString());

            this.showOkMessage("AP");
        } catch (Exception ioex) {
            throw new SalvarException("Erro ao Salvar AP");
        }
    }

    private void salvarGLC(GLC glc) throws SalvarException {
        StringBuilder sb = new StringBuilder();

        sb.append("V:");  // Add Simbolos Nao-Termais
        for (SimboloString s : glc.getSimbNTerm()) {
            sb.append("<simbolo>" + s.getNome() + "</simbolo>");
        }

        sb.append("\nT:");  // Add Simbolos Termais
        for (SimboloString s : glc.getSimbTerm()) {
            sb.append("<simbolo>" + s.getNome() + "</simbolo>");
        }

        SimboloString aux = glc.getSimbInicial(); // Simbolo Inicial
        sb.append("\nS:");
        if (aux != null) {
            sb.append("<simbolo>" + aux.getNome() + "</simbolo>");
        }

        SimboloString lambda = GLC.LAMBDA;
        for (RegraProducao rp : glc.getRegrasProducao()) {
            sb.append("\nP:<simbolo>" + rp.getSimbLEsq().getNome() + "</simbolo>");
            sb.append("-");
            if (lambda.equals(rp.getSimbLDireito().get(0))) {
                sb.append("<simbolo></simbolo>");
                continue;
            }
            for (SimboloString x : rp.getSimbLDireito()) {
                sb.append("<simbolo>" + x.getNome() + "</simbolo>");
            }
        }

        try {
            this.writeInFile(
                    new File(
                    this.file.getPath() + ".glc"), sb.toString());

            this.showOkMessage("GLC");
        } catch (Exception ioex) {
            throw new SalvarException("Erro ao Salvar GLC");
        }
    }

    private void salvarMT(MT mt) throws SalvarException {
        StringBuilder sb = new StringBuilder();

        sb.append("E:");  // Add Simbolos do Alfabeo
        for (Simbolo s : mt.getAlfabeto()) {
            sb.append(s.getNome() + "-");
        }

        sb.append("\nV:");  // Add Simbolos do Alfabeto auxiliar
        for (Simbolo s : mt.getAlfabetoAux()) {
            sb.append(s.getNome() + "-");
        }

        sb.append("\nQ:"); // Add os estados
        for (Estado e : mt.getEstados()) {
            sb.append(e.getNome() + "-");
        }

        sb.append("\nI:"); // Estado Inicial        
        Estado aux = mt.getEstIni();
        if (aux != null) {
            sb.append(aux.getNome());
        }

        sb.append("\nF:");
        for (Estado e : mt.getEstFinais()) {
            sb.append(e.getNome() + "-");
        }

        for (TransicaoMT t : mt.getTransicoes()) {
            sb.append("\nT:").append(t.getEstAtual().getNome()).append("-").append(t.getSimLido().getNome()).append("-").append(t.getEstDestino().getNome()).append("-").append(t.getSimbEscrito().getNome()).append("-").append(t.getDirecao());
        }

        try {
            this.writeInFile(
                    new File(
                    this.file.getPath() + ".mt"), sb.toString());

            this.showOkMessage("MT");
        } catch (Exception ioex) {
            throw new SalvarException("Erro ao Salvar MT");
        }
    }

    private void salvarALL(ALL all) throws SalvarException {
        StringBuilder sb = new StringBuilder();

        sb.append("E:");  // Add Simbolos do Alfabeo
        for (Simbolo s : all.getAlfabeto()) {
            sb.append(s.getNome() + "-");
        }

        sb.append("\nV:");  // Add Simbolos do Alfabeto auxiliar
        for (Simbolo s : all.getAlfabetoAux()) {
            sb.append(s.getNome() + "-");
        }

        sb.append("\nQ:"); // Add os estados
        for (Estado e : all.getEstados()) {
            sb.append(e.getNome() + "-");
        }

        sb.append("\nI:"); // Estado Inicial
        Estado aux = all.getEstIni();
        if (aux != null) {
            sb.append(aux.getNome());
        }

        sb.append("\nF:");
        for (Estado e : all.getEstFinais()) {
            sb.append(e.getNome() + "-");
        }

        for (TransicaoALL t : all.getTransicoes()) {
            sb.append("\nT:").append(t.getEstAtual().getNome()).append("-").append(t.getSimLido().getNome()).append("-").append(t.getEstDestino().getNome()).append("-").append(t.getSimbEscrito().getNome()).append("-").append(t.getDirecao());
        }

        try {
            this.writeInFile(
                    new File(
                    this.file.getPath() + ".all"), sb.toString());

            this.showOkMessage("ALL");
        } catch (Exception ioex) {
            throw new SalvarException("Erro ao Salvar MT");
        }
    }

    private void salvarMealy(Mealy mealy) throws SalvarException {
        StringBuilder sb = new StringBuilder();

        sb.append("E:");  // Add Simbolos
        for (Simbolo s : mealy.getSimbolos()) {
            sb.append(s.getNome() + "-");
        }

        sb.append("\nO:"); //simbolos saida
        for (Simbolo s : mealy.getSimbolosSaida()) {
            sb.append(s.getNome() + "-");
        }

        sb.append("\nS:");
        for (Estado e : mealy.getEstados()) {
            sb.append(e.getNome() + "-");
        }

        Estado aux = mealy.getEstadoInicial();
        sb.append("\nI:");
        if (aux != null) {
            sb.append(aux.getNome());
        }

        sb.append("\nF:");
        for (Estado e : mealy.getEstadosFinais()) {
            sb.append(e.getNome() + "-");
        }

        for (Transicao t : mealy.getTransicoes()) {
            sb.append("\nT:" +
                    t.getEstOri().getNome() + "-" +
                    t.getSimbolo().getNome() + "-" +
                    t.getEstDest().getNome() + "-" +
                    t.getSimboloSaida().getNome());
        }

        try {
            this.writeInFile(
                    new File(
                    this.file.getPath() + ".mealy"), sb.toString());

            this.showOkMessage("Mealy");
        } catch (Exception ioex) {
            throw new SalvarException("Erro ao Salvar Mealy");
        }
    }

    private void salvarMoore(Moore moore) throws SalvarException {
        StringBuilder sb = new StringBuilder();

        sb.append("E:");  // Add Simbolos
        for (Simbolo s : moore.getSimbolos()) {
            sb.append(s.getNome() + "-");
        }

        sb.append("\nO:"); //simbolos saida
        for (Simbolo s : moore.getSimbolosSaida()) {
            sb.append(s.getNome() + "-");
        }


        for (Estado e : moore.getEstados()) {
            sb.append("\nS:" +
                    e.getNome() + "-" +
                    e.getSaida().getNome());
        }

        Estado aux = moore.getEstadoInicial();
        sb.append("\nI:");
        if (aux != null) {
            sb.append(aux.getNome());
        }

        sb.append("\nF:");
        for (Estado e : moore.getEstadosFinais()) {
            sb.append(e.getNome() + "-");
        }

        for (Transicao t : moore.getTransicoes()) {
            sb.append("\nT:" +
                    t.getEstOri().getNome() + "-" +
                    t.getSimbolo().getNome() + "-" +
                    t.getEstDest().getNome());
        }

        try {
            this.writeInFile(
                    new File(
                    this.file.getPath() + ".moore"), sb.toString());

            this.showOkMessage("Moore");
        } catch (Exception ioex) {
            throw new SalvarException("Erro ao Salvar Moore");
        }
    }

    private void writeInFile(File file, String content)
            throws Exception {

        FileWriter fw = new FileWriter(file);
        fw.write(content);
        fw.flush();
        fw.close();

    }

    private void showOkMessage(String nameFormalModel) {
        javax.swing.JOptionPane.showMessageDialog(null,
                nameFormalModel + " Salvo com Sucesso", "Operação Concluída",
                javax.swing.JOptionPane.INFORMATION_MESSAGE);

    }
}
