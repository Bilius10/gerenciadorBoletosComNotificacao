package com.boletos.Gerenciar.CONTROLLER.GeradorBoleto;

import com.boletos.Gerenciar.DTO.EditContaDTO;
import com.boletos.Gerenciar.DTO.GeradorBoleto.Banco.CriarBancoDTO;
import com.boletos.Gerenciar.ENTITY.GeradorBoleto.Banco;
import com.boletos.Gerenciar.SERVICE.GeradorBoleto.BancoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/banco")
public class BancoController {

    @Autowired
    private BancoService bancoService;

    @GetMapping
    public ResponseEntity<List<Banco>> buscarTodosBancos(){

        return ResponseEntity.status(HttpStatus.OK).body(bancoService.buscarTodosBancos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> buscarBanco(@PathVariable int id){

        Optional<Banco> bancoExiste = bancoService.buscarBanco(id);

        if(bancoExiste.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Banco não existe");
        }

        return ResponseEntity.status(HttpStatus.OK).body(bancoExiste);

    }

    @PostMapping
    public ResponseEntity<Banco> criarBanco(@RequestBody CriarBancoDTO criarBancoDTO){
        var bancoRecebeDTO = new Banco();

        BeanUtils.copyProperties(criarBancoDTO, bancoRecebeDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(bancoService.saveBanco(bancoRecebeDTO));
    }

    @PutMapping
    public ResponseEntity<Object> editarBanco(@RequestBody EditContaDTO editContaDTO){
        var bancoRecebeDTO = new Banco();

        BeanUtils.copyProperties(editContaDTO, bancoRecebeDTO);

        Optional<Banco> bancoEditado = bancoService.editarBanco(bancoRecebeDTO);

        if(bancoEditado.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Banco não encontrado");
        }

        return ResponseEntity.status(HttpStatus.OK).body(bancoEditado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBanco(@PathVariable int id){

        Optional<Banco> bancoExcluido = bancoService.deleteBanco(id);

        if(bancoExcluido.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Banco não encontrado");
        }

        return ResponseEntity.status(HttpStatus.OK).body("Banco excluido");
    }
}
