package com.mangu.congreso_api.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;
import java.util.Set;
import javax.persistence.*;


@Entity(name = "votacion")
@Table(name = "votacion", schema = "public")
public class Votacion {

    @Id
    @Column(nullable = false, updatable = false)
    private Long id;

    @Column(nullable = false)
    private Integer votacionNumber;

    @Column(nullable = false)
    private LocalDate fecha;

    @Column(nullable = false, columnDefinition = "text")
    private String titulo;

    @Column(nullable = false, columnDefinition = "text")
    private String textoexpediente;

    @Column(nullable = false, columnDefinition = "text")
    private String titulosubgrupo;

    @Column(nullable = false, columnDefinition = "text")
    private String textosubgrupo;

    @ManyToOne(targetEntity = Sesion.class,fetch = FetchType.LAZY)
    @JoinColumn(name = "sesion_id", nullable = false)
    @JsonIgnore
    private Sesion sesion;

    @OneToMany(mappedBy = "votacion", fetch = FetchType.EAGER)
    private Set<VotosResumido> votacionVotosResumidos;

    @OneToMany(mappedBy = "votacion", fetch = FetchType.EAGER)
    private Set<VotosDetallado> votacionVotosDetallados;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public Integer getVotacionNumber() {
        return votacionNumber;
    }

    public void setVotacionNumber(final Integer votacionNumber) {
        this.votacionNumber = votacionNumber;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(final LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(final String titulo) {
        this.titulo = titulo;
    }

    public String getTextoexpediente() {
        return textoexpediente;
    }

    public void setTextoexpediente(final String textoexpediente) {
        this.textoexpediente = textoexpediente;
    }

    public String getTitulosubgrupo() {
        return titulosubgrupo;
    }

    public void setTitulosubgrupo(final String titulosubgrupo) {
        this.titulosubgrupo = titulosubgrupo;
    }

    public String getTextosubgrupo() {
        return textosubgrupo;
    }

    public void setTextosubgrupo(final String textosubgrupo) {
        this.textosubgrupo = textosubgrupo;
    }

    public Sesion getSesion() {
        return sesion;
    }

    public void setSesion(final Sesion sesion) {
        this.sesion = sesion;
    }

    public Set<VotosResumido> getVotacionVotosResumidos() {
        return votacionVotosResumidos;
    }

    public void setVotacionVotosResumidos(final Set<VotosResumido> votacionVotosResumidos) {
        this.votacionVotosResumidos = votacionVotosResumidos;
    }

    public Set<VotosDetallado> getVotacionVotosDetallados() {
        return votacionVotosDetallados;
    }

    public void setVotacionVotosDetallados(final Set<VotosDetallado> votacionVotosDetallados) {
        this.votacionVotosDetallados = votacionVotosDetallados;
    }

}
