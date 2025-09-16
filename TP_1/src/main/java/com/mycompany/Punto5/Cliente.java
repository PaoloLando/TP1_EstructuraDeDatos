
package com.mycompany.Punto5;




public class Cliente {
    private final String dni;
    private final int tipoServicio;
    private final double montoPagar;

    public Cliente(String dni, int tipoServicio) {
        this.dni = dni;
        this.tipoServicio = tipoServicio;
        this.montoPagar = calcularMonto(tipoServicio);
    }

    private double calcularMonto(int tipo) {
        return switch (tipo) {
            case 1 -> 750;
            case 2 -> 1100;
            case 3 -> 1500 * 0.95;
            default -> 0;
        }; // 5% de descuento
    }

    public void mostrarFactura() {
        System.out.println("DNI: " + dni);
        System.out.println("Tipo de servicio: " + tipoServicio);
        System.out.printf("Monto a pagar: $%.2f\n", montoPagar);
        System.out.println("---------------------------");
    }
}
