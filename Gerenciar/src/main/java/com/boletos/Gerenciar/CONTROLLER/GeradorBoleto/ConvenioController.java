package com.boletos.Gerenciar.CONTROLLER.GeradorBoleto;

import com.boletos.Gerenciar.DTO.GeradorBoleto.Conta.CriarContaDTO;
import com.boletos.Gerenciar.DTO.GeradorBoleto.Convenio.CriarConvenioDTO;
import com.boletos.Gerenciar.DTO.GeradorBoleto.Convenio.EditConvenioDTO;
import com.boletos.Gerenciar.DTO.GeradorBoleto.Empresa.EditEmpresaDTO;
import com.boletos.Gerenciar.ENTITY.GeradorBoleto.Conta;
import com.boletos.Gerenciar.ENTITY.GeradorBoleto.Convenio;
import com.boletos.Gerenciar.ENTITY.GeradorBoleto.Empresa;
import com.boletos.Gerenciar.EXCEPTIONS.RegraNegocioException;
import com.boletos.Gerenciar.SERVICE.GeradorBoleto.ConvenioService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/convenio")
public class ConvenioController {

    @Autowired
    private ConvenioService convenioService;

    @GetMapping
    public ResponseEntity<List<Convenio>> buscarTodasConvenio(){

        return ResponseEntity.status(HttpStatus.OK).body(convenioService.buscarTodosConvenios());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> buscarConvenio(@PathVariable int id){

        Optional<Convenio> convenioExiste = convenioService.buscarConvenio(id);

        if(convenioExiste.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Convênio  não existe");
        }

        return ResponseEntity.status(HttpStatus.OK).body(convenioExiste);

    }

    @PostMapping
    public ResponseEntity<Object> criarConvenio(@RequestBody CriarConvenioDTO criarConvenioDTO) throws RegraNegocioException, BeansException {

        try {
            var convenioRecebeDTO = new Convenio();

            BeanUtils.copyProperties(criarConvenioDTO, convenioRecebeDTO);

            Convenio convenioCriado = convenioService.saveConvenio(convenioRecebeDTO, criarConvenioDTO.idConta());
            return ResponseEntity.status(HttpStatus.CREATED).body(convenioCriado);
        } catch (BeansException | RegraNegocioException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }

    @PutMapping
    public ResponseEntity<Object> editarConvenio(@RequestBody EditConvenioDTO editConvenioDTO) throws RegraNegocioException {

        try {
            var convenioRecebeDTO = new Convenio();

            BeanUtils.copyProperties(editConvenioDTO, convenioRecebeDTO);


            Convenio convenioEditado = convenioService.editConvenio(convenioRecebeDTO, editConvenioDTO.idConta());

            return ResponseEntity.status(HttpStatus.OK).body(convenioEditado);
        } catch (BeansException | RegraNegocioException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteConvenio(@PathVariable int id){

        Optional<Convenio> convenioExcluido = convenioService.deleteConvenio(id);

        if(convenioExcluido.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Convênio  não encontrado");
        }

        return ResponseEntity.status(HttpStatus.OK).body("Convênio excluida");
    }
}
