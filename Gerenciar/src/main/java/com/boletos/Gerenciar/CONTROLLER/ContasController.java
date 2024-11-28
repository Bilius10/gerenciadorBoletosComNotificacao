package com.boletos.Gerenciar.CONTROLLER;

import com.boletos.Gerenciar.DTO.EditContaDTO;
import com.boletos.Gerenciar.ENTITY.ContasEntity;
import com.boletos.Gerenciar.SERVICE.ContasService;
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
public class ContasController {

    @Autowired
    private ContasService contasService;

    @GetMapping
    public ResponseEntity<List<ContasEntity>> buscarTodasContas(){
        return ResponseEntity.status(HttpStatus.OK).body(contasService.buscarTodasContas());
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> buscarConta(@PathVariable UUID id){

        Optional<ContasEntity> contaBuscada = contasService.buscarConta(id);

        if(contaBuscada.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Conta não encontrada");
        }

        return ResponseEntity.status(HttpStatus.OK).body(contaBuscada);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deletarConta(@PathVariable UUID id){

        Optional<ContasEntity> contaDeletada = contasService.deletarConta(id);

        if(contaDeletada.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Conta não encontrada");
        }

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Conta excluida");
    }

    @PutMapping
    private ResponseEntity<Object> editarConta(@RequestBody EditContaDTO editContaDTO){

        ContasEntity contaRecebida = new ContasEntity();

        BeanUtils.copyProperties(editContaDTO, contaRecebida);



    }
}
