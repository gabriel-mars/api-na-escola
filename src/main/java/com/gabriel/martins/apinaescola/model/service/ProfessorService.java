package com.gabriel.martins.apinaescola.model.service;

import com.gabriel.martins.apinaescola.model.dao.EmailRepository;
import com.gabriel.martins.apinaescola.model.dao.EscolaRepository;
import com.gabriel.martins.apinaescola.model.dao.ProfessorRepository;
import com.gabriel.martins.apinaescola.model.dao.UsuarioRepository;
import com.gabriel.martins.apinaescola.model.entity.EmailEntity;
import com.gabriel.martins.apinaescola.model.entity.EscolaEntity;
import com.gabriel.martins.apinaescola.model.entity.ProfessorEntity;
import com.gabriel.martins.apinaescola.model.utils.SecurityGeneric;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class ProfessorService {
    
    @Autowired
    private ProfessorRepository repository;
    
    @Autowired
    private UsuarioRepository userRepository;

    @Autowired
    private EmailRepository emailRepository;

    @Transactional(readOnly = false)
    public void save(ProfessorEntity entity) throws Exception {
        try {
            
            entity.getUsuario().setSenha(SecurityGeneric.gerarSenhaAleatoria());
            entity.getUsuario().setSenha(SecurityGeneric.getSecurePassword(entity.getUsuario().getSenha()));
            entity.getUsuario().setHash(SecurityGeneric.getHashUser(entity.getUsuario().getCpf()));
            entity.setSenhaGerada(entity.getUsuario().getSenha());
            
            userRepository.save(entity.getUsuario());
            repository.save(entity);

            EmailEntity email = new EmailEntity();
            email.setCodigoProfessor(SecurityGeneric.generateSecurityKey());
            email.setSenhaProfessor(entity.getUsuario().getSenha());
            email.setEmailProfessor(entity.getUsuario().getEmail());
            email.setEmailEscola(entity.getEscola().getEmail());
            email.setNomeEscola(entity.getEscola().getNome());
            email.setNomeProfessor(entity.getUsuario().getNome());
            email.setCodigoMec(entity.getEscola().getCodigoMec());
            email.setCaracteristica("cadastro");
            email.setEnviado(Boolean.FALSE);

            emailRepository.save(email);
        } catch (Exception e) {
            Logger.getLogger(EscolaService.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Transactional(readOnly = false)
    public void update(ProfessorEntity entity) throws Exception { 
        repository.update(entity);
    }
    
    @Transactional(readOnly = false)
    public void updateSenha(ProfessorEntity entity) throws Exception { 
        String senha = SecurityGeneric.getSecurePassword(entity.getUsuario().getSenha());
        entity.getUsuario().setSenha(senha);
        repository.update(entity);
    }

    @Transactional(readOnly = false)
    public void remove(Long id) throws Exception { repository.delete(id); }

    public ProfessorEntity findById(Long id) { return repository.findById(id); }

    public ProfessorEntity findByLogin(String email, String senha) {
        senha = SecurityGeneric.getSecurePassword(senha);
        return repository.findByLogin(email, senha);
    }

    @Transactional(readOnly = true)
    public List<ProfessorEntity> buscarTodos() { return repository.findAll(); }

    public List<ProfessorEntity> findByEscola(Long id) {
        return repository.findByEscola(id);
    }
}
