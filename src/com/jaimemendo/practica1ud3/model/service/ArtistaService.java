package com.jaimemendo.practica1ud3.model.service;

import com.jaimemendo.practica1ud3.model.data.ArtistaDAO;
import com.jaimemendo.practica1ud3.model.entity.Artista;
import org.hibernate.exception.ConstraintViolationException;

import javax.persistence.PersistenceException;
import java.util.List;

public class ArtistaService {

    private ArtistaDAO artistaDAO = new ArtistaDAO();

    public void addArtista(Artista artista) {artistaDAO.add(artista);}

    public void deleteArtista(Artista artista) {
        try {
            artistaDAO.delete(artista);
        } catch (PersistenceException e) {
            if (e.getCause() instanceof ConstraintViolationException) {
                throw new IllegalStateException("NO_SE_PUEDE_ELIMINAR");
            }
            throw e;
        }
    }

    public void updateArtista(Artista artista) {artistaDAO.update(artista);}

    public List<Artista> showAllArtista(){return artistaDAO.showAll();}

    public Artista showOneArtista(String name){return artistaDAO.getOne(name);}

}
