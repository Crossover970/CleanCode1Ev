//17. Diferencias entre objetos y estructuras de datos
// Mala práctica: La clase contiene tanto datos como lógica, lo que la convierte en una mezcla entre objeto y estructura de datos
class Producto {
    public String nombre;
    public double precio;
    
    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    // La lógica de operación está incluida aquí, pero debería estar separada
    public double calcularDescuento(double porcentaje) {
        return this.precio * (1 - porcentaje);
    }
}
// Buena práctica: El objeto "Producto" solo contiene los datos y las funciones que operan sobre esos datos se mantienen separadas
class Producto {
    private String nombre;
    private double precio;
    
    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }
}

class Descuento {
    public double calcularDescuento(Producto producto, double porcentaje) {
        return producto.getPrecio() * (1 - porcentaje);
    }
}
//18. La Ley de Demeter
// Mala práctica: La clase "Pedido" conoce demasiados detalles internos del objeto "Cliente"
class Pedido {
    private Cliente cliente;

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
    }

    public void procesar() {
        // La clase Pedido conoce las "tripas" del objeto Cliente, accediendo a su ciudad, país, etc.
        String paisCliente = cliente.getDireccion().getCiudad().getPais().getNombre();
        System.out.println("Enviando a " + paisCliente);
    }
}

class Cliente {
    private Direccion direccion;
    
    public Direccion getDireccion() {
        return direccion;
    }
}

class Direccion {
    private Ciudad ciudad;
    
    public Ciudad getCiudad() {
        return ciudad;
    }
}

class Ciudad {
    private Pais pais;
    
    public Pais getPais() {
        return pais;
    }
}
// Buena práctica: La clase Pedido solo interactúa con métodos públicos del objeto Cliente sin conocer detalles internos
class Pedido {
    private Cliente cliente;

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
    }

    public void procesar() {
        // Pedido solo conoce lo necesario para procesar el envío, sin conocer las "tripas" del cliente
        String paisCliente = cliente.obtenerPaisCliente();
        System.out.println("Enviando a " + paisCliente);
    }
}

class Cliente {
    private Direccion direccion;
    
    public String obtenerPaisCliente() {
        return direccion.obtenerPais();
    }
}

class Direccion {
    private Ciudad ciudad;
    
    public String obtenerPais() {
        return ciudad.obtenerPais();
    }
}

class Ciudad {
    private Pais pais;
    
    public String obtenerPais() {
        return pais.getNombre();
    }
}