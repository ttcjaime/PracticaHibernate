package com.jaimemendo.practica1ud3.controller.discografica;

import com.jaimemendo.practica1ud3.model.Modelo;
import com.jaimemendo.practica1ud3.model.entity.Discografica;
import com.jaimemendo.practica1ud3.util.Util;
import com.jaimemendo.practica1ud3.view.discografica.DiscograficaView;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class DiscograficaController implements ActionListener, ListSelectionListener {

    private Modelo modelo;
    private DiscograficaView discograficaView;
    private String emptyFields;

    public DiscograficaController(Modelo modelo, DiscograficaView discograficaView) {
        this.modelo = modelo;
        this.discograficaView = discograficaView;

        addActionListener(this);
        addListListener(this);
        listDiscografica();
    }

    private void addActionListener(ActionListener listener) {
        discograficaView.getBorrarButtonDiscografica().addActionListener(listener);
        discograficaView.getAddButtonDiscografica().addActionListener(listener);
        discograficaView.getModificarButtonDiscografica().addActionListener(listener);
    }

    private void addListListener(ListSelectionListener listener) {
        discograficaView.getDiscograficaList().addListSelectionListener(listener);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "addDiscografica":
                addDiscografica();
                break;
            case "deleteDiscografica":
                deleteDiscografica();
                break;
            case "updateDiscografica":
                updateDiscografica();
                break;
        }
        listDiscografica();
    }

    public void listDiscografica(){
            List<Discografica> listDiscografica = modelo.getDiscograficaService().showAllDiscograficas();
            discograficaView.getDlmDiscografica().clear();

            for (Discografica discografica : listDiscografica) {
                discograficaView.getDlmDiscografica().addElement(discografica);
            }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (e.getValueIsAdjusting()) {
            Discografica discografica = (Discografica) discograficaView.getDiscograficaList().getSelectedValue();
            discograficaView.getTxtEmailDiscografica().setText(discografica.getEmailContacto());
            discograficaView.getTxtPaisDiscografica().setText(discografica.getPais());
            discograficaView.getTxtNombreDiscografica().setText(discografica.getNombre());
            discograficaView.getTxtTelefonoDiscografica().setText(String.valueOf(discografica.getTelefonoContacto()));
            discograficaView.getTxtWebDiscografica().setText(discografica.getSitioWeb());
        }
    }

    private void addDiscografica() {
        if (algunCampoDiscograficaVacio()) {
            Util.showErrorAlert(camposDiscograficaVacio());
            emptyFields = "";
        } else {
            Discografica discografica = new Discografica();
            discografica.setSitioWeb(discograficaView.getTxtWebDiscografica().getText());
            discografica.setEmailContacto(discograficaView.getTxtEmailDiscografica().getText());
            discografica.setNombre(discograficaView.getTxtNombreDiscografica().getText());
            discografica.setPais(discograficaView.getTxtPaisDiscografica().getText());
            discografica.setTelefonoContacto(Integer.parseInt(discograficaView.getTxtTelefonoDiscografica().getText()));
            modelo.getDiscograficaService().addDiscografica(discografica);
        }
    }

    private void updateDiscografica() {
        Discografica discograficaUpdate = (Discografica)discograficaView.getDiscograficaList().getSelectedValue();

        if (discograficaUpdate == null) {
            Util.showErrorAlert("Selecciona una discografica para actualizar");
        } else {
            discograficaUpdate.setSitioWeb(discograficaView.getTxtWebDiscografica().getText());
            discograficaUpdate.setEmailContacto(discograficaView.getTxtEmailDiscografica().getText());
            discograficaUpdate.setNombre(discograficaView.getTxtNombreDiscografica().getText());
            discograficaUpdate.setPais(discograficaView.getTxtPaisDiscografica().getText());
            discograficaUpdate.setTelefonoContacto(Integer.parseInt(discograficaView.getTxtTelefonoDiscografica().getText()));
            modelo.getDiscograficaService().updateDiscografica(discograficaUpdate);
        }
    }

    private void deleteDiscografica() {
        Discografica discograficaBorrar = (Discografica)discograficaView.getDiscograficaList().getSelectedValue();
        if (discograficaBorrar == null) {
            Util.showErrorAlert("Selecciona una discografica para borrar");
        } else {
            try {
                modelo.getDiscograficaService().deleteDiscografica(discograficaBorrar);
            } catch (IllegalStateException e) {
                System.out.println("aqui");
                if ("NO_SE_PUEDE_ELIMINAR".equals(e.getMessage())) {
                    System.out.println("aqui");
                    Util.showErrorAlert("Esta discografica esta relacionada con una o varios artistas y discos");
                }
            }
        }
    }

    private boolean algunCampoDiscograficaVacio() {
        return discograficaView.getTxtNombreDiscografica().getText().isEmpty() || discograficaView.getTxtWebDiscografica().getText().isEmpty()
                || discograficaView.getTxtTelefonoDiscografica().getText().isEmpty() || discograficaView.getTxtPaisDiscografica().getText().isEmpty()
                || discograficaView.getTxtEmailDiscografica().getText().isEmpty();
    }

    private String camposDiscograficaVacio() {
        emptyFields = "Los siguientes campos estan vacios: \n";
        if (discograficaView.getTxtPaisDiscografica().getText().isEmpty()) {
            emptyFields += "Pais \n";
        }
        if (discograficaView.getTxtNombreDiscografica().getText().isEmpty()) {
            emptyFields += "Nombre \n";
        }
        if (discograficaView.getTxtTelefonoDiscografica().getText().isEmpty() ) {
            emptyFields += "Telefono \n";
        }
        if (discograficaView.getTxtEmailDiscografica().getText().isEmpty()) {
            emptyFields += "Email";
        }
        if (discograficaView.getTxtWebDiscografica().getText().isEmpty()) {
            emptyFields += "Web";
        }
        return emptyFields;
    }

}
