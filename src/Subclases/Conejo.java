package Subclases;

import clase_base.Animal;

public class Conejo extends Animal {
    public Conejo(String nombre, int edad, String propietario) {
        super(nombre, edad, propietario);
    }

    @Override
    public double calcularCostoConsulta() {
        return 350000;
    }
}
