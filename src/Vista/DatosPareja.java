package Vista;

import Control.Control;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DatosPareja extends JFrame {

    private Control control;

    public JPanel panel, panel2;

    public JLabel cc, nombre, edad, correo, usuario, password, almacen, pareja;
    public JTextField fieldCC, fieldNombre, fieldEdad, fieldCorreo, fieldUsuario;
    public JTextField fieldPassword;
    public JComboBox parejas;
    public JComboBox almacenes;
    public ArrayList<String> listaClientes = new ArrayList<>();
    public ArrayList<String> listaAlmacenes = new ArrayList<>();

    public JButton crear = new JButton("CREAR");



    public DatosPareja(String title, Control control) {
        super(title);
        setSize(350, 300);
        setLocationRelativeTo(null);
        setBackground(Color.WHITE);
        setVisible(false);
        this.control = control;

    }

    public void P() {

        super.frameInit();
        panel = new JPanel(new GridLayout(8, 2));
        panel2 = new JPanel();

        cc = new JLabel("CC: ");
        nombre = new JLabel("NOMBRE: ");
        edad = new JLabel("EDAD: ");
        correo = new JLabel("CORREO: ");
        usuario = new JLabel("USUARIO: ");
        password = new JLabel("CONTRASEÑA: ");
        pareja = new JLabel("PAREJA: ");
        almacen = new JLabel("ALMACÉN: ");

        fieldCC = new JTextField(10);
        fieldNombre = new JTextField(20);
        fieldEdad = new JTextField(20);
        fieldCorreo = new JTextField(20);
        fieldUsuario = new JTextField(20);

        fieldPassword = new JPasswordField(10);

        panel.add(cc);
        panel.add(fieldCC);
        panel.add(nombre);
        panel.add(fieldNombre);
        panel.add(edad);
        panel.add(fieldEdad);
        panel.add(correo);
        panel.add(fieldCorreo);
        panel.add(usuario);
        panel.add(fieldUsuario);
        panel.add(password);
        panel.add(fieldPassword);

        panel.add(pareja);

        parejas = new JComboBox(control.ClienteJcombo());
        panel.add(parejas);

        panel.add(almacen);
        almacenes = new JComboBox(control.AlmacenesJcombo());
        panel.add(almacenes);

        crear.setActionCommand("CrearPareja");
        panel2.add(crear);

        this.add(panel);
        this.add(panel2, BorderLayout.SOUTH);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}
