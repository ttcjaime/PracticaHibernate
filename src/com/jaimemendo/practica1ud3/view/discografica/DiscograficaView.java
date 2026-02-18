package com.jaimemendo.practica1ud3.view.discografica;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class DiscograficaView {

    public JPanel mainPanel;
    public JPanel panelDiscografica;
     JTextField txtNombreDiscografica;
     JTextField txtWebDiscografica;
     JTextField txtEmailDiscografica;
     JTextField txtTelefonoDiscografica;
     JButton addButtonDiscografica;
     JButton borrarButtonDiscografica;
     JButton modificarButtonDiscografica;
     JTextField txtPaisDiscografica;
     JList discograficaList;

     DefaultListModel dlmDiscografica;

    public DiscograficaView() {
        setTableModel();
    }

     private void setTableModel() {
         dlmDiscografica = new DefaultListModel();
         discograficaList.setModel(dlmDiscografica);
     }

    public JTextField getTxtEmailDiscografica() {
        return txtEmailDiscografica;
    }

    public JTextField getTxtNombreDiscografica() {
        return txtNombreDiscografica;
    }

    public JTextField getTxtWebDiscografica() {
        return txtWebDiscografica;
    }

    public JTextField getTxtTelefonoDiscografica() {
        return txtTelefonoDiscografica;
    }

    public JTextField getTxtPaisDiscografica() {
        return txtPaisDiscografica;
    }

    public JList getDiscograficaList() {
        return discograficaList;
    }

    public DefaultListModel getDlmDiscografica() {
        return dlmDiscografica;
    }

    public JButton getAddButtonDiscografica() {
        return addButtonDiscografica;
    }

    public JButton getBorrarButtonDiscografica() {
        return borrarButtonDiscografica;
    }

    public JButton getModificarButtonDiscografica() {
        return modificarButtonDiscografica;
    }
}
