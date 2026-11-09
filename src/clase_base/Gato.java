package clase_base;

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
}
