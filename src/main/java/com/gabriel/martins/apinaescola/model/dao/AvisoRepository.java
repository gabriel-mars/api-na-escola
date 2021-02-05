package com.gabriel.martins.apinaescola.model.dao;

import com.gabriel.martins.apinaescola.model.entity.AlunoEntity;
import com.gabriel.martins.apinaescola.model.entity.AvisoEntity;
import com.gabriel.martins.apinaescola.model.utils.BaseDAO;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

@Repository
public class AvisoRepository extends BaseDAO<AvisoEntity, Long> {
    
    @PersistenceContext
    private EntityManager manager;
    
    @SuppressWarnings("unchecked")
    public List<AvisoEntity> findByEscola(Long idEscola) {
        TypedQuery<AvisoEntity> query = manager.createQuery("SELECT a FROM AvisoEntity a "
                + "WHERE a.escola.id = :escola", AvisoEntity.class);
        query.setParameter("escola", idEscola);
        return query.getResultList();
    }

    @SuppressWarnings("unchecked")
    public List<AvisoEntity> findByProfessor(Long idProfessor) {
        TypedQuery<AvisoEntity> query = manager.createQuery("SELECT a FROM AvisoEntity a "
                + "WHERE a.professor.id = :professor", AvisoEntity.class);
        query.setParameter("professor", idProfessor);
        return query.getResultList();
    }

    @SuppressWarnings("unchecked")
    public List<AvisoEntity> findByDay(Long idEscola, Date data) {
        TypedQuery<AvisoEntity> query = manager.createQuery("SELECT a FROM AvisoEntity a "
                + "WHERE a.professor.id = :professor AND A.dataAviso = :data", AvisoEntity.class);
        query.setParameter("escola", idEscola);
        query.setParameter("data", data);
        return query.getResultList();
    }
}
