/*
 * Salvar.java
 *
 * Created on 11 de Abril de 2007, 09:57
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package cassolato.rafael.sctmf.model.services.salvar;

import cassolato.rafael.sctmf.model.pojo.AFD;
import cassolato.rafael.sctmf.model.pojo.AFND;
import cassolato.rafael.sctmf.model.pojo.Estado;
import cassolato.rafael.sctmf.model.pojo.ModeloFormal;
import cassolato.rafael.sctmf.model.pojo.Simbolo;
import cassolato.rafael.sctmf.model.pojo.Transicao;
import cassolato.rafael.sctmf.model.services.salvar.Salvar;
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
    
    public void salvarModeloFormal(File file, ModeloFormal fm) throws SalvarException {
        this.file = file;
        
        if(fm instanceof AFD)
            this.salvarAFD((AFD)fm);   
            
        else if(fm instanceof AFND)
            this.salvarAFND((AFND)fm);              
                        
    }
    
    private void salvarAFD(AFD afd) throws SalvarException {
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
            throw new SalvarException("Erro ao Salvar AFD");
        }
    }
    
    private void salvarAFND(AFND afnd) throws SalvarException {
        StringBuffer sb = new StringBuffer();
        
        sb.append("E:");  // Add Simbolos
        for(Simbolo s : afnd.getSimbolos())
            sb.append(s.getNome()+"-");     
                       
        sb.append("\nS:");
        for(Estado e : afnd.getEstados())
            sb.append(e.getNome()+"-");          
                       
        sb.append("\nI:");
        for(Estado ei : afnd.getEstadosIniciais())
            sb.append(ei.getNome()+"-"); 
                        
        sb.append("\nF:");
        for(Estado e : afnd.getEstadosFinais())
            sb.append(e.getNome()+"-"); 
                
        for(Transicao t : afnd.getTransicoes())
        sb.append("\nT:"+
                t.getEstOri().getNome()+"-"+
                t.getSimbolo().getNome()+"-"+
                t.getEstDest().getNome()); 
    
        try {         
            this.writeInFile(
                    new File(
                        this.file.getPath()+".afnd"),sb.toString());
            
            this.showOkMessage("AFND");
        }catch(Exception ioex) {
            throw new SalvarException("Erro ao Salvar AFND");
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
                nameFormalModel+" Salvo com Sucesso", "Opera��o Conclu�da",
                javax.swing.JOptionPane.INFORMATION_MESSAGE);
        
    }
    
}
