package Vista;

import Control.Control;

import javax.swing.*;
import java.awt.*;

public class DatosCliente extends JFrame {
    private Control control;

    public JPanel panel, panel2;

    public JLabel cc, nombre, edad, correo, usuario, password;
    public JTextField fieldCC, fieldNombre, fieldEdad, fieldCorreo, fieldUsuario;
    public JPasswordField fieldPassword;

    public JButton crear;

    public DatosCliente(String title, Control control){
        super(title);
        setSize(350, 300);
        setLocationRelativeTo(null);
        setBackground(Color.WHITE);
        setVisible(false);
        this.control = control;
    }

    @Override
    public void frameInit(){
        super.frameInit();
        panel = new JPanel(new GridLayout(7, 2));
        panel2 = new JPanel();

        cc = new JLabel("CC: ");
        nombre = new JLabel("NOMBRE: ");
        edad = new JLabel("EDAD: ");
        correo = new JLabel("CORREO: ");
        usuario = new JLabel("USUARIO: ");
        password = new JLabel("CONTRASEÑA: ");
       

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
        

        crear = new JButton("CREAR");
        crear.setActionCommand("CrearCliente");
        panel2.add(crear);

        this.add(panel);
        this.add(panel2, BorderLayout.SOUTH);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}
