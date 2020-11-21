package com.gabriel.martins.apinaescola.model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "aluno")
public class AlunoEntity implements Serializable {
    @Id
    @SequenceGenerator(name = "generator", sequenceName = "seq_aluno_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    @Basic(optional = false)
    @Column(name = "id", nullable = false, columnDefinition = "BIGINT DEFAULT NEXTVAL('seq_aluno_id')")
    private Long id;

    @Column(name = "data_nascimento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;

    @Column(name = "matricula", nullable = false, length = 10)
    private String matricula;

    @Column(name = "data_matricula", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataMatricula;

    @Column(name = "codigo_gerado_escola", nullable = false, length = 8)
    private String codigoGeradoEscola;

    @Column(name = "nome_pai", length = 50)
    private String nomePai;

    @Column(name = "nome_mae", nullable = false, length = 50)
    private String nomeMae;

    @Column(name = "situacao", nullable = false)
    private String situacao;

    @Column(name = "justificativa")
    private String justificativa;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_escola_id", columnDefinition = "bigint")
    private EscolaEntity escola;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_responsavel_id", columnDefinition = "bigint")
    private ResponsavelEntity responsavel;

    //GETTERS and SETTERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Date getDataMatricula() {
        return dataMatricula;
    }

    public void setDataMatricula(Date dataMatricula) {
        this.dataMatricula = dataMatricula;
    }

    public String getCodigoGeradoEscola() {
        return codigoGeradoEscola;
    }

    public void setCodigoGeradoEscola(String codigoGeradoEscola) {
        this.codigoGeradoEscola = codigoGeradoEscola;
    }

    public String getNomePai() {
        return nomePai;
    }

    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getJustificativa() {
        return justificativa;
    }

    public void setJustificativa(String justificativa) {
        this.justificativa = justificativa;
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
    //END - GETTERS and SETTERS

    //HASH and EQUALS
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AlunoEntity)) return false;
        AlunoEntity that = (AlunoEntity) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getDataNascimento(), that.getDataNascimento()) &&
                Objects.equals(getMatricula(), that.getMatricula()) &&
                Objects.equals(getDataMatricula(), that.getDataMatricula()) &&
                Objects.equals(getCodigoGeradoEscola(), that.getCodigoGeradoEscola()) &&
                Objects.equals(getNomePai(), that.getNomePai()) &&
                Objects.equals(getNomeMae(), that.getNomeMae()) &&
                Objects.equals(getSituacao(), that.getSituacao()) &&
                Objects.equals(getJustificativa(), that.getJustificativa()) &&
                Objects.equals(getEscola(), that.getEscola()) &&
                Objects.equals(getResponsavel(), that.getResponsavel());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDataNascimento(), getMatricula(), getDataMatricula(), getCodigoGeradoEscola(), getNomePai(), getNomeMae(), getSituacao(), getJustificativa(), getEscola(), getResponsavel());
    }

    //END - HASH and EQUALS
}
