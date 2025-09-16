
package com.mycompany.Punto4;



import java.util.Scanner;

public class ControlCamiones {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            final int TOTAL_CAMIONES = 30;
            
            Camion[] camiones = new Camion[TOTAL_CAMIONES];
            int contadorTe = 0;
            
            for (int i = 0; i < TOTAL_CAMIONES; i++) {
                System.out.println("Camión #" + (i + 1));
                
                String patente = leerCampoObligatorio(scanner, "Ingrese la patente: ");
                String nombre = leerCampoObligatorio(scanner, "Ingrese el nombre del chofer: ");
                String apellido = leerCampoObligatorio(scanner, "Ingrese el apellido del chofer: ");
                String chofer = nombre + " " + apellido;
                
                String tipoCarga = leerTipoCargaValido(scanner);
                
                String horaEgreso = leerCampoObligatorio(scanner, "Ingrese hora de egreso (ej: 14:30): ");
                
                camiones[i] = new Camion(patente, chofer, tipoCarga, horaEgreso);
                
                if (camiones[i].getTipoCarga().equals("té")) {
                    contadorTe++;
                }
                
                System.out.println();
            }
            
            System.out.println("\n===== INFORME DE CAMIONES =====");
            for (Camion camion : camiones) {
                camion.mostrarDatos();
            }
            
            System.out.println("Cantidad de camiones que transportaron té: " + contadorTe);
        }
    }

    // Método auxiliar para evitar campos vacíos
    private static String leerCampoObligatorio(Scanner scanner, String mensaje) {
        String input;
        do {
            System.out.print(mensaje);
            input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println(" XX️ Este campo no puede estar vacío.");
            }
        } while (input.isEmpty());
        return input;
    }

    // Método auxiliar para validar tipo de carga
    private static String leerTipoCargaValido(Scanner scanner) {
        String tipo;
        do {
            System.out.print("Ingrese tipo de carga (madera, yerba o té): ");
            tipo = scanner.nextLine().trim().toLowerCase();
            if (!(tipo.equals("madera") || tipo.equals("yerba") || tipo.equals("té"))) {
                System.out.println("️XX Tipo de carga inválido. Debe ser madera, yerba o té.");
            }
        } while (!(tipo.equals("madera") || tipo.equals("yerba") || tipo.equals("té")));
        return tipo;
    }
}
