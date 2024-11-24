package com.boletos.Gerenciar.PRODUCER;

import com.boletos.Gerenciar.ENTITY.EmailEntity;
import com.boletos.Gerenciar.ENTITY.UsuarioEntity;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EmailProducer {

    final RabbitTemplate rabbitTemplate;

    public EmailProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value(value = "${broker.queue.email.name}")
    private String routingKey;

    public void publishWelComeMessage(UsuarioEntity usuarioEntity) {
        var emailDto = new EmailEntity();
        emailDto.setUserId(usuarioEntity.getIdUsuario());
        emailDto.setEmailTo(usuarioEntity.getEmail());
        emailDto.setSubject("Cadastro realizado com sucesso!");
        emailDto.setText(usuarioEntity.getNome() + ", seja bem vindo(a)! \nAgradecemos o seu cadastro, aproveite agora todos os recursos da nossa plataforma!");

        rabbitTemplate.convertAndSend("", routingKey, emailDto);
    }


}
