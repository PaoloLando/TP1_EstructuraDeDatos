/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tp2_edd;

import java.util.Scanner;

public class CineReserva {
    // 10 filas x 10 asientos
    static String[][] sala = new String[10][10];
    static String[][] clientes = new String[10][10]; // Guardamos nombre y teléfono

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        inicializarSala();

        do {
            System.out.println("\n--- SISTEMA DE RESERVA DE CINE ---");
            System.out.println("1. Mostrar sala");
            System.out.println("2. Reservar asiento");
            System.out.println("3. Eliminar reserva");
            System.out.println("4. Salir");
            System.out.print("Elija una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    mostrarSala();
                    break;
                case 2:
                    reservarAsiento(sc);
                    break;
                case 3:
                    eliminarReserva(sc);
                    break;
                case 4:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 4);
    }

    // Inicializar sala con "O" (asiento libre)
    public static void inicializarSala() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                sala[i][j] = "O"; // O = libre
                clientes[i][j] = null;
            }
        }
    }

    // Mostrar mapa de la sala
    public static void mostrarSala() {
        System.out.println("\nMapa de la sala (O = libre, X = reservado):");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(sala[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Reservar un asiento
    public static void reservarAsiento(Scanner sc) {
        System.out.print("Ingrese fila (0-9): ");
        int fila = sc.nextInt();
        System.out.print("Ingrese asiento (0-9): ");
        int asiento = sc.nextInt();

        if (sala[fila][asiento].equals("X")) {
            System.out.println("El asiento ya está reservado por: " + clientes[fila][asiento]);
        } else {
            sc.nextLine(); // limpiar buffer
            System.out.print("Ingrese su nombre: ");
            String nombre = sc.nextLine();
            System.out.print("Ingrese su teléfono: ");
            String telefono = sc.nextLine();

            sala[fila][asiento] = "X"; // Marcamos como reservado
            clientes[fila][asiento] = nombre + " (" + telefono + ")";
            System.out.println("Reserva realizada con éxito.");
        }
    }

    // Eliminar una reserva
    public static void eliminarReserva(Scanner sc) {
        System.out.print("Ingrese fila (0-9): ");
        int fila = sc.nextInt();
        System.out.print("Ingrese asiento (0-9): ");
        int asiento = sc.nextInt();

        if (sala[fila][asiento].equals("O")) {
            System.out.println("Ese asiento no tiene ninguna reserva.");
        } else {
            System.out.println("Reserva de " + clientes[fila][asiento] + " eliminada.");
            sala[fila][asiento] = "O";
            clientes[fila][asiento] = null;
        }
    }
}
