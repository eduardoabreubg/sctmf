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
import cassolato.rafael.sctmf.model.pojo.FormalModel;
import java.io.File;

/**
 *
 * @author rafael2009_00
 */
public class SaveFormalModel implements Save {
    private static SaveFormalModel singleton = null;
    private File file;
    
    /** Creates a new instance of Save */
    private SaveFormalModel() {}
    
    public void save(File file, FormalModel fm) throws SaveException {
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
        throw new SaveException("Erro ao Salvar AFD");
    }
    
    private void saveAFND(AFND afnd) throws SaveException {
        
    }
    
    public static SaveFormalModel getInstance() {
        if(singleton==null)
            singleton = new SaveFormalModel();
        
        return singleton;
    }
}
