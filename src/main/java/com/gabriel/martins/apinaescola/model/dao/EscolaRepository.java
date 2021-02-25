package com.gabriel.martins.apinaescola.model.dao;

import com.gabriel.martins.apinaescola.model.entity.DiaLetivoEntity;
import com.gabriel.martins.apinaescola.model.entity.EscolaEntity;
import com.gabriel.martins.apinaescola.model.entity.RequisicaoEntity;
import com.gabriel.martins.apinaescola.model.entity.UsuarioEntity;
import com.gabriel.martins.apinaescola.model.utils.BaseDAO;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

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

    public EscolaEntity readByCodigo(Integer codigoMecEscola) {
        TypedQuery<EscolaEntity> query = manager.createQuery("SELECT e FROM EscolaEntity e "
                + "WHERE e.codigoMec = :codigoMec", EscolaEntity.class);
        query.setParameter("codigoMec", codigoMecEscola);

        return query.getSingleResult();
    }

    public void updateSenhaEscola(EscolaEntity escola) {
        TypedQuery<EscolaEntity> query = manager.createQuery("UPDATE EscolaEntity SET senha = :senha, confirmacao = :confirmacao WHERE id = :id", EscolaEntity.class);
        query.setParameter("senha", escola.getSenha());
        query.setParameter("confirmacao", escola.getConfirmacao());
        query.setParameter("id", escola.getId());
        query.executeUpdate();
    }

    public void finishCreateEscola(EscolaEntity escola) {
        TypedQuery<EscolaEntity> query = manager.createQuery("UPDATE EscolaEntity SET telefone = :telefone, endereco = :endereco, uf = :uf, municipio = :municipio, cep = :cep WHERE codigoMec = :codigoMec", EscolaEntity.class);
        query.setParameter("telefone", escola.getTelefone());
        query.setParameter("endereco", escola.getEndereco());
        query.setParameter("uf", escola.getUf());
        query.setParameter("municipio", escola.getMunicipio());
        query.setParameter("cep", escola.getCep());
        query.setParameter("codigoMec", escola.getCodigoMec());
        query.executeUpdate();
    }

    @SuppressWarnings("unchecked")
    public List<RequisicaoEntity> findRequisicoes(Long id) {
        TypedQuery<RequisicaoEntity> query = manager.createQuery("SELECT R.id, P.nome, R.tipo_requisicao, R.requisicao_aluno_id, R.observacao FROM RequisicaoEntity R "
                + "INNER JOIN ResponsavelEntity RP ON RP.id = R.responsavel.id "
                + "INNER JOIN PessoaEntity P ON P.id = RP.usuario.id "
                + "WHERE R.escola.id = :id", RequisicaoEntity.class);
        query.setParameter("id", id);

        return query.getResultList();
    }

    public void saveAllDiasLetivos(List<DiaLetivoEntity> dias) {
        for (DiaLetivoEntity dl : dias) {
            manager.persist(dl);
        }

        manager.flush();
        manager.clear();
    }

    @SuppressWarnings("unchecked")
    public List<DiaLetivoEntity> findDiasLetivosByEscola(Long escolaId) {
        TypedQuery<DiaLetivoEntity> query = manager.createQuery("SELECT DL.id, DL.escola.id, DL.dia FROM DiaLetivoEntity DL "
                + "WHERE DL.escola.id = :id", DiaLetivoEntity.class);
        query.setParameter("id", escolaId);

        return query.getResultList();
    }
    
    public List<EscolaEntity> findByUser(UsuarioEntity user) {
        TypedQuery<EscolaEntity> query = manager.createQuery("SELECT e FROM EscolaEntity e "
                + "WHERE e.diretor = :diretor", EscolaEntity.class);
        query.setParameter("diretor", user);

        return query.getResultList();
    }
}
