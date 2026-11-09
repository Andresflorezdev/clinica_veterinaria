package clase_base;

// clase abstracta
public abstract class Animal {
    // atributos
    protected String nombre;
    protected int edad;
    protected String propietario;

    // constructor
    public Animal(String nombre, int edad, String propietario) {
        this.nombre = nombre;
        this.edad = edad;
        this.propietario = propietario;
    }

    // metodo
    public abstract double calcularCostoConsulta();

    // metodo que se hereda
    public void imprimirFicha() {
        System.out.println("nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("dueño: " + propietario);
        System.out.println("\n");
    }
}
