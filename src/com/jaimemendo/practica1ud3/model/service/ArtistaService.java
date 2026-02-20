package com.jaimemendo.practica1ud3.model.service;

import com.jaimemendo.practica1ud3.model.data.ArtistaDAO;
import com.jaimemendo.practica1ud3.model.entity.Artista;

import java.util.List;

public class ArtistaService {

    private ArtistaDAO artistaDAO = new ArtistaDAO();

    public void addArtista(Artista artista) {artistaDAO.add(artista);}

    public void deleteArtista(Artista artista) {artistaDAO.delete(artista);}

    public void updateArtista(Artista artista) {artistaDAO.update(artista);}

    public List<Artista> showAllArtista(){return artistaDAO.showAll();}

    public Artista showOneArtista(String name){return artistaDAO.getOne(name);}

}
