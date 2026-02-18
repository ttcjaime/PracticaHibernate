package com.jaimemendo.practica1ud3.model.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Discografica {
    private String nombre;
    private int id;
    private String pais;
    private String sitioWeb;
    private String emailContacto;
    private int telefonoContacto;
    private List<Disco> discos;
    private List<Artista> artistas;

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
    @Column(name = "pais")
    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Basic
    @Column(name = "sitio_web")
    public String getSitioWeb() {
        return sitioWeb;
    }

    public void setSitioWeb(String sitioWeb) {
        this.sitioWeb = sitioWeb;
    }

    @Basic
    @Column(name = "email_contacto")
    public String getEmailContacto() {
        return emailContacto;
    }

    public void setEmailContacto(String emailContacto) {
        this.emailContacto = emailContacto;
    }

    @Basic
    @Column(name = "telefono_contacto")
    public int getTelefonoContacto() {
        return telefonoContacto;
    }

    public void setTelefonoContacto(int telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Discografica that = (Discografica) o;
        return id == that.id &&
                telefonoContacto == that.telefonoContacto &&
                Objects.equals(nombre, that.nombre) &&
                Objects.equals(pais, that.pais) &&
                Objects.equals(sitioWeb, that.sitioWeb) &&
                Objects.equals(emailContacto, that.emailContacto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, id, pais, sitioWeb, emailContacto, telefonoContacto);
    }

    @OneToMany(mappedBy = "discografica")
    public List<Disco> getDiscos() {
        return discos;
    }

    public void setDiscos(List<Disco> discos) {
        this.discos = discos;
    }

    @OneToMany(mappedBy = "discografica")
    public List<Artista> getArtistas() {
        return artistas;
    }

    public void setArtistas(List<Artista> artistas) {
        this.artistas = artistas;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + " | País: " + pais + " | Sitio Web: " + sitioWeb + " | Telefono: " + telefonoContacto + " | Email: " + emailContacto;
    }

}
