package Ejercicios.e2;

/**
 * Clase Ejercicio2
 *
 * Esta clase demuestra el manejo de excepciones en Java a través de una serie de métodos encadenados.
 * La ejecución comienza en el metodo main(), que invoca methodA(), el cual a su vez llama a methodB(),
 * y este finalmente ejecuta methodC().
 *
 * En methodC() se produce una excepción ArithmeticException debido a una división por cero,
 * la cual se propaga hacia arriba hasta ser capturada en main().
 */
public class Ejercicio2 {

    /**
     * Metodo principal que inicia la ejecución del programa.
     * Captura la excepción ArithmeticException generada en methodC().
     *
     * @param args Argumentos de la línea de comandos (no utilizados en este programa).
     */
    public static void main(String[] args) {
        System.out.println("Enter main()");
        try {
            methodA(); // Llama a methodA(), lo que desencadena la cadena de llamadas
        } catch (ArithmeticException e) {
            System.out.println("Exception caught in main(): " + e);
        }
        System.out.println("Exit main()");
    }

    /**
     * Metodo methodA().
     * Llama a methodB(), lo que lleva eventualmente a la ejecución de methodC().
     * La excepción generada en methodC() no es manejada aquí y se propaga hacia main().
     */
    public static void methodA() {
        System.out.println("Enter methodA()");
        methodB(); // Llama a methodB(), que a su vez llamará a methodC()
        System.out.println("Exit methodA()"); // Esta línea no se ejecuta debido a la excepción en methodC()
    }

    /**
     * Metodo methodB().
     * Llama a methodC(), donde ocurre la excepción ArithmeticException.
     * Al no manejar la excepción, esta se propaga hacia methodA().
     */
    public static void methodB() {
        System.out.println("Enter methodB()");
        methodC(); // Llama a methodC(), donde ocurre la excepción
        System.out.println("Exit methodB()"); // Nunca se ejecuta debido a la excepción en methodC()
    }

    /**
     * Metodo methodC().
     * Aquí ocurre la excepción ArithmeticException debido a la división por cero.
     * Esta excepción se propaga hacia methodB() y, posteriormente, hasta main().
     */
    public static void methodC() {
        System.out.println("Enter methodC()");
        System.out.println(1 / 0); // Provoca una ArithmeticException (división por cero)
        System.out.println("Exit methodC()"); // Nunca se ejecuta debido a la excepción
    }
}