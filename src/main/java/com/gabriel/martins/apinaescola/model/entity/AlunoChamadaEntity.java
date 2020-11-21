package com.gabriel.martins.apinaescola.model.entity;

import com.gabriel.martins.apinaescola.model.enums.STATUS_CHAMADA;
import com.google.gson.annotations.Expose;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "aluno_chamada")
public class AlunoChamadaEntity implements Serializable {
    @Id
    @SequenceGenerator(name = "generator", sequenceName = "seq_aluno_chamada_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    @Basic(optional = false)
    @Column(name = "id", nullable = false, columnDefinition = "BIGINT DEFAULT NEXTVAL('seq_aluno_chamada_id')")
    private Long id;

    @OneToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(name = "fk_aluno_id", columnDefinition = "bigint")
    private AlunoEntity aluno;

    @OneToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(name = "fk_chamada_id", columnDefinition = "bigint")
    private ChamadaEntity chamada;

    @Column(name = "turno")
    @Enumerated(EnumType.STRING)
    @Expose
    private STATUS_CHAMADA status;

    @Column(name = "falta", nullable = false)
    private Integer falta;

    //GETTERS and SETTERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AlunoEntity getAluno() {
        return aluno;
    }

    public void setAluno(AlunoEntity aluno) {
        this.aluno = aluno;
    }

    public ChamadaEntity getChamada() {
        return chamada;
    }

    public void setChamada(ChamadaEntity chamada) {
        this.chamada = chamada;
    }

    public STATUS_CHAMADA getStatus() {
        return status;
    }

    public void setStatus(STATUS_CHAMADA status) {
        this.status = status;
    }

    public Integer getFalta() {
        return falta;
    }

    public void setFalta(Integer falta) {
        this.falta = falta;
    }
    //END - GETTERS and SETTERS

    //HASH and EQUALS
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AlunoChamadaEntity)) return false;
        AlunoChamadaEntity that = (AlunoChamadaEntity) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getAluno(), that.getAluno()) &&
                Objects.equals(getChamada(), that.getChamada()) &&
                getStatus() == that.getStatus() &&
                Objects.equals(getFalta(), that.getFalta());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAluno(), getChamada(), getStatus(), getFalta());
    }
    //END - HASH and EQUALS
}
