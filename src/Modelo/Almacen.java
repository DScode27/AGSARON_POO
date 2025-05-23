package Modelo;

public class Almacen {
    private String nombre;
    private String direccion;
    private int abierto;
    private int cerrado;

    public Almacen(String nombre, String direccion, int abierto, int cerrado) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.abierto = abierto;
        this.cerrado = cerrado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getAbierto() {
        return abierto;
    }

    public void setAbierto(int abierto) {
        this.abierto = abierto;
    }

    public int getCerrado() {
        return cerrado;
    }

    public void setCerrado(int cerrado) {
        this.cerrado = cerrado;
    }
}
