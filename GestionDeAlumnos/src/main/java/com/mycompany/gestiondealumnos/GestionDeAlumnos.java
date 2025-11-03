
package com.mycompany.gestiondealumnos;


import java.util.ArrayList;
import java.util.Scanner;

public class GestionDeAlumnos {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Estudiante> estudiantes = new ArrayList<>();
        
        System.out.println("=== GESTIÓN DE ESTUDIANTES ===");
        boolean continuar = true;
        
        while (continuar) {
            System.out.print("Ingrese nombre del estudiante: ");
            String nombre = sc.nextLine();
            
            System.out.print("Ingrese edad: ");
            int edad = Integer.parseInt(sc.nextLine());
            
            System.out.print("Ingrese nota promedio: ");
            double nota = Double.parseDouble(sc.nextLine());
            
            // Crear y agregar estudiante
            Estudiante est = new Estudiante(nombre, edad, nota);
            estudiantes.add(est);
            
            System.out.print("¿Desea agregar otro estudiante? (s/n): ");
            String resp = sc.nextLine();
            if (resp.equalsIgnoreCase("n")) {
                continuar = false;
            }
        }
        
        System.out.println("\n--- Estudiantes con nota mayor a 7 ---");
        for (Estudiante e : estudiantes) {
            if (e.getNota() > 7) {
                System.out.println(e);
            }
        }
        
        // Eliminar estudiantes con nota < 4
        estudiantes.removeIf(e -> e.getNota() < 4);
        
        System.out.println("\n--- Lista final de estudiantes ---");
        for (Estudiante e : estudiantes) {
            System.out.println(e);
        }
    }
}

class Estudiante {
    private String nombre;
    private int edad;
    private double nota;

    public Estudiante(String nombre, int edad, double nota) {
        this.nombre = nombre;
        this.edad = edad;
        this.nota = nota;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public double getNota() {
        return nota;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + " | Edad: " + edad + " | Nota: " + nota;
    }
}
