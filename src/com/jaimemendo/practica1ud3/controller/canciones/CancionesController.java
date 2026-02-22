package com.jaimemendo.practica1ud3.controller.canciones;

import com.jaimemendo.practica1ud3.model.Modelo;
import com.jaimemendo.practica1ud3.model.entity.Artista;
import com.jaimemendo.practica1ud3.model.entity.Cancion;
import com.jaimemendo.practica1ud3.model.entity.Disco;
import com.jaimemendo.practica1ud3.model.entity.Discografica;
import com.jaimemendo.practica1ud3.util.Util;
import com.jaimemendo.practica1ud3.view.cancion.CancionView;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class CancionesController implements ListSelectionListener, ActionListener {

    private Modelo modelo;
    private CancionView cancionView;
    private String emptyFields;

    public CancionesController(Modelo modelo, CancionView cancionView) {
        this.modelo = modelo;
        this.cancionView = cancionView;

        addActionListener(this);
        addListListener(this);
        actualizarCancion();
        actualizarCancionDisco();
    }

    private void addActionListener(ActionListener listener) {
        cancionView.getBtnAddCancion().addActionListener(listener);
        cancionView.getBtnBorrarCancion().addActionListener(listener);
        cancionView.getBtnModificarCancion().addActionListener(listener);
        cancionView.getBtnMostrarDisco().addActionListener(listener);
    }

    private void addListListener(ListSelectionListener listener) {
        cancionView.getListCancion().addListSelectionListener(listener);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "btnAddCancion":
                addCancion();
                break;
            case "btnDeleteCancion":
                deleteCancion();
                break;
            case "btnUpdateCancion":
                update();
                break;
            case "mostrarDisco":
                mostrarDisco();
                break;
        }
        actualizarCancion();
        actualizarCancionDisco();
        deleteFields();
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (e.getValueIsAdjusting()) {
            Cancion cancion =  (Cancion) cancionView.getListCancion().getSelectedValue();
            cancionView.getTxtTituloCancion().setText(cancion.getTitulo());
            cancionView.getComboDiscoCancion().setSelectedItem(cancion.getDisco());
        }
    }

    private void addCancion() {
        if (algunCampoVacio()) {
            Util.showErrorAlert(campoVacio());
        } else {
            Cancion cancion = new Cancion();
            Disco disco = modelo.getDiscoService().showOneDisco((String)cancionView.getComboDiscoCancion().getSelectedItem());
            cancion.setTitulo(cancionView.getTxtTituloCancion().getText());
            cancion.setDisco(disco);
            cancion.setDuracion(cancionView.getPrecio());

            modelo.getCancionService().addCancion(cancion);
        }
    }

    private void deleteCancion() {
        Cancion cancionDelete = (Cancion) cancionView.getListCancion().getSelectedValue();
        if (cancionDelete == null) {
            Util.showErrorAlert("Selecciona una canción para borrar");
        } else {
            modelo.getCancionService().deleteCancion(cancionDelete);
        }
    }

    private void update() {
        Cancion cancionUpdate = (Cancion) cancionView.getListCancion().getSelectedValue();
        if (cancionUpdate == null) {
            Util.showErrorAlert("Selecciona una canción para actualizar");
        } else {
            Disco disco = modelo.getDiscoService().showOneDisco((String)cancionView.getComboDiscoCancion().getSelectedItem());
            cancionUpdate.setTitulo(cancionView.getTxtTituloCancion().getText());
            cancionUpdate.setDisco(disco);
            cancionUpdate.setDuracion(cancionView.getPrecio());

            modelo.getCancionService().updateCancion(cancionUpdate);
        }
    }

    private boolean algunCampoVacio() {
        return cancionView.getTxtTituloCancion().getText().isEmpty()
                || cancionView.getComboDiscoCancion().getSelectedItem() == null;
    }

    private String campoVacio() {
        emptyFields = "Los siguientes campos estan vacios: \n";
        if (cancionView.getTxtTituloCancion().getText().isEmpty()) {
            emptyFields += "Titulo";
        }
        if (cancionView.getComboDiscoCancion().getSelectedItem() == null) {
            emptyFields += "Disco";
        }
        return emptyFields;
    }

    public void actualizarCancion() {
        List<Cancion> listCancion = modelo.getCancionService().showAllCancion();

        cancionView.getDlmCancion().clear();

        for (Cancion cancion : listCancion) {
            cancionView.getDlmCancion().addElement(cancion);
        }

    }

    public void actualizarCancionDisco() {
        List<Disco> listDisco = modelo.getDiscoService().showAllDisco();

        cancionView.getComboDiscoCancion().removeAllItems();

        for (Disco d : listDisco) {
            cancionView.getComboDiscoCancion().addItem(d.getNombre());
        }
    }

    private void mostrarDisco() {
        List<Disco> listDisco = modelo.getDiscoService().showAllDisco();

        cancionView.getDlmDisco().clear();

        for (Disco d : listDisco) {
            cancionView.getDlmDisco().addElement(d);
        }
    }

    private void deleteFields() {
        cancionView.getTxtTituloCancion().setText("");
        cancionView.getComboDiscoCancion().setSelectedItem(-1);
        cancionView.getSpinnerDuracion().setValue(1);
    }

}
