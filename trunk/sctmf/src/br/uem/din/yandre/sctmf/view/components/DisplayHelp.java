/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.uem.din.yandre.sctmf.view.components;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author michelmenega
 */
public class DisplayHelp {

    public DisplayHelp(){
    
    JFrame frame = new JFrame();
    //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container con = frame.getContentPane();

    JEditorPane jep = new JEditorPane();
    JScrollPane jsp = new JScrollPane(jep);
    con.add(jsp);

    jep.setContentType("text/html");
    try{
    jep.setPage("http://www.din.uem.br/~yandre/sctmf/HELP.html");
    }
    catch (Exception e){
      e.printStackTrace();
    }
    frame.setTitle("HELP - SCTMF *v1.0");
    frame.setBounds(50, 50, 800, 600);
    frame.setVisible(true);
    }
}
