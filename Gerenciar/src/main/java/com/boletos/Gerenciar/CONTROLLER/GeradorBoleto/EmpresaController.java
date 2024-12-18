package com.boletos.Gerenciar.CONTROLLER.GeradorBoleto;

import com.boletos.Gerenciar.DTO.EditContaDTO;
import com.boletos.Gerenciar.DTO.GeradorBoleto.Banco.CriarBancoDTO;
import com.boletos.Gerenciar.DTO.GeradorBoleto.Empresa.CriarEmpresaDTO;
import com.boletos.Gerenciar.DTO.GeradorBoleto.Empresa.EditEmpresaDTO;
import com.boletos.Gerenciar.ENTITY.GeradorBoleto.Banco;
import com.boletos.Gerenciar.ENTITY.GeradorBoleto.Empresa;
import com.boletos.Gerenciar.EXCEPTIONS.RegraNegocioException;
import com.boletos.Gerenciar.SERVICE.GeradorBoleto.EmpresaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @GetMapping
    public ResponseEntity<List<Empresa>> buscarTodasEmpresa(){

        return ResponseEntity.status(HttpStatus.OK).body(empresaService.buscarTodasEmpresas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> buscarEmpresa(@PathVariable int id){

        Optional<Empresa> empresaExiste = empresaService.buscarEmpresa(id);

        if(empresaExiste.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Empresa não existe");
        }

        return ResponseEntity.status(HttpStatus.OK).body(empresaExiste);

    }

    @PostMapping
    public ResponseEntity<Object> criarEmpresa(@RequestBody CriarEmpresaDTO criarEmpresaDTO) throws RegraNegocioException {
        try {
            var empresaRecebeDTO = new Empresa();

            BeanUtils.copyProperties(criarEmpresaDTO, empresaRecebeDTO);

            Empresa empresaCriada = empresaService.saveEmpresa(empresaRecebeDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(empresaCriada);
        } catch (BeansException | RegraNegocioException b) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(b.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<Object> editarBanco(@RequestBody EditEmpresaDTO editEmpresaDTO) throws RegraNegocioException {

        try {
            var empresaRecebeDTO = new Empresa();

            BeanUtils.copyProperties(editEmpresaDTO, empresaRecebeDTO);

            Empresa empresaEditada = empresaService.editarEmpresa(empresaRecebeDTO);

            return ResponseEntity.status(HttpStatus.OK).body(empresaEditada);
        } catch (BeansException | RegraNegocioException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmpresa(@PathVariable int id){

        Optional<Empresa> empresaExcluido = empresaService.deleteEmpresa(id);

        if(empresaExcluido.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Empresa não encontrado");
        }

        return ResponseEntity.status(HttpStatus.OK).body("Empresa excluida");
    }
}
