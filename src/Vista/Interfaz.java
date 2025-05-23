package Vista;

import Control.Control;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Interfaz extends JFrame {
    private Control control;

    public JPanel panel;

    public JButton crearAlmacen, regCliente, regPareja, iniciarSesion, ordenar;

    public Interfaz(String title, Control control){
        super(title);
        setSize(300, 400);
        setLocationRelativeTo(null);
        setBackground(Color.WHITE);
        setVisible(true);
        this.control = control;
    }

    public void mostrarMensaje(String cadena){
        JOptionPane.showMessageDialog(null, cadena);
    }
    public void mensajeConsola(String mensaje){
        System.out.println(mensaje);
    }

    @Override
    public void frameInit(){
        super.frameInit();
        panel = new JPanel(new GridLayout(5,1));

        crearAlmacen = new JButton("Crear Almacén");
        crearAlmacen.setActionCommand("CrearAlmacen");
        regCliente = new JButton("Registrar Cliente");
        regCliente.setActionCommand("RegCliente");
        regPareja = new JButton("Registrar Pareja");
        regPareja.setActionCommand("RegPareja");
        iniciarSesion = new JButton("Iniciar Sesión");
        iniciarSesion.setActionCommand("IniciarSesion");
        ordenar = new JButton("Ordenar");
        ordenar.setActionCommand("Ordenar");

        panel.add(crearAlmacen);
        panel.add(regCliente);
        panel.add(regPareja);
        panel.add(iniciarSesion);
        panel.add(ordenar);

        this.add(panel);
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });

    }

}
