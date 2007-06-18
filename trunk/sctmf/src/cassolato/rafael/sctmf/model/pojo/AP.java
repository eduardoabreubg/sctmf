/*
 * AP.java
 *
 * Created on 16 de Junho de 2007, 13:30
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package cassolato.rafael.sctmf.model.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cassolato
 */
public class AP extends AFD {
    
    private List<Simbolo> alfabetoPilha = new ArrayList<Simbolo>();
    private Simbolo simbBasePilha; 
    
    /** Creates a new instance of AP */
    public AP() {
    }
    
}
