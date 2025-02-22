
// Bloque 3: Comentarios

// Mala práctica: Comentarios que mienten
class MalaPracticaComentarios {
    // Crea un usuario en la base de datos
    void guardarUsuarioEnBaseDeDatos(Usuario usuario) {
        // código
    }
}

// Buena práctica: Código autoexplicativo
class BuenaPracticaComentarios {
    void guardarUsuarioEnBaseDeDatos(Usuario usuario) {
        // código
    }
}

// Mala práctica: Uso innecesario de comentarios
class MalaPracticaComentariosDetalles {
    // Aumenta el precio en un 10%
    double aumentarPrecio(double precio) {
        return precio * 1.1;
    }
}

// Buena práctica: Código autoexplicativo
class BuenaPracticaComentariosDetalles {
    double aumentarPrecio(double precio) {
        return precio * 1.1;
    }
}

// Mala práctica: Comentarios que dicen qué hace el código
class MalaPracticaComentariosRedundantes {
    // Este método guarda los datos en la base de datos
    void guardarDatos() {
        // código para guardar en la base de datos
    }
}

// Buena práctica: Código autoexplicativo
class BuenaPracticaComentariosRedundantes {
    void guardarDatos() {
        baseDeDatos.guardar(datos);
    }
}
// Mala práctica: Comentarios innecesarios
class MalaPracticaComentarios {
    void calcularSuma(int a, int b) {
        // Sumar los dos números
        int suma = a + b; // Sumar a y b
        // Mostrar el resultado
        System.out.println(suma); // Imprimir el resultado
    }
}

// Buena práctica: Comentarios solo cuando sean necesarios
class BuenaPracticaComentarios {
    void calcularSuma(int a, int b) {
        // La lógica es simple, no se necesita comentario.
        int suma = a + b;
        System.out.println(suma);
    }

    // Ejemplo donde un comentario sí es necesario
    void manejarBaseDeDatos() {
        // Conexión a la base de datos con un driver JDBC obsoleto debido a limitaciones del sistema.
        // Esto es necesario temporalmente, hasta que se pueda actualizar a una solución más moderna.
        conectarBaseDeDatosConDriverAntiguo();
    }

    void conectarBaseDeDatosConDriverAntiguo() {
        // código de conexión a base de datos
    }
}
// Mala práctica: Comentarios que describen lo que hace el código
class MalaPracticaComentarioQue {
    void calcularDescuento(double precio) {
        // Si el precio es mayor de 100, se aplica un 10% de descuento
        if (precio > 100) {
            precio = precio * 0.9;
        }
        // Imprimir el precio con descuento
        System.out.println(precio);
    }
}

// Buena práctica: Comentarios que explican por qué se hace algo
class BuenaPracticaComentarioPorque {
    void calcularDescuento(double precio) {
        // Aplicamos un descuento solo si el precio es superior a 100,
        // para incentivar compras mayores a este valor.
        if (precio > 100) {
            precio = precio * 0.9;
        }
        System.out.println(precio);
    }
}
