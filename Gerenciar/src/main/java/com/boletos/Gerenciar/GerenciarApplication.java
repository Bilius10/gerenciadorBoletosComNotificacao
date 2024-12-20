package com.boletos.Gerenciar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GerenciarApplication {

	public static void main(String[] args) {
		SpringApplication.run(GerenciarApplication.class, args);
	}
	//arrumar o registro do usuario

	//{
	//	"valor": 1500.00,
	//		"dataVencimento": "2024-12-31",
	//		"tipoPagamento": "boleto",
	//		"situacaoPagamento": "nao paga",
	//		"numeroDocumento": "123456789",
	//		"nossoNumero": "987654321",
	//		"conta": {
	//	"idConta": 1
	//},
	//	"usuarioEntity": {
	//	"idUsuario": 1
	//},
	//	"convenio": {
	//	"idConvenio": 1
	//}
	//}
}
