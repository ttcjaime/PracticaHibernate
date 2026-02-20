package com.jaimemendo.practica1ud3.view.cancion;

import javax.swing.*;

public class CancionView {
    private JPanel panelCancion;
    private JTextField txtTituloCancion;
    private JSpinner spinnerDuracion;
    private JComboBox comboDiscoCancion;
    private JButton btnAddCancion;
    private JButton btnBorrarCancion;
    private JButton btnModificarCancion;
    public JPanel mainPanel;
    private JList listCancion;

    private DefaultListModel dlmCancion;

    public CancionView() {
        setListModel();
    }

    private void setListModel() {
        dlmCancion = new DefaultListModel();
        listCancion.setModel(dlmCancion);
    }

    public int getPrecio() {
        Object value = spinnerDuracion.getValue();
        if (value instanceof Number) {
            return ((Number) value).intValue();
        } else {
            return 0; // o lanzar una excepción
        }
    }

    public JTextField getTxtTituloCancion() {
        return txtTituloCancion;
    }

    public JSpinner getSpinnerDuracion() {
        return spinnerDuracion;
    }

    public JComboBox getComboDiscoCancion() {
        return comboDiscoCancion;
    }

    public JButton getBtnAddCancion() {
        return btnAddCancion;
    }

    public JButton getBtnBorrarCancion() {
        return btnBorrarCancion;
    }

    public JButton getBtnModificarCancion() {
        return btnModificarCancion;
    }

    public JList getListCancion() {
        return listCancion;
    }

    public DefaultListModel getDlmCancion() {
        return dlmCancion;
    }
}
