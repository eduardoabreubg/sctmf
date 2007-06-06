/*
 * Abrir.java
 *
 * Created on 18 de Abril de 2007, 09:14
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package cassolato.rafael.sctmf.model.services.abrir;

import cassolato.rafael.sctmf.model.pojo.ModeloFormal;
import cassolato.rafael.sctmf.model.services.*;
import java.io.File;

/**
 *
 * @author rafael2009_00
 */
public interface Abrir {
    public ModeloFormal abrirModeloFormal(File arquivo) throws AbrirException;
}
