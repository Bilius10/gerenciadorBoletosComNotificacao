package com.boletos.Gerenciar.INFRA.GeradorBoleto;

public class PagadorInput {

    private Integer tipoInscricao;
    private Long numeroInscricao;
    private String nome;
    private String endereco;
    private Long cep;
    private String cidade;
    private String bairro;
    private String uf;
    private String telefone;

    public PagadorInput(Integer tipoInscricao, Long numeroInscricao, String nome,
                        String endereco, Long cep, String cidade, String bairro, String uf, String telefone) {
        this.tipoInscricao = tipoInscricao;
        this.numeroInscricao = numeroInscricao;
        this.nome = nome;
        this.endereco = endereco;
        this.cep = cep;
        this.cidade = cidade;
        this.bairro = bairro;
        this.uf = uf;
        this.telefone = telefone;
    }

    public PagadorInput() {
    }

    public Integer getTipoInscricao() {
        return tipoInscricao;
    }

    public void setTipoInscricao(Integer tipoInscricao) {
        this.tipoInscricao = tipoInscricao;
    }

    public Long getNumeroInscricao() {
        return numeroInscricao;
    }

    public void setNumeroInscricao(Long numeroInscricao) {
        this.numeroInscricao = numeroInscricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Long getCep() {
        return cep;
    }

    public void setCep(Long cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}