public class OrdenamientosObjetos {
    
    public static void main(String[] args) {
        OrdenamientosObjetos pruebaOrdenamiento = new OrdenamientosObjetos();
        pruebaOrdenamiento.probarOrdenamientos();
    }

    public OrdenamientosObjetos() {}

    public void probarOrdenamientos() {
        Persona persona1 = new Persona(62, "Diego");
        Persona persona2 = new Persona(63, "Fabiola");
        
        // Comparar los objetos Persona con compareTo
        if(persona1.compareTo(persona2) > 0)
            System.out.println("La persona 1 es mayor que la persona 2 (por edad)");
        else if(persona1.compareTo(persona2) < 0)
            System.out.println("La persona 1 es menor que la persona 2 (por edad)");
        else
            System.out.println("La persona 1 es igual que la persona 2 (por edad)");

        // Crear arreglo desordenado de 10 objetos Persona
        Persona[] personas = {
            new Persona(30, "Ricardo"),
            new Persona(25, "Marta"),
            new Persona(40, "Antonio"),
            new Persona(22, "Elena"),
            new Persona(35, "Sara"),
            new Persona(28, "David"),
            new Persona(60, "Tomás"),
            new Persona(19, "Clara"),
            new Persona(50, "Oscar"),
            new Persona(55, "Julia")
        };
        
        // Ordenar usando burbuja
        personas = burbuja(personas);

        // Imprimir el arreglo ordenado
        System.out.println("\nArreglo ordenado por burbuja:");
        for (Persona persona : personas) {
            System.out.println(persona);
        }
    }

    // Implementación del algoritmo de burbuja para ordenar un arreglo de Personas
    public static Persona[] burbuja(Persona[] arr) {
        int n = arr.length;
        Persona[] ordenado = arr.clone(); // Copia del arreglo original

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (ordenado[j].compareTo(ordenado[j + 1]) > 0) {
                    // Intercambio de personas
                    Persona temp = ordenado[j];
                    ordenado[j] = ordenado[j + 1];
                    ordenado[j + 1] = temp;
                }
            }
        }
        return ordenado;
    }
}