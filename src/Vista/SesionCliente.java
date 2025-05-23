/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import Control.Control;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author User
 */
public class SesionCliente extends JFrame {

    private Control control;
    public JPanel panel;
    public JLabel mensajeDeuda;
    public JLabel mensajeAbono;
    public JLabel mensajePrestamo;
    public JLabel mensajeAprobado;
    public JTextField campoAbono;
    public JButton botonAbonar = new JButton("Abonar");
    public JButton botonRechazar = new JButton("Rechazar");
    public JButton botonAceptar = new JButton("Aceptar");

    public SesionCliente(Control control) {
        setTitle("Gestión de Deuda");
        setSize(450, 280);
        setVisible(false);
        setBackground(Color.WHITE);
        setLocationRelativeTo(null);
        this.control = control;
    }

    public void mostrar() {
        super.frameInit();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // Crear un panel para organizar los componentes
        panel = new JPanel();
        panel.setLayout(null); // Desactivar el diseño predeterminado para colocar los componentes manualmente

        // Etiqueta para mostrar el mensaje centrado
        mensajeDeuda = new JLabel("Su deuda es de : $" + control.getCliente().getTarjeta().getDeuda(), SwingConstants.CENTER);
        mensajeDeuda.setBounds(10, 20, 360, 30);
        panel.add(mensajeDeuda);

        // Etiqueta y campo de texto para ingresar el abono
        mensajeAbono = new JLabel("Desea abonar (liberar cupo):");
        mensajeAbono.setBounds(10, 60, 200, 20);
        panel.add(mensajeAbono);

        campoAbono = new JTextField();
        campoAbono.setBounds(220, 60, 100, 20);
        panel.add(campoAbono);

        // Botón para realizar acciones relacionadas con el abono
        botonAbonar.setBounds(330, 60, 80, 20);
        botonAbonar.setActionCommand("Abonar");
        panel.add(botonAbonar);

        mensajePrestamo = new JLabel("La pareja:" + control.getPareja().getNombre() + "\nestá solicitando un préstamo por: $" + control.getSobreCupo(), SwingConstants.CENTER);
        mensajePrestamo.setBounds(10, 100, 360, 30);
        panel.add(mensajePrestamo);
        
        mensajeAprobado = new JLabel("¿desea aprobarlo?", SwingConstants.CENTER); 
        mensajeAprobado.setBounds(10, 140, 360, 30);
        panel.add(mensajeAprobado);
        
        botonAceptar.setBounds(110, 180, 80, 20);
        botonAceptar.setActionCommand("Aceptar");
        panel.add(botonAceptar);

        botonRechazar.setBounds(200, 180, 90, 20);
        botonRechazar.setActionCommand("Rechazar");
        panel.add(botonRechazar);

        // Agregar el panel al JFrame
        add(panel);

        // Hacer visible la ventana
        setVisible(true);
    }

}
