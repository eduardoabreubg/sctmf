/*
 * Validacao.java
 *
 * Created on 14 de Maio de 2007, 10:10
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.uem.din.yandre.sctmf.model.services;

import br.uem.din.yandre.sctmf.model.pojo.ModeloFormal;

/**
 *
 * @author rafael2009_00
 */
public interface Validacao {
    void valida(ModeloFormal mf, String sequencia);
}
