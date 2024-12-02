package com.boletos.Gerenciar.INFRA;

import java.math.BigDecimal;

public class CobrancaInput {

    private Long numeroConvenio;
    private Integer numeroCarteira;
    private Integer numeroVariacaoCarteira;
    private Integer codigoModalidade;
    private String dataEmissao; // dd.mm.aaaa
    private String dataVencimento; // dd.mm.aaaa
    private BigDecimal valorOriginal;
    private String valorAbatimento;
    private Integer quantidadeDiasProtesto;
    private Integer quantidadeDiasNegativacao;
    private String indicadorAceiteTituloVencido; // informações
    private Integer numeroDiasLimiteRecebimento;
    private char codigoAceite; // A ou N
    private Integer codigoTipoTitulo;
    private String descricaoTipoTitulo;
    private String indicadorPermissaoRecebimentoParcial; // S ou N
    private String numeroTituloBeneficiario;
    private String campoUtilizacaoBeneficiario;
    private String numeroTituloCliente;
    private String textoMensagemBloqueioOcorrencia;
    private String indicadorPix;

    public CobrancaInput(Long numeroConvenio, Integer numeroCarteira, Integer numeroVariacaoCarteira, Integer codigoModalidade,
                         String dataEmissao, String dataVencimento, BigDecimal valorOriginal, String valorAbatimento,
                         Integer quantidadeDiasProtesto, Integer quantidadeDiasNegativacao, String indicadorAceiteTituloVencido,
                         Integer numeroDiasLimiteRecebimento, char codigoAceite, Integer codigoTipoTitulo, String descricaoTipoTitulo,
                         String indicadorPermissaoRecebimentoParcial, String numeroTituloBeneficiario,
                         String campoUtilizacaoBeneficiario, String numeroTituloCliente, String textoMensagemBloqueioOcorrencia,
                         String indicadorPix) {
        this.numeroConvenio = numeroConvenio;
        this.numeroCarteira = numeroCarteira;
        this.numeroVariacaoCarteira = numeroVariacaoCarteira;
        this.codigoModalidade = codigoModalidade;
        this.dataEmissao = dataEmissao;
        this.dataVencimento = dataVencimento;
        this.valorOriginal = valorOriginal;
        this.valorAbatimento = valorAbatimento;
        this.quantidadeDiasProtesto = quantidadeDiasProtesto;
        this.quantidadeDiasNegativacao = quantidadeDiasNegativacao;
        this.indicadorAceiteTituloVencido = indicadorAceiteTituloVencido;
        this.numeroDiasLimiteRecebimento = numeroDiasLimiteRecebimento;
        this.codigoAceite = codigoAceite;
        this.codigoTipoTitulo = codigoTipoTitulo;
        this.descricaoTipoTitulo = descricaoTipoTitulo;
        this.indicadorPermissaoRecebimentoParcial = indicadorPermissaoRecebimentoParcial;
        this.numeroTituloBeneficiario = numeroTituloBeneficiario;
        this.campoUtilizacaoBeneficiario = campoUtilizacaoBeneficiario;
        this.numeroTituloCliente = numeroTituloCliente;
        this.textoMensagemBloqueioOcorrencia = textoMensagemBloqueioOcorrencia;
        this.indicadorPix = indicadorPix;
    }

    public CobrancaInput() {
    }

    public Long getNumeroConvenio() {
        return numeroConvenio;
    }

    public void setNumeroConvenio(Long numeroConvenio) {
        this.numeroConvenio = numeroConvenio;
    }

    public Integer getNumeroCarteira() {
        return numeroCarteira;
    }

    public void setNumeroCarteira(Integer numeroCarteira) {
        this.numeroCarteira = numeroCarteira;
    }

    public Integer getNumeroVariacaoCarteira() {
        return numeroVariacaoCarteira;
    }

    public void setNumeroVariacaoCarteira(Integer numeroVariacaoCarteira) {
        this.numeroVariacaoCarteira = numeroVariacaoCarteira;
    }

    public Integer getCodigoModalidade() {
        return codigoModalidade;
    }

    public void setCodigoModalidade(Integer codigoModalidade) {
        this.codigoModalidade = codigoModalidade;
    }

    public String getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(String dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public String getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(String dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public BigDecimal getValorOriginal() {
        return valorOriginal;
    }

    public void setValorOriginal(BigDecimal valorOriginal) {
        this.valorOriginal = valorOriginal;
    }

    public String getValorAbatimento() {
        return valorAbatimento;
    }

    public void setValorAbatimento(String valorAbatimento) {
        this.valorAbatimento = valorAbatimento;
    }

    public Integer getQuantidadeDiasProtesto() {
        return quantidadeDiasProtesto;
    }

    public void setQuantidadeDiasProtesto(Integer quantidadeDiasProtesto) {
        this.quantidadeDiasProtesto = quantidadeDiasProtesto;
    }

    public Integer getQuantidadeDiasNegativacao() {
        return quantidadeDiasNegativacao;
    }

    public void setQuantidadeDiasNegativacao(Integer quantidadeDiasNegativacao) {
        this.quantidadeDiasNegativacao = quantidadeDiasNegativacao;
    }

    public String getIndicadorAceiteTituloVencido() {
        return indicadorAceiteTituloVencido;
    }

    public void setIndicadorAceiteTituloVencido(String indicadorAceiteTituloVencido) {
        this.indicadorAceiteTituloVencido = indicadorAceiteTituloVencido;
    }

    public Integer getNumeroDiasLimiteRecebimento() {
        return numeroDiasLimiteRecebimento;
    }

    public void setNumeroDiasLimiteRecebimento(Integer numeroDiasLimiteRecebimento) {
        this.numeroDiasLimiteRecebimento = numeroDiasLimiteRecebimento;
    }

    public char getCodigoAceite() {
        return codigoAceite;
    }

    public void setCodigoAceite(char codigoAceite) {
        this.codigoAceite = codigoAceite;
    }

    public Integer getCodigoTipoTitulo() {
        return codigoTipoTitulo;
    }

    public void setCodigoTipoTitulo(Integer codigoTipoTitulo) {
        this.codigoTipoTitulo = codigoTipoTitulo;
    }

    public String getDescricaoTipoTitulo() {
        return descricaoTipoTitulo;
    }

    public void setDescricaoTipoTitulo(String descricaoTipoTitulo) {
        this.descricaoTipoTitulo = descricaoTipoTitulo;
    }

    public String getIndicadorPermissaoRecebimentoParcial() {
        return indicadorPermissaoRecebimentoParcial;
    }

    public void setIndicadorPermissaoRecebimentoParcial(String indicadorPermissaoRecebimentoParcial) {
        this.indicadorPermissaoRecebimentoParcial = indicadorPermissaoRecebimentoParcial;
    }

    public String getNomeTituloBeneficiario() {
        return numeroTituloBeneficiario;
    }

    public void setNomeTituloBeneficiario(String numeroTituloBeneficiario) {
        this.numeroTituloBeneficiario = numeroTituloBeneficiario;
    }

    public String getCampoUtilizacaoBeneficiario() {
        return campoUtilizacaoBeneficiario;
    }

    public void setCampoUtilizacaoBeneficiario(String campoUtilizacaoBeneficiario) {
        this.campoUtilizacaoBeneficiario = campoUtilizacaoBeneficiario;
    }

    public String getNumeroTituloCliente() {
        return numeroTituloCliente;
    }

    public void setNumeroTituloCliente(String numeroTituloCliente) {
        this.numeroTituloCliente = numeroTituloCliente;
    }

    public String getTextoMensagemBloqueioOcorrencia() {
        return textoMensagemBloqueioOcorrencia;
    }

    public void setTextoMensagemBloqueioOcorrencia(String textoMensagemBloqueioOcorrencia) {
        this.textoMensagemBloqueioOcorrencia = textoMensagemBloqueioOcorrencia;
    }

    public String getIndicadorPix() {
        return indicadorPix;
    }

    public void setIndicadorPix(String indicadorPix) {
        this.indicadorPix = indicadorPix;
    }
}

