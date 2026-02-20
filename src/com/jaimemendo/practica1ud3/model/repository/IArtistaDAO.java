package com.jaimemendo.practica1ud3.model.repository;

import com.jaimemendo.practica1ud3.model.entity.Artista;

import java.util.List;

public interface IArtistaDAO {

    Artista add(Artista artista);
    boolean delete(Artista artista);
    boolean update(Artista artista);
    List<Artista> showAll();
    Artista getOne(String name);

}
