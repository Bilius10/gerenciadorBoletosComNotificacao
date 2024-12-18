package com.boletos.Gerenciar.SERVICE.GeradorBoleto;

import com.boletos.Gerenciar.ENTITY.GeradorBoleto.Banco;
import com.boletos.Gerenciar.ENTITY.GeradorBoleto.Conta;
import com.boletos.Gerenciar.ENTITY.GeradorBoleto.Convenio;
import com.boletos.Gerenciar.ENTITY.GeradorBoleto.Empresa;
import com.boletos.Gerenciar.EXCEPTIONS.RegraNegocioException;
import com.boletos.Gerenciar.REPOSITORY.GeradorBoleto.ContaRepository;
import com.boletos.Gerenciar.REPOSITORY.GeradorBoleto.ConvenioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConvenioService {

    @Autowired
    private ConvenioRepository convenioRepository;
    @Autowired
    private ContaRepository contaRepository;

    public List<Convenio> buscarTodosConvenios(){

        return convenioRepository.findAll();
    }

    public Optional<Convenio> buscarConvenio(int id){

        return convenioRepository.findById(id);

    }

    public Convenio saveConvenio(Convenio convenio, int idConta) throws RegraNegocioException {

        Optional<Conta> contaExiste = contaRepository.findById(idConta);

        if(contaExiste.isEmpty()){
            throw new RegraNegocioException("ID da conta incorreto");
        }
        convenio.setConta(contaExiste.get());

        return convenioRepository.save(convenio);
    }

    public Convenio editConvenio(Convenio convenio, int idConta) throws RegraNegocioException {

        Optional<Convenio> convenioExiste = convenioRepository.findById(convenio.getIdConvenio());

        if(convenioExiste.isEmpty()){
            throw new RegraNegocioException("ID do convenio incorreto");
        }

        Optional<Conta> contaExiste = contaRepository.findById(idConta);

        if(contaExiste.isEmpty()){
            throw new RegraNegocioException("ID da conta incorreto");
        }
        convenio.setConta(contaExiste.get());

        return convenioRepository.save(convenio);
    }

    public Optional<Convenio> deleteConvenio(int id){
        Optional<Convenio> convenioExiste = convenioRepository.findById(id);

        if(convenioExiste.isPresent()){
            convenioRepository.deleteById(id);
        }

        return convenioExiste;
    }

}
