package com.boletos.Gerenciar.CONTROLLER.GeradorBoleto;

import com.boletos.Gerenciar.DTO.GeradorBoleto.Endereco.CriarEnderecoDTO;
import com.boletos.Gerenciar.DTO.GeradorBoleto.Endereco.EditEnderecoDTO;
import com.boletos.Gerenciar.ENTITY.GeradorBoleto.Endereco;
import com.boletos.Gerenciar.SERVICE.GeradorBoleto.EnderecoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping
    public ResponseEntity<List<Endereco>> buscarTodosEnderecos(){

        return ResponseEntity.status(HttpStatus.OK).body(enderecoService.buscarTodosEnderecos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> buscarEndereco(@PathVariable int id){

        Optional<Endereco> enderecoExiste = enderecoService.buscarEndereco(id);

        if(enderecoExiste.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Endereço não existe");
        }

        return ResponseEntity.status(HttpStatus.OK).body(enderecoExiste);

    }

    @PostMapping
    public ResponseEntity<Endereco> criarEndereco(@RequestBody CriarEnderecoDTO criarEnderecoDTO){
        var enderecoRecebeDTO = new Endereco();

        BeanUtils.copyProperties(criarEnderecoDTO, enderecoRecebeDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(enderecoService.saveEndereco(enderecoRecebeDTO));
    }

    @PutMapping
    public ResponseEntity<Object> editarBanco(@RequestBody EditEnderecoDTO editEnderecoDTO){
        var enderecoRecebeDTO = new Endereco();

        BeanUtils.copyProperties(enderecoRecebeDTO, editEnderecoDTO);

        Optional<Endereco> enderecoEditado = enderecoService.editarEndereco(enderecoRecebeDTO);

        if(enderecoEditado.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Endereço não encontrado");
        }

        return ResponseEntity.status(HttpStatus.OK).body(enderecoEditado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBanco(@PathVariable int id){

        Optional<Endereco> enderecoExcluido = enderecoService.deleteEndereco(id);

        if(enderecoExcluido.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Endereço não encontrado");
        }

        return ResponseEntity.status(HttpStatus.OK).body("Endereço excluido");
    }
}
