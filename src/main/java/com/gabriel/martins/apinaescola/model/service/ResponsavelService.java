package com.gabriel.martins.apinaescola.model.service;

import com.gabriel.martins.apinaescola.model.dao.ResponsavelRepository;
import com.gabriel.martins.apinaescola.model.entity.ResponsavelEntity;
import com.gabriel.martins.apinaescola.model.utils.SecurityGeneric;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class ResponsavelService {
    
    @Autowired
    private ResponsavelRepository repository;
    
    @Transactional(readOnly = false)
    public void salvar(ResponsavelEntity responsavel) {
        responsavel.getUsuario().setSenha(SecurityGeneric.getSecurePassword(responsavel.getUsuario().getSenha()));
        responsavel.getUsuario().setHash(SecurityGeneric.getHashUser(responsavel.getUsuario().getCpf()));
        repository.save(responsavel);
    }

    @Transactional(readOnly = false)
    public void editar(ResponsavelEntity responsavel) {
        repository.update(responsavel);
    }

    @Transactional(readOnly = false)
    public void excluir(Long id) {
        repository.delete(id);
    }

    @Transactional(readOnly = false)
    public void updateAluno(ResponsavelEntity responsavel) {
        repository.update(responsavel);
    }

    public ResponsavelEntity buscarPorId(Long id) {
        return repository.findById(id); 
    }

    public List<ResponsavelEntity> buscarTodos() {
        return repository.findAll();
    }
    
    public ResponsavelEntity buscarDadosResponsavel(String codigoAluno) {
        return repository.findDataResponsavel(codigoAluno);
    }
}
