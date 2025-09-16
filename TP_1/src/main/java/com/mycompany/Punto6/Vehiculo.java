
package com.mycompany.Punto6;



public class Vehiculo {
    private final String numero;
    private final double tiempo;

    public Vehiculo(String numero, double tiempo) {
        this.numero = numero;
        this.tiempo = tiempo;
    }

    public String getNumero() {
        return numero;
    }

    public double getTiempo() {
        return tiempo;
    }
}
