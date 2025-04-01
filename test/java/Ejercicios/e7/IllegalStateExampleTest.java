package Ejercicios.e7;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias para la clase IllegalStateExample.
 * Se verifican los casos en los que la lámpara se enciende y apaga correctamente,
 * así como los casos en los que se lanza una excepción al intentar cambiar de estado incorrectamente.
 */
class IllegalStateExampleTest {

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
     * Prueba del metodo encender().
     * Verifica que la lámpara se encienda correctamente y que la salida sea la esperada.
     */
    @Test
    void encender_correctamente() {
        IllegalStateExample lampara = new IllegalStateExample();
        lampara.encender();  // La lámpara se enciende correctamente
        // Verifica que la salida contiene el mensaje esperado
        assertTrue(outContent.toString().contains("La lámpara está encendida."));
    }

    /**
     * Prueba que verifica la excepción IllegalStateException al intentar encender
     * una lámpara que ya está encendida.
     */
    @Test
    void encender_dos_veces() {
        IllegalStateExample lampara = new IllegalStateExample();
        lampara.encender();  // La lámpara se enciende correctamente
        // Verifica que al intentar encenderla de nuevo, se lanza una excepción
        IllegalStateException exception = assertThrows(IllegalStateException.class, lampara::encender);
        assertEquals("La lámpara ya está encendida.", exception.getMessage());  // Verifica el mensaje de la excepción
    }

    /**
     * Prueba del metodo apagar().
     * Verifica que la lámpara se apague correctamente después de haber sido encendida.
     */
    @Test
    void apagar_correctamente() {
        IllegalStateExample lampara = new IllegalStateExample();
        lampara.encender();  // Enciende la lámpara
        lampara.apagar();    // Apaga la lámpara
        // Verifica que la salida contiene el mensaje esperado de apagado
        assertTrue(outContent.toString().contains("La lámpara está apagada."));
    }

    /**
     * Prueba que verifica la excepción IllegalStateException al intentar apagar
     * una lámpara que ya está apagada.
     */
    @Test
    void apagar_dos_veces() {
        IllegalStateExample lampara = new IllegalStateExample();
        // Verifica que al intentar apagar la lámpara antes de encenderla, se lanza una excepción
        IllegalStateException exception = assertThrows(IllegalStateException.class, lampara::apagar);
        assertEquals("La lámpara ya está apagada.", exception.getMessage());  // Verifica el mensaje de la excepción
    }

    /**
     * Prueba del metodo main().
     * Verifica que el flujo del programa maneja correctamente los intentos de encender
     * la lámpara dos veces y captura la excepción.
     */
    @Test
    void main() {
        IllegalStateExample.main(new String[]{});  // Llama al metodo main()

        String output = outContent.toString().trim();  // Obtiene la salida del flujo
        // Verifica que la lámpara se enciende correctamente y que se lanza la excepción
        assertTrue(output.contains("La lámpara está encendida."));
        assertTrue(output.contains("Error: La lámpara ya está encendida."));
    }
}