/*
 * ValSeqAfnd.java
 *
 * Created on 26 de Maio de 2007, 19:19
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package cassolato.rafael.sctmf.view.formalmodels.afnd;

import cassolato.rafael.sctmf.model.pojo.AFND;
import cassolato.rafael.sctmf.model.pojo.Estado;
import cassolato.rafael.sctmf.model.pojo.FormalModel;
import cassolato.rafael.sctmf.model.pojo.Simbolo;
import cassolato.rafael.sctmf.model.pojo.Transicao;
import cassolato.rafael.sctmf.model.services.ValidaSequencia;
import cassolato.rafael.sctmf.view.formalmodels.afd.ValSeq;

/**
 *
 * @author Cassolato
 */
public class ValSeqAfnd extends ValSeq {
    private AFND afnd = null;
    
    /** Creates a new instance of ValSeqAfnd */
    public ValSeqAfnd() {
    }
    
    protected void managerFM(FormalModel fm) {
        this.afnd = (AFND)fm;
        this.setInformacoes(afnd);
    }
    
    protected void actionValidar() {
        ValidaSequencia.getInstance().valida(
                afnd, getFSequencia().getText());
    }
    
    private void setInformacoes(AFND afnd) {
        getAInf().setText("V = <\u03a3, S, S\u2080, \u03B4, F>\n");
        StringBuffer sb = new StringBuffer();
        
        sb.append("\u03a3 = {");  // Add Simbolos
        for(Simbolo s : afnd.getSimbolos())
            sb.append(s.getNome()+", ");                
        sb = formataSb(sb);
                
        sb.append("S = {");
        for(Estado e : afnd.getEstados())
            sb.append("<"+e.getNome()+">, ");          
        sb = formataSb(sb);
                      
        sb.append("S\u2080 = {");
        for(Estado ef : afnd.getEstadosIniciais())            
            sb.append("<"+ef.getNome()+">, ");     
        sb = formataSb(sb);
        
        sb.append("F = {");
        for(Estado e : afnd.getEstadosFinais())
            sb.append("<"+e.getNome()+">, "); 
        sb = formataSb(sb);        
        getAInf().append("\n");
        
        for(Transicao t : afnd.getTransicoes())
        sb.append("\u03B4(<"+
                t.getEstOri().getNome()+">, "+
                t.getSimbolo().getNome()+") = <"+
                t.getEstDest().getNome()+">\n" );         
        
        getAInf().append(sb.toString());
    }    
    
}