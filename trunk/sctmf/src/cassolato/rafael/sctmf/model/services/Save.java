/*
 * Save.java
 *
 * Created on 18 de Abril de 2007, 09:13
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package cassolato.rafael.sctmf.model.services;

import cassolato.rafael.sctmf.model.pojo.FormalModel;
import java.io.File;

/**
 *
 * @author rafael2009_00
 */
public interface Save {
    public void save(File file, FormalModel fm) throws SaveException;
}
