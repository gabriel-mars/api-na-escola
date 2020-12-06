package com.gabriel.martins.apinaescola.model.service;

import com.gabriel.martins.apinaescola.model.dao.EmailRepository;
import com.gabriel.martins.apinaescola.model.entity.EmailEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = false)
public class EmailService {
    @Autowired
    private EmailRepository repository;

    public void salvar(EmailEntity email) {
        try {
            repository.save(email);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void editar(EmailEntity email) {
        try {
            repository.update(email);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void excluir(Long id) {
        // TODO Auto-generated method stub

    }

    @Transactional(readOnly = true)
    public EmailEntity buscarPorId(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Transactional(readOnly = true)
    public List<EmailEntity> buscarTodos() {
        // TODO Auto-generated method stub
        return null;
    }

    @Transactional(readOnly = true)
    public List<EmailEntity> buscarPorNaoEnviada(){
        return repository.findByNotSend();
    }

    @Transactional(readOnly = true)
    public List<EmailEntity> buscarPorNaoEnviadaProfessor(){
        return repository.findByNotSendProfessor();
    }

    @Transactional(readOnly = true)
    public List<EmailEntity> buscarPorNaoEnviadaEscola(){ return repository.findByNotSendEscola(); }

    @Transactional(readOnly = true)
    public List<EmailEntity> buscarPorNaoEnviadaSenhaEscola(){
        return repository.findByNotSendSenha();
    }

    @Transactional(readOnly = true)
    public List<EmailEntity> buscarPorNaoEnviadaSenhaProfessor() {
        return repository.findByNotSendSenhaProfessor();
    }
}
