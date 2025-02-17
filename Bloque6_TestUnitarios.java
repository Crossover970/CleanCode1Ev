//Bloque6_TestUnitarios3. Las tres leyes del TDD
// Mala práctica: No seguimos las leyes del TDD
// Código de producción sin test previo

class Calculadora {
    public int sumar(int a, int b) {
        return a + b;
    }
}

public class Main {
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();
        System.out.println(calculadora.sumar(2, 3)); // Sin haber escrito un test primero
    }
}

// Buena práctica: Siguiendo las tres leyes del TDD

// 1. Escribimos el test primero
@Test
public void testSuma() {
    Calculadora calculadora = new Calculadora();
    int resultado = calculadora.sumar(2, 3);
    assertEquals(5, resultado); // Test falla porque la implementación aún no está escrita
}

// 2. Luego escribimos solo el código necesario para pasar el test
class Calculadora {
    public int sumar(int a, int b) {
        return a + b;
    }
}
// 3. Test pasa con el código mínimo necesario

//24. Mantén limpios los tests
// Mala práctica: Test desordenado y desorganizado

@Test
public void testCalculadora() {
    Calculadora calculadora = new Calculadora();
    int resultado1 = calculadora.sumar(2, 3);
    assertEquals(5, resultado1);
    
    int resultado2 = calculadora.restar(5, 3);
    assertEquals(2, resultado2);
    
   // Test largo y difícil de mantener
}
// Buena práctica: Tests organizados y claros
@Test
public void testSuma() {
    Calculadora calculadora = new Calculadora();
    int resultado = calculadora.sumar(2, 3);
    assertEquals(5, resultado);
}

@Test
public void testResta() {
    Calculadora calculadora = new Calculadora();
    int resultado = calculadora.restar(5, 3);
    assertEquals(2, resultado);
}
//25. Clean tests
// Mala práctica: Test difícil de leer y entender

@Test
public void testCalculadora() {
    Calculadora calculadora = new Calculadora();
    assertEquals(5, calculadora.sumar(2, 3));
    assertEquals(2, calculadora.restar(5, 3));
    assertEquals(6, calculadora.multiplicar(2, 3));
    assertEquals(2, calculadora.dividir(6, 3));
}
// Buena práctica: Test claro y legible

@Test
public void testSuma() {
    Calculadora calculadora = new Calculadora();
    assertEquals("La suma de 2 + 3 debe ser 5", 5, calculadora.sumar(2, 3));
}

@Test
public void testResta() {
    Calculadora calculadora = new Calculadora();
    assertEquals("La resta de 5 - 3 debe ser 2", 2, calculadora.restar(5, 3));
}

@Test
public void testMultiplicacion() {
    Calculadora calculadora = new Calculadora();
    assertEquals("La multiplicación de 2 * 3 debe ser 6", 6, calculadora.multiplicar(2, 3));
}

@Test
public void testDivision() {
    Calculadora calculadora = new Calculadora();
    assertEquals("La división de 6 / 3 debe ser 2", 2, calculadora.dividir(6, 3));
}
//26. Un Assert por test
// Mala práctica: Varios asserts en un solo test, difícil de saber qué está fallando

@Test
public void testOperaciones() {
    Calculadora calculadora = new Calculadora();
    assertEquals(5, calculadora.sumar(2, 3));
    assertEquals(2, calculadora.restar(5, 3));
    assertEquals(6, calculadora.multiplicar(2, 3));
    assertEquals(2, calculadora.dividir(6, 3)); // Un fallo nos podría afectar a todos los asserts
}
// Buena práctica: Un solo assert por test

@Test
public void testSuma() {
    Calculadora calculadora = new Calculadora();
    assertEquals(5, calculadora.sumar(2, 3));
}

@Test
public void testResta() {
    Calculadora calculadora = new Calculadora();
    assertEquals(2, calculadora.restar(5, 3));
}

@Test
public void testMultiplicacion() {
    Calculadora calculadora = new Calculadora();
    assertEquals(6, calculadora.multiplicar(2, 3));
}

@Test
public void testDivision() {
    Calculadora calculadora = new Calculadora();
    assertEquals(2, calculadora.dividir(6, 3));
}
//27. Un único concepto por test
// Mala práctica: Test que prueba más de un concepto a la vez

@Test
public void testOperaciones() {
    Calculadora calculadora = new Calculadora();
    int suma = calculadora.sumar(2, 3);
    int resta = calculadora.restar(5, 3);
    
    assertEquals(5, suma);
    assertEquals(2, resta); // Un solo test para verificar conceptos diferentes
}
// Buena práctica: Cada test verifica un solo concepto

@Test
public void testSuma() {
    Calculadora calculadora = new Calculadora();
    assertEquals(5, calculadora.sumar(2, 3));
}

@Test
public void testResta() {
    Calculadora calculadora = new Calculadora();
    assertEquals(2, calculadora.restar(5, 3));
}
//28. La regla F.I.R.S.T
// Mala práctica: Test que no es rápido ni repetible
// Este test depende de un servicio externo como una base de datos, lo que lo hace lento e impredecible

@Test
public void testConexionBaseDeDatos() {
    BaseDeDatos db = new BaseDeDatos();
    db.conectar(); // La conexión puede ser lenta dependiendo del entorno o la base de datos
    assertTrue(db.estaConectado());
    db.desconectar();
}
// Buena práctica: Test rápido, independiente y repetible
// Este test solo verifica un comportamiento en memoria, sin dependencias externas

@Test
public void testSuma() {
    Calculadora calculadora = new Calculadora();
    int resultado = calculadora.sumar(2, 3);
    assertEquals(5, resultado);  // Test que se ejecuta rápidamente y siempre de la misma manera
}

@Test
public void testMultiplicacion() {
    Calculadora calculadora = new Calculadora();
    int resultado = calculadora.multiplicar(2, 3);
    assertEquals(6, resultado);  // Test sin dependencia externa, predecible y repetible
}

