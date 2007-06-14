/*
 * CEstado.java
 *
 * Created on 8 de Junho de 2007, 19:27
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package cassolato.rafael.sctmf.view.components;

import cassolato.rafael.sctmf.model.pojo.Estado;
import java.util.Set;

/**
 *
 * @author Cassolato
 */
public interface CEstado {
    public abstract void addEstado(Estado estado);
    public abstract void remEstados(Set<Estado> estados);
    public abstract void removeAllItens();
}
