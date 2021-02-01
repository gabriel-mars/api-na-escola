package com.gabriel.martins.apinaescola.model.service;

import com.gabriel.martins.apinaescola.model.dao.AlunoRepositoty;
import com.gabriel.martins.apinaescola.model.entity.AlunoEntity;
import com.gabriel.martins.apinaescola.model.entity.EscolaEntity;
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

//    public List<AlunoEntity> buscarPorEscola(Long escolaId) {
//        return dao.findByEscola(escolaId);
//    }

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

//    @Transactional(readOnly = true)
//    public List<AlunoEntity> buscarPorSemClasse(Long escolaId) {
//            return dao.findByNoClass(escolaId);
//    }
//
//    @Transactional(readOnly = true)
//    public List<AlunoEntity> buscarPorClasse(Long id) {
//            return dao.findByClass(id);
//    }
//
//    @Transactional(readOnly = true)
//    public List<Object[]> buscarPorClasseBoletim(Long id) {
//            return dao.findByClasseBoletim(id);
//    }
//
//    public List<AlunoEntity> buscarPorNome(String nome, Long id) {
//            return dao.findByName(nome, id);
//    }
//
//    public List<AlunoEntity> buscarPorProfessor(Long id) {
//            return dao.findByProfessor(id);
//    }
//
//    public List<AlunoEntity> buscarPorNomeProfessor(String nome, Long id) {
//            return dao.findByNameProfessor(nome, id);
//    }
//    
//    public Pessoa buscarDadosResponsavel(String codigoAluno) {
//        Pessoa responsavel = new Pessoa();
//        List<Object[]> aux = dao.findDataResponsavel(codigoAluno);
//
//        Object[] result = aux.get(0);
//        responsavel.setNome(result[0].toString());
//        responsavel.setTelefone(result[1].toString());
//        responsavel.setEmail(result[2].toString());
//        responsavel.setEndereco(result[3].toString());
//        responsavel.setMunicipio(result[4].toString());
//
//        return responsavel;
//    }
}
