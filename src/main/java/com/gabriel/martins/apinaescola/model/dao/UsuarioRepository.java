/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gabriel.martins.apinaescola.model.dao;

import com.gabriel.martins.apinaescola.model.entity.ProfessorEntity;
import com.gabriel.martins.apinaescola.model.entity.UsuarioEntity;
import com.gabriel.martins.apinaescola.model.utils.BaseDAO;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

/**
 *
 * @author b2ml
 */
@Repository
public class UsuarioRepository extends BaseDAO<UsuarioEntity, Long> {
    
    @PersistenceContext
    private EntityManager manager;
    
    @SuppressWarnings("unchecked")
    public UsuarioEntity findByLogin(String email, String senha) {       
        TypedQuery<UsuarioEntity> query = manager.createQuery("SELECT u FROM UsuarioEntity u "
                + "WHERE u.email = :email AND u.senha = :senha", UsuarioEntity.class);
        query.setParameter("email", email);
        query.setParameter("senha", senha);

        return query.getSingleResult();
    }
}
