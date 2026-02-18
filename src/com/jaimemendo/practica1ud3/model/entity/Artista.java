package com.jaimemendo.practica1ud3.model.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Artista {
    private String nombre;
    private int id;
    private String genero;
    private String pais;
    private Discografica discografica;
    private List<Participacion> participaciones;

    @Basic
    @Column(name = "nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "genero")
    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Basic
    @Column(name = "pais")
    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artista artista = (Artista) o;
        return id == artista.id &&
                Objects.equals(nombre, artista.nombre) &&
                Objects.equals(genero, artista.genero) &&
                Objects.equals(pais, artista.pais);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, id, genero, pais);
    }

    @ManyToOne
    @JoinColumn(name = "id_discografica", referencedColumnName = "id", nullable = false)
    public Discografica getDiscografica() {
        return discografica;
    }

    public void setDiscografica(Discografica discografica) {
        this.discografica = discografica;
    }

    @OneToMany(mappedBy = "artista")
    public List<Participacion> getParticipaciones() {
        return participaciones;
    }

    public void setParticipaciones(List<Participacion> participaciones) {
        this.participaciones = participaciones;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + " | Pais: " + pais + " | Genero: " + genero + " | Discografica: " + discografica.getNombre();
    }

}
