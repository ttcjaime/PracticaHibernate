package com.jaimemendo.practica1ud3.view;

import com.github.lgooddatepicker.components.DatePicker;
import com.jaimemendo.practica1ud3.model.entity.Disco;
import com.jaimemendo.practica1ud3.view.Artista.ArtistaView;
import com.jaimemendo.practica1ud3.view.cancion.CancionView;
import com.jaimemendo.practica1ud3.view.disco.DiscoView;
import com.jaimemendo.practica1ud3.view.discografica.DiscograficaView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class View extends JFrame {
     public JTabbedPane tabbedDiscografica;
     JPanel panel1;
    JTable tableArtista;
    JSpinner spinnerPrecio;
    JTable tableDisco;
    JTable tableDiscografica;
    JSpinner spinnerDuracion;

    public JMenuItem itemOpciones;
    public JMenuItem itemDesconectar;
    public JMenuItem itemSalir;

    DefaultTableModel dtmArtistas;
    DefaultTableModel dtmDiscografica;
    DefaultTableModel dtmDisco;

    private SpinnerNumberModel spinnerPrecioModel;
    private SpinnerNumberModel spinnerDuracionModel;

    public final DiscograficaView DISCOGRAFICA_VIEW = new DiscograficaView();
    public final CancionView CANCION_VIEW = new CancionView();
    public final ArtistaView ARTISTA_VIEW = new ArtistaView();
    public final DiscoView DISCO_VIEW = new DiscoView();

     public View() {
         super("MitoStore");
         initFrame();
     }

     public void initFrame() {
         this.setContentPane(panel1);
         this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
         this.setVisible(true);
         this.setLocationRelativeTo(null);
         initPanels();
         setMenu();
         this.pack();
     }

    private void setMenu() {
        JMenuBar mbBar = new JMenuBar();
        JMenu menu = new JMenu("Archivo");
        itemOpciones = new JMenuItem("Opciones");
        itemOpciones.setActionCommand("Opciones");
        itemDesconectar = new JMenuItem("Conectar");
        itemDesconectar.setActionCommand("Conectar");
        itemSalir=new JMenuItem("Salir");
        itemSalir.setActionCommand("Salir");
        menu.add(itemOpciones);
        menu.add(itemDesconectar);
        menu.add(itemSalir);
        mbBar.add(menu);
        mbBar.add(Box.createHorizontalGlue());
        this.setJMenuBar(mbBar);
    }

//    private void setEnumComboBox() {
//        for (ColoresEnum constant: ColoresEnum.values()) {
//            boxColores.addItem(constant.getValor());
//        }
//        boxColores.setSelectedIndex(-1);
//        for (Generos constant: Generos.values()) {
//            boxGeneroDis.addItem(constant.getValor());
//            boxGeneroArt.addItem(constant.getValor());
//        }
//        boxGeneroDis.setSelectedIndex(-1);
//        boxGeneroArt.setSelectedIndex(-1);
//    }

    private void setTableModels() {
        //librosTabla, autoresTabla, editorialesTabla
        this.dtmArtistas=new DefaultTableModel();
        this.tableArtista.setModel(dtmArtistas);

        this.dtmDiscografica=new DefaultTableModel();
        this.tableDiscografica.setModel(dtmDiscografica);

        this.dtmDisco=new DefaultTableModel();
        this.tableDisco.setModel(dtmDisco);
    }

    private void setSpinnerModels() {
        spinnerPrecioModel  = new SpinnerNumberModel(1,1,500,1);
        spinnerPrecio.setModel(spinnerPrecioModel);
        spinnerDuracionModel  = new SpinnerNumberModel(1,1,500,1);
        spinnerDuracion.setModel(spinnerDuracionModel);
    }

    private void initPanels() {
        tabbedDiscografica.removeAll();
        tabbedDiscografica.addTab("Disco",DISCO_VIEW.mainPanel);
        tabbedDiscografica.addTab("Canción",CANCION_VIEW.mainPanel);
        tabbedDiscografica.addTab("Artista",ARTISTA_VIEW.mainPanel);
        tabbedDiscografica.addTab("Discografía",DISCOGRAFICA_VIEW.mainPanel);
        tabbedDiscografica.revalidate();
        tabbedDiscografica.repaint();
    }

}
