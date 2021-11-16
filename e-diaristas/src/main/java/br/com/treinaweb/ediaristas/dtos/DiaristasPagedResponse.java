package br.com.treinaweb.ediaristas.dtos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.treinaweb.ediaristas.models.Diarista;

public class DiaristasPagedResponse {

    private List<Diarista> diaristas;

    @JsonProperty("quantidade_diaristas")
    private Long quantidadeDiaristas;

    public DiaristasPagedResponse() { }

    public DiaristasPagedResponse(List<Diarista> diaristas, Long quantidadeDiaristas) {
        this.diaristas = diaristas;
        this.quantidadeDiaristas = quantidadeDiaristas;
    }
    // #region Getters and Setters

    public List<Diarista> getDiaristas() {
        return diaristas;
    }

    public void setDiaristas(List<Diarista> diaristas) {
        this.diaristas = diaristas;
    }

    public Long getQuantidadeDiaristas() {
        return quantidadeDiaristas;
    }

    public void setQuantidadeDiaristas(Long quantidadeDiaristas) {
        this.quantidadeDiaristas = quantidadeDiaristas;
    }

    // #endregion
}
