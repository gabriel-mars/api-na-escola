package com.gabriel.martins.apinaescola.model.utils;

import com.gabriel.martins.apinaescola.model.entity.EmailEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@EnableScheduling
public class EmailSchedule {

    private final long SEGUNDO = 1000;
    private final long MINUTO = SEGUNDO * 60;
    private final long CINCO_MINUTOS = MINUTO * 5;
    private final long DEZ_MINUTOS = MINUTO * 10;
    private final long QUINZE_MINUTOS = MINUTO * 15;
    private final long VINTE_MINUTOS = MINUTO * 20;
    private final long VINTE_E_CINCO_MINUTOS = MINUTO * 25;

//    @Autowired
//    private EmailService service;

    @Autowired(required = false)
    private EmailFactory emailFactory;

    @Scheduled(fixedDelay = VINTE_E_CINCO_MINUTOS)
    public void verificarDuvidas() {
        EmailEntity email = buscarEmailDuvida();

        if (email != null) {
            emailFactory.sendMailDuvida(email);
            finalizarEmail(email);
        }
    }

    @Scheduled(fixedDelay = QUINZE_MINUTOS)
    public void verificarEmailSenha() {
        EmailEntity email = buscarEmailSenha();

        emailFactory.sendMailSenhaEscola(email);

        finalizarEmail(email);
    }

    @Scheduled(fixedDelay = VINTE_MINUTOS)
    public void verificarEmailSenhaProfessor() {
        EmailEntity email = buscarEmailSenhaProfessor();

        emailFactory.sendMailSenhaProfessor(email);

        finalizarEmail(email);
    }

    @Scheduled(fixedDelay = DEZ_MINUTOS)
    public void verificarEmailCadastroProfessor() {
        EmailEntity email = buscarEmailProfessor();

        emailFactory.sendMailCadastroProfessor(email);

        finalizarEmail(email);
    }

    @Scheduled(fixedDelay = CINCO_MINUTOS)
    public void verificarEmailCadastroEscola() {
        EmailEntity email = buscarEmailEscola();

        emailFactory.sendMail(email);

        finalizarEmail(email);
    }

    private EmailEntity buscarEmailEscola() {
        List<EmailEntity> emails = new ArrayList<>();
        EmailEntity email = new EmailEntity();

//        emails = service.buscarPorNaoEnviadaEscola();
        email = emails.get(0);

        return email;
    }

    private EmailEntity buscarEmailSenha() {
        List<EmailEntity> emails = new ArrayList<>();
        EmailEntity email = new EmailEntity();

//        emails = service.buscarPorNaoEnviadaSenhaEscola();
        email = emails.get(0);

        return email;
    }

    private EmailEntity buscarEmailSenhaProfessor() {
        List<EmailEntity> emails = new ArrayList<>();
        EmailEntity email = new EmailEntity();

//        emails = service.buscarPorNaoEnviadaSenhaProfessor();
        email = emails.get(0);

        return email;
    }

    public EmailEntity buscarEmailDuvida() {
        List<EmailEntity> emails = new ArrayList<>();
        EmailEntity email = new EmailEntity();

//        emails = service.buscarPorNaoEnviada();

        if (emails == null) {
            return null;
        } else {
            email = emails.get(0);
            return email;
        }
    }

    public EmailEntity buscarEmailProfessor() {
        List<EmailEntity> emails = new ArrayList<>();
        EmailEntity email = new EmailEntity();

//        emails = service.buscarPorNaoEnviadaProfessor();
        email = emails.get(0);

        return email;
    }

    public void finalizarEmail(EmailEntity email) {
        email.setEnviado(Boolean.TRUE);
//        service.editar(email);
    }
}
