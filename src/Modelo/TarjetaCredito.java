/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *99
 * @author User
 */
public class TarjetaCredito {

    private String  numero;
    private double credito;
    private String titular;
    private double deuda=0;

    public TarjetaCredito() {
       
    }
    public String getNumero() {
        return numero;
    }

    public double getDeuda() {
        return deuda;
    }

    public void setDeuda(double deuda) {
        this.deuda = deuda;
    }
    
    

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public double getCredito() {
        return credito;
    }

    public void setCredito(double credito) {
        this.credito = credito;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    @Override
    public String toString() {
        return "TarjetaCredito{" + "numero=" + numero + ", credito=" + credito + ", titular=" + titular + '}';
    }
    
    
}
