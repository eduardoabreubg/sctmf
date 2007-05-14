/*
 * Save.java
 *
 * Created on 11 de Abril de 2007, 09:57
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
import java.io.File;
import java.io.FileWriter;

/**
 *
 * @author rafael2009_00
 */
public class SaveFormalModel implements Save {
    private FileWriter fw;
    private File file;
    
    /** Creates a new instance of Save */
    public SaveFormalModel() {
    }
    
    public void save(File file, FormalModel fm) throws SaveException {
        this.file = file;
        
        try {
            this.saveAFD((AFD)fm);   
            
        }catch(ClassCastException exAfd) {
            try {                
                this.saveAFND((AFND)fm);              
                
            }catch(ClassCastException exAfnd) {
                exAfnd.printStackTrace();
            }
        }
        
    }
    
    private void saveAFD(AFD afd) throws SaveException {
        StringBuffer sb = new StringBuffer();
        
        sb.append("E:");  // Add Simbolos
        for(Simbolo s : afd.getSimbolos())
            sb.append(s.getNome()+"-");     
                       
        sb.append("\nS:");
        for(Estado e : afd.getEstados())
            sb.append(e.getNome()+"-");          
                       
        Estado aux = afd.getEstadoInicial();
        sb.append("\nI:");
        if(aux!=null)
             sb.append(aux.getNome());        
                        
        sb.append("\nF:");
        for(Estado e : afd.getEstadosFinais())
            sb.append(e.getNome()+"-"); 
                
        for(Transicao t : afd.getTransicoes())
        sb.append("\nT:"+
                t.getEstOri().getNome()+"-"+
                t.getSimbolo().getNome()+"-"+
                t.getEstDest().getNome()); 
    
        try {         
            this.writeInFile(
                    new File(
                        this.file.getPath()+".afd"),sb.toString());
            
            this.showOkMessage("AFD");
        }catch(Exception ioex) {
            throw new SaveException("Erro ao Salvar AFD");
        }
    }
    
    private void saveAFND(AFND afnd) throws SaveException {
        
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
                nameFormalModel+" Salvo com Sucesso", "Operação Concluída",
                javax.swing.JOptionPane.INFORMATION_MESSAGE);
        
    }
    
}
