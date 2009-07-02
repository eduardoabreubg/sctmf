/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.uem.din.yandre.sctmf.model.pojo;

import java.util.List;
import java.util.Set;

/**
 *
 * @author Fabio Schnaider Bortolotto
 */
public class GLCFNC extends GLC {
    @Override
    public void addRegraProducao(RegraProducao rp) {
        if (!isFNC(rp)) 
            return; // TODO: ver o q eu posso fazer aki c o cassolato //throw new Exception("Regra de produção " +rp.toString() +" é inválida");
        super.addRegraProducao(rp);
    }
    
    @Override
    public void setRegrasProducao(Set<RegraProducao> regrasProducao) {
        this.getRegrasProducao().clear();
        for (RegraProducao rp : regrasProducao) addRegraProducao(rp);
    }
    
    /**
     * Verifica se o lado direito da regra de produção está<br>
     * na forma normal de chomsky
     */
    private boolean isFNC(RegraProducao rp) {
        List<SimboloString> value = rp.getSimbLDireito();
        int tam = value.size();
        if(tam>2) return false;
        if(tam==1) {
            if(getSimbTerm().contains(value.get(0))  // A -> a
                    || (rp.getSimbLEsq().equals(getSimbInicial()) 
                    && GLC.LAMBDA.equals(value.get(0))))
                return true;
            else return false;
        
        } else if(getSimbNTerm().contains(value.get(0))&&
                getSimbNTerm().contains(value.get(1))) // A -> BC
            return true;
        else return false;
    }
}
