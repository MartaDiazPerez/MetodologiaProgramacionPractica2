package Ejercicios.e8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyMagicExceptionTest {

    @Test
    void getSeveridad() {
        /**Se crea una instancia de MyMagicException con un mensaje, un código de error y un rigor*/
        MyMagicException m1 = new MyMagicException("Error crítico", 800, "Alta");
        /**Se comprueba que es el rigor correcto*/
        assertEquals("Alta", m1.getSeveridad(), "Severidad debe ser 'Alta'");
    }

    @Test
    void testToString() {
        /** Se crea una instancia de MyMagicException con un mensaje, un código de error y un rigor*/
        MyMagicException m1 = new MyMagicException("Error crítico", 800, "Alta");
        /**Se comprueba si el toString() devuelve el formato correcto*/
        assertEquals("Error 800 (Alta): Error crítico", m1.toString(),
                "El formato del toString() debe ser 'Error 800 (Alta): Error crítico'");
    }
}