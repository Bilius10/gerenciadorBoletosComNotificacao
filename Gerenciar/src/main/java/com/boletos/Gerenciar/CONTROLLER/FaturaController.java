package com.boletos.Gerenciar.CONTROLLER;

import com.boletos.Gerenciar.DTO.EditContaDTO;
import com.boletos.Gerenciar.ENTITY.GeradorBoleto.Fatura;
import com.boletos.Gerenciar.SERVICE.FaturaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/contas")
public class FaturaController {

    @Autowired
    private FaturaService faturaService;

    @GetMapping
    public ResponseEntity<List<Fatura>> buscarTodasContas(){
        return ResponseEntity.status(HttpStatus.OK).body(faturaService.buscarTodasContas());
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> buscarConta(@PathVariable int id){

        Optional<Fatura> contaBuscada = faturaService.buscarConta(id);

        if(contaBuscada.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Conta não encontrada");
        }

        return ResponseEntity.status(HttpStatus.OK).body(contaBuscada);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deletarConta(@PathVariable int id){

        Optional<Fatura> contaDeletada = faturaService.deletarConta(id);

        if(contaDeletada.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Conta não encontrada");
        }

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Conta excluida");
    }


}
