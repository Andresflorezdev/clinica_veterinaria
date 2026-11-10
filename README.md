# Sistema de Clinica Veterinaria

Sistema en Java que modela los animales y servicios de una clinica veterinaria aplicando herencia, clases abstractas, interfaces y polimorfismo.

---

## Estructura del Proyecto

```text
ClinicaVeterinaria/
|-- .idea/                             # Carpeta generada y traida por IntelliJ IDEA. Contiene la configuracion interna del proyecto en el IDE.
|   |-- inspectionProfiles/
|   |-- misc.xml
|   |-- modules.xml
|   `-- workspace.xml
|-- out/                               # Carpeta de salidas generada tras compilar. Almacena los archivos binarios (.class) y se puede borrar o volver a generar en cualquier momento.
|   `-- production/
|       `-- ClinicaVeterinaria/
|           |-- clase_base/
|           |   `-- Animal.class
|           |-- Subclases/
|           |   |-- Perro.class
|           |   |-- Gato.class
|           |   |-- Ave.class
|           |   |-- Conejo.class
|           |   `-- Clinica.class
|           |-- Interfaces/
|           |   |-- Asegurable.class
|           |   `-- Vacunable.class
|           `-- Main.class
|-- src/                               # Carpeta de codigo fuente organizada en paquetes
|   |-- clase_base/                    # Carpeta que contiene la clase base abstracta
|   |   `-- Animal.java
|   |-- Subclases/                     # Carpeta que contiene las implementaciones y subclases concretas
|   |   |-- Perro.java
|   |   |-- Gato.java
|   |   |-- Ave.java
|   |   |-- Conejo.java
|   |   `-- Clinica.java
|   |-- Interfaces/                    # Carpeta que contiene los contratos de capacidad
|   |   |-- Asegurable.java
|   |   `-- Vacunable.java
|   `-- Main.java                      # Clase principal que ejecuta las pruebas del sistema
|-- .gitignore                         # Archivo para excluir del control de versiones carpetas autogeneradas (.idea y out)
`-- ClinicaVeterinaria.iml             # Descriptor del modulo creado por IntelliJ IDEA
```

> Nota sobre las carpetas del proyecto:
> - `.idea/`: Es una carpeta que trae y gestiona IntelliJ IDEA de forma automatica para almacenar preferencias, indices y configuraciones del entorno de desarrollo.
> - `out/`: Es la carpeta de salidas que se crea al compilar el proyecto; contiene el bytecode ejecutable (.class) producido por el compilador de Java. No requiere versionarse y se puede regenerar limpia siempre que se desee.
> - `src/`: Agrupa el codigo fuente distribuido en carpetas de paquetes (`clase_base/`, `Subclases/`, `Interfaces/`), manteniendo la logica modular y clasificada en lugar de tener archivos sueltos.

---

## Mapa del Sistema

| Clase / Entidad | Extiende | Implementa | Abstracta |
| :--- | :--- | :--- | :--- |
| Animal | Ninguna | Ninguna | Si |
| Perro | Animal | Vacunable, Asegurable | No |
| Gato | Animal | Vacunable, Asegurable | No |
| Ave | Animal | Ninguna | No |
| Clinica | Ninguna | Asegurable | No |
| Conejo | Animal | Ninguna | No |

---

## Preguntas y Respuestas del Laboratorio

### 1. La clase base: Animal

- **Pregunta A (Atributos comunes):** Identifica los tres datos que todo animal tiene. Decide que modificador de acceso corresponde para que las subclases puedan usarlos directamente, y justifica por que no son private ni public.
  - **Respuesta:**
    - Atributos: `nombre` (String), `edad` (int) y `propietario` (String).
    - Modificador: `protected`. No es `private` porque las subclases no podrian acceder a ellos directamente en sus metodos o constructores. No es `public` porque violaria el encapsulamiento permitiendo que cualquier clase ajena al paquete o jerarquia modifique la informacion sin restricciones.

- **Pregunta B (El metodo que todas deben resolver):** La clinica calcula el costo de la consulta. ¿Por que ese metodo no puede implementarse en Animal? Declaralo abstract, con la firma y el tipo de retorno correctos.
  - **Respuesta:** No puede implementarse en `Animal` porque no existe un valor generico; cada especie calcula su costo con reglas de negocio totalmente diferentes.
  - Firma: `public abstract double calcularCostoConsulta();`

- **Pregunta C (El metodo que todas heredan igual):** La ficha muestra siempre los mismos datos en el mismo formato. Implementalo en Animal para que todas las subclases lo hereden sin reescribirlo. Debe llamar internamente al metodo del punto B.
  - **Respuesta:** Se define en `Animal` como `public void imprimirFicha()`. Imprime los campos comunes (`nombre`, `edad`, `propietario`) y llama internamente al metodo abstracto `calcularCostoConsulta()` para mostrar el valor particular de cada especie.

- **Pregunta (Para pensar):** ¿Que pasaria si alguien intenta hacer `new Animal("Luna", 3, "Carlos")`? ¿Java lo detecta en compilacion o en ejecucion? ¿Por que?
  - **Respuesta:** Java lo detecta en **tiempo de compilacion**. Las clases abstractas no pueden ser instanciadas porque representan conceptos incompletos; el compilador emite un error e impide generar el programa.

---

### 2. Las subclases concretas: Perro, Gato, Ave

- **Pregunta:** ¿Que atributo propio necesita cada subclase ademas de los heredados?
  - **Respuesta:**
    - Perro: `raza` (String).
    - Gato: `esEsterilizado` (boolean).
    - Ave: `pesoGramos` (double).

- **Pregunta:** ¿Como llamas al constructor del padre desde la subclase?
  - **Respuesta:** Con la instruccion `super(nombre, edad, propietario);` en la primera linea de ejecucion del constructor hijo.

- **Pregunta:** ¿Que anotacion indica que estas cumpliendo un metodo del padre?
  - **Respuesta:** La anotacion `@Override`.

- **Pregunta:** ¿Por que Java te obliga a implementar el metodo de costo de consulta?
  - **Respuesta:** Porque `Animal` lo declaro abstracto. En Java, toda subclase concreta (no abstracta) debe implementar de forma obligatoria todos los metodos abstractos heredados para poder compilar.

---

### 3. Los contratos de capacidad: Interfaces Vacunable y Asegurable

- **Pregunta (Para pensar - Vacunable):** ¿Por que esta capacidad va en una interfaz y no como metodo abstracto en Animal? Piensa que pasaria si manana la clinica tambien vacuna peces o reptiles, que no son ni perros ni gatos.
  - **Respuesta:** Porque no todos los animales son vacunables en el modelo (las aves tienen otro protocolo). Si se colocara en `Animal`, forzaria a todas las especies a implementarlo innecesariamente. La interfaz permite desacoplar la capacidad para asignarla selectivamente a cualquier clase sin alterar la jerarquia de herencia.

- **Pregunta (Para pensar - Asegurable):** El momento de quiebre. Cuando implementes Clinica, nota que no extiende Animal. Aun asi puede implementar Asegurable. ¿Por que es posible? ¿Que dice eso sobre la diferencia entre herencia e interfaces?
  - **Respuesta:** Es posible porque una interfaz define una capacidad o rol contractual ("lo que puede hacer" / *can-do*), mientras que la herencia define identidad taxonomica ("lo que es" / *is-a*). `Clinica` no es un animal, pero si comparte la cualidad de poder asegurarse.

---

### 4. Las pruebas en el Main

- **Pregunta (Para pensar - Fichas con referencia polimorfica):** El metodo `imprimirFicha()` vive en Animal. ¿Como sabe Java cual costo de consulta mostrar para cada especie, si el metodo esta en la clase padre?
  - **Respuesta:** Mediante el **enlace dinamico** (*dynamic binding*). En tiempo de ejecucion, la maquina virtual de Java consulta el tipo real del objeto instanciado en memoria y ejecuta la implementacion sobrescrita de `calcularCostoConsulta()` correspondiente a esa subclase concreta.

- **Pregunta (Para pensar - Vacunar los que aplican):** Si declaras el perro como Perro puedes vacunarlo sin problema. ¿Por que el ave no podria llamar `registrarVacuna()` aunque quisieras? ¿Que te dice el compilador si lo intentas? Pruebalo y lee el mensaje.
  - **Respuesta:** Porque la clase `Ave` no implementa la interfaz `Vacunable`. El compilador valida los metodos disponibles segun el tipo y arroja un error en tiempo de compilacion: *"cannot find symbol: method registrarVacuna(String)"*.

- **Pregunta (Para pensar - Calcular las polizas):** ¿Por que el perro cabe tanto en un arreglo `Animal[]` como en uno `Asegurable[]`? ¿Que representa cada uno de esos dos tipos para el mismo objeto?
  - **Respuesta:** Porque `Perro` extiende de `Animal` e implementa `Asegurable`. En `Animal[]` se le trata por su naturaleza e identidad biologica; en `Asegurable[]` se le trata exclusivamente bajo su rol o contrato financiero con la aseguradora.

- **Pregunta (La verificacion final):** Sin modificar ninguna clase que ya construiste, crea una clase nueva Conejo que extienda Animal con un costo de consulta de $35.000 fijos. Agregalo al arreglo Animal[] del primer bloque. Cuenta: ¿cuantas lineas tuviste que cambiar fuera de la clase nueva? Eso mide si tu diseno es realmente extensible.
  - **Respuesta:** Solo se modifico **1 linea** en `Main.java` para instanciar y agregar `new Conejo(...)` al arreglo de animales. Ninguna clase existente (`Animal`, `Perro`, `Gato`, `Ave`, `Clinica` o las interfaces) tuvo que modificarse, demostrando cumplimiento directo del Principio Abierto/Cerrado (Open/Closed Principle).

