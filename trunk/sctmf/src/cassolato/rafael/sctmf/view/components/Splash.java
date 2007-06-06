/*
 * Splash.java
 *
 * Created on 9 de Abril de 2007, 19:44
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package cassolato.rafael.sctmf.view.components;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.Window;

/**
 *
 * @author Cassolato
 */
public class Splash extends Window {
    
    // Imagem que ira aparecer no Splash
    private final String imgName = 
            "/cassolato/rafael/sctmf/view/icons/java2.jpg";
    private Image splashImage;
    private Toolkit toolkit;
    private static Splash singleton;
   
    private Splash() {
        super(new java.awt.Frame());
        setVisible(false);
        
        splashImage = null;
        toolkit = Toolkit.getDefaultToolkit();
    }
    
    /**
     * Singleton
     */
    public static Splash getInstance() {
        if(singleton == null)
            singleton = new Splash();
        
        return singleton;
    }
    
    /**
     * Method initSplash.
     */
    private void initSplash() {
        // Carrega a imagem na memoria
        MediaTracker media = new MediaTracker(this);
        splashImage = toolkit.getImage(getClass().getResource(imgName));
        
        if (splashImage != null) {
            media.addImage(splashImage, 0);
            
            try {
                media.waitForID(0);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
        
        // Configura o tamanho do splash e a posicao na tela
        setSize(splashImage.getWidth(this), splashImage.getHeight(this));
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension size = getSize();
        
        if (size.width > screenSize.width)
            size.width = screenSize.width;
        
        if (size.height > screenSize.height)
            size.height = screenSize.height;
        
        setLocation((screenSize.width - size.width) / 2, (screenSize.height - size.height) / 2);
        setVisible(true);
    }
    
    /**
     * Abre o splash
     */
    public void openSplash() {
        setCursor(new Cursor(Cursor.WAIT_CURSOR));
        initSplash();
    }
    
    /**
     * Finaliza o Splash
     */
    public void finish() {
        setVisible(false);
        dispose();
    }
    
    /**
     * Reescreve o metodo paint
     */
    public void paint(Graphics g) {        
        g.drawImage(splashImage, 0, 0, getBackground(), this);
    }
       
}