import Interfaces.Asegurable;
import Subclases.*;
import clase_base.Animal;

public class Main {
    public static void main(String[] args) {

        System.out.println("Animales");
        Animal[] animales = {
                new Perro("Rocky", 4, "Andres Florez", "criollo"),
                new Gato("Pelusa", 2, "Andres Florez", true),
                new Ave("Ruco", 2, "Jose Fernandez", 45.5),
                new Conejo("Rafael", 1, "Carlos Gomez")
        };
        for (Animal a: animales) {
            a.imprimirFicha();
        }
        System.out.println("Vacunacion");
        Perro miPerro = new Perro("Rocky", 4, "Andres Florez", "criollo");
        Gato miGato = new Gato("Rufino", 8, "Andres Florez", false);

        miPerro.registrarVacuna("Moquillo");
        miPerro.registrarVacuna("Tos");

        miGato.registrarVacuna("Leucemia felina");

        System.out.println("Vacunas aplicadas a mi perro " + miPerro.getVacunasAplicadas());
        System.out.println("Vacunas aplicadas a mi gato " + miGato.getVacunasAplicadas());
        System.out.println();

        System.out.println("Polizas");
        Clinica miClinica = new Clinica("Las Vegas", "calle 4 sur #48-110");

        Asegurable[] asegurables = {miPerro, miGato, miClinica};
        for (Asegurable asegurable : asegurables) {
            System.out.println("Poliza #: " + asegurable.obtenerNumeroPoliza() + "| Prima anual: $" + asegurable.calcularPrimaSeguro());
        }
    }
}