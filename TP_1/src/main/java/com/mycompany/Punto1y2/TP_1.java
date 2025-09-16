

package com.mycompany.Punto1y2;


import java.util.Scanner;

public class TP_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cantidad;

        do {
            System.out.print("¿Cuántas notas desea ingresar? ");
            cantidad = scanner.nextInt();
            if (cantidad <= 0) {
                System.out.println(" Debe ingresar un número mayor que cero.");
            }
        } while (cantidad <= 0);

        Alumno alumno = new Alumno(cantidad);
        alumno.cargarNotas();

        System.out.println("\n Resultados:");
        System.out.println("Nota más alta: " + alumno.obtenerNotaMaxima());
        System.out.println("Promedio de notas: " + alumno.calcularPromedio());
        System.out.println("Cantidad de aprobados (≥6): " + alumno.contarAprobados());
        System.out.println("Cantidad de desaprobados (<6): " + alumno.contarDesaprobados());
    }
}
