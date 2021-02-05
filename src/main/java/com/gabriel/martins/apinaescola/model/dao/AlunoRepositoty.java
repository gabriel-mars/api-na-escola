package com.gabriel.martins.apinaescola.model.dao;

import com.gabriel.martins.apinaescola.model.entity.AlunoEntity;
import com.gabriel.martins.apinaescola.model.utils.BaseDAO;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import javax.persistence.TypedQuery;

@Repository
public class AlunoRepositoty extends BaseDAO<AlunoEntity, Long> {
    
    @PersistenceContext
    private EntityManager manager;

    @SuppressWarnings("unchecked")
    public List<AlunoEntity> findByEscola(Long escolaId) {
        TypedQuery<AlunoEntity> query = manager.createQuery("SELECT a FROM AlunoEntity a "
                + "WHERE a.escola.id = :escola", AlunoEntity.class);
        query.setParameter("escola", escolaId);
        return query.getResultList();
    }

    @SuppressWarnings("unchecked")
    public List<AlunoEntity> findByNoClass(Long escolaId) {
        TypedQuery<AlunoEntity> query = manager.createQuery("SELECT "
                + "A FROM AlunoEntity A "
                + "LEFT JOIN AlunoClasseEntity AC ON AC.aluno.id = A.id "
                + "WHERE A.escola.id = :escola and AC.aluno.id is null", AlunoEntity.class);
        query.setParameter("escola", escolaId);
        return query.getResultList();
    }

    @SuppressWarnings("unchecked")
    public List<AlunoEntity> findByClass(Long idClasse) {
        TypedQuery<AlunoEntity> query = manager.createQuery("SELECT A FROM AlunoEntity A "
                + "INNER JOIN AlunoClasseEntity AC ON AC.aluno.id = A.id "
                + "WHERE AC.classe.id = :classe", AlunoEntity.class);
        query.setParameter("classe", idClasse);
        return query.getResultList();
    }

    @SuppressWarnings("unchecked")
    public List<AlunoEntity> findByName(String nome, Long id) {        
        TypedQuery<AlunoEntity> query = manager.createQuery("SELECT A FROM AlunoEntity A "
                + "WHERE A.escola.id = :escola AND A.usuario.nome LIKE :nome ORDER BY A.id", AlunoEntity.class);
                query.setParameter("escola", id);
                query.setParameter("nome", nome);
        return query.getResultList();
    }

    @SuppressWarnings("unchecked")
    public List<AlunoEntity> findByProfessor(Long id) {
        TypedQuery<AlunoEntity> query = manager.createQuery("SELECT A FROM AlunoEntity A "
                + "INNER JOIN AlunoClasseEntity AC on AC.aluno.id = A.id "
                + "INNER JOIN ClasseEntity C on C.id = AC.classe.id "
                + "INNER JOIN ProfessorEntity PR on PR.id = C.professor.id "
                + "WHERE PR.id = :professor ORDER BY A.id", AlunoEntity.class);
                query.setParameter("professor", id);
        return query.getResultList();
    }

    @SuppressWarnings("unchecked")
    public List<AlunoEntity> findByNameProfessor(String nome, Long id) {
        TypedQuery<AlunoEntity> query = manager.createQuery("SELECT A FROM AlunoEntity A "
                + "INNER JOIN AlunoClasseEntity AC on AC.aluno.id = A.id "
                + "INNER JOIN ClasseEntity C on C.id = AC.classe.id "
                + "INNER JOIN ProfessorEntity PR on PR.id = C.professor.id "
                + "WHERE PR.id = :professor AND PR.usuario.nome LIKE :nome ORDER BY A.id", AlunoEntity.class);
                query.setParameter("professor", id);
                query.setParameter("nome", nome);
        return query.getResultList();
    }
}
