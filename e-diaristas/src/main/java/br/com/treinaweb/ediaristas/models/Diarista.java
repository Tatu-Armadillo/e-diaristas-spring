package br.com.treinaweb.ediaristas.models;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.hibernate.validator.constraints.br.CPF;

import br.com.treinaweb.ediaristas.controllers.FileController;
import br.com.treinaweb.ediaristas.converters.CepConverter;
import br.com.treinaweb.ediaristas.converters.CpfConverter;
import br.com.treinaweb.ediaristas.converters.TelefoneConverter;
import lombok.EqualsAndHashCode;

@Entity
public class Diarista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @NotNull
    @Size(min = 3, max = 100)
    @Column(nullable = false, length = 100)
    @JsonProperty("nome_completo")
    private String nomeCompleto;

    @NotNull
    @Size(min = 11, max = 14)
    @CPF
    @Column(nullable = false, length = 11, unique = true)
    @Convert(converter = CpfConverter.class)
    @JsonIgnore
    private String cpf;

    @NotNull
    @NotEmpty
    @Email
    @Column(nullable = false, unique = true)
    @JsonIgnore
    private String email;

    @NotNull
    @Size(min = 11, max = 15)
    @Column(nullable = false, length = 11)
    @Convert(converter = TelefoneConverter.class)
    @JsonIgnore
    private String telefone;

    @NotNull
    @NotEmpty
    @Column(nullable = false)
    @JsonIgnore
    private String logradouro;

    @NotNull
    @NotEmpty
    @Column(nullable = false)
    @JsonIgnore
    private String numero;

    @NotNull
    @NotEmpty
    @Column(nullable = false)
    @JsonIgnore
    private String bairro;

    @Column(nullable = true)
    @JsonIgnore
    private String complemento;

    @NotNull
    @Size(min = 8, max = 9)
    @Column(nullable = false, length = 8)
    @Convert(converter = CepConverter.class)
    @JsonIgnore
    private String cep;

    @NotNull
    @NotEmpty
    @Column(nullable = false)
    private String cidade;

    @NotNull
    @Size(min = 2, max = 2)
    @Column(nullable = false, length = 2)
    @JsonIgnore
    private String estado;

    @Column(nullable = false)
    @JsonIgnore
    private String codigoIbge;

    @Column(nullable = false)
    @JsonIgnore
    private String foto;

    @JsonProperty("foto_usuario")
    public String getFotoUrl() throws IOException {
        return linkTo(methodOn(FileController.class).file(this.foto)).toString();
    }
    
    @JsonProperty("reputacao")
    public Integer getReputacao() throws IOException {
        return ThreadLocalRandom.current().nextInt(0, 6);
    }

    public Diarista() {}

    public Diarista(Long id, String nomeCompleto, String cpf, String email, String telefone, String logradouro,
            String numero, String bairro, String complemento, String cep, String cidade, String estado,
            String codigoIbge, String foto) {
        this.id = id;
        this.nomeCompleto = nomeCompleto;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.complemento = complemento;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
        this.codigoIbge = codigoIbge;
        this.foto = foto;
    }

    public Diarista(String nomeCompleto, String cpf, String email, String telefone, String logradouro, String numero,
            String bairro, String complemento, String cep, String cidade, String estado, String codigoIbge,
            String foto) {
        this.nomeCompleto = nomeCompleto;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.complemento = complemento;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
        this.codigoIbge = codigoIbge;
        this.foto = foto;
    }

    // #region Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCodigoIbge() {
        return codigoIbge;
    }

    public void setCodigoIbge(String codigoIbge) {
        this.codigoIbge = codigoIbge;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
    // #endregion

}
