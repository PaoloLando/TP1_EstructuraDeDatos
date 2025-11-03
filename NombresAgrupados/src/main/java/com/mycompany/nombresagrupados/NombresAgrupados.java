/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.nombresagrupados;

/**
 *
 * @author Paolo
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class NombresAgrupados {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Estructura: letra inicial -> lista de nombres
        HashMap<Character, ArrayList<String>> nombresMap = new HashMap<>();

        System.out.print("¿Cuántos nombres querés ingresar? ");
        int cantidad = sc.nextInt();
        sc.nextLine(); // limpiar el buffer del Enter

        // Cargar nombres
        for (int i = 0; i < cantidad; i++) {
            System.out.print("Ingrese el nombre " + (i + 1) + ": ");
            String nombre = sc.nextLine();

            // Obtener la inicial en mayúscula
            char inicial = Character.toUpperCase(nombre.charAt(0));

            // Si la clave no existe, la crea
            nombresMap.putIfAbsent(inicial, new ArrayList<>());

            // Agregar el nombre a la lista correspondiente
            nombresMap.get(inicial).add(nombre);
        }

        // Consultar por letra
        System.out.print("\nIngrese una letra para mostrar los nombres: ");
        char letra = Character.toUpperCase(sc.next().charAt(0));

        if (nombresMap.containsKey(letra)) {
            System.out.println("Nombres que empiezan con '" + letra + "':");
            for (String n : nombresMap.get(letra)) {
                System.out.println("- " + n);
            }
        } else {
            System.out.println("No hay nombres que empiecen con la letra '" + letra + "'.");
        }
    }
}
