package com.mangu.congreso_api.domain;

import org.hibernate.annotations.Immutable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Objects;

@Entity(name = "fechas_view")
@Immutable
@Table(name = "fechas_view", schema = "public")
public class FechasView {
    @Id
    private String id;

    private LocalDate fecha;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FechasView that = (FechasView) o;
        return Objects.equals(id, that.id) && Objects.equals(fecha, that.fecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fecha);
    }

    @Override
    public String toString() {
        return "FechasView{" +
                "id='" + id + '\'' +
                ", fecha='" + fecha + '\'' +
                '}';
    }
}
