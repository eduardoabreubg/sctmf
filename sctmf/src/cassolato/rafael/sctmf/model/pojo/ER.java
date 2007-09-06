/*
 * ER.java
 *
 * Created on 6 de Setembro de 2007, 10:13
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
public class ER extends ModeloFormal {
    
    private Set<Simbolo> alfabeto = new LinkedHashSet<Simbolo>();
    private String expressaoRegular;
    
    /** Creates a new instance of ER */
    public ER() {
    }

    public Set<Simbolo> getAlfabeto() {
        return alfabeto;
    }

    public void setAlfabeto(Set<Simbolo> alfabeto) {
        this.alfabeto = alfabeto;
    }

    public String getExpressaoRegular() {
        return expressaoRegular;
    }

    public void setExpressaoRegular(String expressaoRegular) {
        this.expressaoRegular = expressaoRegular;
    }
    
    public void addSimboAlf(Simbolo s) {
        this.alfabeto.add(s);
    }
}
