package com.mangu.congreso_api.domain;

import java.util.Set;
import javax.persistence.*;


@Entity(name = "sesion")
@Table(name = "sesion", schema = "public")
public class Sesion {

    @Id
    @Column(nullable = false, updatable = false)
    private Integer id;

    @Column
    private Long sesionNumber;

    @OneToMany(mappedBy = "sesion", fetch = FetchType.EAGER)
    private Set<Votacion> sesionVotacions;

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public Long getSesionNumber() {
        return sesionNumber;
    }

    public void setSesionNumber(final Long sesionNumber) {
        this.sesionNumber = sesionNumber;
    }

    public Set<Votacion> getSesionVotacions() {
        return sesionVotacions;
    }

    public void setSesionVotacions(final Set<Votacion> sesionVotacions) {
        this.sesionVotacions = sesionVotacions;
    }

}
