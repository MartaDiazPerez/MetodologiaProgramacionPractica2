package Ejercicios.e2;

import Ejercicios.e2.Ejercicio2;
import org.junit.jupiter.api.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias para la clase Ejercicio2.
 * Se prueba cada método individualmente y el flujo de excepciones.
 */
class Ejercicio2Test {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void redirectOutput() {
        System.setOut(new PrintStream(outContent));  // Redirige la salida a un flujo en memoria para comprobar la salida
    }

    @AfterEach
    void restoreOutput() {
        System.setOut(originalOut);  // Restaura la salida original después de cada test
    }

    /**
     * Test del método main().
     * Se espera que capture la excepción y se impriman todos los mensajes correctamente.
     * Esto cubre:
     * - Entrada y salida del método main()
     * - Flujo normal del try
     * - Captura del catch (ArithmeticException)
     */
    @Test
    void main() {
        Ejercicio2.main(new String[]{});

        String output = outContent.toString();

        assertAll(
                () -> assertTrue(output.contains("Enter main()")),  // Verifica que 'Enter main()' se imprime
                () -> assertTrue(output.contains("Enter methodA()")),  // Verifica que 'Enter methodA()' se imprime
                () -> assertTrue(output.contains("Enter methodB()")),  // Verifica que 'Enter methodB()' se imprime
                () -> assertTrue(output.contains("Enter methodC()")),  // Verifica que 'Enter methodC()' se imprime
                () -> assertTrue(output.contains("Exception caught in main(): java.lang.ArithmeticException: / by zero")),  // Verifica la captura de la excepción en main()
                () -> assertTrue(output.contains("Exit main()"))  // Verifica que 'Exit main()' se imprime
        );
    }

    /**
     * Test directo del método methodA().
     * Se espera una ArithmeticException debido a que methodC() hace una división por cero.
     */
    @Test
    void methodA() {
        ArithmeticException exception = assertThrows(ArithmeticException.class, Ejercicio2::methodA);
        assertEquals("/ by zero", exception.getMessage());  // Verifica que la excepción es la correcta

        String output = outContent.toString();
        assertAll(
                () -> assertTrue(output.contains("Enter methodA()")),  // Verifica que 'Enter methodA()' se imprime
                () -> assertTrue(output.contains("Enter methodB()")),  // Verifica que 'Enter methodB()' se imprime
                () -> assertTrue(output.contains("Enter methodC()"))   // Verifica que 'Enter methodC()' se imprime
        );
    }

    /**
     * Test directo del método methodB().
     * Se espera una ArithmeticException al llegar a methodC().
     */
    @Test
    void methodB() {
        ArithmeticException exception = assertThrows(ArithmeticException.class, Ejercicio2::methodB);
        assertEquals("/ by zero", exception.getMessage());  // Verifica que la excepción es la correcta

        String output = outContent.toString();
        assertAll(
                () -> assertTrue(output.contains("Enter methodB()")),  // Verifica que 'Enter methodB()' se imprime
                () -> assertTrue(output.contains("Enter methodC()"))   // Verifica que 'Enter methodC()' se imprime
        );
    }

    /**
     * Test directo del método methodC().
     * Se espera una ArithmeticException por división entre cero.
     */
    @Test
    void methodC() {
        ArithmeticException exception = assertThrows(ArithmeticException.class, Ejercicio2::methodC);
        assertEquals("/ by zero", exception.getMessage());  // Verifica que la excepción es la correcta

        String output = outContent.toString();
        assertTrue(output.contains("Enter methodC()"));  // Verifica que 'Enter methodC()' se imprime
    }
}