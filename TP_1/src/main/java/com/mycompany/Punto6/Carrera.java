
package com.mycompany.Punto6;


import java.util.Scanner;

public class Carrera {
    public static void main(String[] args) {
        final int TOTAL_COMPETIDORES = 12;
        Vehiculo[] vehiculos = new Vehiculo[TOTAL_COMPETIDORES];

        try (Scanner scanner = new Scanner(System.in)) {
            for (int i = 0; i < TOTAL_COMPETIDORES; i++) {
                System.out.println("Competidor #" + (i + 1));

                String numero = leerNumeroVehiculo(scanner);
                double tiempo = leerTiempoValido(scanner);

                vehiculos[i] = new Vehiculo(numero, tiempo);
                System.out.println();
            }

            // Buscar el de menor tiempo
            Vehiculo mejor = vehiculos[0];
            for (int i = 1; i < vehiculos.length; i++) {
                if (vehiculos[i].getTiempo() < mejor.getTiempo()) {
                    mejor = vehiculos[i];
                }
            }

            System.out.println("===== RESULTADO FINAL =====");
            System.out.println("Vehículo con mejor tiempo: " + mejor.getNumero());
            System.out.printf("Tiempo registrado: %.2f segundos\n", mejor.getTiempo());
        }
    }

    private static String leerNumeroVehiculo(Scanner scanner) {
        String numero;
        do {
            System.out.print("Ingrese el número de vehículo: ");
            numero = scanner.nextLine().trim();
            if (numero.isEmpty()) {
                System.out.println("️ El número de vehículo no puede estar vacío.");
            }
        } while (numero.isEmpty());
        return numero;
    }

    private static double leerTiempoValido(Scanner scanner) {
        double tiempo = -1;
        boolean valido = false;

        do {
            System.out.print("Ingrese el tiempo en segundos: ");
            String input = scanner.nextLine().trim();

            try {
                tiempo = Double.parseDouble(input);
                if (tiempo > 0) {
                    valido = true;
                } else {
                    System.out.println("️ El tiempo debe ser mayor que cero.");
                }
            } catch (NumberFormatException e) {
                System.out.println("️ Ingrese un número válido para el tiempo.");
            }
        } while (!valido);

        return tiempo;
    }
}
