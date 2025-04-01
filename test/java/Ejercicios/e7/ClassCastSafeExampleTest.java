package Ejercicios.e7;

import org.junit.jupiter.api.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias para la clase ClassCastSafeExample.
 * Se verifican tanto los casos exitosos como aquellos que lanzan una excepción.
 */
class ClassCastSafeExampleTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    /**
     * Redirige la salida estándar a un flujo de memoria antes de cada prueba.
     */
    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    /**
     * Restaura la salida estándar después de cada prueba.
     */
    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    /**
     * Test del metodo main().
     * Se espera que cubra ambos casos de testCasting():
     * - Una conversión inválida que lanza ClassCastException.
     * - Una conversión exitosa con un Integer.
     */
    @Test
    void main() {
        ClassCastSafeExample.main(new String[]{});

        String output = outContent.toString().trim();
        assertTrue(output.contains("Error: No se puede convertir a Integer.")); // Excepción manejada
        assertTrue(output.contains("Convertido a Integer: 42")); // Conversión exitosa
    }

    /**
     * Prueba de conversión fallida con un Object genérico.
     * Debe lanzar ClassCastException y manejar el error.
     */
    @Test
    void testCasting_invalid() {
        ClassCastSafeExample.testCasting(new Object());
        assertTrue(outContent.toString().trim().contains("Error: No se puede convertir a Integer."));
    }

    /**
     * Prueba de conversión exitosa con un Integer válido.
     * No debe lanzar excepciones y debe imprimir el número correctamente.
     */
    @Test
    void testCasting_valid() {
        ClassCastSafeExample.testCasting(100);
        assertTrue(outContent.toString().trim().contains("Convertido a Integer: 100"));
    }
}