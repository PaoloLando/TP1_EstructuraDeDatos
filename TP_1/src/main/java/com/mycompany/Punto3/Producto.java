
package com.mycompany.Punto3;


public class Producto {
    private final int cantidad;
    private final double costoUnitario;

    public Producto(int cantidad, double costoUnitario) {
        this.cantidad = cantidad;
        this.costoUnitario = costoUnitario;
    }

    public double calcularTotal() {
        return cantidad * costoUnitario;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getCostoUnitario() {
        return costoUnitario;
    }
}
