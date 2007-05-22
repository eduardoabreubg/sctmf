/*
 * Controller.java
 *
 * Created on 9 de Abril de 2007, 20:02
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package cassolato.rafael.sctmf.control;

import cassolato.rafael.sctmf.model.pojo.FormalModel;
import cassolato.rafael.sctmf.model.services.open.Open;
import cassolato.rafael.sctmf.model.services.open.OpenException;
import cassolato.rafael.sctmf.model.services.open.OpenFormalModel;
import cassolato.rafael.sctmf.model.services.Save;
import cassolato.rafael.sctmf.model.services.save.SaveException;
import cassolato.rafael.sctmf.model.services.save.SaveFormalModel;
import cassolato.rafael.sctmf.view.MainWindow;
import cassolato.rafael.sctmf.view.components.Splash;
import cassolato.rafael.sctmf.view.components.TrayIconManager;

/**
 *
 * @author Cassolato
 */
public class Controller {
    
    private Open open = new OpenFormalModel();
    private Save save = new SaveFormalModel();
    private MainWindow gui = null;
    private final String GUI_TITLE = 
            "* SCTMF - Sistema de Criação e Testes de Modelos Formais * v0.1";
    
    /** Creates a new instance of Controller */
    public Controller() {
        Splash.getInstance().openSplash(); // Open Splash      
        
        gui = new MainWindow(this);        // Create a instance of GUI        
        gui.setTitle(GUI_TITLE);
        
        new TrayIconManager(gui);          // Call TrayIcon
        
        gui.setVisible(true);
        
        Splash.getInstance().finish(); // Close Splash
    }
    
    /**
     * Envia para o model, o modelo formal a ser salvo
     *
     */    
    public void saveFormalModel(java.io.File file, FormalModel fm) {         
        try {            
            save.save(file, fm);
        } catch (SaveException ex) {
            ex.printStackTrace();
        }
    }
    
    public FormalModel openFormalModel(java.io.File file) {        
        try {
            return open.open(file);        
        } catch (OpenException ex) {
            ex.printStackTrace();
            return null;
        }        
    }
    
}
