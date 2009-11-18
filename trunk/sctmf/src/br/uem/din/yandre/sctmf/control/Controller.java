/*
 * Controller.java
 *
 * Created on 9 de Abril de 2007, 20:02
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.uem.din.yandre.sctmf.control;

import br.uem.din.yandre.sctmf.model.pojo.ModeloFormal;
import br.uem.din.yandre.sctmf.model.services.abrir.Abrir;
import br.uem.din.yandre.sctmf.model.services.abrir.AbrirException;
import br.uem.din.yandre.sctmf.model.services.abrir.AbrirModeloFormal;
import br.uem.din.yandre.sctmf.model.services.salvar.Salvar;
import br.uem.din.yandre.sctmf.model.services.salvar.SalvarException;
import br.uem.din.yandre.sctmf.model.services.salvar.SalvarModeloFormal;
import br.uem.din.yandre.sctmf.view.MainWindow;
import br.uem.din.yandre.sctmf.view.components.Splash;
import br.uem.din.yandre.sctmf.view.components.TrayIconManager;
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
            "* SCTMF - Software de Criação e Teste de Modelos Formais * v1.5";
    
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
            return open.abrir(arquivo);        
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
            save.salvar(arquivo, mf);
        } catch (SalvarException ex) {
            ex.printStackTrace();
        }
    }

}