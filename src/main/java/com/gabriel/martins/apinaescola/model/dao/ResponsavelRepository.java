package com.gabriel.martins.apinaescola.model.dao;

import com.gabriel.martins.apinaescola.model.entity.ResponsavelEntity;
import com.gabriel.martins.apinaescola.model.utils.BaseDAO;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

@Repository
public class ResponsavelRepository extends BaseDAO<ResponsavelEntity, Long> {
    
    @PersistenceContext
    private EntityManager manager;
    
    @SuppressWarnings("unchecked")
    public ResponsavelEntity findDataResponsavel(String codigoAluno) {
        TypedQuery<ResponsavelEntity> query = manager.createQuery("SELECT R FROM ResponsavelEntity R "
                + "INNER JOIN AlunoEntity A on A.responsavel.id = R.id "
                + "WHERE A.codigoGeradoEscola LIKE :codigo", ResponsavelEntity.class);
                query.setParameter("codigo", codigoAluno);
        return query.getSingleResult();
    }
}
