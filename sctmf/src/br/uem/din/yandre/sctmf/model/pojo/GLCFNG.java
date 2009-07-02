package br.uem.din.yandre.sctmf.model.pojo;

import java.util.List;
import java.util.Set;

/**
 *
 * @author Fabio Schnaider Bortolotto
 */
public class GLCFNG extends GLC{
    @Override
    public void addRegraProducao(RegraProducao rp) {
        if (!isFNG(rp)) 
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
     * na forma normal de Greibach
     */
    private boolean isFNG(RegraProducao rp) {
        List<SimboloString> value = rp.getSimbLDireito();
        return value.size() > 0 ?getSimbTerm().contains(value.get(0)) 
                : (rp.getSimbLEsq().equals(getSimbInicial()) 
                && GLC.LAMBDA.equals(value.get(0)));
    }
}