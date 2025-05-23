package Modelo;

public class Persona {
    protected String cc;
    protected String nombre;
    protected int edad;
    protected Genero genero;
    protected String correo;
    protected String usuario;
    protected String password;
    protected Almacen almacen;

    public Persona(String cc, String nombre, int edad, Genero genero, String correo, String usuario, String password, Almacen almacen) {
        this.cc = cc;
        this.nombre = nombre;
        this.edad = edad;
        this.genero = genero;
        this.correo = correo;
        this.usuario = usuario;
        this.password = password;
        this.almacen = almacen;
    }

    public Persona(String cc, String nombre, int edad, Genero genero, String correo, String usuario, String password) {
        this.cc = cc;
        this.nombre = nombre;
        this.edad = edad;
        this.genero = genero;
        this.correo = correo;
        this.usuario = usuario;
        this.password = password;
    }

    public Persona(String cc, String nombre, int edad, String correo, String usuario, String password) {
        this.cc = cc;
        this.nombre = nombre;
        this.edad = edad;
        this.correo = correo;
        this.usuario = usuario;
        this.password = password;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Almacen getAlmacen() {
        return almacen;
    }

    public void setAlmacen(Almacen almacen) {
        this.almacen = almacen;
    }
}
