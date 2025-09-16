
package com.mycompany.Punto7;


public class Persona {
    private final String dni;
    private final int edad;
    private final char sexo;

    public Persona(String dni, int edad, char sexo) {
        this.dni = dni;
        this.edad = edad;
        this.sexo = sexo;
    }

    public String getDni() {
        return dni;
    }

    public int getEdad() {
        return edad;
    }

    public char getSexo() {
        return sexo;
    }
}
