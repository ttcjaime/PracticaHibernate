package com.jaimemendo.practica1ud3.model.service;

import com.jaimemendo.practica1ud3.model.data.CancionDAO;
import com.jaimemendo.practica1ud3.model.entity.Cancion;

import java.util.List;


public class CancionService {

    private CancionDAO cancionDAO = new CancionDAO();

    public void addCancion(Cancion cancion) {cancionDAO.add(cancion);}

    public void deleteCancion(Cancion cancion) {cancionDAO.delete(cancion);}

    public void updateCancion(Cancion cancion) {cancionDAO.update(cancion);}

    public List<Cancion> showAllCancion() {return cancionDAO.showAll();}

    public Cancion showOneCancion(String name) {return cancionDAO.getOne(name);}

    public Cancion getIdCancion(int idCancion) {return cancionDAO.getId(idCancion);}

}
