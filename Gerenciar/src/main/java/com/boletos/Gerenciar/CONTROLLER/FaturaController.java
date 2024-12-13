package com.boletos.Gerenciar.CONTROLLER;

import com.boletos.Gerenciar.DTO.GeradorBoleto.BoletoRegistradoDTO;
import com.boletos.Gerenciar.DTO.GeradorBoleto.CobrancaDTO;
import com.boletos.Gerenciar.ENTITY.GeradorBoleto.Fatura;
import com.boletos.Gerenciar.INFRA.GeradorBoleto.CobrancaInput;
import com.boletos.Gerenciar.SERVICE.FaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/faturas")
public class FaturaController {

    @Autowired
    private FaturaService faturaService;

    @GetMapping("{faturaId}")
    public CobrancaInput transformar(@PathVariable int faturaId) {
        return faturaService.transformarFaturaEmCobranca(faturaId);
    }

    @PostMapping("{faturaId}")
    public BoletoRegistradoDTO registrar(@PathVariable int faturaId, @RequestBody CobrancaDTO model) {
        return faturaService.registrarCobranca(faturaId, model);
    }

    @GetMapping(path = "{faturaId}/boleto/pdf", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<byte[]> gerarBoleto(@PathVariable int faturaId) {
        byte[] bytesPdf = faturaService.gerar(faturaId);

        return ResponseEntity.ok().contentType(MediaType.APPLICATION_PDF).body(bytesPdf);
    }







}
