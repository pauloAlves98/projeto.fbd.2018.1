/*
 * PARG Desenvolvimento de Sistemas
 * Pablo Alexander - pablo@parg.com.br
 * 
 * Obtem um CEP no ViaCEP
 */
package br.com.pauloAlves_felipeAntonio.projeto_fbd.parg.viacep;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Classe java para obter um CEP no ViaCEP
 *
 * @author Pablo Alexander da Rocha Gonçalves
 */
public class ViaCEP extends ViaCEPBase {

    // constantes
    public static final double VIACEP_VERSAO = 0.32;

    /**
     * Constrói uma nova classe
     */
    public ViaCEP() {
        super();
    }

    /**
     * Constrói uma nova classe
     *
     * @param events eventos para a classe
     */
    public ViaCEP(ViaCEPEvents events) {
        super();
        this.Events = events;
    }

    /**
     * Constrói uma nova classe e busca um CEP no ViaCEP
     *
     * @param events eventos para a classe
     * @param cep
     * @throws br.com.parg.viacep.ViaCEPException caso ocorra algum erro
     */
    public ViaCEP(String cep, ViaCEPEvents events) throws ViaCEPException {
        super();
        this.Events = events;
        this.buscar(cep);
    }

    /**
     * Constrói uma nova classe e busca um CEP no ViaCEP
     *
     * @param cep
     * @throws br.com.parg.viacep.ViaCEPException caso ocorra algum erro
     */
    public ViaCEP(String cep) throws ViaCEPException {
        super();
        this.buscar(cep);
    }

    /**
     * Busca um CEP no ViaCEP
     *
     * @param cep
     * @throws br.com.parg.viacep.ViaCEPException caso ocorra algum erro
     */
    @Override
    public final void buscar(String cep) throws ViaCEPException {
        // define o cep atual
        currentCEP = cep;

        // define a url
        String url = "http://viacep.com.br/ws/" + cep + "/json/";

        // define os dados
        JSONObject obj = new JSONObject(getHttpGET(url));

        if (!obj.has("erro")) {
            CEP novoCEP = new CEP(obj.getString("cep"),
                    obj.getString("logradouro"),
                    obj.getString("complemento"),
                    obj.getString("bairro"),
                    obj.getString("localidade"),
                    obj.getString("uf"),
                    obj.getString("ibge"),
                    obj.getString("gia"));

            // insere o novo CEP
            CEPs.add(novoCEP);

            // atualiza o index
            index = CEPs.size() - 1;

            // verifica os Eventos
            if (Events instanceof ViaCEPEvents) {
                Events.onCEPSuccess(this);
            }
        } else {
            // verifica os Eventos
            if (Events instanceof ViaCEPEvents) {
                Events.onCEPError(currentCEP);
            }

            throw new ViaCEPException("Não foi possível encontrar o CEP", cep, ViaCEPException.class.getName());
        }
    }

    /**
     * Busca um CEP usando um endereço
     *
     * @param cep classe CEP com uf, localidade, logradouro
     * @throws ViaCEPException
     */
    @Override
    public void buscarCEP(CEP cep) throws ViaCEPException {
        // define o cep atual
        currentCEP = "?????-???";

        // define a url
        String url = "http://viacep.com.br/ws/" + cep.Uf.toUpperCase() + "/" + cep.Localidade + "/" + cep.Logradouro + "/json/";

        // obtem a lista de CEP's
        JSONArray ceps = new JSONArray(getHttpGET(url));

        if (ceps.length() > 0) {
            for (int i = 0; i < ceps.length(); i++) {
                JSONObject obj = ceps.getJSONObject(i);

                if (!obj.has("erro")) {
                    CEP novoCEP = new CEP(obj.getString("cep"),
                            obj.getString("logradouro"),
                            obj.getString("complemento"),
                            obj.getString("bairro"),
                            obj.getString("localidade"),
                            obj.getString("uf"),
                            obj.getString("ibge"),
                            obj.getString("gia"));

                    // insere o novo CEP
                    CEPs.add(novoCEP);

                    // atualiza o index
                    index = CEPs.size() - 1;

                    // verifica os Eventos
                    if (Events instanceof ViaCEPEvents) {
                        Events.onCEPSuccess(this);
                    }
                } else {
                    // verifica os Eventos
                    if (Events instanceof ViaCEPEvents) {
                        Events.onCEPError(currentCEP);
                    }

                    throw new ViaCEPException("Não foi possível validar o CEP", currentCEP, ViaCEPException.class.getName());
                }
            }
        } else {
            throw new ViaCEPException("Nenhum CEP encontrado", currentCEP, getClass().getName());
        }
    }
}
