package com.jaimemendo.practica1ud3.controller;

import com.jaimemendo.practica1ud3.controller.artista.ArtistaController;
import com.jaimemendo.practica1ud3.controller.canciones.CancionesController;
import com.jaimemendo.practica1ud3.controller.disco.DiscoController;
import com.jaimemendo.practica1ud3.controller.discografica.DiscograficaController;
import com.jaimemendo.practica1ud3.model.Modelo;
import com.jaimemendo.practica1ud3.util.HibernateUtil;
import com.jaimemendo.practica1ud3.util.Util;
import com.jaimemendo.practica1ud3.view.View;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IndexController implements ActionListener {

    private Modelo model;
    private View view;

    private DiscograficaController discograficaController;
    private ArtistaController artistaController;
    private DiscoController discoController;
    private CancionesController cancionesController;

    public IndexController(View view, Modelo model){
        this.view = view;
        this.model = model;

        addActionListener(this);
    }

    private void addActionListener(ActionListener listener) {
        view.itemDesconectar.addActionListener(listener);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "Conectar":
                connected();
                break;
            case "Desconectar":
                disconnected();
                break;
        }
    }

    private void connected() {

        if (!HibernateUtil.isConnected()) {
            HibernateUtil.connect();
            view.initTabbed();
            view.itemDesconectar.setText("Desconectar");
            view.itemDesconectar.setActionCommand("Desconectar");
            // Crear controladores ahora que hay conexión

            this.discograficaController = new DiscograficaController(model, view.DISCOGRAFICA_VIEW);
            this.artistaController = new ArtistaController(model, view.ARTISTA_VIEW);
            this.discoController = new DiscoController(model, view.DISCO_VIEW);
            this.cancionesController = new CancionesController(model, view.CANCION_VIEW);

            changeListener();

        }
    }

    private void disconnected() {

        if (HibernateUtil.isConnected()) {
            HibernateUtil.disconnect();
            view.initConnectionPanel();
            view.itemDesconectar.setText("Conectar");
            view.itemDesconectar.setActionCommand("Conectar");
            Util.showErrorAlert("Estas desconectado");
        }
    }

    public void changeListener() {
        view.tabbedDiscografica.addChangeListener(e -> {
            int index =  view.tabbedDiscografica.getSelectedIndex();
            String titulo =  view.tabbedDiscografica.getTitleAt(index);

            switch (titulo) {
                case "Disco":
                    discoController.cargarArtistas();
                    discoController.cargarDiscograficas();
                    discoController.cargarDiscos();
                    break;
                case "Discografica":
                    discograficaController.actualizarDiscografica();
                    break;
                case "Artista":
                    artistaController.actualizarArtista();
                    artistaController.actualizarDiscografica();
                    break;
                case "Cancion":
                    cancionesController.actualizarCancionDisco();
                    cancionesController.actualizarCancion();
                    break;
            }
        });
    }
}
