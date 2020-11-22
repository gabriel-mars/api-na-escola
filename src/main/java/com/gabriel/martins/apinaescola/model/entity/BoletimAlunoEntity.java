package com.gabriel.martins.apinaescola.model.entity;

import com.gabriel.martins.apinaescola.model.enums.STATUS_BOLETIM;
import com.google.gson.annotations.Expose;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "boletim_aluno")
public class BoletimAlunoEntity implements Serializable {
    @Id
    @SequenceGenerator(name = "generator", sequenceName = "seq_boletim_aluno_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    @Basic(optional = false)
    @Column(name = "id", nullable = false, columnDefinition = "BIGINT DEFAULT NEXTVAL('seq_boletim_aluno_id')")
    private Long id;

    @OneToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(name = "fk_aluno_id", columnDefinition = "bigint")
    private AlunoEntity aluno;

    @OneToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(name = "fk_boletim_id", columnDefinition = "bigint")
    private BoletimEntity boletim;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    @Expose
    private STATUS_BOLETIM status;

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

    public BoletimEntity getBoletim() {
        return boletim;
    }

    public void setBoletim(BoletimEntity boletim) {
        this.boletim = boletim;
    }

    public STATUS_BOLETIM getStatus() {
        return status;
    }

    public void setStatus(STATUS_BOLETIM status) {
        this.status = status;
    }
    //END - GETTERS and SETTERS

    //HASH and EQUALS
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BoletimAlunoEntity)) return false;

        BoletimAlunoEntity that = (BoletimAlunoEntity) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (getAluno() != null ? !getAluno().equals(that.getAluno()) : that.getAluno() != null) return false;
        if (getBoletim() != null ? !getBoletim().equals(that.getBoletim()) : that.getBoletim() != null) return false;
        return getStatus() == that.getStatus();
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getAluno() != null ? getAluno().hashCode() : 0);
        result = 31 * result + (getBoletim() != null ? getBoletim().hashCode() : 0);
        result = 31 * result + (getStatus() != null ? getStatus().hashCode() : 0);
        return result;
    }
    //END - HASH and EQUALS
}
