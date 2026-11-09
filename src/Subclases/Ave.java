package Subclases;

import Interfaces.Asegurable;
import Interfaces.Vacunable;
import clase_base.Animal;

public class Ave extends Animal implements Vacunable, Asegurable {

    private double pesoGramos;

    // constructor
    public Ave(String nombre, int edad, String propietario, double pesoGramos) {
        super(nombre, edad, propietario);
        this.pesoGramos = pesoGramos;
    }

    @Override
    public double calcularCostoConsulta() {
        return 45000 + (edad * 3000);
    }

    @Override
    public void registrarVacunas(String nombre) {
    }

    @Override
    public int getVacunasAplicadas() {
        return 0;
    }

    @Override
    public double calcularPrimaSeguro() {
        return edad * 80000;
    }

    @Override
    public String obtenerNumeroPoliza() {
        return "POL-AVE-" + nombre;
    }
}
