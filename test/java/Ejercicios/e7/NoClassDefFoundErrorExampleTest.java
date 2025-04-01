package Ejercicios.e7;

import org.junit.jupiter.api.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias para la clase NoClassDefFoundErrorExample.
 * Se verifica que se capture el error NoClassDefFoundError y se imprima el mensaje correspondiente.
 */
class NoClassDefFoundErrorExampleTest {

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
     * Prueba que verifica que el metodo main() capture el NoClassDefFoundError correctamente.
     * Se simula la ausencia de la clase 'MyClass' para lanzar un NoClassDefFoundError.
     */
    @Test
    void main() {
        // Intentamos ejecutar el metodo main() de la clase NoClassDefFoundErrorExample
        try {
            NoClassDefFoundErrorExample.main(new String[]{});
        } catch (Error e) {
            // Aseguramos que el mensaje de error esté presente en la salida
            String output = outContent.toString().trim();
            assertTrue(output.contains("Error: No se pudo encontrar la clase:"),
                    "El mensaje de error no fue impreso correctamente.");
        }
    }
}