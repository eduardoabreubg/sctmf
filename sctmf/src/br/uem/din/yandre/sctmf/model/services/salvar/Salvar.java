/*
 * Salvar.java
 *
 * Created on 18 de Abril de 2007, 09:13
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.uem.din.yandre.sctmf.model.services.salvar;

import br.uem.din.yandre.sctmf.model.pojo.ModeloFormal;
import br.uem.din.yandre.sctmf.model.services.salvar.SalvarException;
import java.io.File;


/**
 *
 * @author rafael2009_00
 */
public interface Salvar {
    public void salvar(File arquivo, ModeloFormal mf) throws SalvarException;
}
