package com.boletos.Gerenciar.CONTROLLER.GeradorBoleto;

import com.boletos.Gerenciar.DTO.GeradorBoleto.Conta.CriarContaDTO;
import com.boletos.Gerenciar.DTO.GeradorBoleto.Conta.EditContaDTO;
import com.boletos.Gerenciar.DTO.GeradorBoleto.Empresa.CriarEmpresaDTO;
import com.boletos.Gerenciar.DTO.GeradorBoleto.Empresa.EditEmpresaDTO;
import com.boletos.Gerenciar.ENTITY.GeradorBoleto.Conta;
import com.boletos.Gerenciar.ENTITY.GeradorBoleto.Empresa;
import com.boletos.Gerenciar.EXCEPTIONS.RegraNegocioException;
import com.boletos.Gerenciar.SERVICE.GeradorBoleto.ContaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/conta")
public class ContaController {

    @Autowired
    private ContaService contaService;

    @GetMapping
    public ResponseEntity<List<Conta>> buscarTodasContas(){

        return ResponseEntity.status(HttpStatus.OK).body(contaService.buscarTodasContas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> buscarConta(@PathVariable int id){

        Optional<Conta> contaExiste = contaService.buscarConta(id);

        if(contaExiste.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Conta não existe");
        }

        return ResponseEntity.status(HttpStatus.OK).body(contaExiste);

    }

    @PostMapping
    public ResponseEntity<Object> criarConta(@RequestBody CriarContaDTO criarContaDTO) throws RegraNegocioException, BeansException {

        try {
            var contaRecebeDTO = new Conta();

            BeanUtils.copyProperties(criarContaDTO, contaRecebeDTO);

            Conta contaCriada = contaService.saveConta(contaRecebeDTO, criarContaDTO.idBanco(), criarContaDTO.idEmpresa());
            return ResponseEntity.status(HttpStatus.CREATED).body(contaCriada);
        } catch (BeansException | RegraNegocioException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }

    @PutMapping
    public ResponseEntity<Object> editarConta(@RequestBody EditContaDTO editContaDTO) throws RegraNegocioException {

        try {
            var contaRecebeDTO = new Conta();

            BeanUtils.copyProperties(editContaDTO, contaRecebeDTO);

            Conta contaEditada = contaService.editConta(contaRecebeDTO, editContaDTO.idBanco(), editContaDTO.idEmpresa());

            return ResponseEntity.status(HttpStatus.OK).body(contaEditada);
        } catch (BeansException | RegraNegocioException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteConta(@PathVariable int id){

        Optional<Conta> contaExcluida = contaService.deleteConta(id);

        if(contaExcluida.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Conta não encontrado");
        }

        return ResponseEntity.status(HttpStatus.OK).body("Conta excluida");
    }
}
