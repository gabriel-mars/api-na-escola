package com.gabriel.martins.apinaescola.model.service;

import com.gabriel.martins.apinaescola.model.dao.AlunoRepositoty;
import com.gabriel.martins.apinaescola.model.entity.AlunoEntity;
import com.gabriel.martins.apinaescola.model.entity.EscolaEntity;
import com.gabriel.martins.apinaescola.model.utils.SecurityGeneric;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class AlunoService {
    
    @Autowired
    private AlunoRepositoty repository;
    
    @Transactional(readOnly = false)
    public void save(AlunoEntity aluno) {
        repository.save(aluno);
    }

    @Transactional(readOnly = false)
    public void update(AlunoEntity aluno) {
        repository.update(aluno);
    }

    @Transactional(readOnly = false)
    public void remove(Long id) {
        repository.delete(id);
    }

    @Transactional(readOnly = false)
    public void updateAluno(AlunoEntity aluno) {
        repository.update(aluno);
    }

    public AlunoEntity findById(Long id) {
        return repository.findById(id); 
    }

    public List<AlunoEntity> findAll() {
        return repository.findAll();
    }

    public List<AlunoEntity> findByEscola(Long escolaId) {
        return repository.findByEscola(escolaId);
    }

    public String gerarCodigoEscola(EscolaEntity escola, String cpf) {
        String codigoGerado;
        Integer codigoEscola;

        codigoEscola = escola.getCodigoMec();
        codigoGerado = SecurityGeneric.generateKeyAluno(codigoEscola, cpf);

        return codigoGerado;
    }

    public List<AlunoEntity> findByNoClass(Long escolaId) {
        return repository.findByNoClass(escolaId);
    }

    public List<AlunoEntity> findByClass(Long id) {
        return repository.findByClass(id);
    }

    @Deprecated
    public List<AlunoEntity> buscarPorClasseBoletim(Long id) {
            return repository.findByClass(id);
    }

    public List<AlunoEntity> findByName(String nome, Long id) {
        return repository.findByName(nome, id);
    }

    public List<AlunoEntity> findByProfessor(Long id) {
        return repository.findByProfessor(id);
    }

    public List<AlunoEntity> findByNameProfessor(String nome, Long id) {
        return repository.findByNameProfessor(nome, id);
    }
}
