package com.boletos.Gerenciar.CONTROLLER;

import com.boletos.Gerenciar.DTO.GeradorBoleto.BoletoRegistradoDTO;
import com.boletos.Gerenciar.INFRA.GeradorBoleto.CobrancaInput;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
public class CobrancaController {

    private RestTemplate restTemplate = new RestTemplate();

    public BoletoRegistradoDTO registrar(CobrancaInput cobranca, String token, String key){
        URI url = URI.create("https://oauth.hm.bb.com.br/oauth/token");
        var uriBuilder = UriComponentsBuilder.fromUri(url);
        uriBuilder.queryParam("gw-dev-app-key", key);

        var headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + token);

        var request = new HttpEntity<>(cobranca, headers);

        var response = restTemplate.postForObject(uriBuilder.build().toUri(), request, BoletoRegistradoDTO.class);

        return response;
    }
}
