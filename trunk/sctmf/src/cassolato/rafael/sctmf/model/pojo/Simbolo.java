/*
 * Simbolo.java
 *
 * Created on 7 de Maio de 2007, 20:17
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package cassolato.rafael.sctmf.model.pojo;

/**
 *
 * @author Cassolato
 */
public class Simbolo {
    private Character nome;
    
    /** Creates a new instance of Simbolo */
    public Simbolo(Character nome) {
        this.nome = nome;
    }  

    public Character getNome() {
        return nome;
    }    
}