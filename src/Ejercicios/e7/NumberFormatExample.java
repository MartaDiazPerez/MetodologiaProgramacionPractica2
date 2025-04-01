package Ejercicios.e7;

/**
 * Ejemplo que demuestra la ocurrencia de una excepción NumberFormatException.
 * Se intenta convertir una cadena no numérica en un número entero, lo que lanza la excepción.
 */
public class NumberFormatExample {

    /**
     * Metodo principal que ejecuta el ejemplo.
     * Intenta convertir una cadena no numérica a un número entero y captura la excepción NumberFormatException.
     *
     * @param args Argumentos de la línea de comandos (no se utilizan en este ejemplo).
     */
    public static void main(String[] args) {
        // Se crea una cadena que no representa un número válido.
        String str = "abc";

        try {
            // Se intenta convertir la cadena "abc" a un número entero.
            // Esto provoca una NumberFormatException porque "abc" no es un número válido.
            int num = Integer.parseInt(str);
            System.out.println("Número convertido: " + num);
        } catch (NumberFormatException e) {
            // Captura la excepción NumberFormatException y muestra un mensaje de error en la consola.
            System.out.println("Error: la cadena no es un número válido.");
        }
    }
}