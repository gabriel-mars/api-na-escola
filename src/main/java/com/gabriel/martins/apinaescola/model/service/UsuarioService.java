/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gabriel.martins.apinaescola.model.service;

import com.gabriel.martins.apinaescola.model.dao.UsuarioRepository;
import com.gabriel.martins.apinaescola.model.entity.UsuarioEntity;
import com.gabriel.martins.apinaescola.model.utils.SecurityGeneric;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author b2ml
 */

@Service
@Transactional(readOnly = true)
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository repository;
    
    @Transactional(readOnly = false)
    public void save(UsuarioEntity entity) throws Exception {
        try {            
            entity.setSenha(SecurityGeneric.getSecurePassword(entity.getSenha()));
            entity.setHash(SecurityGeneric.getHashUser(entity.getCpf()));
            
            repository.save(entity);
        } catch (Exception e) {
            Logger.getLogger(UsuarioService.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Transactional(readOnly = false)
    public void update(UsuarioEntity entity) throws Exception { 
        String senha = SecurityGeneric.getSecurePassword(entity.getSenha());
        entity.setSenha(senha);
        repository.update(entity);
    }

    @Transactional(readOnly = false)
    public void remove(Long id) throws Exception { repository.delete(id); }

    public UsuarioEntity findById(Long id) { return repository.findById(id); }

    public UsuarioEntity findByLogin(String email, String senha) {
        senha = SecurityGeneric.getSecurePassword(senha);
        return repository.findByLogin(email, senha);
    }

    @Transactional(readOnly = true)
    public List<UsuarioEntity> buscarTodos() { return repository.findAll(); }
}
