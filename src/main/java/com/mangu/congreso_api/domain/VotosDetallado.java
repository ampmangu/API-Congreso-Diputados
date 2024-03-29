package com.mangu.congreso_api.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "votos_detallado", schema = "public")
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
public class VotosDetallado {

  @Id
  @Column(nullable = false, updatable = false)
  private Long id;

  @Column
  private Integer asiento;

  @Column(nullable = false, columnDefinition = "text")
  private String diputado;

  @Column(nullable = false, columnDefinition = "text")
  private String grupo;

  @Column(nullable = false, columnDefinition = "text")
  private String voto;

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

  public Integer getAsiento() {
    return asiento;
  }

  public void setAsiento(final Integer asiento) {
    this.asiento = asiento;
  }

  public String getDiputado() {
    return diputado;
  }

  public void setDiputado(final String diputado) {
    this.diputado = diputado;
  }

  public String getGrupo() {
    return grupo;
  }

  public void setGrupo(final String grupo) {
    this.grupo = grupo;
  }

  public String getVoto() {
    return voto;
  }

  public void setVoto(final String voto) {
    this.voto = voto;
  }

  public Votacion getVotacion() {
    return votacion;
  }

  public void setVotacion(final Votacion votacion) {
    this.votacion = votacion;
  }

}
