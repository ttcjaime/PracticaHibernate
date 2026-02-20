package com.jaimemendo.practica1ud3.model.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "artista_disco", schema = "mitostore", catalog = "")
public class Participacion {
    private int id;
    private String rol;
    private Date fechaParticipacion;
    private Artista artista;
    private Disco disco;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "rol")
    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Basic
    @Column(name = "fecha_participacion")
    public Date getFechaParticipacion() {
        return fechaParticipacion;
    }

    public void setFechaParticipacion(Date fechaParticipacion) {
        this.fechaParticipacion = fechaParticipacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participacion that = (Participacion) o;
        return id == that.id &&
                Objects.equals(rol, that.rol) &&
                Objects.equals(fechaParticipacion, that.fechaParticipacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rol, fechaParticipacion);
    }

    @ManyToOne
    @JoinColumn(name = "id_artista", referencedColumnName = "id", nullable = false)
    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    @ManyToOne
    @JoinColumn(name = "id_disco", referencedColumnName = "id", nullable = false)
    public Disco getDisco() {
        return disco;
    }

    public void setDisco(Disco disco) {
        this.disco = disco;
    }

    @Override
    public String toString() {
        return "Participacion{" +
                "id=" + id +
                ", rol='" + rol + '\'' +
                ", fechaParticipacion=" + fechaParticipacion +
                ", artista=" + artista +
                ", disco=" + disco +
                '}';
    }
}
