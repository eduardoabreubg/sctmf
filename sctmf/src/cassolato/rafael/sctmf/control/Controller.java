/*
 * Controller.java
 *
 * Created on 9 de Abril de 2007, 20:02
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package cassolato.rafael.sctmf.control;

import cassolato.rafael.sctmf.model.pojo.ModeloFormal;
import cassolato.rafael.sctmf.model.services.abrir.Abrir;
import cassolato.rafael.sctmf.model.services.abrir.AbrirException;
import cassolato.rafael.sctmf.model.services.abrir.AbrirModeloFormal;
import cassolato.rafael.sctmf.model.services.salvar.Salvar;
import cassolato.rafael.sctmf.model.services.salvar.SalvarException;
import cassolato.rafael.sctmf.model.services.salvar.SalvarModeloFormal;
import cassolato.rafael.sctmf.view.MainWindow;
import cassolato.rafael.sctmf.view.components.Splash;
import cassolato.rafael.sctmf.view.components.TrayIconManager;
import java.io.File;

/**
 *
 * @author Cassolato
 */
public class Controller {
    
    private Abrir open = new AbrirModeloFormal();
    private Salvar save = new SalvarModeloFormal();
    private MainWindow gui = null;
    private final String GUI_TITLE = 
            "* SCTMF - Sistema de Criação e Testes de Modelos Formais * v0.1";
    
    /** Creates a new instance of Controller */
    public Controller() {
        Splash.getInstance().openSplash(); // Abrir Splash      
        
        gui = new MainWindow(this);        // Create a instance of GUI        
        gui.setTitle(GUI_TITLE);
        
        new TrayIconManager(gui);          // Call TrayIcon
        
        gui.setVisible(true);
        
        Splash.getInstance().finish(); // Close Splash
    }
    
    public ModeloFormal abrirModeloFormal(java.io.File arquivo) {        
        try {
            return open.abrirModeloFormal(arquivo);        
        } catch (AbrirException ex) {
            ex.printStackTrace();
            return null;
        }        
    }

    /**
     * Envia para o model, o modelo formal a ser salvo
     *
     */ 
    public void salvarModeloFormal(File arquivo, ModeloFormal mf) {
         try {            
            save.salvarModeloFormal(arquivo, mf);
        } catch (SalvarException ex) {
            ex.printStackTrace();
        }
    }

}