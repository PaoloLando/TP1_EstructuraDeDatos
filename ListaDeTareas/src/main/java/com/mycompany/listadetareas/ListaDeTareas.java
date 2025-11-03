

package com.mycompany.listadetareas;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ListaDeTareas {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> tareas = new ArrayList<>();
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n=== GESTOR DE TAREAS ===");
            System.out.println("1. Agregar tarea");
            System.out.println("2. Insertar tarea en posición específica");
            System.out.println("3. Eliminar tarea por nombre");
            System.out.println("4. Mostrar tareas ordenadas alfabéticamente");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            String opcion = sc.nextLine();

            switch (opcion) {
                case "1":
                    System.out.print("Ingrese la tarea: ");
                    String tarea = sc.nextLine();
                    tareas.add(tarea);
                    System.out.println("Tarea agregada correctamente.");
                    break;

                case "2":
                    if (tareas.isEmpty()) {
                        System.out.println("No hay tareas cargadas.");
                        break;
                    }
                    System.out.print("Ingrese la tarea a insertar: ");
                    String nuevaTarea = sc.nextLine();
                    System.out.print("Ingrese la posición (0 a " + tareas.size() + "): ");
                    int pos = Integer.parseInt(sc.nextLine());
                    if (pos < 0 || pos > tareas.size()) {
                        System.out.println("Posición inválida.");
                    } else {
                        tareas.add(pos, nuevaTarea);
                        System.out.println("Tarea insertada en la posición " + pos + ".");
                    }
                    break;

                case "3":
                    if (tareas.isEmpty()) {
                        System.out.println("No hay tareas para eliminar.");
                        break;
                    }
                    System.out.print("Ingrese el nombre exacto de la tarea a eliminar: ");
                    String eliminar = sc.nextLine();
                    if (tareas.remove(eliminar)) {
                        System.out.println("Tarea eliminada correctamente.");
                    } else {
                        System.out.println("No se encontró esa tarea.");
                    }
                    break;

                case "4":
                    if (tareas.isEmpty()) {
                        System.out.println("No hay tareas para mostrar.");
                    } else {
                        ArrayList<String> tareasOrdenadas = new ArrayList<>(tareas);
                        Collections.sort(tareasOrdenadas, String.CASE_INSENSITIVE_ORDER);
                        System.out.println("\n--- TAREAS ORDENADAS ---");
                        for (String t : tareasOrdenadas) {
                            System.out.println("- " + t);
                        }
                    }
                    break;

                case "5":
                    continuar = false;
                    System.out.println("Saliendo del gestor de tareas...");
                    break;

                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        }
    }
}
