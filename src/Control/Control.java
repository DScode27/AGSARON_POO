package Control;

import Modelo.*;
import Vista.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import static java.lang.Double.parseDouble;

public class Control implements ActionListener {

    private Interfaz interfaz;
    private DatosAlmacen datosAlmacen;
    private DatosCliente datosCliente;
    private DatosPareja datosPareja;
    private IniciarSesion iniciarSesion;
    private LoginPareja loginPareja;
    private SesionCliente sesionCliente;

    private Cliente cliente;
    private Pareja pareja;
    private Almacen almacen;
    private Producto producto;
    private ControlPDF controlPDF;
    private double sobreCupo = 0;
   private ControlEmail controlEmail;

    private ArrayList<Almacen> almacenes = new ArrayList<>();
    private ArrayList<Cliente> clientes = new ArrayList<>();
    private ArrayList<Producto> productosVenta;

    private Map<String, String> dataBaseParejas = new HashMap<>();

    public Control() {
        interfaz = new Interfaz("HIDE&SEEK MARKET", this);
        interfaz.crearAlmacen.addActionListener(this);
        interfaz.regCliente.addActionListener(this);
        interfaz.regPareja.addActionListener(this);
        interfaz.iniciarSesion.addActionListener(this);
        interfaz.ordenar.addActionListener(this);

        datosAlmacen = new DatosAlmacen("DATOS ALMACEN", this);
        datosAlmacen.crear.addActionListener(this);

        datosCliente = new DatosCliente("DATOS CLIENTE", this);
        datosCliente.crear.addActionListener(this);

        datosPareja = new DatosPareja("DATOS PAREJA", this);
        datosPareja.crear.addActionListener(this);

        iniciarSesion = new IniciarSesion("INICIAR SESION", this);
        iniciarSesion.iniciar.addActionListener(this);

        loginPareja = new LoginPareja("INTERFAZ PAREJA", this);
        loginPareja.comprar.addActionListener(this);
        loginPareja.factura.addActionListener(this);

        sesionCliente = new SesionCliente(this);
        sesionCliente.botonAbonar.addActionListener(this);
        sesionCliente.botonAceptar.addActionListener(this);
        sesionCliente.botonRechazar.addActionListener(this);
    }

    public double getSobreCupo() {
        return sobreCupo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Pareja getPareja() {
        return pareja;
    }

    public ArrayList<Producto> getProductosVenta() {
        return productosVenta;
    }

    public void setProductosVenta(ArrayList<Producto> productosVenta) {
        this.productosVenta = productosVenta;
    }

    public void crearAlmacen(String nombre, String direccion, int abierto, int cerrado) {
        almacen = new Almacen(nombre, direccion, abierto, cerrado);
        almacenes.add(almacen);
        interfaz.mostrarMensaje("ALMACEN CREADO");

    }

    //    -------------------------------------------------------------------------------------
    public String[] ClienteJcombo() {
        String[] listaparejasM = new String[datosPareja.listaClientes.size()];
        for (int i = 0; i < listaparejasM.length; i++) {
            listaparejasM[i] = datosPareja.listaClientes.get(i);
        }
        return listaparejasM;
    }

    public String[] AlmacenesJcombo() {
        String[] array = new String[datosPareja.listaAlmacenes.size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = datosPareja.listaAlmacenes.get(i);
        }
        return array;
    }

    public void crearCliente(String cc, String nombre, int edad, String correo, String usuario, String password) {
        cliente = new Cliente(cc, nombre, edad, correo, usuario, password);
        asignarTarjeta();
        clientes.add(cliente);
        datosPareja.listaClientes.add(nombre);
        controlEmail = new ControlEmail();
        controlEmail.transferirimail(correo);
        interfaz.mostrarMensaje("CLIENTE CREADO");

    }

    public void crearPareja(String cc, String nombre, int edad, String correo, String usuario, String password, Almacen almacen) {
        pareja = new Pareja(cc, nombre, edad, correo, usuario, password, almacen, cliente);
        cliente.agregarPareja(pareja);
        asignarPresupuestoPareja();
        controlEmail = new ControlEmail();
        controlEmail.transferirimail(correo);
        interfaz.mostrarMensaje("PAREJA CREADA");
    }

    public void asignarTarjeta() {
        Random random = new Random();
        cliente.getTarjeta().setNumero(Integer.toString(random.nextInt((99999999 - 11111111 + 1) + 11111111)));
        cliente.getTarjeta().setCredito(Math.round((2000000 + (3000000 * random.nextDouble())) / 100000) * 100000);
        cliente.getTarjeta().setTitular(cliente.getNombre());
        interfaz.mensajeConsola((cliente.getTarjeta().toString()));
    }

    public void asignarPresupuestoPareja() {
        for (int i = 0; i < cliente.getParejas().size(); i++) {
            cliente.getParejas().get(i).setMonto(((cliente.getTarjeta().getCredito() - cliente.getTarjeta().getDeuda()) / cliente.getParejas().size()));
        }
    }

    public void datosAlmacen() {
        String nombre = datosAlmacen.fieldNombre.getText();
        String direccion = datosAlmacen.fieldDireccion.getText();
        int abierto = Integer.parseInt(datosAlmacen.fieldAbierto.getText());
        int cerrado = Integer.parseInt(datosAlmacen.fieldCerrado.getText());

        crearAlmacen(nombre, direccion, abierto, cerrado);

        datosAlmacen.fieldNombre.setText("");
        datosAlmacen.fieldDireccion.setText("");
        datosAlmacen.fieldAbierto.setText("");
        datosAlmacen.fieldCerrado.setText("");
        datosPareja.listaAlmacenes.add(nombre);
    }

    public void datosCliente() {
        String cc = datosCliente.fieldCC.getText();
        String nombre = datosCliente.fieldNombre.getText();
        int edad = Integer.parseInt(datosCliente.fieldEdad.getText());
        String correo = datosCliente.fieldCorreo.getText();
        String usuario = datosCliente.fieldUsuario.getText();
        String password = Arrays.toString(datosCliente.fieldPassword.getPassword());
        crearCliente(cc, nombre, edad, correo, usuario, password);

        datosCliente.fieldCC.setText("");
        datosCliente.fieldNombre.setText("");
        datosCliente.fieldEdad.setText("");
        datosCliente.fieldCorreo.setText("");
        datosCliente.fieldUsuario.setText("");
        datosCliente.fieldPassword.setText("");

    }

    public void datosPareja() {
        String cc = datosPareja.fieldCC.getText();
        String nombre = datosPareja.fieldNombre.getText();
        int edad = Integer.parseInt(datosPareja.fieldEdad.getText());
        String correo = datosPareja.fieldCorreo.getText();
        String usuario = datosPareja.fieldUsuario.getText();
        String password = datosPareja.fieldPassword.getText();

        for (int i = 0; i < almacenes.size(); i++) {
            Almacen alm = almacenes.get(i);
            if (alm.getNombre().equals(datosPareja.almacenes.getSelectedItem())) {
                almacen = almacenes.get(i);
                break;
            }
        }

        for (int i = 0; i < clientes.size(); i++) {
            Cliente cli = clientes.get(i);
            if (cli.getNombre().equals(datosPareja.almacenes.getSelectedItem())) {
                cliente = clientes.get(i);
                break;
            }
        }

        crearPareja(cc, nombre, edad, correo, usuario, password, almacen);
        dataBaseParejas.put(usuario, password);

        datosPareja.fieldCC.setText("");
        datosPareja.fieldNombre.setText("");
        datosPareja.fieldEdad.setText("");
        datosPareja.fieldCorreo.setText("");
        datosPareja.fieldUsuario.setText("");
        datosPareja.fieldPassword.setText("");
    }

    public void iniciarSesion(String usuario, String password) {
        for (int i = 0; i < clientes.size(); i++) {
            for (int j = 0; j < clientes.get(i).getParejas().size(); j++) {
                if (usuario.equals(clientes.get(i).getParejas().get(j).getUsuario())) {
                    if (password.equals(clientes.get(i).getParejas().get(j).getPassword())) {
                        interfaz.mostrarMensaje("LOGIN EXITOSO");

                        loginPareja.user = usuario;
                        loginPareja.pa();
                        loginPareja.setVisible(true);
                        iniciarSesion.fieldUsuario.setText("");
                        iniciarSesion.fieldPassword.setText("");
                        iniciarSesion.setVisible(false);
                        pareja = clientes.get(i).getParejas().get(j);
                        cliente = clientes.get(i);

                    } else {
                        interfaz.mostrarMensaje("DATOS INCORRECTOS");
                    }
                }
            }
        }
    }

    public void agregarProductos() {
        productosVenta = new ArrayList<>();
        producto = new Producto("Arroz", 3000);
        productosVenta.add(producto);
        producto = new Producto("Aceite", 4000);
        productosVenta.add(producto);
        producto = new Producto("Papa", 2000);
        productosVenta.add(producto);
        producto = new Producto("Lentejas", 3000);
        productosVenta.add(producto);
        producto = new Producto("Pollo", 3000);
        productosVenta.add(producto);

    }

    public void compras() {
        if (Integer.parseInt(loginPareja.fieldHora.getText()) >= almacen.getAbierto() && Integer.parseInt(loginPareja.fieldHora.getText()) <= almacen.getCerrado()) {
            for (int i = 0; i < loginPareja.cantidades.size(); i++) {
                int cantidad = Integer.parseInt(loginPareja.cantidades.get(i).getText());
                if (cantidad != 0) {
                    if (pareja.getMonto() - cantidad * productosVenta.get(i).getPrecio() >= 0) {
                        pareja.setMonto(pareja.getMonto() - cantidad * productosVenta.get(i).getPrecio());
                        cliente.getTarjeta().setDeuda(cantidad * productosVenta.get(i).getPrecio() + cliente.getTarjeta().getDeuda());
                        for (int j = 0; j < cantidad; j++) {
                            Producto producto1 = new Producto();
                            producto1.setNombre(productosVenta.get(i).getNombre());
                            producto1.setPrecio(productosVenta.get(i).getPrecio());
                            pareja.getProductos().add(producto1);
                        }
                        loginPareja.cantidades.get(i).setText("0");
                    } else {
                        sobreCupo = cantidad * productosVenta.get(i).getPrecio() - pareja.getMonto();
                        sesionCliente.mostrar();
                    }
                }
            }
        } else {
            interfaz.mostrarMensaje("El almacen está cerrado!");
        }

    }

    public void ordenarNombres() {
        Collections.sort(clientes, new Comparator<Cliente>() {
            @Override
            public int compare(Cliente cliente1, Cliente cliente2) {
                return cliente1.getNombre().compareTo(cliente2.getNombre());
            }
        });

        interfaz.mensajeConsola("ORDENAMIENTO POR NOMBRE: ");
        interfaz.mensajeConsola("-----DESCENDENTE: -----");
        for (Cliente item : clientes) {
            interfaz.mensajeConsola(item.getNombre());
        }

        Collections.reverse(clientes);
        interfaz.mensajeConsola("-----ASCENDENTE: -----");
        for (Cliente value : clientes) {
            interfaz.mensajeConsola(value.getNombre());
        }
    }

    public void abonoDeuda(double abono) {
        if (cliente.getTarjeta().getCredito() > abono && cliente.getTarjeta().getDeuda() > abono) {
            cliente.getTarjeta().setDeuda(cliente.getTarjeta().getDeuda() - abono);
            interfaz.mostrarMensaje("Abono realizado con exito");
            asignarPresupuestoPareja();
        } else {
            interfaz.mostrarMensaje("Error al realizar el abono");
            interfaz.mostrarMensaje("Recuede que no puede\n abonar una cantidad mayor\n a su deuda o al credito asignado ");
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ("CrearAlmacen".equalsIgnoreCase(e.getActionCommand())) {
            datosAlmacen.setVisible(true);
        }
        if ("Almacen".equalsIgnoreCase(e.getActionCommand())) {
            datosAlmacen();
        }

        if ("RegCliente".equalsIgnoreCase(e.getActionCommand())) {
            datosCliente.setVisible(true);
        }
        if ("CrearCliente".equalsIgnoreCase(e.getActionCommand())) {
            datosCliente();
        }

        if ("RegPareja".equalsIgnoreCase(e.getActionCommand())) {
            datosPareja.setVisible(true);
            datosPareja.P();
        }
        if ("CrearPareja".equalsIgnoreCase(e.getActionCommand())) {
            datosPareja();
        }

        if ("IniciarSesion".equalsIgnoreCase(e.getActionCommand())) {
            iniciarSesion.setVisible(true);
        }

        if ("Iniciar".equalsIgnoreCase(e.getActionCommand())) {
            String usuario = iniciarSesion.fieldUsuario.getText();
            String password = iniciarSesion.fieldPassword.getText();

            iniciarSesion(usuario, password);

        }

        if ("ComprarProducto".equalsIgnoreCase(e.getActionCommand())) {
            compras();
        }

        if ("GenerarPDF".equalsIgnoreCase(e.getActionCommand())) {
            for (Producto producto : pareja.getProductos()) {
                controlPDF = new ControlPDF();
                controlPDF.generarPDF(pareja.getNombre(), pareja.getAlmacen().getNombre(), pareja);
            }
        }

        if ("Ordenar".equalsIgnoreCase(e.getActionCommand())) {
            ordenarNombres();
        }

        if ("Abonar".equalsIgnoreCase(e.getActionCommand())) {
            double abono = Double.parseDouble(sesionCliente.campoAbono.getText());
            abonoDeuda(abono);
        }
        if ("Aceptar".equalsIgnoreCase(e.getActionCommand())) {
            interfaz.mostrarMensaje("Recuerde que el sobre cupo\n sera sumado al credito de su tarjeta.");
            interfaz.mostrarMensaje("Su pareja Aprobo el sobre cupo");
            cliente.getTarjeta().setCredito(cliente.getTarjeta().getCredito() + sobreCupo);
            pareja.setMonto(pareja.getMonto() + sobreCupo);
            sesionCliente.setVisible(false);
            loginPareja.setVisible(true);
        }
        if ("Rechazar".equalsIgnoreCase(e.getActionCommand())) {
            interfaz.mostrarMensaje("Su pareja rechazo el sobre cupo");
            sesionCliente.setVisible(false);
        }
    }
}
