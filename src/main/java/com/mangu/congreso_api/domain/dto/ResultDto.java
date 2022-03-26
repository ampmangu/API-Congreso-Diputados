package com.mangu.congreso_api.domain.dto;

import java.util.Objects;

public class ResultDto {

    private Long id;

    private String legislatura;

    private String fecha;

    private String titulo;

    private String textoexpediente;


    public ResultDto(Long id, String legislatura, String fecha, String titulo, String textoexpediente) {
        this.id = id;
        this.legislatura = legislatura;
        this.fecha = fecha;
        this.titulo = titulo;
        this.textoexpediente = textoexpediente;
    }

    public String getLegislatura() {
        return legislatura;
    }

    public void setLegislatura(String legislatura) {
        this.legislatura = legislatura;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTextoexpediente() {
        return textoexpediente;
    }

    public void setTextoexpediente(String textoexpediente) {
        this.textoexpediente = textoexpediente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResultDto resultDto = (ResultDto) o;
        return Objects.equals(id, resultDto.id) && Objects.equals(legislatura, resultDto.legislatura) && Objects.equals(fecha, resultDto.fecha) && Objects.equals(titulo, resultDto.titulo) && Objects.equals(textoexpediente, resultDto.textoexpediente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, legislatura, fecha, titulo, textoexpediente);
    }

    @Override
    public String toString() {
        return "ResultDto{" +
                "id=" + id +
                ", legislatura='" + legislatura + '\'' +
                ", fecha='" + fecha + '\'' +
                ", titulo='" + titulo + '\'' +
                ", textoexpediente='" + textoexpediente + '\'' +
                '}';
    }

    public static class Builder {
        protected Long id;

        protected String legislatura;

        protected String fecha;

        protected String titulo;

        protected String textoexpediente;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder legislatura(String legislatura) {
            this.legislatura = legislatura;
            return this;
        }

        public Builder fecha(String fecha) {
            this.fecha = fecha;
            return this;
        }

        public Builder titulo(String titulo) {
            this.titulo = titulo;
            return this;
        }

        public Builder textoexpediente(String textoexpediente) {
            this.textoexpediente = textoexpediente;
            return this;
        }

        public ResultDto build() {
            return new ResultDto(id, legislatura, fecha, titulo, textoexpediente);
        }
    }
}
