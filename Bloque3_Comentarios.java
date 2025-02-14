
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
