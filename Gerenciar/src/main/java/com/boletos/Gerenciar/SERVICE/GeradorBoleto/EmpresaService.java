package com.boletos.Gerenciar.SERVICE.GeradorBoleto;

import com.boletos.Gerenciar.ENTITY.GeradorBoleto.Empresa;
import com.boletos.Gerenciar.ENTITY.GeradorBoleto.Endereco;
import com.boletos.Gerenciar.EXCEPTIONS.RegraNegocioException;
import com.boletos.Gerenciar.REPOSITORY.GeradorBoleto.EmpresaRepository;
import com.boletos.Gerenciar.REPOSITORY.GeradorBoleto.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;

    public List<Empresa> buscarTodasEmpresas(){

        return empresaRepository.findAll();
    }

    public Optional<Empresa> buscarEmpresa(int id){

        return empresaRepository.findById(id);

    }

    public Empresa saveEmpresa(Empresa empresa) {

        Endereco enderecoSalvo = enderecoRepository.save(empresa.getEndereco());
        empresa.setEndereco(enderecoSalvo);

        return empresaRepository.save(empresa);
    }

    public Empresa editarEmpresa(Empresa empresa) throws RegraNegocioException{

        Optional<Empresa> empresaExiste = empresaRepository.findById(empresa.getIdEmpresa());

        if(empresaExiste.isEmpty()){
            throw new RegraNegocioException("Id da empresa não encontrado");
        }

        Optional<Endereco> enderecoExiste = enderecoRepository.findById(empresa.getEndereco().getIdEndereco());

        if(enderecoExiste.isEmpty()){
            throw new RegraNegocioException("ID do endereço incorreto");
        }
        Endereco enderecoEncontrado = enderecoExiste.get();

        if(!empresa.getEndereco().equals(enderecoEncontrado)){
            enderecoRepository.save(empresa.getEndereco());
        }

        return empresaRepository.save(empresa);
    }

    public Optional<Empresa> deleteEmpresa(int id){
        Optional<Empresa> empresaExiste = empresaRepository.findById(id);

        if(empresaExiste.isPresent()){
            empresaRepository.deleteById(id);
            enderecoRepository.deleteById(empresaExiste.get().getEndereco().getIdEndereco());
        }

        return empresaExiste;
    }
}
