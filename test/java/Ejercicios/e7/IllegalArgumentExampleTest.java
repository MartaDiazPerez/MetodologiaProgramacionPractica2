package Ejercicios.e7;

import org.junit.jupiter.api.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias para la clase IllegalArgumentExample.
 * Se verifican tanto los casos exitosos como aquellos que lanzan una excepción.
 */
class IllegalArgumentExampleTest {

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
     * Se espera que capture la excepción IllegalArgumentException y que se imprima el mensaje de error.
     */
    @Test
    void main() {
        IllegalArgumentExample.main(new String[]{});

        String output = outContent.toString().trim();
        assertTrue(output.contains("Error: El radio no puede ser negativo."));
    }

    /**
     * Prueba con un radio negativo.
     * Se espera una IllegalArgumentException con el mensaje correcto.
     */
    @Test
    void calcularAreaCirculo_negativeRadius() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                IllegalArgumentExample.calcularAreaCirculo(-5)
        );
        assertEquals("El radio no puede ser negativo.", exception.getMessage());
    }

    /**
     * Prueba con un radio válido.
     * Se espera que el metodo devuelva el área correcta sin lanzar excepciones.
     */
    @Test
    void calcularAreaCirculo_validRadius() {
        double area = IllegalArgumentExample.calcularAreaCirculo(3);
        assertEquals(Math.PI * 9, area, 0.0001);
    }
}