package com.gabriel.martins.apinaescola.model.dao;

import com.gabriel.martins.apinaescola.model.entity.BoletimEntity;
import com.gabriel.martins.apinaescola.model.utils.BaseDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

@Repository
public class BoletimRepository extends BaseDAO<BoletimEntity, Long> {
    
    @PersistenceContext
    private EntityManager manager;
    
    @SuppressWarnings("unchecked")
    public List<BoletimEntity> findByEscola(Long escolaId) {
        TypedQuery<BoletimEntity> query = manager.createQuery("SELECT b FROM BoletimEntity b "
                + "WHERE b.escola.id = :escola", BoletimEntity.class);
        query.setParameter("email", escolaId);

        return query.getResultList();
    }

//    public void saveComponente(BoletimComponente boletimComponente) {
//            Query query = manager.createNativeQuery("INSERT INTO boletim_componente (componente_id, boletim_id) VALUES (?, ?)")
//                            .setParameter(1, boletimComponente.getComponenteId())
//                            .setParameter(2, boletimComponente.getBoletimId());
//            query.executeUpdate();
//    }
//
//    @SuppressWarnings("unchecked")
//    public List<ComponenteCurricular> findByBoletim(Long boletimId) {
//            Query query = manager.createNativeQuery("SELECT BC.id, C.nome, C.tipo_avaliacao "
//                            + "FROM boletim_componente BC "
//                            + "INNER JOIN componente C on C.id = BC.componente_id "
//                            + "WHERE BC.boletim_id = ? ORDER BY BC.id")
//                            .setParameter(1, boletimId);
//
//            return query.getResultList();
//    }
//
//    public void removeComponente(Long id) {
//            Query query = manager.createNativeQuery("DELETE FROM boletim_componente WHERE id = ?")
//                            .setParameter(1, id);
//            query.executeUpdate();
//    }
//
//    public void updateBoletim(BoletimEntity boletim) {
//            Query query = manager.createNativeQuery("UPDATE boletim "
//                            + "SET bimestre = ?, classe_id = ?, observacao = ? "
//                            + "WHERE id = ?")
//                            .setParameter(1, boletim.getBimestre())
//                            .setParameter(2, boletim.getIdClasse())
//                            .setParameter(3, boletim.getObservacao())
//                            .setParameter(4, boletim.getId());
//            query.executeUpdate();
//    }
//
//    public void saveAll(List<BoletimAluno> boletins) {
//            for (BoletimAluno ba : boletins) {
//                    manager.persist(ba);
//            }
//
//            manager.flush();
//            manager.clear();
//    }
//
//    public void generatedBoletim(Long id) {
//            Query query = manager.createNativeQuery("UPDATE boletim "
//                            + "SET individual_criado = 'Sim' "
//                            + "WHERE id = ?")
//                            .setParameter(1, id);
//            query.executeUpdate();
//    }
//
//    @SuppressWarnings("unchecked")
//    public List<Object[]> findComponentesBoletim(Long id) {
//            Query query = manager.createNativeQuery("SELECT BC.id, BC.componente_id, BC.boletim_id FROM boletim_componente BC WHERE BC.boletim_id = ?")
//                            .setParameter(1, id);
//
//            return query.getResultList();
//    }
//
//    public void saveAllBoletins(List<BoletimAlunoComponente> boletins) {
//            for (BoletimAlunoComponente bac : boletins) {
//                    manager.persist(bac);
//            }
//
//            manager.flush();
//            manager.clear();
//    }
//
//    @SuppressWarnings("unchecked")
//    public List<Object[]> findBoletimAlunos(Long id) {
//            Query query = manager.createNativeQuery("SELECT BA.id, BA.boletim_id, BA.aluno_id "
//                            + "FROM boletim_aluno BA "
//                            + "WHERE BA.boletim_id = ?")
//                            .setParameter(1, id);
//
//            return query.getResultList();
//    }
//
//    @SuppressWarnings("unchecked")
//    public List<Object[]> findAllComponentesBoletim(Long id) {
//            Query query = manager.createNativeQuery("SELECT BAC.id, BAC.boletim_componente_id, C.nome, C.tipo_avaliacao, BAC.conceito FROM boletim_aluno_componente BAC "
//                            + "INNER JOIN boletim_componente BC ON BC.id = BAC.boletim_componente_id "
//                            + "INNER JOIN componente C ON C.id = BC.componente_id "
//                            + "INNER JOIN boletim_aluno BA ON BA.id = BAC.boletim_aluno_id "
//                            + "WHERE BA.aluno_id = ?")
//                            .setParameter(1, id);
//
//            return query.getResultList();
//    }
//
//    public void updateComponenteAlunoBoletins(BoletimAlunoComponente componente) {
//            Query query = manager.createNativeQuery("UPDATE boletim_aluno_componente "
//                            + "SET conceito = ? "
//                            + "WHERE id = ?")
//                            .setParameter(1, componente.getConceito())
//                            .setParameter(2, componente.getId());
//            query.executeUpdate();
//    }
}
