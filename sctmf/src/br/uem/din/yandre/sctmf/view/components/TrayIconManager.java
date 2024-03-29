/*
 * TrayIconManager.java
 *
 * Created on 9 de Abril de 2007, 20:33
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.uem.din.yandre.sctmf.view.components;

import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author Cassolato
 */
public class TrayIconManager {
    
    /**
     * Creates a new instance of TrayIconManager
     */
    public TrayIconManager(final JFrame gui) {
        
        final TrayIcon trayIcon;
        
        if (SystemTray.isSupported()) {
            
            SystemTray tray = SystemTray.getSystemTray();
            
            Image image = Toolkit.getDefaultToolkit().getImage(
                    getClass().getResource("java_tray.gif"));
                        
            PopupMenu popup = new PopupMenu();
            MenuItem miSair = new MenuItem("Sair");
            MenuItem miHide = new MenuItem("Hide");
            MenuItem miShow = new MenuItem("Show");
            MenuItem miSobre = new MenuItem("Sobre");
            
            miSair.addActionListener( new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {                    
                    int i = javax.swing.JOptionPane.showOptionDialog(
                            null, "Deseja Sair do Sistema ?", "",   
                        javax.swing.JOptionPane.YES_NO_OPTION,
                        javax.swing.JOptionPane.QUESTION_MESSAGE,   
                        null, new String[]{"Sim","N�o"}, null);
        
                    if(i==0) {
                        gui.setVisible(false);
                        System.exit(0);
                    }
                        
                }
            });
            
            miHide.addActionListener( new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    gui.setVisible(false);
                }
            });
            
            miShow.addActionListener( new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    gui.setVisible(true);
                    gui.toFront();
                    gui.requestFocus();
                }
            });
            
            miSobre.addActionListener( new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    new SobreGUI(null,true);
                }
            });            
                       
            popup.add(miSair);
            popup.add(miHide);
            popup.add(miShow);
            popup.add(miSobre);
            
            trayIcon = new TrayIcon(image, gui.getTitle(), popup);
            
            trayIcon.setImageAutoSize(true);
            
            trayIcon.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    gui.toFront();
                    gui.requestFocus();
                }
            });
            
            try {
                tray.add(trayIcon);
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        } else
            System.err.println("System tray is currently not supported.");
        
    }    
}