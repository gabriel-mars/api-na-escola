package com.gabriel.martins.apinaescola.model.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "boletim_aluno_componente")
public class BoletimAlunoComponenteEntity implements Serializable {
    @Id
    @SequenceGenerator(name = "generator", sequenceName = "seq_boletim_aluno_componente_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    @Basic(optional = false)
    @Column(name = "id", nullable = false, columnDefinition = "BIGINT DEFAULT NEXTVAL('seq_boletim_aluno_componente_id')")
    private Long id;

    @OneToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(name = "fk_boletim_aluno_id", columnDefinition = "bigint")
    private BoletimAlunoEntity boletimAluno;

    @OneToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(name = "fk_boletim_componente_id", columnDefinition = "bigint")
    private BoletimComponenteEntity boletimComponente;

    @Column(name = "faltas")
    private Integer faltas;

    @Column(name = "conceito")
    private String conceito;

    //GETTERS and SETTERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BoletimAlunoEntity getBoletimAluno() {
        return boletimAluno;
    }

    public void setBoletimAluno(BoletimAlunoEntity boletimAluno) {
        this.boletimAluno = boletimAluno;
    }

    public BoletimComponenteEntity getBoletimComponente() {
        return boletimComponente;
    }

    public void setBoletimComponente(BoletimComponenteEntity boletimComponente) {
        this.boletimComponente = boletimComponente;
    }

    public Integer getFaltas() {
        return faltas;
    }

    public void setFaltas(Integer faltas) {
        this.faltas = faltas;
    }

    public String getConceito() {
        return conceito;
    }

    public void setConceito(String conceito) {
        this.conceito = conceito;
    }
    //END - GETTERS and SETTERS

    //HASH and EQUALS
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BoletimAlunoComponenteEntity)) return false;

        BoletimAlunoComponenteEntity that = (BoletimAlunoComponenteEntity) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (getBoletimAluno() != null ? !getBoletimAluno().equals(that.getBoletimAluno()) : that.getBoletimAluno() != null)
            return false;
        if (getBoletimComponente() != null ? !getBoletimComponente().equals(that.getBoletimComponente()) : that.getBoletimComponente() != null)
            return false;
        if (getFaltas() != null ? !getFaltas().equals(that.getFaltas()) : that.getFaltas() != null) return false;
        return getConceito() != null ? getConceito().equals(that.getConceito()) : that.getConceito() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getBoletimAluno() != null ? getBoletimAluno().hashCode() : 0);
        result = 31 * result + (getBoletimComponente() != null ? getBoletimComponente().hashCode() : 0);
        result = 31 * result + (getFaltas() != null ? getFaltas().hashCode() : 0);
        result = 31 * result + (getConceito() != null ? getConceito().hashCode() : 0);
        return result;
    }
    //END - HASH and EQUALS
}
