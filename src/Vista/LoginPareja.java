package Vista;

import Control.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class LoginPareja extends JFrame {

    private Control control;
    private IniciarSesion iniciarSesion;
    private ControlPDF controlPDF;

    public JPanel panel, panel2, panelProductos;
    public JTextField cantidad, fieldHora;

    public JButton factura = new JButton("GENERAR FACTURA"), comprar = new JButton("COMPRAR PRODUCTO");
    public String user;
    public JLabel nombre, almacen, precio, producto, hora;

    public JComboBox parejas;
    public JComboBox almacenes;
    public static ArrayList<JTextField> cantidades;
    private int c = 0;

    public LoginPareja(String title, Control control) {
        super(title);
        setSize(350, 300);
        setLocationRelativeTo(null);
        setBackground(Color.WHITE);
        setVisible(false);
        this.control = control;

    }

    public void pa() {
        super.frameInit();
        JPanel containerPanel = new JPanel();
        containerPanel.setLayout(new BoxLayout(containerPanel, BoxLayout.Y_AXIS));
        control.agregarProductos();
        panel = new JPanel();
        panel2 = new JPanel(new GridLayout(2, 1));
        panelProductos = new JPanel(new GridLayout(control.getProductosVenta().size() + 1, 3));

        nombre = new JLabel("NOMBRE: " + user);
        almacen = new JLabel("ALMACEN: ");
        hora = new JLabel("HORA DE COMPRA (FORMATO 24H): ");
        fieldHora = new JTextField(2);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        nombre.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        panel.add(nombre);
        panel.add(hora);
        panel.add(fieldHora);
        panelProductos.removeAll();
        almacenes = new JComboBox(control.AlmacenesJcombo());
        cantidades=new ArrayList<>();
        for (int i = 0; i < control.getProductosVenta().size(); i++) {

            precio = new JLabel(control.getProductosVenta().get(i).getNombre());
            producto = new JLabel(Double.toString(control.getProductosVenta().get(i).getPrecio()));
            cantidad = new JTextField();

            panelProductos.add(precio);
            panelProductos.add(producto);
            panelProductos.add(cantidad);
            cantidad.setText("0");
            
            cantidades.add(cantidad);

        }

        panelProductos.add(almacen);
        panelProductos.add(almacenes);

        comprar.setActionCommand("ComprarProducto");
        panel2.add(comprar);

        factura.setActionCommand("GenerarPDF");
        panel2.add(factura);
        containerPanel.add(panel);
        containerPanel.add(panelProductos);
        containerPanel.add(panel2);
        
        
        this.add(containerPanel);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}
