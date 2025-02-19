public class Persona implements Comparable<Persona> {
    private int edad;
    private String nombre;

    // Constructor
    public Persona(int edad, String nombre) {
        this.edad = edad;
        this.nombre = nombre;
    }

    // Getters
    public int getEdad() {
        return edad;
    }

    public String getNombre() {
        return nombre;
    }

    // Implementación de compareTo para comparar por edad
    @Override
    public int compareTo(Persona otraPersona) {
        return Integer.compare(this.edad, otraPersona.edad); // Compara por edad
    }

    // Sobrescribimos toString para que imprima las propiedades
    @Override
    public String toString() {
        return nombre + " (" + edad + " años)";
    }

}