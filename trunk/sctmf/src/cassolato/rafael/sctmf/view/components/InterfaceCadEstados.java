/*
 * InterfaceCadEstados.java
 *
 * Created on 6 de Junho de 2007, 19:36
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package cassolato.rafael.sctmf.view.components;

import cassolato.rafael.sctmf.model.pojo.Estado;
import java.util.Set;

/**
 * Interface para o Cadastramento de Estados, toda a classe que usar o componente
 * para cadastramento de estados, necessita implementar essa interface.
 *
 * @author Cassolato
 */
public interface InterfaceCadEstados {
    public abstract void addEstado(Estado estado);
    public abstract void remEstados(Set<Estado> estados);
}
