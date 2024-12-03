package com.boletos.Gerenciar.INFRA.GeradorBoleto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
    private DescontoInput desconto;
    private JurosInput jurosMora;
    private MultaInput multa;
    private PagadorInput pagador;


}

