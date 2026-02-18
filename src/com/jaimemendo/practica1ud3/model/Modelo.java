package com.jaimemendo.practica1ud3.model;

import com.jaimemendo.practica1ud3.model.service.ArtistaService;
import com.jaimemendo.practica1ud3.model.service.DiscograficaService;

public class Modelo {
    private DiscograficaService discograficaService;
    private ArtistaService artistaService;

    public Modelo() {
        discograficaService = new DiscograficaService();
        artistaService = new ArtistaService();
    }

    public DiscograficaService getDiscograficaService() {
        return discograficaService;
    }

    public ArtistaService getArtistaService() {
        return artistaService;
    }
}
