//29. Organización de clases
// Mala práctica: La clase tiene una organización desordenada con variables y métodos mezclados de forma poco clara

class Usuario {
    public static final String NOMBRE = "Usuario";  // Constantes públicas al principio
    private String nombre;   // Variables privadas al final
    private int edad;
    
    public String obtenerNombre() {
        return nombre;
    }
    
    public void actualizarEdad(int nuevaEdad) {
        if (nuevaEdad > 0) {
            this.edad = nuevaEdad;
        }
    }

    // Métodos privados no relacionados directamente con las funciones públicas
    private void calcularEdadMedia() {
        // Lógica interna innecesaria aquí
    }
}
// Buena práctica: La clase sigue una estructura clara y organizada

class Usuario {
    // Constantes públicas al principio
    public static final String NOMBRE = "Usuario";  

    // Variables privadas
    private String nombre;   
    private int edad;

    // Métodos públicos a continuación
    public String obtenerNombre() {
        return nombre;
    }

    public void actualizarEdad(int nuevaEdad) {
        if (nuevaEdad > 0) {
            this.edad = nuevaEdad;
        }
    }

    // Métodos privados al final, solo usados dentro de la clase
    private void calcularEdadMedia() {
        // Lógica interna
    }
}
//30. Las clases deberían ser pequeñas
// Mala práctica: La clase crece demasiado y mezcla responsabilidades

class GestionUsuario {
    private String nombre;
    private int edad;
    private String direccion;
    
    public void actualizarNombre(String nuevoNombre) {
        this.nombre = nuevoNombre;
    }
    
    public void actualizarEdad(int nuevaEdad) {
        this.edad = nuevaEdad;
    }
    
    public void actualizarDireccion(String nuevaDireccion) {
        this.direccion = nuevaDireccion;
    }

    // Función que realiza múltiples tareas no relacionadas
    public void realizarTareasDeGestion() {
        // Lógica de gestión de usuario (p.ej., actualizar datos, notificar, etc.)
    }
}
// Buena práctica: Clase pequeña, enfocada solo en una tarea

class GestionNombre {
    private String nombre;
    
    public void actualizarNombre(String nuevoNombre) {
        this.nombre = nuevoNombre;
    }
}

class GestionEdad {
    private int edad;
    
    public void actualizarEdad(int nuevaEdad) {
        this.edad = nuevaEdad;
    }
}
//31. Principio de Responsabilidad Única
// Mala práctica: Clase que tiene múltiples responsabilidades, lo que hace difícil de mantener

class Usuario {
    private String nombre;
    private int edad;
    
    public void actualizarNombre(String nuevoNombre) {
        this.nombre = nuevoNombre;
    }
    
    public void actualizarEdad(int nuevaEdad) {
        this.edad = nuevaEdad;
    }

    public void notificarUsuario() {
        // Lógica de notificación, lo cual es una responsabilidad diferente
    }
}
// Buena práctica: Cada clase tiene una única responsabilidad

class Usuario {
    private String nombre;
    private int edad;
    
    public void actualizarNombre(String nuevoNombre) {
        this.nombre = nuevoNombre;
    }

    public void actualizarEdad(int nuevaEdad) {
        this.edad = nuevaEdad;
    }
}

class Notificador {
    public void notificarUsuario() {
        // Lógica de notificación
    }
}
//32. Cohesión
// Mala práctica: La clase no es cohesiva, las variables no se usan de manera consistente en los métodos

class Usuario {
    private String nombre;
    private int edad;
    private String direccion;
    
    public void actualizarNombre(String nuevoNombre) {
        this.nombre = nuevoNombre;
    }

    public void actualizarEdad(int nuevaEdad) {
        this.edad = nuevaEdad;
    }

    public void actualizarDireccion(String nuevaDireccion) {
        this.direccion = nuevaDireccion;
    }

    public void realizarOperacion(int numero) {
        // Lógica que no tiene nada que ver con la clase Usuario
    }
}
// Buena práctica: Cada método trabaja sobre las variables de instancia de la clase

class Usuario {
    private String nombre;
    private int edad;
    
    public void actualizarNombre(String nuevoNombre) {
        this.nombre = nuevoNombre;
    }

    public void actualizarEdad(int nuevaEdad) {
        this.edad = nuevaEdad;
    }

    public String obtenerNombre() {
        return this.nombre;
    }
}
//33. Organiza tu código para prepararlo para el cambio
// Mala práctica: Dependencia directa de detalles de implementación

class Usuario {
    private String nombre;
    private int edad;
    
    public void setEdad(int edad) {
        // Código específico de la implementación que puede cambiar en el futuro
        this.edad = edad;
    }

    public int getEdad() {
        return edad;
    }
}
class GestorUsuario {
    private Usuario usuario;

    public GestorUsuario() {
        // Dependencia concreta en lugar de usar una interfaz o clase abstracta
        usuario = new Usuario();
    }

    public void actualizarEdad(int edad) {
        usuario.setEdad(edad);  // Cambio en Usuario implicaría cambios aquí
    }
}
// Buena práctica: El código depende de abstracciones y no de detalles de implementación

interface IUsuario {
    void setEdad(int edad);
    int getEdad();
}

class Usuario implements IUsuario {
    private String nombre;
    private int edad;
    
    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getEdad() {
        return edad;
    }
}

class GestorUsuario {
    private IUsuario usuario;  // Se usa la interfaz en lugar de una implementación concreta

    public GestorUsuario(IUsuario usuario) {
        this.usuario = usuario;
    }

    public void actualizarEdad(int edad) {
        usuario.setEdad(edad);  // Cambio en Usuario no afecta directamente al GestorUsuario
    }
}
//34. Separa la construcción de un sistema de su uso
// Mala práctica: La creación de objetos y la lógica de negocio están mezcladas, lo que dificulta el testing

class Pedido {
    private Producto producto;

    public Pedido() {
        // Instanciación dentro de la lógica de negocio
        this.producto = new Producto();
    }

    public void procesar() {
        producto.enviar();  // El acoplamiento entre Pedido y Producto es fuerte
    }
}

class Producto {
    public void enviar() {
        // Lógica de envío
    }
}
// Buena práctica: Se utiliza inyección de dependencias para separar la creación de objetos

class Pedido {
    private Producto producto;

    public Pedido(Producto producto) {
        this.producto = producto;  // El objeto Producto se inyecta, desacoplando la construcción
    }

    public void procesar() {
        producto.enviar();
    }
}

class Producto {
    public void enviar() {
        // Lógica de envío
    }
}

// En otro lugar del código, se inyecta la dependencia
Producto producto = new Producto();
Pedido pedido = new Pedido(producto);

//35. Utiliza copias de objetos para trabajar con concurrencia
// Mala práctica: Modificar un objeto compartido entre hilos sin control de concurrencia

class Cuenta {
    private int saldo;

    public void depositar(int cantidad) {
        saldo += cantidad;  // El saldo puede ser modificado por varios hilos a la vez, lo que causa problemas
    }

    public int obtenerSaldo() {
        return saldo;
    }
}

class HiloDeposito extends Thread {
    private Cuenta cuenta;

    public HiloDeposito(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    @Override
    public void run() {
        cuenta.depositar(100);  // Problema si dos hilos modifican 'saldo' simultáneamente
    }
}
// Buena práctica: Crear una copia del objeto para evitar problemas de concurrencia

class Cuenta {
    private final int saldo;

    public Cuenta(int saldoInicial) {
        this.saldo = saldoInicial;
    }

    public Cuenta depositar(int cantidad) {
        return new Cuenta(saldo + cantidad);  // Retornamos una nueva instancia con el saldo actualizado
    }

    public int obtenerSaldo() {
        return saldo;
    }
}

class HiloDeposito extends Thread {
    private Cuenta cuenta;

    public HiloDeposito(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    @Override
    public void run() {
        cuenta = cuenta.depositar(100);  // Se crea una nueva instancia de Cuenta con el saldo actualizado
    }
}
