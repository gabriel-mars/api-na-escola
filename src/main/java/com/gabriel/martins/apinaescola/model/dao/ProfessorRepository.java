package com.gabriel.martins.apinaescola.model.dao;

import com.gabriel.martins.apinaescola.model.entity.ProfessorEntity;
import com.gabriel.martins.apinaescola.model.utils.BaseDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

@Repository
public class ProfessorRepository extends BaseDAO<ProfessorEntity, Long>{
    
    @PersistenceContext
    private EntityManager manager;
    
    @SuppressWarnings("unchecked")
    public ProfessorEntity findByLogin(String email, String senha) {       
        TypedQuery<ProfessorEntity> query = manager.createQuery("SELECT p FROM ProfessorEntity p "
                + "WHERE p.usuario.email = :email AND p.usuario.senha = :senha", ProfessorEntity.class);
        query.setParameter("email", email);
        query.setParameter("senha", senha);

        return query.getSingleResult();
    }

    @SuppressWarnings("unchecked")
    public List<ProfessorEntity> findByEscola(Long escolaId) {
        TypedQuery<ProfessorEntity> query = manager.createQuery("SELECT p.id, p.usuario.nome FROM ProfessorEntity p "
                + "WHERE p.escola.id = :escola", ProfessorEntity.class);
        query.setParameter("escola", escolaId);

        return query.getResultList();
    }

    @SuppressWarnings("unchecked")
    public ProfessorEntity findByCodigo(String codigoGerado) {
        TypedQuery<ProfessorEntity> query = manager.createQuery("SELECT p FROM ProfessorEntity p "
                + "WHERE p.codigoGeradoEscola = :codigo", ProfessorEntity.class);
        query.setParameter("codigo", codigoGerado);
        
        return query.getSingleResult();
    }
}
