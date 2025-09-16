
package com.mycompany.Punto7;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Censo {
    public static void main(String[] args) {
        ArrayList<Persona> personas = new ArrayList<>();
        HashSet<String> dnisRegistrados = new HashSet<>();

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                String dni = leerDniValido(scanner, dnisRegistrados);
                if (dni.equals("0")) break;

                int edad = leerEdadValida(scanner);
                char sexo = leerSexoValido(scanner);

                personas.add(new Persona(dni, edad, sexo));
                dnisRegistrados.add(dni);

                System.out.println();
            }
        }

        procesarResultados(personas);
    }

    private static String leerDniValido(Scanner scanner, HashSet<String> dnisRegistrados) {
        String dni;
        while (true) {
            System.out.print("Ingrese DNI (0 para terminar): ");
            dni = scanner.nextLine().trim();

            if (dni.equals("0")) return dni;

            if (!dni.matches("\\d{8,}")) {
                System.out.println("️ El DNI debe tener al menos 8 dígitos numéricos.");
            } else if (dnisRegistrados.contains(dni)) {
                System.out.println("️ Ese DNI ya fue registrado.");
            } else {
                return dni;
            }
        }
    }

    private static int leerEdadValida(Scanner scanner) {
        while (true) {
            System.out.print("Ingrese edad: ");
            String entrada = scanner.nextLine().trim();
            try {
                int edad = Integer.parseInt(entrada);
                if (edad > 0) return edad;
                else System.out.println("️ La edad debe ser mayor que 0.");
            } catch (NumberFormatException e) {
                System.out.println("️ Ingrese un número válido para la edad.");
            }
        }
    }

    private static char leerSexoValido(Scanner scanner) {
        while (true) {
            System.out.print("Ingrese sexo (M o F): ");
            String entrada = scanner.nextLine().trim().toUpperCase();
            if (entrada.equals("M") || entrada.equals("F")) {
                return entrada.charAt(0);
            } else {
                System.out.println("️ Sexo inválido. Ingrese 'M' o 'F'.");
            }
        }
    }

    private static void procesarResultados(ArrayList<Persona> personas) {
        int total = personas.size();
        int varones = 0;
        int mujeres = 0;
        int varones16165 = 0;
        Persona mayor = null;

        for (Persona p : personas) {
            if (p.getSexo() == 'M') {
                varones++;
                if (p.getEdad() >= 16 && p.getEdad() <= 65) {
                    varones16165++;
                }
            } else if (p.getSexo() == 'F') {
                mujeres++;
            }

            if (mayor == null || p.getEdad() > mayor.getEdad()) {
                mayor = p;
            }
        }

        System.out.println("\n===== RESULTADOS DEL CENSO =====");
        System.out.println("Total de personas censadas: " + total);
        System.out.println("Cantidad de varones: " + varones);
        System.out.println("Cantidad de mujeres: " + mujeres);

        if (varones > 0) {
            double porcentaje = (varones16165 * 100.0) / varones;
            System.out.printf("Porcentaje de varones entre 16 y 65 años: %.2f%%\n", porcentaje);
        } else {
            System.out.println("No se ingresaron varones.");
        }

        if (mayor != null) {
            System.out.println("\nPersona de mayor edad:");
            System.out.println("DNI: " + mayor.getDni());
            System.out.println("Edad: " + mayor.getEdad());
            System.out.println("Sexo: " + mayor.getSexo());
        }
    }
}

