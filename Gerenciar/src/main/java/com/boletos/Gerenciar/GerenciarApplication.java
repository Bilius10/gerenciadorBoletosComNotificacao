package com.boletos.Gerenciar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GerenciarApplication {

	public static void main(String[] args) {
		SpringApplication.run(GerenciarApplication.class, args);
	}
	//https://bitbucket.org/prgomesr/03.04-criando-tabela-fatura-empresa-banco-conta-e-convenio/src/master/src/main/resources/db/migration/V002__criando_empresa_banco_conta_fatura_e_convenio.sql
	//https://youtu.be/hlKik_eQ6gw?si=Q3C9mfFUY3bONbPO
	//boa sorte quando terminar isso e rodar kkk
	//arrumar o dto de criação de um usuario

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
