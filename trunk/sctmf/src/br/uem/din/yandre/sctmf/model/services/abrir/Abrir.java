/*
 * Abrir.java
 *
 * Created on 18 de Abril de 2007, 09:14
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.uem.din.yandre.sctmf.model.services.abrir;

import br.uem.din.yandre.sctmf.model.pojo.ModeloFormal;
import java.io.File;

/**
 *
 * @author rafael2009_00
 */
public interface Abrir {
    public ModeloFormal abrir(File arquivo) throws AbrirException;
}
