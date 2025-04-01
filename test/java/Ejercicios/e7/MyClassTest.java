package Ejercicios.e7;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias para la clase MyClass.
 * Se verifica que el mteodo saludar() imprima el mensaje esperado en la consola.
 */
class MyClassTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();  // Para capturar la salida de la consola
    private final PrintStream originalOut = System.out;  // Para restaurar la salida original

    /**
     * Redirige la salida estándar a un flujo de memoria antes de cada prueba.
     * Esto permite capturar y verificar las impresiones en la consola.
     */
    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));  // Redirige la salida a ByteArrayOutputStream
    }

    /**
     * Restaura la salida estándar después de cada prueba.
     * Esto asegura que las pruebas no interfieran con la salida del sistema.
     */
    @AfterEach
    void tearDown() {
        System.setOut(originalOut);  // Restaura la salida original
    }

    /**
     * Prueba que verifica que el metodo saludar() imprime el mensaje correcto.
     */
    @Test
    void saludar() {
        MyClass myClass = new MyClass();  // Crea una instancia de MyClass
        myClass.saludar();  // Llama al metodo saludar()

        // Verifica que el mensaje esperado está contenido en la salida de la consola
        String output = outContent.toString().trim();
        assertEquals("¡Hola desde MyClass!", output);  // Verifica que la salida es la esperada
    }
}