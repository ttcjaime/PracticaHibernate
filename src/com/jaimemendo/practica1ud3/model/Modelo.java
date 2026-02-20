package com.jaimemendo.practica1ud3.model;

import com.jaimemendo.practica1ud3.model.service.ArtistaService;
import com.jaimemendo.practica1ud3.model.service.CancionService;
import com.jaimemendo.practica1ud3.model.service.DiscoService;
import com.jaimemendo.practica1ud3.model.service.DiscograficaService;

public class Modelo {
    private DiscograficaService discograficaService;
    private ArtistaService artistaService;
    private DiscoService discoService;
    private CancionService cancionService;

    public Modelo() {
        discograficaService = new DiscograficaService();
        artistaService = new ArtistaService();
        discoService = new DiscoService();
        cancionService = new CancionService();
    }

    public DiscograficaService getDiscograficaService() {
        return discograficaService;
    }

    public ArtistaService getArtistaService() {
        return artistaService;
    }

    public DiscoService getDiscoService() {
        return discoService;
    }

    public CancionService getCancionService() {
        return cancionService;
    }

}
