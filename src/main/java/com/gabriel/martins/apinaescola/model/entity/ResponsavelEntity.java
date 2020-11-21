package com.gabriel.martins.apinaescola.model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "responsavel")
public class ResponsavelEntity implements Serializable {

    @Id
    @SequenceGenerator(name = "generator", sequenceName = "seq_responsavel_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    @Basic(optional = false)
    @Column(name = "id", nullable = false, columnDefinition = "BIGINT DEFAULT NEXTVAL('seq_responsavel_id')")
    private Long id;

    @OneToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(name = "fk_user_id", columnDefinition = "bigint")
    private UserEntity usuario;

    @Column(name = "foto", nullable = true, columnDefinition = "TEXT")
    private String foto;

    //GETTERS and SETTERS
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

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
    //END - GETTERS and SETTERS

    //HASH and EQUALS
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ResponsavelEntity)) return false;
        ResponsavelEntity that = (ResponsavelEntity) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getUsuario(), that.getUsuario()) &&
                Objects.equals(getFoto(), that.getFoto());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUsuario(), getFoto());
    }
    //END - HASH and EQUALS
}
