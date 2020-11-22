package com.gabriel.martins.apinaescola.model.dao;

import com.gabriel.martins.apinaescola.model.entity.EscolaEntity;
import com.gabriel.martins.apinaescola.model.utils.BaseDAO;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Repository
public class EscolaRepository extends BaseDAO<EscolaEntity, Long> {

    @PersistenceContext
    private EntityManager manager;

    public EscolaEntity findByLogin(EscolaEntity escola) {
        TypedQuery<EscolaEntity> query = manager.createQuery("SELECT e FROM EscolaEntity e "
                + "WHERE e.email = :email AND e.senha = :senha", EscolaEntity.class);
        query.setParameter("email", escola.getEmail());
        query.setParameter("senha", escola.getSenha());

        return query.getSingleResult();
    }
}
