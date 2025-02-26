import java.util.Arrays;
import java.util.Comparator;
import java.text.DecimalFormat;

public class OrdenamientosProductos {

    public static void main(String[] args) {
        OrdenamientosProductos pruebaOrdenamiento = new OrdenamientosProductos();
        pruebaOrdenamiento.probarOrdenamientos();
    }

    public OrdenamientosProductos() {}

    public void probarOrdenamientos() {
        // Crear objetos Producto
        Producto producto1 = new Producto(16554 , "Arroz", 1000);
        Producto producto2 = new Producto(25443 , "Carne", 5000);
        Producto producto3 = new Producto(34565 , "Leche", 1200);

        // Comparar dos productos usando compareTo (por código):
        if (producto1.compareTo(producto2) > 0)
            System.out.println("El producto 1 es mayor que el producto 2 (por código)");
        else if (producto1.compareTo(producto2) < 0)
            System.out.println("El producto 1 es menor que el producto 2 (por código)");
        else
            System.out.println("El producto 1 es igual al producto 2 (por código)");

        // Crear un arreglo de productos desordenado:
        Producto[] productos = {producto1, producto2, producto3};

        // Ordenar usando el comparador por precio:
        Arrays.sort(productos, new Comparator<Producto>() {
            @Override
            public int compare(Producto p1, Producto p2) {
                return Double.compare(p1.getPrecio(), p2.getPrecio());
            }
        });

        System.out.println("\nProductos ordenados por precio:");
        for (Producto p : productos) {
            System.out.println(p);
        }

        // Ordenar usando el comparador por nombre:
        Arrays.sort(productos, new Comparator<Producto>() {
            @Override
            public int compare(Producto p1, Producto p2) {
                return p1.getNombre().compareTo(p2.getNombre());
            }
        });

        System.out.println("\nProductos ordenados por nombre:");
        for (Producto p : productos) {
            System.out.println(p);
        }
    }

    // Clase Producto con los atributos código, nombre y precio
    class Producto implements Comparable<Producto> {
        private int codigo;
        private String nombre;
        private double precio;

        public Producto(int codigo, String nombre, double precio) {
            this.codigo = codigo;
            this.nombre = nombre;
            this.precio = precio;
        }

        // Métodos getter
        public int getCodigo() {
            return codigo;
        }

        public String getNombre() {
            return nombre;
        }

        public double getPrecio() {
            return precio;
        }

        // Método compareTo para ordenar por código
        @Override
        public int compareTo(Producto otroProducto) {
            return Integer.compare(this.codigo, otroProducto.codigo);
        }

        // Método toString para mostrar la información del producto con formato
        @Override
        public String toString() {
            DecimalFormat formato = new DecimalFormat("###,###,###");
            String precioFormateado = precio % 1 == 0 ? String.format("%.0f", precio) : formato.format(precio);
            return "Producto{codigo=" + codigo + ", nombre='" + nombre + "', precio=" + precioFormateado + "}";
        }
    }
}
