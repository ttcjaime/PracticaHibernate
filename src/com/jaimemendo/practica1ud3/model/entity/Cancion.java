package com.jaimemendo.practica1ud3.model.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Cancion {
    private int idCancion;
    private String titulo;
    private double duracion;
    private Disco disco;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cancion")
    public int getIdCancion() {
        return idCancion;
    }

    public void setIdCancion(int idCancion) {
        this.idCancion = idCancion;
    }

    @Basic
    @Column(name = "titulo")
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Basic
    @Column(name = "duracion")
    public double getDuracion() {
        return duracion;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cancion cancion = (Cancion) o;
        return idCancion == cancion.idCancion &&
                Double.compare(cancion.duracion, duracion) == 0 &&
                Objects.equals(titulo, cancion.titulo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCancion, titulo, duracion);
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
        return "Titulo: " + titulo + " | Disco: " + disco.getNombre() + " | Duración: " + duracion;
    }
}
