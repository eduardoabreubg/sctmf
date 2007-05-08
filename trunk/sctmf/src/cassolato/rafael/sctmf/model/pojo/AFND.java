/*
 * AFND.java
 *
 * Created on 9 de Abril de 2007, 08:35
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package cassolato.rafael.sctmf.model.pojo;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 *
 * @author rafael2009_00
 */
public class AFND extends Automato {
    private Set<Estado> estadosIniciais = new LinkedHashSet<Estado>();
    
    /** Creates a new instance of AFND */
    public AFND() {
    }
    
    public void addEstadoInicial(Estado ei) {
        estadosIniciais.add(ei);        
    }
    
    public void removeEstadoInicial(Estado ei) {
        estadosIniciais.remove(ei);        
    }
    
}