package com.boletos.Gerenciar.CONTROLLER.GeradorBoleto;

import com.boletos.Gerenciar.SERVICE.GeradorBoleto.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/conta")
public class ContaController {

    @Autowired
    private ContaService contaService;
}
