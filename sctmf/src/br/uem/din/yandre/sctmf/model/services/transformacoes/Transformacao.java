package br.uem.din.yandre.sctmf.model.services.transformacoes;

import br.uem.din.yandre.sctmf.model.pojo.ModeloFormal;

/**
 *
 * @author Fabio Schnaider Bortolotto
 */
public interface Transformacao {
    public void setModeloFormalOrigem (ModeloFormal mf);
    public ModeloFormal transformar() throws Exception;
}