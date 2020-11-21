package com.gabriel.martins.apinaescola.model.entity;

import com.gabriel.martins.apinaescola.model.enums.STATUS_CLASSE;
import com.gabriel.martins.apinaescola.model.enums.TURNO_CLASSE;
import com.google.gson.annotations.Expose;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "classe")
public class ClasseEntity implements Serializable {
    @Id
    @SequenceGenerator(name = "generator", sequenceName = "seq_classe_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    @Basic(optional = false)
    @Column(name = "id", nullable = false, columnDefinition = "BIGINT DEFAULT NEXTVAL('seq_classe_id')")
    private Long id;

    @Column(name = "nome", nullable = false, length = 50)
    private String nome;

    @Column(name = "ano_classe", nullable = false)
    private String anoClasse;

    @Column(name = "ano_letivo", nullable = false)
    private String anoLetivo;

    @Column(name = "descricao")
    private String descricao;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_professor_id", columnDefinition = "bigint")
    private ProfessorEntity professor;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_escola_id", columnDefinition = "bigint")
    private EscolaEntity escola;

    @Column(name = "turno")
    @Enumerated(EnumType.STRING)
    @Expose
    private TURNO_CLASSE turno;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    @Expose
    private STATUS_CLASSE status;

    //GETTERS and SETTERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAnoClasse() {
        return anoClasse;
    }

    public void setAnoClasse(String anoClasse) {
        this.anoClasse = anoClasse;
    }

    public String getAnoLetivo() {
        return anoLetivo;
    }

    public void setAnoLetivo(String anoLetivo) {
        this.anoLetivo = anoLetivo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public ProfessorEntity getProfessor() {
        return professor;
    }

    public void setProfessor(ProfessorEntity professor) {
        this.professor = professor;
    }

    public EscolaEntity getEscola() {
        return escola;
    }

    public void setEscola(EscolaEntity escola) {
        this.escola = escola;
    }

    public TURNO_CLASSE getTurno() {
        return turno;
    }

    public void setTurno(TURNO_CLASSE turno) {
        this.turno = turno;
    }

    public STATUS_CLASSE getStatus() {
        return status;
    }

    public void setStatus(STATUS_CLASSE status) {
        this.status = status;
    }
    //END - GETTERS and SETTERS

    //HASH and EQUALS
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClasseEntity)) return false;
        ClasseEntity that = (ClasseEntity) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getNome(), that.getNome()) &&
                Objects.equals(getAnoClasse(), that.getAnoClasse()) &&
                Objects.equals(getAnoLetivo(), that.getAnoLetivo()) &&
                Objects.equals(getDescricao(), that.getDescricao()) &&
                Objects.equals(getProfessor(), that.getProfessor()) &&
                Objects.equals(getEscola(), that.getEscola()) &&
                getTurno() == that.getTurno() &&
                getStatus() == that.getStatus();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNome(), getAnoClasse(), getAnoLetivo(), getDescricao(), getProfessor(), getEscola(), getTurno(), getStatus());
    }
    //END - HASH and EQUALS
}
