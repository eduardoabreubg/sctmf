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
import cassolato.rafael.sctmf.model.pojo.Estado;
import cassolato.rafael.sctmf.model.pojo.Simbolo;
import cassolato.rafael.sctmf.model.pojo.Transicao;
import java.util.Set;

/**
 *
 * @author rafael2009_00
 */
public class ValidaSequencia {
    
    private static ValidaSequencia singleton;
    
    /** Creates a new instance of ValidaSequencia */
    private ValidaSequencia() {
    }
    
    /**
     * Metodo que faz a validação de uma sequencia.
     * 
     * @param afd - Automato finito deterministico
     * @param sequencia - Sequencia digitada pelo usuário
     *
     * @return boolean;
     */
    public boolean validaAFD(AFD afd, String sequencia) {
        // Estado Inicial
        Estado estadoAtual = afd.getEstadoInicial();
        
        // Transicoes Cadastradas
        Set<Transicao> transicoes = afd.getTransicoes();
        
        //Simbolos da Sequencia
        String[] simbolos = new String[sequencia.length()];
        for(int i=0;i<simbolos.length;i++)
            simbolos[i] = String.valueOf(sequencia.charAt(i));
        
        for(int i=0;i<sequencia.length();i++) 
            for(Transicao t : transicoes) {
                Estado e = t.getEstOri();
                Simbolo s = t.getSimbolo();
                if(estadoAtual.getNome().equals(e.getNome())
                    &&simbolos[i].equals(s.getNome())) {
                    
                    estadoAtual = t.getEstDest();
                    break;
                }
                
            }
        
        // Verifica se o Estado atual Ã© algum
        // Dos estados finais
        for(Estado x : afd.getEstadosFinais())
            if(estadoAtual.getNome().equals(x.getNome()))
                return true;
        
        return false;
        
    }
    
    public static ValidaSequencia getInstance() {
        return singleton;
    }
    
    static {
        singleton = 
                new ValidaSequencia();
    }
    
}