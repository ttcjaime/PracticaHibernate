package com.jaimemendo.practica1ud3.model.repository;

import com.jaimemendo.practica1ud3.model.entity.Cancion;

import java.util.List;

public interface ICancionDAO {

    Cancion add(Cancion cancion);
    boolean delete(Cancion cancion);
    boolean update(Cancion cancion);
    List<Cancion> showAll();
    Cancion getOne(String name);
    Cancion getId(int idCancion);

}
