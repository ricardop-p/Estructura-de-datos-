public class OrdenamientosObjetos {
    
    public static void main(String[] args) {
        OrdenamientosObjetos pruebaOrdenamiento = new OrdenamientosObjetos();
        pruebaOrdenamiento.probarOrdenamientos();
    }

    public OrdenamientosObjetos() {}

    public void probarOrdenamientos() {
        // Crear productos con precios asignados
        Producto carne = new Producto(101, 120.0, 50, "Carne");
        Producto pan = new Producto(102, 30.0, 100, "Pan");
        Producto arroz = new Producto(103, 15.0, 200, "Arroz");

        // Crear arreglo estático de productos
        Producto[] productos = {
            carne,
            pan,
            arroz
        };

        // Agregar un nuevo producto (por ejemplo, un producto más caro que la carne)
        Producto leche = new Producto(104, 150.0, 30, "Leche");
        productos = agregarProducto(productos, leche);

        // Buscar un producto por código
        Producto encontrado = buscarProductoPorCodigo(productos, 102);
        if (encontrado != null) {
            System.out.println("\nProducto encontrado: " + encontrado);
        } else {
            System.out.println("\nProducto no encontrado.");
        }

        // Ordenar productos por precio utilizando el algoritmo de burbuja
        productos = ordenarPorPrecio(productos);

        // Imprimir los productos ordenados por precio
        System.out.println("\nProductos ordenados por precio:");
        for (Producto producto : productos) {
            System.out.println(producto);
        }

        // Ordenar productos por cantidad utilizando el algoritmo de burbuja
        productos = ordenarPorCantidad(productos);

        // Imprimir los productos ordenados por cantidad
        System.out.println("\nProductos ordenados por cantidad:");
        for (Producto producto : productos) {
            System.out.println(producto);
        }
    }

    // Método para agregar un producto a un arreglo de productos
    public Producto[] agregarProducto(Producto[] productos, Producto nuevoProducto) {
        Producto[] nuevoArreglo = new Producto[productos.length + 1];
        System.arraycopy(productos, 0, nuevoArreglo, 0, productos.length);
        nuevoArreglo[productos.length] = nuevoProducto;
        return nuevoArreglo;
    }

    // Método para buscar un producto por su código
    public Producto buscarProductoPorCodigo(Producto[] productos, int codigo) {
        for (Producto producto : productos) {
            if (producto.getCodigo() == codigo) {
                return producto;
            }
        }
        return null; // Retorna null si no se encuentra el producto
    }

    // Ordenar productos por precio usando el algoritmo de burbuja
    public Producto[] ordenarPorPrecio(Producto[] productos) {
        int n = productos.length;
        Producto[] ordenado = productos.clone();

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (ordenado[j].getPrecio() > ordenado[j + 1].getPrecio()) {
                    Producto temp = ordenado[j];
                    ordenado[j] = ordenado[j + 1];
                    ordenado[j + 1] = temp;
                }
            }
        }
        return ordenado;
    }

    // Ordenar productos por cantidad usando el algoritmo de burbuja
    public Producto[] ordenarPorCantidad(Producto[] productos) {
        int n = productos.length;
        Producto[] ordenado = productos.clone();

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (ordenado[j].getCantidad() > ordenado[j + 1].getCantidad()) {
                    Producto temp = ordenado[j];
                    ordenado[j] = ordenado[j + 1];
                    ordenado[j + 1] = temp;
                }
            }
        }
        return ordenado;
    }
}

// Clase Producto
class Producto {
    private int codigo;
    private double precio;
    private int cantidad;
    private String nombre;

    // Constructor
    public Producto(int codigo, double precio, int cantidad, String nombre) {
        this.codigo = codigo;
        this.precio = precio;
        this.cantidad = cantidad;
        this.nombre = nombre;
    }

    // Métodos getter
    public int getCodigo() {
        return codigo;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    // Sobreescribir toString para una impresión más clara
    @Override
    public String toString() {
        return "Producto [Nombre=" + nombre + ", Codigo=" + codigo + ", Precio=" + precio + ", Cantidad=" + cantidad + "]";
    }
}
