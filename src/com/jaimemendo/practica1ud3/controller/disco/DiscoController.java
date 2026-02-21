package com.jaimemendo.practica1ud3.controller.disco;

import com.jaimemendo.practica1ud3.model.Modelo;
import com.jaimemendo.practica1ud3.model.entity.Artista;
import com.jaimemendo.practica1ud3.model.entity.Disco;
import com.jaimemendo.practica1ud3.model.entity.Discografica;
import com.jaimemendo.practica1ud3.model.entity.Participacion;
import com.jaimemendo.practica1ud3.util.Util;
import com.jaimemendo.practica1ud3.view.disco.DiscoView;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.List;

public class DiscoController implements ActionListener, ListSelectionListener {

    private Modelo modelo;
    private DiscoView discoView;
    private String emptyFields;
    private Disco currentDisco;

    public DiscoController(Modelo modelo, DiscoView discoView) {
        this.modelo = modelo;
        this.discoView = discoView;

        addActionListener(this);
        addListListener(this);
        listDisco();
    }

    private void addActionListener(ActionListener listener) {
        discoView.getBtnAddDisco().addActionListener(listener);
        discoView.getBtnBorrarDisco().addActionListener(listener);
        discoView.getBtnModificarDisco().addActionListener(listener);
    }

    private void addListListener(ListSelectionListener listener) {
        discoView.getListDisco().addListSelectionListener(listener);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "btnAddDisco":
                addDisco();
                break;
            case "btnBorrarDisco":
                deleteDisco();
                break;
            case "btnUpdateDisco":
                update();
                break;
        }
        listDisco();
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            Disco disco = (Disco) discoView.getListDisco().getSelectedValue();

            if (disco == null) {
                currentDisco = null;
                return;
            }

            currentDisco = modelo.getDiscoService().getIdDisco(disco.getId());

            discoView.getTxtNombreDisco().setText(disco.getNombre());
            discoView.getBoxDiscografica().setSelectedItem(disco.getDiscografica());
            discoView.getBoxColores().setSelectedItem(disco.getColor());
            discoView.getBoxGeneroDis().setSelectedItem(disco.getGenero());
            discoView.getFechaDisco().setText(String.valueOf(discoView.getFechaDisco()));
            discoView.getSpinnerPrecio().setValue(disco.getPrecio());
        }
    }

    private void addDisco() {
        if (algunCampoVacio()) {
            Util.showErrorAlert(camposVacios());
            emptyFields = "";
        } else {
            Disco disco = new Disco();
            Artista artista = modelo.getArtistaService().showOneArtista((String)discoView.getBoxArtista().getSelectedItem());
            Discografica discografica = modelo.getDiscograficaService().showOneDiscografica((String) discoView.getBoxDiscografica().getSelectedItem());
            disco.setNombre(discoView.getTxtNombreDisco().getText());
            disco.setColor((String) discoView.getBoxColores().getSelectedItem());
            disco.setFechaLanzamiento(Date.valueOf(discoView.getFechaDisco().getDate()));
            disco.setDiscografica(discografica);
            disco.setGenero( (String) discoView.getBoxGeneroDis().getSelectedItem());

            Participacion participacion = new Participacion();
            participacion.setArtista(artista);
            participacion.setDisco(disco);
            System.out.println(participacion);
            disco.getParticipaciones().add(participacion);

            modelo.getDiscoService().addDisco(disco);

        }
    }

    private void deleteDisco() {
        Disco discoDelete = (Disco) discoView.getListDisco().getSelectedValue();
        if (discoDelete == null) {
            Util.showErrorAlert("Selecciona un disco a borrar");
        } else {
            modelo.getDiscoService().deleteDisco(discoDelete);
            currentDisco = null;
        }
    }

    private void update() {
        if (currentDisco == null) {
            Util.showErrorAlert("Selecciona un disco a editar");
        } else {
            Artista artista = modelo.getArtistaService().showOneArtista((String)discoView.getBoxArtista().getSelectedItem());
            Discografica discografica = modelo.getDiscograficaService().showOneDiscografica((String) discoView.getBoxDiscografica().getSelectedItem());
            currentDisco.setNombre(discoView.getTxtNombreDisco().getText());
            currentDisco.setColor((String) discoView.getBoxColores().getSelectedItem());
            currentDisco.setFechaLanzamiento(Date.valueOf(discoView.getFechaDisco().getDate()));
            currentDisco.setDiscografica(discografica);
            currentDisco.setGenero( (String) discoView.getBoxGeneroDis().getSelectedItem());

            currentDisco.getParticipaciones().clear();
            Participacion participacion = new Participacion();
            participacion.setArtista(artista);
            participacion.setDisco(currentDisco);
            System.out.println(participacion);
            currentDisco.getParticipaciones().add(participacion);

            modelo.getDiscoService().updateDisco(currentDisco);

            currentDisco = null;
            discoView.getListDisco().clearSelection();
        }
    }

    private boolean algunCampoVacio() {
        return discoView.getTxtNombreDisco().getText().isEmpty() || discoView.getBoxGeneroDis().getSelectedItem() == null
                || discoView.getBoxArtista().getSelectedItem() == null || discoView.getBoxColores().getSelectedItem() == null
                || discoView.getBoxDiscografica().getSelectedItem() == null || discoView.getFechaDisco().getText().isEmpty();
    }

    private String camposVacios() {
        emptyFields = "Los siguientes campos estan vacios: \n";
        if (discoView.getTxtNombreDisco().getText().isEmpty()) {
            emptyFields += "Nombre \n";
        }
        if (discoView.getBoxGeneroDis().getSelectedItem() == null) {
            emptyFields += "Genero \n";
        }
        if (discoView.getBoxArtista().getSelectedItem() == null) {
            emptyFields += "Artista \n";
        }
        if (discoView.getBoxColores().getSelectedItem() == null) {
            emptyFields += "Colores \n";
        }
        if (discoView.getBoxDiscografica().getSelectedItem() == null) {
            emptyFields += "Discografica \n";
        }
        if (discoView.getFechaDisco().getText().isEmpty()) {
            emptyFields += "Fecha \n";
        }
        return emptyFields;
    }

    public void listDisco(){
        List<Disco> listDisco = modelo.getDiscoService().showAllDisco();

        discoView.getDlmDisco().clear();
        discoView.getBoxDiscografica().removeAllItems();
        discoView.getBoxArtista().removeAllItems();

        List<Discografica> listDiscografica =
                modelo.getDiscograficaService().showAllDiscograficas();

        List<Artista> listArtista = modelo.getArtistaService().showAllArtista();

        for (Disco disco : listDisco) {
            discoView.getDlmDisco().addElement(disco);
        }

        discoView.getBoxDiscografica().removeAllItems();
        discoView.getBoxArtista().removeAllItems();

        for (Discografica d : listDiscografica) {
            discoView.getBoxDiscografica().addItem(d.getNombre());
        }

        for (Artista a : listArtista) {
            discoView.getBoxArtista().addItem(a.getNombre());
        }

    }

}
