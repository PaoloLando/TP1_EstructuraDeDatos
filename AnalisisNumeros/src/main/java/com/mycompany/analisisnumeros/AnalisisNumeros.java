/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.analisisnumeros;

/**
 *
 * @author Paolo
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class AnalisisNumeros {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> numeros = new ArrayList<>();

        System.out.println("=== ANÁLISIS DE NÚMEROS ===");
        System.out.println("Ingrese números enteros (un número negativo termina la carga):");

        while (true) {
            System.out.print("Número: ");
            int num = sc.nextInt();
            if (num < 0) {
                break; // no se guarda el negativo
            }
            numeros.add(num);
        }

        if (numeros.isEmpty()) {
            System.out.println("No se ingresaron números válidos.");
            return;
        }

        // Calcular mayor, menor y promedio
        int mayor = Collections.max(numeros);
        int menor = Collections.min(numeros);
        double suma = 0;
        for (int n : numeros) {
            suma += n;
        }
        double promedio = suma / numeros.size();

        System.out.println("\n--- RESULTADOS ---");
        System.out.println("Mayor número: " + mayor);
        System.out.println("Menor número: " + menor);
        System.out.println("Promedio: " + promedio);

        // Eliminar números repetidos
        HashSet<Integer> sinDuplicados = new HashSet<>(numeros);
        ArrayList<Integer> listaFinal = new ArrayList<>(sinDuplicados);

        System.out.println("\n--- LISTA FINAL SIN DUPLICADOS ---");
        for (int n : listaFinal) {
            System.out.println(n);
        }
    }
}
 