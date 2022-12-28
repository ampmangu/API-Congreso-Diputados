package com.mangu.congreso_api.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "votos_resumido", schema = "public")
public class VotosResumido {

  @Id
  @Column(nullable = false, updatable = false)
  private Long id;

  @Column(nullable = false, columnDefinition = "text")
  private String grupo;

  @Column(nullable = false, columnDefinition = "text")
  private String aFavor;

  @Column(nullable = false, columnDefinition = "text")
  private String enContra;

  @Column(nullable = false, columnDefinition = "text")
  private String abstencion;

  @Column(nullable = false, columnDefinition = "text")
  private String nsnc;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "votacion_id", nullable = false)
  @JsonIgnore
  private Votacion votacion;

  public Long getId() {
    return id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public String getGrupo() {
    return grupo;
  }

  public void setGrupo(final String grupo) {
    this.grupo = grupo;
  }

  public String getAFavor() {
    return aFavor;
  }

  public void setAFavor(final String aFavor) {
    this.aFavor = aFavor;
  }

  public String getEnContra() {
    return enContra;
  }

  public void setEnContra(final String enContra) {
    this.enContra = enContra;
  }

  public String getAbstencion() {
    return abstencion;
  }

  public void setAbstencion(final String abstencion) {
    this.abstencion = abstencion;
  }

  public String getNsnc() {
    return nsnc;
  }

  public void setNsnc(final String nsnc) {
    this.nsnc = nsnc;
  }

  public Votacion getVotacion() {
    return votacion;
  }

  public void setVotacion(final Votacion votacion) {
    this.votacion = votacion;
  }

}
