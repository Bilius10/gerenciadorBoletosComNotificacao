package com.boletos.Gerenciar.UTIL;

import com.boletos.Gerenciar.ENTITY.UsuarioEntity;
import org.springframework.util.StringUtils;

import java.text.Normalizer;

public class Normalizador {

    public static String norm(String str) {
        return Normalizer.normalize(str.trim(), Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "").toUpperCase();
    }

    public static String abreviar(String str) {

        str = str.replaceAll("AVENIDA", "AV");
        str = str.replaceAll("RUA", "R");
        str = str.replaceAll("DOUTOR", "DR");
        str = str.replaceAll("JARDIM", "JD");
        str = str.replaceAll("VILA", "VL");
        str = str.replaceAll("CAPITAO", "CAP");
        str = str.replaceAll("ENGENHEIRO", "ENG");
        str = str.replaceAll("LOTEAMENTO", "LTO");

        return str;
    }

    public static String criarEnderecoCompleto(UsuarioEntity pessoa, int tamanhoMaximoEndereco) {
        var enderecoCompleto = "";

        var endereco = pessoa.getEndereco();
        var logradouro = abreviar(norm(endereco.getLogradouro())).concat(", ");
        var temComplemento = StringUtils.hasText(endereco.getComplemento());
        var tamanhoDoNumero = endereco.getNumero().length();
        var tamanhoDoLogradouro = logradouro.length();

        if (temComplemento) {
            tamanhoDoNumero += 2; // conta-se a virgula e o espaco

            var tamanhoTotal = tamanhoDoNumero + tamanhoDoLogradouro + endereco.getComplemento().length();

            if (tamanhoTotal > tamanhoMaximoEndereco) {

                logradouro = logradouro.substring(0, (tamanhoTotal - tamanhoMaximoEndereco));

                enderecoCompleto = logradouro
                        .concat(endereco.getNumero().concat(", ").concat(endereco.getComplemento()));
            }

        } else {

            var tamanhoTotal = tamanhoDoNumero + tamanhoDoLogradouro;

            if (tamanhoTotal > tamanhoMaximoEndereco) {
                logradouro = logradouro.substring(0, (tamanhoTotal - tamanhoMaximoEndereco));

                enderecoCompleto = logradouro.concat(endereco.getNumero());
            } else {
                enderecoCompleto = logradouro.concat(endereco.getNumero());
            }
        }

        return enderecoCompleto;
    }
}
