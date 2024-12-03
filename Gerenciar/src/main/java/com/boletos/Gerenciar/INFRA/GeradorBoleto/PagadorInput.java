package com.boletos.Gerenciar.INFRA.GeradorBoleto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

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


}