package com.jaimemendo.practica1ud3.model.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Disco {
    private String nombre;
    private int id;
    private String genero;
    private int precio;
    private String color;
    private Date fechaLanzamiento;
    private Discografica discografica;
    private List<Cancion> canciones;
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
    @Column(name = "precio")
    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @Basic
    @Column(name = "color")
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Basic
    @Column(name = "fecha_lanzamiento")
    public Date getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(Date fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Disco disco = (Disco) o;
        return id == disco.id &&
                precio == disco.precio &&
                Objects.equals(nombre, disco.nombre) &&
                Objects.equals(genero, disco.genero) &&
                Objects.equals(color, disco.color) &&
                Objects.equals(fechaLanzamiento, disco.fechaLanzamiento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, id, genero, precio, color, fechaLanzamiento);
    }

    @ManyToOne
    @JoinColumn(name = "id_discografica", referencedColumnName = "id", nullable = false)
    public Discografica getDiscografica() {
        return discografica;
    }

    public void setDiscografica(Discografica discografica) {
        this.discografica = discografica;
    }

    @OneToMany(mappedBy = "disco")
    public List<Cancion> getCanciones() {
        return canciones;
    }

    public void setCanciones(List<Cancion> canciones) {
        this.canciones = canciones;
    }

    @OneToMany(mappedBy = "disco")
    public List<Participacion> getParticipaciones() {
        return participaciones;
    }

    public void setParticipaciones(List<Participacion> participaciones) {
        this.participaciones = participaciones;
    }
}
