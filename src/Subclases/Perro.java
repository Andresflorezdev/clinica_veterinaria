package Subclases;

import Interfaces.Asegurable;
import Interfaces.Vacunable;
import clase_base.Animal;

// subclases
public class Perro extends Animal implements Vacunable, Asegurable {

    private String raza;

    // constructor
    public Perro(String nombre, int edad, String propietario, String raza) {
        super(nombre, edad, propietario); // llamamos el construtor padre que es clase_base.Animal
        this.raza = raza;
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
        return "POL_PERRO-" + nombre;
    }

}
