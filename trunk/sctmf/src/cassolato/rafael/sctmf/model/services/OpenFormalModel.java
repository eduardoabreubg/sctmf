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
import cassolato.rafael.sctmf.model.pojo.FormalModel;
import cassolato.rafael.sctmf.model.pojo.Simbolo;
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
             if(line.startsWith("Simbolos -> ")) {
                 String[] simbolos = line.split("-");
                 afd.addSimbolo(new Simbolo(simbolos[1].charAt(0)));
                 afd.addSimbolo(new Simbolo(simbolos[2].charAt(0)));
             }
         }
         
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