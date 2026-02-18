package com.jaimemendo.practica1ud3.view.Artista;

import com.jaimemendo.practica1ud3.model.entity.enums.Generos;

import javax.swing.*;
import java.util.List;

public class ArtistaView {

    private JPanel panelArtista;
    private JPanel panelArtista1;
    private JPanel panelNombreArtista;
    private JTextField txtNombreArtista;
    private JPanel panelGeneroArtista;
    private JComboBox boxGeneroArt;
    private JPanel panelPaisArtista;
    private JTextField txtPaisArtista;
    private JPanel panelArtista2;
    private JPanel panelBtnAddArt;
    private JButton btnAddArt;
    private JPanel panelBorrarArt;
    private JButton btnBorrarArt;
    private JPanel panelModificarArt;
    private JButton btnModificar;
    public JPanel mainPanel;
    private JComboBox discograficaBox;
    private JList artistaList;

    private DefaultListModel dlmArtista;

    public ArtistaView() {
        initComponents();
    }

    private void initComponents() {
        setEnumComboBox();
        setTableModel();
    }

    private void setTableModel() {
        dlmArtista = new DefaultListModel();
        artistaList.setModel(dlmArtista);
    }

    private void setEnumComboBox() {
    for (Generos constant: Generos.values()) {
        boxGeneroArt.addItem(constant.getValor());
    }
        boxGeneroArt.setSelectedIndex(-1);
    }

    public JTextField getTxtNombreArtista() {
        return txtNombreArtista;
    }

    public JComboBox getBoxGeneroArt() {
        return boxGeneroArt;
    }

    public JTextField getTxtPaisArtista() {
        return txtPaisArtista;
    }

    public JList getArtistaList() {
        return artistaList;
    }

    public JComboBox getDiscograficaBox() {
        return discograficaBox;
    }

    public JButton getBtnAddArt() {
        return btnAddArt;
    }

    public JButton getBtnBorrarArt() {
        return btnBorrarArt;
    }

    public JButton getBtnModificar() {
        return btnModificar;
    }

    public DefaultListModel getDlmArtista() {
        return dlmArtista;
    }

}
