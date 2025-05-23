package Modelo;

import java.util.ArrayList;

public class Cliente extends Persona{
    private TarjetaCredito tarjeta;
    private Pareja pareja;

    private ArrayList<Pareja> parejas = new ArrayList<>();

    public Cliente(String cc, String nombre, int edad, String correo, String usuario, String password) {
        super(cc, nombre, edad, Genero.HOMBRE, correo, usuario, password);
        this.tarjeta = new TarjetaCredito();
    }

    public TarjetaCredito getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(TarjetaCredito tarjeta) {
        this.tarjeta = tarjeta;
    }
    
   
    public Pareja getPareja() {
        return pareja;
    }

    public void setPareja(Pareja pareja) {
        this.pareja = pareja;
    }

    public ArrayList<Pareja> getParejas() {
        return parejas;
    }

    public void setParejas(ArrayList<Pareja> parejas) {
        this.parejas = parejas;
    }
    
    public void agregarPareja(Pareja pareja){
        parejas.add(pareja);
    }



}
