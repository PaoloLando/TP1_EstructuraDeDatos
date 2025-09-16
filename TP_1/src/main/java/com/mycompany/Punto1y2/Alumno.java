
package com.mycompany.Punto1y2;


import java.util.Scanner;

public class Alumno {
    private final double[] notas;

    public Alumno(int cantidadNotas) {
        notas = new double[cantidadNotas];
    }

    public void cargarNotas() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < notas.length; i++) {
            double nota;
            do {
                System.out.print("Ingrese la nota " + (i + 1) + " (entre 0 y 10): ");
                nota = scanner.nextDouble();
                if (nota < 0 || nota > 10) {
                    System.out.println("️ Nota inválida. Debe estar entre 0 y 10.");
                }
            } while (nota < 0 || nota > 10);
            notas[i] = nota;
        }
    }

    public double obtenerNotaMaxima() {
        double max = notas[0];
        for (double nota : notas) {
            if (nota > max) {
                max = nota;
            }
        }
        return max;
    }

    public double calcularPromedio() {
        double suma = 0;
        for (double nota : notas) {
            suma += nota;
        }
        return suma / notas.length;
    }

    public int contarAprobados() {
        int contador = 0;
        for (double nota : notas) {
            if (nota >= 6) {
                contador++;
            }
        }
        return contador;
    }

    public int contarDesaprobados() {
        int contador = 0;
        for (double nota : notas) {
            if (nota < 6) {
                contador++;
            }
        }
        return contador;
    }
}
