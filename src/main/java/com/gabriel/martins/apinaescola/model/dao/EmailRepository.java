package com.gabriel.martins.apinaescola.model.dao;

import com.gabriel.martins.apinaescola.model.entity.EmailEntity;
import com.gabriel.martins.apinaescola.model.utils.BaseDAO;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class EmailRepository extends BaseDAO<EmailEntity, Long> {
    @PersistenceContext
    private EntityManager manager;

    public List<EmailEntity> findByNotSend() {
        TypedQuery<EmailEntity> query = manager.createQuery("SELECT e FROM EmailEntity e "
                + "WHERE e.enviado = 'nao' AND e.descricaoDuvida IS NOT NULL AND e.caracteristica = 'duvida'", EmailEntity.class);

        return query.getResultList();
    }

    public List<EmailEntity> findByNotSendProfessor() {
        TypedQuery<EmailEntity> query = manager.createQuery("SELECT e FROM EmailEntity e "
                + "WHERE e.enviado = 'nao' AND e.emailProfessor IS NOT NULL AND e.codigoMec IS NOT NULL AND e.caracteristica = 'cadastro'", EmailEntity.class);

        return query.getResultList();
    }

    public List<EmailEntity> findByNotSendEscola() {
        TypedQuery<EmailEntity> query = manager.createQuery("SELECT e FROM EmailEntity e "
                + "WHERE e.enviado = 'nao' AND e.codigoMec IS NOT NULL AND e.senhaEscola IS NULL AND e.caracteristica = 'cadastro'", EmailEntity.class);
        return query.getResultList();
    }

    public List<EmailEntity> findByNotSendSenha() {
        TypedQuery<EmailEntity> query = manager.createQuery("SELECT e FROM EmailEntity e "
                + "WHERE e.enviado = 'nao' AND e.senhaEscola IS NOT NULL AND e.caracteristica = 'senha'", EmailEntity.class);
        return query.getResultList();
    }

    public List<EmailEntity> findByNotSendSenhaProfessor() {
        TypedQuery<EmailEntity> query = manager.createQuery("SELECT e FROM EmailEntity e "
                + "WHERE e.enviado = 'nao' AND e.emailProfessor IS NOT NULL AND e.senhaProfessor IS NOT NULL AND e.caracteristica = 'senha'", EmailEntity.class);
        return query.getResultList();
    }
}
