package Modelo;

import java.util.ArrayList;

public class Pareja extends Persona{
    private double monto;
    private Cliente cliente;
    private ArrayList<Producto> productos = new ArrayList<>();

    public Pareja(String cc, String nombre, int edad, String correo, String usuario, String password, Almacen almacen, Cliente cliente) {
        super(cc, nombre, edad, Genero.MUJER, correo, usuario, password, almacen);
        this.cliente = cliente;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
        
}
