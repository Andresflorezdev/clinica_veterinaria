package Subclases;

import Interfaces.Asegurable;
import Interfaces.Vacunable;
import clase_base.Animal;

public class Gato extends Animal implements Vacunable, Asegurable {

    private boolean esEsterilizado;
    private java.util.List<String> vacunas = new java.util.ArrayList<>();

    // constructor
    public Gato(String nombre, int edad, String propietario, boolean esEsterilizado) {
        super(nombre, edad, propietario);
        this.esEsterilizado = esEsterilizado;
    }

    @Override
    public double calcularCostoConsulta() {
        return 38000;
    }

    @Override
    public void registrarVacuna(String nombre) {
        vacunas.add(nombre);
    }

    @Override
    public int getVacunasAplicadas() {
        return vacunas.size();
    }

    @Override
    public double calcularPrimaSeguro() {
        if (esEsterilizado) {
            return 120000;
        } else {
            return 200000;
        }
    }

    @Override
    public String obtenerNumeroPoliza() {
        return "POL-GATO-" + nombre;
    }
}
