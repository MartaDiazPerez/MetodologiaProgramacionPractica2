package Ejercicios.e8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyExcepcionTest {

    @Test
    void getMensaje() {
        /**Se crea una instancia de MyMagicException con un mensaje y un código de error */
        MyExcepcion ex = new MyExcepcion("Error concreto", 105);
        /**Se comprueba que el mensaje es el correcto*/
        assertEquals("Error concreto", ex.getMensaje(), "El mensaje debe ser 'Error concreto'");
    }

    @Test
    void getCodigoError() {
        /**Se crea una instancia de MyMagicException con un mensaje y un código de error */
        MyExcepcion ex = new MyExcepcion("Error concreto", 105);
        /**Se comprueba que el codigo del error es el correcto*/
        assertEquals(105, ex.getCodigoError(), "El codigo del error debe ser 105");
    }

    @Test
    void testToString() {
        /**Se crea una instancia de MyMagicException con un mensaje y un código de error*/
        MyExcepcion ex = new MyExcepcion("Error concreto", 105);
        /**Comprueba que el metodo toString() devuelva el formato indicado */
        assertEquals("Error 105: Error concreto", ex.toString(), "El formato del toString() debe ser 'Error 105: Error concreto'");
    }

    @Test
    void testEquals() {
        /**Se crean tres instancias de MyMagicException con un mensaje y un código de error*/
        MyExcepcion ex1 = new MyExcepcion("Error concreto", 105);
        MyExcepcion ex2 = new MyExcepcion("Error concreto", 105);
        MyExcepcion ex3 = new MyExcepcion("Error distinto", 98);
        /**Comprueba si los codigos son iguales y como lo son, devuelve verdadero*/
        assertEquals(ex1.equals(ex2), true, "Las excepciones son iguales");
        /**Comprueba si los codigos son iguales y como no lo son, devuelve falso*/
        assertEquals(ex1.equals(ex3), false, "Las excepciones diferentes");
    }
}