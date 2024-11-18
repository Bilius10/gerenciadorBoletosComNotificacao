package com.enviar.email.SERVICE;

import com.enviar.email.ENTITY.EmailEntity;
import com.enviar.email.ENUMs.StatusEmail;
import com.enviar.email.REPOSITORY.EmailRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmailService {

    final EmailRepository emailRepository;
    final JavaMailSender emailSender;
    private static final Logger logger = LoggerFactory.getLogger(EmailService.class);

    public EmailService(EmailRepository emailRepository, JavaMailSender emailSender) {
        this.emailRepository = emailRepository;
        this.emailSender = emailSender;
    }

    @Value(value = "${spring.mail.username}")
    private String emailFrom;

    @Transactional
    public EmailEntity sendEmail(EmailEntity emailModel) {
        try {

            emailModel.setLocalDateTime(LocalDateTime.now());
            emailModel.setEmailFrom(emailFrom);

            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(emailFrom);
            message.setTo(emailModel.getEmailTo());
            message.setSubject(emailModel.getSubject());
            message.setText(emailModel.getText());


            emailSender.send(message);

            emailModel.setStatusEmail(StatusEmail.SENT);
        } catch (MailException e) {

            emailModel.setStatusEmail(StatusEmail.ERROR);
            logger.error("Erro ao enviar e-mail: ", e);
        } finally {

            return emailRepository.save(emailModel);
        }
    }

}
