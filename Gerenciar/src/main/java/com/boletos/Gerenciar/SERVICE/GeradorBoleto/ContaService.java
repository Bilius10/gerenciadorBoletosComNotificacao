package com.boletos.Gerenciar.SERVICE.GeradorBoleto;

import com.boletos.Gerenciar.REPOSITORY.GeradorBoleto.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContaService {

    @Autowired
    private ContaRepository contaRepository;
}
