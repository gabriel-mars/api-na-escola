package com.gabriel.martins.apinaescola.model.entity;

import com.google.gson.annotations.Expose;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "componente_curricular")
public class ComponenteCurricularEntity implements Serializable {
    @Id
    @SequenceGenerator(name = "generator", sequenceName = "seq_componente_curricular_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    @Basic(optional = false)
    @Column(name = "id", nullable = false, columnDefinition = "BIGINT DEFAULT NEXTVAL('seq_componente_curricular_id')")
    private Long id;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_escola_id", columnDefinition = "bigint")
    private EscolaEntity escola;

    @Column(name = "nome", nullable = false, length = 50)
    private String nome;

    @Column(name = "carga_horaria", nullable = false)
    private String cargaHoraria;

    @Column(name = "tipo_avaliacao")
    @Enumerated(EnumType.STRING)
    @Expose
    private String tipoAvaliacao;

    @Column(name = "media_aprovacao", nullable = false)
    private Double mediaAprovacao;

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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(String cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getTipoAvaliacao() {
        return tipoAvaliacao;
    }

    public void setTipoAvaliacao(String tipoAvaliacao) {
        this.tipoAvaliacao = tipoAvaliacao;
    }

    public Double getMediaAprovacao() {
        return mediaAprovacao;
    }

    public void setMediaAprovacao(Double mediaAprovacao) {
        this.mediaAprovacao = mediaAprovacao;
    }
    //END - GETTERS and SETTERS

    //HASH and EQUALS
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ComponenteCurricularEntity)) return false;

        ComponenteCurricularEntity that = (ComponenteCurricularEntity) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (getEscola() != null ? !getEscola().equals(that.getEscola()) : that.getEscola() != null) return false;
        if (getNome() != null ? !getNome().equals(that.getNome()) : that.getNome() != null) return false;
        if (getCargaHoraria() != null ? !getCargaHoraria().equals(that.getCargaHoraria()) : that.getCargaHoraria() != null)
            return false;
        if (getTipoAvaliacao() != null ? !getTipoAvaliacao().equals(that.getTipoAvaliacao()) : that.getTipoAvaliacao() != null)
            return false;
        return getMediaAprovacao() != null ? getMediaAprovacao().equals(that.getMediaAprovacao()) : that.getMediaAprovacao() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getEscola() != null ? getEscola().hashCode() : 0);
        result = 31 * result + (getNome() != null ? getNome().hashCode() : 0);
        result = 31 * result + (getCargaHoraria() != null ? getCargaHoraria().hashCode() : 0);
        result = 31 * result + (getTipoAvaliacao() != null ? getTipoAvaliacao().hashCode() : 0);
        result = 31 * result + (getMediaAprovacao() != null ? getMediaAprovacao().hashCode() : 0);
        return result;
    }
    //END - HASH and EQUALS
}
