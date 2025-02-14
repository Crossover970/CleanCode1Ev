
// Bloque 1: Nombres

// Mala práctica: Nombres poco descriptivos
class MalaPracticaNombres {
    int a = 7;
    void procesar() {
        for (int i = 0; i < a; i++) {
            // hacer algo
        }
    }
}

// Buena práctica: Nombres descriptivos
class BuenaPracticaNombres {
    int diasEnSemana = 7;
    void procesar() {
        for (int dia = 0; dia < diasEnSemana; dia++) {
            // hacer algo
        }
    }
}

// Mala práctica: Nombres difíciles de pronunciar
class Controlador {
    void manejar() {
        // código
    }
}

// Buena práctica: Nombres fáciles de pronunciar
class ControladorVehiculo {
    void iniciar() {
        // código
    }
}

// Mala práctica: Nombres poco significativos
class GestorVehiculo { 
    void manejarVehiculo() { 
        // código
    }
}

// Buena práctica: Nombres de clases y métodos claros
class Vehiculo {
    void arrancar() { 
        // código
    }
}
// Mala práctica: Nombres inconsistentes para clases que realizan tareas similares
class Manager {
    void gestionarEmpleados() {
        // Código para gestionar empleados
    }
}

class Controller {
    void controlarEmpleados() {
        // Código para controlar empleados
    }
}

class Supervisor {
    void supervisarEmpleados() {
        // Código para supervisar empleados
    }
}

// Buena práctica: Usar un nombre coherente para clases que realizan tareas similares
class GestorEmpleados {
    void gestionarEmpleados() {
        // Código para gestionar empleados
    }
}

class ControladorEmpleados {
    void controlarEmpleados() {
        // Código para controlar empleados
    }
}

class SupervisorEmpleados {
    void supervisarEmpleados() {
        // Código para supervisar empleados
    }
}
