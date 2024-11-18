package com.enviar.email.CONSUMER;

import com.enviar.email.DTOs.EmailReceiveDTO;
import com.enviar.email.ENTITY.EmailEntity;
import com.enviar.email.SERVICE.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

    private EmailService emailService;

    public EmailConsumer(EmailService emailService) {
        this.emailService = emailService;
    }

    @RabbitListener(queues = "${broker.queue.email.name}" )
    public void listenEmailQueueWelcome(@Payload EmailReceiveDTO emailRecordDto) {
        var emailEntity = new EmailEntity();
        BeanUtils.copyProperties(emailRecordDto, emailEntity);
        emailService.sendEmail(emailEntity);
    }

}
