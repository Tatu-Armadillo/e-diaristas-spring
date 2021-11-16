package br.com.treinaweb.ediaristas.dtos;

public class ViaCepResponse {

    private String cep;

    private String logradouro;

    private String uf;

    private String localidade;

    private String complemento;

    private String bairro;

    private String ibge;

    public ViaCepResponse() { }

    public ViaCepResponse(String cep, String logradouro, String uf, String localidade, String complemento,
            String bairro, String ibge) {
        this.cep = cep;
        this.logradouro = logradouro;
        this.uf = uf;
        this.localidade = localidade;
        this.complemento = complemento;
        this.bairro = bairro;
        this.ibge = ibge;
    }

    @Override
    public String toString() {
        return "CEP: " + cep + ", logradoururo: " + logradouro + ", UF: " + cep + ", localidade: " + ", Bairro: " + bairro + ", IBGE: " + ibge;
    }

    // #region Getters and Setters
    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getIbge() {
        return ibge;
    }

    public void setIbge(String ibge) {
        this.ibge = ibge;
    }

    // #endregion
}
