package Ejercicios.e6;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class MethodCallStackDemoTest {

    @Test
    void main() {
        // Redirigir la salida estándar para capturar el output del programa
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Ejecutar el método main
        MethodCallStackDemo.main(new String[]{});

        // Restaurar la salida estándar
        System.setOut(System.out);

        // Verificar la salida esperada
        String output = outContent.toString();
        assertTrue(output.contains("Enter main()"));
        assertTrue(output.contains("Enter methodA()"));
        assertTrue(output.contains("Caught an ArithmeticException: / by zero"));
        assertTrue(output.contains("finally in methodA()"));
        assertTrue(output.contains("Exit methodA()"));
        assertTrue(output.contains("Exit main()"));
    }

    @Test
    void methodA() {
        // Redirigir la salida estándar para capturar el output del programa
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Ejecutar el método methodA
        MethodCallStackDemo.methodA();

        // Restaurar la salida estándar
        System.setOut(System.out);

        // Verificar la salida esperada
        String output = outContent.toString();
        assertTrue(output.contains("Enter methodA()"));
        assertTrue(output.contains("Caught an ArithmeticException: / by zero"));
        assertTrue(output.contains("finally in methodA()"));
        assertTrue(output.contains("Exit methodA()"));
    }
}