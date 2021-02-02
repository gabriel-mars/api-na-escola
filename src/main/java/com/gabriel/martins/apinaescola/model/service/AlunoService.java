package com.gabriel.martins.apinaescola.model.service;

import com.gabriel.martins.apinaescola.model.dao.AlunoRepositoty;
import com.gabriel.martins.apinaescola.model.entity.AlunoEntity;
import com.gabriel.martins.apinaescola.model.entity.EscolaEntity;
import com.gabriel.martins.apinaescola.model.entity.ResponsavelEntity;
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
    public void salvar(AlunoEntity aluno) {
        repository.save(aluno);
    }

    @Transactional(readOnly = false)
    public void editar(AlunoEntity aluno) {
        repository.update(aluno);
    }

    @Transactional(readOnly = false)
    public void excluir(Long id) {
        repository.delete(id);
    }

    @Transactional(readOnly = false)
    public void updateAluno(AlunoEntity aluno) {
        repository.update(aluno);
    }

    public AlunoEntity buscarPorId(Long id) {
        return repository.findById(id); 
    }

    public List<AlunoEntity> buscarTodos() {
        return repository.findAll();
    }

    public List<AlunoEntity> buscarPorEscola(Long escolaId) {
        return repository.findByEscola(escolaId);
    }

    public String gerarCodigoEscola(EscolaEntity escola, String cpf) {
        String codigoGerado;
        Integer codigoEscola;

        codigoEscola = escola.getCodigoMec();
        codigoGerado = generateSecurityKey(codigoEscola, cpf);

        return codigoGerado;
    }

    private String generateSecurityKey(Integer codigo, String cpf){
        String inicioCpf;
        String tmpValor = String.valueOf(codigo);
        String securityKey = new String();
        char[] letras = null;

        // Quebra do código da escola nos 5 primeiros dígitos
        for (int i = 3; i < tmpValor.length(); i++) {
            securityKey = securityKey + tmpValor.substring(i, i+1);
        }

        // Quebra do CPF do professor nos 
        letras = cpf.toCharArray();
        inicioCpf = "" + letras[0];
        inicioCpf = inicioCpf + letras[1];
        inicioCpf = inicioCpf + letras[2];

        securityKey = securityKey + inicioCpf;

        return securityKey;
    }

    public List<AlunoEntity> buscarPorSemClasse(Long escolaId) {
        return repository.findByNoClass(escolaId);
    }

    public List<AlunoEntity> buscarPorClasse(Long id) {
        return repository.findByClass(id);
    }

    @Deprecated
    public List<AlunoEntity> buscarPorClasseBoletim(Long id) {
            return repository.findByClass(id);
    }

    public List<AlunoEntity> buscarPorNome(String nome, Long id) {
        return repository.findByName(nome, id);
    }

    public List<AlunoEntity> buscarPorProfessor(Long id) {
        return repository.findByProfessor(id);
    }

    public List<AlunoEntity> buscarPorNomeProfessor(String nome, Long id) {
        return repository.findByNameProfessor(nome, id);
    }
}
