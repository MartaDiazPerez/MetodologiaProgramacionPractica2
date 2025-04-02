package Ejercicios.e6;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class TryCatchFinallyTest {

    @Test
    void main_FileNotFound() {
        // Redirigir la salida estándar para capturar el output del programa
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Ejecutar el método main
        TryCatchFinally.main(new String[]{});

        // Restaurar la salida estándar
        System.setOut(System.out);

        // Verificar la salida esperada
        String output = outContent.toString();
        assertTrue(output.contains("Start of the main logic"));
        assertTrue(output.contains("Try opening a file ..."));
        assertTrue(output.contains("File Not Found caught ..."));
        assertTrue(output.contains("finally-block runs regardless of the state of exception"));
        assertTrue(output.contains("After try-catch-finally, life goes on..."));
    }
}