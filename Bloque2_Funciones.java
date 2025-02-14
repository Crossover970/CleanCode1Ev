
// Bloque 2: Funciones

// Mala práctica: Funciones largas y con varias responsabilidades
class MalaPracticaFunciones {
    void procesar() {
        cargarDatos();
        validarDatos();
        transformarDatos();
        guardarDatos();
    }

    void cargarDatos() {
        // código
    }

    void validarDatos() {
        // código
    }

    void transformarDatos() {
        // código
    }

    void guardarDatos() {
        // código
    }
}

// Buena práctica: Funciones pequeñas y con una única responsabilidad
class BuenaPracticaFunciones {
    void cargarDatos() {
        // código
    }

    void validarDatos() {
        // código
    }

    void transformarDatos() {
        // código
    }

    void guardarDatos() {
        // código
    }
}



// Mala práctica: Uso excesivo de switch
class MalaPracticaSwitch {
    Vehiculo crearVehiculo(String tipo) {
        switch (tipo) {
            case "coche":
                return new Coche();
            case "camion":
                return new Camion();
        }
        return null;
    }
}

// Buena práctica: Uso de polimorfismo
class BuenaPracticaSwitch {
    Vehiculo crearVehiculo(String tipo) {
        if ("coche".equals(tipo)) return new Coche();
        if ("camion".equals(tipo)) return new Camion();
        throw new IllegalArgumentException("Tipo de vehículo desconocido");
    }
}
// Mala práctica: demasiados parámetros
class MalaPracticaArgumentos {
    void procesarDatos(String nombre, int edad, String direccion, String telefono, String email, String fechaNacimiento) {
        // código
    }
}

// Buena práctica: pocos parámetros, agrupando información relacionada
class BuenaPracticaArgumentos {
    class Persona {
        String nombre;
        int edad;
        String direccion;

        Persona(String nombre, int edad, String direccion) {
            this.nombre = nombre;
            this.edad = edad;
            this.direccion = direccion;
        }
    }

    void procesarDatos(Persona persona) {
        // código
    }
}
// Mala práctica: "flag argument"
class MalaPracticaFlagArgument {
    void procesarDatos(String tipoDeProceso) {
        if (tipoDeProceso.equals("guardar")) {
            guardarDatos();
        } else if (tipoDeProceso.equals("cargar")) {
            cargarDatos();
        }
    }

    void guardarDatos() {
        // código para guardar
    }

    void cargarDatos() {
        // código para cargar
    }
}

// Buena práctica: funciones separadas
class BuenaPracticaFlagArgument {
    void procesarDatosParaGuardar() {
        guardarDatos();
    }

    void procesarDatosParaCargar() {
        cargarDatos();
    }

    void guardarDatos() {
        // código para guardar
    }

    void cargarDatos() {
        // código para cargar
    }
}
// Mala práctica: la función tiene efectos colaterales inesperados
class MalaPracticaSideEffects {
    void obtenerDatos() {
        // código que obtiene datos de una base de datos
        // Y además guarda los datos en un archivo (efecto colateral)
        guardarDatosEnArchivo();
    }

    void guardarDatosEnArchivo() {
        // código para guardar en archivo
    }
}

// Buena práctica: la función solo obtiene datos, sin efectos colaterales
class BuenaPracticaSideEffects {
    void obtenerDatos() {
        // código que obtiene datos de una base de datos
    }

    void guardarDatosEnArchivo() {
        // código para guardar en archivo
    }
}
// Mala práctica: repetición de código
class MalaPractica {
    void procesarCompra() {
        // lógica para procesar compra
        aplicarDescuento(0.1);
        calcularTotal();
    }

    void procesarDevolucion() {
        // lógica para procesar devolución
        aplicarDescuento(0.05);
        calcularTotal();
    }

    void aplicarDescuento(double porcentaje) {
        // aplicar descuento
    }

    void calcularTotal() {
        // calcular total
    }
}

// Buena práctica: evitar la repetición
class BuenaPractica{
    void procesarCompra() {
        procesarTransaccion(0.1);
    }

    void procesarDevolucion() {
        procesarTransaccion(0.05);
    }

    void procesarTransaccion(double descuento) {
        aplicarDescuento(descuento);
        calcularTotal();
    }

    void aplicarDescuento(double porcentaje) {
        // aplicar descuento
    }

    void calcularTotal() {
        // calcular total
    }
}
