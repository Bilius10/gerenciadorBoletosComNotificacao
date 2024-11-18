Estrutura do Projeto
1. Pasta gerenciar:
Essa pasta deve conter as lógicas relacionadas ao gerenciamento de boletos e usuários. Ela será responsável por manter a consistência dos dados de boletos e usuários no banco de dados.

Classes e Funcionalidades:
Classe Usuario:

Atributos:
id: Identificador único do usuário.
nome: Nome do usuário.
tipo: Tipo de usuário (pagador ou cobrador).
status: Status do usuário (ativo ou inativo).
email: Endereço de e-mail para notificações.
Função: O usuário pode ser um pagador, responsável pelo pagamento dos boletos, ou um cobrador, responsável pela criação e gerenciamento dos boletos.
Classe Boleto:

Atributos:
id: Identificador único do boleto.
valor: Valor do boleto.
dataVencimento: Data de vencimento do boleto.
status: Status do boleto (pago ou não pago).
usuario: O usuário associado ao boleto (um pagador).
Funções:
Criar boletos com valores e datas de vencimento.
Alterar o status do boleto de "não pago" para "pago" quando o pagamento for realizado.
Calcular os juros de atraso, se necessário.
Marcar os boletos como "vencidos" quando ultrapassada a data de vencimento.
Classe GerenciadorDeBoletos:

Funções:
Criar Boleto: Criação de boletos para os pagadores com base nas informações inseridas.
Pagar Boleto: Função que permite o pagamento de um boleto e a alteração do seu status para pago.
Verificar Vencimento: Verificação automática para boletos próximos do vencimento ou vencidos.
Enviar Notificação: Após o pagamento ou vencimento de um boleto, a notificação sobre o status do boleto será enviada ao usuário, através da integração com o sistema de notificações.
2. Pasta email:
Esta pasta será responsável pela criação do sistema de notificações. A principal finalidade é enviar mensagens sobre o status dos boletos para os usuários, seja por e-mail ou outro meio, utilizando a comunicação assíncrona com o RabbitMQ.

Classes e Funcionalidades:
Classe Notificacao:
Funções:
EnviarNotificacao: Envia a notificação para o usuário com informações sobre o boleto. Quando um boleto é pago ou vence, essa função deve ser chamada para gerar um e-mail informando o usuário sobre a mudança de status.
ConstruirMensagem: A função de construir a mensagem que será enviada por e-mail, com base nos dados do boleto e do usuário.
Classe EmailService:
Funções:
EnviarEmail: Função que realiza a integração com um serviço de e-mail (como o Spring Mail) para enviar a mensagem construída pela classe Notificacao.
