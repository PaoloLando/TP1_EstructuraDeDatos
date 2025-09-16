
package com.mycompany.Punto5;



import java.util.Scanner;

public class FacturaInternet {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            final int TOTAL_CLIENTES = 5;
            Cliente[] clientes = new Cliente[TOTAL_CLIENTES];

            for (int i = 0; i < TOTAL_CLIENTES; i++) {
                System.out.println("Cliente #" + (i + 1));

                String dni = leerDNIValido(scanner);
                int tipoServicio = leerTipoServicioValido(scanner);

                clientes[i] = new Cliente(dni, tipoServicio);
                System.out.println();
            }

            System.out.println("===== FACTURAS GENERADAS =====");
            for (Cliente cliente : clientes) {
                cliente.mostrarFactura();
            }
        }
    }

    private static String leerDNIValido(Scanner scanner) {
        String dni;
        do {
            System.out.print("Ingrese el DNI del cliente: ");
            dni = scanner.nextLine().trim();

            if (dni.isEmpty()) {
                System.out.println("️ El DNI no puede estar vacío.");
            } else if (!dni.matches("\\d+")) {
                System.out.println("️ El DNI debe contener solo números.");
                dni = "";
            }
        } while (dni.isEmpty());
        return dni;
    }

    private static int leerTipoServicioValido(Scanner scanner) {
        int tipo = 0;
        boolean valido = false;
        do {
            System.out.print("Ingrese el tipo de servicio (1 = 30Mb, 2 = 50Mb, 3 = 100Mb): ");
            String input = scanner.nextLine().trim();
            try {
                tipo = Integer.parseInt(input);
                if (tipo >= 1 && tipo <= 3) {
                    valido = true;
                } else {
                    System.out.println("️ Opción inválida. Debe ser 1, 2 o 3.");
                }
            } catch (NumberFormatException e) {
                System.out.println("️ Ingrese un número válido (1, 2 o 3).");
            }
        } while (!valido);
        return tipo;
    }
}
