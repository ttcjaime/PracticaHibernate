package com.jaimemendo.practica1ud3.model.repository;

import com.jaimemendo.practica1ud3.model.entity.Disco;

import java.util.List;

public interface IDiscoDAO {

    Disco add(Disco disco);
    boolean delete(Disco disco);
    boolean update(Disco disco);
    List<Disco> showAll();
    Disco getOne(String nombre);
    Disco getId(int idDisco);

}
