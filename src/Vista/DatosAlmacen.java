package Vista;

import Control.Control;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DatosAlmacen extends JFrame {
    private Control control;

    public JPanel panel;
    public JLabel nombre, direccion, abierto, cerrado;
    public JTextField fieldNombre, fieldDireccion, fieldAbierto, fieldCerrado;
    public JButton crear;


    public DatosAlmacen(String title, Control control) {
        super(title);
        setSize(350, 200);
        setLocationRelativeTo(null);
        setBackground(Color.WHITE);
        setVisible(false);
        this.control = control;
    }

    @Override
    public void frameInit(){
        super.frameInit();
        panel = new JPanel(new GridLayout(4,2));

        nombre = new JLabel("NOMBRE: ");
        direccion = new JLabel("DIRECCIÓN: ");
        abierto = new JLabel("Horario de Apertura: ");
        cerrado = new JLabel("Horario de Cerrado: ");


        fieldNombre = new JTextField(20);
        fieldDireccion = new JTextField(20);
        fieldAbierto = new JTextField(2);
        fieldCerrado = new JTextField(2);

        panel.add(nombre);
        panel.add(fieldNombre);
        panel.add(direccion);
        panel.add(fieldDireccion);
        panel.add(abierto);
        panel.add(fieldAbierto);
        panel.add(cerrado);
        panel.add(fieldCerrado);

        crear = new JButton("CREAR");
        crear.setActionCommand("Almacen");
        JPanel panel2 = new JPanel();
        panel2.add(crear);

        this.add(panel);
        this.add(panel2, BorderLayout.SOUTH);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}
