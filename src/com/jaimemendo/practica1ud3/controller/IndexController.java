package com.jaimemendo.practica1ud3.controller;

import com.jaimemendo.practica1ud3.controller.artista.ArtistaController;
import com.jaimemendo.practica1ud3.controller.discografica.DiscograficaController;
import com.jaimemendo.practica1ud3.model.Modelo;
import com.jaimemendo.practica1ud3.model.entity.Artista;
import com.jaimemendo.practica1ud3.view.View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IndexController implements ActionListener {

    private Modelo model;
    private View view;

    private final DiscograficaController discograficaController;
    private final ArtistaController artistaController;

    public IndexController(View view, Modelo model){
        this.view = view;
        this.model = model;
        this.discograficaController = new DiscograficaController(model, view.DISCOGRAFICA_VIEW);
        this.artistaController = new ArtistaController(model, view.ARTISTA_VIEW);
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
