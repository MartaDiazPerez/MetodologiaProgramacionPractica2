package Ejercicios.e7;

import org.junit.jupiter.api.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias para la clase NumberFormatExample.
 * Verifica que se capture correctamente la excepción NumberFormatException
 * y que el mensaje correspondiente se imprima.
 */
class NumberFormatExampleTest {

    // Flujo de salida para capturar los mensajes impresos en la consola
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    /**
     * Redirige la salida estándar a un flujo de memoria antes de cada prueba.
     * Esto permite capturar y verificar las impresiones en la consola.
     */
    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));  // Redirige la salida estándar
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
     * Prueba que simula la ejecución del metodo main() de la clase NumberFormatExample.
     * Se verifica que el mensaje de error sea el esperado cuando ocurre la excepción NumberFormatException.
     */
    @Test
    void main() {
        // Ejecuta el metodo main() de la clase NumberFormatExample
        NumberFormatExample.main(new String[]{});

        // Captura la salida generada por la consola
        String output = outContent.toString().trim();

        // Verifica que el mensaje "Error: la cadena no es un número válido." esté presente
        assertTrue(output.contains("Error: la cadena no es un número válido."),
                "El mensaje de error no fue impreso correctamente.");
    }
}