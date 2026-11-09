package Subclases;

import Interfaces.Asegurable;
import Interfaces.Vacunable;
import clase_base.Animal;

public class Gato extends Animal implements Vacunable, Asegurable {

    private boolean esEsterilizado;

    // constructor
    public Gato(String nombre, int edad, String propietario, boolean esEsterilizado) {
        super(nombre, edad, propietario);
        this.esEsterilizado = esEsterilizado;
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
        return "POL-GATO-" + nombre;
    }
}
