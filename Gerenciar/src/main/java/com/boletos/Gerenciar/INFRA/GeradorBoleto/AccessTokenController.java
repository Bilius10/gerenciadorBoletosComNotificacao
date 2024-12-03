package com.boletos.Gerenciar.INFRA.GeradorBoleto;

import org.apache.logging.log4j.util.Base64Util;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Arrays;

@Component
public class AccessTokenController {

    private RestTemplate restTemplate = new RestTemplate();

    public String requisitarToken(String clientId, String clientSecrect){

        URI url = URI.create("https://oauth.hm.bb.com.br/oauth/token");
        HttpHeaders httpHeaders = new HttpHeaders();

        var basic = clientId.concat(":").concat(clientSecrect);
        byte[] auth = Base64Util.encode(basic).getBytes();

        httpHeaders.set("Authorization", "Basic " + Arrays.toString(auth));
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("grant_type", "client_credentials");
        map.add("scope", "cobrancas.boletos-requisicao");

        var request = new HttpEntity<>(map, httpHeaders);

        var accessToken = restTemplate.postForObject(url, map, AccessTokenBB.class);
        return accessToken.getAccess_token();
    }
}
