package Ejercicios.e6;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class EjemploTryCatchFinallyTest {

    @Test
    void main() {
        // Simular entradas para la ejecución
        String simulatedInput = "10\n0\n"; // Primer número 10, segundo número 0 para generar excepción
        ByteArrayInputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);

        // Capturar la salida
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Ejecutar el metodo main
        EjemploTryCatchFinally.main(new String[]{});

        // Recuperar la salida capturada
        String output = outputStream.toString();

        // Verificar que la salida contiene los mensajes esperados
        assertTrue(output.contains("Ingresa un número entero:"));
        assertTrue(output.contains("Ingresa otro número entero para dividir:"));
        assertTrue(output.contains("Error: División por cero no permitida."));
        assertTrue(output.contains("Bloque finally: limpiando recursos..."));
        assertTrue(output.contains("El programa continúa después del bloque try-catch-finally."));
    }
}