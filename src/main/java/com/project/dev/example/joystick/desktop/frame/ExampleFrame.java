/*
 * @fileoverview {FileName} se encarga de realizar tareas especificas.
 *
 * @version             1.0
 *
 * @author              Dyson Arley Parra Tilano <dysontilano@gmail.com>
 * Copyright (C) Dyson Parra
 *
 * @History v1.0 --- La implementacion de {FileName} fue realizada el 31/07/2022.
 * @Dev - La primera version de {FileName} fue escrita por Dyson A. Parra T.
 */
package com.project.dev.example.joystick.desktop.frame;

import com.project.dev.example.joystick.desktop.getter.GraphicGetter;
import com.project.dev.example.joystick.desktop.setter.GenericJoystickComponentActionSetter;
import com.project.dev.example.joystick.desktop.setter.NintendoJoystickComponentActionSetter;
import com.project.dev.example.joystick.desktop.setter.PolyJoystickComponentActionSetter;
import com.project.dev.joystick.exception.JoystickClientConnectionRefusedException;
import com.project.dev.joystick.exception.UnknownJoystickTypeException;
import com.project.dev.joystick.factory.JoystickFactory;
import com.project.dev.joystick.listener.JoystickServerListener;
import com.project.dev.joystick.name.generic.type.GenericJoystickServer;
import com.project.dev.joystick.name.nintendo.NintendoJoystick;
import com.project.dev.joystick.name.poly.PolyJoystick;
import com.project.dev.joystick.setter.GenericJoystickPrintActionSetter;
import com.project.dev.tray.setter.TrayIconSetter;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * TODO: Definición de {@code ExampleFrame}.
 *
 * @author Dyson Parra
 * @since 1.8
 */
public class ExampleFrame extends JFrame {

    /* Ancho de la ventana. */
    private int width = 0;
    /* Alto de la ventana. */
    private int height = 0;

    /*
     * Variables locales.
     */
    private String joystickType = "";                                           // Indica el tipo de joystick a utilizar.
    private String joystickName = "";                                           // Indica el nombre del joystick a utilizar.
    private GenericJoystickServer server = null;                                // Indica el joystick asociado a la ventana.
    private final ExampleFrame window = this;                                   // Referencia a la ventana.
    private JLabel player;                                                      // Es el jugador.
    private final int playerMoveQuantity = 6;                                   // Cantidad de veces que cabe el jugador a lo alto de la ventana.

    /**
     * TODO: Definición de {@code getJoystickType}.
     *
     * @return
     */
    public String getJoystickType() {
        return joystickType;
    }

    /**
     * TODO: Definición de {@code setJoystickType}.
     *
     * @param joystickType
     */
    public void setJoystickType(String joystickType) {
        this.joystickType = joystickType;
    }

    /**
     * TODO: Definición de {@code getJoystickName}.
     *
     * @return
     */
    public String getJoystickName() {
        return joystickName;
    }

    /**
     * TODO: Definición de {@code setJoystickName}.
     *
     * @param joystickName
     */
    public void setJoystickName(String joystickName) {
        this.joystickName = joystickName;
    }

    /**
     * TODO: Definición de {@code ExampleFrame}.
     *
     */
    public ExampleFrame() {
        initComponents();

        // Obtiene el alto en píxeles de la ventana.
        Dimension windowSize = window.getContentPane().getSize();
        width = windowSize.width;
        height = windowSize.height;
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT
     * modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 600, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 400, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * FIXME: Definición de {@code startFrame}. Inicializa el frame con la información obtenida del
     * frame anterior.
     */
    public void startFrame() {
        try {
            // Obtiene un joystick servidor del nombre indicado en el frame anterior usando la fábrica de joystick.
            server = (GenericJoystickServer) JoystickFactory.makeJoystick(joystickType, joystickName, null, 0);

            // Agrega acciones de impresión en pantalla a cada botón del joystick.
            GenericJoystickPrintActionSetter printActionSetter = new GenericJoystickPrintActionSetter();
            printActionSetter.addButtonPrintActions(server);

            // Asigna icono y título al frame, y agrega el frame al systemTray.
            window.setIconImage(GraphicGetter.getGraphic("example_icon.png").getImage());
            window.setTitle("Example en " + server.getServerIpAddress() + " Puerto " + server.getServerPort() + " (" + server.getName() + ")");
            TrayIconSetter.setTrayIconToFrame(window);

            // Agrega mensajes que informan cuando un cliente se conecte y cuando uno se desconecte.
            server.setOnJoystickServerListener(new JoystickServerListener() {
                @Override
                public void onClientConnected() {
                    new Thread(() -> {
                        JOptionPane.showMessageDialog(window, "Se ha conectado un cliente.");
                    }).start();
                }

                @Override
                public void onClientDisconnected() {
                    new Thread(() -> {
                        JOptionPane.showMessageDialog(window, "Se ha desconectado un cliente.");
                    }).start();
                }
            });

            // Indica que cuando se cierre la ventana se parará el servidor del joystick.
            this.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    server.stopServer();
                }
            });

            // Inicializa el componente que tendrá el jugador, y lo agrega a la ventana.
            player = new JLabel();
            player.setIcon(GraphicGetter.getGraphic("punch_01.png", width, height, playerMoveQuantity));
            player.setSize(player.getIcon().getIconWidth(), player.getIcon().getIconHeight());
            player.setLocation(0, 0);
            window.add(player, 0);

            // Asigna acciones para controlar el jugador y la ventana dependiendo del nombre del joystick.
            GenericJoystickComponentActionSetter componentActionSetter;

            switch (joystickName) {
                case NintendoJoystick.JOYSTICK_NAME:
                    componentActionSetter = new NintendoJoystickComponentActionSetter(player, window, width, height, playerMoveQuantity);
                    componentActionSetter.setButtonActions(server);
                    break;

                case PolyJoystick.JOYSTICK_NAME:
                    componentActionSetter = new PolyJoystickComponentActionSetter(player, window, width, height, playerMoveQuantity);
                    componentActionSetter.setButtonActions(server);
                    break;
            }

        } catch (JoystickClientConnectionRefusedException ex) {
            dispose();
        } catch (UnknownJoystickTypeException ex) {
            Logger.getLogger(ExampleFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ExampleFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    /**
     * Entrada principal del sistema.
     *
     * @param args argumentos de la linea de comandos.
     */
    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (javax.swing.UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ExampleFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(() -> {
            new ExampleFrame().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}