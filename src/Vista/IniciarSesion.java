package Vista;

import Control.Control;

import javax.swing.*;
import java.awt.*;

public class IniciarSesion extends JFrame {
    private Control control;

    public JPanel panel, panel2;
    public JLabel usuario, password;
    public JTextField fieldUsuario;
    public JTextField fieldPassword;
    public JButton iniciar;

    public IniciarSesion(String title, Control control) {
        super(title);
        setSize(300, 150);
        setLocationRelativeTo(null);
        setBackground(Color.WHITE);
        setVisible(false);
        this.control = control;
    }

    @Override
    public void frameInit(){
        super.frameInit();
        panel = new JPanel(new GridLayout(2,2));

        usuario = new JLabel("USUARIO: ");
        password = new JLabel("CONTRASEÑA: ");

        fieldUsuario = new JTextField(20);
        fieldPassword = new JTextField(20);

        panel.add(usuario);
        panel.add(fieldUsuario);
        panel.add(password);
        panel.add(fieldPassword);

        iniciar = new JButton("Iniciar Sesión");
        iniciar.setActionCommand("Iniciar");
        panel2 = new JPanel();
        panel2.add(iniciar);

        this.add(panel);
        this.add(panel2, BorderLayout.SOUTH);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}