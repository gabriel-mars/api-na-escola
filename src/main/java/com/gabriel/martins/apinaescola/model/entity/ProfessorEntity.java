package com.gabriel.martins.apinaescola.model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "professor")
public class ProfessorEntity implements Serializable {
    @Id
    @SequenceGenerator(name = "generator", sequenceName = "seq_professor_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    @Basic(optional = false)
    @Column(name = "id", nullable = false, columnDefinition = "BIGINT DEFAULT NEXTVAL('seq_professor_id')")
    private Long id;

    @OneToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(name = "fk_user_id", columnDefinition = "bigint")
    private UserEntity usuario;

    @Column(name = "codigo_gerado_escola", nullable = false, length = 8)
    private String codigoGeradoEscola;

    @OneToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(name = "fk_escola_id", columnDefinition = "bigint")
    private EscolaEntity escola;

    @Column(name = "senha_gerada", nullable = false)
    private String senhaGerada;

    // GETTERS and SETTERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UserEntity usuario) {
        this.usuario = usuario;
    }

    public String getCodigoGeradoEscola() {
        return codigoGeradoEscola;
    }

    public void setCodigoGeradoEscola(String codigoGeradoEscola) {
        this.codigoGeradoEscola = codigoGeradoEscola;
    }

    public EscolaEntity getEscola() {
        return escola;
    }

    public void setEscola(EscolaEntity escola) {
        this.escola = escola;
    }

    public String getSenhaGerada() {
        return senhaGerada;
    }

    public void setSenhaGerada(String senhaGerada) {
        this.senhaGerada = senhaGerada;
    }
    //END - GETTERS and SETTERS

    //HASH and EQUALS
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProfessorEntity)) return false;
        ProfessorEntity that = (ProfessorEntity) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getUsuario(), that.getUsuario()) &&
                Objects.equals(getCodigoGeradoEscola(), that.getCodigoGeradoEscola()) &&
                Objects.equals(getEscola(), that.getEscola()) &&
                Objects.equals(getSenhaGerada(), that.getSenhaGerada());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUsuario(), getCodigoGeradoEscola(), getEscola(), getSenhaGerada());
    }
    //END - HASH and EQUALS
}
