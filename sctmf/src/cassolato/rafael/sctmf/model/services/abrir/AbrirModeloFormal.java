/*
 * AbrirModeloFormal.java
 *
 * Created on 13 de Abril de 2007, 09:26
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package cassolato.rafael.sctmf.model.services.abrir;

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
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;

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
        String extencionFile = aux[aux.length-1];
        
        // De acordo com a extencao, retorna o Modelo Formal equivalente
        if(extencionFile.equalsIgnoreCase("afd"))
            return this.abrirAFD(arquivo);
        
        else if(extencionFile.equalsIgnoreCase("afnd"))
            return this.abrirAFND(arquivo);
        
        else if(extencionFile.equalsIgnoreCase("ap"))
            return this.abrirAP(arquivo);
        
        else if(extencionFile.equalsIgnoreCase("glc"))
            return this.abrirGLC(arquivo);
        
        else
            return null;
    }
    
    private AFD abrirAFD(File arquivo) throws AbrirException {
        AFD afd = new AFD();
        try {
         BufferedReader br = new BufferedReader(new FileReader(arquivo));
         while(br.ready()) {
             String line = br.readLine();
             if(line.length()>2) {                 
                 if(line.startsWith("I")) {
                        afd.setEstadoInicial(
                            new Estado(line.substring(2)));
                        
                 }else if(line.startsWith("T")) {
                     line = line.substring(2);
                     String str[] = line.split("-");
                     
                     Transicao t = new Transicao();
                     t.setEstOri(new Estado(str[0]));
                     t.setSimbolo(new Simbolo(str[1].charAt(0)));
                     t.setEstDest(new Estado(str[2]));
                     
                     afd.addTransicao(t);
                     
                 }else if(line.startsWith("E")) {                                          
                    for(String s : line.substring(2,line.length()-1).split("-"))
                        afd.addSimbolo(new Simbolo(s.charAt(0)));

                 }else if(line.startsWith("S")) {                        
                     for(String e: line.substring(2,line.length()-1).split("-"))
                         afd.addEstado(new Estado(e));

                 }else if(line.startsWith("F")) {
                     for(String f : line.substring(2,line.length()-1).split("-"))
                         afd.addEstadoFinal(new Estado(f));
                                      
                 }
             }                 
             
         }//end while
         
         br.close();
        }catch(Exception ex) {
            ex.printStackTrace();
            throw new AbrirException("Erro Ao abrir modelo Formal");            
        }
                
        return afd;        
    }
    
     private AFND abrirAFND(File arquivo) throws AbrirException  {
        AFND afnd = new AFND();
        try {
         BufferedReader br = new BufferedReader(new FileReader(arquivo));
         while(br.ready()) {
             String line = br.readLine();
             if(line.length()>2) {                 
                 if(line.startsWith("T")) { // Transicoes
                     line = line.substring(2);
                     String str[] = line.split("-");
                     
                     Transicao t = new Transicao();
                     t.setEstOri(new Estado(str[0]));
                     t.setSimbolo(new Simbolo(str[1].charAt(0)));
                     t.setEstDest(new Estado(str[2]));
                     
                     afnd.addTransicao(t);
                     
                 }else if(line.startsWith("E")) { // Alfabeto                                        
                    for(String s : line.substring(2,line.length()-1).split("-"))
                        afnd.addSimbolo(new Simbolo(s.charAt(0)));

                 }else if(line.startsWith("S")) { // Simbolos                       
                     for(String e: line.substring(2,line.length()-1).split("-"))
                         afnd.addEstado(new Estado(e));

                 }else if(line.startsWith("F")) { // Estados Finais
                     for(String f : line.substring(2,line.length()-1).split("-"))
                         afnd.addEstadoFinal(new Estado(f));
                                      
                 }else if(line.startsWith("I")) { // Estados Iniciais
                     for(String ei : line.substring(2,
                             line.length()-1).split("-"))
                         afnd.addEstadoInicial(new Estado(ei));
                 }
             }                 
             
         }//end while
         
         br.close();
        }catch(Exception ex) {
            ex.printStackTrace();
            throw new AbrirException("Erro Ao abrir modelo Formal");            
        }
                
        return afnd;  
    }
    
     private AP abrirAP(File arquivo) throws AbrirException {
        AP ap = new AP();
        try {
         BufferedReader br = new BufferedReader(new FileReader(arquivo));
         while(br.ready()) {
             String line = br.readLine();
             if(line.length()>2) {                 
                 if(line.startsWith("I")) {
                        ap.setEstadoInicial(
                            new Estado(line.substring(2)));
                        
                 }else if(line.startsWith("T")) {
                     line = line.substring(2);
                     String str[] = line.split("-");
                     
                     TransicaoAP t = new TransicaoAP();
                     t.setEstOri(new Estado(str[0]));
                     char s = str[1].charAt(0);                     
                     t.setSimbolo(new Simbolo(s=='?'?'\u03BB':s));
                     s = str[2].charAt(0);  
                     t.setSimBasePilha(new Simbolo(s=='?'?'\u03BB':s));
                     
                     t.setEstDest(new Estado(str[3]));
                     // Entrada da pilha
                     List<Simbolo> simbolos = new LinkedList<Simbolo>();
                     for(char c :str[4].toCharArray())                         
                         simbolos.add(new Simbolo(c=='?'?'\u03BB':c));                     
                         
                     t.setEntradaPilha(simbolos);
                     
                     ap.addTransicao(t); 
                     
                 }else if(line.startsWith("E")) { // Alfabeto                                          
                    for(String s : line.substring(2,line.length()-1).split("-"))
                        ap.addSimbolo(new Simbolo(s.charAt(0)));
                    
                 }else if(line.startsWith("P")) { // Alfabeto da Pilha                                         
                    for(String s : line.substring(2,line.length()-1).split("-"))
                        ap.addSimboloPilha(new Simbolo(s.charAt(0)));

                 }else if(line.startsWith("S")) {                        
                     for(String e: line.substring(2,line.length()-1).split("-"))
                         ap.addEstado(new Estado(e));

                 }else if(line.startsWith("B")) {
                     ap.setTopoPilha(
                            new Simbolo(line.substring(2).charAt(0)));
                                      
                 }
             }                 
             
         }//end while
         
         br.close();
        }catch(Exception ex) {
            ex.printStackTrace();
            throw new AbrirException("Erro Ao abrir modelo Formal");            
        }
                
        return ap;        
    }
     
    private GLC abrirGLC(File arquivo) throws AbrirException {
        GLC glc = new GLC();
       
        try {
         BufferedReader br = new BufferedReader(new FileReader(arquivo));
         while(br.ready()) {
             String line = br.readLine();
             if(line.length()>2) {                 
                 if(line.startsWith("S")) {
                        glc.setSimbInicial(
                            new Simbolo(line.substring(2).charAt(0)));
                        
                 }else if(line.startsWith("P")) {
                     line = line.substring(2);
                     String str[] = line.split("-");
                     
                     RegraProducao rp = new RegraProducao();
                     rp.setSimbLEsq(new Simbolo(str[0].charAt(0)));
                     
                     // Lado Direito da regra
                     List<Simbolo> simbolos = new LinkedList<Simbolo>();
                     for(char c :str[1].toCharArray())                         
                         simbolos.add(new Simbolo(c));                     
                         
                     rp.setSimbLDireito(simbolos);
                     
                     glc.addRegraProducao(rp);
                     
                 }else if(line.startsWith("V")) { // Alfabeto Nao-Terminais                                         
                    for(String s : line.substring(2,line.length()-1).split("-"))
                        glc.addSimbNTerm(new Simbolo(s.charAt(0)));
                    
                 }else if(line.startsWith("T")) { // Alfabeto Terminais                                        
                    for(String s : line.substring(2,line.length()-1).split("-"))
                        glc.addSimbTerm(new Simbolo(s.charAt(0)));

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
    
}