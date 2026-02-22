package com.jaimemendo.practica1ud3.view.disco;

import com.github.lgooddatepicker.components.DatePicker;
import com.jaimemendo.practica1ud3.model.entity.enums.ColoresEnum;
import com.jaimemendo.practica1ud3.model.entity.enums.Generos;

import javax.swing.*;

public class DiscoView {
    private JPanel panelDisco;
    private JPanel panelDisco1;
    private JPanel panelNombreDisco;
    private JTextField txtNombreDisco;
    private JPanel panelGeneroDisco;
    private JComboBox boxGeneroDis;
    private JPanel panelPrecioDisco;
    private JSpinner spinnerPrecio;
    private JPanel panelDisco2;
    private DatePicker fechaDisco;
    private JComboBox boxColores;
    private JPanel panelDisco3;
    private JComboBox comboArtistaDisco;
    private JPanel panelDisco4;
    private JButton btnAddDisco;
    private JButton btnBorrarDisco;
    private JButton btnModificarDisco;

    public JPanel mainPanel;
    private JList listDisco;
    private JComboBox boxDiscografica;
    private JComboBox boxArtista;

    private SpinnerNumberModel spinnerPrecioModel;

    private DefaultListModel dlmDisco;

    public DiscoView() {
        initComponents();
    }

    private void initComponents() {
        setListModel();
        setEnumComboBox();
        setSpinnerModels();
    }

    private void setListModel() {
        dlmDisco = new DefaultListModel();
        listDisco.setModel(dlmDisco);
    }

    private void setEnumComboBox() {
        for (ColoresEnum constant: ColoresEnum.values()) {
            boxColores.addItem(constant.getValor());
        }
        boxColores.setSelectedIndex(-1);

        for (Generos constant : Generos.values()) {
            boxGeneroDis.addItem(constant.getValor());
        }

        boxGeneroDis.setSelectedItem(-1);

    }

    private void setSpinnerModels() {
        spinnerPrecioModel = new SpinnerNumberModel(1, 1, 500, 1);
        spinnerPrecio.setModel(spinnerPrecioModel);
    }

    public int getPrecio() {
        Object value = spinnerPrecio.getValue();
        if (value instanceof Number) {
            return ((Number) value).intValue();
        } else {
            return 0; // o lanzar una excepción
        }
    }

    public JTextField getTxtNombreDisco() {
        return txtNombreDisco;
    }

    public JComboBox getBoxGeneroDis() {
        return boxGeneroDis;
    }

    public JSpinner getSpinnerPrecio() {
        return spinnerPrecio;
    }

    public DatePicker getFechaDisco() {
        return fechaDisco;
    }

    public JComboBox getBoxColores() {
        return boxColores;
    }

    public JComboBox getComboArtistaDisco() {
        return comboArtistaDisco;
    }

    public JButton getBtnAddDisco() {
        return btnAddDisco;
    }

    public JButton getBtnBorrarDisco() {
        return btnBorrarDisco;
    }

    public JButton getBtnModificarDisco() {
        return btnModificarDisco;
    }

    public DefaultListModel getDlmDisco() {
        return dlmDisco;
    }

    public JList getListDisco() {
        return listDisco;
    }

    public JComboBox getBoxDiscografica() {
        return boxDiscografica;
    }

    public JComboBox getBoxArtista() {
        return boxArtista;
    }
}
