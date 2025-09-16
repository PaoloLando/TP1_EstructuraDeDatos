
package com.mycompany.Punto3;



import java.util.Scanner;

public class Punto3 {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Ingrese la cantidad de productos: ");
            int n = scanner.nextInt();
            
            Producto[] productos = new Producto[n];
            
            for (int i = 0; i < n; i++) {
                System.out.print("Ingrese la cantidad del producto " + (i + 1) + ": ");
                int cantidad = scanner.nextInt();
                
                System.out.print("Ingrese el costo unitario del producto " + (i + 1) + ": ");
                double costo = scanner.nextDouble();
                
                productos[i] = new Producto(cantidad, costo);
            }
            
            System.out.println("\n--- Resultado ---");
            for (int i = 0; i < n; i++) {
                double total = productos[i].calcularTotal();
                System.out.println("Producto " + (i + 1) + ": total = $" + total);
                
                if (total > 1000) {
                    System.out.println("  Este producto supera los $1000");
                }
            }
        }
    }
}
