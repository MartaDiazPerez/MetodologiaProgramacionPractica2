package Ejercicios.e7;

/**
 * Ejemplo que demuestra la ocurrencia de una excepción NullPointerException.
 * Se crea un arreglo de cadenas y se intenta acceder a un elemento que es null, lo que genera una excepción.
 */
public class NullPointerExample {

    /**
     * Metodo principal que ejecuta el ejemplo.
     * Crea un arreglo de cadenas, intenta acceder a un elemento nulo y captura la excepción NullPointerException.
     *
     * @param args Argumentos de la línea de comandos (no se utilizan en este ejemplo).
     */
    public static void main(String[] args) {
        // Se crea un arreglo de cadenas con 3 elementos, todos inicialmente nulos.
        String[] strs = new String[3];

        try {
            // Se intenta obtener la longitud del primer elemento, que es null.
            // Esto provoca un NullPointerException.
            System.out.println(strs[0].length()); // Lanza NullPointerException
        } catch (NullPointerException e) {
            // Captura la excepción y muestra un mensaje de error en la consola.
            System.out.println("Error: se intentó usar una referencia nula.");
        }
    }
}