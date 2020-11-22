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

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (getNome() != null ? !getNome().equals(that.getNome()) : that.getNome() != null) return false;
        if (getAnoClasse() != null ? !getAnoClasse().equals(that.getAnoClasse()) : that.getAnoClasse() != null)
            return false;
        if (getAnoLetivo() != null ? !getAnoLetivo().equals(that.getAnoLetivo()) : that.getAnoLetivo() != null)
            return false;
        if (getDescricao() != null ? !getDescricao().equals(that.getDescricao()) : that.getDescricao() != null)
            return false;
        if (getProfessor() != null ? !getProfessor().equals(that.getProfessor()) : that.getProfessor() != null)
            return false;
        if (getEscola() != null ? !getEscola().equals(that.getEscola()) : that.getEscola() != null) return false;
        if (getTurno() != that.getTurno()) return false;
        return getStatus() == that.getStatus();
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getNome() != null ? getNome().hashCode() : 0);
        result = 31 * result + (getAnoClasse() != null ? getAnoClasse().hashCode() : 0);
        result = 31 * result + (getAnoLetivo() != null ? getAnoLetivo().hashCode() : 0);
        result = 31 * result + (getDescricao() != null ? getDescricao().hashCode() : 0);
        result = 31 * result + (getProfessor() != null ? getProfessor().hashCode() : 0);
        result = 31 * result + (getEscola() != null ? getEscola().hashCode() : 0);
        result = 31 * result + (getTurno() != null ? getTurno().hashCode() : 0);
        result = 31 * result + (getStatus() != null ? getStatus().hashCode() : 0);
        return result;
    }
    //END - HASH and EQUALS
}
