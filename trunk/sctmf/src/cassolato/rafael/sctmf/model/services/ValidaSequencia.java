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
import cassolato.rafael.sctmf.model.pojo.FormalModel;
import cassolato.rafael.sctmf.model.pojo.Simbolo;
import cassolato.rafael.sctmf.model.pojo.Transicao;

/**
 *
 * @author rafael2009_00
 */
public class ValidaSequencia implements Validacao {
    
    private static ValidaSequencia singleton;
    
    /** Creates a new instance of ValidaSequencia */
    private ValidaSequencia() {
    }
    
    public void valida(FormalModel fm, String sequencia) {        
       try {
           this.sendMessage(this.validaAFD((AFD) fm, sequencia));
       }catch(ClassCastException exAFD)  {
           try {
               
           }catch(ClassCastException exAFND) {
               
           }
       }
        
    }
            
    /**
     * Metodo que faz a validação de uma sequencia.
     * 
     * @param afd - Automato finito deterministico
     * @param sequencia - Sequencia digitada pelo usuário
     *
     * @return boolean;
     */    
    private boolean validaAFD(AFD afd, String sequencia) {
        // Estado InicialE
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
    
    private void sendMessage(boolean isOK) {
        if(isOK) 
            javax.swing.JOptionPane.showMessageDialog(null, 
                    "Seqüência ACEITA", "!! OK !!",
                    javax.swing.JOptionPane.INFORMATION_MESSAGE);
        else
            javax.swing.JOptionPane.showMessageDialog(null, 
                    "Seqüência REJEITADA", "!! Atenção !!",
                    javax.swing.JOptionPane.INFORMATION_MESSAGE);
            
    }
    
    public static ValidaSequencia getInstance() {
        return singleton;
    }
    
    static {
        singleton = 
                new ValidaSequencia();
    }
    
}