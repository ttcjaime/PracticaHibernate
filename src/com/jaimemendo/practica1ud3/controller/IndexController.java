package com.jaimemendo.practica1ud3.controller;

import com.jaimemendo.practica1ud3.controller.artista.ArtistaController;
import com.jaimemendo.practica1ud3.controller.canciones.CancionesController;
import com.jaimemendo.practica1ud3.controller.disco.DiscoController;
import com.jaimemendo.practica1ud3.controller.discografica.DiscograficaController;
import com.jaimemendo.practica1ud3.model.Modelo;
import com.jaimemendo.practica1ud3.view.View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IndexController implements ActionListener {

    private Modelo model;
    private View view;

    private final DiscograficaController discograficaController;
    private final ArtistaController artistaController;
    private final DiscoController discoController;
    private final CancionesController cancionesController;

    public IndexController(View view, Modelo model){
        this.view = view;
        this.model = model;
        this.discograficaController = new DiscograficaController(model, view.DISCOGRAFICA_VIEW);
        this.artistaController = new ArtistaController(model, view.ARTISTA_VIEW);
        this.discoController = new DiscoController(model, view.DISCO_VIEW);
        this.cancionesController = new CancionesController(model, view.CANCION_VIEW);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "Conectar":
                if (view.itemDesconectar.getText().equals("Conectar")) {
                    view.itemDesconectar.setText("Desconectar");
                } else {
                    view.itemDesconectar.setText("Conectar");
                }
                break;
            case "Desconectar":
                break;
        }
    }

}
