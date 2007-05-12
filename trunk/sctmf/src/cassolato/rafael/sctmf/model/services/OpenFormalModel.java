/*
 * OpenFormalModel.java
 *
 * Created on 13 de Abril de 2007, 09:26
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package cassolato.rafael.sctmf.model.services;

import cassolato.rafael.sctmf.model.pojo.AFD;
import cassolato.rafael.sctmf.model.pojo.AFND;
import cassolato.rafael.sctmf.model.pojo.Estado;
import cassolato.rafael.sctmf.model.pojo.FormalModel;
import cassolato.rafael.sctmf.model.pojo.Simbolo;
import cassolato.rafael.sctmf.model.pojo.Transicao;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 *
 * @author rafael2009_00
 */
public class OpenFormalModel implements Open {
    
    private static final OpenFormalModel singleton = new OpenFormalModel();
    
    /** Creates a new instance of OpenFormalModel */
    private OpenFormalModel() {}
    
    public FormalModel open(File file) throws OpenException {
        // pega a extenção do arquivo
        String aux[] = file.getName().split("\\.");    
        String extencionFile = aux[aux.length-1];
        
        // De acordo com a extencao, retorna o Modelo Formal equivalente
        if(extencionFile.equalsIgnoreCase("afd"))
            return this.getAFD(file);
        
        else if(extencionFile.equalsIgnoreCase("afnd"))
            return this.getAFND(file);
        
        else
            return null;
    }
    
    private AFD getAFD(File file) throws OpenException {
        AFD afd = new AFD();
        try {
         BufferedReader br = new BufferedReader(new FileReader(file));
         while(br.ready()) {
             String line = br.readLine();
             if(line.length()>2) {
                 if(line.startsWith("I")) {
                        afd.setEstadoInicial(
                            new Estado(line.substring(2)));
                        
                 }else if(line.startsWith("T")) {
                     line = line.substring(2,line.length()-1);
                     String str[] = line.split("-");
                     
                     Transicao t = new Transicao();
                     t.setEstOri(new Estado(str[0]));
                     t.setSimbolo(new Simbolo(str[1].charAt(0)));
                     t.setEstDest(new Estado(str[2]));
                     
                     afd.addTransicao(t);
                     
                 }else {
                     line = line.substring(2,line.length()-2);
                     
                     if(line.startsWith("E")) {
                        for(String s : line.split("-"))
                            afd.addSimbolo(new Simbolo(s.charAt(0)));

                     }else if(line.startsWith("S")) {                        
                         for(String e: line.split("-"))
                             afd.addEstado(new Estado(e));

                     }else if(line.startsWith("F")) {
                         for(String f : line.split("-"))
                             afd.addEstadoFinal(new Estado(f));

                     }                     
                 } // end else
             }                 
             
         }//end while
         
         br.close();
        }catch(Exception ex) {
            ex.printStackTrace();
            throw new OpenException("Erro Ao abrir modelo Formal");            
        }
        
        return afd;        
    }
    
     private AFND getAFND(File file) throws OpenException  {
        return new AFND();
    }
    
    public static OpenFormalModel getInstance() {
        return singleton;
    }
    
}