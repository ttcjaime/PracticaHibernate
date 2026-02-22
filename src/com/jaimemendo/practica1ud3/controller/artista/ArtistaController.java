package com.jaimemendo.practica1ud3.controller.artista;

import com.jaimemendo.practica1ud3.model.Modelo;
import com.jaimemendo.practica1ud3.model.entity.Artista;
import com.jaimemendo.practica1ud3.model.entity.Discografica;
import com.jaimemendo.practica1ud3.util.Util;
import com.jaimemendo.practica1ud3.view.Artista.ArtistaView;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ArtistaController implements ActionListener, ListSelectionListener {

    private Modelo modelo;
    private ArtistaView artistaView;
    private String emptyFields;

    public ArtistaController(Modelo modelo, ArtistaView artistaView) {
        this.modelo = modelo;
        this.artistaView = artistaView;

        addActionListener(this);
        addListListener(this);
        listArtista();
    }

    private void addActionListener(ActionListener listener) {
        artistaView.getBtnAddArt().addActionListener(listener);
        artistaView.getBtnBorrarArt().addActionListener(listener);
        artistaView.getBtnModificar().addActionListener(listener);
    }

    private void addListListener(ListSelectionListener listener) {
        artistaView.getArtistaList().addListSelectionListener(listener);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "addArtista":
                addArtista();
                break;
            case "updateArtista":
                updateArtista();
                break;
            case "deleteArtista":
                deleteArtista();
                break;
        }
        listArtista();
    }

    public void listArtista(){
        List<Artista> listArtista = modelo.getArtistaService().showAllArtista();

        artistaView.getDlmArtista().clear();
        artistaView.getDiscograficaBox().removeAllItems();

        List<Discografica> listDiscografica =
                modelo.getDiscograficaService().showAllDiscograficas();

        for (Artista artista : listArtista) {
            artistaView.getDlmArtista().addElement(artista);
        }

        artistaView.getDiscograficaBox().removeAllItems();

        for (Discografica d : listDiscografica) {
            artistaView.getDiscograficaBox().addItem(d.getNombre());
        }

    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (e.getValueIsAdjusting()) {
            Artista artista = (Artista)artistaView.getArtistaList().getSelectedValue();
            artistaView.getTxtPaisArtista().setText(artista.getPais());
            artistaView.getTxtNombreArtista().setText(artista.getNombre());
            artistaView.getBoxGeneroArt().setSelectedItem(artista.getGenero());
            artistaView.getDiscograficaBox().setSelectedItem(artista.getDiscografica());
        }
    }

    private void addArtista() {
        if (algunCampoVacio()) {
            Util.showErrorAlert(camposArtistaVacio());
            emptyFields = "";
        } else {
            Artista artista = new Artista();
            Discografica discografica = modelo.getDiscograficaService().showOneDiscografica((String) artistaView.getDiscograficaBox().getSelectedItem());
            System.out.println(discografica);
            artista.setNombre(artistaView.getTxtNombreArtista().getText());
            artista.setPais(artistaView.getTxtPaisArtista().getText());
            artista.setGenero( (String) artistaView.getBoxGeneroArt().getSelectedItem());
            artista.setDiscografica(discografica);
            modelo.getArtistaService().addArtista(artista);
            modelo.getDiscoService().showAllDisco();
        }
    }

    private void updateArtista() {
        Artista artistaUpdate = (Artista)artistaView.getArtistaList().getSelectedValue();
        Discografica discografica = modelo.getDiscograficaService().showOneDiscografica((String) artistaView.getDiscograficaBox().getSelectedItem());
        if (artistaUpdate == null) {
            Util.showErrorAlert("Selecciona un artista a actualizar");
        } else {
            artistaUpdate.setNombre(artistaView.getTxtNombreArtista().getText());
            artistaUpdate.setPais(artistaView.getTxtPaisArtista().getText());
            artistaUpdate.setGenero( (String) artistaView.getBoxGeneroArt().getSelectedItem());
            artistaUpdate.setDiscografica(discografica);
            modelo.getArtistaService().updateArtista(artistaUpdate);
        }
    }

    private void deleteArtista() {
        Artista artistaBorrar = (Artista)artistaView.getArtistaList().getSelectedValue();
        if (artistaBorrar == null) {
            Util.showErrorAlert("Selecciona un artista a borrar");
        } else {
            try {
                modelo.getArtistaService().deleteArtista(artistaBorrar);
            } catch (IllegalStateException e) {
                if ("NO_SE_PUEDE_ELIMINAR".equals(e.getMessage())) {
                    Util.showErrorAlert("Este artista esta relacionado con uno o varias discos");
                }
            }
        }
    }

    private boolean algunCampoVacio() {
        return artistaView.getTxtNombreArtista().getText().isEmpty() || artistaView.getTxtPaisArtista().getText().isEmpty()
                || artistaView.getDiscograficaBox().getSelectedItem() == null || artistaView.getBoxGeneroArt().getSelectedItem() == null;
    }

    private String camposArtistaVacio() {
        emptyFields = "Los siguientes campos estan vacios: \n";
        if (artistaView.getTxtNombreArtista().getText().isEmpty()) {
            emptyFields += "Nombre \n";
        }
        if (artistaView.getTxtPaisArtista().getText().isEmpty()) {
            emptyFields += "Pais \n";
        }
        if (artistaView.getBoxGeneroArt().getSelectedItem() == null) {
            emptyFields += "Genero \n";
        }
        if ( artistaView.getDiscograficaBox().getSelectedItem() == null) {
            emptyFields += "Discografica";
        }
        return emptyFields;
    }

}
