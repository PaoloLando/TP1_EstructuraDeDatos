
package com.mycompany.Punto4;



public class Camion {
    private final String patente;
    private final String chofer;
    private final String tipoCarga;
    private final String horaEgreso;

    public Camion(String patente, String chofer, String tipoCarga, String horaEgreso) {
        this.patente = patente;
        this.chofer = chofer;
        this.tipoCarga = tipoCarga;
        this.horaEgreso = horaEgreso;
    }

    public String getTipoCarga() {
        return tipoCarga.toLowerCase();
    }

    public void mostrarDatos() {
        System.out.println("Patente: " + patente);
        System.out.println("Chofer: " + chofer);
        System.out.println("Tipo de carga: " + tipoCarga);
        System.out.println("Hora de egreso: " + horaEgreso);
        System.out.println("---------------------------");
    }
}
