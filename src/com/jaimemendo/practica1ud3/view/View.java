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
     public JPanel panel1;
    public JPanel mainPanel;

    public JMenuItem itemOpciones;
    public JMenuItem itemDesconectar;
    public JMenuItem itemSalir;

    public final DiscograficaView DISCOGRAFICA_VIEW = new DiscograficaView();
    public final CancionView CANCION_VIEW = new CancionView();
    public final ArtistaView ARTISTA_VIEW = new ArtistaView();
    public final DiscoView DISCO_VIEW = new DiscoView();
    public final ConnectionView CONNECTION_VIEW = new ConnectionView();

     public View() {
         super("MitoStore");
         initFrame();
     }

     public void initFrame() {
         this.setContentPane(panel1);
         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         this.setVisible(true);
         this.setMinimumSize(new Dimension(1000, 600));
         this.setLocationRelativeTo(null);
         initConnectionPanel();
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

    public void initConnectionPanel() {
        mainPanel.removeAll();
        mainPanel.add(CONNECTION_VIEW.mainPanel,BorderLayout.CENTER);
        mainPanel.revalidate();
        mainPanel.repaint();
        this.pack();
    }

        public void initTabbed() {
         mainPanel.removeAll();
         tabbedDiscografica.removeAll();
         mainPanel.add(tabbedDiscografica, BorderLayout.CENTER);
        tabbedDiscografica.addTab("Disco",DISCO_VIEW.mainPanel);
        tabbedDiscografica.addTab("Canción",CANCION_VIEW.mainPanel);
        tabbedDiscografica.addTab("Artista",ARTISTA_VIEW.mainPanel);
        tabbedDiscografica.addTab("Discografía",DISCOGRAFICA_VIEW.mainPanel);
        tabbedDiscografica.revalidate();
        tabbedDiscografica.repaint();
            mainPanel.revalidate();
            mainPanel.repaint();
            this.pack();
    }

}
