package com.gabriel.martins.apinaescola.model.entity;

import com.gabriel.martins.apinaescola.model.enums.TIPO_REQUISICAO;
import com.google.gson.annotations.Expose;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "requisicao")
public class RequisicaoEntity implements Serializable {
    @Id
    @SequenceGenerator(name = "generator", sequenceName = "seq_requisicao_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    @Basic(optional = false)
    @Column(name = "id", nullable = false, columnDefinition = "BIGINT DEFAULT NEXTVAL('seq_requisicao_id')")
    private Long id;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_escola_id", columnDefinition = "bigint")
    private EscolaEntity escola;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_responsavel_id", columnDefinition = "bigint")
    private ResponsavelEntity responsavel;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_aluno_id", columnDefinition = "bigint")
    private AlunoEntity aluno;

    @Column(name = "observacao")
    private String observacao;

    @Column(name = "tipo_requisicao")
    @Enumerated(EnumType.STRING)
    @Expose
    private TIPO_REQUISICAO tipoRequisicao;

    //GETTERS and SETTERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EscolaEntity getEscola() {
        return escola;
    }

    public void setEscola(EscolaEntity escola) {
        this.escola = escola;
    }

    public ResponsavelEntity getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(ResponsavelEntity responsavel) {
        this.responsavel = responsavel;
    }

    public AlunoEntity getAluno() {
        return aluno;
    }

    public void setAluno(AlunoEntity aluno) {
        this.aluno = aluno;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public TIPO_REQUISICAO getTipoRequisicao() {
        return tipoRequisicao;
    }

    public void setTipoRequisicao(TIPO_REQUISICAO tipoRequisicao) {
        this.tipoRequisicao = tipoRequisicao;
    }
    //END - GETTERS and SETTERS

    //HASH and EQUALS
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RequisicaoEntity)) return false;

        RequisicaoEntity that = (RequisicaoEntity) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (getEscola() != null ? !getEscola().equals(that.getEscola()) : that.getEscola() != null) return false;
        if (getResponsavel() != null ? !getResponsavel().equals(that.getResponsavel()) : that.getResponsavel() != null)
            return false;
        if (getAluno() != null ? !getAluno().equals(that.getAluno()) : that.getAluno() != null) return false;
        if (getObservacao() != null ? !getObservacao().equals(that.getObservacao()) : that.getObservacao() != null)
            return false;
        return getTipoRequisicao() == that.getTipoRequisicao();
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getEscola() != null ? getEscola().hashCode() : 0);
        result = 31 * result + (getResponsavel() != null ? getResponsavel().hashCode() : 0);
        result = 31 * result + (getAluno() != null ? getAluno().hashCode() : 0);
        result = 31 * result + (getObservacao() != null ? getObservacao().hashCode() : 0);
        result = 31 * result + (getTipoRequisicao() != null ? getTipoRequisicao().hashCode() : 0);
        return result;
    }
    //END - HASH and EQUALS
}
