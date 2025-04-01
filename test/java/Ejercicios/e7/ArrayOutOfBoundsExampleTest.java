package Ejercicios.e7;

import org.junit.jupiter.api.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias para la clase ArrayOutOfBoundsExample.
 * Se verifica el correcto manejo de la excepción ArrayIndexOutOfBoundsException.
 */
class ArrayOutOfBoundsExampleTest {

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
     * Se espera que capture la excepción ArrayIndexOutOfBoundsException y
     * que se imprima el mensaje de error correspondiente.
     */
    @Test
    void main() {
        ArrayOutOfBoundsExample.main(new String[]{});

        String output = outContent.toString().trim();
        assertEquals("Error: índice fuera del rango del arreglo.", output);
    }
}