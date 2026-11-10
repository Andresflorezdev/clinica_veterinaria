package Subclases;

import clase_base.Animal;

public class Ave extends Animal {

    private double pesoGramos;

    // constructor
    public Ave(String nombre, int edad, String propietario, double pesoGramos) {
        super(nombre, edad, propietario);
        this.pesoGramos = pesoGramos;
    }

    @Override
    public double calcularCostoConsulta() {
        return 28000 + (pesoGramos * 100);
    }

}
