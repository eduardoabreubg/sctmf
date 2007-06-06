/*
 * Salvar.java
 *
 * Created on 18 de Abril de 2007, 09:13
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package cassolato.rafael.sctmf.model.services.salvar;

import cassolato.rafael.sctmf.model.pojo.ModeloFormal;
import cassolato.rafael.sctmf.model.services.salvar.SalvarException;
import java.io.File;


/**
 *
 * @author rafael2009_00
 */
public interface Salvar {
    public void salvarModeloFormal(File arquivo, ModeloFormal fm) throws SalvarException;
}
