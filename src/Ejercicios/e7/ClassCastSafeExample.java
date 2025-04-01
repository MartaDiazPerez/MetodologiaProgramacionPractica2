package Ejercicios.e7;

/**
 * Clase que demuestra el manejo seguro de ClassCastException en Java.
 * Intenta convertir un objeto genérico en un Integer y maneja posibles excepciones.
 */
public class ClassCastSafeExample {
    public static void main(String[] args) {
        testCasting(new Object()); // Caso que lanza ClassCastException
        testCasting(42); // Caso exitoso con Integer válido
    }

    /**
     * Metodo que intenta convertir un objeto en un Integer.
     * Si la conversión es exitosa, imprime el número.
     * Si ocurre ClassCastException, maneja la excepción y muestra un mensaje de error.
     *
     * @param o El objeto a convertir.
     */
    public static void testCasting(Object o) {
        try {
            Integer i = (Integer) o;
            System.out.println("Convertido a Integer: " + i);
        } catch (ClassCastException e) {
            System.out.println("Error: No se puede convertir a Integer. " + e.getMessage());
        }
    }
}