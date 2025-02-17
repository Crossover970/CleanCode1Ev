//19. Usa excepciones en lugar de código de retorno
// Mala práctica: Usar códigos de retorno para indicar errores
class Calculadora {
    public int dividir(int a, int b) {
        if (b == 0) {
            return -1; // Error, división por cero
        }
        return a / b;
    }
}
// Buena práctica: Lanzar una excepción cuando ocurre un error
class Calculadora {
    public int dividir(int a, int b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("No se puede dividir por cero");
        }
        return a / b;
    }
}
//20. Escribe primero el try-catch-finally
// Mala práctica: No manejar el estado en el catch
class Archivo {
    public void leer() {
        try {
            // Intentar leer archivo
            throw new Exception("Error de archivo");
        } catch (Exception e) {
            // No se asegura de que el sistema esté en un estado consistente
            System.out.println("Error: " + e.getMessage());
        }
    }
}
// Buena práctica: Garantizar que el sistema esté en un estado consistente
class Archivo {
    public void leer() {
        try {
            // Intentar leer archivo
            throw new Exception("Error de archivo");
        } catch (Exception e) {
            // Asegurarse de manejar el error correctamente
            System.out.println("Error: " + e.getMessage());
            // Recuperar o limpiar recursos si es necesario
        } finally {
            // Asegurar el cierre de recursos u operaciones necesarias
            System.out.println("Cerrando archivo...");
        }
    }
}
//21. Usa excepciones unchecked
// Mala práctica: Forzar a capturar o declarar la excepción
class Conexion {
    public void conectar() throws IOException {
        // Conectar a un servidor
        throw new IOException("Error de conexión");
    }
}
// Buena práctica: Usar excepciones unchecked (RuntimeException)
class Conexion {
    public void conectar() {
        // Conectar a un servidor
        throw new RuntimeException("Error de conexión");
    }
}
//22.No devuelvas Null
// Mala práctica: Devolver null puede causar NullPointerException
class Usuario {
    public String obtenerNombre() {
        return null; // Puede causar un error al llamar a este método
    }
}
// Buena práctica: No devolver null, usar un valor por defecto o un Optional
class Usuario {
    public String obtenerNombre() {
        return ""; // Valor por defecto en lugar de null
    }
}
