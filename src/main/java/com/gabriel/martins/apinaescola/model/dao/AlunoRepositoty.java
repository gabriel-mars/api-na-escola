package com.gabriel.martins.apinaescola.model.dao;

import com.gabriel.martins.apinaescola.model.entity.AlunoEntity;
import com.gabriel.martins.apinaescola.model.utils.BaseDAO;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class AlunoRepositoty extends BaseDAO<AlunoEntity, Long> {
    @PersistenceContext
    private EntityManager manager;

    public void updateAluno(AlunoEntity aluno) {
//        Query query = manager.createNativeQuery("UPDATE aluno "
//                + "SET data_nascimento = ?, data_matricula = ?, cpf_responsavel = ?, matricula = ?, nome_mae = ?, nome_pai = ?, nome_responsavel = ?, situacao = ?, justificativa = ? "
//                + "WHERE id = ?")
//                .setParameter("dataNascimento", aluno.getDataNascimento())
//                .setParameter("dataMatricula", aluno.getDataMatricula())
//                .setParameter("cpf", aluno.getCpfResponsavel())
//                .setParameter(4, aluno.getMatricula())
//                .setParameter(5, aluno.getNomeMae())
//                .setParameter(6, aluno.getNomePai())
//                .setParameter(7, aluno.getNomeResponsavel())
//                .setParameter(8, aluno.getSituacao())
//                .setParameter(9, aluno.getJustificativa())
//                .setParameter(10, aluno.getId());
//        query.executeUpdate();

    }

//    @SuppressWarnings("unchecked")
//    public List<AlunoEntity> findByEscola(Long escolaId) {
//        Query query = manager.createNativeQuery("SELECT "
//                + "A.id, P.nome, P.cpf, A.data_nascimento, A.data_matricula, A.cpf_responsavel, A.matricula, A.nome_mae, A.nome_pai, A.nome_responsavel, A.situacao, A.justificativa, A.codigo_gerado_escola "
//                + "FROM aluno A "
//                + "INNER JOIN pessoa P ON P.id = A.pessoa_id "
//                + "WHERE A.escola_id = ?")
//                .setParameter(1, escolaId);
//        return query.getResultList();
//    }

//    @SuppressWarnings("unchecked")
//    public List<AlunoEntity> findByNoClass(Long escolaId) {
//        Query query = manager.createNativeQuery("SELECT "
//                + "A.id, P.nome, P.cpf, A.data_nascimento, A.data_matricula, A.cpf_responsavel, A.matricula, A.nome_mae, A.nome_pai, A.nome_responsavel, A.situacao, A.justificativa, A.codigo_gerado_escola "
//                + "FROM aluno A "
//                + "INNER JOIN pessoa P ON P.id = A.pessoa_id "
//                + "LEFT JOIN aluno_classe AC ON AC.aluno_id = A.id "
//                + "WHERE A.escola_id = ? and AC.aluno_id is null").setParameter(1, escolaId);
//        return query.getResultList();
//    }

//    @SuppressWarnings("unchecked")
//    public List<AlunoEntity> findByClass(Long idClasse) {
//        Query query = manager.createNativeQuery("SELECT A.id, P.nome, A.matricula, A.situacao "
//                + "FROM aluno A "
//                + "INNER JOIN pessoa P ON P.id = A.pessoa_id "
//                + "INNER JOIN aluno_classe AC ON AC.aluno_id = A.id "
//                + "WHERE AC.classe_id = ?").setParameter(1, idClasse);
//        return query.getResultList();
//    }

//    @SuppressWarnings("unchecked")
//    public AlunoEntity searchById(Long id) {
//        Query query = manager.createNativeQuery("SELECT P.nome, P.cpf, A.id, A.codigo_gerado_escola, A.cpf_responsavel, A.data_matricula, A.data_nascimento, A.matricula, A.nome_mae, A.nome_pai, A.nome_responsavel, A.situacao, A.pessoa_id "
//                + "FROM aluno A "
//                + "INNER JOIN pessoa P on P.id = A.pessoa_id "
//                + "WHERE A.id = ?")
//                .setParameter(1, id);
//        return query.getResultList();
//    }

    public void excludeAluno(Long id) {
//        Query query = manager.createNativeQuery("DELETE FROM aluno A WHERE A.id = ?").setParameter(1, id);
//        query.executeUpdate();
    }

//    @SuppressWarnings("unchecked")
//    public List<Object[]> findByClasseBoletim(Long id) {
//        Query query = manager.createNativeQuery("SELECT A.id, P.nome, A.matricula, A.situacao "
//                + "FROM aluno A "
//                + "INNER JOIN pessoa P ON P.id = A.pessoa_id "
//                + "INNER JOIN aluno_classe AC ON AC.aluno_id = A.id "
//                + "WHERE AC.classe_id = ?").setParameter(1, id);
//        return query.getResultList();
//    }

//    @SuppressWarnings("unchecked")
//    public List<AlunoEntity> findByName(String nome, Long id) {
//        Query query = manager.createNativeQuery("SELECT "
//                + "A.id, P.nome, P.cpf, A.data_nascimento, A.data_matricula, A.cpf_responsavel, A.matricula, A.nome_mae, A.nome_pai, A.nome_responsavel, A.situacao, A.justificativa, A.codigo_gerado_escola "
//                + "FROM aluno A "
//                + "INNER JOIN pessoa P ON P.id = A.pessoa_id "
//                + "WHERE A.escola_id = ? AND P.nome ~ ?")
//                .setParameter(1, id)
//                .setParameter(2, nome);
//        return query.getResultList();
//    }

//    @SuppressWarnings("unchecked")
//    public List<AlunoEntity> findByProfessor(Long id) {
//        Query query = manager.createNativeQuery("SELECT A.id, P.nome, C.nome as classe_nome FROM aluno A "
//                + "INNER JOIN pessoa P on P.id = A.pessoa_id "
//                + "INNER JOIN aluno_classe AC on AC.aluno_id = A.id "
//                + "INNER JOIN classe C on C.id = AC.classe_id "
//                + "INNER JOIN professor PR on PR.id = C.professor_id "
//                + "WHERE PR.id = ? ORDER BY A.id")
//                .setParameter(1, id);
//        return query.getResultList();
//    }

//    @SuppressWarnings("unchecked")
//    public List<AlunoEntity> findByNameProfessor(String nome, Long id) {
//        Query query = manager.createNativeQuery("SELECT A.id, P.nome, C.nome as classe_nome FROM aluno A "
//                + "INNER JOIN pessoa P on P.id = A.pessoa_id "
//                + "INNER JOIN aluno_classe AC on AC.aluno_id = A.id "
//                + "INNER JOIN classe C on C.id = AC.classe_id "
//                + "INNER JOIN professor PR on PR.id = C.professor_id "
//                + "WHERE PR.id = ? AND P.nome ~ ? ORDER BY A.id")
//                .setParameter(1, id)
//                .setParameter(2, nome);
//        return query.getResultList();
//    }

//    @SuppressWarnings("unchecked")
//    public List<Object[]> findDataResponsavel(String codigoAluno) {
//        Query query = manager.createNativeQuery("SELECT P.nome, P.telefone, P.email, P.endereco, P.municipio FROM pessoa P "
//                + "INNER JOIN responsavel R ON R.pessoa_id = P.id "
//                + "INNER JOIN responsavel_aluno RA ON RA.responsavel_id = R.id "
//                + "WHERE RA.codigo_aluno = ?")
//                .setParameter(1, codigoAluno);
//        return query.getResultList();
//    }
}
